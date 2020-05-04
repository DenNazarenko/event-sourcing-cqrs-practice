package com.fooddelivery.order.saver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fooddelivery.order.event.BaseEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventSaver {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "order-events", groupId = "group1", containerFactory = "kafkaListenerContainerFactory")
    public void on(BaseEvent baseEvent) {
        log.info("Event [" + baseEvent.id + "] has been received. Starting saving to HDFS");

        Configuration conf = new Configuration();
        conf.set("dfs.replication", "1"); //todo could it be set into hadoop configs?
        try (SequenceFile.Writer writer = SequenceFile.createWriter(
                conf,
                SequenceFile.Writer.file(new Path("hdfs://localhost:9000/events")), //todo think how to cut events to many files
                SequenceFile.Writer.keyClass(Text.class),
                SequenceFile.Writer.valueClass(Text.class),
                SequenceFile.Writer.appendIfExists(true)
        )) {
            writer.append(new Text(baseEvent.id), new Text(objectMapper.writeValueAsString(baseEvent)));
        }

        log.info("Event [" + baseEvent.id + "] has been saved");
    }

}
