package Main;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;
import 시간.낮과밤;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 시간 쓰레든 선언
        낮과밤 낮과밤 = 시간.낮과밤.getInstance();;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("나의 마법사 키우기 게임이 시작됐습니다.");
        System.out.println("판타지 세계에 떨어진 마스터가 한명의 마법사를 키워나가는 게임입니다.");

        //================= 초기 셋팅 =========================
        // Master 상태 세팅
        String PlayerName;
        System.out.println("플레이어 이름을 입력해주세요.");
        System.out.println(":");

        PlayerName = sc.next();
        System.out.println("플레이어 이름은 " + PlayerName + " 입니다.");

        // 낮/밤 스위치 쓰레드 동작
        낮과밤.SwitchDay();

        MasterClass master = new MasterClass(PlayerName);
        MageClass mage = new MageClass();
        VillageInner vi = new VillageInner(master, mage);

        System.out.println("여기는 아라한 마을입니다.");
        vi.goVillage();
    }
}