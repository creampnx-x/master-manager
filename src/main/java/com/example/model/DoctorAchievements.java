package com.example.model;


public class DoctorAchievements {

  private long id;
  private long paper;
  private long prize;
  private String standard;
  private String others;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPaper() {
    return paper;
  }

  public void setPaper(long paper) {
    this.paper = paper;
  }


  public long getPrize() {
    return prize;
  }

  public void setPrize(long prize) {
    this.prize = prize;
  }


  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }


  public String getOthers() {
    return others;
  }

  public void setOthers(String others) {
    this.others = others;
  }

}
