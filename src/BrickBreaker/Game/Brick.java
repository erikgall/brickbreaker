package BrickBreaker.Game;

import java.awt.*;

/**
 * Created by erikgalloway on 5/8/16.
 */
public class Brick extends Rectangle {

    public int width = 90;

    public int height = 15;

    public int x;

    public int y;

    public boolean valid = true;

    public Brick() {}

    public void setPosition(int x, int y) {

        this.x = x;
        this.y = y;

        this.setRect(this.x, this.y, this.width, this.height);

    }

    public void draw(Graphics g) {

        if (valid) {

            this.drawBrick(g);

        }

    }

    protected void drawBrick(Graphics g) {

        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, this.width, this.height);

    }
}
