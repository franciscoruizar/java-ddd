package ar.franciscoruiz.shared.domain;

public final class StreetAddressMother {
    public static String random() {
        return MotherCreator.random().address().streetAddress();
    }
}
