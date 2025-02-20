package peaksoft.restarant.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subcategories")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "subcategory_gen")
    @SequenceGenerator(name = "subcategory_gen",sequenceName = "subcategory_seq",allocationSize = 1)
    Long id;
    String name;

    // OneToMany байланышынан келип чыккан MenuItem'дер
    @OneToMany(mappedBy = "subcategory")
    List<MenuItem> menuItems;

    @ManyToOne
    Category category;

}
