package com.bogsnebes.mtstetajava.data.dto;

public final class MovieDto {
    public final Long id;
    public final String title;
    public final String description;
    public final Float rateScore;
    public final Boolean ageRestriction;
    public final String imageUrl;

    MovieDto(Long id, String title, String description, Float rateScore, Boolean ageRestriction, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rateScore = rateScore;
        this.ageRestriction = ageRestriction;
        this.imageUrl = imageUrl;
    }
}
