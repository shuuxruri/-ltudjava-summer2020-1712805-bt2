package testDB;

import java.io.Serializable;
import java.util.*;

public class Schedule implements Serializable {

	//Set<Classroom> classList = new HashSet<Classroom>();
	private Classroom classId = new Classroom();
	private Subject subjectId = new Subject();
	private String room;
	private int Id;
	private int stt;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Subject getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}

	public Classroom getClassId() {
		return classId;
	}

	public void setClassId(Classroom classId) {
		this.classId = classId;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	public Schedule(String Room)
	{
		subjectId = null;
		classId = null;
		room = Room;
	}
	public Schedule(int Stt,Classroom ClassId,Subject SubjectId,String Room)
	{
		stt =Stt;
		classId = ClassId;
		subjectId = SubjectId;
		room = Room;
	}
	public void setClassroom(Classroom cl) {
		classId = cl;
	}
	
	void output() {
		//System.out.println("Lớp: "+classId);
		classId.output();
		subjectId.subjectOutput();
		System.out.println("Phòng: "+room);
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Schedule(Classroom ClassId,Subject SubjectId,String Room,int Stt)
	{
		classId = ClassId;
		subjectId = SubjectId;
		room = Room;
		stt =Stt;
		
	}
	public Schedule(int Stt,String Room)
	{
		stt = Stt;
		room = Room;
		
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

}
