package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import speakingclub.app.dto.user.ProfileDto;
import speakingclub.app.service.ProfileService;

@Tag(name = "Profile panel manager", description = "Endpoints for profile panel")
@RequiredArgsConstructor
@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;
    @GetMapping("/{id}")
    @Operation(summary = "get profile by user ID")
    public ProfileDto getProfileByUserId(@PathVariable Long id) {
        return profileService.getProfileByUserID(id);
    }

    @PostMapping("/add")
    @Operation(summary = "create profile to user")
    public ProfileDto createProfileToUser(@RequestBody @Valid ProfileDto profileDto) {
            return profileService.createProfileToUser(profileDto);
    }
}
