package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import lombok.Data;

@Data
public class LessonDto {
    @NotBlank
    private String name;
    private String videoLink;
    @NotBlank
    private String theory;
    private Set<HomeworkDto> homeworks;
}
