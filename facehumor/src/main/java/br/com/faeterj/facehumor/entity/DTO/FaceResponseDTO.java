package br.com.faeterj.facehumor.entity.DTO;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.ImageDB;

public record FaceResponseDTO(Boolean joy,
                              Boolean anger,
                              Boolean surprise,
                              Boolean sorrow,
                              Boolean headwear,
                              ImageDB faceImg,
                              String photoURL) {
    public FaceResponseDTO(Face face) {
        this(face.getJoy(), face.getAnger(), face.getSurprise(), face.getSorrow(), face.getHeadwear(), face.getFaceImg(), face.getPhotoURL());
    }
}
