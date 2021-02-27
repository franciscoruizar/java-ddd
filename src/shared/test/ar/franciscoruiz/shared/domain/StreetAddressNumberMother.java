package ar.franciscoruiz.shared.domain;

public final class StreetAddressNumberMother {
    public static String random() {
        return MotherCreator.random().address().streetAddressNumber();
    }
}
