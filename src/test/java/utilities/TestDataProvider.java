package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name="UserAccounts")
    public Object[][] loginData()
    {
        return new Object[][]{
                {"lizabeth.legros@yahoo.com","4xnL@X"},
                {"vicente.wisozk@yahoo.com","Feg4%5"}
        };
    }
}
