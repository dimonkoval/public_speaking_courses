package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
public class CourseWithWebinarDto {
    @NotEmpty
    private String name;
    @PositiveOrZero
    private BigDecimal price;
    private String imageUrl;
    @NotEmpty
    private String courseType;
    @NotEmpty
    private String courseDirection;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<SkillDto> skills;
    private Set<ModuleWithWebinarDto> modules;
}
