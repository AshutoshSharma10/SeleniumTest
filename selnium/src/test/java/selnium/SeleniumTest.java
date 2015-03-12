package selnium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.thoughtworks.selenium.SeleneseTestCase;
public class SeleniumTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		Server.startSeleniumServer();
		super.setUp("http://www.google.com/", "*firefox");
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testNew() throws Exception {
		System.out.println("In testNew Method");
		selenium.open("/");
		selenium.type("q", "selenium rc");
		selenium.click("btnG");
		//selenium.waitForPageToLoad("3000");
		assertTrue(!selenium.isTextPresent("Selenium Remote-Control"));
		System.out.println("Out testNew Method");
	}
	@SuppressWarnings("deprecation")
	@After
    public void tearDown() {
		Server.stopSeleniumServer(selenium);
        System.out.println("@After - tearDown");
    }
}