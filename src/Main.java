import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // =========================== 단계 1 : 저녁 재료 구하기 ===========================================
        System.out.println("힘든 일을 끝내고 온 나는 집 현관문을 연다");
        System.out.println("그리고 생각한다, 아... 집에 오는길에 저녁을 사올껄");
        System.out.println("집에 들어온 나는 나의 상태를 확인한다");

        // 스캐너와 난수 생성
        Scanner sc = new Scanner(System.in);
        Random 랜덤 = new Random();

        // 나의 상태 확인
        int 현금 = 1000 * (랜덤.nextInt(4));
        int 체력 = 10;
        int 라면 = 0;
        int 파스타 = 0;
        int 쫄면 = 0;
        int 버스비 = 1500;

        System.out.println("================");
        System.out.println("현금 : " + 현금);
        System.out.println("체력 : " + 체력);
        System.out.println("라면 : " + 라면);
        System.out.println("파스타 : " + 파스타);
        System.out.println("쫄면 : " + 쫄면);
        System.out.println("================");

        // 집에 어떤 재료가 있는지 확인
        System.out.println("그리고 집에 저녁을 만들 재료가 있는지 확인한다.");
        // 라면, 파스타, 쫄면
        // 라면이 있는지 확인

        int 재료확인 = 랜덤.nextInt(2);
        if(재료확인 == 0)
        {
            System.out.println("집에 재료가 없음을 확인했다.");
            System.out.println("저녁을 사러 어디로 가야할지 생각한다.");
            System.out.println("편의점 -> 원래 가격보다 500원 비싸고 거리는 가깝다 (돈 + 500, 체력 소모x)");
            System.out.println("동네슈퍼 -> 가격은 원래 가격이지만 걸어야해서 힘들다, (체력 -5)");
            System.out.println("대형할인마트 -> 버스를 타고 가야하며 원래 가격보다 500원 싸다");

            /*
            원래가격
            라면 1000원
            쫄면 1500원
            파스타 3000원
            버스비 = 1500원
            행동 1번에 체력 -1
            걷기 체력 -5
            버스 체력 -2
            저녁은 무조건 1개만 살 수 있다
            */

            String 목적지 = sc.next();
            System.out.println("나는 " + 목적지 + "를 가기로 정했다.");

            // 목적지로 향하기전 내 돈의 상태를 점검함
            if(현금 > 0) {
                // =================================================================================================
                // 목적지가 "편의점"인 경우
                if (목적지.equals("편의점")) {
                    // 편의점 : 체력 소모x, 원래가격 + 500
                    System.out.println("나는" + 목적지 + "에 도착했다");
                    System.out.println("나는 나의 상태를 확인했다");
                    System.out.println("================");
                    System.out.println("현금 : " + 현금);
                    System.out.println("체력 : " + 체력);
                    System.out.println("라면 : " + 라면);
                    System.out.println("파스타 : " + 파스타);
                    System.out.println("쫄면 : " + 쫄면);
                    System.out.println("================");

                    System.out.println("나는 가격표를 봤다");
                    System.out.println("라면 : 1500원");
                    System.out.println("파스타 : 3500원");
                    System.out.println("쫄면 : 2000원");

                    // 무엇을 살 것인지?
                    System.out.println("무엇을 살꺼지?");
                    String 저녁 = sc.next();
                    if (저녁.equals("라면")) {
                        현금 = 현금 - 1500;
                        if (현금 >= 0) {
                            라면 = 라면 + 1;
                            System.out.println("나는 라면을 샀다");
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        } else {
                            System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                            System.out.println("집으로 오는 길에 친구를 만나 라면 하나를 얻었다");
                            라면 = 라면 + 1;
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }

                    } else if (저녁.equals("파스타")) {
                        현금 = 현금 - 3500;
                        if(현금 >= 0) {
                            파스타 = 파스타 + 1;
                            System.out.println("나는 파스타를 샀다");
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        } else {
                            System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                            System.out.println("집으로 오는 길에 친구를 만나 라면 하나를 얻었다");
                            라면 = 라면 + 1;
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }

                    } else if (저녁.equals("쫄면")) {
                        현금 = 현금 - 1500;
                        if(현금 >= 0) {
                            쫄면 = 쫄면 + 1;
                            System.out.println("나는 파스타를 샀다");
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }else{
                            System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                            System.out.println("집으로 오는 길에 친구를 만나 라면 하나를 얻었다");
                            라면 = 라면 + 1;
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }
                    }else{
                        System.out.println(저녁 + "가 뭔지는 잘 몰라도 저녁은 굶어야겠지?");
                    }
                // =================================================================================================
                // 목적지가 "동네슈퍼"인 경우
                } else if (목적지.equals("동네슈퍼")) {
                    System.out.println("나는" + 목적지 + "에 도착했다");
                    체력 = 체력 - 5;
                    System.out.println("나는 나의 상태를 확인했다");
                    System.out.println("================");
                    System.out.println("현금 : " + 현금);
                    System.out.println("체력 : " + 체력);
                    System.out.println("라면 : " + 라면);
                    System.out.println("파스타 : " + 파스타);
                    System.out.println("쫄면 : " + 쫄면);
                    System.out.println("================");

                    System.out.println("나는 가격표를 봤다");
                    System.out.println("라면 : 1000원");
                    System.out.println("파스타 : 3000원");
                    System.out.println("쫄면 : 1500원");

                    System.out.println("무엇을 살꺼야?");
                    String 저녁 = sc.next();
                    if(저녁.equals("라면")){
                        현금 = 현금 - 1000;
                        if(현금 >= 0){
                            라면 = 라면 + 1;
                            System.out.println("나는 라면을 샀다");
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }else{
                            System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                            System.out.println("그런 나를 불쌍히 여긴 동네 슈퍼 아주머니께서 라면하나를 주셨다");
                            라면 = 라면 + 1;
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }
                    }else if(저녁.equals("파스타")){
                        현금 = 현금 - 3000;
                        if(현금 >= 0) {
                            파스타 = 파스타 + 1;
                            System.out.println("나는 파스타를 샀다");
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }else{
                            System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                            System.out.println("그런 나를 불쌍히 여긴 동네 슈퍼 아주머니께서 라면하나를 주셨다");
                            라면 = 라면 + 1;
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }

                    }else if(저녁.equals("쫄면")){
                        현금 = 현금 - 1500;
                        if(현금 >= 0) {
                            쫄면 = 쫄면 + 1;
                            System.out.println("나는 쫄면을 샀다");
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }else{
                            System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                            System.out.println("그런 나를 불쌍히 여긴 동네 슈퍼 아주머니께서 라면하나를 주셨다");
                            라면 = 라면 + 1;
                            System.out.println("================");
                            System.out.println("현금 : " + 현금);
                            System.out.println("체력 : " + 체력);
                            System.out.println("라면 : " + 라면);
                            System.out.println("파스타 : " + 파스타);
                            System.out.println("쫄면 : " + 쫄면);
                            System.out.println("================");
                        }
                    }else{
                        System.out.println(저녁 + "가 뭔지는 잘 몰라도 저녁은 굶어야겠지?");
                    }

                // =================================================================================================
                // 목적지가 "대형할인마트"인 경우 -> 버스비 * 2, 할인가격 500
                } else if (목적지.equals("대형할인마트")) {
                    System.out.println("나는" + 목적지 + "에 도착했다");
                    현금 = 현금 - 버스비;
                    System.out.println("나는 나의 상태를 확인했다");
                    System.out.println("================");
                    System.out.println("현금 : " + 현금);
                    System.out.println("체력 : " + 체력);
                    System.out.println("라면 : " + 라면);
                    System.out.println("파스타 : " + 파스타);
                    System.out.println("쫄면 : " + 쫄면);
                    System.out.println("================");
                    System.out.println("나는 가격표를 봤다");
                    System.out.println("라면 : 500원");
                    System.out.println("파스타 : 2500원");
                    System.out.println("쫄면 : 1000원");
                    System.out.println("역시 대형할인마트는 싸구만");
                    System.out.println("무엇을 살꺼야?");

                    String 저녁 = sc.next();
                    if(현금 > 500){
                        if (저녁.equals("라면")) {
                            현금 = 현금 - 500;
                            if (현금 >= 0) {
                                라면 = 라면 + 1;
                                System.out.println("나는 라면을 샀다");
                                System.out.println("================");
                                System.out.println("현금 : " + 현금);
                                System.out.println("체력 : " + 체력);
                                System.out.println("라면 : " + 라면);
                                System.out.println("파스타 : " + 파스타);
                                System.out.println("쫄면 : " + 쫄면);
                                System.out.println("================");
                            } else {
                                System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                                System.out.println("그런 나를 불쌍히 여긴 동네 슈퍼 아주머니께서 라면하나를 주셨다");
                                라면 = 라면 + 1;
                                System.out.println("================");
                                System.out.println("현금 : " + 현금);
                                System.out.println("체력 : " + 체력);
                                System.out.println("라면 : " + 라면);
                                System.out.println("파스타 : " + 파스타);
                                System.out.println("쫄면 : " + 쫄면);
                                System.out.println("================");
                            }
                        } else if (저녁.equals("파스타")) {
                            현금 = 현금 - 2500;
                            if (현금 >= 0) {
                                파스타 = 파스타 + 1;
                                System.out.println("나는 파스타를 샀다");
                                System.out.println("================");
                                System.out.println("현금 : " + 현금);
                                System.out.println("체력 : " + 체력);
                                System.out.println("라면 : " + 라면);
                                System.out.println("파스타 : " + 파스타);
                                System.out.println("쫄면 : " + 쫄면);
                                System.out.println("================");
                            } else {
                                System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                                System.out.println("그런 나를 불쌍히 여긴 동네 슈퍼 아주머니께서 라면하나를 주셨다");
                                라면 = 라면 + 1;
                                System.out.println("================");
                                System.out.println("현금 : " + 현금);
                                System.out.println("체력 : " + 체력);
                                System.out.println("라면 : " + 라면);
                                System.out.println("파스타 : " + 파스타);
                                System.out.println("쫄면 : " + 쫄면);
                                System.out.println("================");
                            }

                        } else if (저녁.equals("쫄면")) {
                            현금 = 현금 - 1000;
                            if (현금 >= 0) {
                                쫄면 = 쫄면 + 1;
                                System.out.println("나는 쫄면을 샀다");
                                System.out.println("================");
                                System.out.println("현금 : " + 현금);
                                System.out.println("체력 : " + 체력);
                                System.out.println("라면 : " + 라면);
                                System.out.println("파스타 : " + 파스타);
                                System.out.println("쫄면 : " + 쫄면);
                                System.out.println("================");
                            } else {
                                System.out.println("나는 돈이 없어 저녁을 사지 못했다.");
                                System.out.println("그런 나를 불쌍히 여긴 동네 슈퍼 아주머니께서 라면하나를 주셨다");
                                라면 = 라면 + 1;
                                System.out.println("================");
                                System.out.println("현금 : " + 현금);
                                System.out.println("체력 : " + 체력);
                                System.out.println("라면 : " + 라면);
                                System.out.println("파스타 : " + 파스타);
                                System.out.println("쫄면 : " + 쫄면);
                                System.out.println("================");
                            }
                        } else {
                            System.out.println(저녁 + "가 뭔지는 잘 몰라도 저녁은 굶어야겠지?");
                        }
                        System.out.println("이제 집으로 가볼까?");

                        // 현금이 1500원 이하인 경우에는 걸어가야 한다 체력 -3
                        if (현금 < 1500) {
                            System.out.println("아... 버스비를 생각하지 못했다");
                            체력 = 체력 - 3;
                            System.out.println("나는 털레 털레 집으로 걸어갔다.");
                        } else {
                            System.out.println("나는 버스를 정류장으로 향했다");
                            System.out.println("버스를 타고 나는 집에 도착했다");
                        }
                    }
                    else{
                        System.out.println("버스비로 이미 돈을 다 써버린 나는");
                        System.out.println("털레 털레 집으로 돌아가는 중이었다.");
                        체력 = 체력 - 3;
                        System.out.println("집으로 돌아가던중 여자친구를 만나 라면하나를 얻었다");
                        라면 = 라면 + 1;
                    }

                } else {
                    System.out.println("잘못된 목적지인 " + 목적지 + "을 선택한 것 같아");
                    System.out.println("나는 오늘 굶어야하는 운명인가봐");
                }
            // 현금이 1000원인 경우 동네슈퍼에서 라면, 쫄면
            }else if(현금 == 1000) {
                System.out.println("돈이 1000원 밖에 없네 동네슈퍼를 가야겠어");
                System.out.println("동네슈퍼에서 라면 밖에 살 수 없겠어... 오늘 저녁은 라면이군");
                System.out.println("나는 라면 한 개를 사서 집으로 돌아갔다");
                라면 = 라면 + 1;
                체력 = 체력 - 5;
                System.out.println("================");
                System.out.println("현금 : " + 현금);
                System.out.println("체력 : " + 체력);
                System.out.println("라면 : " + 라면);
                System.out.println("파스타 : " + 파스타);
                System.out.println("쫄면 : " + 쫄면);
                System.out.println("================");
            }else // 현금이 0원 이하인 경우, 이 경우는 운이 좋은 경우이며 신용카드를 사용할 수 있다.
            {
                // 신용카드를 가져간다
                System.out.println("오오! 신용카드를 가져가야겠어");
                System.out.println("신용 카드는 내가 원하는 어떤 저녁이든 사먹을 수 있어");
                System.out.println("그리고 저녁 재료를 사러 어디든 갈 수 있어");
            }
        }
        else{
            // 재료가 있는 경우
            System.out.println("재료가 있음을 확인했다.");
            System.out.println("그럼 어떤 저녁을 만들 수 있을까?");

            // 어떤 재료가 있는지는 랜덤으로 선택
            // 0) 라면 1) 파스타 2) 쫄면
            int 랜덤_저녁 = 랜덤.nextInt(3);
            if(랜덤_저녁 == 0) {
                라면 = 라면 + 1;
                System.out.println("휴~ 집에 라면이 하나 남아 있구나");
            }else if(랜덤_저녁 == 1){
                파스타 = 파스타 + 1;
                System.out.println("오오!~ 파스타가 집에 있었다니 운이 좋구나");
            }else{
                쫄면 = 쫄면 + 1;
                System.out.println("오! 쫄면이 집에 있었네, 쫄깃 쫄깃 쫄면~");
            }

            // 현재 나의 상태 확인
            System.out.println("현재 나의 상태는?");
            System.out.println("현금 : " + 현금);
            System.out.println("체력 : " + 체력);
            System.out.println("라면 : " + 라면);
            System.out.println("파스타 : " + 파스타);
            System.out.println("쫄면 : " + 쫄면);
        }

        // =========================== 단계 2 : 저녁 만들 준비하기 ===========================================
        System.out.println("==============================================================================");
        System.out.println("저녁밥을 사서 나는 집으로 돌아가는 중이다.");
        System.out.println("나는 나의 상태를 확인해봤다.");
        System.out.println("===================");
        System.out.println("현금 : " + 현금);
        System.out.println("체력 : " + 체력);
        System.out.println("라면 : " + 라면);
        System.out.println("파스타 : " + 파스타);
        System.out.println("쫄면 : " + 쫄면);
        System.out.println("===================");

        // 여기서는 특정한 행동 1번에 체력이 1 됩니다.
        System.out.println("현관문 앞에서 나는 도어락의 비번을 누른다");
        System.out.println("음... 비밀번호가 뭐였더라?");

        // 도어락 비밀 번호 4자리를 기억해봅니다
        // 비밀번호는 ((현금 * 체력) + 라면 + 파스타 + 쫄면)을 계산한 수 입니다.
        int 현관_비밀번호 = (현금*체력) + 라면 + 파스타 + 쫄면;
        int 누른_비밀번호 = sc.nextInt();

        // 현관_비밀번호와 누른_비밀번호를 비교합니다.
        if(현관_비밀번호 == 누른_비밀번호)
        {
            체력 = 체력 - 1;
            System.out.println("띠리릭~ 오! 현관문이 열렸어");
            System.out.println("===================");
            System.out.println("현금 : " + 현금);
            System.out.println("체력 : " + 체력);
            System.out.println("라면 : " + 라면);
            System.out.println("파스타 : " + 파스타);
            System.out.println("쫄면 : " + 쫄면);
            System.out.println("===================");
        }else{
            체력 = 체력 - 1;
            System.out.println("설마 본인의 집 비밀번호를 모르는 건 아니겠지?");
            System.out.println("모른다면 좀 심각한데?");
            System.out.println("아! 생각났어 비밀번호는 " + 현관_비밀번호 + "설정했었어");
            System.out.println("===================");
            System.out.println("현금 : " + 현금);
            System.out.println("체력 : " + 체력);
            System.out.println("라면 : " + 라면);
            System.out.println("파스타 : " + 파스타);
            System.out.println("쫄면 : " + 쫄면);
            System.out.println("===================");
        }

        System.out.println("나는 간신히 현관문을 열고 들어왔다");
        System.out.println("신발을 벗고 나는 무엇을 먼저 준비할지 생각에 빠졌다");

        // 0) 밥상을 차린다. 1) 냄비를 준비한다. 2) 프라이팬을 준비한다.
        int 준비행동 = sc.nextInt();
        // 준비행동_카운터는 준비행동 1개씩 완료할때마다 1씩 감소한다
        int 준비행동_카운터 = 3;
        boolean 준비행동_밥상 = false;
        boolean 준비행동_냄비 = false;
        boolean 준비행동_프라이팬 = false;

        // 준비행동 카운터 3 지점
        // 밥상을 차린다.
        if (준비행동 == 0) {
            System.out.println("나는 밥상을 펼치려고한다. ");
            // 반잔은 뭘로 선택할래? 0) 단무지 1) 김치 2) 피클
            int 반찬 = sc.nextInt();

            // 반찬 -> 단무지
            if(반찬 == 0) {
                System.out.println("나는 단무지를 꺼내기 위해 냉장고로 향했다");
                System.out.println("나는 냉장고 문을 당긴다 연다");

                boolean 열자_냉장고문 = 랜덤.nextBoolean();
                if(열자_냉장고문 == false){
                    체력 = 체력 - 1;
                    System.out.println("냉장고문이 열리지 않는다");
                    System.out.println("나는 힘껏 냉장고문을 당겨본다");
                    boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                    if(다시열자_냉장고문 == false){
                        System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                        체력 = 체력 - 2;
                        System.out.println("나는 간신히 단무지를 꺼낼수 있었다. 정말 힘들게");
                    }else{
                        체력 = 체력 - 1;
                        System.out.println("냉장고 문이 열렸다");
                        System.out.println("나는 어렵게 단무지를 꺼낼수 있었다");
                    }
                }else{
                    체력 = 체력 - 1;
                    System.out.println("손쉽게 냉장고문을 연 나는 단무지를 꺼내 밥상위에 놓았다");
                    System.out.println("역시 면발에는 단무지지!");
                }

            //반찬 -> 김치
            }else if(반찬 == 1){
                System.out.println("나는 김치를 꺼내기 위해 냉장고로 향했다");
                System.out.println("나는 냉장고 문을 당긴다 연다");

                boolean 열자_냉장고문 = 랜덤.nextBoolean();
                if(열자_냉장고문 == false){
                    체력 = 체력 - 1;
                    System.out.println("냉장고문이 열리지 않는다");
                    System.out.println("나는 힘껏 냉장고문을 당겨본다");
                    boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                    if(다시열자_냉장고문 == false){
                        System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                        체력 = 체력 - 2;
                        System.out.println("나는 간신히 김치를 꺼낼수 있었다. 정말 힘들게");
                    }else{
                        체력 = 체력 - 1;
                        System.out.println("냉장고 문이 열렸다");
                        System.out.println("나는 어렵게 김치를 꺼낼 수 있었다");
                    }
                }else{
                    체력 = 체력 - 1;
                    System.out.println("손쉽게 냉장고문을 연 나는 김치를 꺼내 밥상위에 놓았다");
                    System.out.println("역시 면발에는 김치지!");
                }
            //반찬 -> 피클
            }else if(반찬 == 2){
                System.out.println("나는 피클을 꺼내기 위해 냉장고로 향했다");
                System.out.println("나는 냉장고 문을 당긴다 연다");

                boolean 열자_냉장고문 = 랜덤.nextBoolean();
                if(열자_냉장고문 == false){
                    체력 = 체력 - 1;
                    System.out.println("냉장고문이 열리지 않는다");
                    System.out.println("나는 힘껏 냉장고문을 당겨본다");
                    boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                    if(다시열자_냉장고문 == false){
                        System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                        체력 = 체력 - 2;
                        System.out.println("나는 간신히 단무지를 꺼낼수 있었다. 정말 힘들게");
                    }else{
                        체력 = 체력 - 1;
                        System.out.println("냉장고 문이 열렸다");
                        System.out.println("나는 어렵게 단무지를 꺼낼수 있었다");
                    }
                }else{
                    체력 = 체력 - 1;
                    System.out.println("손쉽게 냉장고문을 연 나는 단무지를 꺼내 밥상위에 놓았다");
                    System.out.println("역시 면발에는 단무지지!");
                }
            }else{
                System.out.println("그래 반찬이 뭐가 필요하겠어, 그냥 먹자");
                System.out.println("얼른 먹고 팀노바 과제나 해야지 뭐");
            }
            준비행동_밥상 = true;
        }else if(준비행동 == 1) {
            체력 = 체력 - 1;
            System.out.println("나는 냄비를 준비하려고 한다");
            System.out.println("냄비에 물을 넣는다.");

            준비행동_냄비 = true;
        }else if(준비행동 == 2){
            체력 = 체력 - 1;
            System.out.println("나는 프라이팬을 준비하려고 한다");

            준비행동_프라이팬 = true;
        }else{
            if(체력 <= 0) {
                System.out.println("체력이 딸려서 더는 못 움직이곘어");
            }else {
                System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
            }
        }
        // 준비행동 카운터 2 지점
        준비행동_카운터 = 준비행동_카운터 - 1;
        if(준비행동_카운터 > 0 && ((준비행동_밥상 == true) || (준비행동_냄비 == true) || (준비행동_프라이팬 == true))) {

            // 밥상을 먼저 준비한 경우
            if(준비행동_밥상 == true){
                if(준비행동 == 2){
                    체력 = 체력 - 1;
                    System.out.println("나는 프라이팬을 준비하려고 한다");

                    준비행동_프라이팬 = true;
                }else {
                    if (체력 <= 0) {
                        System.out.println("체력이 딸려서 더는 못 움직이곘어");
                    } else {
                        System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
                    }
                }
            }
            // 냄비를 먼저 준비한 경우
            if (준비행동 == 0) {
                System.out.println("나는 밥상을 펼치려고한다. ");
                // 반잔은 뭘로 선택할래? 0) 단무지 1) 김치 2) 피클
                int 반찬 = sc.nextInt();

                // 반찬 -> 단무지
                if (반찬 == 0) {
                    System.out.println("나는 단무지를 꺼내기 위해 냉장고로 향했다");
                    System.out.println("나는 냉장고 문을 당긴다 연다");

                    boolean 열자_냉장고문 = 랜덤.nextBoolean();
                    if (열자_냉장고문 == false) {
                        체력 = 체력 - 1;
                        System.out.println("냉장고문이 열리지 않는다");
                        System.out.println("나는 힘껏 냉장고문을 당겨본다");
                        boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                        if (다시열자_냉장고문 == false) {
                            System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                            체력 = 체력 - 2;
                            System.out.println("나는 간신히 단무지를 꺼낼수 있었다. 정말 힘들게");
                        } else {
                            체력 = 체력 - 1;
                            System.out.println("냉장고 문이 열렸다");
                            System.out.println("나는 어렵게 단무지를 꺼낼수 있었다");
                        }
                    } else {
                        체력 = 체력 - 1;
                        System.out.println("손쉽게 냉장고문을 연 나는 단무지를 꺼내 밥상위에 놓았다");
                        System.out.println("역시 면발에는 단무지지!");
                    }

                    //반찬 -> 김치
                } else if (반찬 == 1) {
                    System.out.println("나는 김치를 꺼내기 위해 냉장고로 향했다");
                    System.out.println("나는 냉장고 문을 당긴다 연다");

                    boolean 열자_냉장고문 = 랜덤.nextBoolean();
                    if (열자_냉장고문 == false) {
                        체력 = 체력 - 1;
                        System.out.println("냉장고문이 열리지 않는다");
                        System.out.println("나는 힘껏 냉장고문을 당겨본다");
                        boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                        if (다시열자_냉장고문 == false) {
                            System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                            체력 = 체력 - 2;
                            System.out.println("나는 간신히 김치를 꺼낼수 있었다. 정말 힘들게");
                        } else {
                            체력 = 체력 - 1;
                            System.out.println("냉장고 문이 열렸다");
                            System.out.println("나는 어렵게 김치를 꺼낼 수 있었다");
                        }
                    } else {
                        체력 = 체력 - 1;
                        System.out.println("손쉽게 냉장고문을 연 나는 김치를 꺼내 밥상위에 놓았다");
                        System.out.println("역시 면발에는 김치지!");
                    }
                    //반찬 -> 피클
                } else if (반찬 == 2) {
                    System.out.println("나는 피클을 꺼내기 위해 냉장고로 향했다");
                    System.out.println("나는 냉장고 문을 당긴다 연다");

                    boolean 열자_냉장고문 = 랜덤.nextBoolean();
                    if (열자_냉장고문 == false) {
                        체력 = 체력 - 1;
                        System.out.println("냉장고문이 열리지 않는다");
                        System.out.println("나는 힘껏 냉장고문을 당겨본다");
                        boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                        if (다시열자_냉장고문 == false) {
                            System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                            체력 = 체력 - 2;
                            System.out.println("나는 간신히 단무지를 꺼낼수 있었다. 정말 힘들게");
                        } else {
                            체력 = 체력 - 1;
                            System.out.println("냉장고 문이 열렸다");
                            System.out.println("나는 어렵게 단무지를 꺼낼수 있었다");
                        }
                    } else {
                        체력 = 체력 - 1;
                        System.out.println("손쉽게 냉장고문을 연 나는 단무지를 꺼내 밥상위에 놓았다");
                        System.out.println("역시 면발에는 단무지지!");
                    }
                } else {
                    System.out.println("그래 반찬이 뭐가 필요하겠어, 그냥 먹자");
                    System.out.println("얼른 먹고 팀노바 과제나 해야지 뭐");
                }
                준비행동_밥상 = true;
            }else if(준비행동 == 2){
                체력 = 체력 - 1;
                System.out.println("나는 프라이팬을 준비하려고 한다");

                준비행동_프라이팬 = true;
            }
            // 프라이팬을 먼저 준비한 경우
            if (준비행동 == 0) {
                System.out.println("나는 밥상을 펼치려고한다. ");
                // 반잔은 뭘로 선택할래? 0) 단무지 1) 김치 2) 피클
                int 반찬 = sc.nextInt();

                // 반찬 -> 단무지
                if(반찬 == 0) {
                    System.out.println("나는 단무지를 꺼내기 위해 냉장고로 향했다");
                    System.out.println("나는 냉장고 문을 당긴다 연다");

                    boolean 열자_냉장고문 = 랜덤.nextBoolean();
                    if(열자_냉장고문 == false){
                        체력 = 체력 - 1;
                        System.out.println("냉장고문이 열리지 않는다");
                        System.out.println("나는 힘껏 냉장고문을 당겨본다");
                        boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                        if(다시열자_냉장고문 == false){
                            System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                            체력 = 체력 - 2;
                            System.out.println("나는 간신히 단무지를 꺼낼수 있었다. 정말 힘들게");
                        }else{
                            체력 = 체력 - 1;
                            System.out.println("냉장고 문이 열렸다");
                            System.out.println("나는 어렵게 단무지를 꺼낼수 있었다");
                        }
                    }else{
                        체력 = 체력 - 1;
                        System.out.println("손쉽게 냉장고문을 연 나는 단무지를 꺼내 밥상위에 놓았다");
                        System.out.println("역시 면발에는 단무지지!");
                    }

                    //반찬 -> 김치
                }else if(반찬 == 1){
                    System.out.println("나는 김치를 꺼내기 위해 냉장고로 향했다");
                    System.out.println("나는 냉장고 문을 당긴다 연다");

                    boolean 열자_냉장고문 = 랜덤.nextBoolean();
                    if(열자_냉장고문 == false){
                        체력 = 체력 - 1;
                        System.out.println("냉장고문이 열리지 않는다");
                        System.out.println("나는 힘껏 냉장고문을 당겨본다");
                        boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                        if(다시열자_냉장고문 == false){
                            System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                            체력 = 체력 - 2;
                            System.out.println("나는 간신히 김치를 꺼낼수 있었다. 정말 힘들게");
                        }else{
                            체력 = 체력 - 1;
                            System.out.println("냉장고 문이 열렸다");
                            System.out.println("나는 어렵게 김치를 꺼낼 수 있었다");
                        }
                    }else{
                        체력 = 체력 - 1;
                        System.out.println("손쉽게 냉장고문을 연 나는 김치를 꺼내 밥상위에 놓았다");
                        System.out.println("역시 면발에는 김치지!");
                    }
                    //반찬 -> 피클
                }else if(반찬 == 2){
                    System.out.println("나는 피클을 꺼내기 위해 냉장고로 향했다");
                    System.out.println("나는 냉장고 문을 당긴다 연다");

                    boolean 열자_냉장고문 = 랜덤.nextBoolean();
                    if(열자_냉장고문 == false){
                        체력 = 체력 - 1;
                        System.out.println("냉장고문이 열리지 않는다");
                        System.out.println("나는 힘껏 냉장고문을 당겨본다");
                        boolean 다시열자_냉장고문 = 랜덤.nextBoolean();
                        if(다시열자_냉장고문 == false){
                            System.out.println("모든 힘을 다해 냉장고 문을 열었다");
                            체력 = 체력 - 2;
                            System.out.println("나는 간신히 단무지를 꺼낼수 있었다. 정말 힘들게");
                        }else{
                            체력 = 체력 - 1;
                            System.out.println("냉장고 문이 열렸다");
                            System.out.println("나는 어렵게 단무지를 꺼낼수 있었다");
                        }
                    }else{
                        체력 = 체력 - 1;
                        System.out.println("손쉽게 냉장고문을 연 나는 단무지를 꺼내 밥상위에 놓았다");
                        System.out.println("역시 면발에는 단무지지!");
                    }
                }else{
                    System.out.println("그래 반찬이 뭐가 필요하겠어, 그냥 먹자");
                    System.out.println("얼른 먹고 팀노바 과제나 해야지 뭐");
                }
                준비행동_밥상 = true;
            }else if(준비행동 == 1) {
                체력 = 체력 - 1;
                System.out.println("나는 냄비를 준비하려고 한다");
                System.out.println("냄비에 물을 넣는다.");

                준비행동_냄비 = true;
            }
        }

        System.out.println("===================");
        System.out.println("현금 : " + 현금);
        System.out.println("체력 : " + 체력);
        System.out.println("라면 : " + 라면);
        System.out.println("파스타 : " + 파스타);
        System.out.println("쫄면 : " + 쫄면);
        System.out.println("===================");






































        System.out.println("============================");
        System.out.println("요리 메뉴를 고르시오!");
        System.out.println("1) 라면  2) 파스타 3)쫄면");
        System.out.println(":");
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
        int rLuckyItem = 랜덤.nextInt(4) +1;

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