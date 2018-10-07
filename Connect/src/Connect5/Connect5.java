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

			if(isSamsam(h,w))//삼삼체크 추가
			{
				setBoardEmpty(h,w);
				System.out.println("no samsam man");
				wb_turn = !wb_turn;
			}
			else
			{
			checkGameOver(h,w);
			}
		}while(gameover == false);
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
	private void checkGameOver(int h, int w) {
		
			int[] lineCounts = new int[4];
			lineCounts = countLines(h,w);
			if((lineCounts[0]==5)||(lineCounts[1]==5)||(lineCounts[2]==5)||(lineCounts[3]==5))
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
			private boolean isSamsam(int h, int w) {
				int[]_lineCounts = countLines(h,w);
				for(int i=0;i<4;i++)
				{
					for(int j=i+1;j<4;j++)
					{
						if((_lineCounts[i]==3)&&(_lineCounts[j]==3))
							return true;
					}
				}
				return false;
			
			
			}
			
	}
	
	
	

