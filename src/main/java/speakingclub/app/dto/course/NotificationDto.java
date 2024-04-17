package speakingclub.app.dto.course;

import lombok.Data;
import org.mapstruct.Named;
import speakingclub.app.model.Module;
import speakingclub.app.model.Notification;
import speakingclub.app.model.Profile;

import java.util.HashSet;
import java.util.Set;

@Data
public class NotificationDto {
    private String note;
//    private Profile profile;

}
