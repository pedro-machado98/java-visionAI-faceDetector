package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.domain.user.DataAutenticationLoginDTO;
import br.com.faeterj.facehumor.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity getLogin(@RequestBody @Valid DataAutenticationLoginDTO data) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication  authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
