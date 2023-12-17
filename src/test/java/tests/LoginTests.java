package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTests extends TestBase {
        @Test

        public void  loginSuccessTest(){
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("test.anna.book@gmail.com", "SAMASAMa2023@");
            app.getHelperUser().submitLogin();

            //Assert if element with text "Logged is success" is present
           Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
           app.getHelperUser().clickOKButton();

        }

    }
