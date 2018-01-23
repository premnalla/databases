/**
 * 
 */
package ex.postgres;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author prem
 *
 */
public class DbCommon {

	/**
	 * 
	 */
	public DbCommon() {
	}

	public Properties loadProps(String fname) throws Exception {
		InputStream input = new FileInputStream(fname);
		Properties props = new Properties();
		props.load(input);
		return (props);
	}
	
	public Connection openConnection(Properties props) throws Exception {
		Connection ret = null;
		
		ret = DriverManager.getConnection(props.getProperty("jdbc.url"), props);
		
		return (ret);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		DbCommon db = new DbCommon();
		Properties props = db.loadProps("/Users/prem/Downloads/aiven-postgres/postgres.properties");
		Connection c = db.openConnection(props);
		System.out.println("Got connection");
		c.close();
		
	}

}
