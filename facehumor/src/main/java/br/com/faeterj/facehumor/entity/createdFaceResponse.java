package br.com.faeterj.facehumor.entity;

public record createdFaceResponse(String photoURL,
                                  ImageDB faceImg,
                                  Boolean joy,
                                  Boolean anger,
                                  Boolean surprise,
                                  Boolean sorrow,
                                  Boolean headwear) {
    public createdFaceResponse(Face face) {
        this(face.getPhotoURL(), face.getFaceImg(), face.getJoy(), face.getAnger(), face.getSurprise(), face.getSorrow(), face.getHeadwear());
    }
}
