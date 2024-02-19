package 아이템.소모품;

import 아이템.Item;

public abstract class Expendables extends Item {

    public Expendables(String Name, int Price) {
        super(Name, Price);
    }

    public abstract int getRecoveryPoint();

}
