package testDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;


public  class  Model {
	

public static List<SV> layDanhSachSV() {
List<SV> ds = new ArrayList<SV>();
Session session = HibernateUtil.getSessionFactory()
.openSession();
try {
String hql = "Select Name from SV ";
TypedQuery<String> query = session.createQuery(hql);
//NativeQuery qry = OBDal.getInstance().getSession().createNativeQuery("select stragg(1) from dual");
List<String>ds2 = new ArrayList<String>();
ds2 = query.getResultList();
for( SV temp : ds)
	temp.output();
for(String t: ds2)
	System.out.println(t);
} catch (HibernateException ex) {
//Log the exception
System.err.println(ex);
} finally {
session.close();
}
return ds;
}
public static List<pk> getPKList() {
List<pk> ds = new ArrayList<pk>();
Session session = HibernateUtil.getSessionFactory()
.openSession();
try {
String hql = " from pk ";
TypedQuery<pk> query = session.createQuery(hql);
//NativeQuery qry = OBDal.getInstance().getSession().createNativeQuery("select stragg(1) from dual");

ds = query.getResultList();

} catch (HibernateException ex) {
//Log the exception
System.err.println(ex);
} finally {
session.close();
}
return ds;
}
public static SV getSVInfo(String mssv)
{
	SV sv = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
			try {
			String hql= " select sv ";
			hql +="from SV sv left join fetch sv.classes";
			hql += " where sv.Mssv=:mssv";
			TypedQuery<SV> query = session.createQuery(hql);
			query.setParameter("mssv", mssv);
			sv = query.getSingleResult();
			} catch (HibernateException ex) {
			System.err.println(ex);
			return null;
			}catch(NoResultException nores)
			{
				
			}finally {
				
			session.close();
			
			}
	return sv;
}
public static Grade getGradeInfo(svClassroomId clId)
{
	Grade gp = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
			try {
		gp = session.get(Grade.class, new svClassroomId(clId));
			} catch (HibernateException ex) {
			System.err.println(ex);
			return null;
			}catch(NoResultException nores)
			{
				
			}finally {
				
			session.close();
			
			}
	return gp;
}
public static Classroom getClassInfo(String ClassId)
{
	Classroom Class = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
			try {
			String hql= " select cl ";
			hql +="from Classroom cl left join fetch cl.DSSV";
			hql += " where cl.classId=:name";
			TypedQuery<Classroom> query = session.createQuery(hql);
			query.setParameter("name", ClassId);
			Class = query.getSingleResult();
			} catch (HibernateException ex) {
			System.err.println(ex);
			}catch(NoResultException nores)
			{
				
			}
			finally {
			session.close();
			}
	return Class;
}
public static SV layThongTinSV(String mssv) {
SV sv = null;
Session session = HibernateUtil.getSessionFactory()
.openSession();
try {
sv = (SV) session.get(SV.class, 
mssv);
} catch (HibernateException ex) {
//Log the exception
System.err.println(ex);
} finally {
session.close();
}
return sv;
}
public static boolean addSV(SV sv) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.saveOrUpdate(sv);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}
return true; }
public static boolean updateGrade(Grade gp) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.saveOrUpdate(gp);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}
return true; }
public static boolean test(SV sv) {
Session session = HibernateUtil.getSessionFactory().openSession();
if (getSVInfo(sv.getMssv())!=null) {
return false; }
Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.update(sv);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}
return true; }
public static boolean deleteSV(String mssv) {
Session session = HibernateUtil.getSessionFactory().openSession();
SV temp = getSVInfo(mssv);
if (temp==null) {
return false; }
Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.remove(temp);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}
return true; }
public static boolean addClassroom(Classroom classes) {
Session session = null;
session = HibernateUtil.getSessionFactory().openSession();

//if (getClassInfo(classes.getName())!=null) {
//return false; }
Transaction transaction = null;



try {

transaction = session.beginTransaction();
 
session.saveOrUpdate(classes);

transaction.commit();
} catch (HibernateException ex) {
//Log the exception
	ex.printStackTrace();
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}

return true; }
public static boolean updateClassroomGrade(Classroom classes) {
Session session = null;
session = HibernateUtil.getSessionFactory().openSession();

//if (getClassInfo(classes.getName())!=null) {
//return false; }
Transaction transaction = null;



try {

transaction = session.beginTransaction();
 
session.saveOrUpdate(classes);

transaction.commit();
} catch (HibernateException ex) {
//Log the exception
	ex.printStackTrace();
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}

return true; }
public static void c4(String path)
{
	Classroom cl = null;
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	//if (getClassInfo(classes.getName())!=null) {
	//return false; }
	
	try {
	
	cl = readImportC3(path);
	if(cl !=null)
	{
		addClassroom(cl);
	
	String tempClassName = cl.getClassId();
	
	String hql= " select sc.idKey.subjectId ";
	hql +="from Schedule sc";
	hql += " where sc.idKey.classId=:classId";
	TypedQuery<Subject> query = session.createQuery(hql);
	query.setParameter("classId", cl);
	
	
	List<Subject>IdList = query.getResultList();
	List<String> subjectIdList= new ArrayList<String>();
	for(Subject sj :IdList)
		subjectIdList.add(sj.getsubjectId());
	//subjectIdList.add("CT0011");
	//subjectIdList.add("CT0012");
	
	for(int i = 0; i < subjectIdList.size(); i++)
		{
		
		
		Set<SV>svList = new HashSet<SV>();
		svList = getSVList(tempClassName);
		for(SV sv:svList)
		{
		sv.output();
		System.out.println("-----------------");
		
		}
		Classroom temp = new Classroom(tempClassName+"-"+subjectIdList.get(i),svList);
		addClassroom(temp);
		
	
		}
	}
	else
		System.out.println("Fightttttttttttt");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		session.close();
		}
	
}

