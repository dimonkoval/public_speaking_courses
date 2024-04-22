package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import speakingclub.app.dto.course.CourseDto;
import speakingclub.app.dto.course.NotificationDto;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.service.ProfileService;

@Tag(name = "Profile panel manager", description = "Endpoints for profile panel")
@RequiredArgsConstructor
@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/{id}")
    @Operation(summary = "get profile by user ID")
    public ProfileDto getProfileByUserId(@PathVariable Long id) {
        return profileService.getProfileByUserID(id);
    }

    @GetMapping("/notifications/{id}")
    @Operation(summary = "get notifications by profile ID")
    public List<NotificationDto> getNotificationsByProfileId(@PathVariable Long id) {
        return profileService.getNotificationsByProfileId(id);
    }

    @GetMapping("/courses/{id}")
    @Operation(summary = "get courses by profile ID")
    public List<CourseDto> getCoursesByProfileId(@PathVariable Long id) {
        return profileService.getCoursesByProfileId(id);
    }

    @PostMapping("/add")
    @Operation(summary = "create profile to user")
    public ProfileDto createProfileToUser(@RequestBody @Valid ProfileDto profileDto) {
        return profileService.createProfileToUser(profileDto);
    }
}
