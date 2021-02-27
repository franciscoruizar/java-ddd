package ar.franciscoruiz.shared.domain;

public final class LatitudeMother {
    public static String random() {
        return MotherCreator.random().address().latitude();
    }
}
