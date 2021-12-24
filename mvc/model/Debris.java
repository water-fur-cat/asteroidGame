package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;

public class Debris extends Sprite{
    private int nExpiry;

    public Debris(Asteroid astExploded){

        //call Sprite constructor
        super();
        setTeam(Team.DEBRIS);


        //random delta-x
        int nDX = Game.R.nextInt(4);
        if(nDX %2 ==0)
            nDX = -nDX;
        setDeltaX(nDX);

        //random delta-y
        int nDY = Game.R.nextInt(4);
        if(nDY %2 ==0)
            nDY = -nDY;
        setDeltaY(nDY);

        setCenter(astExploded.getCenter());
        setnExpiry(100);

    }
    public void move() {
        super.move();
        expire();
    }

    public void setnExpiry(int nExpiry) {
        this.nExpiry = nExpiry;
    }

    @Override
    public void draw(Graphics g) {

        Point pntCenter = getCenter();
        g.setColor(Color.YELLOW);
        g.fillOval(pntCenter.x, pntCenter.y, nExpiry / 20 , nExpiry / 20);

    }
    public void expire() {
        if(nExpiry > 0) {
            nExpiry--;
        }else {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);;;
            System.gc();
        }
    }
}
