package atm;
import java.util.*;

public class atmOption {
	public void showOptions(int id) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Amount amount = new Amount();
		atmOption atmoption = new atmOption();
		
		System.out.println("1. Withdraw Amount\n2. Deposit Amount\n3. Balance\n4. Change pin\n5. Exit");
		System.out.println("Enter the option : ");
		int opt = scanner.nextInt();
		switch(opt) {
		case 1:
			amount.withdraw(id);
			break;
		case 2:
			amount.Deposit(id);
			break;
		case 3:
			amount.Balance(id);
			break;
		case 4:
			amount.chandePin(id);
			break;
		case 5:
			break;
		default:
			System.out.println("Enter correct choice");
			atmoption.showOptions(id);
		}
	}
}
