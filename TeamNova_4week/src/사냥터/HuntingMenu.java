package 사냥터;

import 마법사.MageClass;
import 마스터.MasterClass;

import java.util.Scanner;

public class HuntingMenu {
    Scanner sc = new Scanner(System.in);
    public int HuntingStartMenu(){
        System.out.println("어떤 행동을 하시겠습니까?");
        System.out.println("1) 사냥하러 간다. 2) 파티 스킬 설정을 수정한다. 3) 마을로 간다.");
        System.out.println(":");
        int ActionSelect = sc.nextInt();
        return ActionSelect;
    }
    public int HuntingMenu(){
        System.out.println("어떤 행동을 취하겠습니까?");
        System.out.println("1) 공격한다. 2) 도망간다. ");
        System.out.println(":");

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
        System.out.printf("1) 일반공격 <데미지 %d> ",master.Attack);
        System.out.printf("2) 방패공격 <데미지 %d> ",master.Attack+5);
        System.out.printf("3) 대신 막기 ");
        System.out.printf("4) 도망 ");
        System.out.println(":");
        int Result = sc.nextInt();

        return Result;
    }

    // 마법사 메뉴
    public int MageMenu(MageClass mage){
        System.out.println(mage.name + "님의 공격 차례입니다.");
        System.out.println("어떤 공격을 하시겠어요?");
        System.out.printf("1) 지팡이 공격(데미지 : %d) ", mage.MagicAttack);
        int iTemp = mage.HaveSkillList.get(0).Add_MagicAttack;
        System.out.printf("2) %s <데미지 %d> ", mage.HaveSkillList.get(0).SkillName,iTemp + mage.MagicAttack);
        iTemp = mage.HaveSkillList.get(1).Add_MagicAttack;
        System.out.printf("3) %s <데미지 %d> ", mage.HaveSkillList.get(1).SkillName,iTemp + mage.MagicAttack);
        iTemp = mage.HaveSkillList.get(2).Add_MagicAttack;
        System.out.printf("4) %s <데미지 %d> ", mage.HaveSkillList.get(2).SkillName,iTemp + mage.MagicAttack);
        iTemp = mage.HaveSkillList.get(3).Add_MagicAttack;
        System.out.printf("5) %s <데미지 %d> \n", mage.HaveSkillList.get(3).SkillName,iTemp + mage.MagicAttack);
        System.out.println(":");
        int Result = sc.nextInt();
        return Result;
    }
}
