package pe.com.project4.ms.infrastructure.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.com.project4.ms.infrastructure.event.SendMoneyRequestEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendMoneyProducer {

    private final KafkaTemplate<String, SendMoneyRequestEvent> kafkaTemplate;

    public void sendMoneyEvent(SendMoneyRequestEvent sendMoneyEventRequestEvent) {
        log.debug("==> Producing message {}", sendMoneyEventRequestEvent.toString());
        kafkaTemplate.send("SEND-MONEY-EVENT", sendMoneyEventRequestEvent);
    }

}
