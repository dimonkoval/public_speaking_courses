package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.model.enums.CourseDirection;
import speakingclub.app.model.enums.CourseType;
import speakingclub.app.service.CourseService;

@Tag(name = "Course manager", description = "Endpoints for courses")
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    @Operation(summary = "get all courses")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/filter")
    @Operation(summary = "get courses with a filter by type and direction")
    public List<CourseDto> getCoursesByTypeAndDirection(@RequestParam(required = false) CourseType type,
                                                        @RequestParam(required = false) CourseDirection direction) {
        return courseService.getCoursesByTypeAndDirection(type, direction);
    }
}
