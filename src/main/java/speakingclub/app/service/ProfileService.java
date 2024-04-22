package speakingclub.app.service;

import java.util.List;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.dto.user.ProfileDto;

public interface ProfileService {
    ProfileDto getProfileByUserID(Long userId);

    ProfileDto createProfileToUser(ProfileDto profileDto);

    List<NotificationDto> getNotificationsByProfileId(Long profileId);

    List<CourseDto> getCoursesByProfileId(Long profileId);
}
