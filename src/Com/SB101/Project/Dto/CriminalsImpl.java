package Com.SB101.Project.Dto;

public class CriminalsImpl implements Criminals{
	/**
	 * This class is a implementation of criminals and has all methods of criminals interface and
	 *  shows how a table of criminals in database looks alike
	 */
	private int age;
	private char gender;
	private String address;
	private String name;
	private String identity;
	private String area;
	private CrimesImpl c;

	public CriminalsImpl(int age, char gender, String address, String name, String identity, String area,
			CrimesImpl c) {
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.name = name;
		this.identity = identity;
		this.area = area;
		this.c = c;
	}

	@Override
	public int getAge() {
		return age;
	}
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public char getGender() {
		return gender;
	}
	@Override
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getIdentity() {
		return identity;
	}
	@Override
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	@Override
	public String getArea() {
		return area;
	}
	@Override
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public CrimesImpl getC() {
		return c;
	}
	@Override
	public void setC(CrimesImpl c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "CriminalsImpl [age=" + age + ", gender=" + gender + ", address=" + address + ", name=" + name
				+ ", identity=" + identity + ", area=" + area + ", c=" + c + "]";
	}
	
	
}
