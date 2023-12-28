import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class ImageFileIOBase64 {
    public static void main(String[] args) {
        // 이미지 파일 경로
        String imagePath = "C:/Temp/test2.jpg";

        try {
            // 이미지 파일을 바이트 배열로 읽어옴
            Path path = Paths.get(imagePath);
            byte[] imageBytes = Files.readAllBytes(path);

            // 이미지를 Base64로 인코딩
            String base64Encoded = Base64.getEncoder().encodeToString(imageBytes);

            // Base64로 인코딩된 문자열을 디코딩하여 이미지로 저장
            byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
            Path outputPath = Paths.get("C:/Temp/test2_output.jpg");
            Files.write(outputPath, decodedBytes);

            System.out.println("이미지 변환해서 출력 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
