package com.ewsie.allpic.user.security.controller.impl;

import com.ewsie.allpic.user.model.AuthenticatedUserDTO;
import com.ewsie.allpic.user.model.request.UserRegisterRequestBody;
import com.ewsie.allpic.user.security.service.UserLoginService;
import com.ewsie.allpic.user.security.controller.UserAuth;
import com.ewsie.allpic.user.model.CustomUserDetails;
import com.ewsie.allpic.user.model.request.UserLoginRequestBody;
import com.ewsie.allpic.user.security.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserAuthImpl implements UserAuth {

    private final UserLoginService userLoginService;
    private final UserRegisterService userRegisterService;

    @Override
    public ResponseEntity<String> login(@RequestBody UserLoginRequestBody requestBody) {

        String username = requestBody.getUsername();
        String password = requestBody.getPassword();

        return userLoginService.login(username, password);
    }

    @Override
    public ResponseEntity<AuthenticatedUserDTO> authenticate(@AuthenticationPrincipal CustomUserDetails user) {
        String roles = user.getAuthorities().toString().replaceAll("([\\[\\]])", ""); // remove [ and ]

        return ResponseEntity.ok(
                AuthenticatedUserDTO.builder()
                        .username(user.getUsername())
                        .role(roles)
                        .build()
        );
    }

    @Override
    public ResponseEntity<String> register(UserRegisterRequestBody requestBody) {

        String username = requestBody.getUsername();
        String password = requestBody.getPassword();
        String email = requestBody.getEmail();

        return userRegisterService.register(username, password, email);
    }
}
