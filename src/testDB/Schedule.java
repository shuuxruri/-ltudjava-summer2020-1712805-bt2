package testDB;

import java.io.Serializable;
import java.util.*;

public class Schedule implements Serializable {

	//Set<Classroom> classList = new HashSet<Classroom>();
	private subjectClassId idKey;
	
	private String room;
	
	private int stt;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	public Schedule(int Stt,subjectClassId key,String Room)
	{
		stt =Stt;
		idKey = key;
		room = Room;
	}
	
	
	void output() {
		//System.out.println("Lớp: "+classId);
		
		System.out.println("Phòng: "+room);
	}

	

	public Schedule(subjectClassId key,String Room,int Stt)
	{
		idKey = key;
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



	public subjectClassId getIdKey() {
		return idKey;
	}



	public void setIdKey(subjectClassId idKey) {
		this.idKey = idKey;
	}

}
