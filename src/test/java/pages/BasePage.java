package pages;

import org.openqa.selenium.WebDriver;

import javax.naming.ldap.LdapReferralException;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;

    }
}
