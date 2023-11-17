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


//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        ImageDB imageDB = new ImageDB(fileName, file.getContentType(), file.getBytes());

        return faceRepository.save(face.getDataFromPhotoByIMG(new ImageDB(file)));

//        return faceRepository.save(face.getDataFromPhotoByIMG(imageDB));
    }
    public Face registerURL(FaceRegisterByURLDTO photoURL) throws Exception {
        return faceRepository.save(face.getDataFromPhotoByURL(photoURL.photoURL()));
    }

    public List<Face> getAllFaces(){
        return faceRepository.findAll();
    }

    public Face deleteFace(Long id) {
        return faceRepository.deleteFaceById(id);
    }

    public void deleteAllFaces() {
        faceRepository.deleteAll();
    }
}
