	package StepDefinition;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;

public class Steps {

	@Given("^Open google chrome and launch the app$")				
    public void open_chrome_and_app() throws Throwable							
    {		
        System.out.println("This Step open the Crhome and launch the application at localhost4200");					
    }		

    @When("^Input all the atributes for the creation of a order$")					
    public void enter_Information() throws Throwable 							
    {		
       System.out.println("This step user enter info");					
    }		

    @Then("^Save the order with a random channel$")					
    public void save_info() throws Throwable 							
    {    		
        System.out.println("This step saves");					
    }		

}
