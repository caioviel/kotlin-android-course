package com.example.exer_02_intents;

public class MathChallenge {
    private String question;
    private Integer answer;

    public MathChallenge(String pQuestion, Integer pAnswer) {
        this.question = pQuestion;
        this.answer = pAnswer;
    }

    public Integer getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
