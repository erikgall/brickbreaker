package BrickBreaker;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import BrickBreaker.Game.Ball;
import BrickBreaker.Game.Brick;
import java.awt.event.KeyEvent;
import BrickBreaker.Game.Goalie;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {

    protected Ball ball;

    protected Goalie goalie;

    protected ArrayList<Brick> pieces;

    protected int panelHeight;

    protected int panelWidth;

    protected JLabel score;

    protected boolean gameStarted = false;

    protected int time;

    protected int pointTotal = 0;

    public GamePanel(int time) {

        super();

        this.time = time;

        this.setBoard();

        addKeyListener(this);
    }

    public int getTime() {
        return this.time;
    }

    public void incrementTimer() {

        this.time++;

        this.timeEvent();

    }

    public void resetTime() {
        this.time = 0;
    }

    public void startGame() {

        this.gameStarted = true;

        this.score = new JLabel("Score: " + this.pointTotal);
        this.score.setFont(new Font("PT Sans", Font.PLAIN, 16));
        this.add(this.score);


    }

    public boolean gameOver() {
        return this.gameStarted == false;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        this.requestFocusInWindow();

        this.buildGamePanel();

        if (this.gameStarted == false) {
            this.buildGamePanel();
        }

        for (Brick brick : this.pieces) {

            brick.draw(g);

        }

        this.ball.draw(g);
        this.goalie.draw(g);

        Dimension dimension = this.getSize();

        this.panelWidth = (int) dimension.getWidth();
        this.panelHeight = (int) dimension.getHeight();

    }

    protected boolean ballIntersectsGoalie() {

        this.goalie.setRect(this.goalie.x, this.goalie.y, this.goalie.width, this.goalie.height);
        this.ball.setRect(this.ball.x, this.ball.y, this.ball.width, this.ball.height);

        return this.goalie.intersects(this.ball);


    }

    protected boolean ballIntersectsBrick() {

        this.ball.setRect(this.ball.x, this.ball.y, this.ball.width, this.ball.height);

        for (Brick brick : this.pieces) {

            if (brick.valid && this.ball.intersects(brick)) {

                brick.valid = false;

                this.pointTotal++;

                this.score.setText("Score: " + this.pointTotal);

                if (this.pointTotal == 5 || this.pointTotal == 10) {

                    this.ball.incrementBallSpeed();

                }

                return true;

            }

        }

        return false;

    }


    protected void buildGamePanel() {

        int row = 1;
        int count = 1;
        int padding = 50;
        int x = 25;

        for (Brick brick : this.pieces) {


            if (count == 1) {
                x = 25;
            }
            else {

                x += 95;

            }

            int y = (15*row) + (50*row);

            brick.setPosition(x, y);

            if (count == 10) {

                row++;
                count = 0;

            }

            count++;
        }
    }

    protected void setBoard() {

        this.ball = new Ball();

        this.goalie = new Goalie();

        this.pieces = new ArrayList<>();

        this.setGamePieces();
    }

    protected void setGamePieces() {

        for (int i = 0; i < 30; i++) {

            this.pieces.add(new Brick());

        }

    }

    protected void timeEvent() {

        if (this.time == 3) {
            this.ball.startGame();
            this.ball.move();
        }

        if (this.gameStarted) {

            this.triggerBallEvent();

        }

        this.validate();
        this.repaint();
    }

    protected void moveBall() {

        if (this.ball.x <= 6) {

            this.ball.moveRight();

        } else if (this.ball.x >= 970) {

            this.ball.moveLeft();

        }

        if (this.ball.y <= 6 ) {

            this.ball.moveDown();

        } else if (this.ball.y >= 711) {

            this.gameStarted = false;

        }

        this.ball.move();
    }

    protected void triggerBallEvent() {
        if (this.ballIntersectsGoalie()) {

            this.ball.hitGoalieEvent();

        } else if (this.ballIntersectsBrick()) {

            this.ball.hitBrickEvent();

        }
        else {

            this.moveBall();

        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (this.goalie.x >= 20 && e.getKeyCode() == 37) {
            this.goalie.moveLeft();
        }
        else if (this.goalie.x <= 880 && e.getKeyCode() == 39) {

            this.goalie.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
