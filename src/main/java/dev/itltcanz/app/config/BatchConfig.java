package dev.itltcanz.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Configuration
public class BatchConfig {

  @Value("${outbox.batch-size}")
  private int batchSize;

  @Value("${outbox.batch-sort-field}")
  private String batchSortField;

  @Bean
  public Pageable batchPageable() {
    Sort sort = Sort.by(Direction.ASC, batchSortField);
    return PageRequest.of(0, batchSize, sort);
  }
}
