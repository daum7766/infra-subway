package nextstep.subway.auth.ui;

import org.slf4j.LoggerFactory;
import nextstep.subway.auth.application.AuthService;
import nextstep.subway.auth.dto.TokenRequest;
import nextstep.subway.auth.dto.TokenResponse;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;
    private final Logger fileLogger = LoggerFactory.getLogger("file");

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login/token")
    public ResponseEntity<TokenResponse> login(@RequestBody TokenRequest request) {
        fileLogger.info("로그인 시도 : {}", request.getEmail());
        TokenResponse token = authService.login(request);
        fileLogger.info("로그인 성공 : {}", request.getEmail());
        return ResponseEntity.ok().body(token);
    }
}
