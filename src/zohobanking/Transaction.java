package zohobanking;

public class Transaction {
           static int tid=10000;
           double amount;
           double balance;
           String description;
           int tran_id;
           int uid;
           int bid;
           
           Transaction(int uid,int bid,String description,double amount,double balance)
           {
        	   this.uid=uid;
        	   this.bid=bid;
        	   this.description=description;
        	   this.balance=balance;
        	   this.amount=amount;
        	   this.tran_id=tid++;
        	   
           }
	
}
