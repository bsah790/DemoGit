package guru.springframework.demogit.service;

import guru.springframework.demogit.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerid) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Heat").beerStyle("").upc(1000L).build();
    }
}
