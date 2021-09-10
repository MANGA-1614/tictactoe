package tictactoe;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		/*
			Create board, then spots, then pieces
			
			Spots will have a number (1-9). This shows their ID and what position they are.
				Once a player puts a piece, that number is removed and will be replaced by [O] or [X]
			
			A turn consists of:
				1. Know who the turn player is
				2. Choosing a spot
				3. Replace spot
				4. Add to Player's list of spots
				4. Print board
		*/	
		
		Board board = new Board();		
		Scanner sc = new Scanner(System.in);
		Player playerO = new Player("O");
		Player playerX = new Player("X");
		Player currPlayer;
		
		initGame(board);
		
		for (int i = 1; i < 10; i++) {
			if ((i % 2) == 0) {
				currPlayer = playerX;
			} else {
				currPlayer = playerO;
			}
			
			turn(board, currPlayer, sc);
			
			if (checkWinCon(currPlayer)) {
				System.out.printf("Player [%s] Wins\n", currPlayer.getChar());
				board.printBoard();
				break;
			}
			
			if (!isNotDraw(board)) {
				System.out.println("Draw - No Player Won");
				board.printBoard();
			}
		}
	}
	
	public static void initGame(Board board) {		
		for (int i = 1; i < 10; i++) {
			Piece tmpPiece = new Piece(String.valueOf(i));
			Spot tmpSpot = new Spot(tmpPiece, i);
			
			board.add(tmpSpot);
		}
	}
			
	private static void turn(Board board, Player player, Scanner sc) {
		board.printBoard();
		Piece inputPiece = new Piece(player.getChar());
		int spotID;
		boolean taken = false;
		
		do {
			System.out.printf("Player [%s]: Enter number to place a piece:", player.getChar());
			spotID = sc.nextInt();
			
			if ((spotID < 1) || (9 < spotID)) {
				System.out.println("Spot does not exist. Please try again.");
			} else if (board.emptySpot(spotID) == true) {
				System.out.println("Spot is taken. Please try again.");
			} else {
				board.replaceSpot(spotID, inputPiece, player);
				taken = true;
			}
		} while (!taken);

		System.out.println();
	}
	
	private static boolean checkWinCon(Player player) {
		/*
			All Win Cons:
			1. 1, 2, 3
			2. 1, 4, 7
			3. 1, 5, 9
			4. 3, 5, 7
			5. 3, 6, 9
			6. 7, 8, 9
			
			Check the Player's spots
				If any of these spots have the same id as the win con, they win
		*/	
		boolean one = false, 
				two = false, 
				three = false, 
				four = false, 
				five = false, 
				six = false, 
				seven = false, 
				eight = false, 
				nine = false;
		
		for (Spot s : player.getSpots()) {
			switch (s.getID()) {
			case 1:
				one = true;
				break;
			case 2:
				two = true;
				break;
			case 3:
				three = true;
				break;
			case 4:
				four = true;
				break;
			case 5:
				five = true;
				break;
			case 6:
				six = true;
				break;
			case 7:
				seven = true;
				break;
			case 8:
				eight = true;
				break;
			case 9:
				nine = true;
				break;
			}			
		}
		
		if (
				(one && two && three) 		||
				(one && four && seven) 		||
				(one && five && nine) 		||
				(two && five && eight) 		||
				(three && five && seven) 	||
				(three && six && seven) 	||
				(four && five && six) 		||
				(seven && eight && nine)
			) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isNotDraw(Board board) {
		/*
			Check board's spots
			If any spot.taken = false, keep going
		*/
		boolean allEmpty = false;
		
		for (Spot s : board.getSpots()) {
			if (!s.checkIfTaken()) {
				allEmpty = true;
			}
		}
		
		return allEmpty;
		
	}
}
