package 마을.방어구상점.방어구;

public abstract class Armor {
    public abstract void ArmorSkill();

    // Getter
    public abstract String getName();

    public abstract int getPrice();

    public abstract int getDefence();

    public abstract String getArmorType();

    public abstract String getEquipStatus();

    public abstract void setEquipStatus(String str);
}
