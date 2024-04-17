package speakingclub.app.dto.course;

import lombok.Data;
import speakingclub.app.model.Profile;

@Data
public class NotificationDto {
    private String note;
    private Profile profile;
}
