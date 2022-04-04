package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public String getUserName() {
        return driver.findElement(By.id("user-name")).getText();
    }
    public String getUserRole() {
        return driver.findElement(By.id("user-role")).getText();
    }
   public void signOut(){
       driver.findElement(By.id("user-name")).click();
       driver.findElement(By.xpath("//a[normalize-space()='Sign out']")).click();
   }
   public void selectHotspotAreaAnalysis(){
        driver.findElement(By.xpath("//a[@id='create-menu']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Hotspot Area Analysis']")).click();
   }
}
