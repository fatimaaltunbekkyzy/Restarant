package peaksoft.restarant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.restarant.enums.RequestStatus;
import peaksoft.restarant.enums.Role;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String email;
    String password;
    String phoneNumber;
    int experience;
    Role role;
    RequestStatus status;
//    Long restaurantId;

//    public UserResponse(Long id, @NotNull String firstName, @NotNull String lastName, @NotNull @Email String email, @NotNull String phoneNumber, @NotNull LocalDate dateOfBirth, int experience, Role role, RequestStatus status) {
    }
//    public UserResponse(Long id, String firstName, String lastName, LocalDate dateOfBirth, String email, String password, String phoneNumber, int experience, Role role, RequestStatus status) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//        this.email = email;
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//        this.experience = experience;
//        this.role = role;
//        this.status = status;

//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public int getExperience() {
//        return experience;
//    }
//
//    public void setExperience(int experience) {
//        this.experience = experience;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public RequestStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(RequestStatus status) {
//        this.status = status;
//    }