public static Set<SV>getSVList(String ClassId)
{
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	Set<SV>svList = null;
			try {
			
			
			Classroom cl = session.get(Classroom.class,ClassId);
			svList = cl.getDSSV();
			} catch (HibernateException ex) {
			System.err.println(ex);
			}catch(NoResultException nores)
			{
				
			}
			finally {
			session.close();
			}
return svList;	
}
public static List<Schedule> getScheduleInfo() {
	List<Schedule> Sc = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
			try {

				
				String hql=" from Schedule ";
				
				TypedQuery<Schedule> query = session.createQuery(hql);
			Sc = query.getResultList();
			} catch (HibernateException ex) {
			System.err.println(ex);
			}catch(NoResultException nores)
			{
				
			}
			finally {
			session.close();
			}
	return Sc;
}
public static Subject getSubjectInfo(String subjectId) {
	Subject Sj = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
			try {
/*
				String hql=" select sj ";
				hql+= " from Subject sj left join fetch sj.schedule";
				hql+= " where dm.subjectId=:subject";
				TypedQuery<Subject> query = session.createQuery(hql);
				query.setParameter("subject", subjectId);
				Sj = query.getSingleResult();*/
				Sj = (Subject)session.get(Subject.class, subjectId);
			} catch (HibernateException ex) {
			System.err.println(ex);
			}catch(NoResultException nores)
			{
				
			}
			finally {
			session.close();
			}
	return Sj;
}
public static List<Schedule> getScheduleInfoFromClass(String classId) {
	List<Schedule> Sc = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
			Classroom cl = session.get(Classroom.class,classId);
			try {
				/*String hql=" select sj ";
				hql+= " from Subject sj left join fetch sj.schedule";
				hql+= " where dm.subjectId=:subject";*/
				
				String hql="select distinct sc  ";
				hql+= "From Schedule sc ";
				hql+= "Where sc.idKey.classId =: classId";
				
				TypedQuery<Schedule> query = session.createQuery(hql);
				query.setParameter("classId", cl);
			Sc = query.getResultList();
			} catch (HibernateException ex) {
			System.err.println(ex);
			}catch(NoResultException nores)
			{
				
			}
			finally {
			session.close();
			}
	return Sc;
}
public static Set<Grade> getGradeInfoFromClass(String classId) {
	Classroom cl = getClassInfo(classId);	
	Set<Grade> list = cl.getGradeList();
	return list;
}
public static boolean addSubject(Subject sj) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.saveOrUpdate(sj);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

ex.printStackTrace();
} finally {
session.close();
}

