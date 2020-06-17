package testDB;
import java.util.*;


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
			} finally {
			session.close();
			}
	return sv;
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
//if (getSVInfo(sv.getMssv())!=null) {
//return false; }
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
public static void main(String args[])
{
	//System.out.println(2);
SVcheck temp = new SVcheck();
//temp.layDanhSachSV();
SV newSv = new SV("145","Hinagiku",100,"tokyo","", "",null);
//temp.addSV(newSv);
SV sv = SVcheck.getSVInfo("145");
sv.output();
}
}