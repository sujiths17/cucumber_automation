package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.issuerPageObjects;

//import pages.CreateIssuerPage;


public class MyStepdefs {




    private static WebDriver obj;
    private issuerPageObjects issuer;
    private static boolean isLoggedIn = false;
    private static boolean isIssuerIn = false;


    @Before
    public void setUp() {
        if (obj == null  ) { obj = new ChromeDriver();}
        if (issuer == null ) { issuer = new issuerPageObjects(obj);}
    }

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        if (!isLoggedIn) { issuer.login("admin", "admin@123"); isLoggedIn = true; }
    }

    @And("I navigate to the Create Issuer page")
    public void iNavigateToTheCreateIssuerPage() {
        if (!isIssuerIn) { issuer.IssuerModule(); isIssuerIn = true; }
    }

    @And("I fill in the other required fields with valid data")
    public void iFillInTheOtherRequiredFieldsWithValidData() throws InterruptedException {
        Thread.sleep(1000);
        String[] xpath = {"issuer_name","institutionid", "routingnumber", "card_production_required", "card_production_issuer_id", "tie_extrct_to_business_date", "protect_sensitive_data"};
        String[] inputs = {"cat","12349 ", "120578 ", "true", "4528163 ", "true", "Yes"};
        issuer.fillFields(inputs,xpath,obj,"");
    }
    @When("I fill in the Issuer Name field with ExistingIssuerName")
    public void iFillInTheIssuerNameFieldWithExistingIssuerName() throws InterruptedException {
        Thread.sleep(1000);
        issuer.FieldName("Issuer","xyt");
    }

    @And("I click the Submit button")
    public void iClickTheSubmitButton() {
        issuer.Submit();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() throws InterruptedException {
        issuer.handleAlert(obj);
        Thread.sleep(1000);
        obj.findElement(By.name("routingnumber")).clear();

    }


    @When("I give in the Institution Id field with Existing_Institution Id")
    public void iGiveInTheInstitutionIdFieldWithExisting_InstitutionId() {
        issuer.FieldName("Institution ID","123011");
    }



//    @When("I give in the Routing and Transit Id field with Existing_Routing and Transit Id")
//    public void iGiveInTheRoutingAndTransitIdFieldWithExisting_RoutingAndTransitId() {
//        issuer.FieldName("Routing and Transit Id","123011");
//
//
//    }


    @Given("I fill the all required fields in New Issuer Page with valid data")
    public void iFillTheAllRequiredFieldsInNewIssuerPageWithValidData() throws InterruptedException {

        String Button ="/html/body/div/div/section/div/div/div/form/div[17]/div/table/tbody/tr/td[4]/button";
        String[] xpath = {"issuer_name","institutionid", "routingnumber", "card_production_required", "card_production_issuer_id", "tie_extrct_to_business_date", "protect_sensitive_data"};
        String[] inputs = {"cat","12349 ", "120578 ", "true", "4528163 ", "true", "Yes"};
//        String[] xpath1={"issuer_name","institutionid", "routingnumber", "card_production_issuer_id"};
//        issuer.clearFields(xpath1,obj);

        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Secure Pin Page with valid data")
    public void iFillTheAllRequiredFieldsInSecurePinPageWithValidData() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/div/form/div[12]/div/table/tbody/tr/td[4]/button";
        String[] inputs = {"5 ", "true", "0030 ", "CMS_KWP", "Indian Rupee", "true", "20 ", "20 "};
        String[] xpath = {"max_pin_tries", "pickup_pin_tries_exceeded", "pin_try_count_reset_time", "pin_export_key", "velocity_currency_code", "reserve_credit_preauths", "card_activity_ret_period", "add_card_data_ret_period"};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Card Mailer Return Address Page with valid data")
    public void iFillTheAllRequiredFieldsInCardMailerReturnAddressPageWithValidData() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/div/form/div[8]/div/table/tbody/tr/td[4]/button";
        String[] inputs = {"abcvilla", "abcvillaz", "jamnagar ", "gujarath ", "68205 ", "India"};
        String[] xpath = {"pin_mailer_return_address_1", "pin_mailer_return_address_2", "pin_mailer_return_city", "pin_mailer_return_region", "pin_mailer_return_postal", "pin_mailer_return_country"};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Business Address Page with valid data")
    public void iFillTheAllRequiredFieldsInBusinessAddressPageWithValidData() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/form/table/tbody/tr[14]/td[4]/button";
        String[] inputs = {"test", "abcd", "kochi ", "kerala ", "682000 ", "India", "9845872857"};
        String[] xpath = {"card_mailer_return_addr_1", "card_mailer_return_addr_2", "card_mailer_return_city", "card_mailer_return_region", "card_mailer_return_postal", "card_mailer_return_country", "card_mailer_return_tel_nr"};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in PIN Mailer Return Address Page with valid data")
    public void iFillTheAllRequiredFieldsInPINMailerReturnAddressPageWithValidData() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/form/table/tbody/tr[10]/td[4]/button";
        String v = "/html/body/div/div/section/div/div/form/table/tbody/tr[8]/td[2]/input";
        String[] inputs = {"test", "abcd", "kochi ", "kerala ", "682000 ", "India", "212121"};
        String[] xpath = {"pin_mailer_return_address_1", "pin_mailer_return_address_2", "pin_mailer_return_city", "pin_mailer_return_region", "pin_mailer_return_postal", "pin_mailer_return_country", v};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Contact Page with valid data")
    public void iFillTheAllRequiredFieldsInContactPageWithValidData() throws InterruptedException {
        String[] inputs = {"hallo ", "manager", "7891234560 ", "1224455 ", "123788788 ", "sadish@gmail.com", "abxd", "abcd", "kochi ", "kerala ", "68500 ", "India", "ACTIVE"};
        String[] xpath = {"contact_name", "contact_job_title", "contact_tel_nr", "contact_fax_nr", "contact_mobile_nr", "contact_email_address", "contact_address_1", "contact_address_2", "contact_city", "contact_region", "contact_postal_code", "contact_country", "issuer_status"};
        issuer.fillFields(inputs,xpath,obj,"");
    }

    @When("I click the Finish button")
    public void iClickTheFinishButton() {
        issuer.Create();
    }

    @Then("I should redirected into an successful page")
    public void iShouldRedirectedIntoAnSuccessfulPage() {
        issuer.finish(obj);
    }
}
