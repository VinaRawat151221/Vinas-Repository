package restAssuredTest;

import org.testng.annotations.Test;
import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Get_Request {

	@Test(priority = 1)
	public void getAPIResponse() {
		given()
		.when()
			.get("https://api.coindesk.com/v1/bpi/currentprice.json")
		.then()
			.statusCode(200)
			.log().all();			
	}
	
	@Test(priority = 2)
	public void validateAPIResponse() {
		given()
		.when()
			.get("https://api.coindesk.com/v1/bpi/currentprice.json")
		.then()
			.body("bpi.USD.code", equalTo("USD"))
            .body("bpi.GBP.code", equalTo("GBP")) 
            .body("bpi.EUR.code", equalTo("EUR"));
			
	}
	
	@Test(priority = 3)
	public void validateAPIResponse1() {
		given()
		.when()
			.get("https://api.coindesk.com/v1/bpi/currentprice.json")
		.then()
			.body("bpi.GBP.description", equalTo("British Pound Sterling"));
	}
}
