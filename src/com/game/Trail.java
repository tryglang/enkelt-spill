package com.game;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private float life;

    private Color color;

    private int width, heigth;
//    life kan være mellom 0.001 og 0.1

    public Trail(int x, int y, ID id, Handler handler, Color color, int width, int height, float life) {
        super(x, y, id, handler);
        this.color = color;
        this.width = width;
        this.heigth = height;
        this.life = life;
    }

    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= life - 0.001f;
        } else handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x, y, width,heigth);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
