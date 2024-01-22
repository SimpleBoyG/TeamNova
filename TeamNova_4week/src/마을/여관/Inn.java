package 마을.여관;

import 마법사.MageClass;
import 마스터.MasterClass;
import 마을.VillageInner;

public class Inn {
    VillageInner vi;
    MasterClass master;
    MageClass mage;
    public Inn(VillageInner vi, MasterClass master, MageClass mage){
        this.vi = vi;
        this.master = master;
        this.mage = mage;
    }


    public void hereInn(){
        System.out.println("안녕하세요. 여기는 여관입니다.");
        System.out.println("잠을 청합니다. 모든 상태가 회복됩니다.");
        master.Hp = master.FullHp;
        mage.Hp = mage.FullHp;
        vi.goVillage();
    }
}
