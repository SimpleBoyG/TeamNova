package 아이템.소모품;
public class ExpendablesInstanceSend {
    // 클래스 타입을 사용하는 팩토리 메서드
    public Expendables getExpendables(Class<? extends Expendables> Expendables){
        if(Expendables == null){
            return null;
        }

        try{
            return Expendables.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
