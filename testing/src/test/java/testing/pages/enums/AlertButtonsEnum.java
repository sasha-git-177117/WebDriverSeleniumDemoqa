package testing.pages.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AlertButtonsEnum {
    TO_SEE_ALERT("alertButton"),
    CONFIRM("confirmButton"),
    PROMPT("promtButton");

    public final String label;

}
