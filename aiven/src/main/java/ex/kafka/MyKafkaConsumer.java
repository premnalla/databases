/**
 * 
 */
package ex.kafka;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import ex.postgres.DbCommon;

/**
 * @author prem
 *
 */
public class MyKafkaConsumer extends MyKafkaCommon {

	private KafkaConsumer<String, String> m_consumer;
	private Properties m_props = new Properties();
	private DbCommon m_dbComm;
	private Connection m_dbConn;
	
	private static int m_dbKey = 1;
	

	/**
	 * 
	 */
	public MyKafkaConsumer() {
	}

	private void setup(String propsFile) throws Exception {
		InputStream config = openPropertiesFile(propsFile);
		m_props.load(config);
		
		// test load props
		System.out.println("ecurity.protocol=" + m_props.getProperty("security.protocol"));
		
		// MyCredentials.MyKafkaConsumerProps(m_props);
	}
	
	private void open() throws Exception {
		m_consumer = new KafkaConsumer<String, String>(m_props);
        m_consumer.subscribe(Arrays.asList("ex"));
        
        m_dbComm = new DbCommon();
        m_dbConn = m_dbComm.openConnection(
        		m_dbComm.loadProps("/Users/prem/Downloads/aiven-postgres/postgres.properties"));
	}
	
	private void close() throws Exception {
		m_consumer.close();
	}
	
	/*
	private void insertRecord(ConsumerRecord<String, String> record) throws Exception {
		String sql = "INSERT INTO system_log(id,log_line) values(?,?)";
		PreparedStatement preparedStatement = m_dbConn.prepareStatement(sql);
		preparedStatement.setInt(1, m_dbKey++);
		preparedStatement.setString(2, record.value());
		preparedStatement .executeUpdate();
	}
	*/
	
	private void read() throws Exception {
		String sql = "INSERT INTO system_log(id,log_line) values(?,?)";
		PreparedStatement preparedStatement = m_dbConn.prepareStatement(sql);

        while (true) {
            ConsumerRecords<String, String> records = m_consumer.poll(500);
            for (ConsumerRecord<String, String> record : records) {
            		// insert data in postgres
            		// insertRecord(record);
	        		preparedStatement.setInt(1, m_dbKey++);
	        		preparedStatement.setString(2, record.value());
	        		preparedStatement .executeUpdate();

            }
        }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyKafkaConsumer myc = new MyKafkaConsumer();
		
		try {
			myc.setup("/Users/prem/Downloads/aiven-kafka/consumer.properties");
			myc.open();
		} catch (Exception e0) {
			e0.printStackTrace();
			System.out.println("Exiting");
			System.exit(-1);
		}
		
		// do work
		try {
			myc.read();
		} catch (Exception e0) {
			e0.printStackTrace();
			System.out.println("Exiting");
			System.exit(-1);
		} finally {
			try {
				myc.close();
			} catch (Exception e1) {
				
			}
		}
		
	}

}
