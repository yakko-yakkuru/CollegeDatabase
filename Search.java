package design;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

public class Search extends DBhandler{
	protected String key; 
	protected static int wLength = 15; 
	protected String result = "";
	/*
	Connection con =null;
	Statement smt = null;
	ResultSet rs;
	*/
	public Search(){ }
	
	public void setWord(String word){
		//検索ワードをセットする
		key = word;
	}
	
	public String getWord(){
		//入力したワードを取得する
		return key;
	}
	
	public void toNext(){
		//ResultSetの指定行を進める
		try {
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object getRecord(String column){
		//指定したカラムのデータを取得する
		try{			
			return rs.getObject(column);

		}catch(Exception e){
			return "";
		}
	}
	
	public void searchRecord(int mode, String table){
		//テーブルからデータを取得する
		
		String sql="", skey = "%";;
		switch(mode){
		case 0 :
			String[] spkey = new String[wLength]; 
			spkey = key.split("");
			for(int i=1; i<=key.length(); i++){
				skey = skey + spkey[i]+ "%" ;
			}
			sql = "SELECT Name FROM " + table + " WHERE Name LIKE '" + skey+"'";
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
	
	public void AccessCount(String target){
		//Collegeテーブルのアクセス数を進める
		String sql = "update College set Access = Access + 1 where Name = '" + target + "'";
		try {
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
