package peaksoft.restarant.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="restaurants")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_gen")
    @SequenceGenerator(name = "restaurant_gen", sequenceName = "restaurant_seq", allocationSize = 1)
    Long id;
    String name;
    String location;
    String restType;
    int numberOfEmployees; //Жумушчулардын саны
    String service; //Услуга

    @OneToMany(mappedBy = "restaurant")
    List<User> users;

    // OneToMany байланышы: Бир ресторанда көп MenuItem'дер болушу мүмкүн
    @OneToMany(mappedBy = "restaurant")
    List<MenuItem> menuItems;

    public Collection<Object> getUser() {
        return null;
    }
}