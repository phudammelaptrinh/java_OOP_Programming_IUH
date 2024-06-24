package bai6;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private int accountNumber;
	private String accountName;
	private double balance;
	private static final double RATE = 0.035;
	
	public Account() {
		this.accountNumber = 999999;
		this.accountName = "chưa xác định";
		this.balance= 50000;
	}

	public Account(int accountNumber, String accountName, double balance) {
		if(accountNumber >0)
		{
		this.accountNumber = accountNumber;
		}
		else 
		{
			this.accountNumber = 999999;
		}
		if(accountName != null && !accountName.trim().isEmpty()) 
		
		{
			this.accountName = accountName;
		}
		else 
		{
			this.accountName = "Chưa xác định!";
		}
		if(balance >= 50000) 
		{
			this.balance = balance;
		}
		else 
		{
			this.balance = 50000;
		}
	}
	
	public Account(int accountNumber , String accountName) {
		this(accountNumber,accountName,50000);
	}
	
	//Pt gửi tiền 
	public boolean deposit(double amount) {
		if(amount >0) {
			balance += amount;
			return true;
		}
		return false;
	}
	
	//Pt rút tiền 
	public boolean withdraw(double amount, double fee) {
		if(amount >0 && amount +fee <= balance) {
			balance -= (amount+fee);
			return true;
		}
		return false;
	}
	
	//Pt tính lãi 
	
	public void addInterset() {
		balance += balance*RATE;
	}
	
	//Pt chuyển tiền 
	
	public boolean transfer(Account acc2, double amount) {
		if(this.withdraw(amount,0)) {
			acc2.deposit(amount);
			return true;
		}
		return false;
	}
	@Override
    public String toString() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return "Account Number: " + accountNumber +
               "\nAccount Name: " + accountName +
               "\nBalance: " + formatter.format(balance);
    }
}
