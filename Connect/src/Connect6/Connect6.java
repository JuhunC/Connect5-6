package Connect6;
import java.util.Scanner;
import Board.Board;
public class Connect6 extends Board{
	Scanner scan;
	private boolean gameover = false;
	private boolean wb_turn = false;
	/**
	 * Connect6 Constructor
	 */
	public Connect6() {
		super();
		scan = new Scanner(System.in);
		startGame();
		scan.close();
	}
	/**
	 * Game Main Frame (Console)
	 */
	private void startGame() {
		System.out.println("Connect6 Game Started!!");
		int h,w;
		// First Round
		super.printBoardConsole();
		do {
			System.out.println("Black Turn(h,w) : ");
			h = scan.nextInt();
			w = scan.nextInt();
		}while(!super.addBlackRock(h, w));
		wb_turn =true;
		
		do {
			super.printBoardConsole();
			if(wb_turn == false) {
				do {
					System.out.println("Black Turn(h,w) : ");
					h = scan.nextInt();
					w = scan.nextInt();
				}while(!super.addBlackRock(h, w));
			}else {
				do {
					System.out.println("White Turn(h,w) : ");
					h = scan.nextInt();
					w = scan.nextInt();
				}while(!super.addWhiteRock(h, w));
			}
			System.out.println();
			checkGameOver(h,w);
			
			
			super.printBoardConsole();
			
			if(wb_turn == false) {
				do {
					System.out.println("Black Turn(h,w) : ");
					h = scan.nextInt();
					w = scan.nextInt();
				}while(!super.addBlackRock(h, w));
				wb_turn = true;
			}else {
				do {
					System.out.println("White Turn(h,w) : ");
					h = scan.nextInt();
					w = scan.nextInt();
				}while(!super.addWhiteRock(h, w));
				wb_turn = false;
			}
			System.out.println();
			
			checkGameOver(h,w);
		}while(gameover==false);
		super.printBoardConsole();
	}
	
	
	
	/**
	 * Check Gameover because of [h,w]
	 * @param h
	 * @param w
	 */
	private void checkGameOver(int h, int w) {
		/**
		 * 전역변수 gameover을 사용하여
		 * 게임이 끝났는지 확인한다.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}
}
