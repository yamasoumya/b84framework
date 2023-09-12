package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.BaseTest2a;

public class DemoTest2a extends BaseTest2a
{

	@Test
	public void testB()
	{
		Reporter.log(driver.getTitle(),true);
		Assert.fail();
	}
}

