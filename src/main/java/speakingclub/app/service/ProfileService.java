package speakingclub.app.service;

import speakingclub.app.dto.user.ProfileDto;

public interface ProfileService {
    ProfileDto getProfileByUserID(Long userId);

    ProfileDto createProfileToUser(ProfileDto profileDto);
}
