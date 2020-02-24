package com.example.codeclan.CheckMate.models.enums;

public enum Mood {
    DEPRESSED("Depressed"),
    SAD("Sad"),
    ANXIOUS("Anxious"),
    WORRIED("Worried"),
    MANIC("Manic"),
    HAPPY("Happy"),
    OKAY("Okay"),
    GRATEFUL("Grateful"),
    AGITATED("Agitated"),
    FINE("Fine"),
    ECSTATIC("Ecstatic"),
    CALM("Calm"),
    PEACEFUL("Peaceful"),
    EXCITED("Excited"),
    AMUSED("Amused"),
    CONTENT("Content"),
    ANGRY("Angry"),
    STRESSED("Stressed"),
    APATHETIC("Apathetic");

    private final String name;

    Mood(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
