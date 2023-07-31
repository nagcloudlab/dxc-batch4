package com.example;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {


    static final Logger log = LoggerFactory.getLogger(Producer.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.74.109.224:9092,10.74.109.75:9092,10.74.109.103:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");


        // safe
        properties.put(ProducerConfig.ACKS_CONFIG, "-1");
        properties.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);
        properties.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "100");
        properties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");


        // throughput
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "none");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG, "0");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
        properties.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "60000");

        // partitioner
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        //properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.example.GreetingsTopicPartitioner");
        // interceptor
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,"com.example.ProducerInterceptor");


        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        //for (int i = 0; i < 10; i++) {
        String topic = "greetings2";
        String key = "key-" + 1;
        String value = "greeting-" + 1;

        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, key, value);
        kafkaProducer.send(producerRecord, (recordMetadata, exception) -> {
            if (exception != null) {
                log.info("topic: {} \n partition: {} \n offset: {}",
                        recordMetadata.topic(),
                        recordMetadata.partition(),
                        recordMetadata.offset());
                log.error(exception.getMessage());
            }
            log.info("\ntopic: {} \n key: {} \n partition: {} \n offset: {}",
                    recordMetadata.topic(),
                    producerRecord.key(),
                    recordMetadata.partition(),
                    recordMetadata.offset());
        });
        //}
        kafkaProducer.flush();
        kafkaProducer.close();


    }
}

