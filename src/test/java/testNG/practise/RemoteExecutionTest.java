package testNG.practise;

//import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteExecutionTest {
	RemoteWebDriver driver;
	public void remoteExecutionTest() throws Throwable
	{
		URL url=new URL("http://192.168.200.1:4444/wd/hub");
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(url, dc);
		driver.get("https://github.com/");
	}

}
