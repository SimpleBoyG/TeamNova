package BGM;

public class BGMThreadHunt extends Thread {
    private BGMPlayer bgmPlayer;

    public BGMThreadHunt(BGMPlayer bgmPlayer) {
        this.bgmPlayer = bgmPlayer; // 공유 객체
    }

    @Override
    public void run() {
        //System.out.println("BGMThread2 :" + Thread.currentThread().getName());
        bgmPlayer.BGMPlay(2);
    }
}
