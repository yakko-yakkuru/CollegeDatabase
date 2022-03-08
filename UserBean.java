package design;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class UserBean extends DBhandler{
	
	/*
	Connection con =null;
	Statement smt = null;
	ResultSet rs;
	*/
	public UserBean(){}
	
	public boolean checkUser(String Id, String Pass){
		getUserInfo(Id);
		
		try {
			rs.next();
			
			if(Pass.equals(rs.getString("Password")))
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
			//e.printStackTrace();
		}
	}
	
	private void getUserInfo(String Id){
		String sql = "SELECT * FROM User WHERE Id = '" + Id + "'";
		try{
			rs = smt.executeQuery(sql);
		}
		catch(Exception e){
			
		}
	}
	
	public boolean addUser(String Id, String Pass){
		String sql1 = "INSERT INTO User(Id,Password) VALUES('" + Id + "','" + Pass + "')";
		String sql2 = "INSERT INTO Favorite(Id) VALUES('" + Id + "')";
		try{
			smt.executeUpdate(sql1);
			smt.executeUpdate(sql2);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean deleteuser(String Id){
		String sql1 = "DELETE FROM User WHERE Id = '" + Id + "'";
		String sql2 = "DELETE FROM Favorite WHERE Id = '" + Id + "'";
		try{
			smt.executeUpdate(sql1);
			smt.executeUpdate(sql2);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public void addFavorite(String Id, String college){
		String sql = "UPDATE Favorite SET Name = '" + college + "' where Id = '" + Id + "'";
		try{
			smt.executeUpdate(sql);
		}catch(Exception e){
			e.getMessage();
		}
	}
}