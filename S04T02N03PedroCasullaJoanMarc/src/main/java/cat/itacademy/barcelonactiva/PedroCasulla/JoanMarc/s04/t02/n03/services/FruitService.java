package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.services;



import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.domain.Fruit;

import java.util.Optional;

public interface FruitService {
    Iterable<Fruit> findAll();

    Optional<Fruit> findById(String Id);

    Fruit add(Fruit fruit);

    void deleteById(String id);

    Fruit updateById(String id, Fruit fruit);




}
