package 마을.아이템상점.아이템.소모품;

import 마을.아이템상점.아이템.Item;

public class 고급회복약 extends Item {
    String Name = "고급 회복약";
    int RecoveryPoint = 100;
    int price = super.PriceRate * 200;

    @Override
    public int getRecoveryPoint() {
        return RecoveryPoint;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return Name;
    }
}
