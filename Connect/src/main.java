import java.util.*;
import Connect5.Connect5;
import Connect6.Connect6;
public class main {
	public static void main(String args[]) {

		Scanner sc= new Scanner(System.in);
		System.out.println("1.오목");
		System.out.println("2.육목");
		System.out.println("3.종료");
		String menu = sc.nextLine();
		switch(menu){
		case "1":
			Connect5 myConnect5 = new Connect5();
			break;
		case "2":
			Connect6 myConnect6 = new Connect6();
			break;
		case "3":
			return;
		
		 
	
		}
	}
}
