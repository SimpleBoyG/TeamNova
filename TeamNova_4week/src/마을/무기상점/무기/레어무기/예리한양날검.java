package 마을.무기상점.무기.레어무기;

import 마을.무기상점.무기.Weapon;

public class 예리한양날검 extends Weapon {
    protected String  Name = "예리한 양날검";
    protected int Price = 1000;
    protected int PhysicalAttack = 20;
    //protected int MagicAttack = 0;
    protected String WeaponType = "마스터";
    protected String EquipStatus = "<<미착용>>";

    @Override
    public void WeaponSkill(){
        System.out.println("강한 공격 시전");
    }

    @Override
    public String getName() {
        return Name;
    }
    @Override
    public int getPrice() {
        return Price;
    }
    @Override
    public int getPhysicalAttack() {
        return PhysicalAttack;
    }
    @Override
    public int getMagicAttack() {return 0; }
    @Override
    public String getWeaponType() {
        return WeaponType;
    }
    @Override
    public String getEquipStatus() { return EquipStatus; }
    @Override
    public void setEquipStatus(String str) { this.EquipStatus = str; }
}
