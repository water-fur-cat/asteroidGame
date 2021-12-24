package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;

public class Explosion extends Sprite{
    private Point pntCenter;
    //this causes movement; change in x and change in y

    //the radius of circumscibing circle
    private int nRadius = 10;
    private int lRadius = 10;
    //is this DEBRIS, FRIEND, FOE, OR FLOATER
    //private byte yFriend;
    //degrees (where the sprite is pointing out of 360)
    //  private int nOrientation;
    private int nExpiry = 20; //natural mortality (short-living objects)
    //the color of this sprite
    //   private Color col;
    private int randRadius;

    public Explosion(Asteroid asteroid) {
        this.pntCenter = asteroid.getCenter();
        setTeam(Team.DEBRIS);
    }

    @Override
    public void move() {
        super.move();
        expire();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(200 + Game.R.nextInt(56), Game.R.nextInt(256),Game.R.nextInt(1)));
        randRadius = Game.R.nextInt(nRadius);
        g.fillOval(pntCenter.x - Game.R.nextInt(nRadius), pntCenter.y - Game.R.nextInt(nRadius), randRadius , randRadius);
        g.fillOval(pntCenter.x - Game.R.nextInt(nRadius), pntCenter.y - Game.R.nextInt(nRadius), randRadius , randRadius);

        g.setColor(new Color(Game.R.nextInt(256), Game.R.nextInt(256),Game.R.nextInt(256)));
        for (int i = 0; i <= 10; i++) {
            double weightSin = Math.sin(Math.toRadians(i * 36));
            double weightCos = Math.cos(Math.toRadians(i * 36));
            //g.drawLine((int)(pntCenter.x + lRadius * weightCos) - Game.R.nextInt(nRadius), (int)(pntCenter.y + lRadius * weightSin)  - Game.R.nextInt(nRadius), (int)(pntCenter.x + lRadius * weightCos)  - Game.R.nextInt(nRadius), (int)(pntCenter.y + lRadius * weightSin) - Game.R.nextInt(nRadius));
            g.fillOval((int)(pntCenter.x + lRadius * weightCos), (int)(pntCenter.y + lRadius * weightSin), randRadius/2 , randRadius/2);
        }

    }

    @Override
    public int points() {
        return super.points();
    }

    //called every 45 ms
    public void expire() {
        if(nExpiry>0) {
            if (nExpiry > 10) {
                nRadius += 1;
            } else {
                nRadius -= 1;
            }
//            lRadius += 5;
            nExpiry--;
        }else {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);;
            System.gc();
        }
    }
}

