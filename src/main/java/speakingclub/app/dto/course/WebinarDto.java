package speakingclub.app.dto.course;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebinarDto {
    private String name;
    private LocalDate date;
    private String link;
}
