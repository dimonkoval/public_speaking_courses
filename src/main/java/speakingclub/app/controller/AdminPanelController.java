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
import speakingclub.app.service.CourseService;

@Tag(name = "Admin panel manager", description = "Endpoints for admin panel")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminPanelController {
    private final CourseService courseService;

    @PostMapping("/courses/add")
    @Operation(summary = "Save the course along with the entities module, "
            + "theme, lesson, and homework")
    public CourseDto createCourse(@RequestBody @Valid CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }
}
