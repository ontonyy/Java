package com.javarush.games.racer;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class Bullet extends GameObject {
    private int[][] matrix = ShapeMatrix.BULLET;
    public boolean drawed = false;
    private int speed = 3;

    public Bullet(PlayerCar player) {
        super(player.x + 2, player.y, ShapeMatrix.BULLET);
    }

    public void move() {
        this.y -= speed;
    }
}
