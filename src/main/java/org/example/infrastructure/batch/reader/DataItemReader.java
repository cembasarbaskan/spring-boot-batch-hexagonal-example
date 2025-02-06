package org.example.infrastructure.batch.reader;

import org.example.domain.DataModel;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class DataItemReader extends FlatFileItemReader<DataModel> {
    public DataItemReader() {
        setResource(new ClassPathResource("data.csv"));
        setLineMapper(new DefaultLineMapper<DataModel>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("id", "name", "description");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<DataModel>() {{
                setTargetType(DataModel.class);
            }});
        }});
    }
}
