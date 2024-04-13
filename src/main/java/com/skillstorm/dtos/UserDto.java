package com.skillstorm.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstorm.entities.User;
import com.skillstorm.entities.W2;
import com.skillstorm.validations.AddUserGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty(message = "{user.firstName.must}")
    @Size(min = 2, message = "{user.firstName.size}")
    @Pattern(regexp = "[a-zA-Z]+", message = "{user.firstName.pattern}")
    private String firstName;

    @NotEmpty(message = "{user.lastName.must}")
    @Size(min = 2, message = "{user.lastName.size}")
    @Pattern(regexp = "[a-zA-Z]+", message = "{user.lastName.pattern}")
    private String lastName;

    @NotEmpty(groups = {AddUserGroup.class, Default.class}, message = "{user.email.must}")
    @Email(groups = {AddUserGroup.class, Default.class}, message = "{user.email.valid}")
    private String email;

    @NotEmpty(message = "{user.address.must}")
    private String address;

    @NotEmpty(message = "{user.phoneNumber.must}")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "{user.phoneNumber.valid}")
    private String phoneNumber;

    @NotEmpty(message = "{user.ssn.must}")
    @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{4}$", message = "{user.ssn.valid}")
    private String ssn;

    private List<W2> w2s;

    public UserDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.phoneNumber = user.getPhoneNumber();
        this.ssn = user.getSsn();
        this.w2s = user.getW2s();
    }

    @JsonIgnore
    public User getUser() {
        User user = new User();
        user.setId(this.id);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setAddress(this.address);
        user.setPhoneNumber(this.phoneNumber);
        user.setSsn(this.ssn);
        user.setW2s(this.w2s);

        return user;
    }
}
