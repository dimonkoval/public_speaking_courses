package speakingclub.app.dto.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.model.User;

@Data
public class ProfileDto {
    @NotNull
    @Valid
    private User user;
    private String photo;
    private Set<NotificationDto> notifications = new HashSet<>();
}
