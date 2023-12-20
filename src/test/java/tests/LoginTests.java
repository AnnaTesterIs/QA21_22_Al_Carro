package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTests extends TestBase {
    @BeforeMethod
    public void preConditions(){
if (app.getHelperUser().isLogged())
        {app.getHelperUser().logout();
        }
    }
        @Test

        public void  loginSuccessTest(){
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("test.anna.book@gmail.com", "SAMASAMa2023@");
            app.getHelperUser().submitLogin();

            //Assert if element with text "Logged is success" is present
           Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
           //app.getHelperUser().clickOKButton();

        }
@AfterMethod
    public void postConditions(){
    app.getHelperUser().clickOKButton();
}

    }