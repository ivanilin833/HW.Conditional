package com.example.conditionalapp.profiles;

import com.example.conditionalapp.profiles.interfaces.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is product";
    }
}
