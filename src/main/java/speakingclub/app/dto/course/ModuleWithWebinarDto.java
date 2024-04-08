package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import lombok.Data;

@Data
public class ModuleWithWebinarDto {
    @NotBlank
    private String name;
    @NotBlank
    private String meditationName;
    @NotBlank
    private String linkToMeditation;
    private Set<ThemaDto> themas;
    private WebinarDto webinar;
}
