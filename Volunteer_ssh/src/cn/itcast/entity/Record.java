package cn.itcast.entity;

public class Record {

	private int id;
	private Integer volId;
	private Integer actId;
	private Boolean isJoined;
	private Boolean isFinished;
	private Boolean isCollected;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getVolId() {
		return volId;
	}
	public void setVolId(Integer volId) {
		this.volId = volId;
	}
	public Integer getActId() {
		return actId;
	}
	public void setActId(Integer actId) {
		this.actId = actId;
	}
	public Boolean getIsJoined() {
		return isJoined;
	}
	public void setIsJoined(Boolean isJoined) {
		this.isJoined = isJoined;
	}
	public Boolean getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}
	public Boolean getIsCollected() {
		return isCollected;
	}
	public void setIsCollected(Boolean isCollected) {
		this.isCollected = isCollected;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", volId=" + volId + ", actId=" + actId + ", isJoined=" + isJoined + ", isFinished="
				+ isFinished + ", isCollected=" + isCollected + "]";
	}
	
}
