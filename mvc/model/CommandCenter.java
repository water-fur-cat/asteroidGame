package edu.uchicago.gerber._08final.mvc.model;



import edu.uchicago.gerber._08final.mvc.controller.Sound;

import java.util.ArrayList;
import java.util.List;


public class CommandCenter {

	public static int nNumFalcon;
	private static int nLevel;
	private static long lScore;
	private static Falcon falShip;
	private  boolean bPlaying;
	private  boolean bPaused;
	private static int nNumShield;
	private static int nCircle;
	private static int nKill;
	
	// These ArrayLists with capacities set
	public static List<Movable> movDebris = new ArrayList<Movable>(300);
	public List<Movable> movFriends = new ArrayList<Movable>(100);
	public List<Movable> movFoes = new ArrayList<Movable>(200);
	public List<Movable> movFloaters = new ArrayList<Movable>(50);

	private GameOpsList opsList = new GameOpsList();


	private static CommandCenter instance = null;

	// Constructor made private - static Utility class only
	private CommandCenter() {}


	public static CommandCenter getInstance(){
		if (instance == null){
			instance = new CommandCenter();
		}
		return instance;
	}


	public  void initGame(){
		setLevel(1);
		setScore(0);
		setNumFalcons(3);
		setNumShield(3);
		setNumKill(1);
		setNumCircle(3);
		spawnFalcon(true);
	}
	
	// The parameter is true if this is for the beginning of the game, otherwise false
	// When you spawn a new falcon, you need to decrement its number
	public void spawnFalcon(boolean bFirst) {
		if (getNumFalcons() != 0) {
			falShip = new Falcon();

			opsList.enqueue(falShip, CollisionOp.Operation.ADD);
			if (!bFirst)
			    setNumFalcons(getNumFalcons() - 1);
		}
		
		Sound.playSound("shipspawn.wav");

	}

	public GameOpsList getOpsList() {
		return opsList;
	}

	public void setOpsList(GameOpsList opsList) {
		this.opsList = opsList;
	}

	public  void clearAll(){
		movDebris.clear();
		movFriends.clear();
		movFoes.clear();
		movFloaters.clear();
	}

	public  boolean isPlaying() {
		return bPlaying;
	}

	public  void setPlaying(boolean bPlaying) {
		this.bPlaying = bPlaying;
	}

	public  boolean isPaused() {
		return bPaused;
	}

	public  void setPaused(boolean bPaused) {
		this.bPaused = bPaused;
	}
	
	public  boolean isGameOver() {		//if the number of falcons is zero, then game over
		if (getNumFalcons() == 0) {
			return true;
		}
		return false;
	}

	public  int getLevel() {
		return nLevel;
	}

	public static long getScore() {
		return lScore;
	}

	public static void setScore(long lParam) {
		lScore = lParam;
	}

	public  void setLevel(int n) {
		nLevel = n;
	}

	public  int getNumFalcons() {
		return nNumFalcon;
	}

	public  void setNumFalcons(int nParam) {
		nNumFalcon = nParam;
	}
	
	public  Falcon getFalcon(){
		return falShip;
	}
	
	public  void setFalcon(Falcon falParam){
		falShip = falParam;
	}

	public static List<Movable> getMovDebris() {
		return movDebris;
	}

	public  List<Movable> getMovFriends() {
		return movFriends;
	}


	public  List<Movable> getMovFoes() {
		return movFoes;
	}


	public  List<Movable> getMovFloaters() {
		return movFloaters;
	}

	public static int getNumShield() {
		return nNumShield;
	}

	public static void setNumShield(int nParam) {
		nNumShield = nParam;
	}
	public static int getNumKill() {
		return nKill;
	}

	public static void setNumKill(int nParam) {
		nKill = nParam;
	}

	public static int getNumCircle() {
		return nCircle;
	}

	public static void setNumCircle(int nParam) {
		nCircle = nParam;
	}
	public static void setCircle(){
		if(getNumCircle() > 0){
			falShip.setBShield_2(true);
			falShip.setNShield_2(40);
		}
		else if(getNumCircle() == 0)
			falShip.setBShield_2(false);
	}


}
