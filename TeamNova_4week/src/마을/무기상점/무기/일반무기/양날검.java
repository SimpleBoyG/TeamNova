package 마을.무기상점.무기.일반무기;

import 마을.무기상점.무기.Weapon;

public class 양날검 extends Weapon {
    public 양날검(){
        this.Name = "양날검";
        this.Price = super.getPrice() + 1000;
        this.PhysicalAttack = super.getPhysicalAttack() + 10;
        this.WeaponType = "마스터";
        this.EquipStatus = "<<미착용>>";
    }
}
