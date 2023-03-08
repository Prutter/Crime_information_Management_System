package Com.SB101.Project.Dto;

import java.time.LocalDateTime;

public interface Crimes {
	/**
	 * this interface is a replica of the crime table described into the database with only abstract methods
	 */
	public LocalDateTime getDt();
	public void setDt(LocalDateTime dt);
	public String getPlace();
	public void setPlace(String place);
	public String getDesp();
	public void setDesp(String desp);
	public String getVictims();
	public void setVictims(String victims);
	public String getDetails();
	public void setDetails(String details);
	public String getSuspect();
	public void setSuspect(String suspect);
	public boolean isStatus();
	public void setStatus(boolean status);
}
