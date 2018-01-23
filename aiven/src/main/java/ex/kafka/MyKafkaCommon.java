/**
 * 
 */
package ex.kafka;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author prem
 *
 */
public abstract class MyKafkaCommon {

	/**
	 * 
	 */
	protected MyKafkaCommon() {
	}

	protected InputStream openPropertiesFile(String fname) throws Exception {
		InputStream input = new FileInputStream(fname);
		return (input);
	}
}
