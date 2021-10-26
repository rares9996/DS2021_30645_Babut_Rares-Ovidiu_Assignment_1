package net.dsrl.lab1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class JwtResponse {
    private String jwt;
    private long id;
    private String username;
    private List<String> roles;
    public JwtResponse(String jwt, long id, String username, List<String> roles) {
        this.jwt = jwt;
        this.id = id;
        this.username = username;
        this.roles = roles;
    }
}
