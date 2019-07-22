package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.LoginTest;
import test.Test2;


@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class,
	Test2.class
})
public class TestSuite {
}
