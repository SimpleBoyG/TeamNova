package Hunting;

import java.util.Scanner;

public class HuntingMenu {

    public int HuntingStartMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("어떤 행동을 취하겠습니까?");
        System.out.println("1) 사냥하러 간다. 2) 파티 설정은 수정한다. ");
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
}
