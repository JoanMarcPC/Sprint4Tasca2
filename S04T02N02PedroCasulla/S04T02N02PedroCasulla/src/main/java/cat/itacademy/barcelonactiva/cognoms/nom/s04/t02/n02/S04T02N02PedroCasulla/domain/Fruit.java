package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n02.S04T02N02PedroCasulla.domain;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data // @ToString, @EqualsAndHashCode, @Getter @Setter, and @RequiredArgsConstructor
@Entity// indica que serà persistent
@Table(name = "Fruits")
@NoArgsConstructor

public class Fruit {
    @Id //define primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // per definir com es tractarà la primary key
    private long id;

    @Column(name= "name", length = 100) //atribut que serà columna a la db
    private String name;

    @Column(name = "kg")
    private int kilos;

    public Fruit(String name, int kilos) {
        this.name = name;
        this.kilos = kilos;
    }
}
