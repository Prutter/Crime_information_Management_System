package Com.SB101.Project.Dao;

import java.sql.SQLException;

public interface CrimeFunctionalities {
	/**  
	 * This abstract method will return whether a crime is registered or not.
	 * @return returns a string based on result that whether crime is registered or not.
	 * @throws SQLException
	 */
	public String addCrime() throws SQLException;
	/**
	 * This abstract method will add a criminal with a crime associated with it.
	 * @return string showing whether one will be added as criminal or not. 
	 * @throws SQLException
	 */
	public String addCriminals() throws SQLException;
	/**
	 * abstract method will return total crimes registered in an area which is specified
	 * @param area
	 * @return an integer showing the count of crimes so far registered.
	 * @throws SQLException
	 */
	public int countTotalCrimes(String area) throws SQLException;
	/**
	 * abstract method will return total crimes which are solved registered in an area which is specified
	 * @param area
	 * @return an integer showing the count of solved crimes so far registered.
	 * @throws SQLException
	 */
	public int countSolvedCrimes(String area) throws SQLException;
	/**
	 * abstract method will return total crimes which are unsolved registered in an area which is specified
	 * @param area
	 * @return an integer showing the count of unsolved crimes so far registered.
	 * @throws SQLException
	 */
	public int countUnsolvedCrimes(String area) throws SQLException;
	/**
	 * abstract method will return total criminals who were arrested from the area specified 
	 * @param area
	 * @return an integer showing total criminals in the specified area
	 * @throws SQLException
	 */
	public int countTotalCriminals(String area) throws SQLException;
	/**
	 * abstract method will return a string all records of crimes which are solved
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesBySolved() throws SQLException;
	/**
	 * abstract method will return a string all records of crimes which are unsolved
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByUnsolved() throws SQLException;
	/**
	 * abstract method will return a string all records of crimes which are registered in a specified place or area
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByPlace(String area) throws SQLException;
	/**
	 * abstract method will return a string all records of crimes which are registered in a specified month which is taken as integer
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByMonth() throws SQLException;
	/**
	 * abstract method will return a string all records of crimes which are registered with a specified description
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByDescription() throws SQLException;
	/**
	 * abstract method will return a string all records of crimes which are registered with a specified date which is internally used as yyyy-mm-dd
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCrimesByDate() throws SQLException;
	/**
	 * abstract method will return a string all records of criminals which are under a age bracket not inclusive of both.
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByAge() throws SQLException;
	/**
	 * abstract method will return a string all records of criminals who belongs to a gender 
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByGender() throws SQLException;
	/**
	 * abstract method will return a string all records of criminals who are having a particular identity
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByIdentity() throws SQLException;
	/**
	 * abstract method will return a string all records of criminals who live in a area specified internally
	 * @return string of records
	 * @throws SQLException
	 */
	public String getCriminalsByArea(String area) throws SQLException;
	/**
	 * abstract method will return a string all records of all crimes whose criminals are arrested and being solved after updating the status of crimes
	 * @return string of records
	 * @throws SQLException
	 */
	public String updateUnsolvedToSolved(String area) throws SQLException;
	/**
	 * abstract method will return a string all records of all crimes which are not solved after deleting the solved crimes
	 * @return string of records
	 * @throws SQLException
	 */
	public String deleteAllSolvedCrimes(String area) throws SQLException;
}
