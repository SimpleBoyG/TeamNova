package 마법사;

import 마법사.스킬.Skill;

import java.util.ArrayList;
import java.util.Scanner;

public class SkillSet {
    ArrayList<Skill> SkillPackage = new ArrayList<>();
    ArrayList<Skill> HaveSkillSet = new ArrayList<>(){};
    MageClass mage = null;

    SkillManager sm = new SkillManager();
    Scanner sc = new Scanner(System.in);

    public SkillSet(MageClass mage) {
        this.mage = mage;
        HaveSkillSet.add(sm.FireSkill_Level1);
        HaveSkillSet.add(sm.FireSkill_Level2);
        HaveSkillSet.add(sm.FireSkill_Level3);
        HaveSkillSet.add(sm.FireSkill_Level4);
        mage.HaveSkillList = HaveSkillSet;
    }

    public boolean showSkillList() {
        SkillPackage = sm.getSkillPackage();
        for (int i = 0; i < SkillPackage.size(); i++) {
            System.out.printf("%d) 스킬명 : %s / 데미지 : %d / 스킬 등급 : %d \n", i, SkillPackage.get(i).SkillName,
                    SkillPackage.get(i).Add_MagicAttack, SkillPackage.get(i).Magic_Grade);
        }
        System.out.println("사용하시길 원하는 스킬을 선택해주세요.");
        SelectSkill();
        ShowHaveSkillList();
        System.out.println("선택을 완료했습니다.");
        System.out.println("사냥터로 떠납니다");
        return true;
    }

    public void SelectSkill() {
        HaveSkillSet.clear();
        // 4가지 스킬 선택
        while (HaveSkillSet.size() < 4) {
            int SelectSkill = sc.nextInt();
            if (SelectSkill < SkillPackage.size()) {
                HaveSkillSet.add(SkillPackage.get(SelectSkill));
            }else{
                System.out.println("선택을 잘못 하셨습니다. 다시 선택해주세요.");
            }
        }
    }

    // 4가지
    public void ShowHaveSkillList() {
        for (int i = 0; i < HaveSkillSet.size(); i++) {
            System.out.printf("%d) 스킬명 : %s / 데미지 : %d / 스킬 등급 : %d \n", i, HaveSkillSet.get(i).SkillName,
                    HaveSkillSet.get(i).Add_MagicAttack, HaveSkillSet.get(i).Magic_Grade);
        }
        // 마법사가 가지는 스킬에 입력
        mage.HaveSkillList = HaveSkillSet;
    }

    ;
}
