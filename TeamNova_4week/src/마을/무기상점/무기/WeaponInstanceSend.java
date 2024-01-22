package 마을.무기상점.무기;

public class WeaponInstanceSend {
    // 클래스 타입을 사용하는 팩토리 메서드
    public Weapon getWeapon(Class<? extends Weapon> weaponType){
        if(weaponType == null){
            return null;
        }

        try{
            return weaponType.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
