package testDB;
import java.util.*;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.*;
import org.hibernate.query.NativeQuery;


public class SVcheck {
	

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
public static Classroom getClassInfo(String ClassId)
{
	Classroom Class = null;
	Session session = HibernateUtil.getSessionFactory()
			.openSession();
	
			try {
			String hql= " select cl ";
			hql +="from Classroom cl left join fetch cl.DSSV";
			hql += " where cl.Name=:name";
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
if (getSVInfo(sv.getMssv())!=null) {
return false; }
Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.saveOrUpdate(sv);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();
System.out.println("done");
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
System.out.println("done");
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
System.out.println("done");
System.err.println(ex);
} finally {
session.close();
}
return true; }
public static boolean addClassroom(Classroom classes) {
Session session = HibernateUtil.getSessionFactory().openSession();
if (getClassInfo(classes.getName())!=null) {
return false; }
Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.saveOrUpdate(classes);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();
System.out.println("done");
System.err.println(ex);
} finally {
session.close();
}
System.out.println("done");
return true; }



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
System.out.println("roll back done");
System.err.println(ex);
} finally {
session.close();
}
System.out.println("done");
return true; }
public static boolean addSchedule(Schedule sc) {
Session session = HibernateUtil.getSessionFactory().openSession();

Transaction transaction = null;
try {
transaction = session.beginTransaction();
session.saveOrUpdate(sc);
transaction.commit();
} catch (HibernateException ex) {
//Log the exception
transaction.rollback();
System.out.println("roll back done");
System.err.println(ex);
} finally {
session.close();
}
System.out.println("done");
return true; }
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
System.out.println("rollback done");
System.err.println(ex);
} finally {
session.close();
}
System.out.println("done");
return true; }



public static void main(String args[])
{
	//System.out.println(2);
SVcheck temp = new SVcheck();
//temp.layDanhSachSV();
/*SV newSv = new SV("152","Hijikata",-8,"shinsegumi","Mayonise addict", "",null);
SV newSv1 = new SV("153","Gintoki",-8,"yorozura","Mayonise addict", "",null);
SV newSv2 = new SV("154","kagura",-8,"yorozura","Mayonise addict", "",null);
SV newSv3 = new SV("155","shinpachi",-8,"yorozura","Mayonise addict", "",null);
SV newSv4 = new SV("156","otae",-8,"cabaret","Mayonise addict", "",null);
Set<SV> listsv = new HashSet<SV>();
//listsv.add(newSv);
listsv.add(newSv1);
listsv.add(newSv2);
listsv.add(newSv3);
listsv.add(newSv4);
Classroom cl4 = new Classroom("17_33",listsv);
Classroom cl = new Classroom("17_32",null);
Classroom cl2 = new Classroom("17_31",null);
Classroom cl3 = new Classroom("17CTT6",null);
Set<Classroom>list = new HashSet<Classroom>();
list.add(cl);
list.add(cl2);
list.add(cl3);
newSv.setClasses(list);
//temp.addSV(newSv);
temp.addClassroom(cl4);
//temp.addClassroom(cl4);
//temp.deleteSV("152");
//temp.addClassroom(cl);
//SV sv = SVcheck.getSVInfo("145");
//sv.output();*/
//temp.getSubjectInfo("CT001").subjectOutput();
/*List<Schedule >ls = temp.getScheduleInfo();

ls2.addAll(ls);
*/
Set<Schedule>ls2 = new HashSet<Schedule>();
Classroom cl3 = new Classroom("17_38",null,null);
Subject sj = new Subject("JAC","Japanese anime Capital",null);

//temp.addSubject(sj);
System.out.println("dooooooooooooooooooooooooooo");

Schedule s = new Schedule("306");
s.setSubjectId(sj);
s.setClassroom(cl3);
ls2.add(s);
temp.addShedule(s);
//sj.addSchedule(s);
	
	//temp.addSubject(sj);
	
//temp.addSubject(sj);



//temp.addSubject(sj);
}
}