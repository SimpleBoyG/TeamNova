package Interrupt;

public class PrintThread2 extends Thread{
//    public void run(){
//        try{
//            while(true){
//                System.out.println("실행 중");
//                Thread.sleep(3000);
//
//            }
//        }catch (InterruptedException e){
//            System.out.println("인터럽트가 발생했습니다");
//        }
//
//        System.out.println("자원 정리");
//        System.out.println("실행 종료");
//    }

public void run(){

        while(true){
            System.out.println("실행 중");
            if(Thread.interrupted()){
                System.out.println("인터럽트 입니다");
                break;
            }
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }


}
