package com.game;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH -48);
        y = Game.clamp(y, 0, Game.HEIGHT -71);

        collision();
    }
    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision code
                    if (HUD.HEALTH == 0) {
                        System.out.println("Dead");
                    } else {
                        HUD.HEALTH -= 2;
                        System.out.println("ouch!");
                    }
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if(id == ID.Player) g.setColor(Color.WHITE);
        g.fillRect(x,y,32,32);

    }
}
