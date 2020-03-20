package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.element.Element;
import javax.sound.midi.Soundbank;

import Model.ATM;

public class view {
	public static void main(String[] args) {
		ATM m = null;
		ATM atm = new ATM("lehieu", 5000, "123");
		ATM atm2 = new ATM("mai",5000,"123");
		List<ATM> list = new ArrayList<ATM>();
		list.add(atm);
		list.add(atm2);
		
		Scanner scanner = new Scanner(System.in);
	    ATM atm3 = nhap(scanner,list);
	    System.out.println(atm3.getCard_name());
	   if( checkatm(list, atm3)== false) {
		   System.out.println("tai khoan ko ton tai xin vui long kiem tra laij tai khoan");
	   }
	   else {
		System.out.println("dang nhap thanh cong xin vui long lua chon chuc nang");
		System.out.println("chuc nang 1 : kiem tra so du trong tai khoan");
		System.out.println("chuc nang 2 : rut tien");
		System.out.println("chuc nang 3 : chuyen tien cho nguoi khac");
		System.out.println("vui long nhap chuc nang ban muon giao dich");
		String lc = scanner.nextLine();
		 switch (lc) {
		   case "1": {
			   System.out.println("so du trong tai khoan cua ban la : " +atm3.getMoney());
			   break;
		   }
		   case "2" : {
			   System.out.println("nhap so tien ban can rut :");
			  try {
				  int c = scanner.nextInt();
				 
				  if(ruttien(atm3, c)== true) {
					  System.out.println("giao dich thanh cong !");
					  System.out.println("so du trong tai khoan la " + atm3.getMoney());
				  }
				  else {
					System.out.println("Giao dich that bai !");
				}
			   
			} catch (Exception e) {
				System.out.println("giao dich ket thuc");
			}
			  break;
		     }
		   case "3" :{
			   int cc=0;
			   System.out.println("nhap ten tai khoan ma ban muon chuyen tien");
			   String tenString = scanner.nextLine();
			 
			   for(ATM c : list) {
				   if(c.getCard_name().equals(tenString)) {
					   
					    m = c;
                       if(m!=null) {
                    	   System.out.println("nhap so tien ban muon gui");
							  cc = scanner.nextInt();
							  chuyentien(atm3, m, cc);
                       }
                      
                       
				   }
				  
				   
			   }
			  
			  
			   break;
		   }
	   }
	    
	  }	
		
	}
	public static ATM nhap(Scanner scanner,List<ATM> list ) {
		System.out.println("vui long nhap ten tai khoan");
		String ten = scanner.nextLine();
	    System.out.println("vui long nhap pass word");
		String  pass = scanner.nextLine();
		ATM m = null;
		for(ATM c: list) {
			if(c.getCard_name().equals(ten)&& c.getPass().equals(pass)) {
				
		    m=c;
		    if(m!=null) return m;
			}
		}
		return null ;
	}
	public static boolean checkatm(List<ATM> list ,ATM b) {
		for(ATM c: list) {
			if(c.getCard_name().equals(b.getCard_name())&& c.getPass().equals(b.getPass())) {
				
				return true;
			}
			
		}
		return false;
	}
	public static boolean ruttien(ATM b,Integer c) {
		if((b.getMoney()-c)>0) {
			b.setMoney(b.getMoney()-c);
			return true;
		}
		return false;
	}
	public static boolean chuyentien(ATM atm ,ATM b,int c) {
		if(atm.getMoney()-c >= 0) {
			
			atm.setMoney(atm.getMoney()-c);
			System.out.println("so tien con laijj cua ban la"+ atm.getMoney());
			b.setMoney(b.getMoney()+c);
		}
		else {
		  System.out.println("so tien cua ban ko du , xin vui long kiem tra laij");
		  
		}
		return false;
	}

}
