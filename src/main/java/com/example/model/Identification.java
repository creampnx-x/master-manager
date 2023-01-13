package com.example.model;

import com.example.model.Achievements.DoctorAchievements;
import com.example.model.Achievements.MasterAchievements;

public class Identification {
    private long id;
    private long sponsor;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String userType;
    private MasterAchievements masterAchievements;

    public DoctorAchievements getDoctorAchievements() {
        return doctorAchievements;
    }

    public void setDoctorAchievements(DoctorAchievements doctorAchievements) {
        this.doctorAchievements = doctorAchievements;
    }

    private DoctorAchievements doctorAchievements;
    private String initialStatus;
    private String finalStatus;

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

    public MasterAchievements getMasterAchievements() {
        return masterAchievements;
    }

    public void setMasterAchievements(MasterAchievements masterAchievements) {
        this.masterAchievements = masterAchievements;
    }
}
