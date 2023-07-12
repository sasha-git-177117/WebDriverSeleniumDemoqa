package testing.pages.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDataModel {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int salary;
    private String department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        UserDataModel userData = (UserDataModel) o;
        return this.firstName.equals(userData.firstName) &&
                this.lastName.equals(userData.lastName) &&
                this.email.equals(userData.email) &&
                this.department.equals(userData.department) &&
                this.age == userData.age &&
                this.salary == userData.salary;
    }
}
