package 마을.방어구상점.방어구;
public class ArmorInstanceSend {
    // 클래스 타입을 사용하는 팩토리 메서드
    public Armor getArmor(Class<? extends Armor> armorType){
        if(armorType == null){
            return null;
        }

        try{
            return armorType.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
