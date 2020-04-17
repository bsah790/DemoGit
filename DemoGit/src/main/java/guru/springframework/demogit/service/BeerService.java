package guru.springframework.demogit.service;

import guru.springframework.demogit.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerid);
}
