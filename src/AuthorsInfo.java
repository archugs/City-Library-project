import java.sql.*;

public class AuthorsInfo {

	public static void main(String[] args)
	{
		try
		{
			String str = "SELECT * FROM Authors ";
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:ArchanaDB", "System", "Anna1Nagar1");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			System.out.println("Author ID\t Author Name\t City");
			while(rs.next())
			{
				String id = rs.getString("au_id");
				String name = rs.getString("au_name");
				String city = rs.getString("au_city");
				System.out.print(id+"\t\t");
				System.out.print(name+"\t\t");
				System.out.println(city);
			}
			con.close();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
