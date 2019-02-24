import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class JavaProcedur {


    public static void main(String[] args) {
        String topicname="arama";
        Properties config=new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        Producer producer=new KafkaProducer<String,String>(config);
        ProducerRecord<String,String> record=new ProducerRecord<String, String>
                (topicname,"ayakkabı");
        producer.send(record);
        producer.close();

    }
}
