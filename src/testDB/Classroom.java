package testDB;
import java.util.*;

import testDB.SV;

import java.io.*;


//package java.io.package.*;
public class Classroom implements Serializable{
//public static HashSet <SV> DSSV2 ;
	String Name;
public   Set <SV>DSSV= new HashSet<SV>(0); 
private static final char  DEFAULT_QUOTE = '\"';
private static final char DEFAULT_SEPERATOR = ',';
Set<Schedule>ScheduleList = new HashSet<Schedule>(0);
private Set<Grade>GradeList = new HashSet<Grade>(0);

public Classroom()
{
	
	
}
public String getName()
{
return Name;	
}
public void setName()
{
	
}
/*public Set<SV> getDSSV()
{
return DSSV;	
}*/
public Set<SV> getDSSV()
{
return DSSV;	
}
public void setDSSV(Set<SV>dssv)
{
	DSSV = dssv;
}
public Set<Schedule> getScheduleList()
{
return ScheduleList;	
}
public void setScheduleList(Set<Schedule>list)
{
	ScheduleList = list;
}

public Classroom(String name, Set<SV> dssv,Set<Grade>gp)

{
Name = name;
DSSV = dssv;
GradeList = gp;
}
public Classroom(Classroom Class)
{
Name = Class.Name;
DSSV = Class.DSSV;
ScheduleList = Class.ScheduleList;
GradeList = Class.GradeList;
}
/*public static SV advancedConvert(String str)
{
	boolean startCollect = false;
	boolean insideQuote = false;

	StringBuffer buffer = new StringBuffer();
	char[]charArray = str.toCharArray();
	Set <String>result = new HashSet<String>();
	 
	for(char ch : charArray)
	{
		if(insideQuote)
		{
			startCollect = true;
			//không thể fix đc trường hợp đặc biệt
			if(ch == DEFAULT_QUOTE)
				{
				insideQuote = false;
				}
			else
				{
					buffer.append(ch);
					
				}
		}
		else
		{
			if(ch == DEFAULT_QUOTE)
			{
				insideQuote = true;
				//kiểm tra syntax
				if(charArray[0]!='\"')
				{
					buffer.append(ch);
				}
				// kiểm tra trường hợp nhập \" trong ""
				if(startCollect)
				{
					buffer.append(ch);
				}
				
			 } 
			else if(ch == DEFAULT_SEPERATOR)
			{
				result.add(buffer.toString());
				//System.out.println(buffer);
				buffer = new StringBuffer();
				// kết thúc 1 biến
				startCollect = false;
			}
			else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                }
			else if (ch == '\n') {
                    //the end, break!
                    break;
                }
			else {
                    buffer.append(ch);
                }
			}
		}
	// thêm biến cuối
	result.add(buffer.toString());
	if(result.size()>6)
		{
		System.out.println("Lỗi định dạng file");
		System.exit(-1);
		}
		
	// có thể làm cách ít lỗi hơn bằng cách đem hết vào 1 mảng String[]( như cách ở dưới
	SV student = new SV(result.get(0),result.get(1),Float.parseFloat(result.get(2)),result.get(3),result.get(4),result.get(5));
	
	return  student;
}*/
public static SV advancedConvert(String str)
{
	boolean startCollect = false;
	boolean insideQuote = false;

	StringBuffer buffer = new StringBuffer();
	char[]charArray = str.toCharArray();
	List <String>result = new ArrayList<String>();
	 
	for(char ch : charArray)
	{
		if(insideQuote)
		{
			startCollect = true;
			//không thể fix đc trường hợp đặc biệt
			if(ch == DEFAULT_QUOTE)
				{
				insideQuote = false;
				}
			else
				{
					buffer.append(ch);
					
				}
		}
		else
		{
			if(ch == DEFAULT_QUOTE)
			{
				insideQuote = true;
				//kiểm tra syntax
				if(charArray[0]!='\"')
				{
					buffer.append(ch);
				}
				// kiểm tra trường hợp nhập \" trong ""
				if(startCollect)
				{
					buffer.append(ch);
				}
				
			 } 
			else if(ch == DEFAULT_SEPERATOR)
			{
				result.add(buffer.toString());
				//System.out.println(buffer);
				buffer = new StringBuffer();
				// kết thúc 1 biến
				startCollect = false;
			}
			else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                }
			else if (ch == '\n') {
                    //the end, break!
                    break;
                }
			else {
                    buffer.append(ch);
                }
			}
		}
	// thêm biến cuối
	result.add(buffer.toString());
	if(result.size()>6)
		{
		System.out.println("Lỗi định dạng file");
		System.exit(-1);
		}
		
	// có thể làm cách ít lỗi hơn bằng cách đem hết vào 1 mảng String[]( như cách ở dưới
	SV student = new SV(result.get(0),result.get(1),Float.parseFloat(result.get(2)),result.get(3),result.get(4),result.get(5),1,null);
	
