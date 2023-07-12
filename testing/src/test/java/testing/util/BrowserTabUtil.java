package testing.util;

import framework.seleniumobjects.BrowserTab;

public class BrowserTabUtil {
    BrowserTab browserTab = new BrowserTab();

    public void openBrowserTab(int index) {
        browserTab.openBrowserTab(index);
    }

    public void closeBrowserTab() {
        browserTab.closeBrowserTab();
    }

    public String getPartURLPage() {
        String[] url = browserTab.getURLBrowserTab().split("/");
        return "/"+url[url.length-1];
    }

    public void returnToBeforePage() {
        browserTab.returnToBeforePage();
    }
}
