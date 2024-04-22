package speakingclub.app.service;

import java.util.List;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.HomeworkDto;
import speakingclub.app.dto.course.SkillDto;
import speakingclub.app.dto.user.UserResponseDto;

public interface UserService {
    String addCourseToStudent(Long userId, Long courseId);

    List<CourseDto> getCoursesByUserId(Long id);

    CourseDto getCourseByIdAndUserId(Long userId, Long courseId);

    List<SkillDto> getSkillsByUserId(Long id);

    List<HomeworkDto> getHomeworksByUserId(Long id);

    UserResponseDto getUserById(Long id);
}