	return  student;
}

/*public static void AcsId()
{
	if(DSSV.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return;
	}
	else
	{
		for(int i = 0; i < DSSV.size(); i++)
			for(int j = i+1; j < DSSV.size(); j++)
				if(DSSV.get(i).getMssv().compareTo(DSSV.get(j).getMssv())>0)
					 Collections.swap( DSSV, i, j);
	}
	for(SV student:DSSV)
		student.output();
}
public static void DcsId()
{
	if(DSSV.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return;
	}
	else
	{
		for(int i = 0; i < DSSV.size(); i++)
			for(int j = i+1; j < DSSV.size(); j++)
				if(DSSV.get(i).getMssv().compareTo(DSSV.get(j).getMssv())<0)
					 Collections.swap( DSSV, i, j);
	}
	for(SV student:DSSV)
		student.output();
}
public static void AcsScore()
{
	if(DSSV.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return;
	}
	else
	{
		for(int i = 0; i < DSSV.size(); i++)
			for(int j = i+1; j < DSSV.size(); j++)
				if(DSSV.get(i).getScore()>DSSV.get(j).getScore())
					 Collections.swap( DSSV, i, j);
	}
	for(SV student:DSSV)
		student.output();
}
public static void DcsScore()
{
	if(DSSV.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return;
	}
	else
	{
		for(int i = 0; i < DSSV.size(); i++)
			for(int j = i+1; j < DSSV.size(); j++)
				if(DSSV.get(i).getScore()<DSSV.get(j).getScore())
					 Collections.swap( DSSV, i, j);
	}
	for(SV student:DSSV)
		student.output();
}*/
public  void writeTextFile(String path)
{
	String regex = ".*,.*";
	BufferedWriter bw;
	
	try
	{
	 bw = new BufferedWriter(new FileWriter(path));
	 for(SV student : DSSV)
		{	
		 String fixedAdress = student.getAddress();
		 String fixedNote = student.getNote();
		 String fixedLinkedPicture = student.getPicture();
		 if(fixedAdress.matches(regex)) {
			 fixedAdress = "\""+ student.getAddress()+"\"";
		 }
		 if(fixedNote.matches(regex)) {
			 fixedNote = "\""+ student.getNote()+"\"";
		 }
		 if(fixedLinkedPicture.matches(regex)) {
			 fixedLinkedPicture = "\""+ student.getPicture()+"\"";
		 }
			String str = student.getMssv()+','+student.getName()+','+Float. toString(student.getScore())+','+fixedAdress
			+','+fixedNote+','+fixedLinkedPicture+'\n';
			bw.write(str);
			//System.out.println(str);
			//System.out.println("done");
		}
	 bw.close();
	 
	}
	catch(IOException e)
	{
		System.out.println("Lỗi mở file 1");
		return;
	}
	
	

}
public  void readTextFile(String path)
{
	//FileReader fr = new FileReader("C:\\Users\\DELL\\Desktop\\comment reading.txt");
	BufferedReader br;
	try 
	{
	 br = new BufferedReader(new FileReader(path));
	  String line;
	    while ((line = br.readLine()) != null) {
	    	SV student = advancedConvert(line);
	    	DSSV.add(student);
	    	student.output();
	    }
	    br.close();
	}
	catch( FileNotFoundException ex )
	{
		System.out.println("File Not Found");
		return;
	}
	catch(IOException e)
	{

		System.out.println("error read file");
		return;
	}
	
	
	
	
}
private  void deleteStudent(String deleteOne)
{
	boolean flag = false;
	for(SV student: DSSV)
	{
	
	if(student.getMssv().compareTo(deleteOne)==0)
	{
		DSSV.remove(student);
		flag = true;
		break;
	}
	}
	if(flag)
		System.out.println("Đã xóa");
	else
		System.out.println("không có học sinh có mã trùng với bạn yêu cầu");
}

public  void writeStreamFile(String path)
{
DataOutputStream dos;
ObjectOutputStream os;
try 
{
	dos=new DataOutputStream(
			new FileOutputStream(path));
	 os= new ObjectOutputStream(dos);
}
catch(IOException exc) 
{
	System.out.println("Error open file !");
	return;
}

try 
{
	os.writeInt(DSSV.size());
//os.writeObject(DSSV.size());
	for( SV student: DSSV)
os.writeObject(student);
os.close();
dos.close();
}
catch(IOException exc) 
{
	System.out.println("Error write file.");
}

}

