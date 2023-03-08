package Com.SB101.Project.UI;

public class DisplayList {
	public DisplayList() {
		super();
	}
	
	/**
	 * this method is only used for showing the list of options that one can choose for doing a operation whatever one wants to do 
	 */
	public void displayDropDown() {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("Enter your choice what you want to do.\n"
				+ "\t0.  To exit from our system.\n"
				+ "\t1.  Register a new crime\n"
				+ "\t2.  Register a new criminal\n"
				+ "\t3.  Total crimes records ( solved or not solved )\n"
				+ "\t4.  Total criminals in your area recorded\n"
				+ "\t5.  Get all details of crimes records which are solved\n"
				+ "\t6.  Get all details of crimes records which are unsolved\n"
				+ "\t7.  Get all crimes records of a specific place\n"
				+ "\t8.  Get all crimes record of a specified month\n"
				+ "\t9.  Get all crimes record of specified description.\n"
				+ "\t10. Get all crimes that are logged into system on a particular date.\n"
				+ "\t11. Get all criminals who were arrested in your area.\n"
				+ "\t12. Get all criminals who belongs to a particular age brackets\n"
				+ "\t13. Get all criminals who belongs to a particular gender.\n"
				+ "\t14. Get all criminals who have a particular identity or facial marks\n"
				+ "\t15. Get all criminals arrested in all police stations\n"
				+ "\t16. Update all crimes whise criminals are arrested.\n"
				+ "\t17. Delete all solved registered crimes whose criminals were arrested.");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
	}
}
