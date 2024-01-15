package 마을.방어구상점.방어구;

public class Armor {
    public String Name;
    public int Price;
    public int DefenceValue;
    public String ArmorType;
    public String Status = "<<미착용>>";
    public Armor(String Name, int Price, int DefenceValue, String ArmorType){
        this.Name = Name;
        this.Price = Price;
        this.DefenceValue = DefenceValue;
        this.ArmorType = ArmorType;
    };
}
