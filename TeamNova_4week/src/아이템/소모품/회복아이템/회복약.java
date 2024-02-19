package 아이템.소모품.회복아이템;

import 아이템.소모품.Expendables;

public class 회복약 extends Expendables {

    int RecoveryPoint = 50;

    public 회복약() {
        super("회복약", 100);
    }

    @Override
    public int getRecoveryPoint() {
        return RecoveryPoint;
    }
}
