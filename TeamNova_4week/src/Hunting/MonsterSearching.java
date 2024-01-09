package Hunting;

import Mage.FireMageClass;
import Mage.WaterMageClass;
import Master.MasterClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

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

        frame.setBounds(0, 0, 700, 600);
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

        //JLabel imgLabelDown = new JLabel();
//        JLabel imgLabelLeft = new JLabel();
//        JLabel imgLabelRight = new JLabel();
//        JLabel imgLabelUp = new JLabel();
        imgLabel.setBounds(0,0,631,407);
        //imgLabelDown.setBounds(0,0,631,407);
//        imgLabelLeft.setBounds(0,0,631,407);
//        imgLabelRight.setBounds(0,0,631,407);
//        imgLabelUp.setBounds(0,0,631,407);

        // 이미지 전시
        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[0]));

//        imgLabelLeft.setIcon(new ImageIcon(IMAGES_KEYBOARD[2]));
//        imgLabelRight.setIcon(new ImageIcon(IMAGES_KEYBOARD[3]));
//        imgLabelUp.setIcon(new ImageIcon(IMAGES_KEYBOARD[4]));
        //frame.getContentPane().add(imgLabelBasic);


        // 이미지 전시

        //showKeyboardImage(frame,imgLabelBasic);

        // 객체 선언
        HitMonster HitMonster = new HitMonster();
        HuntingMenu HuntingMenu = new HuntingMenu();

        if (HuntingMenu.HuntingStartMenu() == 1) {
            PanerTest.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    // keyTyped 이벤트는 특수 키에 대한 정보를 제공하지 않습니다.
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    // keyPressed 이벤트에서 화살표 키 입력을 감지합니다.
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        System.out.println("위쪽 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        // 이미지 전시
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[4]));
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        System.out.println("아래쪽 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[1]));
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        System.out.println("왼쪽 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[2]));
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        System.out.println("오른쪽 방향으로 걸었습니다");
                        initMonsterCount(HitMonster);
                        MonsterCount++;
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[3]));
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // keyReleased 이벤트도 활용할 수 있습니다.
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[0]));
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[0]));
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[0]));
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        imgLabel.setIcon(new ImageIcon(IMAGES_KEYBOARD[0]));
                    }

                }
            });
        } else {
            System.out.println("미구현");
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

    public void showKeyboardImage(JFrame frame,JLabel imgLabel){

    }
}
