import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main {
    public static void main(String[] args) {
//        try {
//            File file = new File("Test/src/TestSong.wav");
//            File file1 = new File("Test/src/TestSong2.wav");
//            File file2 = new File("Test/src/TestSong3.wav");
//            File file3 = new File("Test/src/PokemonSong.wav");
//            // audio input stream 열기
//            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
//
//            //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Main.class.getResource(bgmFilePath));
//
//            // 클립 가져오기
//            Clip clip = AudioSystem.getClip();
//
//            // 오디오 클립 열기
//            clip.open(stream);
//
//            // 클립 길이 만큼의 초를 가져온다
//            // 가독성을 위하여 100만을 나타낸 수 1_000_000
//            long DurationClipSecond = clip.getMicrosecondLength();
//            long DurationSecond = DurationClipSecond / 1_000_000;
//
//            // BGM 루프 시작
//            clip.loop(2);
//            Thread.sleep(10000);//DurationSecond*1000);
//            //clip.stop();
//            //clip.close();
//
////            stream = AudioSystem.getAudioInputStream(file1);
////            clip.open(stream);
////            clip.start();
////            Thread.sleep(30000);
////            clip.stop();
////            clip.close();
////            //stream.close();
////
////            stream = AudioSystem.getAudioInputStream(file2);
////            clip.open(stream);
////            clip.start();
////            Thread.sleep(30000);
////            clip.stop();
////            clip.close();
////            //stream.close();
////
////            stream = AudioSystem.getAudioInputStream(file3);
////            clip.open(stream);
////            clip.start();
////            Thread.sleep(30000);
////            clip.stop();
////            clip.close();
//
//
//
//
//
//
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//
////        Thread thread = new Thread(() -> {
////            Toolkit toolkit = Toolkit.getDefaultToolkit(); // 쓰레드 실행 내용
////            for (int i = 0; i < 5; i++) {
////                toolkit.beep();
////                try {
////                    Thread.sleep(500);
////                } catch (Exception e) {
////                }
////            }
////        });
////
////        thread.start();
//    }
//===============================================================
        WorkObject shardObject = new WorkObject(); // 공유 객체 생성

        ThreadA threadA = new ThreadA(shardObject);
        ThreadB threadB = new ThreadB(shardObject); // ThreadA와 ThreadB 생성

        threadA.start(); // ThreadA와 ThreadB를 실행
        threadB.start();
//===============================================================

   }
}