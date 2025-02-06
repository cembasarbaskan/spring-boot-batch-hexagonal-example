package org.example.infrastructure.batch.config;

import lombok.RequiredArgsConstructor;
import org.example.domain.DataModel;
import org.example.infrastructure.batch.listener.JobCompletionNotificationListener;
import org.example.infrastructure.batch.processor.DataItemProcessor;
import org.example.infrastructure.batch.reader.DataItemReader;
import org.example.infrastructure.batch.writer.DataItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataItemReader reader;
    private final DataItemProcessor processor;
    private final DataItemWriter writer;
    private final JobCompletionNotificationListener listener;

    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<DataModel, DataModel> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}