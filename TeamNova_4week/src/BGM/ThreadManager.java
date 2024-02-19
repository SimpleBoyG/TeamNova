package BGM;

public class ThreadManager {
    private static ThreadManager ThreadManagerInstance;

    private BGMPlayer bgmPlayer;
    BGMThreadVillage Thread1;
    BGMThreadHunt Thread2;
    public static ThreadManager getInstance(){
        if(ThreadManagerInstance == null){
            ThreadManagerInstance = new ThreadManager();
        }
        return ThreadManagerInstance;
    }


    public ThreadManager(){
        bgmPlayer = BGMPlayer.getInstance();
        Thread1 = new BGMThreadVillage(bgmPlayer);
        Thread2 = new BGMThreadHunt(bgmPlayer);
    }

    public void ThreadTerminate(int ThreadNum){
        if(ThreadNum == 1){
            //System.out.println("pause : " + Thread1.getName());
            Thread1.interrupt();
        } else{
            //System.out.println("pause : " + Thread1.getName());
            Thread2.interrupt();
        }
    }

    public void ThreadStart(int ThreadNum){
        if(ThreadNum == 1){
            //System.out.println("pause : " + Thread1.getName());
            Thread1.start();
        } else{
            //System.out.println("pause : " + Thread1.getName());
            Thread2.start();
        }
    }

    public void createThread1(){
        if(Thread1.getState() != Thread.State.NEW) {
            Thread1 = new BGMThreadVillage(bgmPlayer);
        }
    }

    public void createThread2(){
        if(Thread1.getState() != Thread.State.NEW) {
            Thread2 = new BGMThreadHunt(bgmPlayer);
        }
    }
}
