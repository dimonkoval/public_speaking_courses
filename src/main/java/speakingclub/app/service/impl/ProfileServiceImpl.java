package speakingclub.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.exception.ProfileException;
import speakingclub.app.exception.UserNotFoundException;
import speakingclub.app.mapper.course.CourseMapper;
import speakingclub.app.mapper.course.NotificationMapper;
import speakingclub.app.mapper.user.ProfileMapper;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;
import speakingclub.app.repository.user.ProfileRepository;
import speakingclub.app.service.NotificationService;
import speakingclub.app.service.ProfileService;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;
    private final CourseMapper courseMapper;

    @Override
    public ProfileDto getProfileByUserID(Long userId) {
        Profile profile = profileRepository.getProfileByUserID(userId)
                .orElseThrow(() -> new UserNotFoundException("User by ID " + userId + " not found"));
        return profileMapper.toDto(profile);
    }

    @Override
    public ProfileDto createProfileToUser(ProfileDto profileDto) {

        Optional<Profile> optionalProfile = profileRepository.getProfileByUserID(profileDto.getUser().getId());

        if (optionalProfile.isEmpty()) {
            Profile profile = profileMapper.toModel(profileDto);
            Profile savedProfile = profileRepository.save(profile);

            Set<NotificationDto> savedNotificationDtos = notificationService
                    .saveNotifications(profileDto.getNotifications(), savedProfile);
            ProfileDto savedProfileDto = profileMapper.toDto(savedProfile);
            savedProfileDto.setNotifications(savedNotificationDtos);
            return savedProfileDto;
        } else {
            throw new ProfileException("User by ID " + profileDto.getUser().getId() + " already has a profile");
        }
    }

    @Override
    public List<NotificationDto> getNotificationsByProfileId(Long profileId) {
        Set<Notification> notifications = profileRepository.getNotificationsByProfileId(profileId);
        return notifications.stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByProfileId(Long profileId) {
        return profileRepository.getCoursesByProfileId(profileId)
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }
}
