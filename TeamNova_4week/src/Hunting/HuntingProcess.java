package Hunting;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HuntingProcess {
    static int MonsterCount = 0;
    public void HuntingProcess(){

        JFrame frame = new JFrame("조작키");

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        frame.add(textArea);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // 객체 선언
        HitMonster HitMonster = new HitMonster();
        HuntingMenu HuntingMenu = new HuntingMenu();
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // keyTyped 이벤트는 특수 키에 대한 정보를 제공하지 않습니다.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // keyPressed 이벤트에서 화살표 키 입력을 감지합니다.
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("위쪽 방향으로 걸었습니다");
                    MonsterCount++;
                    initMonsterCount(HitMonster);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("아래쪽 방향으로 걸었습니다");
                    MonsterCount++;
                    initMonsterCount(HitMonster);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("왼쪽 방향으로 걸었습니다");
                    MonsterCount++;
                    initMonsterCount(HitMonster);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("오른쪽 방향으로 걸었습니다");
                    MonsterCount++;
                    initMonsterCount(HitMonster);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // keyReleased 이벤트도 활용할 수 있습니다.
            }
        });
    }

    public void initMonsterCount(HitMonster HitMonster){
        // 랜덤한 Hit 값이 결정됨
        if(HitMonster.MonterHitMotion(MonsterCount) == true){
            MonsterCount = 0;
        }
    }
}
