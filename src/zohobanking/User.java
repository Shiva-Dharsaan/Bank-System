package zohobanking;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
   static int uid=0;
   String name,mobile,acc_type,gender;
   double balance;
   int user_id;
   int age;
   int bid;
   String password;
   HashMap<Integer,Branch> accounts=new HashMap<>();
   ArrayList<Transaction>  transaction=new ArrayList<>();
   
   User(String name,String mobile,String acc_type,String gender,double balance,int age,int bid,String password)
   {
	   this.name=name;
	   this.mobile=mobile;
	   this.acc_type=acc_type;
	   this.balance=balance;
	   this.age=age;
	   this.user_id=uid++;
	   this.bid=bid;
	   this.gender = gender;
	   this.password=password;
   }
}
