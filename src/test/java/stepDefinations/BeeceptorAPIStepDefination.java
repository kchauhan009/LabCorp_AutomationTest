package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.TestSetup;

public class BeeceptorAPIStepDefination {

	TestSetup testSetup;

	public BeeceptorAPIStepDefination(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}

	@Given("^User get beeceptor information and validated Path IP and all headers$")
	public void beeceptor_information(DataTable table) throws IOException {

		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
		//for (Map<String, String> columns : rows){
		//columns.get("");
		//}

		RestAssured.baseURI = testSetup.basePage.getPropertiesFileData().getProperty("apiBaseURL");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		Response response = request.get(testSetup.basePage.getPropertiesFileData().getProperty("path"));
		
		System.out.println("API Information :");
		System.out.println(response.asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.jsonPath().getString("path"), rows.get(0).get("Path"));
		Assert.assertTrue(response.jsonPath().getString("ip").contains(rows.get(0).get("IP")));

		Map<String, String> headers = JsonPath.from(response.asString()).get("headers");

		Assert.assertEquals(headers.get("Host"), rows.get(0).get("Host"));
		Assert.assertEquals(headers.get("User-Agent"), rows.get(0).get("User-Agent"));
		Assert.assertEquals(headers.get("Accept"), rows.get(0).get("Accept"));
		Assert.assertEquals(headers.get("Accept-Encoding"), rows.get(0).get("Accept-Encoding"));
		//Assert.assertEquals(headers.get("Cache-Control"), rows.get(0).get("Cache-Control"));
		//Assert.assertEquals(headers.get("Content-Type"), rows.get(0).get("Content-Type"));
		//Assert.assertEquals(headers.get("Postman-Token"), rows.get(0).get("Postman-Token"));
	}
	
	
	@Given("Customer information addition and verification")
	public void addCustomerInformation() throws IOException{
		
		RestAssured.baseURI = testSetup.basePage.getPropertiesFileData().getProperty("apiBaseURL");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		request.body(testSetup.basePage.getTestData());
		Response response = request.post(testSetup.basePage.getPropertiesFileData().getProperty("path"));
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Customer Information :");
		System.out.println(response.asString());
		
		JsonPath actData = new JsonPath(response.asString());
		JsonPath expData = new JsonPath(testSetup.basePage.getTestData());

		Assert.assertEquals(actData.getString("parsedBody.customer.name"), expData.getString("customer.name"));
		Assert.assertEquals(actData.getString("parsedBody.customer.email"), expData.getString("customer.email"));
		Assert.assertEquals(actData.getString("parsedBody.customer.address.city"), expData.getString("customer.address.city"));
		Assert.assertEquals(actData.getString("parsedBody.payment.method"), expData.getString("payment.method"));
		Assert.assertEquals(actData.getString("parsedBody.payment.transaction_id"), expData.getString("payment.transaction_id"));
		Assert.assertEquals(actData.getString("parsedBody.items.product_id[1]"), expData.getString("items.product_id[1]"));
		Assert.assertEquals(actData.getString("parsedBody.items.name[1]"), expData.getString("items.name[1]"));
	}
}
