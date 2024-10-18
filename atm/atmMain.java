package atm;
import java.util.*;

public class atmMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter your Account number : ");
			int id = scanner.nextInt();
			
			accDAO accdao = new accDAO();
			accdao.checkId(id);
			
			
		}
	}
}