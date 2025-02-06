package org.example.application.service;

import lombok.RequiredArgsConstructor;
import org.example.application.port.in.ProcessDataUseCase;
import org.example.application.port.out.SaveDataPort;
import org.example.domain.DataModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataProcessorService implements ProcessDataUseCase {
    private final SaveDataPort saveDataPort;

    @Override
    public void processData(DataModel data) {
        // Business logic here
        saveDataPort.saveData(data);
    }
}
