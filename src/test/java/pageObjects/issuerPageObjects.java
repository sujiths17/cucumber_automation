package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class issuerPageObjects {
    private WebDriver obj;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"heroCarousel\"]/div/div/div/div/form/div/div/div/div/div[1]/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath ="/html/body/div/div/section/div/div/div/form/div[15]/div/table/tbody/tr/td[4]/button")
    private WebElement create;
    @FindBy(xpath = "//*[@id=\"heroCarousel\"]/div/div/div/div/form/div/div/div/div/div[1]/div[3]")
    private WebElement loginButton;
    @FindBy(name = "issuer_name")
    private WebElement issuerName;
    @FindBy(name = "institutionid")
    private WebElement InstID;
    @FindBy(name = "routingnumber")
    private WebElement RID;
    public static final String base_url="//*[@id=\"about\"]/div/div";
    public static final String issuer =base_url+"/div[1]/a[1]";
    @FindBy(xpath = issuer)
    private WebElement issuerModule;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/div/form/div[17]/div/table/tbody/tr/td[4]/button")
    private WebElement Next;

    private WebElement findElement(WebDriver obj, String locator) {
        return locator.contains("/") || locator.contains("@") || locator.contains("#")
                ? obj.findElement(By.xpath(locator))
                : obj.findElement(By.name(locator));
    }

    private String getElementType(WebElement element) {
        return element.getAttribute("type");
    }


    public issuerPageObjects(WebDriver obj) {
        this.obj = obj;
        PageFactory.initElements(obj, this);
    }
    public void login(String username, String password) {

        obj.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        obj.manage().window().maximize();
        obj.get("http://localhost:5050/APT_KRAYAM_v2.0.02.build240730/Login.jsp");

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();

    }
    public void IssuerModule(){
        issuerModule.click();
    }

    public void FieldName(String FieldName,String InputElement){
        if(FieldName.equals("Issuer")){issuerName.clear(); issuerName.sendKeys(InputElement);}
        else if (FieldName.equals("Institution ID")) {InstID.clear();InstID.sendKeys(InputElement);}
        else {RID.clear();RID.sendKeys(InputElement);}

    }


    public  void fillFields(String[] inputs, String[] xpath, WebDriver obj,String nxt) throws InterruptedException {
        if (inputs.length != xpath.length) {
            System.out.println("Arrays 'inputs' and 'xpath' must have the same size for creating the dictionary.");
            return;
        }

        for (int i = 0; i < inputs.length; i++) {
            WebElement element = findElement(obj, xpath[i]);

            String elementType = getElementType(element);

            if ("select".equals(elementType)) {
                new Select(element).selectByVisibleText(inputs[i]);
            } else {
                if (!"checkbox".equals(elementType)) {
                    element.sendKeys(inputs[i]);
                } else {
                    JavascriptExecutor executor = (JavascriptExecutor) obj;
                    executor.executeScript("arguments[0].click();", obj.findElement(By.name(xpath[i])));
                }
            }
        }

        if (!nxt.isEmpty()) {
            obj.findElement(By.xpath(nxt)).click();
        }
    }

    public void Submit(){
        Next.click();
    }

    public void Create(){
        create.click();
    }

    public void finish( WebDriver obj){
        String currentUrl = obj.getCurrentUrl();
        assertTrue(currentUrl.contains("issuer_success.jsp")); //"Issuer Created Successfully!!! "
    }

    public  void handleAlert(WebDriver obj) {
        try {
            WebDriverWait wait1 = new WebDriverWait(obj, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.alertIsPresent());
            Alert x = obj.switchTo().alert();
            String message =x.getText();
            Thread.sleep(60);
            x.accept();
            Thread.sleep(60);
            System.out.println(message);
            assertFalse(message.isEmpty());
            if (!message.isEmpty()){
                System.out.println("Test Passed");

            }else{
                System.out.println("Test Failed");
            }


        } catch (Exception e) {
            System.out.println("No alert present.");

        }
    }

    public  void clearFields( String[] xpath, WebDriver obj) throws InterruptedException {

        for (int i = 0; i < xpath.length; i++) {
            WebElement Element = findElement(obj, xpath[i]);

            String elementType = getElementType(Element);


            if ("text".equals(elementType)) {

                WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(Element));
                    Element.click();
                } catch (Exception e) {
                    System.out.println(e);
                }
                }
            }
        }











    }
