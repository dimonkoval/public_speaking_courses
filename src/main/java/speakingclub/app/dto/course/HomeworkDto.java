package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HomeworkDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
