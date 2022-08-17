package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

public class HaloRegistrationAndLoginTests extends BaseTest {
    HaloLandingPage haloLandingPage;
    HaloLoginPage haloLoginPage;
    HaloRegistrationPage haloRegistrationPage;
    MailinatorMainPage mailinatorMainPage;
    MailinatorInboxPage mailinatorInboxPage;
    MailinatorActivationEmailPage mailinatorActivationEmailPage;
    HaloAccountActivationPage haloAccountActivationPage;
    HaloProfilPage haloProfilPage;

    @Before
    public void SetUpTest() {
        haloLandingPage = new HaloLandingPage();
        haloLoginPage = new HaloLoginPage();
        haloRegistrationPage = new HaloRegistrationPage();
        mailinatorMainPage = new MailinatorMainPage();
        mailinatorInboxPage = new MailinatorInboxPage();
        mailinatorActivationEmailPage = new MailinatorActivationEmailPage();
        haloAccountActivationPage = new HaloAccountActivationPage();
        haloProfilPage = new HaloProfilPage();
    }

    @Test
    public void haloOglasiRegistrationAndLoginTest() throws InterruptedException {
        //  Open link https://www.halooglasi.com/
        // moved to BaseTest @Before

//    click on login (uloguj se) button
        haloLandingPage.ulogujSeButton();

//    go to registration link
        haloLoginPage.registrujteSeButton();

//    if "fizicko lice" is not selected, then select it
        haloRegistrationPage.fizickoLiceRadioButtonClick();

//    fill the form
        haloRegistrationPage.fizickoLiceRadioButtonClick();
        haloRegistrationPage.korisnickoImeInputBoxSendKeys();
        //    email address is generated on (@mailinator.com)
        haloRegistrationPage.emailInputBoxSendKeys();
        haloRegistrationPage.lozinkaInputBoxSendKeys();
        haloRegistrationPage.potvrdaLozinkeInputBoxSendKeys();
        //    accept the agreement
        haloRegistrationPage.racunSaglasnostCheckboxClick();
        //    click on register button
        haloRegistrationPage.registrujMeButton();

//      assert the message
        Assert.assertTrue(haloRegistrationPage.registracijaUspelaNaslovTextIsDisplayed());
        Assert.assertEquals("Registracija je uspela!", haloRegistrationPage.registracijaUspelaNaslovTextGetText());
        Assert.assertTrue(haloRegistrationPage.registracijaUspelaTeloTextIsDisplayed());
        String emailBodyText = "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : " + email + " !";
        Assert.assertEquals(emailBodyText, haloRegistrationPage.registracijaUspelaTeloTextGetText());

//    go to https://www.mailinator.com/
        driver.get("https://www.mailinator.com/");

//    enter the address (used on halo oglasi) into public inbox
        //    and press Enter key
        mailinatorMainPage.mailinatorInboxInputBoxSendKeys();

//    open halo oglasi email
        mailinatorInboxPage.haloOglasiEmailElementClick();

//    click on halo oglasi account activation button -> opens a new Chrome tab
        mailinatorActivationEmailPage.aktivirajNalogButtonClick();

        // switch to second Chrome tab
        sharedMethods.switchToTab(1, "Aktivacija korisničkog naloga | Halo oglasi");

//    assert message for account activation
        Assert.assertTrue(haloAccountActivationPage.registrationSuccessTitleTextIsDisplayed());
        Assert.assertEquals("Vaš nalog je uspešno aktiviran!", haloAccountActivationPage.registrationSuccessTitleTextGetText());
        Assert.assertTrue(haloAccountActivationPage.registrationSuccessBodyTextIsDisplayed());
        Assert.assertEquals("Vaš nalog je uspešno aktiviran!\nProdužite na stranicu za logovanje kako biste pristupili našem portalu. Prijava", haloAccountActivationPage.registrationSuccessBodyTextGetText());

        //    click on "Prijava" (login) link
        haloAccountActivationPage.prijavaButtonClick();
        // [+] close cookie policy pop-up
        haloRegistrationPage.cookieAcceptButtonClick();

//    enter email and password (used previously for registration)
        haloLoginPage.emailInputBoxSendKeys();
        haloLoginPage.passwordInputBoxSendKeys();

//    click on "sign in" button
        haloLoginPage.ulogujMeButtonClick();

        //[+] refresh page
        // fixes the "stale element reference" error in next step
        driver.get(driver.getCurrentUrl());

//    check if correct user name and email is displayed
        haloProfilPage.mojProfilDivHover();
        Thread.sleep(3000);
        Assert.assertTrue(haloProfilPage.userNameTextIsDisplayed());
        Assert.assertEquals(userName, haloProfilPage.userNameTextGetText());
        Assert.assertTrue(haloProfilPage.userEmailTextIsDisplayed());
        Assert.assertEquals("email: " + email, haloProfilPage.userEmailTextGetText());
        Assert.assertTrue(haloProfilPage.userNameSecondTextIsDisplayed());
        Assert.assertEquals("korisničko ime: " + userName, haloProfilPage.userNameSecondTextGetText());
    }
}
