package speakingclub.app.dto.user;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserLoginRequestDto(
        @NotBlank
        String email,
        @NotBlank
        @Length(min = 8, max = 20)
        String password
) {
}
