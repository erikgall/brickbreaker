package BrickBreaker.Game;

import java.awt.*;

/**
 * Created by erikgalloway on 5/9/16.
 */
public class Goalie extends Rectangle {

    public int x = 400;
    public int y = 700;

    public int height = 10;
    public int width = 100;

    public Goalie() {

    }

    public void draw(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(Color.WHITE);
        g.drawRect(this.x, this.y, this.width, this.height);

    }

    public void moveLeft() {this.x -= 25;}

    public void moveRight() {this.x += 25;}
}
