package zohobanking;

import java.util.*;

public class Branch {
	HashMap<Integer,User> user=new HashMap<>();
	static int bid=1000;
	String location;
	int branch_id;
	//ArrayList<Transaction>  transactionb=new ArrayList<>();
	//ArrayList<User> users = new ArrayList<>();// it contains all users who have account in it;
	
	Branch(String location){
		this.location=location;
		this.branch_id=bid++;
		
		
	
	}
}
