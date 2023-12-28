import java.io.*;

public class ImageFileIO {
    public static void main(String[] args) throws IOException {

        // 1. 바이트 형태의 파일 불러오기
        // => inputStream
        try {
            // 원본 파일 준비(읽어올 파일)
            File originalFile = new File("C:/Temp/Test2.jpg");

            if(originalFile.exists()){
                // 1) 원본 파일 읽어 오기
                FileInputStream in = new FileInputStream(originalFile);

                long oriFileSize = originalFile.length();
                System.out.println("++++++++++++++++++++++++++++++++");
                System.out.println("원본 파일 사이즈 : " + oriFileSize);
                System.out.println("++++++++++++++++++++++++++++++++");

                // 2) 보조 스트림 준비
                BufferedInputStream bis = new BufferedInputStream(in);

                // 3) 직접 버퍼를 만들어야 한다.
                byte[] buffer = new byte[1024];

                // 4) 복사 대상 파일 준비
                File copyFile = new File("C:/Temp/copy_Test2.jpg");

                // bufferedInputStream 으로 입력 받은 버퍼에 들어있는 데이터를 copyFile에 출력
                // 출력을 위한 OutputStream이 필요하다.
                FileOutputStream out = new FileOutputStream(copyFile);
                BufferedOutputStream bos = new BufferedOutputStream(out);

                int readCount = -1;
                int total_readCount = 0;

                while((readCount = bis.read(buffer)) != -1) {
                    total_readCount += readCount;
                    System.out.println("읽은 수 : " + readCount);

                    // BufferedInputStream을 이용하여 읽어들인 버퍼를
                    // 그대로 BufferedOutputStream을 이용하여 출력한다.
                    bos.write(buffer);
                    System.out.println("파일 복사 진행 >>" + total_readCount + "/" + originalFile.length());
                }
                bos.flush();
                bos.close();
                bis.close();
            }else{
                System.out.println("원본 파일이 없습니다.");
            }
            System.out.println("프로그램 종료");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
