package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.controllers;



import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController // combinacion entre Controller y ResponseBody
@CrossOrigin("http://localhost:8081")
@RequestMapping("/fruit")
public class FruitController {
    @Autowired
    private FruitServiceImpl fruitService;

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody Fruit fruit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.add(fruit));
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") String id) {
        Optional<Fruit> fruit = fruitService.findById(id);
        if (fruit.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(fruit);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> readAll() {
        ArrayList<Fruit> fruits = (ArrayList<Fruit>) fruitService.findAll();
        if (fruits.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(fruits);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
        Optional<Fruit> fruit = fruitService.findById(id);
        if (!fruit.isPresent()) {

            return ResponseEntity.notFound().build();
        } else {
            fruitService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable (value = "id")String id, @RequestBody Fruit fruit){
        Fruit _fruit = null;
        if(fruit!=null){
            _fruit = fruitService.updateById(id, fruit);
        }

        if(_fruit!=null){
            return ResponseEntity.status(HttpStatus.OK).body(_fruit);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

    }


}