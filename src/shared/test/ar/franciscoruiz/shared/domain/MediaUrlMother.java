package ar.franciscoruiz.shared.domain;

public final class MediaUrlMother {
    public static MediaUrl create(String value) {
        return new MediaUrl(value);
    }

    public static MediaUrl random() {
        return create(MotherCreator.random().internet().url());
    }
}
