package br.com.faeterj.facehumor.controller;

import br.com.faeterj.facehumor.entity.DTO.FaceRegisterByURLDTO;
import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.DTO.FaceResponseDTO;
import br.com.faeterj.facehumor.service.FaceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


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
    public ResponseEntity registerByURL(@RequestBody @Valid FaceRegisterByURLDTO photoURL) throws Exception {
        return ResponseEntity.ok(faceservice.registerURL(photoURL));
    }
    @PostMapping("/img")
    @Transactional
    public ResponseEntity registerByIMG(@ModelAttribute("file") MultipartFile file, UriComponentsBuilder uriBuilder) throws Exception {
        Face face = faceservice.registerImage(file);
        if(face == null) {
            return ResponseEntity.badRequest().build();
        }
        URI uri = uriBuilder.path("/img/{id}").buildAndExpand(face.getId()).toUri();
        return ResponseEntity.created(uri).body(new FaceResponseDTO(face));
    }

    @GetMapping
    public ResponseEntity list() {
        return ResponseEntity.ok(faceservice.getAllFaces().stream().map(FaceResponseDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        Face face = faceservice.detailFace(id);
        return ResponseEntity.ok(new FaceResponseDTO(face));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Face> delete (@PathVariable("id") Long id) {

        faceservice.deleteFace(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAll")
    @Transactional
    public ResponseEntity delete() {
        faceservice.deleteAllFaces();
        return ResponseEntity.noContent().build();
    }
}