return true; }
public static boolean addSchedule(Schedule sc) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
	subjectClassId temp = new subjectClassId(sc.getIdKey());
	if(temp==null)
		System.out.println("This is null");
	else
		{
			System.out.println("This is not null");
			System.out.println(temp.getClassId().getClassId());
			System.out.println(temp.getSubjectId().getsubjectId());
			}
transaction = session.beginTransaction();
session.saveOrUpdate(sc);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}
return true; }
public static boolean addGrade(Grade gp) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
	svClassroomId temp = new svClassroomId(gp.getidKey());
	if(temp==null)
		System.out.println("This is null");
	else
		{
			System.out.println("This is not null");
			
			}
transaction = session.beginTransaction();
session.saveOrUpdate(gp);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}

return true; }
public static List<Schedule> AcsSchedule(String classId)
{
	List<Schedule>scList = getScheduleInfoFromClass(classId);
	
	if(scList.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return null;
	}
	else
	{
		
		for(int i = 0; i < scList.size(); i++)
			for(int j = i+1; j < scList.size(); j++)
				if(scList.get(i).getStt()>scList.get(j).getStt())
					 Collections.swap( scList, i, j);
	}
	return scList;
}	
public static List<pk> AcsPK()
{
	List<pk>scList = getPKList();
	
	
		
		for(int i = 0; i < scList.size(); i++)
			for(int j = i+1; j < scList.size(); j++)
				if(scList.get(i).getId()>scList.get(j).getId())
					 Collections.swap( scList, i, j);
	
	return scList;
}	
public static List<Schedule> DcsSchedule(String classId)
{
	List<Schedule>scList = getScheduleInfoFromClass(classId);
	
	if(scList.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return null;
	}
	else
	{
		
		for(int i = 0; i < scList.size(); i++)
			for(int j = i+1; j < scList.size(); j++)
				if(scList.get(i).getStt()<scList.get(j).getStt())
					 Collections.swap( scList, i, j);
	}
	return scList;
}	
public static List<Grade> AcsGrade(String classId)
{
	Set<Grade>temp = getGradeInfoFromClass(classId);
	List<Grade>gpList = new ArrayList<Grade>(temp);
	if(gpList.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return null;
	}
	else
	{
		
		for(int i = 0; i < gpList.size(); i++)
			for(int j = i+1; j < gpList.size(); j++)
				if(gpList.get(i).getId()>gpList.get(j).getId())
					 Collections.swap( gpList, i, j);
	}
	return gpList;
}	
public List<Grade> DscGrade(String classId)
{
	Set<Grade>temp = getGradeInfoFromClass(classId);
	List<Grade>gpList = new ArrayList<Grade>(temp);
	if(gpList.size()==0)
	{
		System.out.println("Chưa có danh sách, hãy thêm học sinh hoặc import từ nguồn khác");
		return null;
	}
	else
	{
		
		for(int i = 0; i < gpList.size(); i++)
			for(int j = i+1; j < gpList.size(); j++)
				if(gpList.get(i).getId()<gpList.get(j).getId())
					 Collections.swap( gpList, i, j);
	}
	return gpList;
}	
public static boolean addShedule(Schedule sc) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
	
transaction = session.beginTransaction();
session.saveOrUpdate(sc);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}

return true; }


public static void choiceMake(String choice,String path)
{
	Classroom cl;
	System.out.println("Merry");
	if(choice.compareTo("Danh sách lớp")==0)
	{
	File tempFile = new File(path);
	System.out.println("Is exist? "+tempFile.exists());
	System.out.println(path);
		cl = readImportC1(path);
		System.out.println("good"+path);
		//addClassroom(cl);
	}
else if(choice.compareTo("Thời khóa biểu")==0)
	c4(path);
else
{
	
	c7(path);
}	
}


