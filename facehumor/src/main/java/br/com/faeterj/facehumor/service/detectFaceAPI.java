package br.com.faeterj.facehumor.service;

import br.com.faeterj.facehumor.entity.Face;
import br.com.faeterj.facehumor.entity.ImageDB;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import lombok.NoArgsConstructor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class detectFaceAPI {

    public static Face detectFaceByURL(String photoURL) throws Exception, IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Face face = null;

//        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));
//        Image img = Image.newBuilder().setContent(imgBytes).build();

        ImageSource imgSource = ImageSource.newBuilder().setImageUri(photoURL).build();
        Image img = Image.newBuilder().setSource(imgSource).build();

        Feature feat = Feature.newBuilder().setType(Feature.Type.FACE_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            System.out.println(photoURL);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s\n", res.getError().getMessage());
                    break;
                }

                // For full list of available annotations, see http://g.co/cloud/vision/docs
                for (FaceAnnotation  annotation : res.getFaceAnnotationsList()) {
                    System.out.format(
                            "anger: %s%njoy: %s%nsurprise: %s%nsorrow: %s%nHeadwear: %s",
                            annotation.getAngerLikelihood().toString(),
                            annotation.getJoyLikelihood(),
                            annotation.getSurpriseLikelihood(),
                            annotation.getSorrowLikelihood(),
                            annotation.getHeadwearLikelihood());

                    face = new Face(annotation, photoURL);
                }


            }
        }
        return face;
    }

    public static Face detectFaceByIMG(ImageDB image) throws Exception, IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();
        Face face = null;

        ByteString imgBytes = ByteString.copyFrom(image.getFace_img_data());
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.FACE_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s\n", res.getError().getMessage());
                    break;
                }

                // For full list of available annotations, see http://g.co/cloud/vision/docs
                for (FaceAnnotation  annotation : res.getFaceAnnotationsList()) {
                    System.out.format(
                            "anger: %s%njoy: %s%nsurprise: %s%nsorrow: %s%nHeadwear: %s",
                            annotation.getAngerLikelihood().toString(),
                            annotation.getJoyLikelihood(),
                            annotation.getSurpriseLikelihood(),
                            annotation.getSorrowLikelihood(),
                            annotation.getHeadwearLikelihood());

                    face = new Face(annotation, image);
                }


            }
        }
        return face;
    }
}
