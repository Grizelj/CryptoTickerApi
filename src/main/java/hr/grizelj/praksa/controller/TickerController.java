package hr.grizelj.praksa.controller;


import hr.grizelj.praksa.model.Ticker;
import hr.grizelj.praksa.repository.TickerRepository;
import hr.grizelj.praksa.service.TickerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RestController
@RequestMapping("/tickers")
public class TickerController {

    private TickerService tickerService;
    private TickerRepository tickerRepository;

    public TickerController(TickerService tickerService){
        this.tickerService=tickerService;
    }


    @GetMapping(path="/all")
    public List<Ticker> getTickers(){

        return tickerService.getTickers();
    }



}
