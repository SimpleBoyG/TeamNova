public class ThreadB extends Thread{
    private WorkObject workObject;

    public ThreadB(WorkObject workObject){
        this.workObject = workObject; // 공유 객체를 매개박을 받아 필드에 저장
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            workObject.methodB(); // 공유 객체의 methodB()를 10변 반복 호출.
        }
    }
}
