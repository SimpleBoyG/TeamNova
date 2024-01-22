package 마을.아이템상점.아이템;
public class ItemInstanceSend {
    // 클래스 타입을 사용하는 팩토리 메서드
    public Item getItem(Class<? extends Item> itemType){
        if(itemType == null){
            return null;
        }

        try{
            return itemType.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
