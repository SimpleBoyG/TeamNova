public class ThreadA extends Thread{
    private WorkObject workObject;

    public ThreadA(WorkObject workObject){
        this.workObject = workObject; // 공유 객체를 매개박을 받아 필드에 저장
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            workObject.methodA(); // 공유 객체의 methodA()를 10변 반복 호출.
        }
    }
}
