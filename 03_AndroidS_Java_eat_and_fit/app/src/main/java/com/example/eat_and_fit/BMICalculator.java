package com.example.eat_and_fit;

public class BMICalculator {
    BMIResult calcBMI(Person person) {
        double value = person.getWeight() / (person.getHeight()*person.getHeight());
        BMIStatus status = BMIStatus.NORMAL;

        if (value < 16.5) {
            status = BMIStatus.DESNUTRITION;
        } else if (value < 18.5) {
            status = BMIStatus.UNDER_WEIGHT;
        } else if (value < 25) {
            status = BMIStatus.NORMAL;
        } else if (value < 30) {
            status = BMIStatus.OVER_WEIGHT;
        } else if (value < 35) {
            status = BMIStatus.MODERATE_OBESE;
        } else if (value < 40) {
            status = BMIStatus.HIGHLY_OBESE;
        } else {
            status = BMIStatus.MORBIDLY_OBESE;
        }

        return new BMIResult(value, status);
    }

    class BMIResult {
        private final double value;
        private final BMIStatus status;

        private BMIResult(double pValue, BMIStatus pStatus) {
            this.value = pValue;
            this.status = pStatus;
        }

        public double getValue() {
            return value;
        }

        public BMIStatus getStatus() {
            return status;
        }
    }
}
