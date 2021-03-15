package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleDrugStorage implements DrugStorage {

    private final Map<Medicine, Integer> drugs;


    public SimpleDrugStorage(Map<Medicine, Integer> drugs) {
        this.drugs = new LinkedHashMap<>(drugs);
    }


    @Override
    public Map<Medicine, Integer> list() {
        return Map.copyOf(drugs);
    }
}
