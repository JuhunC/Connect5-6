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
		scan.nextInt();
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
		System.out.println("Game over");
		System.out.println(getBoard(h,w)+" wins");
		return;
	}
	
	
	
	/**
	 * Check Gameover because of [h,w]
	 * @param h
	 * @param w
	 */
	private void checkGameOver(int h, int w) 
	{
	int[] lineCounts = new int[4];
	lineCounts = countLines(h,w);
	if((lineCounts[0]>=6)||(lineCounts[1]>=6)||(lineCounts[2]>=6)||(lineCounts[3]>=6))
	{
		gameover=true;
	}
	return;
	
	}
	
	
	private int[] countLines(int h, int w) {
	int[] lineCounts= new int[4];//lineCounts[0]이 좌우방향 총 라인 수, [1]이 상하, [2]가 오른 대각, [3]이 왼 대각
	lineCounts[0]=-1;
	lineCounts[1]=-1;
	lineCounts[2]=-1;
	lineCounts[3]=-1;
	char rockColor = getBoard(h,w);
	int rIdx = w;
	int uIdx = h;
	
	while(getBoard(h,rIdx)==rockColor)
	{
		rIdx++;
		lineCounts[0]++;
	}
	rIdx=w;
	while(getBoard(h,rIdx)==rockColor)
	{
		rIdx--;
		lineCounts[0]++;
	}
	
	
	while(getBoard(uIdx,w)==rockColor)
	{
		uIdx++;
		lineCounts[1]++;
	}
	uIdx=h;
	while(getBoard(uIdx,w)==rockColor)
	{
		uIdx--;
		lineCounts[1]++;
	}
	
	rIdx = w;
	uIdx = h;
	
	while(getBoard(uIdx,rIdx)==rockColor)//우상향
	{
		uIdx++;
		rIdx++;
		lineCounts[2]++;
	}
	
	rIdx = w;
	uIdx = h;
	
	while(getBoard(uIdx,rIdx)==rockColor)//좌하향
	{
		uIdx--;
		rIdx--;
		lineCounts[2]++;
	}
	
	rIdx = w;
	uIdx = h;
	
	while(getBoard(uIdx,rIdx)==rockColor)//좌상향
	{
		uIdx++;
		rIdx--;
		lineCounts[3]++;
	}
	rIdx = w;
	uIdx = h;
	
	while(getBoard(uIdx,rIdx)==rockColor)//우하향
	{
		uIdx--;
		rIdx++;
		lineCounts[3]++;
	}
	
	
	
	
	return lineCounts;	
	}
	
	
	
	
}
