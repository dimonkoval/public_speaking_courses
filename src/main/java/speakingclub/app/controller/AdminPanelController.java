package speakingclub.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Admin panel manager", description = "Endpoints for admin panel")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminPanelController {
}
