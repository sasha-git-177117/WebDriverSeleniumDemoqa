package testing.pages.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ButtonsFromAlertsAndFramesButton {
    ALERTS("Alerts"),
    NESTED_FRAMES("Nested Frames"),
    FRAMES("Frames"),
    WEB_TABLES("Web Tables"),
    BROWSER_WINDOWS("Browser Windows"),
    LINKS("Links");

    public final String label;

}
