package com.Gusi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends AppTest{


    WebElement mEmailInput;
    WebElement mPasswordInput;
    WebElement mLoginButton;
    @Test
    public void checkLogin(){
        setTestInfo(
                getSessionId(mWebDriver),
                "Login",
                "PASSED",
                null


        );
        this.initElement();
        // this.mEmailInput.sendKeys("");
    }

    public void initElement(){
        //this.mEmailInput= mWebDriver.findElement(By.id(""));
        // this.mPasswordInput= mWebDriver.findElement(By.id(""));
        // this.mLoginButton= mWebDriver.findElement(By.id(""));
    }

    public void testWithInvalidCrediential(){

    }
    public void resetForm(){
        this.mEmailInput.clear();
        this.mPasswordInput.clear();
    }
}