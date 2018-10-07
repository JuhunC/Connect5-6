package Board;

public class Board {
	private static final int SIZE_WIDTH = 10; // constant
	private static final int SIZE_HEIGHT = 10; // constant
	private static final char BLACK_ROCK = '●';
	private static final char WHITE_ROCK = '○';
	private static final char EMPTY = '+';
	
	private char[][] board;
	/**
	 * Board Constructor
	 */
	public Board(){
		initBoard();
	}
	/**
	 * Initialize Board with EMPTY spaces
	 */
	private void initBoard() {
		board = new char[SIZE_HEIGHT][SIZE_WIDTH];
		for(int i =0;i<SIZE_HEIGHT;i++) {
			for(int j =0;j<SIZE_WIDTH;j++) {
				board[i][j] = EMPTY;
			}
		}
	}
	/**
	 * Print the Board on Console
	 */
	public void printBoardConsole() {
		System.out.println("**********BOARD**********");
		System.out.print("  ");
		for(int i=0;i<SIZE_WIDTH;i++) {
			System.out.print(i);
			if(i<9) {
				System.out.print(" ");
			}
		}System.out.println();
		for(int i =0;i<SIZE_HEIGHT;i++) {
			System.out.print(i + " ");
			for(int j=0;j<SIZE_WIDTH;j++) {
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("*************************");
	}
	/**
	 * Add White Rock on the Board
	 * @param h height
	 * @param w width
	 * @return true(able to put a rock) false(unable to put a rock);
	 */
	public boolean addWhiteRock(int h, int w) {
		if(h>=SIZE_HEIGHT || w >=SIZE_WIDTH || w<0 || h<0) {
			System.out.println("Out of Bounds");
			return false;
		}else if(board[h][w]==EMPTY) {
			board[h][w]=WHITE_ROCK;
			return true;
		}else {
			System.out.println("Unable to Put the Rock : "+h+","+w);
			return false;
		}
	}
	/**
	 * Add Black Rock on the Board
	 * @param h height
	 * @param w width
	 * @return true(able to put a rock) false(unable to put a rock);
	 */
	public boolean addBlackRock(int h, int w) {
		if(h>=SIZE_HEIGHT || w >=SIZE_WIDTH || w<0 || h<0) {
			System.out.println("Out of Bounds");
			return false;
		}else if(board[h][w]==EMPTY) {
			board[h][w]=BLACK_ROCK;
			return true;
		}else {
			System.out.println("Unable to Put the Rock : "+h+","+w);
			return false;
		}
	}
	/**
	 * SIZE_WIDTH getter
	 * @return
	 */
	public int getBoardSizeWidth() {
		return SIZE_WIDTH;
	}
	/**
	 * SIZE_HEIGHT getter
	 * @return
	 */
	public int getBoardSizeHeight() {
		return SIZE_HEIGHT;
	}
	
	public char getBoard(int h, int w) {
		if(h>=SIZE_HEIGHT || w >=SIZE_WIDTH || w<0 || h<0) 
		{
			return 0;
		}
		else
		{
			return board[h][w];
		}
	}//추가 
	public void setBoardEmpty(int h, int w) {
		if(h>=SIZE_HEIGHT || w >=SIZE_WIDTH || w<0 || h<0) 
		{
			return ;
		}
		else
		{
			board[h][w]=EMPTY;
		}
		
	}//추가
	
}
