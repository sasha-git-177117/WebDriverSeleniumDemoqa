package testing.pages.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserDataEnum {
    FIRST_NAME ("firstName"),
    LAST_NAME ("lastName"),
    EMAIL ("userEmail"),
    AGE ("age"),
    SALARY ("salary"),
    DEPARTMENT ("department");

    public final String label;

}
