package design;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBhandler {
	protected Connection con =null;
	protected Statement smt = null;
	protected ResultSet rs;
	
	public DBhandler(){}
	
	public void Connect(){
		//データベースとの接続を行う
		//CloseConnectとセットで使用する
		try{
			con = DBManager.getUserConnection();
			//SQL発行のためのステートメントを取得
			smt = con.createStatement();
		}
		catch(Exception e){
			throw new IllegalStateException(e);
		}
	}

	public void CloseConnect(){
		//ステートメントと接続を破棄する
		if(smt != null){
			try{smt.close();}catch(SQLException ignore){}
		}
		if(con != null){
			try{con.close();}catch(SQLException ignore){}
		}
	}
}