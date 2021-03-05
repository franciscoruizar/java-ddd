package ar.franciscoruiz.shared.infrastructure.spring;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public final class JwtUtil {
    private static final String KEY = "w0dx";

    public String generateToken(AuthUser user) {
        return Jwts.builder().setSubject(user.username().value()).setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean validateToken(String token, AuthUser user) {
        return user.username().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public AuthUsername extractUsername(String token) {
        return new AuthUsername(getClaims(token).getSubject());
    }

    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
