package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//a[text()= 'Log in']"));

    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }

public void clickOKButton(){
        click(By.xpath("//button[text()= 'Ok']"));

}

    public boolean isLogged(){
        return  isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }


}
