package 아이템.방어구;

import 아이템.Item;

public class Armor extends Item {
    protected int Defence;
    protected String ArmorType;
    protected String EquipStatus;
    public Armor(String Name, int Price, int Defence, String ArmorType, String EquipStatus){
        super(Name,Price);
        this.Defence = Defence;
        this.ArmorType = ArmorType;
        this.EquipStatus = EquipStatus;
    }

    // Getter
    public int getDefence() { return Defence; }


    public String getArmorType() { return ArmorType; }


    public String getEquipStatus() { return EquipStatus; }


    public void setEquipStatus(String str) { this.EquipStatus = str; }
}
