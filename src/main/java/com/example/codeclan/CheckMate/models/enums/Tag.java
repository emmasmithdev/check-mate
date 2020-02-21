package com.example.codeclan.CheckMate.models.enums;

public enum Tag {

    OPENING_UP("Opening Up"),
    GOOD_VIBES("Good Vibes"),
    CUTE("Cute"),
    CELEBRATION("Celebration"),
    NATURE("Nature"),
    SELF_CARE("Self-Care");

    public final String label;

    private Tag(String label) {
        this.label = label;
    }
}
