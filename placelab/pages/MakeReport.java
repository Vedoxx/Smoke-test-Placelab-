package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MakeReport {
    private WebDriver driver;
    private String reportName="Sarajevo downtown";

    public MakeReport(WebDriver driver){
        this.driver = driver;
    }

    public String getHeader(){
        return driver.findElement(By.xpath("//*[@id=\"hotspot_dialog\"]/div[1]/div")).getText();
    }
    public void setReportName(){
        WebElement enterReportName = driver.findElement(By.id("name"));
        enterReportName.sendKeys(reportName);
    }
    public WebElement getReportName () {
        return driver.findElement(By.id("name"));
    }
    public void setLocation(){
        WebElement enterLocation = driver.findElement(By.name("location_name"));
        enterLocation.sendKeys("Sarajevo");
    }
    public WebElement getLocation() {
        return driver.findElement(By.id("location_name"));
    }
    public void setLatitude(){
        WebElement latitude= driver.findElement(By.id("city_lat"));
        latitude.sendKeys("43.858819");
    }
    public void setLongitude(){
        WebElement longitude= driver.findElement(By.id("city_lng"));
        longitude.sendKeys("18.421766");
    }
    public WebElement getLatitude () {
        return driver.findElement(By.id("city_lat"));
    }
    public WebElement getLongitude () {
        return driver.findElement(By.id("city_lng"));
    }
    public void setCategory(){
        WebElement category=driver.findElement(By.xpath("//button[@title='Please select category']"));
        category.click();
        WebElement selectCategory=driver.findElement(By.xpath("//*[@id=\"hotspot_poi_query\"]/div[2]/div/ul/div/li[2]/a/label"));
        selectCategory.click();
    }
    public WebElement getRadius () {
        return driver.findElement(By.id("radius"));
    }
    public void createReport(){
        WebElement createReport = driver.findElement(By.xpath("//*[@id='hotspot_poi_query']/button"));
        createReport.click();
    }
    public WebElement getReportButton() {
        return driver.findElement(By.xpath("//*[@id='hotspot_poi_query']/button"));
    }
}
