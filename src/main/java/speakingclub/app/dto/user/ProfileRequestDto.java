package speakingclub.app.dto.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import speakingclub.app.model.Notification;
import speakingclub.app.model.User;

@Data
public class ProfileRequestDto {
    @NotNull
    @Valid
    private User user;
    private String photo;
    private Set<Notification> notifications = new HashSet<>();
}
