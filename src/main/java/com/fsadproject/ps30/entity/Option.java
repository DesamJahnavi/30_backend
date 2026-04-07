package com.fsadproject.ps30.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "options") // ✅ FIX
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionText;
    private int score;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOptionText() { return optionText; }
    public void setOptionText(String optionText) { this.optionText = optionText; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}