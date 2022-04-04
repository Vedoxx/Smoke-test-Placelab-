package placelab.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import placelab.pages.*;
import placelab.utilities.WebDriverSetup;


public class SmokeTest {
    public WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    public String host = System.getProperty("host");
    public String user = System.getProperty("user");
    private String username = System.getProperty("username");
    private String password = System.getProperty("password");
    private String homePageUrl = System.getProperty("homePage");
    private String hotspotURL = System.getProperty("hotspotURL");
    private String reportUrl = System.getProperty("report");
    private String reportName = System.getProperty("reportName");
    private String hotspotArea=System.getProperty("hotspotArea");
    private Login login;
    private HomePage homePage;
    private MakeReport makeReport;
    private Reports reports;
    private ReportInformation reportInformation;


    @Parameters({"browser"})


    @BeforeSuite(alwaysRun = true)
    public void openApp(String browser) {
        //init Driver
        driver = WebDriverSetup.getWebDriver(browser);
        login = new Login(driver);
        homePage = new HomePage(driver);
        makeReport=new MakeReport(driver);
        reportInformation=new ReportInformation(driver);
        reports=new Reports(driver);

    }
    @BeforeTest(alwaysRun = true, description = "Verify that user  can access Placelab app")
    public void loginToPlaceLab() {
        driver.navigate().to(host);
        login.verifyLoginPage(host);
    }
    @Test(priority = 1, groups = {"Positive"}, description = "Verify that user can log in to Placelab app with valid credentials", suiteName = "Smoke Test")
    public void LoginPlacelab(){
        login.verifyLoginPage(host);
        login.enterUsername(username);
        login.enterPassword(password);
        login.submit();
        //check the url of the page
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
        //check the username
        softAssert.assertEquals(homePage.getUserName(),user);
        //check the user role
        Assert.assertEquals(homePage.getUserRole(),"Group Admin");
    }
    @Test(priority = 2, groups = {"Positive"}, description = "Verify that user is on hotspot area analysis site", suiteName = "Smoke Test")
    public void accesHotspotAreaAnalysis ()  {
        homePage.selectHotspotAreaAnalysis();
        //check the url of the page
        Assert.assertEquals(driver.getCurrentUrl(), hotspotArea,"User is not on the right page");
        //check the header
        softAssert.assertEquals(makeReport.getHeader(),"my_locationCreate Hotspot Area Analysis Report","header is not right");
        //check the input forms of the page
        assert (makeReport.getReportName().isDisplayed()):"Report name field is not displayed.";
        assert(makeReport.getLocation().isDisplayed()):"Location field is not displayed";
        assert(makeReport.getLatitude().isDisplayed()):"Latitude field is not displayed";
        assert(makeReport.getLongitude().isDisplayed()):"Longitude field is not displayed";
        assert(makeReport.getRadius().isDisplayed()):"Radius field is not displayed";
        assert(makeReport.getReportButton().isDisplayed()):"Report button is not displayed";

    }
    @Test(priority = 3, groups = {"Positive"}, description = "Verify that user can create a hotspot analysis report", suiteName = "Smoke Test")
    public void createHotspotAreaAnalysis() throws InterruptedException {
    makeReport.setReportName();
    makeReport.setCategory();
    makeReport.setLocation();
    makeReport.setLatitude();
    makeReport.setLongitude();
    makeReport.createReport();
    }
    @Test (priority = 4, groups = {"Positive"}, description = "Validate that the Hotspot Area report was created",suiteName = "Smoke Test")
     public void checkReport() throws InterruptedException {
        Thread.sleep(35000);
        //check the url
        Assert.assertEquals(driver.getCurrentUrl(), reportUrl, "Wrong URL");
        reports.clickOnTheReport();
        //check the widgets
        assert(reportInformation.getmapWidget().isDisplayed()):"Map widget is not displayed";
        assert (reportInformation.getpoiCountWidget()).isDisplayed():"POI count widget is not displayed";
        assert(reportInformation.getdistanceAnalysisWidget().isDisplayed()):"Distance analysis widget is not displayed";
        assert(reportInformation.getattributePresenceWidget().isDisplayed()):"Attribute presence is not displayed";
        assert(reportInformation.getbayesianScoreWidget().isDisplayed()):"Bayesian score widget is not displayed";
        assert(reportInformation.getdistributionPerProviderWidget().isDisplayed()):"Distribution per Provider widget is not displayed";
        assert(reportInformation.getdistributionWidget().isDisplayed()):"Distribution widget is not displayed";
        assert(reportInformation.mostFrequentWidget().isDisplayed()):"Most Frequent categories widget is not displayed.";
        assert(reportInformation.reviewDistributionWidget().isDisplayed()):"Review Distribution widget is not displayed";
        assert (reportInformation.photoDistributionWidget().isDisplayed()):"Photo Distribution widget is not displayed";

    }
    @AfterTest (alwaysRun = true, groups = {"Positive"}, description = "Delete created Hotspot Area report")
    public void deleteHotspotAreaReport(){
        driver.navigate().to(reportUrl);
        //check the Url
        Assert.assertEquals(driver.getCurrentUrl(),reportUrl,"Wrong Url");
        reports.clickOnCheckBox();
        reports.deleteReport();
        reports.confirmDelete();
       softAssert.assertEquals(reports.deleteMessage().isDisplayed(),"Message is not displayed");
        homePage.signOut();

    }
    @AfterSuite(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}
