package BrickBreaker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {

    protected JLabel title;

    protected JLabel caption;

    protected JButton start;

    public MainMenu() {

        super();

        this.setLayout(null);

        this.setBackground(Color.WHITE);

        this.buildMenu();


    }

    public JButton getStart() {
        return this.start;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();

    }

    protected void buildMenu() {

        this.setTitle();
        this.setCaption();
        this.setStartButton();

    }

    protected void setCaption() {
        this.caption = new JLabel("By: Erik Galloway");
        this.caption.setFont(new Font("PT Sans", Font.PLAIN, 36));
        this.caption.setBounds(325, 100, 1000, 300);
        this.add(this.caption);
    }

    protected void setStartButton() {


        this.start = new JButton("START");
        this.start.addActionListener(this);
        this.start.setBounds(300, 450, 325, 50);
        this.add(this.start);

    }

    protected void setTitle() {
        this.title = new JLabel("Brick Breaker");
        this.title.setFont(new Font("PT Sans", Font.PLAIN, 54));
        this.title.setBounds(300, 10, 1000, 300);
        this.add(this.title);
    }
}
