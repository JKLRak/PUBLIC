package Main;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class Main {
    public static void main(String[] args) {
        System.out.printf("START \n");
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Battleships");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

       mouseHandler M = new mouseHandler(gamePanel);
       window.getContentPane().addMouseListener(M);

    }
}