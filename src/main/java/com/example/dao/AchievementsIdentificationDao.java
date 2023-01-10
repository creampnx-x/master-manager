package com.example.dao;

import com.example.model.*;
import java.util.ArrayList;

public class AchievementsIdentificationDao {
    ArrayList<AchievementsIdentification> getIdentificationList(ArrayList<Object> column, int sponsor) {
        return new ArrayList<>();
    }

    int insertPaper(Paper paper) {
        return 1;
    }

    int insertPrize(Prize prize) {
        return 1;
    }

    int insertMasterIdentification(MasterAchievements masterAchievements) {
        return 1;
    }

    int insertDoctorIdentification(DoctorAchievements doctorAchievements) {
        return 1;
    }

    int insertIdentification(com.example.model.AchievementsIdentification achievementsIdentification) {
        return 1;
    }

    void deleteIdentification(int id) {
    }

    void updateStatus(int node, int id) {
    }
}
