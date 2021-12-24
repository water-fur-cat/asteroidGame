package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Life {
    private int x;
    private int y;
    private int width = 40;
    private int height = 10;
    private int life;
    public Life(){
        super();
    }
    public Life(int x, int y, int life){
        super();
        this.x = x;
        this.y = y;
        this.life = life;
    }

    public int getX() {
        return x;
    }
    public void setX(int x){
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D r2 = new Rectangle2D.Double(x , y-height, width, height);
        g2.setColor(Color.YELLOW);
        g2.draw(r2);
        Rectangle2D r = new Rectangle2D.Double(x+1,y-height+1,width*((double)life/100)-1, height-1);
        g2.setColor(Color.RED);
        g2.fill(r);
    }
}
