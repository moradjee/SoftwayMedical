package com.softway.medical.softwaymedical.controller;


import com.softway.medical.softwaymedical.service.IndexSanteService;
import com.softway.medical.softwaymedical.service.IndexSanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class IndexSanteController {

    private final IndexSanteService indexSanteService;

    public IndexSanteController(IndexSanteService indexSanteService) {
        this.indexSanteService = indexSanteService;
    }

    @GetMapping("/diagnostic/{index}")
    public List<String> getDiagnostic(@PathVariable  int index) {
        return indexSanteService.determinePathologies(index);
    }
}
