/**
 * 
 */
package ex.kafka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author prem
 *
 */
public class MyKafkaProducer extends MyKafkaCommon {

	private KafkaProducer<String, String> m_producer;
	private Properties m_props = new Properties();

	/**
	 * 
	 */
	public MyKafkaProducer() {
	}

	private void setup(String propsFile) throws Exception {		
		InputStream config = openPropertiesFile(propsFile);
		m_props.load(config);
		
		// test load props
		System.out.println("security.protocol=" + m_props.getProperty("security.protocol"));
		
		// MyCredentials.MyKafkaProducerProps(m_props);
	}

	private void open() throws Exception {
		m_producer = new KafkaProducer<String, String>(m_props);
	}

	private void close() throws Exception {
		m_producer.close();
	}

	private void send(String str) throws Exception {
		ProducerRecord<String, String> outMsg = new ProducerRecord<String, String>("ex", str);
		m_producer.send(outMsg);
		outMsg = null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// setup
		MyKafkaProducer myp = new MyKafkaProducer();
		try {
			myp.setup("/Users/prem/Downloads/aiven-kafka/producer.properties");
			myp.open();
		} catch (Exception e0) {
			e0.printStackTrace();
			System.out.println("Exiting");
			System.exit(-1);
		}

		// do work
		BufferedReader syslog = null;
		try {
			syslog = new BufferedReader(new FileReader(new File("/var/log/system.log")));
			String ln;
			while ((ln = syslog.readLine()) != null) {
				myp.send(ln);
			}
		} catch (Exception e0) {
			e0.printStackTrace();
		} finally {
			try {
				if (syslog != null) {
					syslog.close();
				}
			} catch (Exception e1) {

			}
		}

		// finally cleanup
		try {
			myp.close();
		} catch (Exception e0) {
			
		}

	}

}
