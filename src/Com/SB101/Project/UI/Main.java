package Com.SB101.Project.UI;

import Com.SB101.Project.Dao.CrimeFunctionalitiesImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	/**
	 * This class & method is basically a command line interface which acts as a UI
	 * for our crime information management system 
	 * @param args which are not ued in command line
	 */
	
	
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
CrimeFunctionalitiesImpl CFI = new CrimeFunctionalitiesImpl();
System.out.println("Welcome To North-West Delhi Police.\nThere are three police stations under us.\n"
		+ "\t1. Kanjhawala\n\t2. Rama-Vihar\n\t3. Krishna-Vihar");
System.out.println("Choice your police station area");
String area = sc.nextLine();
System.out.println("Your police station is :- "+ area+"\n");
DisplayList d = new DisplayList();
d.displayDropDown();
int choice = sc.nextInt();
System.out.println("You choose "+choice);
try {
	do {
		if(choice==0)
			break;
		else if(choice==1)
			System.out.println(CFI.addCrime());
		else if(choice==2)
			System.out.println(CFI.addCriminals());
		else if(choice==3)
			System.out.println("Total crimes records in "+area+" are "+ CFI.countTotalCrimes(area)+"\n"
					+"Total solved records in "+area+" are "+ CFI.countSolvedCrimes(area)+"\n"
					+"Total unsolved crime records in "+area+" are "+ CFI.countUnsolvedCrimes(area));
		else if(choice==4)
			System.out.println("Total criminal recorded in "+area+" "+CFI.countTotalCriminals(area));
		else if(choice==5)
			System.out.println(CFI.getCrimesBySolved());
		else if(choice==6)
			System.out.println(CFI.getCrimesByUnsolved());
		else if(choice==7)
			System.out.println(CFI.getCrimesByPlace(area));
		else if(choice==8)
			System.out.println(CFI.getCrimesByMonth());
		else if(choice==9)
			System.out.println(CFI.getCrimesByDescription());
		else if(choice==10)
			System.out.println("The crimes registered are :- \n"+ CFI.getCrimesByDate());
		else if(choice==11)
			System.out.println("The criminals who arrested in your area\n"+ CFI.getCriminalsByArea(area));
		else if(choice==12)
			System.out.println("The criminals who arrested in your area amd in a particular age bracket\n"+ CFI.getCriminalsByAge());
		else if(choice==13)
			System.out.println("The criminals who arrested in your area based on a gender\n"+ CFI.getCriminalsByGender());
		else if(choice==14)
			System.out.println("The criminals who arrested in your area having a particular identity\n"+ CFI.getCriminalsByIdentity());
		else if(choice==15) {
			String[] a = {"Kanjhawala","Rama-Vihar","Krishna-Vihar"}; 
			for(int i=0;i<a.length;i++)
			System.out.println(a[i] +" has "+CFI.getCriminalsByArea(a[i]));
		}else if(choice==16)
			System.out.println(CFI.updateUnsolvedToSolved(area));
		else if(choice==17)
			System.out.println(CFI.deleteAllSolvedCrimes(area));
		else {
			System.out.println("Wrong input you have entered.");
			break;
		}
			
		d.displayDropDown();
		sc.nextLine();
		choice = sc.nextInt();
		System.out.println("You choose "+choice);
	}while(choice!=0);
}catch(SQLException e){
	e.printStackTrace();
}
sc.close();
System.out.println("NorthWest Delhi Police At Your Service At It's Best.");
	}
}
