package ar.franciscoruiz.shared.domain;

public final class LongitudeMother {
    public static String random() {
        return MotherCreator.random().address().longitude();
    }
}
