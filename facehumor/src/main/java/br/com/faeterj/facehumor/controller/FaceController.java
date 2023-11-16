package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.DTO.FaceRegisterByIMGDTO;
import br.com.faeterj.facehumor.DTO.FaceRegisterByURLDTO;
import br.com.faeterj.facehumor.service.FaceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
    public ResponseEntity registerByIMG (@ModelAttribute("file") FaceRegisterByIMGDTO file) throws Exception {
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
