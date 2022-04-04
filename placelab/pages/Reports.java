package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reports {
    private  WebDriver driver;
    private String reportName = System.getProperty("reportName");

    public Reports(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnTheReport(){
        String path = "//div[@class='query_name']/a[text()='" + reportName + "']";
        WebElement report = driver.findElement(By.xpath(path));
        report.click();
    }
    public void clickOnCheckBox(){
        driver.findElement(By.xpath("//*[@id='table_queries']/tbody/tr[1]/td[2]/div")).click();
    }
    public void deleteReport() {
        driver.findElement(By.xpath("//*[@id='action-delete']/a")).click();
    }
    public void confirmDelete() {
        driver.findElement(By.xpath("//*[@id='confirm-link']")).click();
    }
    public WebElement deleteMessage(){
        WebElement deleteMessage = driver.findElement(By.xpath("//*[@id=\"alert-place\"]/div"));
        return deleteMessage;
    }
}
