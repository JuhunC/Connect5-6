package Connect5;
import java.util.Scanner;
import Board.Board;

public class Connect5 extends Board{
	Scanner scan;
	private boolean gameover = false;
	private boolean wb_turn = false; // true(white turn), false(black turn)
	/**
	 * Connect5 Constructor
	 */
	public Connect5() {
		super();
		scan = new Scanner(System.in);
		startGame();
		scan.close();
	}
	/**
	 * Game Main Frame (Console)
	 */
	private void startGame() {
		System.out.println("Connect5 Game Started!!");
		int h,w;
		do {
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
		}while(gameover == false);
		super.printBoardConsole();
	}
	/**
	 * Check Gameover because of [h,w]
	 * @param h
	 * @param w
	 */
	private void checkGameOver(int h, int w) {
		/**
		 * �������� gameover�� ����Ͽ�
		 * ������ �������� Ȯ���Ѵ�.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}
	
	
	
}
