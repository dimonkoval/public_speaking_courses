package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.CourseWithCoachingDto;
import speakingclub.app.dto.course.CourseWithWebinarDto;
import speakingclub.app.service.CourseService;

@Tag(name = "Admin panel manager", description = "Endpoints for admin panel")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminPanelController {
    private final CourseService courseService;

    @PostMapping("/courses/add")
    @Operation(summary = "Save flexible course",
            description = "Saves the course along with the entities: module, "
                    + "theme, lesson, and homework")
    public CourseDto createCourse(@RequestBody @Valid CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }

    @PostMapping("/courses/addWithWebinar")
    @Operation(summary = "Save course with webinar",
            description = "Saves the course along with the entities: module, "
                    + "webinar, theme, lesson, and homework")
    public CourseWithWebinarDto createCourseWithWebinar(
            @RequestBody @Valid CourseWithWebinarDto courseWithWebinarDto) {
        return courseService.saveCourseWithWebinar(courseWithWebinarDto);
    }

    @PostMapping("/courses/addWithCoaching")
    @Operation(summary = "Save course with coaching",
            description = "Saves the course without other entities")
    public CourseWithCoachingDto createCourseWithCoaching(
            @RequestBody @Valid CourseWithCoachingDto courseWithCoachingDto) {
        return courseService.saveCourseWithCoaching(courseWithCoachingDto);
    }
}
