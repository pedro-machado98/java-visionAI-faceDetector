package br.com.faeterj.facehumor.entity;

import br.com.faeterj.facehumor.service.detectFaceAPI;
import com.google.cloud.vision.v1.FaceAnnotation;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "faces")
@Entity(name = "Face")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Face {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoURL;
    private Boolean joy;
    private Boolean anger;
    private Boolean surprise;
    private Boolean sorrow;
    private Boolean headwear;

    public Face(FaceAnnotation annotation, String photoURL) {
        this.photoURL = photoURL;
        this.joy = annotation.getJoyLikelihood().toString().equals("VERY_LIKELY");
        this.anger = annotation.getAngerLikelihood().toString().equals("VERY_LIKELY");
        this.surprise = annotation.getSurpriseLikelihood().toString().equals("VERY_LIKELY");
        this.sorrow = annotation.getSorrowLikelihood().toString().equals("VERY_LIKELY");
        this.headwear = annotation.getHeadwearLikelihood().toString().equals("VERY_LIKELY");
    }

    public Face getDataFromPhoto(String photoURL) throws Exception {
        return detectFaceAPI.detectFaceByURL(photoURL);
    }
}
