import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("내가 해주는 랜덤 무조건 요리 먹기!");
        System.out.println("============================");
        System.out.println("요리 메뉴를 고르시오!");
        System.out.println("1) 라면  2) 파스타 3)쫄면");
        System.out.println(":");

        Scanner sc = new Scanner(System.in);
        Random rValue = new Random();


        int FoodMenu = sc.nextInt();

        System.out.println("================================================");
        if (FoodMenu == 1)
        {
            System.out.println("오오! 오늘은 라면이구만~ 만들어볼까?");
        }
        else if (FoodMenu == 2)
        {
            System.out.println("와우! 파스타~! 만들어볼까?");
        }
        else
        {
            System.out.println("쫄면은 좀 별로지만 만들어볼까?");
        }

        System.out.println("================================================");
        System.out.println("물 온도는 어떻게 하지?");
        System.out.println("1) 100℃ 2) 50℃ 3) 0℃");
        System.out.println(":");
        int WaterTemperature = sc.nextInt();

        if(WaterTemperature == 1)
        {
            System.out.println("흐흐흐 면이 잘 익고 있구만");
        }
        else if(WaterTemperature == 2)
        {
            System.out.println("이건 좀 아닌 것 같은데?");
        }
        else
        {
            System.out.println("요리를 하는게 맞아?");
        }

        System.out.println("================================================");
        System.out.println("양념은 뭘로 하지?");
        System.out.println("1) 라면 스프 2) 파스타 소스 3)쫄면 소스");
        System.out.println(":");
        int Spicy = sc.nextInt();
        int RightFood = 0;

        if(Spicy == 1 && FoodMenu == 1)
        {
            if (WaterTemperature == 1)
            {
                System.out.println("음~ 맛있는 라면이 만들어지고 있어");
                RightFood = 1;
            } else
            {
                System.out.println("라면을 만들려고 했는데? 이상한 무언가가 만들어지고 있어");
            }
        }
        else if(Spicy == 2 && FoodMenu == 2)
        {
            if(WaterTemperature == 1)
            {
                System.out.println("음~ 맛있는 파스타가 만들어지고 있어");
                RightFood = 2;
            }
            else
            {
                System.out.println("파스타를 만들려고 했는데? 넌 뭐니?");
            }
        }
        else if(Spicy == 3 && FoodMenu == 3)
        {
            if(WaterTemperature == 1)
            {
                System.out.println("쫄면은 기대는 안했지만 막상 만드니 맛나겠구만~!");
                RightFood = 3;
            }
            else
            {
                System.out.println("분명 시작은 쫄면이었을 텐데...");
            }
        }

        System.out.println("================================================");
        System.out.println("이제 마지막 재료를 넣을 차례야, 지금부터 게임을 시작하지");
        System.out.println("1) 계란 2) 파슬리 가루 3) 참기름 4) 식초");
        System.out.println(":");
        int rLuckyItem = rValue.nextInt(4) +1;

        if(rLuckyItem == 1)
        {
            if(RightFood == 1)
            {
                System.out.println("딱 내가 원하던 라면이 만들어졌어, 잘먹겠습니다");
                System.out.println("Happy Day~~~~");
            }
            else if(RightFood == 2)
            {
                System.out.println("파스타에 계란이라니 별로 나쁘지는 않은 선택이군");
                System.out.println("Happy Day~~~~");
            }
            else if(RightFood == 3)
            {
                System.out.println("쫄면에 삶은 계란이라니 베스트하군");
                System.out.println("Happy Day~~~~");
            }
            else
            {
                System.out.println("자신의 요리실력에 부족함이 많음을 깨닫고 공부하도록 하자");
                System.out.println("Bad Day~~~~~~");
            }
        }
        else if(rLuckyItem == 2)
        {
            if(RightFood == 1)
            {
                System.out.println("라면에 파슬리? 뭐 나쁘지는 않네");
                System.out.println("Happy Day~~~~");
            }
            else if(RightFood == 2)
            {
                System.out.println("파스타에 화룡점정 파슬리라니 굳~");
                System.out.println("Happy Day~~~~");
            }
            else if(RightFood == 3)
            {
                System.out.println("쫄면에 파슬리? 한식과 양식의 조화야?");
                System.out.println("Happy Day~~~~");
            }
            else
            {
                System.out.println("한계를 몰랐던 나는 요리의 벽을 느끼게 되었다");
                System.out.println("Bad Day~~~~~~");
            }
        }
        else if(rLuckyItem == 3)
        {
            if(RightFood == 1)
            {
                System.out.println("라면에 파슬리? 뭐 나쁘지는 않네");
                System.out.println("Happy Day~~~~");
            }
            else if(RightFood == 2)
            {
                System.out.println("파스타에 화룡점정 파슬리라니 굳~");
                System.out.println("Happy Day~~~~");
            }
            else if(RightFood == 3)
            {
                System.out.println("쫄면에 파슬리? 한식과 양식의 조화야?");
                System.out.println("Happy Day~~~~");
            }
            else
            {
                System.out.println("한계를 몰랐던 나는 요리의 벽을 느끼게 되었다");
                System.out.println("Bad Day~~~~~~");
            }
        }
        else {
            System.out.println("아... 식초를 잘못넣었다....");
        }

        System.out.println("==================================");
        System.out.println("나온 음식을 먹을꺼야? 먹는다? 안먹는다?");
        System.out.println(":");
        String strLastComment = sc.next();
        if(strLastComment.equals("먹는다"))
        {
            if(RightFood == 0)
            {
                System.out.println("이걸 먹겠다고? 누굴 탓해 내손을 탓해야지");
            }
            else
            {
                System.out.println("오늘도 행복한 밥타임~~~~~ 잘 먹겠습니다.");
            }
        }
        else if(strLastComment.equals("안먹는다"))
        {
            if(RightFood == 0)
            {
                System.out.println("그래... 오늘은 그냥 굶자");
            }
            else
            {
                System.out.println("아주 그냥 재벌 나셨어? 안그래?");
            }
        }
        else
        {
            System.out.println("뭐라는거야? 확실하게 말해");
        }

    }
}