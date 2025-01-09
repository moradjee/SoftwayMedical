package com.softway.medical.softwaymedical.service;

import com.softway.medical.softwaymedical.exception.SanteIndexException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexSanteServiceImpl implements IndexSanteService {


    @Override
    public List<String> determinePathologies(int index) {
        List<String> pathologies = new ArrayList<>();

        // Vérifier si l'index est multiple de 3 (problème cardiaque)
        if (index % 3 == 0) {
            pathologies.add("Cardiologie");
        }

        if (index % 5 == 0) {
            pathologies.add("Traumatologie");
        }

        if(pathologies.isEmpty() )
        {
            throw new SanteIndexException(index);
        }
        return pathologies;
    }
}
