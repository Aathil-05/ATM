package atm;
import java.sql.*;
import java.util.*;

public class Amount {
	Scanner scanner = new Scanner(System.in);
	public void withdraw(int id) throws Exception {
		String query1 = "select * from Acc where accNo = "+id;
		String query2 = "update Acc set balance = ? where accNo ="+id;
		
		Connection con = dataBase.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query1);
		PreparedStatement pst = con.prepareStatement(query2);
		rs.next();
		int bal = rs.getInt(4);
		
		System.out.println("Enter amount in\n 100, 200, 500");
		int amount = scanner.nextInt();
		
		if(amount < bal) {
			if(amount%100==0 || amount%200==0 || amount%500==0) {
				System.out.println("Take your amount "+amount);
				bal -= amount;
				pst.setInt(1, bal);
				pst.executeUpdate();
			}else {
				System.out.println("Enter amount in 100, 200, 500");
			}
		}else{
			System.out.println("Insufficent Balance....");
		}
	}
	
	public void Deposit(int id) throws Exception {
		String query1 = "select * from Acc where accNo ="+id;
		String query2 = "update Acc set balance=? where accNo="+id;
		Connection con = dataBase.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		PreparedStatement pst = con.prepareStatement(query2);
		
		int bal = rs.getInt(4);
		System.out.println("Enter amount in 100, 200, 500");
		int amount = scanner.nextInt();
		if(amount %100==0 || amount%200==0 || amount%500==0) {
			bal+=amount;
			pst.setInt(1, bal);
			pst.executeUpdate();	
		}
	}
	
	public void Balance(int id) throws Exception {
		String query ="select * from Acc where accNo ="+id;
		Connection con = dataBase.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		int bal = rs.getInt(4);
		
		System.out.println("You're Balance is ₹"+bal+"\n");		
	}
	
	public void chandePin(int id) throws Exception {
		String query1 = "select * from Acc where accNo="+id;
		String query2 = "update Acc set pin = ? where accNo="+id;
		Connection con = dataBase.getConnection();
		Statement st = con.createStatement();
		PreparedStatement pst = con.prepareStatement(query2);
		ResultSet rs = st.executeQuery(query1);
		rs.next();
				
		int pin =rs.getInt(3);
		System.out.println("Enter new PIN Number : ");
		int newPin = scanner.nextInt();
		System.out.println("Re-Enter new PIN Number : ");
		int conPin = scanner.nextInt();
		if(newPin == conPin) {
			pst.setInt(1, conPin);
			pst.executeUpdate();
			System.out.println("PIN changed..!");
		}else {
			System.out.println("PIN incorrect");
		}
	}
	
	
	
	
	
	
	
	
}