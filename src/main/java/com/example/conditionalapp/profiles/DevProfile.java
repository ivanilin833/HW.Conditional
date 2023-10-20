package com.example.conditionalapp.profiles;

import com.example.conditionalapp.profiles.interfaces.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
