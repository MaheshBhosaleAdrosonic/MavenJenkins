package Maven_Cucumber.mcucumber;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestImplimentation {

	TestStepDefinition objTestStepDefinition = new TestStepDefinition();

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		System.out.println("success message is displayed");
		objTestStepDefinition.verifyHomePageIsDisplayed();
		System.out.println("Hi");
	}

	@Given("^I open my application$")
	public void i_open_my_application() throws Throwable {
		System.out.println("Home Page Opened...");
		objTestStepDefinition.initializeEnvirnoment();
		objTestStepDefinition.openURLInBrowser();
	}

	@When("^I login with the following data$")
	public void i_login_with_the_following_data(DataTable dt) throws Throwable {
		System.out.println("Enter Username and Password");
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		System.out.println(list.get(0).get("UserName"));
		System.out.println(list.get(0).get("Password"));
		objTestStepDefinition.loginIntoApplication(list.get(0).get("UserName"), list.get(0).get("Password"));
	}

	@Then("^Check home page is displayed$")
	public void check_home_page_is_displayed() throws Throwable {
		objTestStepDefinition.verifyHomePageIsDisplayed();
	//	objTestStepDefinition.tearDownEnvirnoment();
		System.out.println("Close browser...");
	}

	@Given("^product Is Displayed$")
	public void product_Is_Displayed() throws Throwable {
		System.out.println("Product Is Displayed ");
	}

	@When("^product Add Into Cart as \"([^\"]*)\"$")
	public void product_Add_Into_Cart_as(String element) throws Throwable {
		System.out.println("Product Add To cart");
		objTestStepDefinition.productAddIntoCartInApplication(element);
	}

	@Then("^Check Product Added Into Cart$")
	public void check_Product_Added_Into_Cart() throws Throwable {
		System.out.println("View Product is Added to the Cart");
		objTestStepDefinition.viewTheCart();
		objTestStepDefinition.tearDownEnvirnoment();
	}
	
	@Given("^Progress Note Page Display$")
	public void progress_Note_Page_Display() throws Throwable {
	   System.out.println("Progress Note Page Display");
	}

	@When("^Treatement Page Open$")
	public void treatement_Page_Open() throws Throwable {
		 System.out.println("Treatement Page Open");
	}
	
	@Then("^Check Lab Added$")
	public void check_Lab_Added() throws Throwable {
		 System.out.println("Check Lab Added");
	}

}
