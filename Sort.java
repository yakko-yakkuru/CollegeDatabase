package design;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class Sort extends Search{
	@Override
	public void searchRecord(int mode, String table) {
		String sql="", skey = "%";
		switch(mode){
		case 0 :
			String[] spkey = new String[wLength]; 
			spkey = key.split("");
			for(int i=1; i<=key.length(); i++){
				skey = skey + spkey[i]+ "%" ;
			}
			sql = "SELECT Name FROM " + table + " WHERE Name LIKE '" + skey+"' ORDER BY ASC";
			break;
		case 1 : 
			sql = "SELECT * FROM " + table + " WHERE Name = '" + key + "'"; 
			break;
		}
		
		try{
			rs = smt.executeQuery(sql);
		}
		catch(Exception e){
			throw new IllegalStateException(e);
		}
	}
	}
}
