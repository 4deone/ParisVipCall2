package com.deone.parisvipcall.models;

public class LogInformation {
    private String login;
    private String password;
    private String typeChoose;
    private String privateMode;
    private String date;
    private String commentaire;

    public LogInformation() {
    }

    public LogInformation(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LogInformation(String login, String password, String typeChoose, String privateMode, String commentaire) {
        this.login = login;
        this.password = password;
        this.typeChoose = typeChoose;
        this.privateMode = privateMode;
        this.commentaire = commentaire;
    }

    public LogInformation(String login, String password, String typeChoose, String privateMode, String date, String commentaire) {
        this.login = login;
        this.password = password;
        this.typeChoose = typeChoose;
        this.privateMode = privateMode;
        this.date = date;
        this.commentaire = commentaire;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeChoose() {
        return typeChoose;
    }

    public void setTypeChoose(String typeChoose) {
        this.typeChoose = typeChoose;
    }

    public String getPrivateMode() {
        return privateMode;
    }

    public void setPrivateMode(String privateMode) {
        this.privateMode = privateMode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
