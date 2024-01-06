package Main;
import Hunting.HuntingProcess;
import Mage.FireMageClass;
import Mage.WaterMageClass;
import Master.MasterClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("나의 마법사 키우기 게임이 시작됐습니다.");

        //================= 초기 셋팅 =========================
        // Master 상태 세팅
        String PlayerName;

        System.out.println("플레이어 이름을 입력해주세요.");
        System.out.println(":");

        PlayerName = sc.next();
        System.out.println("플레이어 이름은 "+PlayerName + " 입니다.");

        MasterClass MainPlayer = new MasterClass(PlayerName);
        FireMageClass FireMage = new FireMageClass("불 마법사");
        WaterMageClass WaterMage = new WaterMageClass("불 마법사");


        while(true){
            System.out.println("어디로 이동하시겠습니까?");
            System.out.println("1) 마을 2) 사냥");
            System.out.println(":");
            int wherePlace;
            wherePlace = sc.nextInt();

            switch(wherePlace){
                case 2:
                    HuntingProcess hg = new HuntingProcess();
                    hg.HuntingProcess();
                    break;

            }
            break;

        }
    }
}