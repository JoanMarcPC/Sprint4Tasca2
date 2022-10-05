package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02PedroCasulla.controllers;

import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n01.S04T02N01PedroCasullaJoanMarc.domain.Fruit;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n01.S04T02N01PedroCasullaJoanMarc.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FruitController {
    @Autowired
    FruitRepository fruitRepository;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/fruit/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = new ArrayList<Fruit>();
        try {
            if (fruitRepository.count() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            fruits = fruitRepository.findAll();
            return new ResponseEntity<>(fruits, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/fruit/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable("id") long id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);

        if (fruit.isPresent()) {
            return new ResponseEntity<>(fruit.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/fruit/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        try {
            Fruit _fruit = fruitRepository.save(new Fruit(fruit.getName(), fruit.getKilos()));
            return new ResponseEntity<>(_fruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/fruit/update/{id}")

    public ResponseEntity<Fruit> updateFruit(@PathVariable("id") long id, @RequestBody Fruit fruit) {
        Optional<Fruit> fruitFound = fruitRepository.findById(id);

        if (fruitFound.isPresent()) {
            Fruit _fruit = fruitFound.get();
            _fruit.setName(fruit.getName());
            _fruit.setKilos(fruit.getKilos());
            fruitRepository.save(_fruit);
            return new ResponseEntity<>(fruitRepository.save(_fruit), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/fruit/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") long id) {
        try {
            fruitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

