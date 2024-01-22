package 마을.아이템상점.아이템;

public abstract class Item {
    public int PriceRate = 0;
    public abstract int getRecoveryPoint();
    public abstract int getPrice();
    public abstract String getName();
}
