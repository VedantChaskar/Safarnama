package com.company.vacationtourapp.model;

public class GuideData {

    String GuideName;
    String GuideNumber;
    String GuideLocation;

    public GuideData(String GuideName, String GuideNumber, String GuideLocation) {
        this.GuideName = GuideName;
        this.GuideNumber = GuideNumber;
        this.GuideLocation = GuideLocation;
    }

    public String getGuideName() {
        return GuideName;
    }

    public void setGuideName(String GuideName) { this.GuideName = GuideName; }

    public String getGuideNumber() {
        return GuideNumber;
    }

    public void setGuideNumber(String GuideNumber) {
        this.GuideNumber = GuideNumber;
    }

    public String getGuideLocation() {
        return GuideLocation;
    }

    public void setGuideLocation(String GuideLocation) {
        this.GuideLocation = GuideLocation;
    }
}
