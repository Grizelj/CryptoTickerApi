package hr.grizelj.praksa.repository;


import hr.grizelj.praksa.model.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TickerRepository extends JpaRepository<Ticker, Long> {
    List<Ticker> findAllByOrderByTimestampDesc();

}
