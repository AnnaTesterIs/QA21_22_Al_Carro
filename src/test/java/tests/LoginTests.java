package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;




public class LoginTests extends TestBase {
    @BeforeMethod
    public void preConditions(){
if (app.getHelperUser().isLogged())
        {app.getHelperUser().logout();
        }
    }

    @Test

    public void  loginSuccess1(){

        User user = new User().setEmail("test.anna.book@gmail.com").setPassword("SAMASAMa2023@");
        //user.setEmail("test.anna.book@gmail.com");
        //user.setPassword("SAMASAMa2023@");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "Logged is success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOKButton();

    }


        @Test

        public void  loginSuccess(){
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("test.anna.book@gmail.com", "SAMASAMa2023@");
            app.getHelperUser().submit();

            //Assert if element with text "Logged is success" is present
           Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
           //app.getHelperUser().clickOKButton();

        }
    @Test(dataProvider = "loginFile", dataProviderClass = DataProviderUser.class)
    public void  loginSuccessDP(User user){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        //Assert if element with text "Logged is success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOKButton();

    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("test.anna.book@gmail.com", "SAMASAMa2023@");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
       // app.getHelperUser().clickOKButton();

    }


        @Test
        public void loginWrongEmail(){
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm("test.anna.bookgmail.com", "SAMASAMa2023@");
            app.getHelperUser().submit();
            Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
            Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        }
    @Test(dataProvider = "wrongEmailFile", dataProviderClass = DataProviderUser.class)
    public void loginWrongEmailDP(User user){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }
    @Test(dataProvider = "loginWrongPasswordFile", dataProviderClass = DataProviderUser.class)
    public void loginWrongPassword(User user){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }
    @Test
    public void loginWrongPasswordDP(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("test.anna.book@gmail.com", "SAMASAMa2023");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }
    @Test
    public void loginWrongUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luck@gmail.com", "Luck123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }
    @Test(dataProvider = "WrongUnregisteredUserFile", dataProviderClass = DataProviderUser.class)
    public void loginWrongUnregisteredUserDP(User user){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }


    @AfterMethod
    public void postConditions(){
   app.getHelperUser().clickOKButton();
}

    }