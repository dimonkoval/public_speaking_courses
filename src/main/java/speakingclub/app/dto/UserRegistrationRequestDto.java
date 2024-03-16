package speakingclub.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import speakingclub.app.validation.FieldMatch;

@Data
@FieldMatch(password = "password", repeatPassword = "repeatPassword")
public class UserRegistrationRequestDto {
    @Email
    @NotBlank
    private String email;
    @Size(min = 6, max = 255)
    private String password;
    @Size(min = 6, max = 255)
    private String repeatPassword;
    @NotBlank(message = "First name can't be empty.")
    @Size(max = 255, message = "First name length must be less then 255 characters.")
    private String firstName;
    @NotBlank(message = "Last name can't be empty.")
    @Size(max = 255, message = "Last name length must be less then 255 characters.")
    private String lastName;
}
