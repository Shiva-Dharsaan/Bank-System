package zohobanking;

import java.util.*;
//import static zohobanking.Branch.user;
public class Bank {
	static HashMap<Integer,Branch> branch=new HashMap<>();
	//static ArrayList<Transaction>  transaction=new ArrayList<>();

	public static void main(String arg[])
	{

		Scanner sc=new Scanner(System.in);
		System.out.println("                 *********************************************");
	    System.out.println("                               Welcome to ZOHO bank          ");
        System.out.println("                 **********************************************\n\n");
        while(true)
        {
      	    System.out.println("1.Admin\t\t\t\t\t2.User\t\t\t3.Exit\n");
      	    System.out.println("-------------------------------------------------------------------------");
            System.out.println("Enter your Option:");
            int opt=sc.nextInt();
            if(opt==1)
            {
            	//to choose user or admin
          	  System.out.println("1.Create a Branch\n\n"
          	  		+ "2.View Transaction history of bank\n\n"
          	  		+ "3.Remove a branch\n\n"
          	  		+ "4.View Customer with Maximum balance at a brach\n\n"
          	  		+ "5.View all users in a branch\n\n"
          	  		+ "6.Change Branch location\n\n");
          	        System.out.println("-------------------------------------------------------------------------");
          	        System.out.println("Enter your Option:");
         		    int opt1=sc.nextInt();
          		    if(opt1==1)
          		    {
          			   //creating branch
          			   System.out.println("Enter the location in which you want to create:");
          			   String location=sc.next();
          			   branch.put(Branch.bid,new Branch(location));
          			   System.out.println(branch);
           			   System.out.println("You have successfully created a branch with branchid:"+(Branch.bid-1));  
          		    }
          		    else if(opt1==2)
          		    {
          		    	//View Transaction history of bank
          		    	 int bid;
        		    	 while(true)
        		    	 {
                  		   //to check bank id
                  		   System.out.println("Enter your branch id:");
                  		   bid=sc.nextInt();
                  		   if(branch.containsKey(bid))
                  		   {
                  			  break;
                  		   }
                  		   else
                  		   {
                  			   System.out.println("Invalid branch id");
                  			   continue;
                  		    }
   
                  	     }
   
          		    	Branch br=branch.get(bid);
          		    	System.out.println("Branch Id| |Transaction Id| |Description| |Amount| |Balance");
          		    	for(Map.Entry<Integer,User>entry:br.user.entrySet())
              		    {
          		    		User u=entry.getValue();
          		    		for(int i=0;i<u.transaction.size();i++)
          				    {
          				    	Transaction temp=u.transaction.get(i);
          				    	System.out.println(temp.bid +"| |"+temp.tran_id+"| |"+temp.description+"| |"+temp.amount+"| |"+temp.balance);
          				    
          				    }
          		        }
          		    }
          		    else if(opt1==3)
          		    {
          		    	//removing a branch
          		    	 int bid;
        		    	 while(true)
        		    	 {
                  		   //to check bank id
                  		   System.out.println("Enter the branch id to remove:");
                  		   bid=sc.nextInt();
                  		   if(branch.containsKey(bid))
                  		   {
                  			  break;
                  		   }
                  		   else
                  		   {
                  			   System.out.println("Invalid branch id");
                  			   continue;
                  		    }
   
                  	     }
   
          		    	 branch.remove(bid);
          		    	 System.out.println("The branch details of the branch that you want to delete is deleted succcessfully");	
          		    }
          		    else if(opt1==4)
          		    {
          		    	//user with max balance
          		    	 int bid;
         		    	 while(true)
         		    	 {
                   		   //to check bank id
                   		   System.out.println("Enter your branch id:");
                   		   bid=sc.nextInt();
                   		   if(branch.containsKey(bid))
                   		   {
                   			  break;
                   		   }
                   		   else
                   		   {
                   			   System.out.println("Invalid branch id");
                   			   continue;
                   		    }
    
                   	     }
    
          		    	   Branch br=branch.get(bid);
          		    	   int uid=0;
          		    	   double max=-1;
          		    	   for(Map.Entry<Integer,User>entry:br.user.entrySet())
          		    	   {
          		    		 int key=entry.getKey();
          		    		 User temp=entry.getValue();
          		    		 if(temp.balance>max)
          		    		 {
          		    			max=temp.balance;
          		    			uid=key;
          		    		 }
          		    	        else
          		    	        {
          		    	        	continue;
          		    	        }
          		    	    }
          		    	   System.out.println(uid+" "+br.user.get(uid).name+" "+br.user.get(uid).balance+" "+br.user.get(uid).mobile+" "+br.user.get(uid).acc_type+" "+br.user.get(uid).age);

          		    	
          		    }
          		    else if(opt1==5)
          		    {
          		    	//users in a branch
          		    	 int bid;
         		    	 while(true)
         		    	 {
                   		   //to check bank id
                   		   System.out.println("Enter your branch id to check users");
                   		   bid=sc.nextInt();
                   		   if(branch.containsKey(bid))
                   		   {
                   			  break;
                   		   }
                   		   else
                   		  {
                   			  System.out.println("Invalid branch id");
                   			  continue;
                   		  }
    
                   	     }
          		     
          		    	Branch br=branch.get(bid);
          		    	for(Map.Entry<Integer,User>entry:br.user.entrySet())
              		    {
          		    		
              		    	int key=entry.getKey();
              		    	User u=entry.getValue();
              		    	System.out.println(key+" "+u.name+" "+u.balance+" "+u.mobile+" "+u.acc_type+" "+u.age);
              		    }
      
          		    	
    		    	
          		    }
          		    else if(opt1==6)
          		    {
          		    	//to change location
          		    	 int bid;
          		    	 while(true)
          		    	 {
                    		 //to check bank id
                    		 System.out.println("Enter your branch id to change location");
                    		 bid=sc.nextInt();
                    		 if(branch.containsKey(bid))
                    		 {
                    			 break;
                    		 }
                    		 else
                    		 {
                    			 System.out.println("Invalid branch id");
                    			 continue;
                    		 }
     
                    	 }
          		    	 System.out.println("Enter the new location:");
          		    	 String new_loc=sc.next();
          		    	 branch.get(bid).location=new_loc;
          		    	 System.out.println("Location changed sucessfully:");
          		    	 
          		    	 
     
          		    }
          		    else
          		    {
          		    	System.out.println("Invalid option");
          		    	break;
          		    }
          	    

            }
            else if(opt==2)
            {
           
          	  System.out.println("1.Create an Account\n\n"
            	  		+ "2.Login to existing account\n\n"
            	  		+ "3.View Transcation History\n\n"
            	  		+ "4.Change Username\n\n"
            	  		+ "5.Change Password\n\n"
            	  		+ "6.Change Number\n\n");
          	  System.out.println("-------------------------------------------------------------------------");
          	  System.out.println("Enter your Option:");
          	  int opt1=sc.nextInt();
          	  if(opt1==1)
      	      {
          		  //condition to create acc
          		
          		
      		    System.out.println("Enter Name");
      		    String name=sc.next();
      		    System.out.println("Enter the  branch id in which you want to create account");
      		    for(Map.Entry<Integer,Branch>entry:branch.entrySet())
      		    {
      		    	int key=entry.getKey();
      		    	Branch b=entry.getValue();
      		    	System.out.println(key+"\t\t"+b.location);
      		    }
      		    
      		    int br_id=sc.nextInt();
      		    System.out.println("Set a password for your account");
    		    String password=sc.next();
    		    
      		    String description="Opening Account";
      		 
      		    double balance;
      		    while(true)
      		    {
      		    	//to check initial amount
      		    	System.out.println("Enter Intial amount(should be greater than 1500):");
          			balance=sc.nextLong();
          			if(balance>1500)
          			{
          				break;
          			}
          			else
          			{
          				System.out.println("Intial Amount should be greater than 1500");
          				continue;
          			}
      		    }
      	
      			System.out.println("Enter Account type:");
      			String acc_type=sc.next(),number="";
      			int age=0;
      			
      			while(true)
      				{
      				 //To check mobile number
      				 System.out.println("Enter your mobile number");
      				 number=sc.next();
      				if(number.length()==10)
      				{
      					break;
      				}
      				else
      				{
      					System.out.println("Enter a 10 digit number");
      					continue;
      				}
      			}
      			while(true)
      			{
      			System.out.println("Enter your age");
      			age=sc.nextInt();
      			if(age>=18)
      			{
      				//to check age
      				break;
      			}
      			else
      			{
      				System.out.println("You should be 18 to have a bank account");
      				continue;
      			}
      			}
      			String gender=" ";
      			while(true)
      			{
      				//for gender
      				System.out.println("Choose gender:1.Male\t\t2.Female\t\t3.Others");
      				int opt3=sc.nextInt();
          			if(opt3==1)
          			{
          				gender="Male";
          				break;
          			}
          			else if(opt3==2)
          			{
          				gender="Female";
          				break;
          			}
          			else if(opt3==2)
          			{
          				gender="Others";
          				break;
          			}	
          			else
          			{
          				System.out.println("Invalid option");
          				continue;

          			}

      			}
      			User u = new User(name,number,acc_type,gender,balance,age,br_id,password);
      			Branch br=branch.get(br_id);
      			br.user.put(User.uid,u);
      			System.out.println(br.user);
      			System.out.println("You have successfully created a account with userid:"+(User.uid));
      			Transaction t=new Transaction(User.uid,br_id,description,balance,balance);
      			br.user.get(User.uid).transaction.add(t);

      	      }
      	      else if(opt1==2)
      	     {
                 while(true)
                 {
                	 int bid=0;
                	 int id=0;
                	 while(true)
                	 {
                		 //to check bank id
                		 System.out.println("Enter your branch id");
                		 bid=sc.nextInt();
                		 if(branch.containsKey(bid))
                		 {
                			 break;
                		 }
                		 else
                		 {
                			 System.out.println("Invalid branch id");
                			 continue;
                		 }
 
                	 }
                	 Branch br=branch.get(bid);
                	 System.out.println(br.toString());
                	 while(true)
                	 {
                		 //to check account number
                		 System.out.println("Enter your account number");
                		 id=sc.nextInt();
                		 User u1 = br.user.get(id);
                		 System.out.println(br.user);
                		 System.out.println(u1.name);
                		 if(br.user.containsKey(id))
                		 {
                			 break;
                		 }
                		 else
                		 {
                			 System.out.println("Invalid account number");
                			 continue;
                		 }
 
                	 }
                	 while(true)
                	 {
                		 //to check password
                		 System.out.println("Enter your password");
                		 String pass=sc.next();
                		 if(br.user.get(id).password.equals(pass))
                		 {
                			 System.out.println("Login successfull");
                			 break;
                		 }
                		 else
                		 {
                			 System.out.println("Invalid password");
                			 continue;
                		 }
 
                	 }
 
                	 
                	 
                	 System.out.println("1.Deposit\t\t2.Withdraw\t\t3.Transfer\t\t4.Exit");
                	 System.out.println("-------------------------------------------------------------------------");
                	 System.out.println("Enter your option:");
                	 int opt2=sc.nextInt();
                	//to choose deposit or withdraw
                	 if(opt2==1)
                	 {
                		 //to deposit
                		 String description="Deposit";
                		 System.out.println("Enter your amount to deposit");
                		 double amt=sc.nextInt();
                		 br.user.get(id).balance+=amt;
                		 double bal_after_tran=br.user.get(id).balance;
                		 System.out.println("Balance amount after transaction:"+br.user.get(id).balance);
                		 Transaction t=new Transaction(id,bid,description,amt,bal_after_tran);
                		 br.user.get(id).transaction.add(t);

                		 break;
                	 }
                	 else if(opt2==2)
                	 {
                		 //to withdraw
                		 String description="Withdraw";
                		 System.out.println("Enter your amount to withdraw");
                		 double amt=sc.nextInt(); 
                		 System.out.println("Choose your account type");
                		 System.out.println("1.Savings\t2.Current\t3.Loan");
                		 int opt3=sc.nextInt();
                		 if(opt3==1)
                		 {
                			 //savings acc
                			 if(amt>(br.user.get(id).balance-1000))
                					 {
                				        System.out.println("Insuffient Balance");
                				        break;
                					 }
                			 else
                			 {
                				 br.user.get(id).balance-=amt;
                				 double bal_after_tran=br.user.get(id).balance;
                				 System.out.println("Balance amount after transaction:"+br.user.get(id).balance);
                				 Transaction t=new Transaction(id,bid,description,amt,bal_after_tran);
                				 br.user.get(id).transaction.add(t);

                				 break;
                			 }
                
                		 }
                		 else if(opt3==2)
                		 {
                			 //current acc
                			 if(amt>(br.user.get(id).balance))
                					 {
                				        System.out.println("Insuffient Balance");
                				        break;
                					 }
                			 else
                			 {
                				 br.user.get(id).balance-=amt;
                				 double bal_after_tran=br.user.get(id).balance;
                				 System.out.println("Balance amount after transaction:"+br.user.get(id).balance);
                				 Transaction t=new Transaction(id,bid,description,amt,bal_after_tran);
                				 br.user.get(id).transaction.add(t);

                				 break;
                			 }
                			 
                		 }
                		 else if(opt3==3)
                		 {
                			     //loan acc
                				 br.user.get(id).balance-=amt;
                				 double bal_after_tran=br.user.get(id).balance;
                				 System.out.println("Balance amount after transaction:"+br.user.get(id).balance);
                				 Transaction t=new Transaction(id,bid,description,amt,bal_after_tran);
                				 br.user.get(id).transaction.add(t);
                				 break;
                		 }
                		 else
                		 {
                			 System.out.println("Invalid option");
                			 break;
                		 }
                		
                		 
                	
                	 }
                	 else if(opt2==3)
                	 {
                		 //to transfer
                		 Branch brec;
                		 String description="Transfer";
                		 System.out.println("Enter your amount to transfer");
                		 double amt=sc.nextInt(); 
                		 int trans_id;
                		 int trans_bid;
                		 while(true)
                    	 {
                    		 //to check receiver bank id
                    		 System.out.println("Enter your branch id of receiver");
                    		 trans_bid=sc.nextInt();
                    		 brec=branch.get(trans_bid);
                    		 if(branch.containsKey(trans_bid))
                    		 {
                    			 break;
                    		 }
                    		 else
                    		 {
                    			 System.out.println("Invalid branch id");
                    			 continue;
                    		 }
                    	 }
     
                		 while(true)
                    	 {
                    		 //to check receiver account number
                    		 System.out.println("Enter  account number to which you want to transfer:");
                    		 trans_id=sc.nextInt();
                    		 if(brec.user.containsKey(trans_id))
                    		 {
                    			 break;
                    		 }
                    		 else
                    		 {
                    			 System.out.println("Invalid account number");
                    			 continue;
                    		 }
     
                    	 }
                		 System.out.println("Choose your account type");
                		 System.out.println("1.Savings\t2.Current\t3.Loan");
                		 int opt3=sc.nextInt();
                		 if(opt3==1)
                		 {
                			 //savings acc transfer
                			 if(amt>(br.user.get(id).balance-1000))
                					 {
                				        System.out.println("Insuffient Balance to transfer");
                				        break;
                					 }
                			 else
                			 {
                				 br.user.get(id).balance-=amt;
                				 double bal_after_tran=br.user.get(id).balance;
                				 brec.user.get(trans_id).balance+=amt;
                				 System.out.println("Balance amount after transaction:"+br.user.get(id).balance);
                				 Transaction t=new Transaction(id,bid,description,amt,bal_after_tran);
                				 br.user.get(id).transaction.add(t);
                	      		 Transaction t1=new Transaction(trans_id,trans_bid,description,amt,brec.user.get(trans_id).balance);
                	      		 brec.user.get(trans_id).transaction.add(t1);
               				

                				 break;
                			 }
                
                		 }
                		 else if(opt3==2)
                		 {
                			 //current acc transfer
                			 if(amt>(br.user.get(id).balance))
                					 {
                				        System.out.println("Insuffient Balance to transfer");
                				        break;
                					 }
                			 else
                			 {
                				 br.user.get(id).balance-=amt;
                				 double bal_after_tran=br.user.get(id).balance;
                				 brec.user.get(trans_id).balance+=amt;
                				 System.out.println("Balance amount after transaction:"+br.user.get(id).balance);
                				 Transaction t=new Transaction(id,bid,description,amt,bal_after_tran);
                				 br.user.get(id).transaction.add(t);
                	      		 Transaction t1=new Transaction(trans_id,trans_bid,description,amt,brec.user.get(trans_id).balance);
                	      		 brec.user.get(trans_id).transaction.add(t1);
               				

                				 break;
                			 }
                			 
                		 }
                		 else if(opt3==3)
                		 {
                				 br.user.get(id).balance-=amt;
                				 double bal_after_tran=br.user.get(id).balance;
                				 brec.user.get(trans_id).balance+=amt;
                				 System.out.println("Balance amount after transaction:"+br.user.get(id).balance);
                				 Transaction t=new Transaction(id,bid,description,amt,bal_after_tran);
                				 br.user.get(id).transaction.add(t);
                				 Transaction t1=new Transaction(trans_id,trans_bid,description,amt,brec.user.get(trans_id).balance);
                				 brec.user.get(trans_id).transaction.add(t1);
                				 break;
                		 }
                		 else
                		 {
                			 System.out.println("Invalid option");
                			 break;
                		 }

                		 
                	 }
                	 
                	 
                 }
      	     }
      	  else if(opt1==3)
      	  {
      		//trasaction history of user
      		 int bid=0;
      		 int id=0;
      		 while(true)
       	    {
       		  //to check bank id
       		  System.out.println("Enter your branch id");
       		  bid=sc.nextInt();
       		  if(branch.containsKey(bid))
       		  {
       			 break;
       		  }
       		  else
       		  {
       			 System.out.println("Invalid branch id");
       			 continue;
       		  }

       	     }
      		Branch br=branch.get(bid);
      		while(true)
       	    {
       		 //to check account number
       		 System.out.println("Enter your account number");
       		 id=sc.nextInt();
       		 User u1 = br.user.get(id);
       		 System.out.println(br.user);
       		 System.out.println(u1.name);
       		 if(br.user.containsKey(id))
       		 {
       			 break;
       		 }
       		 else
       		 {
       			 System.out.println("Invalid account number");
       			 continue;
       		 }

       	    }

		    User u=br.user.get(id);
		    System.out.println("Branch Id| |Transaction Id| |Description| |Amount| |Balance");
		    for(int i=0;i<u.transaction.size();i++)
		    {
		    	Transaction temp=u.transaction.get(i);
		    	System.out.println(temp.bid +"| |"+temp.tran_id+"| |"+temp.description+"| |"+temp.amount+"| |"+temp.balance);
		    
		    }
      	  }
      	  else if(opt1==4)
      	  {
      		  //change username
      		int id=0;
      		int bid=0;
       	   while(true)
       	   {
       		 //to check bank id
       		 System.out.println("Enter your branch id");
       		 bid=sc.nextInt();
       		 if(branch.containsKey(bid))
       		 {
       			 break;
       		 }
       		 else
       		 {
       			 System.out.println("Invalid branch id");
       			 continue;
       		 }

       	    }
       	    Branch br=branch.get(bid);

      		while(true)
       	    {
       		   //to check account number
       		   System.out.println("Enter your account number");
       		   id=sc.nextInt();
       		   if(br.user.containsKey(id))
       		   {
       			 break;
       		   }
       		   else
       		   {
       			 System.out.println("Invalid account number");
       			 continue;
       		    }
       	     }
      		 while(true)
       	     {
       		   //to check password
       		   System.out.println("Enter your password");
       		   String pass=sc.next();
       		   if(br.user.get(id).password.equals(pass))
       		  {
       			 System.out.println("Login successfull");
       			 break;
       		  }
       		  else
       		  {
       			 System.out.println("Invalid password");
       			 continue;
       		  }

       	     }
      		 System.out.println("Enter your a new username");
      		 String new_name=sc.next();
      		 br.user.get(id).name=new_name;
      		 System.out.println("Username changed successfully");
      		 
      	  }
      	  else if(opt1==5)
      	  {
      		//to change password
      		int id=0;
      		int bid=0;
       	    while(true)
       	   {
       		 //to check bank id
       		 System.out.println("Enter your branch id");
       		 bid=sc.nextInt();
       		 if(branch.containsKey(bid))
       		 {
       			 break;
       		 }
       		 else
       		 {
       			 System.out.println("Invalid branch id");
       			 continue;
       		 }

       	    }
       	    Branch br=branch.get(bid);

      		while(true)
       	    {
       		   //to check account number
       		   System.out.println("Enter your account number");
       		   id=sc.nextInt();
       		   if(br.user.containsKey(id))
       		   {
       			 break;
       		   }
       		   else
       		   {
       			 System.out.println("Invalid account number");
       			 continue;
       		    }
       	     }
      		 while(true)
       	     {
       		   //to check password
       		   System.out.println("Enter your old password");
       		   String pass=sc.next();
       		   if(br.user.get(id).password.equals(pass))
       		  {
       			 System.out.println("Login successfull");
       			 break;
       		  }
       		  else
       		  {
       			 System.out.println("Invalid password");
       			 continue;
       		  }

       	     }
      		 System.out.println("Enter a new password");
      		 String new_pass=sc.next();
      		 br.user.get(id).password=new_pass;
      		 System.out.println("Password changed successfully");

      	    }
      	  else if(opt1==6)
      	  {
      		//to change number
        		int id=0;
        		int bid=0;
           	    while(true)
           	   {
           		 //to check bank id
           		 System.out.println("Enter your branch id");
           		 bid=sc.nextInt();
           		 if(branch.containsKey(bid))
           		 {
           			 break;
           		 }
           		 else
           		 {
           			 System.out.println("Invalid branch id");
           			 continue;
           		 }

           	    }
           	    Branch br=branch.get(bid);

        		while(true)
         	    {
         		   //to check account number
         		   System.out.println("Enter your account number");
         		   id=sc.nextInt();
         		   if(br.user.containsKey(id))
         		   {
         			 break;
         		   }
         		   else
         		   {
         			 System.out.println("Invalid account number");
         			 continue;
         		    }
         	     }
        		 while(true)
         	     {
         		   //to check password
         		   System.out.println("Enter your old password");
         		   String pass=sc.next();
         		   if(br.user.get(id).password.equals(pass))
         		  {
         			 System.out.println("Login successfull");
         			 break;
         		  }
         		  else
         		  {
         			 System.out.println("Invalid password");
         			 continue;
         		  }

         	     }
        		 while(true)
   				 {
   				 //To check mobile number
   				 System.out.println("Enter your new mobile number");
   				 String new_number=sc.next();
   				 if(new_number.length()==10)
   				 {
   					br.user.get(id).mobile=new_number;
   	      		    System.out.println("Number changed successfully");
   					break;
   				 }
   				 else
   				 {
   					System.out.println("Enter a 10 digit number");
   					continue;
   				 }
   			}
      	  }
      	  else
      	  {
      		  System.out.println("!!!Invalid option!!!");
      	  }
        }
        else if(opt==3)
        {
      	  break;
        }
        else
        {
      	  System.out.println("!!!Invalid option!!!");
        }
    }
    
}



	
}
