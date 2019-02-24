import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        String topicName="arama";
        Properties configProperties=new Properties();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG,"bigdat");
        configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG,"örne");

        KafkaConsumer<String ,String> kafkaConsumer=new KafkaConsumer<String, String>(configProperties);
        kafkaConsumer.subscribe(Arrays.asList(topicName));
       try {


        while (true){
            ConsumerRecords<String, String> record=kafkaConsumer.poll(1000);
            for (ConsumerRecord<String,String> record1:record){
                System.out.println(record1.value());

            }
        }
    }catch (Exception e){
           System.out.println(e);
       }
    }

}
