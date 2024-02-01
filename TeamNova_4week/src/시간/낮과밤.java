package 시간;

import java.util.Random;

public class 낮과밤 {
    private static 낮과밤 Instance;
    private 낮과밤(){}
    Random rd = new Random();
    private String DayAndNight = "day";
    public static 낮과밤 getInstance(){
        if(Instance == null){
            Instance = new 낮과밤();
        }
        return Instance;
    }
    public String getDayAndNight(){
        return DayAndNight;
    }
    public void SwitchDay(){
        Runnable 실행할코드 = new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(DayAndNight.equals("day")) {
                        System.out.println("지금은 해가 떠 있습니다.");
                        DayAndNight = "night";
                    }else{
                        System.out.println("지금은 해가 지고 밤이 찾아왔습니다.");
                        DayAndNight = "day";
                    }
                    try{
                        Thread.sleep(30000); // 30초
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread 실행할쓰레드 = new Thread(실행할코드);
        실행할쓰레드.start();
    }
}
