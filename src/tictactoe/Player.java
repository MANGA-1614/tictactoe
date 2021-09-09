package tictactoe;

import java.util.ArrayList;

public class Player {
	private ArrayList<Spot> spots = new ArrayList<Spot>();
	private String pieceChar;
	
	public Player(String str) {
		this.pieceChar = str;
	}
	
	public void add(Spot spot) {
		this.spots.add(spot);
	}
	
	public ArrayList<Spot> getSpots() {
		return this.spots;
	}
	
	public String getChar() {
		return this.pieceChar;
	}
	
	public void printSpots() {
		for (Spot s : this.spots) {
			System.out.println(s.getID());
		}
	}
}
