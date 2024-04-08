package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import lombok.Data;

@Data
public class ModuleDto {
    @NotBlank
    private String name;
    @NotBlank
    private String meditationName;
    private String linkToMeditation;
    private Set<ThemaDto> themas;
}
