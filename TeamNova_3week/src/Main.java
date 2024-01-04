import java.util.*;


public class Main {
    static int 가로 = 0;
    static int 세로 = 0;
    static int 반지름 = 0;
    static int 원_정확도 = 0;
    static int 사이즈_평균 = 0;

    public static void type_Diamond() {
        System.out.println("""
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
                @@'||'''|. |''||''|      /.\\      '||\\   /||` .|''''|, '||\\\\    ||` '||'''|.   @@
                @@ ||   ||    ||        // \\\\      || \\.//||  ||    ||  || \\\\   ||   ||   ||   @@
                @@ ||   ||    ||       //...\\\\     ||     ||  ||    ||  ||  \\\\  ||   ||   ||   @@
                @@ ||   ||    ||      //     \\\\    ||     ||  ||    ||  ||   \\\\ ||   ||   ||   @@
                @@.||...|' |..||..| .//       \\\\. .||     ||. `|....|' .||    \\\\||. .||...|'   @@
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                """);
        Scanner sc = new Scanner(System.in);
        System.out.println("다이아몬드 크기는 몇으로 선택하시겠습니까??");
        System.out.println("다이아몬드 높이 :");

        int 다이아몬드_크기 = sc.nextInt();

        if ((다이아몬드_크기 % 2) == 0) {
            다이아몬드_크기++;
            가로 = 다이아몬드_크기;
            세로 = 다이아몬드_크기;
        } else if (다이아몬드_크기 == 1) {
            다이아몬드_크기 = 3;
            가로 = 다이아몬드_크기;
            세로 = 다이아몬드_크기;
        } else {
            가로 = 다이아몬드_크기;
            세로 = 다이아몬드_크기;
        }

//        System.out.println("높이 :" + 세로);

        사이즈_평균 = (가로 + 세로) / 2;
//        if (사이즈_평균 < 500) {
//            System.out.println("다이아몬드 크기는 가로 : " + 가로 + " 세로 : " + 세로 + " 입니다.");
//        } else{
//            System.out.println("사이즈가 500을 초과했습니다, 원하는 모양이 나오지 않을수도 있습니다.");
//        }
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

    public static void type_Circle() {

        System.out.println("""
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
                @@.|'''', |''||''| '||'''|, .|'''', '||     '||''''| @@
                @@||         ||     ||   || ||       ||      ||   .  @@
                @@||         ||     ||...|' ||       ||      ||'''|  @@
                @@||         ||     || \\    ||       ||      ||      @@
                @@`|....' |..||..| .||  \\.  `|....' .||...| .||....| @@
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                """);
        Scanner sc = new Scanner(System.in);

        // 해상도의 크기는 최소 가로, 세로 50


//        byte 오류_타입 = 0;
//        System.out.println("원의 높이는?");
//        System.out.println(":");
        System.out.println("반지름의 길이는?");
        System.out.println(":");
        반지름 = sc.nextInt();
        원_정확도 = (반지름 * 반지름) / 4;

        가로 = 반지름 * 2 + 20;//sc.nextInt();
        세로 = 반지름 * 2 + 20;//sc.nextInt();

//        사이즈_평균 = (가로+세로)/2;

//        if (사이즈_평균 < 100) {
//            System.out.println("원의 높이는 : " + 사이즈_평균 + " 입니다.");
//        } else {
//            type_Error( 1);
//        }

//        if (오류_타입 == 0) {
//            System.out.println("반지름 길이를 설정해주세요");
//            System.out.println("(반지름의 길이는 해상도의 가로,세로의 크기보다 작은 수 입니다.)");
//            System.out.println("반지름 : ");
//            반지름 = sc.nextInt();
//
//            if (반지름 < 가로 && 반지름 < 세로) {
//                System.out.println("반지름의 길이 : " + 반지름);
//            } else {
//                type_Error( 2);
//            }
//        }

//        if(오류_타입 == 0){
//            System.out.println("원의 정확도 값을 설정해주세요");
//            System.out.println("(원의 정확도 값은 0 ~ 반지름의 제곱 입니다.");
//            System.out.println("원의 정확도 : ");
//            원_정확도 = sc.nextInt();
//            if(원_정확도 > 0 && 원_정확도 < (반지름*반지름)){
//                System.out.println("원의 정확도 : " + 원_정확도);
//            } else {
//                type_Error( 3);
//            }
//
//        }

        char[][] arrCircle = new char[가로][세로];


        //int 반지름 = 30;
        for (int y = 0; y < 세로; y++) {
            for (int x = 0; x < 가로; x++) {
                int Value = (x - (가로 / 2)) * (x - (가로 / 2)) + (y - (세로 / 2)) * (y - (세로 / 2));
                int 반지름_제곱 = (반지름 * 반지름);
                if ((Value < 반지름_제곱 + 원_정확도) && (Value > 반지름_제곱 - 원_정확도)) {
                    //if((Value == 반지름_제곱)) {
                    arrCircle[x][y] = '◼';
                    System.out.print(arrCircle[x][y]);
                } else {
                    arrCircle[x][y] = '◻';
                    System.out.print(arrCircle[x][y]);
                }
            }
            System.out.println(" ");
        }


    }


    public static void type_Star() {
        System.out.println("""
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
                @@.|'''|  |''||''|      /.\\      '||'''|,  @@
                @@||         ||        // \\      ||   ||   @@
                @@`|'''|,    ||       //...\\     ||...|'   @@
                @@ .   ||    ||      //     \\    || \\      @@
                @@ |...|'   .||.   .//       \\. .||  \\.    @@
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                """);

        Scanner sc = new Scanner(System.in);
        System.out.println("별 모양의 높이는 몇으로 선택하시겠습니까??");
        System.out.println("별 모양 높이 :");

        // 크기 = 높이 지정

        int 세로 = sc.nextInt();
        if (세로 < 6) {
            세로 = 7;
        }
        int 가로 = 세로;

        char arrayStar[][] = new char[세로][가로];

        for (int y = 0; y < 세로; y++) {
            for (int x = 0; x < 가로; x++) {
                arrayStar[y][x] = '◻';
            }
        }
//==================================================================================================
        // 영역 1 : 1번 삼각형
        /*
            ◼
            ◼ ◼
            ◼ ◼ ◼
            ◼ ◼
            ◼
        */
        int 흑돌1 = 세로;
        int 흑돌_위치1 = 0;
        for (int x = (가로 / 3) - 1; 1 <= 흑돌1; x++) {
            ;
            for (int y = 흑돌_위치1; y < 흑돌1; y++) {
                arrayStar[y][x] = '◼';
            }
            흑돌_위치1++;
            흑돌1--;
        }

//==================================================================================================
// 영역 2 : 2번 삼각형
        /*
            ◻ ◻ ◼
            ◻ ◼ ◼
            ◼ ◼ ◼
            ◻ ◼ ◼
            ◻ ◻ ◼
        */
        int 흑돌2 = 세로;
        int 흑돌_위치2 = 0;
        for (int x = (가로 - (가로 / 3)); 1 <= 흑돌2; x--) {
            ;
            for (int y = 흑돌_위치2; y < 흑돌2; y++) {
                arrayStar[y][x] = '◼';
            }
            흑돌_위치2++;
            흑돌2--;
        }

//==================================================================================================
// 영역 3 : 3번 삼각형
        /*

            ◻ ◻ ◻ ◻ ◻
            ◼ ◼ ◼ ◼ ◼
            ◻ ◼ ◼ ◼ ◻
            ◻ ◻ ◼ ◻ ◻
            ◻ ◻ ◻ ◻ ◻

        */
        int 흑돌3 = 가로;
        int 흑돌_위치3 = 0;
        for (int y = (세로 / 3); 1 <= 흑돌3; y++) {
            ;
            for (int x = 흑돌_위치3; x < 흑돌3; x++) {
                arrayStar[y][x] = '◼';
            }
            흑돌_위치3++;
            흑돌3--;
        }

//==================================================================================================
// 영역 3 : 3번 삼각형
        /*
            ◻ ◻ ◻ ◻ ◻
            ◻ ◻ ◼ ◻ ◻
            ◻ ◼ ◼ ◼ ◻
            ◼ ◼ ◼ ◼ ◼
            ◻ ◻ ◻ ◻ ◻
        */
        int 흑돌4 = 가로;
        int 흑돌_위치4 = 0;
        for (int y = 세로 - (세로 / 3); 1 <= 흑돌4; y--) {
            ;
            for (int x = 흑돌_위치4; x < 흑돌4; x++) {
                arrayStar[y][x] = '◼';
            }
            흑돌_위치4++;
            흑돌4--;
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


    public static void type_Error(int 오류_타입) {
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
                while (원_정확도 < 0 || 원_정확도 > (반지름 * 반지름)) {
                    System.out.println("원의 정확도 값을 설정해주세요");
                    System.out.println("(원의 정확도 값은 0 ~ 반지름의 제곱 입니다.");

                    원_정확도 = sc.nextInt();
                    System.out.println("원의 정확도 : " + 원_정확도);
                }
                System.out.println("원의 정확도 : " + 원_정확도);
                break;
        }

    }

    public static void type_FiveStar1() {
        int 세로 = 21;
        int 가로 = 21 * 2;

        char arrayStar[][] = new char[세로][가로];

        //==================================================================================================
        // 배열 전체 흑돌화
        for (int y = 0; y < 세로; y++) {
            for (int x = 0; x < 가로; x++) {
                arrayStar[y][x] = '◼';
            }
        }

        //==================================================================================================
        // 좌측 삼각형 1
        int 백돌1 = 세로 - 2;
        int 백돌_위치1 = 2;
        for (int x = 0; x < (가로 / 2); x = x + 2) {
            for (int y = 백돌_위치1; y < 백돌1; y++) {
                arrayStar[y][x] = '◻';
                arrayStar[y][x + 1] = '◻';
            }

            백돌_위치1 = 백돌_위치1 + 1;
            백돌1 = 백돌1 - 1;
        }

        //==================================================================================================
        // 우측 삼각형 2
        int 백돌2 = 세로 - 2;
        int 백돌_위치2 = 2;
        for (int x = 가로 - 1; x > (가로 / 2); x = x - 2) {
            for (int y = 백돌_위치2; y < 백돌2; y++) {
                arrayStar[y][x] = '◻';
                arrayStar[y][x - 1] = '◻';
            }

            백돌_위치2 = 백돌_위치2 + 1;
            백돌2 = 백돌2 - 1;
        }

        //==================================================================================================
        // 아래 삼각형 3
        int 백돌3 = 가로 - 2;
        int 백돌_위치3 = 2;
        for (int y = 세로 - 1; y > (세로 / 2); y--) {
            for (int x = 백돌_위치3; x < 백돌3; x = x + 2) {
                arrayStar[y][x] = '◻';
                arrayStar[y][x + 1] = '◻';
            }

            백돌_위치3 = 백돌_위치3 + 2;
            백돌3 = 백돌3 - 2;
        }

        //==================================================================================================
        // 위 좌측 삼각형 4_1
        int 백돌4_1 = (가로 / 3);
        int 백돌4_2 = (가로 / 2) - 1;
        int 백돌_위치4_1 = 2;
        int 백돌_위치4_2 = 백돌4_1;
        for (int y = 0; y < (세로 / 3); y++) {
            for (int x = 백돌_위치4_1; x < 백돌4_1; x = x + 2) {
                arrayStar[y][x] = '◻';
                arrayStar[y][x + 1] = '◻';
            }
            백돌_위치4_1 = 백돌_위치4_1 + 2;
            for (int x = 백돌_위치4_2; x < 백돌4_2; x++) {
                arrayStar[y][x] = '◻';
            }
            백돌4_2--;
        }

        //==================================================================================================
        // 위 우측 삼각형 5_1
        int 백돌5_1 = (가로 / 3) * 2;
        int 백돌5_2 = (가로 / 2);
        int 백돌_위치5_1 = 가로 - 3;
        int 백돌_위치5_2 = 백돌5_1;
        for (int y = 0; y < (세로 / 3); y++) {
            for (int x = 백돌_위치5_1; x > 백돌5_1; x = x - 2) {
                arrayStar[y][x] = '◻';
                arrayStar[y][x - 1] = '◻';
            }
            백돌_위치5_1 = 백돌_위치5_1 - 2;

            for (int x = 백돌_위치5_2; x > 백돌5_2; x--) {
                arrayStar[y][x] = '◻';
            }
            백돌5_2++;
        }

        //==================================================================================================
        // 위 좌측 삼각형 4_1
//        int 백돌4_1  = 가로-1;
//        int 백돌_위치4_1 = 1;
//        for (int y = 세로-1; y > (세로/2); y--) {
//            for (int x = 백돌_위치3; x < 백돌3; x=x+2) {
//                arrayStar[y][x] = '◻';
//                arrayStar[y][x+1] = '◻';
//            }
//
//            백돌_위치3 = 백돌_위치3 + 2;
//            백돌3 = 백돌3 - 2;
//        }

        //==================================================================================================
        // 배열 전체 출력
        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < (가로); j++) {
                System.out.print(arrayStar[i][j]);
            }
            System.out.print("\n");
        }

    }


