package tictactoe;

public class Spot {
	private String name;
	private Piece piece;
	private int id;
	private boolean taken;
	
	/**
	 * 
	 * @param piece		Piece to put in the spot
	 * @param i			Implied 1 to 9
	 */
	public Spot(Piece piece, int i) {
		this.piece = piece;
		this.name = piece.getName();
		this.id = i;
		this.taken = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public boolean checkIfTaken() {
		if (this.taken) {
			return true;
		} else {
			return false;
		}
	}
	
	public void replace(Piece piece) {
		this.piece = piece;
		this.name = piece.getName();
		this.taken = true;
	}
}

