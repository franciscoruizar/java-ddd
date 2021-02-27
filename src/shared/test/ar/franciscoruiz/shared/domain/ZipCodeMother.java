package ar.franciscoruiz.shared.domain;

public final class ZipCodeMother {
    public static String random() {
        return MotherCreator.random().address().zipCode();
    }
}
