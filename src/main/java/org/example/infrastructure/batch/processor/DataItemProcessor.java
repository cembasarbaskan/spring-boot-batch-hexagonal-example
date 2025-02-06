package org.example.infrastructure.batch.processor;

import org.example.domain.DataModel;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class DataItemProcessor implements ItemProcessor<DataModel, DataModel> {

    @Override
    public DataModel process(DataModel item) throws Exception {
        // Process data here
        return item;
    }
}