    public static void type_FiveStar2() {

        System.out.println("""
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
                @@.|'''|  |''||''|      /.\\      '||'''|,  @@
                @@||         ||        // \\      ||   ||   @@
                @@`|'''|,    ||       //...\\     ||...|'   @@
                @@ .   ||    ||      //     \\    || \\      @@
                @@ |...|'   .||.   .//       \\. .||  \\.    @@
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                """);

        Scanner sc = new Scanner(System.in);
        System.out.println("별의 높이는??");
        System.out.println(":");
        int 세로 = sc.nextInt();
        int 가로 = (세로 * 2) + 1;


        char arrayStar[][] = new char[세로][가로];
        //==================================================================================================
        // 배열 전체 백돌화
        for (int y = 0; y < 세로; y++) {
            for (int x = 0; x < 가로; x++) {
                arrayStar[y][x] = '◻';
            }
        }

        //==================================================================================================
        // 상단 윗 삼각형 1
        int 흑돌_위치1 = 가로 / 2;

        for (int y = 0; y < (세로 / 3); y++) {
            int 흑돌1 = 0;
            for (int x = 흑돌_위치1; 흑돌1 < (2 * y) + 1; x++) {
                arrayStar[y][x] = '◼';
                흑돌1++;
            }
            흑돌_위치1--;
        }

        //==================================================================================================
        // 중단 사다리꼴 2
        int 흑돌_위치2 = 0;
        int 흑돌2 = 가로;
        int 사다리꼴_높이 = ((세로 / 3) * 2);
        for (int y = (세로 / 3); y < 사다리꼴_높이; y++) {
            for (int x = 흑돌_위치2; x < 흑돌2; x++) {
                arrayStar[y][x] = '◼';
//                if (y == 사다리꼴_높이 - 1) {
//                    arrayStar[y + 1][x] = '◼';
//                }
            }
            흑돌2--;
            흑돌_위치2++;
        }

        //==================================================================================================
        // 하단 좌측 삼각형 3
        int 흑돌_위치3 = 0;
        int 흑돌3 = 2;
        int 삼각형_높이1 = 사다리꼴_높이 - 1;
        for (int y = 세로 - 1; y > 삼각형_높이1; y--) {
            for (int x = 흑돌_위치3; x < 흑돌3; x++) {
                arrayStar[y][x] = '◼';
            }
            흑돌3 = 흑돌3 + 4;
            흑돌_위치3++;
        }

        //==================================================================================================
        // 하단 우측 삼각형 4
        int 흑돌_위치4 = 가로 - 1;
        int 흑돌4 = (가로 - 3);
        int 삼각형_높이2 = 사다리꼴_높이 - 1;
        for (int y = 세로 - 1; y > 삼각형_높이2; y--) {
            for (int x = 흑돌_위치4; x > 흑돌4; x--) {
                arrayStar[y][x] = '◼';
            }
            흑돌4 = 흑돌4 - 4;
            흑돌_위치4--;
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

    public static void type_Sudoku1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("개수를 입력하세요.");
        System.out.println(":");
        int 스도쿠_개수 = sc.nextInt();
        Random rd = new Random();
        //int arraySudoku[][] = new int[스도쿠_개수][스도쿠_개수];
        int arraySudoku[][] = new int[스도쿠_개수][스도쿠_개수];


        long StartTime = System.currentTimeMillis();

        for (int y = 0; y < 스도쿠_개수; y++) {
            for (int x = 0; x < 스도쿠_개수; x++) {
                arraySudoku[y][x] = rd.nextInt(스도쿠_개수) + 1;

                for (int z = 0; z < x; z++) {
                    if (arraySudoku[y][x] == arraySudoku[y][z]) {
                        x--;
                    }
                }

                for (int z = 0; z < y; z++) {
                    if (arraySudoku[y][x] == arraySudoku[z][x]) {
                        y--;
                    }
                }
            }
        }
        for (int y = 0; y < 스도쿠_개수; y++) {
            for (int x = 0; x < 스도쿠_개수; x++) {
                if(String.valueOf(arraySudoku[y][x]).length() == 1) {
                    System.out.print("  "+arraySudoku[y][x]+" ");
                }else{
                    System.out.print("  "+arraySudoku[y][x]);
                }
            }
            System.out.println();
        }

        long EndTime = System.currentTimeMillis();
        System.out.println("걸린시간: " + ((EndTime - StartTime) / 1000) + " 초");
    }

    public static void type_Sudoku2() {
        Scanner sc = new Scanner(System.in);

        System.out.println("개수를 입려해주세요.");
        System.out.println(":");
        int 스도쿠_개수 = sc.nextInt();

        Random rd = new Random();

        int arraySudoku[][] = new int[스도쿠_개수][스도쿠_개수];

        long StartTime = System.currentTimeMillis(); // 시작 시간

        searchNum(스도쿠_개수, 0, 0, arraySudoku);

        for (int y = 0; y < 스도쿠_개수; y++) {
            for (int x = 0; x < (스도쿠_개수); x++) {
                if(String.valueOf(arraySudoku[y][x]).length() == 1) {
                    System.out.print("  "+arraySudoku[y][x]+" ");
                }else{
                    System.out.print("  "+arraySudoku[y][x]);
                }
            }
            System.out.println();
        }

        long EndTime = System.currentTimeMillis();
        System.out.println("걸린시간: " + (EndTime - StartTime) + " ms");
    }

    public static Set<Integer> shuffles(int 스도쿠_개수){
        int arrayNums[] = new int[스도쿠_개수];

        for(int i = 0; i < 스도쿠_개수; i++){
            arrayNums[i] = i + 1;
        }

        Random rd = new Random();
        for(int i = 스도쿠_개수 - 1; i >= 0; i--){
            int picked = rd.nextInt(i+1); // 인덱스를 추출
            int tmpNum = arrayNums[picked];
            arrayNums[picked] = arrayNums[i];
            arrayNums[i] = tmpNum;
        }

        Set<Integer> shuffleSet = new LinkedHashSet<>();
        for(int i = 0; i<arrayNums.length; i++){
            shuffleSet.add(arrayNums[i]);
        }

        return shuffleSet;
    }
    public static Boolean searchNum(int 스도쿠_개수, int x, int y, int arraySudoku[][]) {

        if (y == 스도쿠_개수) {
            return true;
        }
        // array 스도쿠의 현재 x,y로 부터 위 상단에 값들
        Set<Integer> collectedNums = shuffles(스도쿠_개수);

        for (int prevY = y - 1; prevY >= 0; prevY--) {
            collectedNums.remove(arraySudoku[prevY][x]);
        }
        for (int prevX = x - 1; prevX >= 0; prevX--) {
            collectedNums.remove(arraySudoku[y][prevX]);
        }

        for (Iterator<Integer> iter = collectedNums.iterator(); iter.hasNext(); ) {
            arraySudoku[y][x] = iter.next();

            if (x + 1 < 스도쿠_개수) {
                if (searchNum(스도쿠_개수, x + 1, y, arraySudoku)) {
                    return true;
                }
            } else {
                if (searchNum(스도쿠_개수, 0, y + 1, arraySudoku)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void type_Sudoku3() {
        int size = 0;
        int rand;
        Random random = new Random(System.currentTimeMillis());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("숫자를 입력하세요(2이상)");
            size = sc.nextInt();
            if (size < 2) {
                System.out.println("2이상 숫자를 입력해주세요");
            } else {
                break;
            }
        }

        //2차원 배열 size크기로 생성
        int result[][] = new int[size][size];

        //0으로 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
            }
        }
        //랜덤상수 size만큼 자연수가들어가게함
        rand = random.nextInt(size) + 1;
        int a;
        int b;
        int row;
        int col;
        boolean isSame = true;
        int loopCount = 0;

        long curTime = System.currentTimeMillis();
        System.out.println("시작시간: "+ (curTime / 1000));

        Loop2: while (true) {
            loopCount=0;//초기화

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    row = j; //제이임
                    col = i;    //아이임


                    Loop1:
                    while (true) {
                        rand = random.nextInt(size) + 1;
                        result[i][j] = rand;


                        //기준 왼쪽값들 일치유무검사
                        for (a = row - 1; a >= 0; a--) {
                            while (isSame == true) {


                                if (result[i][j] == result[i][a]) {
                                    isSame = true;
                                    continue Loop1;
                                } else {
                                    isSame = false;
                                }
                            }
                            isSame = true;//빠져나오면 다시 초기화
                        }


                        //기준 위쪽값들 일치유무검사
                        for (b = col - 1; b >= 0; b--) {
                            while (isSame == true) {
                                if (result[i][j] == result[b][j]) {
                                    loopCount++;
                                    if (loopCount > 300) { //마지막에 가까운 값이 가로 세로 겹쳐서 무한루프가 도는 경우가 발생하는데 300번이상 루프를 돌면 처음부터 스도쿠를 짜게한다.
                                        continue Loop2;
                                    }

                                    isSame = true;
                                    continue Loop1;
                                } else {
                                    isSame = false;
                                }
                            }
                            isSame = true;//빠져나오면 다시 초기화
                        }


                        break;
                    }
                }
            }


            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(String.valueOf(result[i][j]).length() == 1) {
                        System.out.print("  "+result[i][j]+" ");
                    }else{
                        System.out.print("  "+result[i][j]);
                    }
                }
                System.out.println();
            }
            long curTime2 = System.currentTimeMillis();
            System.out.println("걸린시간: " + (curTime2 - curTime)+ " ms");

