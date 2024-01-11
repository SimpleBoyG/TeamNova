package 사냥터;

import 마법사.FireMageClass;
import 마법사.WaterMageClass;
import 마스터.MasterClass;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MonsterSearching{
    static int MonsterCount = 0;
    private static final String[] IMAGES_KEYBOARD = { // 이미지 경로 문자열 저장
            "Image/keyboard.jpg",
            "Image/keyboard_down.png",
            "Image/keyboard_left.png",
            "Image/keyboard_right.png",
            "Image/keyboard_up.png"
    };
    MasterClass master;
    FireMageClass fire;
    WaterMageClass water;
    public MonsterSearching(MasterClass master, FireMageClass fire, WaterMageClass water){
        this.master = master;
        this.fire = fire;
        this.water = water;
    }
    public void MonsterSearching() {
        JFrame frame = new JFrame("조작키");

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

        imgLabel.setBounds(0,0,631,407);

        // 이미지 전시
        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[0]));

        // 객체 선언
        HitMonster HitMonster = new HitMonster();
        HuntingMenu HuntingMenu = new HuntingMenu();

        if (HuntingMenu.HuntingStartMenu() == 1) {
            System.out.println("맵을 탐험합니다.");
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
                        System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        // 이미지 전시
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[4]));
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        char arrowUnicode = '\u25BC';
                        System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[1]));
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        char arrowUnicode = '\u25C0';
                        System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[2]));
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        char arrowUnicode = '\u25B6';
                        System.out.println(arrowUnicode + " 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[3]));
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
        } else {
            System.out.println("도망쳤습니다.");
        }
    }

    public boolean initMonsterCount(HitMonster HitMonster) {
        boolean Result = false;
        // 랜덤한 Hit 값이 결정됨
        HitMonster.setCharacterInfo(master,fire,water);
        if (HitMonster.HitMonsterStatus(MonsterCount) == true) {
            MonsterCount = 0;
            Result = true;
        }
        return Result;
    }
}
