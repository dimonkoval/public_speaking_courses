package speakingclub.app.dto.course;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    @NotEmpty
    private String name;
    @PositiveOrZero
    private BigDecimal price;
    private String imageUrl;
    @NotEmpty
    private String courseType;
    @NotEmpty
    private String courseDirection;
    private Set<SkillDto> skills;
    private Set<ModuleDto> modules;
}
