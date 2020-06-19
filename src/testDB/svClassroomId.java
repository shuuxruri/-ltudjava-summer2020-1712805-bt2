package testDB;

import java.io.Serializable;

public class svClassroomId implements Serializable{
private Classroom classId;
private SV Mssv;
	public svClassroomId() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the classId
	 */
	public Classroom getClassId() {
		return classId;
	}
	/**
	 * @param classId the classId to set
	 */
	public void setClassId(Classroom classId) {
		this.classId = classId;
	}
	public SV getMssv() {
		return Mssv;
	}
	public void setMssv(SV mssv) {
		Mssv = mssv;
	}
	public svClassroomId(svClassroomId key)
	{
		classId = key.classId;
		Mssv = key.Mssv;
	}
	public svClassroomId(Classroom cl, SV sv)
	{
		classId = cl;
		Mssv = sv;
	}
	public svClassroomId( SV sv,Classroom cl)
	{
		classId = cl;
		Mssv = sv;
	}

}
