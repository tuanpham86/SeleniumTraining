package firsttestngpackage;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class ChronologicalView {
  @Test(priority = 3)
  public void c_test() {
	  Assert.fail();
  }
  
  @Test(priority = 0)
  public void a_test() {
	  Assert.assertTrue(true);
  }
  
  @Test(priority = 7)
  public void b_test() {
	  throw new SkipException("Skipping b_test...");
  }
}
