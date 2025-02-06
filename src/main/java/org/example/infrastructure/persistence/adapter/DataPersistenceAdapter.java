package org.example.infrastructure.persistence.adapter;

import org.example.application.port.out.SaveDataPort;
import org.example.domain.DataModel;
import org.springframework.stereotype.Component;

@Component
public class DataPersistenceAdapter implements SaveDataPort {
    @Override
    public void saveData(DataModel data) {
        // Save data to the database
        System.out.println("Data saved: " + data);
    }
}
