package br.com.faeterj.facehumor;

import br.com.faeterj.facehumor.service.detectFaceAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.PrintStream;

@SpringBootApplication
public class FacehumorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FacehumorApplication.class, args);
//		String foto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuszKgEEzTdILZZWGz3ATx733Vde2AvLojrg&usqp=CAU";
//		String json = null;
//		PrintStream ps = new PrintStream("/C:/Users/pedro.machado/Desktop/Github/Projeto 4POA-4UBD/facehumor/src/main/resources/templates/teste.txt");
//		detectFaceAPI.detectFaceByURL(foto);
	}
}