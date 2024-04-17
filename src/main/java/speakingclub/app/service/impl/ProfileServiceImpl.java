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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;
    private final NotificationService notificationService;
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
            profile.setId(profileDto.getUser().getId());
            Profile savedProfile = profileRepository.save(profile);

            notificationService.saveNotifications(profileDto.getNotifications(), savedProfile);
            return profileMapper.toDto(savedProfile);
        } else {
           throw  new UserNotFoundException("User by ID " + profileDto.getUser().getId() + " already has a profile");
        }
    }
}
