package testDB;
import java.util.*;

import java.io.*;
public class SV implements Serializable {
	private int Id;
	private String Mssv;
	private String Name;
	//private score Diem;
	
	private String Gender;
	private String CMND;
	
	private Set<Grade>Grades = new HashSet<Grade>(0);
	Set<Classroom> classes = new HashSet<Classroom>(0);
	public SV()
	{
		
	}
	public SV(SV student)
	{
		Mssv = student.Mssv;
		Name= student.Name;
	
		Gender = student.Gender;
		CMND = student.CMND;
		//Picture = student.Picture;
		classes = student.classes;
		Id = student.Id;
		//Grades = student.Grades;
	}
	public Set<Classroom> getClasses()
	{
		return classes;
	}
	public void setClasses(Set<Classroom>Class)
	{
		classes = Class;
	}
	public SV(int id,String mssv,String name,String gender,String cmnd,Set<Classroom>hp)
	{
		Mssv = mssv;
		Name= name;
		//Score = score;
		Gender = gender;
		CMND = cmnd;
		//Picture = picture;
		classes = hp;
		Id = id;
	}
	public SV(int id,String mssv,String name,String gender,String cmnd)
	{
		Mssv = mssv;
		Name= name;
		//Score = score;
		Gender = gender;
		CMND = cmnd;
		//Picture = picture;
		
		Id = id;
	}
	public SV(String mssv,String name,String gender,String cmnd)
	{
		Mssv = mssv;
		Name= name;
		//Score = score;
		Gender = gender;
		CMND = cmnd;
		//Picture = picture;
		
		//Id = id;
	}
	public void addClassroom(Classroom cl) {
		if(classes ==null)
			classes = new HashSet<Classroom>();
		classes.add(cl);
	}
	public SV(String mssv,String name,String gender,String cmnd,Set<Classroom>hp)
	{
		Mssv = mssv;
		Name= name;
		
		Gender = gender;
		CMND = cmnd;
		
		classes = hp;
	}
	
	public String getName()
	{
		return Name;
	}
	public String getMssv()
	{
		return Mssv;
	}
	public int getId()
	{
		return Id;
	}
	
	public String getGender()
	{
		return Gender;
	}
	
	public String getCMND()
	{
		return CMND;
	}
	public  SV getSV()
	{
	return this;
	}
	public void setSV(SV hs)
	{
		Name = hs.Name;
		Gender = hs.Gender;
		//Score = hs.Score;
		CMND = hs.CMND;
		Mssv = hs.Mssv;
		//Picture = hs.Picture;
		
	}
	public void setName(String name)
	{
		try
		{
			Name = name;
			
		}
		catch(Exception ex)
		{
			System.out.println("failed");
			
		}
	}
	void setId(int id)
	{
	Id = id;	
		
	}
	public void setMssv(String mssv)
	{	
		try
	{
		Mssv = mssv;
		
	}
	catch(Exception ex)
	{
		System.out.println("failed");
		
	}
	}
	
	
	
	public void setCMND(String cmnd)
	{
		CMND = cmnd;
	}
	public void setGender(String gender)
{
	try
	{
		Gender = gender;
	}
	catch(Exception ex)
	{
		System.out.println("failed");
	
}
}

	public  void setStudent(SV hs)
	{
		Name = hs.Name;
		Gender = hs.Gender;
		//Score = hs.Score;
		CMND = hs.CMND;
		Mssv = hs.Mssv;
		//Picture = hs.Picture;
		
	}
	public void input(Scanner inputData )
	{
	 final String nameRegex = ".*[\\<\\(\\[\\{\\^\\-\\=\\$\\!\\|\\]\\}\\)\\?\\*\\+\\.\\>;,]+.*";
	 final String regex = ".*[\\<\\(\\[\\{\\^\\-\\=\\$\\!\\|\\]\\}\\)\\?\\*\\+\\>]+.*";
	
		final String idRegex = "\\w+";
		
		
		System.out.println("Mời bạn nhập MSV");
		//in.nextLine();
		Mssv = inputData.nextLine();
		while(!Mssv.matches(idRegex))
		{
			System.out.println("Sai cú pháp, mời bạn nhập lại MSV");
			//in.nextLine();
			Mssv = inputData.nextLine();
		}
		
		
		System.out.println("Mời bạn nhập tên");
		Name = inputData.nextLine();
		while(Name.matches(nameRegex))
		{
			System.out.println("Sai cú pháp, mời bạn nhập lại tên");
			Name = inputData.nextLine();
		}
		
		
	
		inputData.nextLine();
		
		System.out.println("Mời bạn nhập địa chỉ");
		Gender = inputData.nextLine();
		while(Gender.matches(regex))
		{
			System.out.println("sai cú pháp, mời bạn nhập địa chỉ");
			Gender = inputData.nextLine();
		}
		System.out.println("Mời bạn nhập ghi chú");
		CMND = inputData.nextLine();
		while (CMND.matches(regex))
		{
			System.out.println("sai cú pháp, mời bạn nhập ghi chú");
			CMND = inputData.nextLine();
		}
	
		
	}
	
	public void output( )
	{
		
		System.out.print("MSSV: ");
		//in.nextLine();
		System.out.println(Mssv);
		System.out.print("tên: ");
		System.out.println(Name);
		
		
		System.out.print("Giới tính: ");
		System.out.println(Gender);
		System.out.print("CMND: ");
		System.out.println(CMND);
		
	
		
	}
	public void writeFile()
	{
	DataOutputStream dos;
	try 
	{
		dos=new DataOutputStream(
				new FileOutputStream("abcde.txt"));
	}
	catch(IOException exc) 
	{
		System.out.println("Error open file !");
		return;
	}
	
	try 
	{
		dos.writeUTF(Mssv);
		dos.writeUTF(Name);
		
		dos.writeUTF(Gender);
		dos.writeUTF(CMND);
		dos.close();
	}
	catch(IOException exc) 
	{
		System.out.println("Error write file.");
	}
	
	}
	/**
	 * @return the grades
	 */
	/*public Set<Grade> getGrades() {
		return Grades;
	}
	
	public void setGrades(Set<Grade> grades) {
		this.Grades = grades;
	}*/
	/**
	 * @return the gender
	 */
	public Set<Grade> getGrades() {
		return Grades;
	}
	public void setGrades(Set<Grade> grades) {
		Grades = grades;
	}
	public void addGrade(Grade gp) {
		Grades.add(gp);
		
	}
	
	
}

