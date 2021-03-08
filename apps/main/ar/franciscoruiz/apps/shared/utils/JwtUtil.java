package ar.franciscoruiz.apps.shared.utils;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.Utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

@Service
public final class JwtUtil {
    private static final String KEY = "w0dx";

    public String generateToken(UserResponse user) {
        return Jwts.builder()
            .setClaims(parseClaims(user))
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean isTokenExpired(String token) {
        return claims(token).getExpiration().before(new Date());
    }

    public boolean validate(String token, UserResponse user) {
        return !isTokenExpired(token) && user.username().equals(extractUsername(token)) && user.isActive();
    }

    private Claims claims(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return (String) claims(token).get("username");
    }

    private HashMap<String, Object> parseClaims(UserResponse user) {
        String json = Utils.jsonEncode(user);
        return Utils.jsonDecode(json, HashMap.class);
    }
}
