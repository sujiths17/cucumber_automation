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
    public void i_am_logged_in_as_an_admin() {
        if (!isLoggedIn) { issuer.login("admin", "admin@123"); isLoggedIn = true; }
    }

    @Given("I navigate to the Create Issuer page")
    public void i_navigate_to_the_create_issuer_page() {
        if (!isIssuerIn) { issuer.IssuerModule(); isIssuerIn = true; }
    }

    @Given("I fill in the other required fields with valid data")
    public void i_fill_in_the_other_required_fields_with_valid_data() throws InterruptedException {
        Thread.sleep(1000);
        String[] xpath = {"issuer_name","institutionid", "routingnumber", "card_production_required", "card_production_issuer_id", "tie_extrct_to_business_date", "protect_sensitive_data"};
        String[] inputs = {"cat","12349 ", "120578 ", "true", "4528163 ", "true", "Yes"};
        issuer.fillFields(inputs,xpath,obj,"");
    }

    @When("I fill in the Issuer Name field with ExistingIssuerName")
    public void i_fill_in_the_issuer_name_field_with_existing_issuer_name() throws InterruptedException {
        Thread.sleep(1000);
        issuer.FieldName("Issuer","xyt");
    }

    @When("I click the Submit button")
    public void i_click_the_submit_button() {
        issuer.Submit();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        issuer.handleAlert(obj);
    }

    @When("I give in the Institution Id field with Existing_Institution Id")
    public void i_give_in_the_institution_id_field_with_existing_institution_id() {
        issuer.FieldName("Institution ID","123011");
    }

    @Given("I fill the all required fields in New Issuer Page with valid data")
    public void i_fill_the_all_required_fields_in_new_issuer_page_with_valid_data() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/div/form/div[17]/div/table/tbody/tr/td[4]/button";
        String[] xpath = {"issuer_name","institutionid", "routingnumber", "card_production_required", "card_production_issuer_id", "tie_extrct_to_business_date", "protect_sensitive_data"};
        String[] inputs = {"cat","12349 ", "120578 ", "true", "4528163 ", "true", "Yes"};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Secure Pin Page with valid data")
    public void i_fill_the_all_required_fields_in_secure_pin_page_with_valid_data() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/div/form/div[12]/div/table/tbody/tr/td[4]/button";
        String[] inputs = {"5 ", "true", "0030 ", "CMS_KWP", "Indian Rupee", "true", "20 ", "20 "};
        String[] xpath = {"max_pin_tries", "pickup_pin_tries_exceeded", "pin_try_count_reset_time", "pin_export_key", "velocity_currency_code", "reserve_credit_preauths", "card_activity_ret_period", "add_card_data_ret_period"};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Card Mailer Return Address Page with valid data")
    public void i_fill_the_all_required_fields_in_card_mailer_return_address_page_with_valid_data() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/div/form/div[8]/div/table/tbody/tr/td[4]/button";
        String[] inputs = {"abcvilla", "abcvillaz", "jamnagar ", "gujarath ", "68205 ", "India"};
        String[] xpath = {"pin_mailer_return_address_1", "pin_mailer_return_address_2", "pin_mailer_return_city", "pin_mailer_return_region", "pin_mailer_return_postal", "pin_mailer_return_country"};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Business Address Page with valid data")
    public void i_fill_the_all_required_fields_in_business_address_page_with_valid_data() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/form/table/tbody/tr[14]/td[4]/button";
        String[] inputs = {"test", "abcd", "kochi ", "kerala ", "682000 ", "India", "9845872857"};
        String[] xpath = {"card_mailer_return_addr_1", "card_mailer_return_addr_2", "card_mailer_return_city", "card_mailer_return_region", "card_mailer_return_postal", "card_mailer_return_country", "card_mailer_return_tel_nr"};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in PIN Mailer Return Address Page with valid data")
    public void i_fill_the_all_required_fields_in_pin_mailer_return_address_page_with_valid_data() throws InterruptedException {
        String Button ="/html/body/div/div/section/div/div/form/table/tbody/tr[10]/td[4]/button";
        String v = "/html/body/div/div/section/div/div/form/table/tbody/tr[8]/td[2]/input";
        String[] inputs = {"test", "abcd", "kochi ", "kerala ", "682000 ", "India", "212121"};
        String[] xpath = {"pin_mailer_return_address_1", "pin_mailer_return_address_2", "pin_mailer_return_city", "pin_mailer_return_region", "pin_mailer_return_postal", "pin_mailer_return_country", v};
        issuer.fillFields(inputs,xpath,obj,Button);
    }

    @Given("I fill the all required fields in Contact Page with valid data")
    public void i_fill_the_all_required_fields_in_contact_page_with_valid_data() throws InterruptedException {
        String[] inputs = {"hallo ", "manager", "7891234560 ", "1224455 ", "123788788 ", "sadish@gmail.com", "abxd", "abcd", "kochi ", "kerala ", "68500 ", "India", "ACTIVE"};
        String[] xpath = {"contact_name", "contact_job_title", "contact_tel_nr", "contact_fax_nr", "contact_mobile_nr", "contact_email_address", "contact_address_1", "contact_address_2", "contact_city", "contact_region", "contact_postal_code", "contact_country", "issuer_status"};
        issuer.fillFields(inputs,xpath,obj,"");
    }

    @When("I click the Finish button")
    public void i_click_the_finish_button() {
        issuer.Create();
    }

    @Then("I should redirected into an successful page")
    public void i_should_redirected_into_an_successful_page() {
        issuer.finish(obj);
    }


}
