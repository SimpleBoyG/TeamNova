package BGM;

public class BGMThreadVillage extends Thread {
    private BGMPlayer bgmPlayer;

    public BGMThreadVillage(BGMPlayer bgmPlayer) {
        this.bgmPlayer = bgmPlayer; // 공유 객체
    }

    @Override
    public void run() {
        //System.out.println("BGMThread1 :" + Thread.currentThread().getName());
        bgmPlayer.BGMPlay(1);
    }
}