public static Classroom readImportC1(String path)
{
		
		//FileReader fr = new FileReader("C:\\Users\\DELL\\Desktop\\comment reading.txt");
		BufferedReader br;
		Classroom cl = null;
		try 
		{
		 br = new BufferedReader(new FileReader(path));
		  String line = "";
		  line = br.readLine();
		  int pos = line.indexOf(',');
		 
		  if(pos != -1)
			  line = line.substring(0,pos);
		  cl = getClassInfo(line);
		  if(cl ==null)
				 {
			  	cl = new Classroom();
		  		cl.setClassId(line);
				 }
		  // trừ dòng tiêu đề.
		  line = br.readLine();
		  List<String> result =new ArrayList<String>();
		  boolean flag = false;
		    while ((line = br.readLine()) != null) {
		    	flag = false;
		    	String []list = line.split(",");
		    	for(int i = 0; i < list.length;i++)
		    		result.add(list[i]);
		    	//SV student;
		    	SV student = getSVInfo(list[1]);
		    	if(student==null)
		    		student = new SV(Integer.valueOf(list[0]),list[1],list[2],list[3],list[4]);
		    	else
		    	{
		    		student.setId(Integer.valueOf(list[0]));
		    		student.setName(list[2]);
		    		student.setGender(list[3]);
		    		student.setCMND(list[4]);
		    	}
		    	//addSV(student);
		    	for(Classroom cl2: student.classes)
		    		if(cl.getClassId().compareTo(cl2.getClassId())==0)
		    			flag = true;
		    	if(flag == false)
		    	{//cl.addSV(student);
		    		
		    	student.addClassroom(cl);
		    	}
		    	addSV(student);
		    	student.output();
		    }
		    br.close();
		}
		catch( FileNotFoundException ex )
		{
			System.out.println("File Not Found");
			return null;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("error read file");
			return null;
		}
		
		
		
	return cl;	
		
	
}
public static Classroom readImportC3(String path)
{
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
		//FileReader fr = new FileReader("C:\\Users\\DELL\\Desktop\\comment reading.txt");
		BufferedReader br;
		boolean flag = false;
		Classroom cl = null;
		try 
		{
		 br = new BufferedReader(new FileReader(path));
		  String line = "";
		  line = br.readLine();
		  int pos = line.indexOf(',');
		  
		  if(pos != -1)
			  line = line.substring(0,pos);
		  	
		  	 cl = session.get(Classroom.class,line);
		  	 if(cl ==null)
		  	 {
		  		 cl = new Classroom();
		  		 cl.setClassId(line);
		  	 }
		  // trừ dòng tiêu đề.
		  line = br.readLine();
			
		  List<String> result =new ArrayList<String>();
		    while ((line = br.readLine()) != null) {
		    
		    	String []list = line.split(",");
		    	
		    	for(int i = 0; i < list.length;i++)
		    		result.add(list[i]);
		    	Subject sj = session.get(Subject.class, list[1]);
		    	
		    	Schedule sc2 = session.get(Schedule.class, new subjectClassId(sj,cl));
		    	if(sc2== null)
		    	{
		    		flag = true;
		    		if(sj==null)
		    		{
		    		sj = new Subject(list[1],list[2],null);
		    		addSubject(sj);
		    		
		    		}
		    	
		    /*	Schedule sc = session.get(Schedule.class,Integer.valueOf(list[0]));
		    	
		    	if(sc ==null)
		    	 sc = new Schedule(list[3],Integer.valueOf(list[0]));*/
		    	Schedule sc = new Schedule(Integer.valueOf(list[0]),list[3]);
		    	
		    sc.setIdKey(new subjectClassId(sj,cl));
		    	
		    	
		    	cl.addSchedule(sc);
		    	
		    	}
		    	else
		    	{
		    		Schedule sc = session.get(Schedule.class, new subjectClassId(sj,cl));
			    	
				    sc.setRoom(list[3]);
				    sc.setStt(Integer.valueOf(list[0]));
				    	
				    	
				    	addSchedule(sc);
				    	
				    	
		    	}
		    	// addSchedule(sc);
		    	
		    	
		    	//SV student = new SV(Integer.valueOf(list[0]),list[1],list[2],list[3],list[4]);
		    	//cl.addSV(student);
		    	//student.output();
		    }
		    //addClassroom(cl);
		    br.close();
		    
		    
		}
		catch( FileNotFoundException ex )
		{
			
			return null;
		}
		catch(IOException e)
		{

			
			return null;
		}
		finally {
			
			session.close();
		}
		// addClassroom(cl);
	if(!flag)
	    return null;	
	return cl;	
		
	
}
////////////////////////////////////danger
public static String c7(String path) {
	BufferedReader br;
	Classroom cl = null;
	List<Grade>gpList = new ArrayList<Grade>();
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	try 
	{
	 br = new BufferedReader(new FileReader(path));
	  String line = "";
	  line = br.readLine();
	 
	  if(line.indexOf('-')==-1)
		 
		  {
		 
		  br.close();
		  return "Thất bại, không thể nhập điểm vào lớp cơ bản";
		  }
		  
	  int pos = line.indexOf(',');
	 
	  if(pos != -1)
		  line = line.substring(0,pos);
	  cl = session.get(Classroom.class, line);
	  if(cl==null)
	  {
		  cl = new Classroom();
		  cl.setClassId(line);
	  }
	  // trừ dòng tiêu đề.
	  line = br.readLine();
	  List<String> result =new ArrayList<String>();
	    while ((line = br.readLine()) != null) {
	    	
	    	String []list = line.split(",");
	    	for(int i = 0; i < list.length;i++)
	    		result.add(list[i]);
	    	SV sv = session.get(SV.class,list[1]);
	    	if(sv == null)
	    	{
	    		//System.out.println("Lỗi, không có Sinh viên với mssv"+list[1]+" trong danh sách lớp ");
	    		//return false;
	    		sv = new SV();
	    		sv.setMssv(list[1]);
	    		sv.setName(list[2]);
	    		return "Lỗi, không có Sinh viên với mss"+list[1]+" trong danh sách lớp ";
	    	}
	    	
	    	Grade grade = new Grade(Integer.valueOf(list[0]),sv,cl,Float.valueOf(list[3]),Float.valueOf(list[4]),Float.valueOf(list[5]),Float.valueOf(list[6]));
	    	
	    	grade.setidKey(new svClassroomId(sv,cl));
	    	gpList.add(grade);
	    	
	    	sv.output();
	    }
	    
		
	    session.close();
	 
	   for(Grade gp:gpList)
		   addGrade(gp);
	   br.close();
	}
	catch( FileNotFoundException ex )
	{
		System.out.println("File Not Found");
		return "File Not Found";
	}
	catch(IOException e)
	{

		System.out.println("error read file");
		return "error read file";
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	
	
	
return "Thành công";	
}
public static boolean c72(String path) {
	BufferedReader br;
	Classroom cl = null;
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	try 
	{
	 br = new BufferedReader(new FileReader(path));
	  String line = "";
	  line = br.readLine();
	  System.out.println(line);
	  if(line.indexOf('–')==-1)
		 
		  {
		
		  br.close();
		  return false;
		  }
		  
	  int pos = line.indexOf(',');
	 
	  if(pos != -1)
		  line = line.substring(0,pos);
	  cl = session.get(Classroom.class, line);
	  if(cl==null)
	  {
		  cl = new Classroom();
		  cl.setClassId(line);
	  }
	  // trừ dòng tiêu đề.
	  line = br.readLine();
	  List<String> result =new ArrayList<String>();
	    while ((line = br.readLine()) != null) {
	    	
	    	String []list = line.split(",");
	    	for(int i = 0; i < list.length;i++)
	    		result.add(list[i]);
	    	SV sv = session.get(SV.class,list[1]);
	    	if(sv == null)
	    	{
	    		//System.out.println("Lỗi, không có Sinh viên với mssv"+list[1]+" trong danh sách lớp ");
	    		//return false;
	    		sv = new SV();
	    		sv.setMssv(list[1]);
	    		sv.setName(list[2]);
	    	}
	    	
	    	Grade grade = new Grade(Integer.valueOf(list[0]),sv,cl,Float.valueOf(list[3]),Float.valueOf(list[4]),Float.valueOf(list[5]),Float.valueOf(list[6]));
	    	sv.addGrade(grade);
	    	cl.addSV(sv);
	    
	    	sv.output();
	    }
	   
	    session.close();
	   updateClassroomGrade(cl);
	   br.close();
	}
	catch( FileNotFoundException ex )
	{
		System.out.println("File Not Found");
		return false;
	}
	catch(IOException e)
	{

		System.out.println("error read file");
		return false;
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	
	
	
return false;	
}
public void watchClassPoint(String classId)
{
	if(classId.indexOf('–')==-1)
	{
		System.out.println("Lớp không tồn tại hoặc không có môn học");
		return;
	}
		
Classroom cl = getClassInfo(classId);	
Set<Grade> list = cl.getGradeList();
for(Grade ls: list)
	ls.output();
}
public static Account getAccountInfo(String username)
{
	Account acc = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
			try {
			String hql= " select acc ";
			hql +="from Account acc ";
			hql += " where acc.username=:user";
			TypedQuery<Account> query = session.createQuery(hql);
			query.setParameter("user", username);
			acc = query.getSingleResult();
			} catch (HibernateException ex) {
			System.err.println(ex);
			return null;
			}catch(NoResultException nores)
			{
				
			}finally {
				
			session.close();
			
			}
	return acc;
}
public static boolean addAccount(Account acc) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	if (getAccountInfo(acc.getUsername())!=null) {
		System.out.println("Tên đăng nhập đã được dùng");
	return false; 
	}
	Transaction transaction = null;
	try {
	transaction = session.beginTransaction();
	session.saveOrUpdate(acc);
	transaction.commit();
	} catch (HibernateException ex) {
	//Log the exception
	transaction.rollback();
	
	System.err.println(ex);
	} finally {
	session.close();
	}
	return true; 
}
public static boolean changeAccountPassword(Account acc) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction transaction = null;
	try {
	transaction = session.beginTransaction();
	session.saveOrUpdate(acc);
	transaction.commit();
	} catch (HibernateException ex) {
	//Log the exception
	transaction.rollback();
	
	System.err.println(ex);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		transaction.rollback();
	}
	finally {
	session.close();
	}
	
	return true; 
}
public static boolean checkAccount(String username, String password)
{
	if(username ==null || password == null)
		return false;
	Account temp = getAccountInfo(username);
	if(temp==null)
		{
		if(username.compareTo("giaovu")==0 && password.compareTo("giaovu")==0)
			return true;
		SV sv = getSVInfo(username);
		if(sv == null)
			return false;
		else if(username.compareTo(password)==0)
		{
			System.out.println(username);
			System.out.println(password);
			return true;
		}
		
		}
	else if(temp.getPassword().compareTo(password)==0)
		return true;
	return false;
		
}

