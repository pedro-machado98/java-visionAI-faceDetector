package br.com.faeterj.facehumor.service;

import br.com.faeterj.facehumor.DTO.FaceRegisterByIMGDTO;
import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.repository.FaceRepository;
import br.com.faeterj.facehumor.entity.ImageDB;
import br.com.faeterj.facehumor.DTO.FaceRegisterByURLDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FaceService {

    @Autowired
    private FaceRepository faceRepository;
    Face face = new Face();

    public Face registerImage (MultipartFile file) throws Exception {
        Face faceNow = face.getDataFromPhotoByIMG(new ImageDB(file));
        if(faceNow.getFaceImg() != null){
            return faceRepository.save(faceNow);
        }
        return null;
    }
    public Face registerURL(FaceRegisterByURLDTO photoURL) throws Exception {
        Face faceNow = face.getDataFromPhotoByURL(photoURL.photoURL());
        if(faceNow.getPhotoURL() != null){
            return faceRepository.save(faceNow);
        }
        return null;
    }

    public List<Face> getAllFaces(){
        return faceRepository.findAll();
    }

    public void deleteFace(Long id) {
        faceRepository.deleteFaceById(id);
    }

    public void deleteAllFaces() {
        faceRepository.deleteAll();
    }
}
