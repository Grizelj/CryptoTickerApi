package hr.grizelj.praksa.service;


import hr.grizelj.praksa.dto.TickerPairDto;
import hr.grizelj.praksa.dto.TickerResponseDto;
import hr.grizelj.praksa.model.Ticker;
import hr.grizelj.praksa.repository.TickerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class TickerService {

    private final TickerRepository tickerRepository;
    private final RestTemplate restTemplate;

    public TickerService(TickerRepository tickerRepository, RestTemplate restTemplate) {
        this.tickerRepository = tickerRepository;
        this.restTemplate = restTemplate;
    }

    @Scheduled(initialDelay = 2000, fixedRate = 5000)
    public void getTickerInfo() {
        TickerResponseDto response = restTemplate.getForObject("https://api.kraken.com/0/public/Ticker?pair=XBTUSD,ETHUSD,LTCUSD", TickerResponseDto.class);
        log.info("nesto {}", response);

        if(response != null) {

            for (String key : response.getResult().keySet()) {
                TickerPairDto tickerPairDto = response.getResult().get(key);
                Ticker ticker = new Ticker();
                ticker.setPair(key);
                ticker.setTimestamp(Instant.now());
                ticker.setA(tickerPairDto.getA());
                ticker.setB(tickerPairDto.getB());
                ticker.setC(tickerPairDto.getC());
                ticker.setV(tickerPairDto.getV());
                ticker.setP(tickerPairDto.getP());
                ticker.setT(tickerPairDto.getT());
                ticker.setL(tickerPairDto.getL());
                ticker.setH(tickerPairDto.getH());
                ticker.setO(tickerPairDto.getO());
                tickerRepository.save(ticker);
            }
        }
    }
    public List<Ticker> getTickers() { return tickerRepository.findAllByOrderByTimestampDesc(); }

}


