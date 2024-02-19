package 아이템;

public abstract class Item{
    private String Name;
    private int Price;
    public Item(String Name, int Price){
        this.Name = Name;
        this.Price = Price;
    }
    public int getPrice(){
        return Price;
    };
    public String getName(){
        return Name;
    };
}
