package testDB;

import java.util.*;
import java.io.*;
public class Subject implements Serializable{

	String subjectId;
	String Name;
	//Set<Classroom> classList = new HashSet<Classroom>();
	Set<Schedule> schedule = new HashSet<Schedule>();
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	public Subject(String id, String name){
		subjectId = id;
		Name = name;
		//classList = list;
	}
	public Subject(String id, String name,Set<Schedule>ls){
		subjectId = id;
		Name = name;
		schedule = ls;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String name){
		Name = name;
	}
	public String getsubjectId()
	{
		return subjectId;
	}
	public void setsubjectId(String id) {
		subjectId = id;
	}
	/*public Set<Classroom> getClassList()
	{
		return classList;
	}
	public void setClassList(Set<Classroom>list) {
		classList = list;
	}*/
	public Set<Schedule> getSchedule()
	{
		return schedule;
	}
	public void setSchedule(Set<Schedule> list)
	{
		schedule = list;
	}
	public void addSchedule(Set<Schedule>list) {
	
		for(Schedule ls:list)
			{
			ls.setSubjectId(this);
			schedule.add(ls);
			
			}
		
	}
	public void addSchedule(Schedule sc) {
		if(schedule ==null)
			schedule = new HashSet<Schedule>();
	schedule.add(sc);
	}
	public void subjectOutput()
	{
	System.out.println("Mã môn học: "+subjectId);	
	System.out.println("Tên môn học: "+Name);	
	for(Schedule temp: schedule)
		{
		Classroom x = temp.getClassId();
		System.out.println("Tên lớp: "+x.getClassId());
		///System.out.println("Phòng: "+temp.getRoom());
		}
	}
	
}
