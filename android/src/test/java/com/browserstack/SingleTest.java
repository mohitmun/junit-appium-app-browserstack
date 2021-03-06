package com.browserstack;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingleTest extends BrowserStackJUnitTest {

  @Test
  public void test() throws Exception {
    AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
    searchElement.click();
    AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
    insertTextElement.sendKeys("BrowserStack");
    Thread.sleep(5000);

    List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
    assertTrue(allProductsName.size() > 0);
  }
}
