package speakingclub.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speakingclub.app.model.Course;
import speakingclub.app.model.Student;
import speakingclub.app.repository.course.CourseRepository;
import speakingclub.app.repository.student.StudentRepository;
import speakingclub.app.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public void addCourseToStudent(Long studentId, Long courseId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()){
            Student student = new Student();
            student.setUser();
        }
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();
            student.getCourses().add(course);
            studentRepository.save(student);
        } else {
            // Обробка випадку, коли студент або курс не знайдено
            // Можна кинути виключення або виконати інші дії за потреби
        }
    }

    @Override
    public List<Course> getCoursesByStudentId(Long Id) {
        return studentRepository.getCoursesByStudentId(Id);
    }


}
