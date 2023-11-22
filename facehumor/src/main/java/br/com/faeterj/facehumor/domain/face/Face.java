package br.com.faeterj.facehumor.domain.face;

import br.com.faeterj.facehumor.domain.image.ImageDB;
import br.com.faeterj.facehumor.service.detectFaceAPI;
import com.google.cloud.vision.v1.FaceAnnotation;
import jakarta.persistence.*;
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
    @Embedded
    private ImageDB faceImg;
    private Boolean joy;
    private Boolean anger;
    private Boolean surprise;
    private Boolean sorrow;
    private Boolean headwear;

    public Face(FaceAnnotation annotation, String photoURL) {
        this.faceImg = null;
        this.photoURL = photoURL;
        this.joy = annotation.getJoyLikelihood().toString().equals("VERY_LIKELY");
        this.anger = annotation.getAngerLikelihood().toString().equals("VERY_LIKELY");
        this.surprise = annotation.getSurpriseLikelihood().toString().equals("VERY_LIKELY");
        this.sorrow = annotation.getSorrowLikelihood().toString().equals("VERY_LIKELY");
        this.headwear = annotation.getHeadwearLikelihood().toString().equals("VERY_LIKELY");
    }

    public Face(FaceAnnotation annotation, ImageDB faceImg) {
        this.photoURL = null;
        this.faceImg = faceImg;
        this.joy = annotation.getJoyLikelihood().toString().equals("VERY_LIKELY");
        this.anger = annotation.getAngerLikelihood().toString().equals("VERY_LIKELY");
        this.surprise = annotation.getSurpriseLikelihood().toString().equals("VERY_LIKELY");
        this.sorrow = annotation.getSorrowLikelihood().toString().equals("VERY_LIKELY");
        this.headwear = annotation.getHeadwearLikelihood().toString().equals("VERY_LIKELY");


    }

    public Face getDataFromPhotoByURL(String photoURL) throws Exception {
        Face face = detectFaceAPI.detectFaceByURL(photoURL);
        if (face.headwear|| face.sorrow|| face.surprise|| face.joy|| face.anger){
            return face;
        }
        return new Face();
    }

    public Face getDataFromPhotoByIMG(ImageDB image) throws Exception {
        Face face = detectFaceAPI.detectFaceByIMG(image);
        if (face.headwear|| face.sorrow|| face.surprise|| face.joy|| face.anger){
            return face;
        }
        return new Face();
    }
}
