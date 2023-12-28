import java.util.Scanner;



public class Main {
    static int 가로 = 0;
    static int 세로 = 0;
    static int 반지름 = 0;
    static int 원_정확도 = 0;
    static int 사이즈_평균 = 0;
    public static void type_Diamond(short 가로, short 세로){
        // 가로
        char[][] arrCircle = new char[가로][세로];

//


//        사이즈 = 사이즈/2;
//        for(int i=0; i<사이즈+1; i++) {
//
//            for(int j = 사이즈; j>i; j--) {
//                System.out.print(" ");
//            }
//
//            for(int k=0; k<(2*i)+1; k++) {
//                System.out.print("*");
//            }
//            System.out.println(" ");
//        }
//
//        int 다음단계_사이즈 = 사이즈;
//        for(int i = 0; i<사이즈; i++)
//        {
//            for(int j= 0; j<=i; j++) {
//                System.out.print(" ");
//            }
//
//            for(int k = 0; k<(2*다음단계_사이즈)-1; k++) {
//                System.out.print("*");
//            }
//            System.out.println(" ");
//            다음단계_사이즈--;
//        }
    }


    public static void type_Circle(){

        Scanner sc = new Scanner(System.in);

        // 해상도의 크기는 최소 가로, 세로 50
        boolean 반복문_OK = true;


        byte 오류_타입 = 0;
        System.out.println("해상도 크기는 몇으로 선택하시겠습니까??");
        System.out.println("(해상도 가로, 세로의 크기는 50 ~ 100 사이의 숫자입니다.)");

        System.out.println("가로 :");
        가로 = sc.nextInt();
        System.out.println("세로 :");
        세로 = sc.nextInt();

        사이즈_평균 = (가로+세로)/2;

        if (사이즈_평균 < 100) {
            System.out.println("해상도는 가로 : " + 가로 + " 세로 : " + 세로 + " 입니다.");
        } else {
            type_Error( 1);
        }

        if (오류_타입 == 0) {
            System.out.println("반지름 길이를 설정해주세요");
            System.out.println("(반지름의 길이는 해상도의 가로,세로의 크기보다 작은 수 입니다.)");
            System.out.println("반지름 : ");
            반지름 = sc.nextInt();

            if (반지름 < 가로 && 반지름 < 세로) {
                System.out.println("반지름의 길이 : " + 반지름);
            } else {
                type_Error( 2);
            }
        }

        if(오류_타입 == 0){
            System.out.println("원의 정확도 값을 설정해주세요");
            System.out.println("(원의 정확도 값은 0 ~ 반지름의 제곱 입니다.");
            System.out.println("원의 정확도 : ");
            원_정확도 = sc.nextInt();
            if(원_정확도 > 0 && 원_정확도 < (반지름*반지름)){
                System.out.println("원의 정확도 : " + 원_정확도);
            } else {
                type_Error( 3);
            }

        }


        가로++;
        세로++;
        char[][] arrCircle = new char[가로][세로];

        //int 반지름 = 30;
        for (int x = 0; x < 가로; x++) {
            for (int y = 0; y < 세로; y++) {
                int Value = (x-(가로/2))*(x-(가로/2)) + (y-(세로/2))*(y-(세로/2));
                int 반지름_제곱 = (반지름*반지름);
                if(Value < 반지름_제곱 + 원_정확도 && (Value > 반지름_제곱 - 원_정확도)  ) {
                    arrCircle[x][y] = '◼';
                    System.out.print(arrCircle[x][y]);
                }else{
                    arrCircle[x][y] = '◻';
                    System.out.print(arrCircle[x][y]);
                }
            }
            System.out.println(" ");
        }


    }


    public static void type_Error(int 오류_타입){
        Scanner sc = new Scanner(System.in);
        switch (오류_타입) {
            case 1:
                while (사이즈_평균 > 100) {

                    System.out.println("해상도 크기를 다시 선택하여 주세요.");
                    System.out.println("해상도 크기는 몇으로 선택하시겠습니까??");
                    System.out.println("(해상도 가로, 세로의 크기는 50 ~ 100 사이의 숫자입니다.)");

                    System.out.println("가로 :");
                    가로 = sc.nextInt();
                    System.out.println("세로 :");
                    세로 = sc.nextInt();
                    사이즈_평균 = (가로 + 세로) / 2;
                }
                System.out.println("해상도는 가로 : " + 가로 + " 세로 : " + 세로 + " 입니다.");
                break;
            case 2:
                while (반지름 > 가로 || 반지름 > 세로) {
                    System.out.println("반지름의 길이를 다시 설정해주세요.");
                    System.out.println("(반지름의 길이는 해상도의 가로,세로의 크기보다 작은 수 입니다.)");
                    System.out.println("반지름 : ");
                    반지름 = sc.nextInt();
                }
                System.out.println("반지름의 길이 : " + 반지름);

            case 3:
                while (원_정확도 < 0 || 원_정확도 > (반지름*반지름)){
                    System.out.println("원의 정확도 값을 설정해주세요");
                    System.out.println("(원의 정확도 값은 0 ~ 반지름의 제곱 입니다.");

                    원_정확도 = sc.nextInt();
                    System.out.println("원의 정확도 : " + 원_정확도);
                }
                System.out.println("원의 정확도 : " + 원_정확도);
                break;
        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
        System.out.println("어떤 타입을 선택하시겠습니까??");
        System.out.println("1) 다이아몬드 2)원");
        System.out.println(":");
        int 타입 = sc.nextInt();

            switch (타입){
                // 다이아몬드
                case 1:
                    //type_Diamond(사이즈);
                    break;
                case 2:
                    type_Circle();
                    break;
            }
        }



    }
}