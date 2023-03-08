package Com.SB101.Project.Dto;

import java.time.LocalDateTime;

public class CrimesImpl implements Crimes{
	/**
	 * This class is a implementation of crimes and has all methods of crimes interface and
	 *  shows how a table of crime in database looks alike
	 */
	private LocalDateTime dt;
	private String place;
	private String desp;
	private String victims;
	private String details;
	private String suspect;
	private boolean status;
	
	public CrimesImpl(LocalDateTime dt, String place, String desp, String victims, String details, String suspect,
			boolean status) {
		this.dt = dt;
		this.place = place;
		this.desp = desp;
		this.victims = victims;
		this.details = details;
		this.suspect = suspect;
		this.status = status;
	}
	@Override
	public LocalDateTime getDt() {
		return dt;
	}
	@Override
	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}
	@Override
	public String getPlace() {
		return place;
	}
	@Override
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String getDesp() {
		return desp;
	}
	@Override
	public void setDesp(String desp) {
		this.desp = desp;
	}
	@Override
	public String getVictims() {
		return victims;
	}
	@Override
	public void setVictims(String victims) {
		this.victims = victims;
	}
	@Override
	public String getDetails() {
		return details;
	}
	@Override
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String getSuspect() {
		return suspect;
	}
	@Override
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	@Override
	public boolean isStatus() {
		return status;
	}
	@Override
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CrimesImpl [dt=" + dt + ", place=" + place + ", desp=" + desp + ", victims=" + victims + ", details="
				+ details + ", suspect=" + suspect + ", status=" + status + "]";
	}
	
	
}
