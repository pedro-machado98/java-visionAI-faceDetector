package br.com.faeterj.facehumor.repository;

import br.com.faeterj.facehumor.entity.Face;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaceRepository extends JpaRepository<Face, Long> {
}
