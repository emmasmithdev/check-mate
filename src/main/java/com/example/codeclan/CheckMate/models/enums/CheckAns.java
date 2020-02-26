package com.example.codeclan.CheckMate.models.enums;

public enum CheckAns {
    ONE("I'm feeling okay, thank you."),
    TWO("I'm feeling a little depressed, but I'll be okay."),
    THREE("I'm feeling depressed."),
    FOUR("I'm feeling happy today, thank you for asking."),
    FIVE("I need help."),
    SIX("I would like you to come round."),
    SEVEN("I'd rather not talk about it right now, but thank you."),
    EIGHT("I'm feeling stressed today."),
    NINE("Do you have time to chat?"),
    TEN("Can you check in on me tomorrow please?");

    public final String check;

    CheckAns(String check) {
        this.check = check;
    }

    public String getCheck() {
        return this.check;
    }
}