            break ;
        }
    }

    public static void HappyNewYear() {
        System.out.println("""
                ==================================================================================================================================================================
                == _|                                                                                                                                                           ==
                == _|_|_|      _|_|_|  _|_|_|    _|_|_|    _|    _|      _|_|_|      _|_|    _|      _|      _|      _|    _|    _|_|      _|_|_|  _|  _|_|                     ==
                == _|    _|  _|    _|  _|    _|  _|    _|  _|    _|      _|    _|  _|_|_|_|  _|      _|      _|      _|    _|  _|_|_|_|  _|    _|  _|_|                         == 
                == _|    _|  _|    _|  _|    _|  _|    _|  _|    _|      _|    _|  _|          _|  _|  _|  _|        _|    _|  _|        _|    _|  _|                           ==
                == _|    _|    _|_|_|  _|_|_|    _|_|_|      _|_|_|      _|    _|    _|_|_|      _|      _|            _|_|_|    _|_|_|    _|_|_|  _|                           ==
                ==                     _|        _|              _|                                                        _|                                                   ==
                ==                     _|        _|          _|_|                                                      _|_|                                                     ==
                ==                 _|                                                                                                                                           ==
                ==                 _|_|_|      _|_|_|  _|_|_|    _|_|_|    _|    _|      _|_|_|      _|_|    _|      _|      _|      _|    _|    _|_|      _|_|_|  _|  _|_|     ==
                ==                 _|    _|  _|    _|  _|    _|  _|    _|  _|    _|      _|    _|  _|_|_|_|  _|      _|      _|      _|    _|  _|_|_|_|  _|    _|  _|_|         ==
                ==                 _|    _|  _|    _|  _|    _|  _|    _|  _|    _|      _|    _|  _|          _|  _|  _|  _|        _|    _|  _|        _|    _|  _|           ==
                ==                 _|    _|    _|_|_|  _|_|_|    _|_|_|      _|_|_|      _|    _|    _|_|_|      _|      _|            _|_|_|    _|_|_|    _|_|_|  _|           ==
                ==                                     _|        _|              _|                                                        _|                                   ==
                ==                                     _|        _|          _|_|                                                      _|_|                                     ==
                ==                                                                                                                                                              ==
                ==================================================================================================================================================================                 
                """);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //while (true) {
        System.out.println("""
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
                @@    ___  ___  ___   _____  _   _\s      @@
                @@    |  \\/  | / _ \\ |_   _|| \\ | |      @@
                @@    | .  . |/ /_\\ \\  | |  |  \\| |      @@
                @@    | |\\/| ||  _  |  | |  | . ` |      @@
                @@    | |  | || | | | _| |_ | |\\  |      @@
                @@    \\_|  |_/\\_| |_/ \\___/ \\_| \\_/      @@
                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                  """);
        System.out.println("어떤 타입을 선택하시겠습니까??");
        System.out.println("1) 다이아몬드 2)원 3) 별 4) 오각별(타입1) 5)오각별(타입2-과제용) 6) 스도쿠 1차 7) 스도쿠 2차(과제용)");
        System.out.println(":");
        int 타입 = sc.nextInt();

        switch (타입) {
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
            case 4:
                type_FiveStar1();
                break;
            case 5:
                type_FiveStar2();
                break;
            case 6:
                type_Sudoku1();
                break;
            case 7:
                type_Sudoku2();
                break;
            case 8:
                type_Sudoku3();
                break;
            case 9:
                HappyNewYear();
                break;
            default:
                break;
        }
        //}


    }
}