package br.com.faeterj.facehumor.DTO;

import br.com.faeterj.facehumor.entity.ImageDB;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public record FaceRegisterByIMGDTO(MultipartFile img) {


}