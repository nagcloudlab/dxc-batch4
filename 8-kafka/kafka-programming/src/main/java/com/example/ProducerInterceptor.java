package com.example;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class ProducerInterceptor implements org.apache.kafka.clients.producer.ProducerInterceptor {

    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        System.out.println("onSend()");
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        System.out.println("onAcknowledgement()");
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
