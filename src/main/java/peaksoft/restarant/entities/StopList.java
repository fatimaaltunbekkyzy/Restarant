package peaksoft.restarant.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="stopList")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StopList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stopList_gen")
    @SequenceGenerator(name = "stopList_gen", sequenceName = "stopList_seq", allocationSize = 1)
    Long id;
    String reason;
    LocalDate date;

    // OneToOne байланышы: MenuItem'ге бир StopList байланыштуу
    @OneToOne
    MenuItem menuItem;

}
