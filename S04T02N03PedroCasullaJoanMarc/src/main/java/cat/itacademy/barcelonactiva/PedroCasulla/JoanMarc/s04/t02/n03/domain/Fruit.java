package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s04.t02.n03.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data // @ToString, @EqualsAndHashCode, @Getter @Setter, and @RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "fruits")
// itli for, iter forecah, sout print
public class Fruit {
    @Id //define primary key
    private  String id;
    private String name;
    private int kilos;

    public Fruit(String name, int kilos) {
        this.name = name;
        this.kilos = kilos;
    }
}
