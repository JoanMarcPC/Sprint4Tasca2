package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.services;


import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.domain.Fruit;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> findById(String id) {
        return fruitRepository.findById(id);

    }

    @Override
    @Transactional
    public Fruit add(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        fruitRepository.deleteById(id);
    }

/*
    @Override
    @Transactional
    public Fruit updateById(Long id, Fruit fruit) {


        try {

            Fruit _fruit = fruitRepository.findById(id).get();
            if (Objects.nonNull(fruit.getId())) {
                _fruit.setId(fruit.getId());
            }
            if (Objects.nonNull(fruit.getName()) && !"".equalsIgnoreCase(fruit.getName())) {
                _fruit.setName(fruit.getName());
            }
            if (Objects.nonNull(fruit.getKilos())) {
                _fruit.setKilos(fruit.getKilos());
            }
            return fruitRepository.save(_fruit);
        }catch(Exception e){
            return null;
        }

    }
*/


    @Override
    @Transactional
    public Fruit updateById(String id, Fruit fruit) {
        try {
            Fruit fruitFound = fruitRepository.findById(id).get();
            if (fruitFound != null) {
                Fruit _fruit = fruitFound;
                _fruit.setName(fruit.getName());
                _fruit.setKilos(fruit.getKilos());
                return fruitRepository.save(_fruit);
                
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }


    }


}
