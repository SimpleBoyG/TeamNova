package BGM;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class BGMPlayer {
    public static Clip clip;

    private static BGMPlayer BGMInstance;

    public static BGMPlayer getInstance() {
        if (BGMInstance == null) {
            BGMInstance = new BGMPlayer();
        }
        return BGMInstance;
    }

    public void BGMPlay(int BgmNum){
        while(true) {
            String strFilePath1 =  "TeamNova_4week/src/BGM/TestSong2.wav";
            String strFilePath2 =  "TeamNova_4week/src/BGM/PokemonSong.wav";
            File file = null;
            if(BgmNum == 1) {
                file = new File(strFilePath1);
            }else{
                file = new File(strFilePath2);
            }

            try {
                AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                // 클립 가져오기
                clip = AudioSystem.getClip();

                if (clip != null && clip.isRunning()) {
                    clip.stop();
                }

                // 재생하려는 클립을 오픈한다.
                clip.open(stream);
                // 클립 시작
                clip.start();

                // 클립 재생 시간 계산
                long DurationClipSecond = clip.getMicrosecondLength();
                long DurationSecond = DurationClipSecond / 1_000_000;

                //System.out.println("methodBGM_1 : " + Thread.currentThread().getName());
                // 재생 시간만큼 재생
                Thread.sleep(DurationSecond * 1000);//DurationSecond/1_000_000);

                // 재생 시간 후 정지/닫기
                clip.stop();
                clip.close();
            } catch (Exception e) {
                //System.out.println("2" + e.getMessage());
                break;
            }
        }
    }

    // Method to pause playback
    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
