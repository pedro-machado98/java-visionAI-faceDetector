package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.FaceRepository;
import br.com.faeterj.facehumor.entity.ImageDB;
import br.com.faeterj.facehumor.entity.PhotoRegisterDTO;
import br.com.faeterj.facehumor.service.FaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        return ResponseEntity.ok(faceservice.registerImage(file));
    }

    @GetMapping
    public ResponseEntity list () {
        return ResponseEntity.ok(faceservice.getAllFaces());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete (@PathVariable Long id){
        faceservice.deleteFace(id);
        return ResponseEntity.ok().build();
    }
}
