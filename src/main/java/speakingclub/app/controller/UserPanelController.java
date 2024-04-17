package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.HomeworkDto;
import speakingclub.app.dto.course.SkillDto;
import speakingclub.app.dto.user.UserResponseDto;
import speakingclub.app.mapper.course.CourseMapper;
import speakingclub.app.mapper.course.HomeworkMapper;
import speakingclub.app.mapper.course.SkillMapper;
import speakingclub.app.repository.course.CourseRepository;
import speakingclub.app.repository.user.UserRepository;
import speakingclub.app.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "User panel manager", description = "Endpoints for user panel")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserPanelController {
    private final CourseMapper courseMapper;
    private final SkillMapper skillMapper;
    private final HomeworkMapper homeworkMapper;
    private final UserService userService;

    @GetMapping("/courses/{id}")
    @Operation(summary = "get all courses by user ID")
    public List<CourseDto> getCoursesByUserId(@PathVariable Long id) {
        return userService.getCoursesByUserId(id)
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "get user by ID")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/skills/{id}")
    @Operation(summary = "get all skills by user ID")
    public List<SkillDto> getSkillsByUserId(@PathVariable Long id) {
        return userService.getSkillsByUserId(id)
                .stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/homeworks/{id}")
    @Operation(summary = "get all homeworks by user ID")
    public List<HomeworkDto> getHomeworksByUserId(@PathVariable Long id) {
        return userService.getHomeworksByUserId(id)
                .stream()
                .map(homeworkMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/course")
    @Operation(summary = "Check if the user has a certain course")
    public CourseDto getCourseByIdAndUserId(@RequestParam Long userId, @RequestParam Long courseId) {
        return userService.getCourseByIdAndUserId(userId, courseId);
    }

    @PostMapping("/courses/add")
    @Operation(summary = "Add the course to student")
    public String addCourseToStudent(@RequestParam Long userId, @RequestParam Long courseId) {
        try {
            return userService.addCourseToStudent(userId, courseId);
        } catch (Exception e) {
            return "Error adding course to student: " + e.getMessage();
        }
    }
}
