//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.logging.Logger;
//
//
//public class Methods extends SeleniumHelper{
//
//    final static Logger log = Logger.getLogger(String.valueOf(BookTest.LogExample.class));
//    public WebDriver driver;
//
//    public Methods() {
//    }
//
//    public void lendBook() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        Thread.sleep(2000);
//        getElement("//*[@id=\"books\"]/span").click();
//        getElement("books").click();
//        Thread.sleep(2000);
//        getElement("view_200").click();
//        Thread.sleep(1000);
//        Select dropdown = new Select(driver.findElement(By.id("select_lender")));
//        dropdown.selectByValue("CatalinMorariu_tester1");
//        WebElement element = driver.findElement(By.id("lend_book"));
//        if (element.isDisplayed() && element.isEnabled()) {
//            element.click();
//            Thread.sleep(1000);
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//        }
//    }
//
//    public WebElement getElement(String locator) {
//        if (locator.startsWith("//")) {
//            return driver.findElement(By.xpath(locator));
//        } else {
//            return driver.findElement(By.id(locator));
//        }
//    }
//}
//
