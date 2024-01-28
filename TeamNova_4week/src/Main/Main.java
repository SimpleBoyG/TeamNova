package Main;

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
        MageClass mage = new MageClass();
        VillageInner vi = new VillageInner(master,mage);

        System.out.println("여기는 아라한 마을입니다.");
        vi.goVillage();
    }
}