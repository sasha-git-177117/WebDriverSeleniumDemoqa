package testing.pages.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TableEnum {
    FIRST_NAME (0),
    LAST_NAME (1),
    AGE (2),
    EMAIL (3),
    SALARY (4),
    DEPARTMENT (5);

    public final Integer label;

}
