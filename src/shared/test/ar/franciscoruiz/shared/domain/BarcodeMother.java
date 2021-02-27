package ar.franciscoruiz.shared.domain;

public final class BarcodeMother {
    public static String random() {
        return MotherCreator.random().code().asin();
    }
}
