package Interrupt;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new PrintThread2();
        thread.start();

        try{
            thread.sleep(3000);
        }catch(InterruptedException e){

        }

        thread.interrupt();
    }
}

