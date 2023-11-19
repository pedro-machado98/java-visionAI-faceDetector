package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.DTO.FaceRegisterByIMGDTO;
import br.com.faeterj.facehumor.DTO.FaceRegisterByURLDTO;
import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.service.FaceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/faces")
@CrossOrigin()
public class FaceController {

    private FaceService faceservice;

    public FaceController (FaceService faceservice) {
        this.faceservice = faceservice;
    }

    @PostMapping("/url")
    @Transactional
    public ResponseEntity registerByURL (@RequestBody @Valid FaceRegisterByURLDTO photoURL) throws Exception {
        return ResponseEntity.ok(faceservice.registerURL(photoURL));
    }
    @PostMapping("/img")
    @Transactional
    public ResponseEntity registerByIMG (@ModelAttribute("file") MultipartFile file) throws Exception {
        if(file.isEmpty()){
            System.out.println("------------------------ARQUIVO ESTÁ VAZIO!! --------------------------------------");
        }
        System.out.println("Key name: "+file.getName());
        System.out.println("File name: "+file.getOriginalFilename());
        System.out.println("Content type: "+file.getContentType());
        System.out.println("Bytes length: "+file.getSize());
        System.out.println("Resource multipart: "+file.getResource());
        Face face = faceservice.registerImage(file);
        if(face == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(faceservice.registerImage(file));
    }
    @GetMapping
    public ResponseEntity list () {
        return ResponseEntity.ok(faceservice.getAllFaces());
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Face> delete (@PathVariable("id") Long id) {
        faceservice.deleteFace(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity delete () {
        faceservice.deleteAllFaces();
        return ResponseEntity.ok().build();
    }
}
