package com.example.model;


public class AchievementsIdentification {

  private long id;
  private long sponsor;
  private long achievements;
  private String initialStatus;
  private String finalStatus;
  private long mentor;

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  private String userType;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSponsor() {
    return sponsor;
  }

  public void setSponsor(long sponsor) {
    this.sponsor = sponsor;
  }


  public long getAchievements() {
    return achievements;
  }

  public void setAchievements(long achievements) {
    this.achievements = achievements;
  }


  public String getInitialStatus() {
    return initialStatus;
  }

  public void setInitialStatus(String initialStatus) {
    this.initialStatus = initialStatus;
  }


  public String getFinalStatus() {
    return finalStatus;
  }

  public void setFinalStatus(String finalStatus) {
    this.finalStatus = finalStatus;
  }


  public long getMentor() {
    return mentor;
  }

  public void setMentor(long mentor) {
    this.mentor = mentor;
  }

}
