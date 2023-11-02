package com.cbfacademy.apiassessment.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.model.Watchlist;

@Service
@EnableMongoRepositories
public class WatchlistServices {

    private final CrudRepository<Watchlist, Long> repository;

    public WatchlistServices(CrudRepository<Watchlist, Long> repository){
        this.repository = repository;
        this.repository.saveAll(defaultWatchlist());
    }

    private static List<Watchlist> defaultWatchlist(){
        return List.of(
            //new Wathclist()
            // return the list of things that will be coming back from the data inputted by the user
        );
    }

    public List<Watchlist> findAll(){
        List<Watchlist> list = new ArrayList<>();
        Iterable<Watchlist> watchlist = repository.findAll();
        watchlist.forEach(list::add);
        return list;
    }

    public Optional<Watchlist> find(Long id){
        return repository.findById(id);
    }

    public Watchlist create(Watchlist copyOfWatchlist){
        Watchlist copy = new Watchlist(
        copy.setStockName(copyOfWatchlist.getStockName());
        copy.setSymbol(copyOfWatchlist.getSymbol());
        copy.setOwned(copyOfWatchlist.isOwned());
        copy.setStatus(copyOfWatchlist.getStatus());
        copy.setCurrency(copyOfWatchlist.getCurrency());
        LocalDate date = userInteractions.userPurchaseDate();
        copy.setDatePurchased(copyOfWatchlist.getDatePurchased());
        copy.setUnitsOwned(copyOfWatchlist.getUnitsOwned());
        copy.setProfit(copyOfWatchlist.getProfit());
        double pointsChange = copyOfWatchlist.getClose() - copyOfWatchlist.getOpen();
        copy.setPointsChange(copyOfWatchlist.getPointsChange(pointsChange));
        copy.setOpen(copyOfWatchlist.getOpen());
        copy.setClose(copyOfWatchlist.getClose());
        copy.setIntradayHigh(copyOfWatchlist.getIntradayHigh());
        );
        return repository.save(copy);
    }
    
}
