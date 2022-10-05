package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n01.S04T02N01PedroCasullaJoanMarc.domain;



import lombok.AllArgsConstructor;
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

    @Column(name= "name") //atribut que serà columna a la db
    private String name;

    @Column(name = "kg")
    private int kilos;

    public Fruit(String name, int kilos) {
        this.name = name;
        this.kilos = kilos;
    }
}
