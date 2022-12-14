package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.ui.backend.reportingmodule.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportingModuleRunner extends TestBase {

    AdminLoginPage adminLoginPage;
    ProductsOrderedReportPage productsOrderedReportPage;
    ProductsMostViewedReportPage productsMostViewedReportPage;
    ProductsLowStockReportPage productsLowStockReportPage;
    SeeProductsCartsReportPage seeProductsCartsReportPage;
    SeeProductsLowStockReportsAbide seeProductsLowStockReportsAbide;
    SeeSaleTotalShippedReport seeSaleTotalShippedReport;
    SeeSalesTotalRefundedReport seeSalesTotalRefundedReport;

SeeProductReviews seeProductReviews;
    @BeforeClass
    public void setUp(ITestContext context) {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
    }

    @Test(description = "Zulhumar")
    public void SeeCustomerNewAccountReport() throws InterruptedException {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        SeeCustomersNewAccountReport seeCustomersNewAccountReport = new SeeCustomersNewAccountReport(driver);
        seeCustomersNewAccountReport.OpenCustomersNewAccountReportPage();
        seeCustomersNewAccountReport.ShowNewAccountReportMethod(
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "startDate"),
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "endDate"));
        Assert.assertTrue(seeCustomersNewAccountReport.verifyReportsDisplayed());
    }

    @Test(description = "Zulhumar")
    public void SeeCustomerByOrderTotalReport() throws InterruptedException {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        SeeCustomerByOrdersTotalReport seeCustomerByOrdersTotalReport = new SeeCustomerByOrdersTotalReport(driver);
        seeCustomerByOrdersTotalReport.OpenCustomerByOrdersTotalReportPage();
        seeCustomerByOrdersTotalReport.ShowCustomersByOrdersTotalReportMethod(ApplicationConfig.readFromConfigProperties(
                        "config.properties", "startDate1"),
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "endDate1"));
        Assert.assertTrue(seeCustomerByOrdersTotalReport.verifyReportsDisplayed());
    }

    @Test(description = "Zulhumar")
    public void SeeCustomerByNumberOfOrder() throws InterruptedException {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        SeeCustomerByNumberOfOrders seeCustomerByNumberOfOrders = new SeeCustomerByNumberOfOrders(driver);
        seeCustomerByNumberOfOrders.OpenCustomerByNumberOfOrdersPage();
        seeCustomerByNumberOfOrders.ShowCustomersByNumberOfOrdersReportMethod(
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "startDate2"),
                ApplicationConfig.readFromConfigProperties(
                        "config.properties", "endDate2"));
        Assert.assertTrue(seeCustomerByNumberOfOrders.verifyReportsDisplayed());
    }
    @Test(description = "Zulhumar")
    public void SeeProductReviewsReport() throws InterruptedException {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
seeProductReviews=new SeeProductReviews(driver);
seeProductReviews.seeProductReviewsMethod();
        Assert.assertTrue(seeProductReviews.verifyReviewsDisplayed());
    }
    @Test(description = "Gvlmihre")
    public void viewProductsOrderedReportMethod() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        productsOrderedReportPage = new ProductsOrderedReportPage(driver);
        productsOrderedReportPage.viewProductsOrderedReport("01/01/2020", "01/01/2022");
        Assert.assertTrue(productsOrderedReportPage.verifyProductsOrderedReportDisplayed());
    }

    @Test(description = "Gvlmihre")
    public void viewProductsMostViewedReportMethod() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        productsMostViewedReportPage = new ProductsMostViewedReportPage(driver);
        productsMostViewedReportPage.viewProductsMostViewedReport("1/1/2020", "1/1/2022");
        Assert.assertTrue(productsMostViewedReportPage.verifyProductsMostViewedReportDisplayed());
    }

    @Test(description = "Gvlmihre")
    public void viewProductsLowStockReportMethod() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        productsLowStockReportPage = new ProductsLowStockReportPage(driver);
        productsLowStockReportPage.viewProductsLowStockReport();
        Assert.assertTrue(productsLowStockReportPage.verifyProductsLowStockReportDisplayed());

    }
    @Test(description = "SeeProductsCartsReport-Faruk")
    public void SeeProductsCartsReportPage(){
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        seeProductsCartsReportPage=new SeeProductsCartsReportPage(driver);
        seeProductsCartsReportPage.clickReportButton();
        seeProductsCartsReportPage.clickShoppingCartsButton();
        seeProductsCartsReportPage.clickProductInCartsButton();
        seeProductsCartsReportPage.clickExportButton();
        Assert.assertTrue(seeProductsCartsReportPage.VerifyMassageDisplay());
    }


    @Test(description = "see products low stock level --Abide")
    public void setSeeProductsLosStockLevel(){
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        seeProductsLowStockReportsAbide=new SeeProductsLowStockReportsAbide(driver);
        seeProductsLowStockReportsAbide.canSeeProductLowStockReports();
        Assert.assertTrue(seeProductsLowStockReportsAbide.verifyReportingViewedSuccessfully());
    }
    

    @Test (description = "Kadirya")
    public void SeeSaleTotalShippedReport(){
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        seeSaleTotalShippedReport=new SeeSaleTotalShippedReport(driver);
        seeSaleTotalShippedReport.SeeShippedReport("06/11/2020", "05/8/2022");
        Assert.assertTrue(seeSaleTotalShippedReport.verifyReportsDisplayed());


    }

    @Test(description = "Kadirya")
    public void SeeSalesTotalRefundedReport(){
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        seeSalesTotalRefundedReport=new SeeSalesTotalRefundedReport(driver);
        seeSalesTotalRefundedReport.OpenRefundedReportPage();
        seeSalesTotalRefundedReport.SeeRefundedReport("04/23/2022","07/25/2022");
        Assert.assertTrue(seeSalesTotalRefundedReport.verifyReportsDisplayed());
    }






    @AfterMethod
    public void logOut() {
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogout();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }


}


