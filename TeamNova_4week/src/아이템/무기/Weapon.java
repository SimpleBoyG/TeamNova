package 아이템.무기;

import 아이템.Item;

public class Weapon extends Item {
    int Attack;
    int MagicAttack;
    String WeaponType;
    String EquipStatus;

    public Weapon(String Name, int Price, int Attack, int MagicAttack,String WeaponType, String EquipStatus){
        super(Name,Price);
        this.Attack = Attack;
        this.MagicAttack = MagicAttack;
        this.WeaponType = WeaponType;
        this.EquipStatus = EquipStatus;
    }

    // Getter
    public int getPhysicalAttack() {
        return Attack;
    }

    public int getMagicAttack() {return MagicAttack; }

    public String getWeaponType() {
        return WeaponType;
    }

    public String getEquipStatus() { return EquipStatus; }

    public void setEquipStatus(String str) { this.EquipStatus = str; }
}
