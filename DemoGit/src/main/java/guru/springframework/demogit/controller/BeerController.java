package guru.springframework.demogit.controller;

import guru.springframework.demogit.model.BeerDto;
import guru.springframework.demogit.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    @Autowired
    private BeerService beerService;

    @GetMapping("/{beerid}")
    public ResponseEntity<BeerDto> getBeerDetail(@PathVariable("beerid") UUID beerid){
        return new ResponseEntity(beerService.getBeerById(beerid), HttpStatus.OK);
    }
}
