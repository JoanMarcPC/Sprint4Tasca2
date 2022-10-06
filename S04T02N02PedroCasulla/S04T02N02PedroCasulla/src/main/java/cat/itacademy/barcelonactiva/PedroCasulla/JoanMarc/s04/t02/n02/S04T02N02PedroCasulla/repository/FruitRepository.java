package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n02.S04T02N02PedroCasulla.repository;

import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n02.S04T02N02PedroCasulla.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit,Long> {

}
