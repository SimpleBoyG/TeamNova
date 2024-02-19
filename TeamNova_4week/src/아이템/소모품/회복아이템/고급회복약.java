package 아이템.소모품.회복아이템;

import 아이템.소모품.Expendables;

public class 고급회복약 extends Expendables {
    String Name;
    int RecoveryPoint = 100;
    int price = 200;

    public 고급회복약() {
        super("고급 회복약", 200);
        Name ="고급 회복약";
        price = 200;
    }

    @Override
    public int getRecoveryPoint() {
        return RecoveryPoint;
    }
}
