package Com.SB101.Project.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CrimeFunctionalitiesImpl implements CrimeFunctionalities{
	Scanner sc = new Scanner(System.in);
	
	
	/**
	 * private method is used to find whether a result set is empty or not.
	 * @param  : a reference of ResultSet
	 * @return
	 * @throws SQLException
	 */
	private boolean isResultSetEmpty(ResultSet res) throws SQLException{
		if(!res.isBeforeFirst() && res.getRow()==0)
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * This method will return whether a crime is registered or not.
	 * @return returns a string based on result that whether crime is registered or not.
	 * @throws SQLException
	 */
	public String addCrime() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query = "Insert into crime (place,description,victim_name,suspect_name,details,date_of_crime,time_of_crime) values (?,?,?,?,?,?,?)";
		PreparedStatement st = c.prepareStatement(query);
		st.setDate(6,Date.valueOf(LocalDate.now()));
		st.setTime(7,Time.valueOf(LocalTime.now()));
		System.out.println("Enter place, description, victim, suspect, details of crime");
		st.setString(1, sc.nextLine());
		st.setString(2, sc.nextLine());
		st.setString(3, sc.nextLine());
		st.setString(4, sc.nextLine());
		st.setString(5, sc.nextLine());
		if(st.executeUpdate()>0)
			return "Crime registered in database successfully\n";
		else
			return "Crime not registered. Something went wrong.\n";
	}
	
	
	
	/**
	 * This method will add a criminal with a crime associated with it.
	 * @return string showing whether one will be added as criminal or not. 
	 * @throws SQLException
	 */
	public String addCriminals() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		System.out.println("Enter name, gender,age, identity, area, crimeid of arrested criminal");
		String query = "Insert into criminals ( name, gender, age, identity,area, crime_no) values (?,?,?,?,?,?)";
		PreparedStatement st = c.prepareStatement(query);
		st.setString(1, sc.nextLine());
		st.setString(2, sc.nextLine());
		st.setInt(3, Integer.parseInt(sc.nextLine()));
		st.setString(4, sc.nextLine());
		st.setString(5, sc.nextLine());
		st.setInt(6, Integer.parseInt(sc.nextLine()));
		if(st.executeUpdate()>0)
			return "Criminal added\n";
		else
			return "Criminal not added\n";
	}
	
	
	
	/**
	 * will return total crimes registered in an area which is specified
	 * @param area
	 * @return an integer showing the count of crimes so far registered.
	 * @throws SQLException
	 */
	public int countTotalCrimes(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query = "Select * from crime where place like '%"+area+"'";
		PreparedStatement st = c.prepareStatement(query);
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return 0;
		else {
			int count=0;
			while(res.next()){
				count++;
			}
			return count;
		}
	}
	
	
	
	/**
	 * will return total crimes which are solved registered in an area which is specified
	 * @param area
	 * @return an integer showing the count of solved crimes so far registered.
	 * @throws SQLException
	 */
	public int countSolvedCrimes(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query = "Select * from crime where solved = 1 and place like '%"+area+"'";
		PreparedStatement st = c.prepareStatement(query);
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return 0;
		else {
			int count=0;
			while(res.next()){
				count++;
			}
			return count;
		}
	}
	
	
	
	/**
	 * will return total crimes which are unsolved registered in an area which is specified
	 * @param area
	 * @return an integer showing the count of unsolved crimes so far registered.
	 * @throws SQLException
	 */
	public int countUnsolvedCrimes(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query = "Select * from crime where solved = 0 and place like '%"+area+"'";
		PreparedStatement st = c.prepareStatement(query);
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return 0;
		else {
			int count=0;
			while(res.next()){
				count++;
			}
			return count;
		}
	}
	
	
	
	/**
	 * will return total criminals who were arrested from the area specified 
	 * @param area
	 * @return an integer showing total criminals in the specified area
	 * @throws SQLException
	 */
	public int countTotalCriminals(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query = "Select * from criminals where area like '%"+area+"'";
		PreparedStatement st = c.prepareStatement(query);
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return 0;
		else {
			int count=0;
			while(res.next()){
				count++;
			}
			return count;
		}
	}
	
	
	
	/**
	 * will return a string all records of crimes which are solved
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesBySolved() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query= "Select distinct time_of_crime, date_of_crime, victim_name, details from crime inner join criminals on crimeId=crime_no where crime.solved=1";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Crime log is solved till yet.\n".toString();
		else {
			while(res.next()){
				String s= "Crime on "+res.getDate("date_of_crime")+" at "+ res.getTime("time_of_crime")+" with "
						+res.getString("victim_name")+" of "+res.getString("details")+"\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of crimes which are unsolved
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByUnsolved() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query= "Select distinct time_of_crime, date_of_crime, victim_name, details from crime inner join criminals on crimeId=crime_no where crime.solved=0";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "All crime logs are unsolved. Charge up guys.!\n".toString();
		else {
			while(res.next()){
				String s= "Crime on "+res.getDate("date_of_crime")+" at "+ res.getTime("time_of_crime")+" with "
						+res.getString("victim_name")+" of "+res.getString("details")+"\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of crimes which are registered in a specified place or area
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByPlace(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query= "Select * from crime where place like '%"+area+"'";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Crime log is solved till yet.\n".toString();
		else {
			while(res.next()){
				String s= "Crime on "+res.getDate("date_of_crime")+" at "+ res.getTime("time_of_crime")+" with "
						+res.getString("victim_name")+" of "+res.getString("details")+"\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of crimes which are registered with a specified description
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByDescription() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		System.out.println("Please specify the desciption of crime you want to search.");
		String des= sc.nextLine();
		String query= "Select * from crime where description = '%"+des+"%'";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Crime log is found of such description.\n".toString();
		else {
			while(res.next()){
				String s= "Crime on "+res.getDate("date_of_crime")+" at "+ res.getTime("time_of_crime")+" with "
						+res.getString("victim_name")+" of "+res.getString("details")+"\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of crimes which are registered with a specified date which is internally used as yyyy-mm-dd
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByDate() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		System.out.println("Please specify the date (yyyy-mm-dd) of crime you want to search.");
		LocalDate dt = LocalDate.parse(sc.next());
		String query= "Select * from crime where date_of_crime = '"+dt+"'";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Crime log is solved till yet.\n".toString();
		else {
			while(res.next()){
				String s= "Crime on "+res.getDate("date_of_crime")+" at "+ res.getTime("time_of_crime")+" with "
						+res.getString("victim_name")+" of "+res.getString("details")+"\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of crimes which are registered in a specified month which is taken as integer
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByMonth() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		System.out.println("Enter month as digit to get crimes logged in that month.\n");
		int month = sc.nextInt();
		String query= "Select * from crime where month(date_of_crime)="+month+"";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Crime log is solved till yet.\n".toString();
		else {
			while(res.next()){
				String s= "Crime on "+res.getDate("date_of_crime")+" at "+ res.getTime("time_of_crime")+" with "
						+res.getString("victim_name")+" of "+res.getString("details")+"\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of criminals which are under a age bracket not inclusive of both.
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByAge() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		System.out.println("Enter age bracket for which criminals are you searching.\n");
		int age1 = sc.nextInt();
		int age2 = sc.nextInt();
		String query= "Select * from criminals where age>="+age1+" and age <="+ age2;
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Criminal found in this age bracket.\n".toString();
		else {
			while(res.next()){
				String s= "Criminal of age "+res.getInt("age")+" having name is "+res.getString("name")+" and gender "
						+(res.getString("gender").toUpperCase()=="MALE"?"male":"female") + "\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of criminals who belongs to a gender 
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByGender() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		System.out.println("Enter gender of criminals which you are searching.\n");
		String gender = sc.next();
		String query= "Select * from criminals where gender = '"+gender+"'";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Criminal found in this age bracket.\n".toString();
		else {
			String sss= ("All criminals of gender "+gender+"\n").toString();
			str.append(sss);
			while(res.next()){
				String s= "Criminal of age "+res.getInt("age")+" having name is "+res.getString("name") +" lives "
						+ "in "+res.getString("area")+ "\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of criminals who are having a particular identity
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByIdentity() throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		System.out.println("Enter identity of criminals which you are searching.\n");
		String identity = sc.next();
		String query= "Select * from criminals where identity like '%"+identity+"%'";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No Criminal found of such identity.\n".toString();
		else {
			String sss= ("All criminals of having "+identity+" are :- \n").toString();
			str.append(sss);
			while(res.next()){
				String s= "Criminal of age "+res.getInt("age")+" having name is "+res.getString("name") +" lives "
						+ "in "+res.getString("area")+ "\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of criminals who live in a area specified internally
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByArea(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query= "Select * from criminals where area like '%"+area+"'";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		ResultSet res = st.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "no criminal arrested.\n".toString();
		else {
			String sss= ("\n\tAll criminals who were arrested from "+area+" are :- \n").toString();
			str.append(sss);
			while(res.next()){
				String s= "\tCriminal of age "+res.getInt("age")+" having name is "+res.getString("name") +" lives "
						+ "in "+res.getString("area")+ "\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of all crimes whose criminals are arrested and being solved after updating the status of crimes
	 * @return string of records
	 * @throws SQLException
	 */
	public String updateUnsolvedToSolved(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query= "update crime inner join criminals on crime.crimeid= criminals.crime_no set solved=1";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		if(st.executeUpdate()>0)
			System.out.println("The crimes which are solved by arresting criminals is updated.");
		else
			System.out.println("The record od crimes are already updated.");
		String q = "select distinct time_of_crime,date_of_crime,name,victim_name, age,identity  from crime cross join criminals on crime.crimeid= criminals.crime_no where solved=1;";
		PreparedStatement state = c.prepareStatement(q);
		ResultSet res = state.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "No crime is solved till yet.\n".toString();
		else {
			String sss= ("\n\tAll crimes which are solved are :- \n").toString();
			str.append(sss);
			while(res.next()){
				String s= "\tCriminal of age "+res.getInt("age")+" having name is "+res.getString("name")+" having "+res.getString("identity") +" has crime done on "
						+res.getString("date_of_crime")+ " at "+res.getString("time_of_crime")+" with "+res.getString("victim_name")+"\n";
				str.append(s);
			}
			return str.toString();
		}
	}
	
	
	
	/**
	 * will return a string all records of all crimes which are not solved after deleting the solved crimes
	 * @return string of records
	 * @throws SQLException
	 */
	public String deleteAllSolvedCrimes(String area) throws SQLException{
		Connection c = null;
		c = DBUtils.connectToDatabase();
		String query= "delete from crime where place like '%"+area+"%' and solved =1";
		PreparedStatement st = c.prepareStatement(query);
		StringBuilder str = new StringBuilder();
		if(st.executeUpdate()>0)
			System.out.println("The crimes which are solved by arresting criminals are deleted.");
		else
			System.out.println("The record of crimes are already updated.");
		String q = "select distinct time_of_crime,date_of_crime,victim_name,place, description,details  from crime where solved= 0";
		PreparedStatement state = c.prepareStatement(q);
		ResultSet res = state.executeQuery();
		if(isResultSetEmpty(res)==true)
			return "All crimes are already solved.\n".toString();
		else {
			String sss= ("\nAll crimes which are unsolved are :- \n").toString();
			str.append(sss);
			while(res.next()){
				String s= "Crime on "+res.getDate("date_of_crime")+" at "+ res.getTime("time_of_crime")+" with "
						+res.getString("victim_name")+" of "+res.getString("details")+" under "+res.getString("description")+" is not solved till now.\n";
				str.append(s);
			}
			return str.toString();
		}
	}
}
