package fr.inetum.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBdd {
	Connection con;

	public ConnexionBdd(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/bibliotheque","root","");
			//String database ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=gestionStock.mdb;";
			//Connection con = DriverManager.getConnection(database, "", "");
			System.out.println("connected!!");
	}
		catch(Exception e){
			System.out.println("connected not yet!!");
			
		}

}
	public Connection connecion(){
		return con;
	}
}
