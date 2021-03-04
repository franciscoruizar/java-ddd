package ar.franciscoruiz.shared.domain;

public final class PhoneNumberMother {
    public static String random() {
        return MotherCreator.random().phoneNumber().cellPhone();
    }
}
