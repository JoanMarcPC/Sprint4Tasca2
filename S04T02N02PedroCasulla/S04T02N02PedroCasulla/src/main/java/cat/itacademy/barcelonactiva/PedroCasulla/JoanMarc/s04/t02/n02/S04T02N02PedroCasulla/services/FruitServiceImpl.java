package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n02.S04T02N02PedroCasulla.services;

import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n02.S04T02N02PedroCasulla.domain.Fruit;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n02.S04T02N02PedroCasulla.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Optional<Fruit> findById(Long Id) {
        return fruitRepository.findById(Id);
    }

    @Override
    public Fruit add(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteById(Long id) {
       fruitRepository.deleteById(id);
    }

    @Override
    public Fruit updateById(Long id, Fruit fruit) {
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
