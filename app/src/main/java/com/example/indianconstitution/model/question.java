package com.example.indianconstitution.model;

public class question {
    private int questionid;
    private boolean istrue;

    public question(int questionid,boolean istrue) {
        this.questionid = questionid;
        this.istrue=istrue;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public boolean isIstrue() {
        return istrue;
    }

    public void setIstrue(boolean istrue) {
        this.istrue = istrue;
    }
}
