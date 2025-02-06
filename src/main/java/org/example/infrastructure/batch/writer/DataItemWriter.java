package org.example.infrastructure.batch.writer;

import lombok.RequiredArgsConstructor;
import org.example.application.port.in.ProcessDataUseCase;
import org.example.domain.DataModel;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataItemWriter implements ItemWriter<DataModel> {
    private final ProcessDataUseCase processDataUseCase;

    @Override
    public void write(List<? extends DataModel> items) throws Exception {
        for (DataModel item : items) {
            processDataUseCase.processData(item);
        }
    }
}
