package placelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportInformation {
    private  WebDriver driver;

    public ReportInformation(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getanalysisInfoWidget () {
        return driver.findElement(By.xpath("//*[@id='hs_query_info']/div[4]"));
    }
    public WebElement getmapWidget () {
        return driver.findElement(By.id("hotspot_map_info"));
    }
    public WebElement getpoiCountWidget () {
        return driver.findElement(By.id("hotspot_total_poi_count"));
    }
    public WebElement getattributePresenceWidget () {
        return driver.findElement(By.id("hotspot_attribute_completeness"));
    }

    public WebElement getdistanceAnalysisWidget () {
        return driver.findElement(By.id("hotspot_distance_analysis"));
    }

    public WebElement getbayesianScoreWidget() {
        return driver.findElement(By.id("bayesian_average"));
    }

    public WebElement getdistributionPerProviderWidget() {
        return driver.findElement(By.id("hotspot_category_distribution_per_provider"));
    }

    public WebElement getdistributionWidget() {
        return driver.findElement(By.id("category_distribution_per_provider"));
    }

    public WebElement mostFrequentWidget() {
        return driver.findElement(By.id("raw_category_frequency"));
    }

    public WebElement reviewDistributionWidget() {
        return driver.findElement(By.id("review_distribution"));
    }

    public WebElement photoDistributionWidget() {
        return driver.findElement(By.id("photo_distribution"));
    }
}
