import java.sql.*;

public class test
{
	public static void main(String args[])
	{
		Connection con = null;
		
		try
		{
		
			/*
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:ProductDS");
			*/
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mysql","mori7890","shuxruri");
			
			Statement st = con.createStatement();
			
			String strsql = "select name from product";
		//	String strsql = "insert into product(productid, productname, productdescription) values (3,'RAM','1066MHz')";
			
			ResultSet rs = st.executeQuery(strsql);
			//System.out.println(rs);
			//int iAffectedRecord = st.executeUpdate(strsql);
			
			
			while (rs.next())
			{
				//int iID = rs.getInt("ProductID");
				String strName = rs.getString(1);
			//	String strDesc = rs.getString(3);
				
				System.out.println( " - Name: " + strName + " - Desc: " );
				
			}
			
			con.close();
		}
		catch (Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
	}
}