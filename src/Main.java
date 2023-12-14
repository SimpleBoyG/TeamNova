import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // =========================== 단계 1 : 저녁 재료 구하기 ===========================================
        System.out.println("=====================================================================================");
        System.out.println("============================= STEP 1 : 저녁 재료 구하기 ================================");
        System.out.println("=====================================================================================");
        System.out.println(" ");
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
                    System.out.println("잘못된 목적지를 정했으므로 난 그냥 집에서 안나가기로 결정했다");
                    System.out.println("나는 오늘 굶어야하는 운명인가봐");
                    System.out.println("라고 생각한 순간 여자친구가 주고 갔던 파스타면이 떠올랐다");
                    System.out.println("찬장을 열어보니 파스타가 하나 들어있었다.");
                    파스타 = 파스타 + 1;
                    System.out.println("다행히도 나는 저녁을 먹을 수 있게 되었다");
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
                //================================ 신용카드 루트 =========================================
                // 신용카드를 가져간다
                System.out.println("오오! 신용카드를 가져가야겠어");
                System.out.println("신용 카드는 내가 원하는 어떤 저녁이든 사먹을 수 있어");
                System.out.println("그리고 저녁 재료를 사러 어디든 갈 수 있어");
                String 신용카드 = "신용카드";

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
                        if (신용카드.equals("신용카드")) {
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
                            System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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

                        if(신용카드.equals("신용카드")) {
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
                            System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
                        if(신용카드.equals("신용카드")) {
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
                            System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
                        if(신용카드.equals("신용카드")){
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
                            System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
                        if(신용카드.equals("신용카드")) {
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
                            System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
                        if(신용카드.equals("신용카드")) {
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
                            System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
                            if (신용카드.equals("신용카드")) {
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
                                System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
                            if (신용카드.equals("신용카드")) {
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
                                System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
                            if (신용카드.equals("신용카드")) {
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
                                System.out.println("나는 신용카드 한도 초과라서 저녁을 사지 못했다.");
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
        System.out.println("=====================================================================================");
        System.out.println("========================== STEP 2 : 저녁 요리 도구 준비하기 =============================");
        System.out.println("=====================================================================================");
        System.out.println(" ");
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
        System.out.println("맞아 비밀번호는 현재 나의 상태를 전부 더한 숫자로 정했지");
        System.out.println("(현금 + 체력 + 라면 + 파스타 + 쫄면)");
        System.out.println("(현금이 1000원 미만이면 1000원으로 계산한다)");

        // 도어락 비밀 번호 4자리를 기억해봅니다
        // 비밀번호는 ((현금 * 체력) + 라면 + 파스타 + 쫄면)을 계산한 수 입니다.
        // 현금이 1000원 미만인 경우는 현금을 1000원으로 계산한다
        int 현관_비밀번호 = 0;
        if(현금 >= 1000){
            현관_비밀번호 = 현금 + 체력 + 라면 + 파스타 + 쫄면;
        }else{
            현금 = 1000;
            현관_비밀번호 = 현금 + 체력 + 라면 + 파스타 + 쫄면;
            현금 = 0;
        }

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
        System.out.println("0) 밥상을 차린다. 1) 냄비를 준비한다. 2) 프라이팬을 준비한다.");

        // 0) 밥상을 차린다. 1) 냄비를 준비한다. 2) 프라이팬을 준비한다.
        int 준비행동 = sc.nextInt();
        // 준비행동_카운터는 준비행동 1개씩 완료할때마다 1씩 감소한다
        int 준비행동_카운터 = 3;
        boolean 준비행동_밥상 = false;
        boolean 준비행동_냄비 = false;
        boolean 준비행동_프라이팬 = false;

        // 밥상을 차린다.
        // 준비행동 카운터 2 지점
        준비행동_카운터--;
        if (준비행동 == 0) {
            System.out.println("나는 밥상을 펼치려고한다. ");
            System.out.println("반잔은 뭘로 선택할래? 0) 단무지 1) 김치 2) 피클");

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
                        System.out.println("나는 어렵게 피클을 꺼낼수 있었다");
                    }
                }else{
                    체력 = 체력 - 1;
                    System.out.println("손쉽게 냉장고문을 연 나는 피클을 꺼내 밥상위에 놓았다");
                    System.out.println("역시 면발에는 피클이지!");
                }
            }else{
                System.out.println("그래 반찬이 뭐가 필요하겠어, 그냥 먹자");
                System.out.println("얼른 먹고 팀노바 과제나 해야지 뭐");
            }
            준비행동_밥상 = true;

        // 냄비에 물을 준비한다
        }else if(준비행동 == 1) {
            체력 = 체력 - 1;
            System.out.println("나는 냄비를 준비하려고 한다");
            System.out.println("어떤 냄비를 써야할까?");
            // 편수냄비, 양푼냄비
            System.out.println("어떤 냄비를 사용하시겠습니까? 편수냄비? 양푼냄비");
            String 냄비종류 = sc.next();
            if(냄비종류.equals("편수냄비")){
                System.out.println("난 편수냄비를 선택했다.");
            }else{
                System.out.println("난 양푼냄비를 선택했다.");
            }
            System.out.println(냄비종류 + "를 선택한 나는 물을 끓일 준비를 한다.");
            System.out.println("물을 어떤 기구를 사용하여 끓이시겠습니까?");
            System.out.println("(가스버너 or 하이라이트)");

            // 가스버너, 하이라이트
            String 물끓이는도구 = sc.next();
            if(물끓이는도구.equals("하이라이트")){
                System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
            }else{
                System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
            }
            System.out.println("난 물을 끓이고 있다.");
            System.out.println("물을 얼마나 끓이겠습니까?");
            System.out.println("100도 or 90도 or 80도");

            // 100도, 90도, 80도
            String 물온도 = sc.next();
            if(물온도.equals("100도")){
                System.out.println("난 " + 물온도 + "를 선택했다.");
            }else if(물온도.equals("90도")) {
                System.out.println("난 " + 물온도 + "를 선택했다.");
            }else if(물온도.equals("80도")){
                System.out.println("난 " + 물온도 + "를 선택했다.");
            }else{
                System.out.println("물온도를 잘못 정한 나는 그냥 100도의 물온도로 끓였다");
                물온도 = "100도";
            }
            System.out.println("난 물을 " + 냄비종류 + "에  " + 물온도 +" 만큼 끓였다");
            준비행동_냄비 = true;

        // 나는 프라이팬을 준비하려고 한다
        }else if(준비행동 == 2){
            체력 = 체력 - 1;
            System.out.println("나는 프라이팬을 준비하려고 한다");
            System.out.println("프라이팬에 나는 집에 있던 계란을 구우려고 한다.");
            System.out.println("프라이팬에 기름을 두른다, 어떤 기름을 쓸꺼야?");
            System.out.println("(올리브유 or 식용유)");

            // 기름을 두른다, 올리브유? 식용유?
            String 기름종류 = sc.next();
            if(기름종류.equals("올리브유")){
                System.out.println("난 프라이팬에 올리브유를 둘렀다");
                System.out.println("올리브유는 높은 온도에서는 타기때문에 160도보다 낮은 온도에서 구워야지");
                System.out.println("몇 도의 온도에서 구울꺼야?");
                System.out.println("우리집 올리브유는 Extra birgin이라 발화점이 160도라는 걸 기억해");
                System.out.println("식용유는 Extra birgin이라 발화점이 250도라는 걸 기억해");

                int 올리브유_온도 = sc.nextInt();

                if(올리브유_온도 > 160){
                    System.out.println(올리브유_온도 + "는 너무 높은 온도를 설정했어, 온도를 140 정도로 내려보자");
                }else if(올리브유_온도 > 140 && 올리브유_온도 <= 160){
                    System.out.println("발화점은 160도지만 " + 올리브유_온도 + "는 여전히 높은 온도야");
                    System.out.println("온도를 조금 낮춰서 140도 정도에서 구워보자");
                }else if(올리브유_온도 > 80 && 올리브유_온도 <= 140){
                    System.out.println(올리브유_온도 + "도는 적당한 온도야");
                    System.out.println("계란이 맛있게 구워지겠어");
                }else{
                    System.out.println("너무 낮은 온도인 것 같아");
                    System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                    System.out.println("100도 이상의 온도에서 계란은 굽자");
                }
            }else if(기름종류.equals("식용유")) {

                int 식용유_온도 = sc.nextInt();

                if (식용유_온도 > 250) {
                    System.out.println(식용유_온도 + "는 너무 높은 온도를 설정했어, 온도를 200 정도로 내려보자");
                } else if (식용유_온도 > 220 && 식용유_온도 <= 250) {
                    System.out.println("발화점은 250도지만 " + 식용유_온도 + "는 여전히 높은 온도야");
                    System.out.println("온도를 조금 낮춰서 200도 정도에서 구워보자");
                } else if (식용유_온도 > 150 && 식용유_온도 <= 220) {
                    System.out.println(식용유_온도 + "도는 적당한 온도야");
                    System.out.println("계란이 맛있게 구워지겠어");
                } else {
                    System.out.println("너무 낮은 온도인 것 같아");
                    System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                    System.out.println("100도 이상의 온도에서 계란은 굽자");
                }
            }

            // 계란은 몇 개 구울 것인가?
            System.out.println("몇 개의 계란을 구울꺼야?");
            // 1개, 2개, 3개
            int 계란수 = sc.nextInt();
            if(계란수 == 1) {
                System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 모자르지 않아?");
                System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                System.out.println("난 계란을 1개 구웠다");
            }else if(계란수 == 2){
                System.out.println("계란을 " + 계란수 + "개만 굽다니 딱 적당하게 먹을 수 있겠어?");
                System.out.println("적당한 단백질 섭취는 오히려 몸에 좋지");
                System.out.println("난 계란을 " + 계란수 + "개 구웠다");
            }else if(계란수 == 3){
                System.out.println("계란을 " + 계란수 + "개만 굽다니 너무 많이 굽지않아?");
                System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                System.out.println("다이어트는 내일부터 하는걸로~");
                System.out.println("난 계란을 " + 계란수 + "개 구웠다");
            }else if(계란수 == 0){
                System.out.println("계란을 굽지 않겠다니, 다이어트를 하려고 그러는거야?");
                System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                System.out.println("난 계란을 " + 계란수 + "개 구웠다");
            }else if(계란수 > 3){
                System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 말이 안되는 것 같아");
                System.out.println("적정량의 계란을 구워야겠어");
                계란수 = 2;
                System.out.println("난 계란을 " + 계란수 + "개 구웠다");
            }else{
                System.out.println("요리할 계란 개수를 정확히 정해봐");
                System.out.println("정하지 못하면 그냥 하나만 굽자");
                계란수 = 1;
                System.out.println("난 계란을 " + 계란수 + "개 구웠다");
            }

            System.out.println("난 계란은 맛있게 구웠다");
            준비행동_프라이팬 = true;
        }else{
            if(체력 <= 0) {
                System.out.println("체력이 딸려서 더는 못 움직이곘어");
            }else {
                System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
            }
        }

        // 준비행동 카운터 1 지점
        준비행동_카운터--;
        if(준비행동_카운터 > 0 && ((준비행동_밥상 == true) || (준비행동_냄비 == true) || (준비행동_프라이팬 == true))) {

            // 이전에 밥상을 먼저 준비한 경우
            if(준비행동_밥상 == true){
                System.out.println("그리고 무엇을 준비할꺼야?");
                System.out.println("1) 냄비를 준비한다. 2) 프라이팬을 준비한다.");
                준비행동 = sc.nextInt();

                // 냄비 준비
                if(준비행동 == 1) {
                    체력 = 체력 - 1;
                    System.out.println("나는 냄비를 준비하려고 한다");
                    System.out.println("어떤 냄비를 써야할까?");
                    // 편수냄비, 양푼냄비
                    System.out.println("어떤 냄비를 사용하시겠습니까? 편수냄비? 양푼냄비");
                    String 냄비종류 = sc.next();
                    if (냄비종류.equals("편수냄비")) {
                        System.out.println("난 편수냄비를 선택했다.");
                    } else {
                        System.out.println("난 양푼냄비를 선택했다.");
                    }
                    System.out.println(냄비종류 + "를 선택한 나는 물을 끓일 준비를 한다.");
                    System.out.println("물을 어떤 기구를 사용하여 끓이시겠습니까?");
                    System.out.println("(가스버너 or 하이라이트)");

                    // 가스버너, 하이라이트
                    String 물끓이는도구 = sc.next();
                    if (물끓이는도구.equals("하이라이트")) {
                        System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
                    } else {
                        System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
                    }
                    System.out.println("난 물을 끓이고 있다.");
                    System.out.println("물을 얼마나 끓이겠습니까?");
                    System.out.println("100도 or 90도 or 80도");

                    // 100도, 90도, 80도
                    String 물온도 = sc.next();
                    if(물온도.equals("100도")){
                        System.out.println("난 " + 물온도 + "를 선택했다.");
                    }else if(물온도.equals("90도")) {
                        System.out.println("난 " + 물온도 + "를 선택했다.");
                    }else if(물온도.equals("80도")){
                        System.out.println("난 " + 물온도 + "를 선택했다.");
                    }else{
                        System.out.println("물온도를 잘못 정한 나는 그냥 100도의 물온도로 끓였다");
                        물온도 = "100도";
                    }
                    System.out.println("난 물을 " + 냄비종류 + "에 " + 물온도 + " 만큼 끓였다");
                    준비행동_냄비 = true;

                // 프라이팬을 준비할 경우
                }else if(준비행동 == 2) {
                    체력 = 체력 - 1;
                    System.out.println("나는 프라이팬을 준비하려고 한다");

                    System.out.println("프라이팬에 나는 집에 있던 계란을 구우려고 한다.");
                    System.out.println("프라이팬에 기름을 두른다, 어떤 기름을 쓸꺼야?");
                    System.out.println("(올리브유 or 식용유)");

                    // 기름을 두른다, 올리브유? 식용유?
                    String 기름종류 = sc.next();
                    if (기름종류.equals("올리브유")) {
                        System.out.println("난 프라이팬에 올리브유를 둘렀다");
                        System.out.println("올리브유는 높은 온도에서는 타기때문에 160도보다 낮은 온도에서 구워야지");
                        System.out.println("몇 도의 온도에서 구울꺼야?");
                        System.out.println("우리집 올리브유는 Extra birgin이라 발화점이 160도라는 걸 기억해");
                        System.out.println("식용유는 Extra birgin이라 발화점이 250도라는 걸 기억해");

                        int 올리브유_온도 = sc.nextInt();

                        if (올리브유_온도 > 160) {
                            System.out.println(올리브유_온도 + "는 너무 높은 온도를 설정했어, 온도를 140 정도로 내려보자");
                        } else if (올리브유_온도 > 140 && 올리브유_온도 <= 160) {
                            System.out.println("발화점은 160도지만 " + 올리브유_온도 + "는 여전히 높은 온도야");
                            System.out.println("온도를 조금 낮춰서 140도 정도에서 구워보자");
                        } else if (올리브유_온도 > 80 && 올리브유_온도 <= 140) {
                            System.out.println(올리브유_온도 + "도는 적당한 온도야");
                            System.out.println("계란이 맛있게 구워지겠어");
                        } else {
                            System.out.println("너무 낮은 온도인 것 같아");
                            System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                            System.out.println("100도 이상의 온도에서 계란은 굽자");
                        }
                    } else if (기름종류.equals("식용유")) {

                        int 식용유_온도 = sc.nextInt();

                        if (식용유_온도 > 250) {
                            System.out.println(식용유_온도 + "는 너무 높은 온도를 설정했어, 온도를 200 정도로 내려보자");
                        } else if (식용유_온도 > 220 && 식용유_온도 <= 250) {
                            System.out.println("발화점은 250도지만 " + 식용유_온도 + "는 여전히 높은 온도야");
                            System.out.println("온도를 조금 낮춰서 200도 정도에서 구워보자");
                        } else if (식용유_온도 > 150 && 식용유_온도 <= 220) {
                            System.out.println(식용유_온도 + "도는 적당한 온도야");
                            System.out.println("계란이 맛있게 구워지겠어");
                        } else {
                            System.out.println("너무 낮은 온도인 것 같아");
                            System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                            System.out.println("100도 이상의 온도에서 계란은 굽자");
                        }
                    }

                    // 계란은 몇 개 구울 것인가?
                    System.out.println("몇 개의 계란을 구울꺼야?");
                    // 1개, 2개, 3개
                    int 계란수 = sc.nextInt();
                    if (계란수 == 1) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 모자르지 않아?");
                        System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                        System.out.println("난 계란을 1개 구웠다");
                    } else if (계란수 == 2) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 딱 적당하게 먹을 수 있겠어?");
                        System.out.println("적당한 단백질 섭취는 오히려 몸에 좋지");
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else if (계란수 == 3) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 너무 많이 굽지않아?");
                        System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                        System.out.println("다이어트는 내일부터 하는걸로~");
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else if (계란수 == 0) {
                        System.out.println("계란을 굽지 않겠다니, 다이어트를 하려고 그러는거야?");
                        System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else if (계란수 > 3) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 말이 안되는 것 같아");
                        System.out.println("적정량의 계란을 구워야겠어");
                        계란수 = 2;
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else {
                        System.out.println("요리할 계란 개수를 정확히 정해봐");
                        System.out.println("정하지 못하면 그냥 하나만 굽자");
                        계란수 = 1;
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    }

                    System.out.println("난 계란은 맛있게 구웠다");
                    준비행동_프라이팬 = true;
                }else {
                    if (체력 <= 0) {
                        System.out.println("체력이 딸려서 더는 못 움직이곘어");
                    } else {
                        System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
                    }
                }

            }else if(준비행동_냄비 == true) {

                // 이전에 냄비를 먼저 준비한 경우 ========================================================
                System.out.println("그리고 무엇을 준비할꺼야?");
                System.out.println("0) 밥상을 차린다. 2) 프라이팬을 준비한다.");
                준비행동 = sc.nextInt();

                if (준비행동 == 0) {
                    System.out.println("나는 밥상을 펼치려고한다. ");
                    System.out.println("반잔은 뭘로 선택할래? 0) 단무지 1) 김치 2) 피클");

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
                                System.out.println("나는 어렵게 피클을 꺼낼수 있었다");
                            }
                        } else {
                            체력 = 체력 - 1;
                            System.out.println("손쉽게 냉장고문을 연 나는 피클을 꺼내 밥상위에 놓았다");
                            System.out.println("역시 면발에는 피클이지!");
                        }
                    } else {
                        System.out.println("그래 반찬이 뭐가 필요하겠어, 그냥 먹자");
                        System.out.println("얼른 먹고 팀노바 과제나 해야지 뭐");
                    }
                    준비행동_밥상 = true;

                    // 프라이팬 준비
                } else if (준비행동 == 2) {
                    체력 = 체력 - 1;
                    System.out.println("나는 프라이팬을 준비하려고 한다");

                    System.out.println("프라이팬에 나는 집에 있던 계란을 구우려고 한다.");
                    System.out.println("프라이팬에 기름을 두른다, 어떤 기름을 쓸꺼야?");
                    System.out.println("(올리브유 or 식용유)");

                    // 기름을 두른다, 올리브유? 식용유?
                    String 기름종류 = sc.next();
                    if (기름종류.equals("올리브유")) {
                        System.out.println("난 프라이팬에 올리브유를 둘렀다");
                        System.out.println("올리브유는 높은 온도에서는 타기때문에 160도보다 낮은 온도에서 구워야지");
                        System.out.println("몇 도의 온도에서 구울꺼야?");
                        System.out.println("우리집 올리브유는 Extra birgin이라 발화점이 160도라는 걸 기억해");
                        System.out.println("식용유는 Extra birgin이라 발화점이 250도라는 걸 기억해");

                        int 올리브유_온도 = sc.nextInt();

                        if (올리브유_온도 > 160) {
                            System.out.println(올리브유_온도 + "는 너무 높은 온도를 설정했어, 온도를 140 정도로 내려보자");
                        } else if (올리브유_온도 > 140 && 올리브유_온도 <= 160) {
                            System.out.println("발화점은 160도지만 " + 올리브유_온도 + "는 여전히 높은 온도야");
                            System.out.println("온도를 조금 낮춰서 140도 정도에서 구워보자");
                        } else if (올리브유_온도 > 80 && 올리브유_온도 <= 140) {
                            System.out.println(올리브유_온도 + "도는 적당한 온도야");
                            System.out.println("계란이 맛있게 구워지겠어");
                        } else {
                            System.out.println("너무 낮은 온도인 것 같아");
                            System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                            System.out.println("100도 이상의 온도에서 계란은 굽자");
                        }
                    } else if (기름종류.equals("식용유")) {

                        int 식용유_온도 = sc.nextInt();

                        if (식용유_온도 > 250) {
                            System.out.println(식용유_온도 + "는 너무 높은 온도를 설정했어, 온도를 200 정도로 내려보자");
                        } else if (식용유_온도 > 220 && 식용유_온도 <= 250) {
                            System.out.println("발화점은 250도지만 " + 식용유_온도 + "는 여전히 높은 온도야");
                            System.out.println("온도를 조금 낮춰서 200도 정도에서 구워보자");
                        } else if (식용유_온도 > 150 && 식용유_온도 <= 220) {
                            System.out.println(식용유_온도 + "도는 적당한 온도야");
                            System.out.println("계란이 맛있게 구워지겠어");
                        } else {
                            System.out.println("너무 낮은 온도인 것 같아");
                            System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                            System.out.println("100도 이상의 온도에서 계란은 굽자");
                        }
                    }

                    // 계란은 몇 개 구울 것인가?
                    System.out.println("몇 개의 계란을 구울꺼야?");
                    // 1개, 2개, 3개
                    int 계란수 = sc.nextInt();
                    if (계란수 == 1) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 모자르지 않아?");
                        System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                        System.out.println("난 계란을 1개 구웠다");
                    } else if (계란수 == 2) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 딱 적당하게 먹을 수 있겠어?");
                        System.out.println("적당한 단백질 섭취는 오히려 몸에 좋지");
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else if (계란수 == 3) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 너무 많이 굽지않아?");
                        System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                        System.out.println("다이어트는 내일부터 하는걸로~");
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else if (계란수 == 0) {
                        System.out.println("계란을 굽지 않겠다니, 다이어트를 하려고 그러는거야?");
                        System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else if (계란수 > 3) {
                        System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 말이 안되는 것 같아");
                        System.out.println("적정량의 계란을 구워야겠어");
                        계란수 = 2;
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    } else {
                        System.out.println("요리할 계란 개수를 정확히 정해봐");
                        System.out.println("정하지 못하면 그냥 하나만 굽자");
                        계란수 = 1;
                        System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                    }

                    System.out.println("난 계란은 맛있게 구웠다");

                    준비행동_프라이팬 = true;
                } else {
                    if (체력 <= 0) {
                        System.out.println("체력이 딸려서 더는 못 움직이곘어");
                    } else {
                        System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
                    }
                }
            }else if(준비행동_프라이팬 == true) {

                // 프라이팬을 먼저 준비한 경우
                System.out.println("그리고 무엇을 준비할꺼야?");
                System.out.println("0) 밥상을 차린다. 1) 냄비를 준비한다.");
                준비행동 = sc.nextInt();

                // 밥상 준비
                if (준비행동 == 0) {
                    System.out.println("나는 밥상을 펼치려고한다. ");
                    System.out.println("반잔은 뭘로 선택할래? 0) 단무지 1) 김치 2) 피클");

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
                                System.out.println("나는 어렵게 피클을 꺼낼수 있었다");
                            }
                        } else {
                            체력 = 체력 - 1;
                            System.out.println("손쉽게 냉장고문을 연 나는 피클을 꺼내 밥상위에 놓았다");
                            System.out.println("역시 면발에는 피클이지!");
                        }
                    } else {
                        System.out.println("그래 반찬이 뭐가 필요하겠어, 그냥 먹자");
                        System.out.println("얼른 먹고 팀노바 과제나 해야지 뭐");
                    }
                    준비행동_밥상 = true;

                    // 냄비 준비
                } else if (준비행동 == 1) {
                    체력 = 체력 - 1;
                    System.out.println("나는 냄비를 준비하려고 한다");
                    System.out.println("어떤 냄비를 써야할까?");
                    // 편수냄비, 양푼냄비
                    System.out.println("어떤 냄비를 사용하시겠습니까? 편수냄비? 양푼냄비");
                    String 냄비종류 = sc.next();
                    if (냄비종류.equals("편수냄비")) {
                        System.out.println("난 편수냄비를 선택했다.");
                    } else {
                        System.out.println("난 양푼냄비를 선택했다.");
                    }
                    System.out.println(냄비종류 + "를 선택한 나는 물을 끓일 준비를 한다.");
                    System.out.println("물을 어떤 기구를 사용하여 끓이시겠습니까?");
                    System.out.println("(가스버너 or 하이라이트)");
                    // 가스버너, 하이라이트
                    String 물끓이는도구 = sc.next();
                    if (물끓이는도구.equals("하이라이트")) {
                        System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
                    } else {
                        System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
                    }
                    System.out.println("난 물을 끓이고 있다.");
                    System.out.println("물을 얼마나 끓이겠습니까?");
                    System.out.println("100도 or 90도 or 80도");

                    // 100도, 90도, 80도
                    String 물온도 = sc.next();
                    if (물온도.equals("100도")) {
                        System.out.println("난 " + 물온도 + "를 선택했다.");
                    } else if (물온도.equals("90도")) {
                        System.out.println("난 " + 물온도 + "를 선택했다.");
                    } else if (물온도.equals("80도")) {
                        System.out.println("난 " + 물온도 + "를 선택했다.");
                    } else {
                        System.out.println("물온도를 잘못 정한 나는 그냥 100도의 물온도로 끓였다");
                        물온도 = "100도";
                    }
                    System.out.println("난 물을 " + 냄비종류 + "에 " + 물온도 + " 만큼 끓였다");
                    준비행동_냄비 = true;

                    준비행동_냄비 = true;
                } else {
                    if (체력 <= 0) {
                        System.out.println("체력이 딸려서 더는 못 움직이곘어");
                    } else {
                        System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
                    }
                }
            }else{
                if (체력 <= 0) {
                    System.out.println("체력이 딸려서 더는 못 움직이곘어");
                } else {
                    System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
                }
            }

        }else{
            if (체력 <= 0) {
                System.out.println("체력이 딸려서 더는 못 움직이곘어");
            } else {
                System.out.println("체력이 얼마 없어, 최대한 빨리 해먹자");
            }
        }

        // 준비행동 카운터 0 지점
        준비행동_카운터--;
        if(준비행동_카운터 == 0) {
            if (준비행동_냄비 == true && 준비행동_프라이팬 == true) {

                System.out.println("나는 밥상을 펼치려고한다. ");
                System.out.println("반잔은 뭘로 선택할래? 0) 단무지 1) 김치 2) 피클");

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
                            System.out.println("나는 어렵게 피클을 꺼낼수 있었다");
                        }
                    } else {
                        체력 = 체력 - 1;
                        System.out.println("손쉽게 냉장고문을 연 나는 피클을 꺼내 밥상위에 놓았다");
                        System.out.println("역시 면발에는 피클이지!");
                    }
                } else {
                    System.out.println("그래 반찬이 뭐가 필요하겠어, 그냥 먹자");
                    System.out.println("얼른 먹고 팀노바 과제나 해야지 뭐");
                }
                준비행동_밥상 = true;

                // 프라이팬 준비
            } else if (준비행동_밥상 == true && 준비행동_냄비 == true) {
                체력 = 체력 - 1;
                System.out.println("나는 프라이팬을 준비하려고 한다");

                System.out.println("프라이팬에 나는 집에 있던 계란을 구우려고 한다.");
                System.out.println("프라이팬에 기름을 두른다, 어떤 기름을 쓸꺼야?");
                System.out.println("(올리브유 or 식용유)");

                // 기름을 두른다, 올리브유? 식용유?
                String 기름종류 = sc.next();
                if (기름종류.equals("올리브유")) {
                    System.out.println("난 프라이팬에 올리브유를 둘렀다");
                    System.out.println("올리브유는 높은 온도에서는 타기때문에 160도보다 낮은 온도에서 구워야지");
                    System.out.println("몇 도의 온도에서 구울꺼야?");
                    System.out.println("우리집 올리브유는 Extra birgin이라 발화점이 160도라는 걸 기억해");
                    System.out.println("식용유는 Extra birgin이라 발화점이 250도라는 걸 기억해");

                    int 올리브유_온도 = sc.nextInt();

                    if (올리브유_온도 > 160) {
                        System.out.println(올리브유_온도 + "는 너무 높은 온도를 설정했어, 온도를 140 정도로 내려보자");
                    } else if (올리브유_온도 > 140 && 올리브유_온도 <= 160) {
                        System.out.println("발화점은 160도지만 " + 올리브유_온도 + "는 여전히 높은 온도야");
                        System.out.println("온도를 조금 낮춰서 140도 정도에서 구워보자");
                    } else if (올리브유_온도 > 80 && 올리브유_온도 <= 140) {
                        System.out.println(올리브유_온도 + "도는 적당한 온도야");
                        System.out.println("계란이 맛있게 구워지겠어");
                    } else {
                        System.out.println("너무 낮은 온도인 것 같아");
                        System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                        System.out.println("100도 이상의 온도에서 계란은 굽자");
                    }
                } else if (기름종류.equals("식용유")) {

                    int 식용유_온도 = sc.nextInt();

                    if (식용유_온도 > 250) {
                        System.out.println(식용유_온도 + "는 너무 높은 온도를 설정했어, 온도를 200 정도로 내려보자");
                    } else if (식용유_온도 > 220 && 식용유_온도 <= 250) {
                        System.out.println("발화점은 250도지만 " + 식용유_온도 + "는 여전히 높은 온도야");
                        System.out.println("온도를 조금 낮춰서 200도 정도에서 구워보자");
                    } else if (식용유_온도 > 150 && 식용유_온도 <= 220) {
                        System.out.println(식용유_온도 + "도는 적당한 온도야");
                        System.out.println("계란이 맛있게 구워지겠어");
                    } else {
                        System.out.println("너무 낮은 온도인 것 같아");
                        System.out.println("계란은 구워지겠지만 너무 느리게 익을 것 같아");
                        System.out.println("100도 이상의 온도에서 계란은 굽자");
                    }
                }

                // 계란은 몇 개 구울 것인가?
                System.out.println("몇 개의 계란을 구울꺼야?");
                // 1개, 2개, 3개
                int 계란수 = sc.nextInt();
                if (계란수 == 1) {
                    System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 모자르지 않아?");
                    System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                    System.out.println("난 계란을 1개 구웠다");
                } else if (계란수 == 2) {
                    System.out.println("계란을 " + 계란수 + "개만 굽다니 딱 적당하게 먹을 수 있겠어?");
                    System.out.println("적당한 단백질 섭취는 오히려 몸에 좋지");
                    System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                } else if (계란수 == 3) {
                    System.out.println("계란을 " + 계란수 + "개만 굽다니 너무 많이 굽지않아?");
                    System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                    System.out.println("다이어트는 내일부터 하는걸로~");
                    System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                } else if (계란수 == 0) {
                    System.out.println("계란을 굽지 않겠다니, 다이어트를 하려고 그러는거야?");
                    System.out.println("하지만 나의 선택이니 뭐 그렇게 굽자");
                    System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                } else if (계란수 > 3) {
                    System.out.println("계란을 " + 계란수 + "개만 굽다니 좀 말이 안되는 것 같아");
                    System.out.println("적정량의 계란을 구워야겠어");
                    계란수 = 2;
                    System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                } else {
                    System.out.println("요리할 계란 개수를 정확히 정해봐");
                    System.out.println("정하지 못하면 그냥 하나만 굽자");
                    계란수 = 1;
                    System.out.println("난 계란을 " + 계란수 + "개 구웠다");
                }

                System.out.println("난 계란은 맛있게 구웠다");

                준비행동_프라이팬 = true;
            } else if (준비행동_밥상 == true && 준비행동_프라이팬 == true) {
                체력 = 체력 - 1;
                System.out.println("나는 냄비를 준비하려고 한다");
                System.out.println("어떤 냄비를 써야할까?");
                // 편수냄비, 양푼냄비
                System.out.println("어떤 냄비를 사용하시겠습니까? 편수냄비? 양푼냄비");
                String 냄비종류 = sc.next();
                if (냄비종류.equals("편수냄비")) {
                    System.out.println("난 편수냄비를 선택했다.");
                } else {
                    System.out.println("난 양푼냄비를 선택했다.");
                }
                System.out.println(냄비종류 + "를 선택한 나는 물을 끓일 준비를 한다.");
                System.out.println("물을 어떤 기구를 사용하여 끓이시겠습니까?");
                System.out.println("(가스버너 or 하이라이트)");

                // 가스버너, 하이라이트
                String 물끓이는도구 = sc.next();
                if (물끓이는도구.equals("하이라이트")) {
                    System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
                } else {
                    System.out.println("난 " + 물끓이는도구 + "를 선택했다.");
                }
                System.out.println("난 물을 끓이고 있다.");
                System.out.println("물을 얼마나 끓이겠습니까?");
                System.out.println("100도 or 90도 or 80도");

                // 100도, 90도, 80도
                String 물온도 = sc.next();
                if (물온도.equals("100도")) {
                    System.out.println("난 " + 물온도 + "를 선택했다.");
                } else if (물온도.equals("90도")) {
                    System.out.println("난 " + 물온도 + "를 선택했다.");
                } else if (물온도.equals("80도")) {
                    System.out.println("난 " + 물온도 + "를 선택했다.");
                } else {
                    System.out.println("물온도를 잘못 정한 나는 그냥 100도의 물온도로 끓였다");
                    물온도 = "100도";
                }
                System.out.println("난 물을 " + 냄비종류 + "에 " + 물온도 + " 만큼 끓였다");
                준비행동_냄비 = true;
            } else {
                if ((준비행동_밥상 == false) && (준비행동_냄비 == false) && (준비행동_프라이팬 == false)) {
                    System.out.println("후... 지치는구만 그냥 아무거나 준비하자");
                }
            }
        }

        if(준비행동_카운터 == 0 && ((준비행동_밥상 == true) && (준비행동_냄비 == true) && (준비행동_프라이팬 == true))) {
            System.out.println("드디어 요리 도구 및 반찬이 준비가 되었다");
            System.out.println("이제 저녁을 맛있게 저녁을 만들어 볼까?");
        }
        System.out.println("갑자기 냉장고에 있던 음료수가 생각이 났다");
        System.out.println("나는 냉장고 앞으로 걸어갔다");
        System.out.println("냉장고 문 손잡이를 잡고 나는 생각한다");
        System.out.println("어떤 음료수를 마시지??");
        System.out.println("0)탄산 음료 , 1) 이온 음료, 2) 단백질 음료");
        System.out.println("어느 것도 정할수 없는 나는 하늘에 맡겨 보기로 했다");

        int 음료선택 = 랜덤.nextInt(3);

        if(음료선택 == 0){
            System.out.println("오오! 탄산 음료가 선택되었어");
        }else if(음료선택 == 1){
            System.out.println("오오! 이온 음료가 선택되었어");
        }else if(음료선택 == 2){
            System.out.println("오오! 단백질 음료가 선택되었어");
        }
        // 1)탄산 음료 , 2) 이온 음료, 3) 단백질 음료

        System.out.println("나는 나의 상태를 한번 확인해 본다");
        System.out.println("===================");
        System.out.println("현금 : " + 현금);
        System.out.println("체력 : " + 체력);
        System.out.println("라면 : " + 라면);
        System.out.println("파스타 : " + 파스타);
        System.out.println("쫄면 : " + 쫄면);
        System.out.println("===================");

        // =========================== 단계 3 : 요리하기 ===========================================
        System.out.println("=====================================================================================");
        System.out.println("================================ STEP 3 : 요리하기 ===================================");
        System.out.println("=====================================================================================");
        System.out.println(" ");

        System.out.println("자~ 이제 요리를 시작해 볼까??");
        System.out.println("어떤 요리를 만들어 볼까?");
        System.out.println("나는 나의 상태를 한번 확인해 본다");
        System.out.println("===================");
        System.out.println("현금 : " + 현금);
        System.out.println("체력 : " + 체력);
        System.out.println("라면 : " + 라면);
        System.out.println("파스타 : " + 파스타);
        System.out.println("쫄면 : " + 쫄면);
        System.out.println("===================");

        if(체력 > 0) {
            if ((라면 > 0) || (파스타 > 0) || (쫄면 > 0)) {

                System.out.println("요리할 메뉴를 고르시오!");
                System.out.println("1) 라면 2) 파스타 3)쫄면");
                System.out.println(":");
                int 메뉴 = sc.nextInt();

                // 메뉴가 라면인데 라면이 있는 경우
                if (메뉴 == 1 && 라면 == 1) {
                    System.out.println("오오! 오늘은 라면이구만~ 만들어볼까?");
                    System.out.println("나는 먼저 냄비의 물이 끓는지 확인했다");
                    System.out.println("라면의 봉투를 뜯었다");
                    System.out.println("무엇을 먼저 넣을까? 면? 스프?");

                    String 라면순서 = sc.next();
                    // 면 먼저
                    if(라면순서.equals("면")){
                        System.out.println("역시 라면은 면부터 넣어야 면이 잘익지");
                        System.out.println("나는 면을 먼저 넣었다.");
                        System.out.println("그리고 스프를 넣었다.");
                        System.out.println("라면은 보글 보글 맛있게 끓고 있다");

                        // 면 익음 정도는 어떤게 좋아? 꼬들면? 퍼진면?
                        System.out.println("면 익음 정도는 어떻게 할래? 꼬들면? 퍼진면?");
                        // 꼬들면
                        String 면발 = sc.next();
                        if(면발.equals("꼬들면")){
                            System.out.println("난 꼬들면으로 먹는 것을 선택했다.");
                            System.out.println("역시 면은 꼬들 꼬들한게 좋지.");
                        // 퍼진면
                        }else if(면발.equals("퍼진면")){
                            System.out.println("난 퍼진면으로 먹는 것을 선택했다.");
                            System.out.println("난 양이 많아지길 기다리고 있어");
                        // 아무렇게나 먹기
                        }else{
                            System.out.println("면이 뭐가 중요한가 그냥 먹으면 배로 들어갈텐데");
                            System.out.println("얼른 저녁을 먹자");
                        }
                    // 스프 먼저
                    }else if(라면순서.equals("스프")){
                        System.out.println("역시 라면은 스프부터 넣어야 면에 맛이 배이지");
                        System.out.println("나는 스프를 먼저 넣었다.");
                        System.out.println("그리고 면을 넣었다.");
                        System.out.println("라면은 보글 보글 맛있게 끓고 있다");

                        // 면 익음 정도는 어떤게 좋아? 꼬들면? 퍼진면?
                        System.out.println("면 익음 정도는 어떻게 할래? 꼬들면? 퍼진면?");
                        // 꼬들면
                        String 면발 = sc.next();
                        if(면발.equals("꼬들면")){
                            System.out.println("난 꼬들면으로 먹는 것을 선택했다.");
                            System.out.println("역시 면은 꼬들 꼬들한게 좋지.");
                            // 퍼진면
                        }else if(면발.equals("퍼진면")) {
                            System.out.println("난 퍼진면으로 먹는 것을 선택했다.");
                            System.out.println("난 양이 많아지길 기다리고 있어");
                            // 아무렇게나 먹기
                        }else{
                            System.out.println("면이 뭐가 중요한가 그냥 먹으면 배로 들어갈텐데");
                            System.out.println("얼른 저녁을 만들어 먹자");
                        }
                    }
                    else{
                        System.out.println("뭘 먼저 넣고 싶은지 모르겠으면 그냥 아무렇게나 넣어");
                        System.out.println("얼른 저녁을 만들어 먹자");
                    }

                    // 계란을 넣어 먹을꺼야?
                    System.out.println("라면에 계란을 넣어 먹을지 생각해보자, 어때?");
                    System.out.println("계란을 넣을 꺼야? 0) No or 1) Yes");
                    boolean 계란유무 = sc.nextBoolean();

                    // 계란은 안넣는다
                    if(계란유무 == false){
                        System.out.println("오늘은 계란이 좀 별로야");
                        System.out.println("난 라면의 국물 그대로의 맛을 느끼고 싶어");
                    //계란은 넣는다
                    }else{
                        System.out.println("역시 라면의 마지막은 계란이 화룡점정이지~");
                        System.out.println("라면은 정말 계란이랑 조합이 좋아");
                        System.out.println("탄수화물 + 단백질 정말 좋구만~~");
                    }

                    System.out.println("드디어 라면이 다 끓여졌어");
                    System.out.println("슬슬 먹어보도록 할까?");

                    // 그릇 선택
                    System.out.println("그전에 라면은 어떤 그릇에 옮겨 먹을래?");
                    System.out.println("1)보울 2)냄비 3)냄비 뚜껑");
                    // 1)보울 2) 냄비 3)냄비 뚜껑
                    int 라면그릇 = sc.nextInt();

                    // 보울 사용
                    if(라면그릇 == 1)
                    {
                        System.out.println("설거지가 늘어나는 것은 싫지만 어떤 그릇을 사용하냐가 음식의 마무리지");
                        System.out.println("난 다 끓인 라면을 보울에 옮겨 담았다");
                        System.out.println("라면이 보울에 맛나게 옮겨 담아졌다");
                    }
                    // 냄비채로 사용
                    else if(라면그릇 == 2)
                    {
                        System.out.println("설거지가 하나 늘어날 뿐이야");
                        System.out.println("피곤한데 하나라도 더 줄여야지");
                        System.out.println("난 라면을 냄비채로 밥상에 놓았다.");
                    }
                    // 냄비뚜껑 사용
                    else if(라면그릇 == 3)
                    {
                        System.out.println("역시 남자라면 라면은 냄뚜에 먹어야지");
                        System.out.println("설거지도 줄이고 좋지 뭐 ㅎㅎ");
                        System.out.println("나는 라면 뚜껑을 덮은채로 라면을 밥상으로 가져갔다");
                    }
                    // 정하지 못했으면 냄비채로 먹기
                    else
                    {
                        System.out.println("뭘 또 고민을 하고 그러나 ㅎㅎ");
                        System.out.println("그냥 냄비채로 먹자 설거지도 줄일겸~");
                    }
                }
                // 메뉴가 파스타인데 파스타가 있는 경우
                else if (메뉴 == 2 && 파스타 == 1) {
                    System.out.println("와우! 파스타~! 만들어볼까?");

                    // 냄비에 물이 끓는지 확인한다.
                    System.out.println("먼저 냄비의 물이 끓는지 확인해볼까?");
                    System.out.println("1) 네 2) 아니오");
                    // 냄비에 물이 끓고 있나? 네 or 아니오
                    int 냄비_물상태 = sc.nextInt();

                    // 네
                    if(냄비_물상태 == 1){
                        System.out.println("냄비에 물이 끓고 있다");
                    // 사온 파스타면을 넣는다
                        System.out.println("냄비에 파스타면을 넣는다");
                    // 아니오
                    }else if(냄비_물상태 == 2){
                        System.out.println("냄비에 물이 아직 안 끓고있어");
                    // 물이 끓을때까지 기다리면
                        System.out.println("물이 끓을때까지 조금만 기다리자");
                    // 다시 물을 확인한다.
                        System.out.println("다시 물 상태를 확인해볼까?");
                        System.out.println("물이 끓고 있구만");
                    // 사온 파스타면을 넣는다
                        System.out.println("냄비에 사온 파스타 면을 넣는다.");
                    }

                    // 사온 파스타면을 넣었다
                    System.out.println("냄비에서 파스타면이 삶아지고 있다");

                    // 면을 몇분동안 삶을 건가요?
                    System.out.println("면을 몇 분동안 삶을껀지 타이머를 맞춰야 겠어");
                    System.out.println("타이머를 몇 분으로 맞출꺼야??");
                    System.out.println("(0 ~ 10분)");

                    int 타이머_분 = sc.nextInt();

                    // 1~6분
                    if(타이머_분 > 0 && 타이머_분 <= 6) {
                        System.out.println("시간이 너무 적은데? 이러면 면이 제대로 익지않아");

                    // 7~8분(완성면)
                    }else if(타이머_분 == 7 && 타이머_분 == 8){
                        System.out.println("적당한 시간을 맞췄군~");
                        System.out.println("면이 잘 익을 것 같아");

                    // 9~10분(불은면)
                    }else if(타이머_분 == 9 && 타이머_분 == 10){
                        System.out.println("좀 시간을 많이 설정한 것 같아");
                        System.out.println("면이 불을 것 같은데...");
                        System.out.println("하지만 면이 불어도 상관없어");

                    // 그외(무조건 불음)
                    }else{
                        System.out.println("요리는 원래 감으로 하는거야");
                        System.out.println("그냥 적당히 끓여서 사용하자");
                    }

                    System.out.println("면이 삶아지는 동안 나는 파스타에 넣을 재료를 익혀볼까??");
                    System.out.println("프라이팬을 먼저 준비해야지");
                    System.out.println("아까 계란 굽고 썼던걸 쓰면 되겠어");

                    // 프라이팬에 기름을 두른다
                    System.out.println("프라이팬에 어떤 기름을 두를까?");

                    // 어떤기름? 올리브유, 포도씨유, 화유
                    System.out.println("0) 올리브유, 1) 포도씨유, 2) 화유");

                    int 프라이팬_기름 = sc.nextInt();

                    // 올리브유 사용
                    if(프라이팬_기름 == 0) {
                        System.out.println("올리브유를 한 번 사용해볼까?");
                        System.out.println("나는 올리브유를 사용했다.");

                    // 포도씨유 사용
                    }else if(프라이팬_기름 == 1){
                        System.out.println("포도씨유를 한 번 사용해볼까?");
                        System.out.println("나는 올리브유를 사용했다.");

                    // 화유 사용
                    }else if(프라이팬_기름 == 2){
                        System.out.println("화유를 한 번 사용해볼까?");
                        System.out.println("나는 화유를 사용했다.");

                    // 아무 기름이나 사용
                    }else{
                        System.out.println("그냥 아무기름이나 사용하자");
                        int 랜덤_기름 = 랜덤.nextInt(3);

                        // 랜덤 - 올리브유
                        if(랜덤_기름 == 0){
                            System.out.println("나는 올리브유를 사용했다");

                        }else if(랜덤_기름 == 1){
                            System.out.println("나는 포도씨유를 사용했다");

                        }else{
                            System.out.println("나는 화유를 사용했다");
                        }
                    }

                    System.out.println("난 파스타에 어떤 재료가 있는지 확인했다");
                    System.out.println("나는 양파, 마늘, 베이컨, 페페론치노가 파스타 밀키트에 들어있었다");
                    System.out.println("먼저 양파부터 썰어야겠어");

                    // 양파를 얇게 or 굵게
                    System.out.println("양파를 어떻게 썰까? 얇게? 굵게?");
                    String 양파_굵기 = sc.next();

                    // 얇게
                    if(양파_굵기 == "얇게") {
                        System.out.println("양파가 얇아야 맛있지");
                        System.out.println("나는 양파를 얇게 썰었다");

                    // 굵게
                    }else if(양파_굵기 == "굵게"){
                        System.out.println("양파가 굵어야 맛있지");
                        System.out.println("나는 양파를 굵어야 썰었다");

                    // 아무렇게나 썰자
                    }else{
                        System.out.println("양파는 아무렇게나 썰어먹어야 겠다");
                        System.out.println("나는 양파를 아무렇게나 썰었다");
                    }

                    // 베이컨을 짧게 길게
                    System.out.println("그다음 베이컨은 어떻게 썰까");

                    System.out.println("베이컨을 어떻게 썰까? 짧게? 길게?");
                    String 베이컨_길이 = sc.next();

                    // 짧게
                    if(베이컨_길이 == "짧게") {
                        System.out.println("베이컨이 짧아야 맛있지");
                        System.out.println("나는 베이컨를 짧게 썰었다");

                    // 굵게
                    }else if(베이컨_길이 == "길게"){
                        System.out.println("베이컨은 길어야 맛있지");
                        System.out.println("나는 베이컨을 길게 썰었다");

                    // 아무렇게나 썰자
                    }else{
                        System.out.println("베이컨은 아무렇게나 썰어먹어야 겠다");
                        System.out.println("나는 베이컨을 아무렇게나 썰었다");
                    }

                    // 영파,마늘,베이컨,페페론치노
                    System.out.println("양파, 마늘, 베이컨, 페페론치노");
                    System.out.println("다음의 재료들을 어떤 순서로 조리할꺼야?");
                    System.out.println("===============================================");
                    System.out.println("0) 마늘, 베이컨 -> 양파 -> 페페론치노(정석)");
                    System.out.println("1) 양파 -> 마늘, 베이컨-> 페페론치노(중급(양파기름용))");
                    System.out.println("2) 모든 재료 한번에(초보용)");
                    System.out.println("===============================================");

                    int 파스타_요리법 = sc.nextInt();

                    // 파스타는 정석대로
                    if(파스타_요리법 == 1){
                        System.out.println("");
                    // 중급자용으로
                    }else if(파스타_요리법 == 2){
                        System.out.println("");
                    // 초보자용으로
                    }else if(파스타_요리법 == 3) {
                        System.out.println("");
                    // 아무렇게나 요리
                    }else{
                        System.out.println("");
                    }

                    System.out.println("삶았던 파스타 타이머가 마침 딱 끝났네");
                    System.out.println("난 삶은 파스타를 프라이팬에 옮겨담았다");
                    System.out.println("그리고는 파스타를 조리하기 시작했다");

                    System.out.println("난 파스타 이리 저리 요리했다.");
                    System.out.println("파스타의 소스가 쫄았는데 면수를 사용할 꺼야?");
                    System.out.println("(Yes or No)");

                    // 면수를 사용할 것인지 말것인지?
                    String 면수_사용 = sc.next();

                    // 면수 사용
                    if(면수_사용 == "Yes"){
                        System.out.println("나는 면수를 사용했다");
                        System.out.println("소스가 더 맛있게 만들어졌다");

                    // 면수 미사용
                    }else {
                        System.out.println("나는 면수를 사용하지 않았다");
                        System.out.println("파스타가 타기 시작하는 것 같다");
                        System.out.println("면수를 사용할까?");
                        System.out.println("(Yes or No)");

                        if(면수_사용 == "Yes"){
                            System.out.println("나는 면수를 사용했다");
                            System.out.println("소스가 더 맛있게 만들어졌다");

                        // 면수 미사용
                        }else {
                            System.out.println("소스가 더 맛있게 만들어졌다");
                        }
                    }


                    // 파마산 치즈를 사용할 것인지?
                    // 사용?
                    // 미사용

                }
                // 메뉴가 쫄면인데 쫄면이 있는 경우
                else if (메뉴 == 3 && 쫄면 == 1)
                {
                    System.out.println("쫄면은 좀 별로지만 만들어볼까?");
                }else {
                    // 메뉴가 라면인데 라면이 없는 경우
                    if(메뉴 == 1 && 라면 == 0){
                        System.out.println("나는 라면을 만들고 싶었지만 라면을 사오지 않았다 ");

                    // 메뉴가 파스타인데 파스타가 없는 경우
                    }else if(메뉴 == 2 && 파스타 == 0){
                        System.out.println("나는 파스타를 만들고 싶었지만 파스타를 사오지 않았다 ");

                    // 메뉴가 쫄면인데 쫄면이 없는경우
                    }else if(메뉴 == 3 && 쫄면 == 0){
                        System.out.println("나는 쫄면을 만들고 싶었지만 쫄면을 사오지 않았다 ");

                    // 메뉴 자체를 잘못 선택할 경우 1,2,3 이외의 선택
                    }else{
                        System.out.println("나는 메뉴를 잘못선택했다.");
                    }
                }



            }
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

        if(Spicy == 1)
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
        else if(Spicy == 2)
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
        else if(Spicy == 3)
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