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
	public void setSchedule(Set<Schedule>list) {
		schedule = list;
	}
	public void addSchedule(Schedule sc) {
		schedule.add(sc);
	}
	public void subjectOutput()
	{
	System.out.println("Mã môn học: "+subjectId);	
	System.out.println("Tên môn học: "+Name);	
	}
	
}
