package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.user.UserResponseDto;
import speakingclub.app.exception.CourseNotFoundException;
import speakingclub.app.exception.UserNotFoundException;
import speakingclub.app.mapper.course.CourseMapper;
import speakingclub.app.mapper.user.UserMapper;
import speakingclub.app.model.Course;
import speakingclub.app.model.Homework;
import speakingclub.app.model.Skill;
import speakingclub.app.model.User;
import speakingclub.app.repository.course.CourseRepository;
import speakingclub.app.repository.user.UserRepository;
import speakingclub.app.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseMapper courseMapper;
    private final UserMapper userMapper;

    @Override
    public String addCourseToStudent(Long userId, Long courseId) {
        User user = userRepository.getUserById(userId).orElseThrow(() -> new UserNotFoundException("User by ID " + userId + " not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course by ID " + courseId + " not found"));
        Optional<Course> optionalCourse = userRepository.getCourseByIdAndUserId(user.getId(), courseId);
        if (optionalCourse.isEmpty()) {
            user.getCourses().add(course);
            userRepository.save(user);
            return "Course by ID " + courseId + " added successfully to student by " + userId;
        }else {
            return "Student by ID " + userId + " already has course by ID " + courseId;
        }
    }

    @Override
    public List<Course> getCoursesByUserId(Long Id) {
        return userRepository.getCoursesByStudentId(Id);
    }

    @Override
    public CourseDto getCourseByIdAndUserId(Long userId, Long courseId) {
        User user = userRepository.getUserById(userId).orElseThrow(() -> new UserNotFoundException("User by ID " + userId + " not found"));
        Course course = userRepository.getCourseByIdAndUserId(user.getId(), courseId).orElseThrow(() -> new CourseNotFoundException("Course by ID " + courseId + " not found"));
        return courseMapper.toDto(course);
    }

    @Override
    public List<Skill> getSkillsByUserId(Long id) {
        return userRepository.getSkillsByUserId(id);
    }

    @Override
    public List<Homework> getHomeworksByUserId(Long id) {
        return userRepository.getHomeworksByUserId(id);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.getUserById(id).orElseThrow(() -> new UserNotFoundException("User by ID " + id + " not found"));
        return userMapper.toDto(user);
    }
}
