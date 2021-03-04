package ar.franciscoruiz.accounts.roles.domain;

import java.util.Random;

public final class RoleMother {
    public static Role random() {
        var values = Role.values();
        var item   = new Random().nextInt(Role.values().length - 1);
        return values[item];
    }
}
