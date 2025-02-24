package peaksoft.restarant.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.restarant.enums.RequestStatus;
import peaksoft.restarant.enums.Role;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_gen")
    @SequenceGenerator(name = "user_gen",sequenceName = "user_seq",allocationSize = 1)
    Long id;
    @Column(nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    LocalDate dateOfBirth;
    @Column(unique = true, nullable = false)
    String email;
    @Column(unique = true, nullable = false)
    String password;
    @Column(nullable = false)
    String phoneNumber;
    @Enumerated(EnumType.STRING)
    Role role;
    int experience;

    String position;

    @Enumerated(EnumType.STRING)
    RequestStatus status = RequestStatus.PENDING;;

    @ManyToOne
    Restaurant restaurant;
    @OneToMany(mappedBy = "user")
    List<Cheque> cheques;

}
