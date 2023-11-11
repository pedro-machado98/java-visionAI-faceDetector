package br.com.faeterj.facehumor.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.cloud.vision.v1.FaceAnnotation;
import jakarta.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataRegisterFace(
        @JsonAlias("photoURL")Photo photoURL,
        @JsonAlias("joyLikelihood")String joy,
        @JsonAlias("angerLikelihood")String anger,
        @JsonAlias("surpriseLikelihood")String surprise,
        @JsonAlias("sorrowLikelihood")String sorrow,
        @JsonAlias("headwearLikelihood")String headwear
) {

    public DataRegisterFace(FaceAnnotation annotation, Photo photoURL) {
        this(photoURL,
                annotation.getJoyLikelihood().toString(),
                annotation.getAngerLikelihood().toString(),
                annotation.getSurpriseLikelihood().toString(),
                annotation.getSorrowLikelihood().toString(),
                annotation.getHeadwearLikelihood().toString()
        );
    }
}