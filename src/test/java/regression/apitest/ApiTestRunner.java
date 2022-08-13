package regression.apitest;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTestRunner {

    WebDriver driver;

    private  String baseURL;
    private  String port;
    private  String username;
    private  String password;
    private  String configFile = "config.properties";

    @BeforeClass
    public void setup() {
        baseURL = ApplicationConfig.readFromConfigProperties(configFile, "api.baseURL");
        username = ApplicationConfig.readFromConfigProperties(configFile, "api.userName");
        password = ApplicationConfig.readFromConfigProperties(configFile, "api.password");
        port = ApplicationConfig.readFromConfigProperties(configFile, "api.port");
    }

    @Test
    public void getOneCustomerTest( ) {
        //Sending request to get respone
        Response response = RestAssured.given().auth().basic(username, password)
                .when().get(baseURL + ":" + port + "/customer/"+"15");
        System.out.println(response.getBody().prettyPrint());
        //check the status code
        int responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode,200);
    }

    @Test
    public void postCustomer(){
        PayLoadUtility payLoadUtility=new PayLoadUtility(driver);
        Response response=RestAssured.given().headers("Content-Type","application/json").and().
            body(payLoadUtility.getCustomerPayLoad(4,4,4,4,"Team4Test")).
            auth().basic(username,password).
            when().post(baseURL+":"+port+"/customer").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
        org.junit.Assert.assertEquals(200,response.getStatusCode());
        org.junit.Assert.assertTrue(response.jsonPath().getString("value").contains("Team4Test"));
    }


}
