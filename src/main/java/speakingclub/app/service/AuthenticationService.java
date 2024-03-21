package speakingclub.app.service;

import org.springframework.stereotype.Service;
import speakingclub.app.dto.UserLoginRequestDto;
import speakingclub.app.dto.UserLoginResponseDto;

@Service
public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto userLoginRequestDto);
}
