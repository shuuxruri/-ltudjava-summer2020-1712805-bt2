package testDB;

public class pk {
	private int Id;
	private String Mssv;
	private String Name;
	private String Subject;
	private String column;
	private float wantedPoint;
	private String reason;
	private String status;
	public pk() {
		// TODO Auto-generated constructor stub
	}
	public String getMssv() {
		return Mssv;
	}
	public void setMssv(String Mssv) {
		this.Mssv = Mssv;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public float getWantedPoint() {
		return wantedPoint;
	}
	public void setWantedPoint(float wantedPoint) {
		this.wantedPoint = wantedPoint;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public pk(String mssv,String name, String subject, String Column,float point,String Reason)
	{
		Mssv = mssv;
		Name = name;
		Subject = subject;
		column = Column;
		wantedPoint = point;
		reason = Reason;
		status = "Chưa xem";
			
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
