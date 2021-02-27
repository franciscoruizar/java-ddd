package ar.franciscoruiz.shared.domain;

public final class DoubleMother {
    public static Double random() {
        return Double.parseDouble(MotherCreator.random().commerce().price());
    }
}
