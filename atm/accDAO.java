package atm;
import java.sql.*;
import java.util.*;

public class accDAO {
	public void checkId(int id) throws Exception{
		Scanner scanner = new Scanner(System.in);
		String query = "select * from Acc";
		Connection con = dataBase.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			if (rs.getInt(1) == id) {
				System.out.println("Welcome "+rs.getString(2));
				System.out.println("Enter your PIN : ");
				int pin = scanner.nextInt();
				if(pin == rs.getInt(3)) {
					atmOption atmoption = new atmOption();
					atmoption.showOptions(id);
					break;
				}else {
					System.out.println("Wrong pin...");
					break;
				}
			}else {
				System.out.println("Sorry Account not found\n");
			}
		}
	}
}
