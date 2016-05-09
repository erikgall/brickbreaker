package BrickBreaker;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameFrame extends JFrame implements ActionListener {

    protected GamePanel gamePanel;

    protected MainMenu menu;

    protected Timer gameTimer;

    protected int time = 0;

    public GameFrame() {

        super("Brick Breaker by: Erik Galloway");

        this.buildGameFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();


        if (obj == this.menu.getStart()) {

            this.startGame();


        }

        if (obj == this.gameTimer) {

            this.time++;

            this.gamePanel.incrementTimer();

            if (this.time > 0 && this.gamePanel.gameOver()) {

                this.remove(this.gamePanel);
                this.add(this.menu);
                this.gameTimer.stop();
                this.time = 0;
                this.gamePanel.resetTime();

                this.validate();
                this.repaint();
            }
        }



    }

    protected void buildGameFrame() {
        this.getContentPane().setLayout(new BorderLayout());

        this.buildMenu();

        this.createTimer();

        this.setDefaults();

    }

    protected void buildMenu() {

        this.menu = new MainMenu();

        menu.start.addActionListener(this);

        this.getContentPane().add(menu);
    }

    protected void createTimer() {
        this.gameTimer = new Timer(10, this);
    }

    protected void setDefaults() {

        this.setSize(1000, 800);

        this.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected void startGame() {

        this.remove(menu);

        this.gamePanel = new GamePanel(this.time);

        this.add(this.gamePanel);

        this.gamePanel.startGame();

        this.validate();

        this.repaint();

        this.gameTimer.start();


    }
}
