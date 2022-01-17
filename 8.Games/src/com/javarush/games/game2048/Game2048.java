package com.javarush.games.game2048;

import com.javarush.engine.cell.*;
import javafx.geometry.Side;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellColoredNumber(j, i, gameField[i][j]);
            }
        }
    }

    private void createNewNumber() {
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        if (getMaxTileValue() == 2048) {
            win();
        }
        if (gameField[x][y] != 0) {
            createNewNumber();
        } else {
            if (getRandomNumber(10) == 9) {
                gameField[x][y] = 4;
            } else {
                gameField[x][y] = 2;
            }
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, color, str);
    }

    private Color getColorByValue(int value) {
        if (value == 0) {
            return Color.WHITE;
        }else if (value == 2) {
            return Color.BLUE;
        } else if (value == 4) {
            return Color.AQUA;
        } else if (value == 8) {
            return Color.BLUEVIOLET;
        } else if (value == 16) {
            return Color.DARKORCHID;
        } else if (value == 32) {
            return Color.LAVENDER;
        } else if (value == 64) {
            return Color.TAN;
        } else if (value == 128) {
            return Color.GREEN;
        } else if (value == 256) {
            return Color.YELLOW;
        } else if (value == 512) {
            return Color.ORANGE;
        } else if (value == 1024) {
            return Color.DARKORANGE;
        } else {
            return Color.RED;
        }
    }

    private boolean compressRow(int[] row) {
        boolean ret = false;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (row[i] == 0 && row[j] > row[i]) {
                    row[i] = row[j];
                    row[j] = 0;
                    ret = true;
                }
            }
        }
        return ret;
    }

    private boolean mergeRow(int[] row) {
        boolean ret = false;
        for (int i = 0; i < 3; i++) {
            if (row[i] > 0 && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                ret = true;
                score += row[i];
                setScore(score);
                }
            }
        return ret;
    }

    @Override
    public void onKeyPress(Key key) {
        boolean wasPressed = true;
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                score = 0;
                setScore(score);
                createGame();
                drawScene();
            }
        } else {
            if (!canUserMove()) {
                gameOver();
            } else {
                if (key == Key.LEFT) {
                    moveLeft();
                } else if (key == Key.RIGHT) {
                    moveRight();
                } else if (key == Key.UP) {
                    moveUp();
                } else if (key == Key.DOWN) {
                    moveDown();
                } else {
                    wasPressed = false;
                }
                if (wasPressed) {
                    drawScene();
                }
            }
        }
    }

    private void moveLeft() {
        boolean isNewNumber = false;
        for (int[] row: gameField) {
            boolean compessed = compressRow(row);
            boolean merged = mergeRow(row);
            if (merged) {
                compressRow(row);
            }
            if (compessed || merged) {
                isNewNumber = true;
            }
        }
        if (isNewNumber) {
            createNewNumber();
        }
    }
    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] result = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                result[j][SIDE - 1 - i] = gameField[i][j];
            }
        }
        gameField = result;
    }

    private int getMaxTileValue() {
        int maxNumber = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] > maxNumber) {
                    maxNumber = gameField[i][j];
                }
            }
        }
        return maxNumber;
    }
    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.VIOLET, "WINNER IS YOU!", Color.TAN, 75);
    }

    private boolean canUserMove() {
        boolean ret = false;
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (gameField[y][x] == 0) {
                    ret = true;
                } else if (y < SIDE - 1 && gameField[y][x] == gameField[y + 1][x]) {
                    ret = true;
                } else if ((x < SIDE - 1) && gameField[y][x] == gameField[y][x + 1]) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "You are loh!", Color.AQUA, 75);
    }
}
