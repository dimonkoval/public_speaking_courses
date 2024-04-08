package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.Data;

@Data
public class LessonDto {
    @NotEmpty
    private String name;
    private String videoLink;
    private String theory;
    private Set<HomeworkDto> homeworks;
}
