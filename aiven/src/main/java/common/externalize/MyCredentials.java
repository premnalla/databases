/**
 * 
 */
package common.externalize;

import java.util.Properties;

/**
 * @author prem
 *
 */
public final class MyCredentials {

	/**
	 * 
	 */
	private MyCredentials() {
	}

	private static void MyKafkaCommonProps(Properties props) {
		/*
		props.put("bootstrap.servers", "kafka-1d34b8d2-exercise1.aivencloud.com:17295");
		props.put("security.protocol", "SSL");
		props.put("ssl.truststore.location", "/Users/prem/Downloads/aiven-kafka/client.truststore.jks");
		props.put("ssl.truststore.password", "secret");
		props.put("ssl.keystore.type", "PKCS12");
		props.put("ssl.keystore.location", "/Users/prem/Downloads/aiven-kafka/client.keystore.p12");
		props.put("ssl.keystore.password", "secret");
		props.put("ssl.key.password", "secret");
		*/
	}
	
	public static void MyKafkaProducerProps(Properties props) {
		/*
		MyKafkaCommonProps(props);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		*/
	}
	
	public static void MyKafkaConsumerProps(Properties props) {
		/*
		MyKafkaCommonProps(props);
        props.put("group.id", "ex-group-1");
        props.put("key.deserializer",
          "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
          "org.apache.kafka.common.serialization.StringDeserializer");
        */
	}
	
	public static void MyPostgresProps(Properties props) {
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
