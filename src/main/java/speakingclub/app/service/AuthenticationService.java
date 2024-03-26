package speakingclub.app.service;

import org.springframework.stereotype.Service;
import speakingclub.app.dto.user.UserLoginRequestDto;
import speakingclub.app.dto.user.UserLoginResponseDto;

@Service
public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto userLoginRequestDto);
}
