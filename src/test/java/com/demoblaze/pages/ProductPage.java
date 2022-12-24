package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(id = "nameofuser")
    public WebElement welcomeUserName_loc;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCart_loc;

        public void verifyLogin_mtd(String expectedUsername){
        String actualUsername = welcomeUserName_loc.getText();
        Assert.assertEquals("user does NOT match ",expectedUsername, actualUsername);
        System.out.println("actualUsername = " + actualUsername);
        System.out.println("expectedUsername = " + expectedUsername);
    }
    public void addProduct_mtd(String product, String category){
        WebElement categoryModul = Driver.get().findElement(By.xpath("//a[.='"+category+"']"));
        BrowserUtils.waitForClickablility(categoryModul,5).click();
        WebElement productItem = Driver.get().findElement(By.xpath("//a[.='"+product+"']"));
        BrowserUtils.scrollToElement(productItem);
        BrowserUtils.waitForClickablility(productItem,5).click();
        BrowserUtils.waitFor(2);
        addToCart_loc.click();
        BrowserUtils.waitFor(2);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();
        homeLink_loc.click();
        BrowserUtils.waitForClickablility(homeLink_loc,5).click();
        BrowserUtils.waitFor(2);


    }
}
