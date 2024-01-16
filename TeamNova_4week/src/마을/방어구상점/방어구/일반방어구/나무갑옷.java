package 마을.방어구상점.방어구.일반방어구;

import 마을.방어구상점.방어구.Armor;

public class 나무갑옷 extends Armor {
    protected String Name = "나무 갑옷";
    protected int Price = 500;
    protected int Defence = 5;
    protected String ArmorType = "마스터";
    protected String EquipStatus = "<<미착용>>";

    @Override
    public void ArmorSkill() {
        System.out.println("일반 방어구는 방어구 스킬이 없습니다.");
    }

    @Override
    public String getName() { return Name; }

    @Override
    public int getPrice() { return Price; }

    @Override
    public int getDefence() { return Defence; }

    @Override
    public String getArmorType() { return ArmorType; }

    @Override
    public String getEquipStatus() { return EquipStatus; }

    @Override
    public void setEquipStatus(String str) { this.EquipStatus = str; }
}
