package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n02.S04T02N02PedroCasulla.services;

import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n02.S04T02N02PedroCasulla.domain.Fruit;

import java.util.Optional;

public interface FruitService {
    Iterable<Fruit> findAll();

    Optional<Fruit> findById(Long Id);

    Fruit add(Fruit fruit);

    void deleteById(Long id);

    Fruit updateById(Long id,Fruit fruit);




}
