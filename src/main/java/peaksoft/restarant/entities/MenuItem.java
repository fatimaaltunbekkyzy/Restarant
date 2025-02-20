package peaksoft.restarant.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="menuItems")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuItem_gen")
    @SequenceGenerator(name = "menuItem_gen", sequenceName = "menuItem_seq", allocationSize = 1)
    Long id;
    String name;
    String image;
    int price;
    String description;
    boolean isVegetarian;//

    // ManyToOne байланышы: Бир MenuItem бир ресторанга таандык
    @ManyToOne
    Restaurant restaurant;

    // OneToMany байланышы: Бир меню элементинде көп чек болушу мүмкүн
    @ManyToMany(mappedBy = "menuItems")
    List<Cheque> cheques;

// OneToOne байланышы: Бир MenuItem бир StopList'ке таандык
    @OneToOne(mappedBy = "menuItem")
    StopList stopList;

    // ManyToOne байланышына Subcategory'ге таандык
    @ManyToOne
    Subcategory subcategory;
}
