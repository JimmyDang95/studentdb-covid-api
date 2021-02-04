package de.neuefische.covidapi.controller;

import de.neuefische.covidapi.model.ActiveCases;
import de.neuefische.covidapi.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("covid")
public class ActiveCasesControllerHH {

    private final CovidService covidService;

    @Autowired
    public ActiveCasesControllerHH(CovidService covidService){
        this.covidService = covidService;
    }

    @GetMapping
    public ActiveCases getActiveCasesHamburg(){
        Optional<ActiveCases> activeCasesHamburg = covidService.getActiveCasesHamburg();
        if(activeCasesHamburg.isPresent()){
            return activeCasesHamburg.get();
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
