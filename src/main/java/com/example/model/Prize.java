package com.example.model;


public class Prize {

  private long id;
  private String name;
  private String prizeLevel;
  private String awardsRank;
  private String rank;
  private java.sql.Date time;
  private String resource;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPrizeLevel() {
    return prizeLevel;
  }

  public void setPrizeLevel(String prizeLevel) {
    this.prizeLevel = prizeLevel;
  }


  public String getAwardsRank() {
    return awardsRank;
  }

  public void setAwardsRank(String awardsRank) {
    this.awardsRank = awardsRank;
  }


  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }


  public java.sql.Date getTime() {
    return time;
  }

  public void setTime(java.sql.Date time) {
    this.time = time;
  }


  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

}
