package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.Data;

@Data
public class ThemaDto {
    @NotEmpty
    private String name;
    private Set<LessonDto> lessons;
}
