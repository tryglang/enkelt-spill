package com.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    private int keyUp;
    private int keyDown;
    private int keyLeft;
    private int keyRight;

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyUp = KeyEvent.VK_W;
        keyDown = KeyEvent.VK_S;
        keyLeft = KeyEvent.VK_A;
        keyRight = KeyEvent.VK_D;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player) {
                //Key event for player 1

                if(key == keyUp) {
                    upPressed = true;
                    tempObject.setVelY(-5);
                }
                if(key == keyLeft) {
                    leftPressed = true;
                    tempObject.setVelX(-5);
                }
                if(key == keyRight) {
                    rightPressed = true;
                    tempObject.setVelX(5);
                }
                if(key == keyDown) {
                    downPressed = true;
                    tempObject.setVelY(5);
                }
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.out.println("Player exits");
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player) {
                //Key event for player 1

                if(key == keyUp) {
                    upPressed = false;
                    if(downPressed) {
                        tempObject.setVelY(5);
                    } else {
                        tempObject.setVelY(0);
                    }
                }
                if(key == keyLeft) {
                    leftPressed = false;
                    if(rightPressed) {
                        tempObject.setVelX(5);
                    } else {
                        tempObject.setVelX(0);
                    }
                }
                if(key == keyRight) {
                    rightPressed = false;
                    if (leftPressed) {
                        tempObject.setVelX(-5);
                    } else {
                        tempObject.setVelX(0);
                    }
                }
                if(key == keyDown) {
                    downPressed = false;
                    if(upPressed) {
                        tempObject.setVelY(-5);
                    } else {
                        tempObject.setVelY(0);
                    }
                }
            }
        }
    }
}
