package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;

public class Cruise_2 extends Sprite{

    private final double FIRE_POWER = 15.0;
    private final int MAX_EXPIRE = 50;

    public double[] dLengthsAlts;
    public double[] dDegreesAlts;

    public Cruise_2(Falcon fal) {

        super();
        setTeam(Team.FRIEND);
        //defined the points on a cartesean grid
        ArrayList<Point> pntCs = new ArrayList<Point>();

        pntCs.add(new Point(0, 10));
        pntCs.add(new Point(5, 7));
        pntCs.add(new Point(6, 4));
        pntCs.add(new Point(6, 0));
        pntCs.add(new Point(4, 4));
        pntCs.add(new Point(3, 5));

        pntCs.add(new Point(0, 5));

        pntCs.add(new Point(-3, 5));
        pntCs.add(new Point(-4, 4));
        pntCs.add(new Point(-6, 0));
        pntCs.add(new Point(-6, 4));
        pntCs.add(new Point(-5, 7));
        pntCs.add(new Point(0, 10));
        assignPolarPoints(pntCs);

        //a cruise missile expires after 25 frames
        setExpire(MAX_EXPIRE);
        setRadius(20);

        int newOri = fal.getOrientation() - 50 + Game.R.nextInt(100);

        setDeltaX(fal.getDeltaX()
                + Math.cos(Math.toRadians(newOri)) * FIRE_POWER);
        setDeltaY(fal.getDeltaY()
                + Math.sin(Math.toRadians(newOri)) * FIRE_POWER);
        setCenter(fal.getCenter());

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(newOri);
        setColor(Color.WHITE);

    }

    //assign for alt image
    protected void assignPolorPointsAlts(ArrayList<Point> pntCs) {
        dDegreesAlts = convertToPolarDegs(pntCs);
        dLengthsAlts = convertToPolarLens(pntCs);
    }

    public void move() {

        super.move();

        Point pnt = getCenter();

        if (pnt.x > getDim().width || pnt.x < 0) {
            setDeltaX(-getDeltaX());
            setOrientation(180 - getOrientation());
        } else if(pnt.y > getDim().height || pnt.y < 0){
            setDeltaY(-getDeltaY());
            setOrientation(-getOrientation());
        }

        double dX = pnt.x + getDeltaX();
        double dY = pnt.y + getDeltaY();

        setCenter(new Point((int) dX, (int) dY));

        if (getExpire() < MAX_EXPIRE -5){
            setDeltaX(getDeltaX() * 1.07);
            setDeltaY(getDeltaY() * 1.07);
        }

        if (getExpire() == 0)
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);

        else
            setExpire(getExpire() - 1);

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.RED);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

}

