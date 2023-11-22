package br.com.faeterj.facehumor.repository;

import br.com.faeterj.facehumor.domain.face.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceRepository extends JpaRepository<Face, Long> {


}
