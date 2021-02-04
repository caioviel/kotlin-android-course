package com.example.eat_and_fit;

public enum BMIStatus {
    DESNUTRITION("desnutrido"),
    UNDER_WEIGHT("baixo do peso"),
    NORMAL("peso ideal"),
    OVER_WEIGHT("acima do peso"),
    MODERATE_OBESE("moderadamente obeso"),
    HIGHLY_OBESE("obesidade elevada"),
    MORBIDLY_OBESE("obesidade morbida");

    public final String ptLabel;

    private BMIStatus(String ptLabel) {
        this.ptLabel = ptLabel;
    }
}
