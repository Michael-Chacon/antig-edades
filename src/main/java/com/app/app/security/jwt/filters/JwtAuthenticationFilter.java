package com.app.app.security.jwt.filters;

import com.app.app.security.jwt.JwtUtils;
import com.app.app.user.persistence.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

//    private final AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }

    private JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Users user = null;
        String username = null;
        String password = null;

        try{
            user = new ObjectMapper().readValue(request.getInputStream(), Users.class);
            username = user.getName();
            password = user.getPassword();
        }catch (Exception e){
            log.error("-----------------------------------NO se pueden obtener las credenciales de la solicitud: " + e.getMessage());
            throw new RuntimeException();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        log.info("authenticationToken line 55 =========================== " + authenticationToken);
        return getAuthenticationManager().authenticate(authenticationToken); //objeto que se encarga de administrar la authentication
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal(); // Obtener los detalles del usuario, no sé a cual usuario hacer referencia
        String token = jwtUtils.generateAccessToken(user.getUsername());

        response.addHeader("Authorization", token);
        Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("username", user.getUsername());
        httpResponse.put("message", "Authentication success");
        httpResponse.put("roles", user.getAuthorities());
        httpResponse.put("token", token);

        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.setContentType("application/json");
        response.setStatus(200);
        response.getWriter().flush();
    }
}
