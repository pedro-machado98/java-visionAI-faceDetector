package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.FaceRepository;
import br.com.faeterj.facehumor.entity.PhotoRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faces")
public class FaceController {

    @Autowired
    private FaceRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register (@RequestBody @Valid PhotoRegisterDTO photoURL) throws Exception {
        Face face = new Face();
        return ResponseEntity.ok(repository.save(face.getDataFromPhoto(photoURL.photoURL())));
    }

    @GetMapping
    public ResponseEntity list () {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete (@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
