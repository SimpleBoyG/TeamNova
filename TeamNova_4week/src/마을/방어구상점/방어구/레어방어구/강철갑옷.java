package 마을.방어구상점.방어구.레어방어구;

import 마을.방어구상점.방어구.Armor;

public class 강철갑옷 extends Armor {
    protected String Name = "강철 갑옷";
    protected int Price = 1000;
    protected int Defence = 10;
    protected String ArmorType = "마스터";
    protected String EquipStatus = "<<미착용>>";

    @Override
    public void ArmorSkill() {
        System.out.println("방어구 스킬을 사용합니다.");
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
