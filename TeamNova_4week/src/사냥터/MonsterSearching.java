package 사냥터;

import 캐릭터.마법사.MageClass;
import 캐릭터.마스터.MasterClass;
import 마을.VillageInner;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MonsterSearching {
    static int MonsterCount = 0;
    MasterClass master;
    MageClass mage;
    VillageInner vi;
    사냥터 사냥터;
    JFrame frame;
    private static final String[] IMAGES_KEYBOARD = { // 이미지 경로 문자열 저장
            "Image/keyboard.jpg",
            "Image/keyboard_down.png",
            "Image/keyboard_left.png",
            "Image/keyboard_right.png",
            "Image/keyboard_up.png"
    };

    public MonsterSearching(MasterClass master, MageClass mage, VillageInner vi, 사냥터 사냥터) {
        this.master = master;
        this.mage = mage;
        this.vi = vi;
        this.사냥터 = 사냥터;
    }

    public void MonsterSearching() {
        frame = new JFrame("조작키");

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        frame.add(textArea);

        frame.setBounds(0, 0, 641, 417);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.getContentPane().setLayout(null);
        JPanel PanerTest = new JPanel();
        PanerTest.setLayout(null);
        frame.setContentPane(PanerTest);


        frame.setVisible(true);
        // 라벨 생성
        JLabel imgLabel = new JLabel();
        PanerTest.add(imgLabel);
        PanerTest.setFocusable(true);
        PanerTest.requestFocus();

        imgLabel.setBounds(0, 0, 631, 407);

        // 이미지 전시
        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[0]));

        // 객체 선언
        HitMonster HitMonster = new HitMonster(사냥터);

        System.out.println("맵을 탐험합니다.");
        System.out.println("방향키를 조정해주세요.");
        PanerTest.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // keyTyped 이벤트는 특수 키에 대한 정보를 제공하지 않습니다.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // keyPressed 이벤트에서 화살표 키 입력을 감지합니다.
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    char arrowUnicode = '\u25B2';
                    MonsterCount++;
                    System.out.printf("============ %d =============\n", MonsterCount);
                    System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                    System.out.println("==========================");
                    imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[4]));
                    initMonsterCount(HitMonster);
                    // 이미지 전시

                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    char arrowUnicode = '\u25BC';
                    MonsterCount++;
                    System.out.printf("============ %d =============\n", MonsterCount);
                    System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                    System.out.println("==========================");
                    imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[1]));
                    initMonsterCount(HitMonster);

                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    char arrowUnicode = '\u25C0';
                    MonsterCount++;
                    System.out.printf("============ %d =============\n", MonsterCount);
                    System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                    System.out.println("==========================");
                    imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[2]));
                    initMonsterCount(HitMonster);

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    char arrowUnicode = '\u25B6';
                    MonsterCount++;
                    System.out.printf("============ %d =============\n", MonsterCount);
                    System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                    System.out.println("==========================");
                    imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[3]));
                    initMonsterCount(HitMonster);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public boolean initMonsterCount(HitMonster HitMonster) {
        boolean Result = false;
        // 랜덤한 Hit 값이 결정됨
        HitMonster.setCharacterInfo(master, mage);
        if (HitMonster.HitMonsterStatus(MonsterCount) == true) {
            MonsterCount = 0;
            frame.dispose();
            사냥터.BattleZone();
            Result = true;
        }
        return Result;
    }
}
