package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class AccountsBatchConfiguration {

    @Bean
    public FlatFileItemReader<Account> reader(){
        FlatFileItemReader<Account> reader = new FlatFileItemReader<Account>();
        reader.setResource(new ClassPathResource("accounts.csv"));
        reader.setLineMapper(new DefaultLineMapper<Account>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "number","balance" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Account>() {{
                setTargetType(Account.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<Account, Account> processor() {
        return new AccountItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Account> writer(DataSource dataSource){
        JdbcBatchItemWriter<Account> writer = new JdbcBatchItemWriter<Account>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Account>());
        writer.setSql("INSERT INTO accounts (number, balance) VALUES (:number, :balance)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,JdbcBatchItemWriter<Account> writer){
        return new StepBuilder("step1")
                .repository(jobRepository)
                .transactionManager(transactionManager)
                .<Account,Account>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }


    @Bean
    public Job importAccountJob(JobRepository jobRepository, Step step1){
        return new JobBuilder("importAccountJob")
                .repository(jobRepository)
                .start(step1)
                .build();
    }



}
