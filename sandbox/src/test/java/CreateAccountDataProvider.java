import org.testng.annotations.DataProvider;

public class CreateAccountDataProvider {


    @DataProvider(name = "create account")
    private Object[][] createAccount() {
        return new Object[][]{

                {"vvdaddsf@fdsas.com", "An account using this email address has already been registered. Please enter a valid password or request a new one."},

                {"", "Invalid email address."}

        };
    }
}
