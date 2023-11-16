package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.PhotoRegisterDTO;
import br.com.faeterj.facehumor.service.FaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/faces")
public class FaceController {

    @Autowired
    private FaceService faceservice;

    @PostMapping("/url")
    @Transactional
    public ResponseEntity registerByURL (@RequestBody @Valid PhotoRegisterDTO photoURL) throws Exception {
        return ResponseEntity.ok(faceservice.registerURL(photoURL));
    }
    @PostMapping("/img")
    @Transactional
    public ResponseEntity registerByIMG (@RequestParam("file") MultipartFile file) throws Exception {
        if(file.isEmpty()){
            System.out.println("------------------------ARQUIVO ESTÁ VAZIO!! --------------------------------------");
        }
        System.out.println("Key name: "+file.getName());
        System.out.println("File name: "+file.getOriginalFilename());
        System.out.println("Content type: "+file.getContentType());
        System.out.println("Bytes length: "+file.getSize());
        System.out.println("Resource multipart: "+file.getResource());
        System.out.println("toString: " + file.toString());
        System.out.println("Classe: " + file.getClass());
        return ResponseEntity.ok(faceservice.registerImage(file));
    }
    @GetMapping
    public List<Face> list() {
        return faceservice.getAllFaces();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Face> delete (@PathVariable Long id){
        faceservice.deleteFace(id);

        ResponseEntity.ok().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public List<Face> delete () {
        return faceservice.deleteAllFaces();
    }
}
