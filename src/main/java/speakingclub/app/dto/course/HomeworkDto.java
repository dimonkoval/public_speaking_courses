package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class HomeworkDto {
    @NotEmpty
    private String name;
    private String description;
}
