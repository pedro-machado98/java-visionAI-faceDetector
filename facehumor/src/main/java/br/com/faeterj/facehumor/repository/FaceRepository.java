package br.com.faeterj.facehumor.repository;

import br.com.faeterj.facehumor.entity.Face;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceRepository extends JpaRepository<Face, Long> {


}
