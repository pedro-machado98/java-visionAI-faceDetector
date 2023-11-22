package br.com.faeterj.facehumor.entity.DTO;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.ImageDB;

public record createdFaceResponseDTO(String photoURL,
                                     Boolean joy,
                                     Boolean anger,
                                     Boolean surprise,
                                     Boolean sorrow,
                                     Boolean headwear,
                                     ImageDB faceImg) {
    public createdFaceResponseDTO(Face face) {
        this(face.getPhotoURL(), face.getJoy(), face.getAnger(), face.getSurprise(), face.getSorrow(), face.getHeadwear(), face.getFaceImg());
    }
}
