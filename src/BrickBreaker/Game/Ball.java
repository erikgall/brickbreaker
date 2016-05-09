package BrickBreaker.Game;

import java.awt.*;

public class Ball extends Rectangle {

    protected boolean gameStarted = false;
    protected boolean isMovingUp = true;
    protected boolean isMovingRight = true;

    public int x = 400;
    public int y = 400;

    public int width = 10;
    public int height = 10;

    protected int xSpeed = 2;
    protected int ySpeed = 2;

    public Ball() {
        this.isMovingRight = Math.random() < 0.5;
    }

    public void startGame() {
        this.gameStarted = true;
        this.isMovingUp = true;
    }

    public void incrementBallSpeed() {

        this.ySpeed += 2;
        this.xSpeed += 1;
    }

    public void move() {

        if (this.isMovingUp) {
            this.y -= this.ySpeed;
        } else {
            this.y += this.ySpeed;

        }

        if (this.isMovingRight) {
            this.x += this.xSpeed;
        } else {
            this.x -= this.xSpeed;
        }

    }

    public boolean isMovingRight() {
        return this.isMovingRight;
    }

    public boolean isMovingDown() {
        return this.isMovingUp == false;
    }


    public void moveDown() {

        this.isMovingUp = false;

    }

    public void moveLeft() {
        this.isMovingRight = false;
    }

    public void moveUp() {

        this.isMovingUp = true;

    }

    public void moveRight() {

        this.isMovingRight = true;


    }

    public void hitGoalieEvent() {

        this.moveUp();

        if (this.isMovingRight) {

            this.moveRight();

        } else {
            this.moveLeft();
        }


        this.move();
    }

    public void hitBrickEvent() {

        if (this.isMovingRight()) {

            this.moveLeft();
        } else {

            this.moveRight();
        }

        if (this.isMovingDown()) {

            this.moveUp();
        } else {

            this.moveDown();
        }

        this.move();
    }

    public void draw(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillOval(this.x, this.y, this.width, this.height);
        g.setColor(Color.BLACK);
        g.drawOval(this.x, this.y, this.width, this.height);

    }


}
