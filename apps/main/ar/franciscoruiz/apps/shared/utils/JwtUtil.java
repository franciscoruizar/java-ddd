package ar.franciscoruiz.apps.shared.utils;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.Utils;
import ar.franciscoruiz.shared.domain.applications.Application;
import ar.franciscoruiz.shared.domain.config.Parameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

@Service
public final class JwtUtil {
    private final String key;

    public JwtUtil(Parameter parameter) throws ParameterNotExist {
        this.key = parameter.get("JWT_KEY");
    }

    public String generateToken(UserResponse user, Application application) {
        return Jwts.builder()
            .setClaims(parseClaims(user, application))
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, key).compact();
    }

    public boolean isTokenExpired(String token) {
        return claims(token).getExpiration().before(new Date());
    }

    public boolean validate(String token, UserResponse user) {
        return !isTokenExpired(token) && user.username().equals(extractUsername(token)) && user.isActive();
    }

    private Claims claims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return (String) claims(token).get("username");
    }

    public String extractApplication(String token) {
        return (String) claims(token).get("application");
    }

    private HashMap<String, Object> parseClaims(UserResponse user, Application application) {
        String json   = Utils.jsonEncode(user);
        var    result = Utils.jsonDecode(json, HashMap.class);
        result.put("application", application.value());
        return result;
    }
}
