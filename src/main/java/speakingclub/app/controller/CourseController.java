package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.mapper.course.CourseMapper;
import speakingclub.app.service.CourseService;

import java.util.List;

@Tag(name = "Course manager", description = "Endpoints for courses")
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;
    @GetMapping
    @Operation(summary = "get all courses")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses()
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }
}
