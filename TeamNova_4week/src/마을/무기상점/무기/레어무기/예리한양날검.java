package 마을.무기상점.무기.레어무기;

import 마을.무기상점.무기.Weapon;

public class 예리한양날검 extends Weapon {
    String  Name = "예리한 양날검";
    int Price = super.getPrice() + 2000;
    int PhysicalAttack = super.getPhysicalAttack() + 20;
    int MagicAttack = 0;
    String WeaponType = "마스터";
    String EquipStatus = "<<미착용>>";

    @Override
    public void WeaponSkill(){
        System.out.println("강한 공격 시전");
    }
}
