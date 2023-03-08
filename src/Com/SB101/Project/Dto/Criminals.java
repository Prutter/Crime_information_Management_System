package Com.SB101.Project.Dto;

public interface Criminals {
	/**
	 * this interface is a replica of the criminals table described into the database with only abstract methods
	 */
	public int getAge();
	public void setAge(int age);
	public char getGender();
	public void setGender(char gender);
	public String getAddress();
	public void setAddress(String address);
	public String getName();
	public void setName(String name);
	public String getIdentity();
	public void setIdentity(String identity);
	public String getArea();
	public void setArea(String area);
	public CrimesImpl getC();
	public void setC(CrimesImpl c);
}
