package ar.franciscoruiz.apps.accounts.backend.controllers.auth.dto;

public final class AuthRequest {
    private String username;
    private String password;

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String password() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
