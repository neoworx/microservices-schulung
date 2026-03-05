package de.hdpgmbh.fahrzeuge.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

  public static final String FAHRZEUG_CREATED_EXCHANGE = "fahrzeugCreatedExchange";

  public static final String FAHRZEUG_CREATED_QUEUE = "fahrzeugCreatedQueue";

  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange(FAHRZEUG_CREATED_EXCHANGE);
  }

  @Bean
  public Queue fahrzeugeCreatedQueue() {
    return new Queue(FAHRZEUG_CREATED_QUEUE, false);
  }

  @Bean
  public Queue queueB() {
    return new Queue("queueB");
  }

  @Bean
  public Binding bindingA(FanoutExchange fanoutExchange, Queue fahrzeugeCreatedQueue) {
    return BindingBuilder.bind(fahrzeugeCreatedQueue).to(fanoutExchange);
  }

  @Bean
  public Binding bindingB(FanoutExchange fanoutExchange, Queue queueB) {
    return BindingBuilder.bind(queueB).to(fanoutExchange);
  }

  @Bean
  public Jackson2JsonMessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

}

