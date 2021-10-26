package net.dsrl.lab1.service;

import net.dsrl.lab1.model.dto.JwtResponseDto;
import net.dsrl.lab1.model.dto.LoginDto;
import net.dsrl.lab1.security.jwt.JwtUtils;
import net.dsrl.lab1.security.services.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

  private final AuthenticationManager authenticationManager;

  private final JwtUtils jwtUtils;

  public AuthenticationService(
      AuthenticationManager authenticationManager,
      JwtUtils jwtUtils) {
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
  }

  public JwtResponseDto authenticateUser(LoginDto loginRequest) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles =
        userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

    return new JwtResponseDto(jwt, userDetails.getId(), userDetails.getUsername(), roles);
  }
}
