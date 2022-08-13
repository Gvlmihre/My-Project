package regression.apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PayLoadUtility extends TestBase {

    TestUtility testUtility;
    WebDriver driver;

    public PayLoadUtility(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

     public String getCustomerPayLoad
             (int attribute_id, int entity_id, int entity_type_id, int id, String value){
         String payLoad=null;
         testUtility=new TestUtility(driver);
         CustomerPayload customerPayload=new CustomerPayload(
                 attribute_id+testUtility.generateRandomNumber(),
                 entity_id+testUtility.generateRandomNumber(),
                 entity_type_id+testUtility.generateRandomNumber(),
                 id+testUtility.generateRandomNumbersGvlmihre(),
                 value+testUtility.generateRandomLetter());

         ObjectMapper objectMapper=new ObjectMapper();
         try {
             payLoad=objectMapper.writeValueAsString(customerPayload);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
         System.out.println(payLoad);
         return payLoad;
     }
}
