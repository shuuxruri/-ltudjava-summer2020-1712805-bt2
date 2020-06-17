package testDB;
import java.util.*;

import java.io.*;
public class SV implements Serializable {
	private int Id;
	private String Mssv;
	private String Name;
	//private score Diem;
	private float Score;
	private String Address;
	private String Note;
	private String Picture;
	private Set<Grade>Grades = new HashSet<Grade>(0);
	Set<Classroom> classes = new HashSet<Classroom>();
	public SV()
	{
		
	}
	public SV(SV student)
	{
		Mssv = student.Mssv;
		Name= student.Name;
		Score = student.Score;
		Address = student.Address;
		Note = student.Note;
		Picture = student.Picture;
		classes = student.classes;
		Id = student.Id;
		Grades = student.Grades;
	}
	public Set<Classroom> getClasses()
	{
		return classes;
	}
	public void setClasses(Set<Classroom>Class)
	{
		classes = Class;
	}
	public SV(String mssv,String name,float score,String address,String note,String picture,int id,Set<Classroom>hp)
	{
		Mssv = mssv;
		Name= name;
		Score = score;
		Address = address;
		Note = note;
		Picture = picture;
		classes = hp;
	}
	public SV(String mssv,String name,float score,String address,String note,String picture,Set<Classroom>hp)
	{
		Mssv = mssv;
		Name= name;
		Score = score;
		Address = address;
		Note = note;
		Picture = picture;
		classes = hp;
	}
	public SV(String mssv,String name,float score,String address,String note,String picture,Set<Grade>gp,Set<Classroom>hp)
	{
		Mssv = mssv;
		Name= name;
		Score = score;
		Address = address;
		Note = note;
		Picture = picture;
		Grades = gp;
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
	public float getScore()
	{
		return Score;
	}
	public String getAddress()
	{
		return Address;
	}
	public String getPicture()
	{
		return Picture;
	}
	public String getNote()
	{
		return Note;
	}
	public  SV getSV()
	{
	return this;
	}
	public void setSV(SV hs)
	{
		Name = hs.Name;
		Address = hs.Address;
		Score = hs.Score;
		Note = hs.Note;
		Mssv = hs.Mssv;
		Picture = hs.Picture;
		
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
	public void setScore(float score)
	{	
		try
	{
		Score = score;
		
	}
	catch(Exception ex)
	{
		System.out.println("failed");
		
	}
	}
	
	public void setNote(String note)
	{
		Note = note;
	}
	public void setAddress(String address)
{
	try
	{
		Address = address;
	}
	catch(Exception ex)
	{
		System.out.println("failed");
	
}
}
	public void setPicture(String picture)
	{
		Picture = picture;
	}
	public  void setStudent(SV hs)
	{
		Name = hs.Name;
		Address = hs.Address;
		Score = hs.Score;
		Note = hs.Note;
		Mssv = hs.Mssv;
		Picture = hs.Picture;
		
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
		
		System.out.println("Mời bạn nhập điểm");
		try
		{
		Score = inputData.nextFloat();
		}
		catch(InputMismatchException a)
		{
			//do something
			System.out.println("lỗi nhập sai số, mời khởi động lại");
			System.exit(0);
			//a.printStackTrace();
		}
		inputData.nextLine();
		
		System.out.println("Mời bạn nhập địa chỉ");
		Address = inputData.nextLine();
		while(Address.matches(regex))
		{
			System.out.println("sai cú pháp, mời bạn nhập địa chỉ");
			Address = inputData.nextLine();
		}
		System.out.println("Mời bạn nhập ghi chú");
		Note = inputData.nextLine();
		while (Note.matches(regex))
		{
			System.out.println("sai cú pháp, mời bạn nhập ghi chú");
			Note = inputData.nextLine();
		}
		System.out.println("Mời bạn nhập đường dẫn ảnh");
		Picture = inputData.nextLine();
		
	}
	
	public void output( )
	{
		
		System.out.print("MSSV: ");
		//in.nextLine();
		System.out.println(Mssv);
		System.out.print("tên: ");
		System.out.println(Name);
		System.out.print("điểm: ");
		System.out.println(Score);
		
		System.out.print("địa chỉ: ");
		System.out.println(Address);
		System.out.print("ghi chú: ");
		System.out.println(Note);
		System.out.print("Đường dẫn ảnh: ");
		System.out.println(Picture);
	
		
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
		dos.writeDouble(Score);
		dos.writeUTF(Address);
		dos.writeUTF(Note);
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
	public Set<Grade> getGrades() {
		return Grades;
	}
	/**
	 * @param grades the grades to set
	 */
	public void setGrades(Set<Grade> grades) {
		this.Grades = grades;
	}
	
}

