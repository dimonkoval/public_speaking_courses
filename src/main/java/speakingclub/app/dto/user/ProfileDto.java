package speakingclub.app.dto.user;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.model.Notification;
import speakingclub.app.model.User;

import java.util.HashSet;
import java.util.Set;

@Data
public class ProfileDto {
    @NotNull
    @Valid
    private User user;
    private String photo;
    private Set<NotificationDto> notifications = new HashSet<>();
}
