package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.FaceRepository;
import br.com.faeterj.facehumor.entity.PhotoRegister;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cadastrar (@RequestBody @Valid PhotoRegister photoURL) throws Exception {
        Face face = new Face();
        repository.save(face.getDataFromPhoto(photoURL.photoURL()));
    }

    @GetMapping
    public List<Face> listar () {
        return repository.findAll();
    }
}
