package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.mapper.course.CourseMapper;
import speakingclub.app.service.CourseService;
import speakingclub.app.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Student panel manager", description = "Endpoints for student panel")
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")

public class StudentPanelController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;
    private final StudentService studentService;

    @GetMapping("/courses/{id}")
    @Operation(summary = "get all courses by student ID")
    public List<CourseDto> getCoursesByStudentId(@PathVariable Long id) {
        return studentService.getCoursesByStudentId(id)
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

//    @GetMapping("/courses")
//    @Operation(summary = "get all courses")
//    public List<CourseDto> getAllCourses() {
//        return courseService.getAllCourses()
//                .stream()
//                .map(courseMapper::toDto)
//                .toList();
//    }

    @PostMapping("/courses/add")
    @Operation(summary = "Save the course")
    public String addCourseToStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        try {
            studentService.addCourseToStudent(studentId, courseId);
            return "Course added successfully to student!";
        } catch (Exception e) {
            return "Error adding course to student: " + e.getMessage();
        }
    }
}
