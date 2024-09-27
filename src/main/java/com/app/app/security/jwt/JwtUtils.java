package com.app.app.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;
import static com.app.app.consts.GeneralConst.SECRET_KEY;

@Component
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtUtils {
    @Value("${jwt.secret.key}")
    String secretkey;

    @Value("${jwt.time.expiration}")
    String timeExpiration;

    public String generateAccessToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis())) // Fecha de creación del token
                .expiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration))) // Fecha expiración del token
                .signWith(SECRET_KEY)
                .compact();
    }

    public boolean isTokenValid(String token){
        try{
            Claims claims = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload();
            return true;
        }catch (Exception e){
            log.error("El token no es valido: " + e.getMessage() );
            return false;
        }
    }

    // Obtener el usuario
    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    // función para extraer ciertos datos del token mediante la interface funcional Function
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = getAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // Obtener los datos que trae el token
    public Claims getAllClaims(String token){
        return Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload();
    }

}
