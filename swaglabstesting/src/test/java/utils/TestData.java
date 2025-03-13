package utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "validUsers")
    public Object[][] getValidUsers() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
        };
    }
}