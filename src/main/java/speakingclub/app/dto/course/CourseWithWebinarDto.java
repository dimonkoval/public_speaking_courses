package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
public class CourseWithWebinarDto {
    @NotBlank
    private String name;
    @PositiveOrZero
    private BigDecimal price;
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String courseType;
    @NotBlank
    private String courseDirection;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<SkillDto> skills;
    private Set<ModuleWithWebinarDto> modules;
}
