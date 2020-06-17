package testDB;

import java.util.*;

public class Subject {

	String Id;
	String Name;
	Set<Classroom> classList = new HashSet<Classroom>();
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	public Subject(String id, String name,Set<Classroom>list){
		Id = id;
		Name = name;
		classList = list;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String name){
		Name = name;
	}
	public String getId()
	{
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public Set<Classroom> getClassList()
	{
		return classList;
	}
	public void setClassList(Set<Classroom>list) {
		classList = list;
	}
}
