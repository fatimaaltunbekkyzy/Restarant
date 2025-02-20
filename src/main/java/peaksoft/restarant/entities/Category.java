package peaksoft.restarant.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name="categories")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_gen")
    @SequenceGenerator(name = "category_gen",sequenceName = "category_seq",allocationSize = 1)
    Long id;
    String name;

   //  OneToMany байланышынан келип чыккан Subcategory'лер
    @OneToMany(mappedBy = "category")
    List<Subcategory> subcategories;













//
//    public Category() {
//    }
//
//    public Category(Long id, String name, List<Subcategory> subcategories) {
//        this.id = id;
//        this.name = name;
//        this.subcategories = subcategories;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Subcategory> getSubcategories() {
//        return subcategories;
//    }
//
//    public void setSubcategories(List<Subcategory> subcategories) {
//        this.subcategories = subcategories;
//    }
}
