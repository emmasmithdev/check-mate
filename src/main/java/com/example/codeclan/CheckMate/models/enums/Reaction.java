package com.example.codeclan.CheckMate.models.enums;

public enum Reaction {

    HAPPY("U+1F600"),
    SAD("U+1F61E"),
    LAUGHING("U+1F602"),
    LOVE("U+2764"),
    THUMBS_UP("U+1F44D"),
    HUG("U+1F917"),
    CAT("U+1F638"),
    DOG("U+1F436");

    public final String label;

    private Reaction(String label){
        this.label = label;
    }
}
