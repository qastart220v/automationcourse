import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.MainPage;

public class CreateAccountTests extends BaseTest {


    @Test
    public void verifyCreateAccount() {
        Account accountDetails = new Account.AccountBuilder().
                firstName("Oleksandr").
                lastName("Pavl").
                country("Ukraine").
                email("alex22@gmail.com").
                desiredPassword("Hxs9HaLeA6VySW3").
                confirmPassword("Hxs9HaLeA6VySW3").
                createAccount();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.openSignInForm();
        mainPage.openCreateAccount();
        CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
        createAccountPage.fillCreateAccountForm(accountDetails);
        Assert.assertEquals("2","4");

        //Домашнее задание - добработать тест. (Подумайте как задавать всегда разные тестовые данные , так как создание  аккаунта с одним и тем же email не разрешается)
        //Подсказка - добавляйте Random строку в название  , например alex22@gmail.com - где alex22vxvc Random строка

    }


}
