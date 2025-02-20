package peaksoft.restarant.dto;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import peaksoft.restarant.enums.Role;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @Past
    LocalDate dateOfBirth;
    @Email
    String email;
    String phoneNumber;
    @NotBlank
    @Size(min = 5, message = "Пароль должен содержать минимум 5 символов")
    String password;
    @NotBlank
    Role role;
    @Min(value = 0, message = "Стаж работы не может быть отрицательным")
    int experience;

    public UserRequest(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String password, Role role, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.experience = experience;
}}

