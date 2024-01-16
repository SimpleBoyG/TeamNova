package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;

import java.util.Scanner;

public class HuntingMenu {

    public int HuntingStartMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("어떤 행동을 하시겠습니까?");
        System.out.println("1) 사냥하러 간다. 2) 파티 설정은 수정한다.(미구현) 3) 마을로 간다.");
        System.out.println(":");
        int ActionSelect = sc.nextInt();
        return ActionSelect;
    }
    public int HuntingMenu(){
        System.out.println("어떤 행동을 취하겠습니까?");
        System.out.println("1) 공격한다. 2) 도망간다. ");
        System.out.println(":");

        Scanner sc = new Scanner(System.in);
        int MenuSelect = sc.nextInt();

        if(MenuSelect == 1){
            AttackSelect();
        }else{
            RunSelect();
        }
        return MenuSelect;
    }
    public void RunSelect(){
        System.out.println("도망칩니다.");
    }
    public void AttackSelect(){
        System.out.println("공격할 준비를 합니다.");
    }

    // 마스터 메뉴
    public int MasterMenu(MasterClass master){
        System.out.println(master.name + "님의 공격 차례입니다.");
        System.out.println("어떤 공격을 하시겠어요?");
        System.out.println("1) 일반공격 2) 방패공격 3) 마법사 방어 4) 도망간다");
        System.out.println(":");
        Scanner sc = new Scanner(System.in);
        int Result = sc.nextInt();

        return Result;
    }

    // 마법사 메뉴
    public int MageMenu(MageClass mage){
        System.out.println(mage.name + "님의 공격 차례입니다.");
        System.out.println("어떤 공격을 하시겠어요?");
        System.out.println("1) SkillLevel1 2) SkillLevel2 3) SkillLevel3 4) SkillLevel4");
        System.out.println(":");
        Scanner sc = new Scanner(System.in);
        int Result = sc.nextInt();

        return Result;
    }
}