public static boolean addPK(pk Pk) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.saveOrUpdate(Pk);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();

System.err.println(ex);
} finally {
session.close();
}

return true; }


public void c9()
{
	SV sv = getSVInfo("1842003");
	Classroom cl = getClassInfo("18HCB–CTT001");
	Grade gp = new Grade(1,sv,cl,5,4,7,8);
	updateGrade(gp);
	
}
public List<Schedule> farm(String cl)
{
	return null;
}

public static List<Grade> c10(String Cls)
{
	Grade Class = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
	Classroom cl = getClassInfo(Cls);
	
	List<Grade> gpList = null;
			try {
			String hql= "";
			hql +="from Grade grade ";
			hql += " where grade.idKey.classId=:name";
			TypedQuery<Grade> query = session.createQuery(hql);
			query.setParameter("name", cl);
			gpList = query.getResultList();
			} catch (HibernateException ex) {
			System.err.println(ex);
			}catch(NoResultException nores)
			{
				
			}
			finally {
			session.close();
			}
	return gpList;
}

public static Set<Grade> c10_2(String mssv)
{
	Set<Grade> gpList = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	SV sv = getSVInfo(mssv);
	
	
			try {
			gpList = sv.getGrades();
			} catch (HibernateException ex) {
			System.err.println(ex);
			}catch(NoResultException nores)
			{
				
			}
			finally {
			session.close();
			}
	return gpList;
}
public static void main(String args[])
{
	//System.out.println(2);
	
	
Model temp = new Model();
temp.readImportC1("C:\\Users\\Admin\\Desktop\\input1.csv");
		
//Classroom cl = temp.readImportC1("input1.csv");
//cl.output();
//temp.addClassroom(cl);
//cl = temp.readImportC1("input2.csv");
//cl.output();

/*List<Grade> gpList = Model.c10("17CTT6–CTT001");
for(Grade gp : gpList)
	gp.output();
System.out.println(gpList.size());*/
//temp.readImportC3("input3.csv");
//temp.c4("input3.csv");
//temp.c4("input5.csv");

//temp.c9();
//Grade t = temp.c10("1742005", "18HCB–CTT001");
//t.output();
	
	
//pk solo = new pk("1712805","Ngoo","Phần mềm","Giữa kỳ",8,"");
//temp.addPK(solo);

}
}