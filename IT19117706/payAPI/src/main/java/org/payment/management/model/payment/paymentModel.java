package org.payment.management.model.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.payment.management.model.DataAccess;


public class paymentModel {

public static int payBill(payment payment) {
		
		int i = 0;
		//create a connection with database
		Connection con = DataAccess.connect();
		//insert query
		String sql = "insert into bill values(?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, null); 
			ps.setString(2, payment.getCus_id());
			ps.setString(3, payment.getLast_bill());
			ps.setString(4, payment.getThis_bill());
			ps.setString(5, payment.getLast_payment());
			ps.setString(6, payment.getUnit_price());
			
			
			i = ps.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
		
	}

public static ArrayList<payment> retrieveAllBill(String cus){
	
	ArrayList<payment> Payments = new ArrayList<>();
	payment payment = null;
	 
	
	Connection con = DataAccess.connect();
	
	String sql = "select * from bill where cus_id='"+cus+"' ";
	
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet resultset = ps.executeQuery();
		
		//while theres data remaining
		while(resultset.next()) {
			payment = new payment();
		//	idbill, cus_id, last_bill, this_bill, last_payment, unit_price
			payment.setIdbill(resultset.getInt("idbill"));
			payment.setCus_id(resultset.getString("cus_id"));
			payment.setLast_bill(resultset.getString("last_bill"));
			payment.setThis_bill(resultset.getString("this_bill"));
			payment.setLast_payment(resultset.getString("last_payment"));
			payment.setUnit_price(resultset.getString("unit_price"));
			
			Payments.add(payment);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}	
	
	//return arraylist
	return Payments;
	
}


public static int payAmount(bill bill) {
	
	int i = 0;
	//create a connection with database
	Connection con = DataAccess.connect();
	//insert query
	String sql = "insert into pay_bill values(?,?,?,?,?,?)";
	
	try {
		
		PreparedStatement ps1 = con.prepareStatement("select * from pay_bill where cus_id='"+bill.getCus_id()+"' and month='"+bill.getMonth()+"'");
		
		ResultSet resultset = ps1.executeQuery();
		
		if(resultset.next()) {
			
		}else {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, null); 
			ps.setString(2, bill.getCus_id());
			ps.setString(3, bill.getBill_no());
			ps.setString(4, bill.getMonth());
			ps.setString(5, bill.getTot_amount());
			ps.setString(6, "1");
			
			
			i = ps.executeUpdate();
		}
		 
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return i;
	
}

public static ArrayList<bill> retrieveAll(){
	
	ArrayList<bill> Payments = new ArrayList<>();
	bill payment = null;
	 
	
	Connection con = DataAccess.connect();
	
	String sql = "select * from pay_bill p inner join customer c on p.cus_id=c.idcustomer";
	
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet resultset = ps.executeQuery();
		
		//while theres data remaining
		while(resultset.next()) {
			payment = new bill();
//			idpay_bill, cus_id, bill_no, month, tot_amount, status
			payment.setIdpay_bill(resultset.getInt("idpay_bill"));
			payment.setCus_id(resultset.getString("name"));
			payment.setBill_no(resultset.getString("bill_no"));
			payment.setMonth(resultset.getString("month"));
			payment.setTot_amount(resultset.getString("tot_amount"));
			payment.setStatus(resultset.getString("status"));
			
			Payments.add(payment);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}	
	
	//return arraylist
	return Payments;
	
}


public static boolean changeBillStatus(int id, int status) {
	Connection connection = DataAccess.connect();
	//sql
	String sqlUpdate = "update pay_bill set status=? where idpay_bill=?";
	
	//execute
	try {
		//ps
		PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
		psUpdate.setInt(1, status);
		psUpdate.setInt(2, id);
		psUpdate.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return true;
}


public static boolean deleteBill(int id) {
	Connection connection = DataAccess.connect();
	//sql
	String sqlUpdate = "delete from pay_bill where idpay_bill=?";
	
	//execute
	try {
		//ps
		PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
		
		psUpdate.setInt(1, id);
		
		psUpdate.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	return true;
}


}
