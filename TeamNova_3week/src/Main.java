import java.util.Scanner;



public class Main {
    static int 가로 = 0;
    static int 세로 = 0;
    static int 반지름 = 0;
    static int 원_정확도 = 0;
    static int 사이즈_평균 = 0;

    public static void type_Diamond() {
        Scanner sc = new Scanner(System.in);
        System.out.println("다이아몬드 크기는 몇으로 선택하시겠습니까??");
        System.out.println("다이아몬드 높이 :");

        int 다이아몬드_크기 = sc.nextInt();

        if ((다이아몬드_크기 % 2) == 0) {
            다이아몬드_크기++;
            가로 = 다이아몬드_크기;
            세로 = 다이아몬드_크기;
        }else if(다이아몬드_크기 == 1){
            다이아몬드_크기 = 3;
            가로 = 다이아몬드_크기;
            세로 = 다이아몬드_크기;
        }else{
            가로 = 다이아몬드_크기;
            세로 = 다이아몬드_크기;
        }

        System.out.println("높이 :" + 세로);

        사이즈_평균 = (가로 + 세로) / 2;
        if (사이즈_평균 < 500) {
            System.out.println("다이아몬드 크기는 가로 : " + 가로 + " 세로 : " + 세로 + " 입니다.");
        } else{
            System.out.println("사이즈가 500을 초과했습니다, 원하는 모양이 나오지 않을수도 있습니다.");
        }
        // 가로
        char[][] arrDiamond = new char[가로][세로];
        //사이즈 = 사이즈/2;
        // 해상도 전시
        for (int y = 0; y < 세로; y++) {
            for (int x = 0; x < 가로; x++) {
                arrDiamond[y][x] = '◻';
            }
        }
        int y = 0;
        for (y = 0; y < (가로 / 2) + 1; y++) {
            // FillOut = 점의 색칠 X
            int FillOut = (가로 / 2) - 1;
            int x = 0;
            for (; FillOut >= y; x++) {
                arrDiamond[y][x] = '◻';
                FillOut--;
            }
            // FillIn = 점의 색칠 O
            for (int FillIn = 0; FillIn < (2 * y) + 1; FillIn++) {
                arrDiamond[y][x] = '◼';
                x++;
            }
        }
        int k = (가로 / 2);
        for (; y < 가로; y++) {
            int FillOut = (가로 / 2) + 1;
            int x = 0;
            for (; y >= FillOut; x++) {
                arrDiamond[y][x] = '◻';
                FillOut++;
            }
            // FillIn = 점의 색칠 O
            // k번째 색칠되는 곳
            for (int FillIn = 0; FillIn < (2 * k) - 1; FillIn++) {
                arrDiamond[y][x] = '◼';
                x++;
            }
            k--;
        }
        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < 가로; j++) {
                System.out.print(arrDiamond[i][j]);
            }
            System.out.print("\n");
        }

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
        for (int y = 0; y < 세로; y++) {
            for (int x = 0; x < 가로; x++) {
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


    public static void type_Star(){
        Scanner sc = new Scanner(System.in);
        System.out.println("별 모양의 높이는 몇으로 선택하시겠습니까??");
        System.out.println("별 모양 높이 :");

        // 크기 = 높이 지정

        int 세로 = sc.nextInt();
        if(세로 < 15){
            세로 = 15;
        }
        int 가로 = 세로*2;

        char arrayStar[][] = new char[세로][가로];

        for (int y = 0; y < 세로; y++) {
            for (int x = 0; x < 가로; x++) {
                arrayStar[y][x] = '◻';
            }
        }
//==================================================================================================
        // 영역 1 : 상단 삼각형
        int 상단_높이 = (세로/2);
        int 백돌 = (가로/2)-1;
        int 흑돌_개수 = 1;
        for(int y=0; y < (상단_높이-2); y++){
            // 빈 공간 개수
            int x = 0;
            for(;x < 백돌; x++){
                arrayStar[y][x] = '◻';
            }

            // 흑돌의 개수
            for(int 흑돌 = 0;흑돌 < 흑돌_개수; 흑돌++){
                arrayStar[y][x] = '◼';
                x++;
            }
            흑돌_개수 = 흑돌_개수 + 2;
            백돌--;
        }
//==================================================================================================
        // 영역 2 : 중단 사다리꼴
        int 가로_흑돌 = 가로;
        int 흑돌_시작점 = 0;
        for(int y = 상단_높이-2; y < (세로-상단_높이)+2; y++){
            for(int x = 흑돌_시작점; x < 가로_흑돌; x++){
                arrayStar[y][x] = '◼';

            }
            가로_흑돌 = 가로_흑돌 - 2;
            흑돌_시작점 = 흑돌_시작점 + 2;
        }

//==================================================================================================
        // 영역 3 : 하단 좌측 삼각형
        int 좌_흑돌 = (가로/2)-1;
        for(int y = 상단_높이 + 2; y < 세로; y++){
            for(int x = (가로/4); x < 좌_흑돌; x++){
                arrayStar[y][x] = '◼';
            }
            좌_흑돌 = 좌_흑돌 - 1;
        }

//==================================================================================================
        // 영역 4 : 하단 우측 삼각형
        int 우_흑돌 = 가로-1;
        int 우_흑돌_위치 = (가로/2);
        for (int y = 상단_높이 + 2; y < 세로; y++) {
            for (int x = 우_흑돌_위치; x < (우_흑돌-(가로/4)); x++) {
                arrayStar[y][x] = '◼';
            }
            우_흑돌_위치 = 우_흑돌_위치 + 1;
        }
//==================================================================================================
        // 배열 전체 출력
        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < (가로); j++) {
                System.out.print(arrayStar[i][j]);
            }
            System.out.print("\n");
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
        System.out.println("1) 다이아몬드 2)원 3) 별");
        System.out.println(":");
        int 타입 = sc.nextInt();

            switch (타입){
                // 다이아몬드
                case 1:
                    type_Diamond();
                    break;
                case 2:
                    type_Circle();
                    break;
                case 3:
                    type_Star();
                    break;
                default:
                    break;
            }
        }



    }
}