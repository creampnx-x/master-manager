package com.example.model;


public class MasterAchievements {

  private long id;
  private long paper;
  private String textbook;
  private String standard;
  private String patent;
  private String report;
  private String devCertificate;


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


  public String getTextbook() {
    return textbook;
  }

  public void setTextbook(String textbook) {
    this.textbook = textbook;
  }


  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }


  public String getPatent() {
    return patent;
  }

  public void setPatent(String patent) {
    this.patent = patent;
  }


  public String getReport() {
    return report;
  }

  public void setReport(String report) {
    this.report = report;
  }


  public String getDevCertificate() {
    return devCertificate;
  }

  public void setDevCertificate(String devCertificate) {
    this.devCertificate = devCertificate;
  }

}
