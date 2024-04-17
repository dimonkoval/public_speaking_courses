package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.exception.UserNotFoundException;
import speakingclub.app.mapper.user.ProfileMapper;
import speakingclub.app.model.Profile;
import speakingclub.app.model.User;
import speakingclub.app.repository.user.ProfileRepository;
import speakingclub.app.repository.user.UserRepository;
import speakingclub.app.service.NotificationService;
import speakingclub.app.service.ProfileService;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;
    private final NotificationService notificationService;
    @Override
    public ProfileDto getProfileByUserID(Long userId) {
        return profileRepository.getProfileByUserID(userId);
    }

    @Override
    public ProfileDto createProfileToUser(ProfileDto profileDto) {
        User user = userRepository.getUserByIdAllElements(profileDto.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        Profile profile = profileMapper.toModel(profileDto);
        profile.setUser(user);
        Profile savedProfile = profileRepository.save(profile);

        notificationService.saveNotifications(profileDto.getNotifications(), savedProfile);

        return profileMapper.toDto(savedProfile);
    }
}
