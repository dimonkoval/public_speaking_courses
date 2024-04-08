package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebinarDto {
    @NotBlank
    private String name;
    private LocalDate date;
    private String link;
}