public  void readStreamFile( String path)
{
DataInputStream dis;
ObjectInputStream is;
SV student = new SV();
try 
{
	dis=new DataInputStream(
			new FileInputStream(path));
	 is= new ObjectInputStream(dis);
}
catch(IOException exc) 
{
	System.out.println("Error open file !");
	return;
}

try 
{
	int number = is.readInt();
	for(int i = 0; i < number; i++)
	{student = (SV)is.readObject();
	student.output();
	DSSV.add(student);
	}

is.close();
}
catch(IOException  | ClassNotFoundException ed  ) 
{
	System.out.println("Error read file.");
}

}
public  SV checkId(String str)
{
for(SV sv: DSSV)
{
	if(sv.getMssv().compareTo(str)==0)
		return sv;
}
return null;
}



public  void printMenu(Scanner input)
{
	while(true)
	{
	System.out.println("Xin hãy chọn chức năng");	
	System.out.println("1: Xem danh sách học sinh");	
	System.out.println("2: Thêm học sinh");
	System.out.println("3: Cập nhật thông tin học sinh");	
	System.out.println("4: Xóa học sinh");
	System.out.println("5: Nhập dữ liệu từ file csv");
	System.out.println("6: Xuất dữ liệu ra file csv");
	System.out.println("7: Nhập dữ liệu từ file nhị phân");
	System.out.println("8: Xuất dữ liệu ra file phân");	
	
	System.out.println("9: Thoát");	
	if(input.hasNextInt())
	{
		
	
	String path;
	//DSSV.addSV(h);
	//DSSV2.add(h);
		int num = input.nextInt();
		Integer choice = new Integer(num);
		input.nextLine();
	
		SV student = new SV();
		switch (choice)
		{
		case 1:
			System.out.println("Bạn muốn xem danh sách theo: ");
			System.out.println("1: MSV tăng dần");
			System.out.println("2: MSV giảm dần");
			System.out.println("3: điểm tăng dần");
			System.out.println("4: điểm giảm dần");
			System.out.println("5: Trở lại");
			int temp = input.nextInt();
			input.nextLine();
			switch(temp)
			{
			/*case 1:
				AcsId();
				break;
			case 2:
				DcsId();
				break;
			case 3:
				AcsScore();
				break;
			case 4:
				DcsScore();
				break;*/
			case 5:
				break;
	
			}
			//DS2.add(new SV());
			//fake.writeStreamFile();
			//fake.output();
			//writeStreamFile();
		break;
		case 2:

			student.input(input);
			while(checkId(student.getMssv())!=null)
			{
				System.out.println("MSV của bạn đã bị trùng, mời bạn nhập lại");
				student.input(input);
			}
			
			DSSV.add(student);
			System.out.println("Đã thêm xong");
			//fake.output(input);
			break;
		case 3:
			System.out.println("Mời bạn nhập MSV mà bạn muốn cập nhật");
			String updateOne = input.nextLine();
			SV tempflag = checkId(updateOne);
			if(tempflag!=null)
			{
				DSSV.remove(tempflag);
			System.out.println("Mời bạn cập nhật lại thông tin: ");
			student.input(input);
			while(checkId(student.getMssv())!=null && student.getMssv()!=tempflag.getMssv())
			{
				System.out.println("MSV của bạn đã bị trùng, mời bạn nhập lại");
				student.input(input);
			}
			
			DSSV.add(student);
			}
			else
				System.out.println("Không có học sinh có mã trùng với yêu cầu");
			
			break;
		case 4:
			System.out.println("Mời bạn nhập MSV mà bạn muốn xóa");
			String deleteOne = input.nextLine();
			deleteStudent(deleteOne);
			
			
			
			break;
		case 5:
			DSSV.removeAll(DSSV);
		System.out.println("Mời bạn nhập đường dẫn");
		 path = input.nextLine();
			readTextFile(path);
			break;
		case 6:
			
			System.out.println("Mời bạn nhập đường dẫn");
			 path = input.nextLine();
			writeTextFile(path);
			break;
		case 7:
			DSSV.removeAll(DSSV);
			System.out.println("Mời bạn nhập đường dẫn");
			 path = input.nextLine();
			readStreamFile(path);
			
			break;
		case 8:
			System.out.println("Mời bạn nhập đường dẫn");
			 path = input.nextLine();
			//for(SV i : DSSV2)
				writeStreamFile(path);
			break;
		case 9:
			break;
	
		}
		
		if(choice == 9)
			break;	
	}
	
	
	}
	
}
public static void main(String args[])throws IOException
{
	
	//DSSV.add(real);
	
	
	Scanner inputData = new Scanner(System.in);
	Classroom manage = new Classroom();
	manage.printMenu(inputData);
	

	
	
		//String str = raf.readUTF();
		//System.out.println(str);

	
}
/**
 * @return the GradeList
 */
public Set<Grade> getGradeList() {
	return GradeList;
}
/**
 * @param GradeList the GradeList to set
 */
public void setGradeList(Set<Grade> GradeList) {
	this.GradeList = GradeList;
}
}

