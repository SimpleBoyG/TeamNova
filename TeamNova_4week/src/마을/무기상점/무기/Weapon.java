package 마을.무기상점.무기;

public class Weapon {
    public String Name = "";
    public int Price = 0;
    public int PhysicalAttack = 0;
    public int MagicAttack = 0;
    public String WeaponType = "";
    public String EquipStatus = "";

    public void WeaponSkill(){
        System.out.println("일반 무기는 무기 스킬이 없습니다.");
    }
    // Getter
    public String getName() {
        return Name;
    }

    public int getPrice() {
        return Price;
    }

    public int getPhysicalAttack() {
        return PhysicalAttack;
    }

    public int getMagicAttack() {
        return MagicAttack;
    }

    public String getWeaponType() {
        return WeaponType;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setPhysicalAttack(int physicalAttack) {
        PhysicalAttack = physicalAttack;
    }

    public void setMagicAttack(int magicAttack) {
        MagicAttack = magicAttack;
    }

    public void setWeaponType(String weaponType) {
        WeaponType = weaponType;
    }

}
