package br.com.faeterj.facehumor.domain.image;

import br.com.faeterj.facehumor.domain.face.FaceRegisterByIMGDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDB {
    private String name;
    private String type;
    private byte[] face_img_data;

    public ImageDB(FaceRegisterByIMGDTO file) throws IOException {
        this.face_img_data = file.img().getBytes();
        this.name = StringUtils.cleanPath(file.img().getOriginalFilename());
        this.type = file.img().getContentType();
    }

    public ImageDB(MultipartFile file) throws IOException {
        this.face_img_data = file.getBytes();
        this.name = StringUtils.cleanPath(file.getOriginalFilename());
        this.type = file.getContentType();
    }
}
