package 마을.무기상점.무기;

public abstract class Weapon {
    public abstract void WeaponSkill();

    // Getter
    public abstract String getName();

    public abstract int getPrice();

    public abstract int getPhysicalAttack();

    public abstract int getMagicAttack();

    public abstract String getWeaponType();

    public abstract String getEquipStatus();

    public abstract void setEquipStatus(String str);
}
