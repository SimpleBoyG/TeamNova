package Main;

import 사냥터.MonsterSearching;
import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;

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
        System.out.println("플레이어 이름은 " + PlayerName + " 입니다.");

        MasterClass master = new MasterClass(PlayerName);
        MageClass Mage = new MageClass("마법사");

        while (true) {
            System.out.println("어디로 이동하시겠습니까?");
            System.out.println("1) 마을 2) 사냥터");
            System.out.println(":");
            int wherePlace;
            wherePlace = sc.nextInt();

            switch (wherePlace) {
                case 1:
                    System.out.println("마을로 돌아갑니다.");
                    VillageInner village = new VillageInner(master,Mage);
                    village.goVillage();
                    break;
                case 2:
                    System.out.println("사냥터로 향합니다.");
                    // 몬스터 탐색
                    MonsterSearching ms = new MonsterSearching(master,Mage);
                    ms.MonsterSearching();
                    break;
            }
            break;

        }

        // ============================= 배틀 ==========================================


    }
}