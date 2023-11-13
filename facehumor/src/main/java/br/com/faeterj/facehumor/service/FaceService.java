package br.com.faeterj.facehumor.service;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.FaceRepository;
import br.com.faeterj.facehumor.entity.ImageDB;
import br.com.faeterj.facehumor.entity.PhotoRegisterDTO;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FaceService {

    @Autowired
    private FaceRepository faceRepository;
    Face face = new Face();

    public Face registerImage (MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImageDB imageDB = new ImageDB(fileName, file.getContentType(), file.getBytes());

        return faceRepository.save(face.getDataFromPhotoByIMG(imageDB));
    }
    public Face registerURL(PhotoRegisterDTO photoURL) throws Exception {
        return faceRepository.save(face.getDataFromPhotoByURL(photoURL.photoURL()));
    }

    public List<Face> getAllFaces(){
        return faceRepository.findAll();
    }

    public void deleteFace(Long id) {
        faceRepository.deleteById(id);
    }

}
