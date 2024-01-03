package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preConditions(){
        if (app.getHelperUser().isLogged())
        {app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);

        User user = new User()
                .withFirstName("Lisa")
                .withLastName("Snow")
                .setEmail("snow"+i+"@mail.ru")
                .setPassword("Snow123456$");
app.getHelperUser().openRegistrationForm();
app.getHelperUser().fillLoginRegistrationForm(user);
app.getHelperUser().checkPolicyXY();
app.getHelperUser().submit();
 Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

    }

    @Test(description = "Bug report #12456, Fixed")

    public void registrationWrongEmail(){

        User user = new User()
                .withFirstName("Lisa")
                .withLastName("Snow")
                .setEmail("snowmail.ru")
                .setPassword("Sno123456$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @Test
    public void registrationWrongPassword(){
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User()
                .withFirstName("Li"+i+"sa")
                .withLastName("Sn"+i+"ow")
                .setEmail("snow"+i+"@mail.ru")
                .setPassword("sno"+i+"123456");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationExistUser(){

        User user = new User().setEmail("test.anna.book@gmail.com").setPassword("SAMASAMaq2023@");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        //Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }

    @Test
    public void registrationEmptyName(){
        User user = new User()
                .withFirstName(" ")
                .withLastName("Snow")
                .setEmail("snow@mail.ru")
                .setPassword("Sno123456$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationEmptyLastName(){
        User user = new User()
                .withFirstName("Don")
                .withLastName(" ")
                .setEmail("snow@mail.ru")
                .setPassword("Sno123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }


    @AfterMethod
    public void postConditions(){
        app.getHelperUser().clickOKButton();
    }
}
