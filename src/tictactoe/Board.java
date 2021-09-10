package tictactoe;

import java.util.ArrayList;

public class Board {
	private ArrayList<Spot> board = new ArrayList<Spot>();
	
	public void add(Spot s) {
		this.board.add(s);
	}
	
	public ArrayList<Spot> getSpots() {
		return this.board;
	}
	
	public void replaceSpot(int id, Piece inputPiece, Player player) {
		Spot tmpSpot = this.board.get(id - 1);
		tmpSpot.replace(inputPiece);
		
		player.add(tmpSpot);
	}
	
	public void printBoard() {
		System.out.println();
		for (int i = 1; i < 10; i++) {
			if ((i == 1) || (i == 4) || (i == 7)) {
				System.out.print("  ");
			}
			System.out.print(this.board.get(i - 1).getName());
			if ((i % 3) != 0) {
				System.out.print(" | ");
			} else {
				System.out.println();
				
				if (i != 9) {
					System.out.println("  - + - + -");
				}
			}
		}
	}
	
	public boolean emptySpot(int i) {
		return this.board.get(i - 1).checkIfTaken();
	}
}
