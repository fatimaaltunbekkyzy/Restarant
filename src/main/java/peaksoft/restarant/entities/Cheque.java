package peaksoft.restarant.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cheques")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cheque_gen")
    @SequenceGenerator(name = "cheque_gen",sequenceName = "cheque_seq",allocationSize = 1)
    Long id;
    int priceAverage;//озточо баасы
    LocalDateTime createdAt;  //чек качан тузулгондугу жонундогу убакыт

    // ManyToOne байланышы: Чек бир колдонуучуга таандык
    @ManyToOne
    User user;

    // ManyToMany байланышы: Cheque көп MenuItem'дерге ээ
    @ManyToMany
    List<MenuItem> menuItems;

}
