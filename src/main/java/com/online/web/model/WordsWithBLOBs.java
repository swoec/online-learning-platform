package main.java.com.online.web.model;

public class WordsWithBLOBs extends Words {
    private String exp;

    private String sentance;

    private String synon;

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp == null ? null : exp.trim();
    }

    public String getSentance() {
        return sentance;
    }

    public void setSentance(String sentance) {
        this.sentance = sentance == null ? null : sentance.trim();
    }

    public String getSynon() {
        return synon;
    }

    public void setSynon(String synon) {
        this.synon = synon == null ? null : synon.trim();
    }
}