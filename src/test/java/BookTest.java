import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class BookTest {
    final static Logger log = Logger.getLogger(String.valueOf(LogExample.class));
    SeleniumHelper seleniumHelper;
    //Methods methods = new Methods();

    @Test
    public void registerUser() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        api.createBook(config.getLoginPassword());
        log.info("Book created");
        Thread.sleep(2000);
        seleniumHelper.lendBook();
        log.info("The book can be lended");
        //methods.lendBook();
        //og.info("The book can be lended");
    }

    @Test
    public void createEmptyBook() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        Thread.sleep(1000);
        seleniumHelper.getElement("books").click();
        Thread.sleep(1000);
        seleniumHelper.createEmptyBook();
    }

    @Test
    public void deleteBook() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        api.createBook(config.getLoginPassword());
        log.info("Book created");
        seleniumHelper.getElement("books").click();
        Thread.sleep(2000);
        seleniumHelper.deleteBook();
    }

    @Test
    public void editBook() throws IOException, InterruptedException {
        Configuration config = new Configuration();
        ApiCalls api = new ApiCalls();
        seleniumHelper = new SeleniumHelper(config.getBrowser());
        //Methods methods = new Methods(config.getBrowser());

        api.createNewUser(config.getApiUrl(), config.getLoginPassword());
        log.info("user created");
        seleniumHelper.navigateToURL(config.getApplicationURL());
        seleniumHelper.loginInApplication(api.getEmailCreated(),
                config.getLoginPassword());
        log.info("login OK");
        seleniumHelper.verifyUserHasLoggedIn();
        log.info("login asserted");
        api.createAuthor(config.getLoginPassword());
        log.info("author created");
        api.createBook(config.getLoginPassword());
        log.info("Book created");
        seleniumHelper.getElement("books").click();
        Thread.sleep(2000);
        seleniumHelper.editBook();
    }

}
