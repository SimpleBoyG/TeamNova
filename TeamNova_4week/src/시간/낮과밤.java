package 시간;

import java.util.Random;

public class 낮과밤 {
    private static 낮과밤 Instance;
    private 낮과밤(){}
    String strNight[] = {"day", "night"};

    Random rd = new Random();
    private String DayAndNight = strNight[rd.nextInt(2)];
    public static 낮과밤 getInstance(){
        if(Instance == null){
            Instance = new 낮과밤();
        }
        return Instance;
    }
    public String getDayAndNight(){
        return DayAndNight;
    }
    public void ReDay(){
        DayAndNight = strNight[rd.nextInt(2)];
    }
}
