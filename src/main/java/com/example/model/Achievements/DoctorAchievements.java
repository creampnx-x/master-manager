package com.example.model.Achievements;

import com.example.model.Paper;
import com.example.model.Prize;

public class DoctorAchievements {
    private long id;
    private Paper paper;
    private Prize prize;
    private String standard;
    private String others;

    public DoctorAchievements(Paper paper, Prize prize, com.example.model.DoctorAchievements doctorAchievements) {
        this.paper = paper;
        this.prize = prize;
        setId(doctorAchievements.getId());
        setStandard(doctorAchievements.getStandard());
        setOthers(doctorAchievements.getOthers());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
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
