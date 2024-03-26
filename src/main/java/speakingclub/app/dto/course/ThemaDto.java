package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import lombok.Data;

@Data
public class ThemaDto {
    @NotBlank
    private String name;
    private Set<LessonDto> lessons;
}
