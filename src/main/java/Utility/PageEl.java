package Utility;

import base.PageDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PageEl {

    public WebElement webelement;
    private final By ElementLocator;
    int timeOut = 6;
    int index = 0;
    //public static WebDriver webdriver = ThreadLocalWebdriver.getDriver();
    //int timeOut = Integer.parseInt(XMLReader.getTimeOut());
    //String platform = ((String) ((RemoteWebDriver) ThreadLocalWebdriver.getDriver()).getCapabilities().getCapability("platformName")).toUpperCase();

    public PageEl(By locator) {
        ElementLocator = locator;
    }

    public WebElement Element() {
        try {
            if (index == 0) {
                return new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(timeOut))
                        .until(ExpectedConditions.presenceOfElementLocated(ElementLocator));
            } else {
                return new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(timeOut))
                        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(ElementLocator)).get(index);
            }
        } catch (Exception e) {
            throw new java.util.NoSuchElementException("Element not found - " + e.getMessage());
        }
    }

    public List<WebElement> Elements() {
        try {
            return new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(ElementLocator));
        } catch (Exception e) {
            throw new java.util.NoSuchElementException("Element not found - " + e.getMessage());
        }
    }

    /*public WebElement Element() {
        if (index == 0) {
            try {
                webelement = base.PageDriver.getDriver().findElement(ElementLocator);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                IsElementPresent(timeOut);
                webelement = base.PageDriver.getDriver().findElement(ElementLocator);
            }
        } else {
            try {
                webelement = base.PageDriver.getDriver().findElements(ElementLocator).get(index);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                IsElementPresent(timeOut);
                webelement = base.PageDriver.getDriver().findElements(ElementLocator).get(index);
            }
        }
        return webelement;
    }

    public List<WebElement> Elements() {
        try {
            return base.PageDriver.getDriver().findElements(ElementLocator);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            IsElementPresent(timeOut);
            return base.PageDriver.getDriver().findElements(ElementLocator);
        }
    }*/

    public Boolean IsElementPresent(int timeOut) {
        try {
            new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(timeOut)).until(ExpectedConditions.presenceOfElementLocated(ElementLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean IsElementPresent(int timeOut, String locatorName) throws IOException {
        try {
            new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(timeOut)).until(ExpectedConditions.presenceOfElementLocated(ElementLocator));
            System.out.println("Element is present on the screen --> " + locatorName + " and waited for " + timeOut);
            return true;
        } catch (Exception e) {
            System.out.println("Element is not present on the screen --> " + locatorName + " and waited for " + timeOut);
            return false;
        }
    }

    public void waitForElement(int timeOut) {
        new WebDriverWait(PageDriver.getDriver(), timeOut).until(ExpectedConditions.presenceOfElementLocated(ElementLocator));
    }

    public void waitForElement(int timeOut, String locatorName) {
        new WebDriverWait(PageDriver.getDriver(), timeOut).until(ExpectedConditions.presenceOfElementLocated(ElementLocator));
        System.out.println("Waited " + timeOut + " for element " + locatorName);
    }

    public void click() {
        try {
            Element().click();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            IsElementClickable(timeOut);
            Element().click();
        }
    }

    public void click(String locatorName) {
        try {
            Element().click();
            System.out.println("Clicked on --> " + locatorName);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            IsElementClickable(timeOut);
            Element().click();

        }

    }


    public void sendKeys(String text) {
        try {

            Element().clear();
            Element().sendKeys(text);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            IsElementClickable(timeOut);
            Element().clear();
            Element().sendKeys(text);
        }
    }

    /*public void pickerSendKeys(String text) {
        try {
            Element().sendKeys(text);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            IsElementClickable(timeOut);
            Element().sendKeys(text);
        }
    }*/

    public void sendKeys(String text, String locatorName) {
        try {
            Element().clear();
            //Log.info("Cleared text for the field --> " + locatorName, true);
            Element().sendKeys(text);
            System.out.println("Sent value i.e " + text + " to the field --> " + locatorName);
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            System.out.println("Inside Catch block");
            IsElementClickable(timeOut);
            Element().clear();
            //Log.info("Cleared text for the field --> " + locatorName, true);
            Element().sendKeys(text);
            System.out.println("Sent value i.e " + text + " to the field --> " + locatorName);
        }
    }

    public boolean IsElementClickable(int timeOut) {
        try {
            new WebDriverWait(PageDriver.getDriver(), timeOut)
                    .until(ExpectedConditions.elementToBeClickable(ElementLocator));
            return true;
        } catch (Exception e) {
            System.out.println("Element is not clickable " + e.getMessage());
            return false;
        }
    }

    /*public void doubleClick(String locatorName) {
        if (IsElementClickable(timeOut)) {
            new Actions(ThreadLocalWebdriver.getDriver()).doubleClick(Element()).build().perform();
            Log.info("Double clicked on " + locatorName);
        } else
            Log.warn("Double click not performed for" + locatorName);
    }*/

    public void clear() {
        Element().clear();
    }

    public void clear(String locatorName) {
        Element().clear();
        System.out.println("Cleared text for the field --> " + locatorName);
    }

    public String getAttribute(String attribute) {
        return Element().getAttribute(attribute);
    }

    /*public String getText() {
        String value = "";
        //System.out.println("calling getText(), platform = " + platform);
        switch (platform) {
            case "ANDROID":
                value = Element().getText();
                break;
            case "IOS":
                value = Element().getAttribute("value");
                break;
        }
        return value;
    }

    public String getText(String locatorName) throws IOException {
        String value = "";
        try {

            switch (platform) {
                case "ANDROID":
                    value = Element().getText();
                    Log.info("Got text i.e " + value + " from the screen for --> " + locatorName, true);
                    break;
                case "IOS":
                    value = Element().getAttribute("value");
                    Log.info("Got text i.e " + value + " from the screen for --> " + locatorName, true);
                    break;
            }
        } catch (Exception e) {
            Log.fail("Not able to get the text for --> " + locatorName + e.getMessage());
        }
        return value;
    }

    public MobElement scrollDownIntoView() {
        int tries = 0;
        while (!IsElementPresent(1) && tries <= 20) {
            Util.scrollDown();
            tries++;
        }
        webelement = Element();
        return this;
    }

    public MobElement scrollDownIntoView(String elementText) {
        List<WebElement> newList = Elements();
        List<WebElement> oldList = null;
        int tries = 0;
        while (newList != oldList && tries <= 20 && newList.size() > 0) {
            for (WebElement e : newList) {
                switch (platform) {
                    case "ANDROID":
                        if ((e.getText().equals(elementText)) && (e.getAttribute("visible").equals("true"))) {
                            webelement = e;
                        }
                    case "IOS":
                        if ((e.getAttribute("value").equals(elementText)) && (e.getAttribute("visible").equals("true"))) {
                            webelement = e;
                        }
                }
            }
            oldList = newList;
            Util.scrollDown();
            newList = Elements();
            tries++;
        }
        if (webelement == null) {
            throw new ElementNotVisibleException("Could not find Element with the name " + elementText + "'");
        }
        return this;
    }

    public MobElement scrollUpIntoView() {
        int tries = 0;
        while (!IsElementPresent(1) && tries <= 20) {
            Util.scrollUp();
            tries++;
        }
        webelement = Element();
        return this;
    }

    public MobElement scrollUpIntoView(String elementText) {
        List<WebElement> newList = Elements();
        List<WebElement> oldList = null;
        int tries = 0;
        while (newList != oldList && tries <= 20 && newList.size() > 0) {
            for (WebElement e : newList) {
                switch (platform) {
                    case "ANDROID":
                        if ((e.getText().equals(elementText)) && (e.getAttribute("visible").equals("true"))) {
                            webelement = e;
                        }
                    case "IOS":
                        if ((e.getAttribute("value").equals(elementText)) && (e.getAttribute("visible").equals("true"))) {
                            webelement = e;
                        }
                }
            }
            oldList = newList;
            Util.scrollUp();
            newList = Elements();
            tries++;
        }
        if (webelement == null) {
            throw new ElementNotVisibleException("Could not find Element with the name '" + elementText + "'");
        }
        return this;
    }*/


    public String getCssValue(String property) throws IOException {
        try {
            return Element().getCssValue(property);
        } catch (StaleElementReferenceException e) {
            IsElementClickable(timeOut);
            return Element().getCssValue(property);
        }
    }

    public Boolean isDisplayed() {
        try {
            return Element().isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return IsElementPresent(timeOut);
        }
    }

    public Boolean isDisplayed(String locatorName) {
        try {
            System.out.println("Verifying element is displaying --> " + locatorName);
            return Element().isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return IsElementPresent(timeOut);
        }
    }

    public int size() {
        return Elements().size();
    }

    public int size(String locatorName) throws IOException {
        int size = 0;
        try {
            size = Elements().size();
            System.out.println("Size of the --> " + locatorName + " is " + size);
        } catch (Exception e) {
            System.out.println("Not able to found size of the --> " + locatorName + e.getMessage());
        }
        return size;
    }

    /*public String verifyTextPresent(String expText, String locatorName) throws IOException {
        String actText = Element().getText();
        try {
            if (expText.equals(actText)) {
                Log.pass("Verified text present in the screen, Expected " + expText + " and Actual " + actText);
            } else {
                Log.failAndContinue("Verification failed, text present in the screen, Expected " + expText + " and Actual " + actText);
            }

        } catch (Exception e) {
            Log.fail("Not able to verify text present in the screen --> " + locatorName + e.getMessage());
        }
        return actText;
    }*/

    /*public String verifyAttributeTextPresent(String expText, String expAttribute, String locatorName) throws IOException {
        String actText = Element().getAttribute(expAttribute);
        try {
            if (expText.equals(actText)) {
                Log.pass("Verified value present in the screen, Expected, " + expText + " and Actual, " + actText);
            } else {
                Log.failAndContinue("Verification failed, value present in the screen, Expected, " + expText + " and Actual, " + actText);
            }

        } catch (Exception e) {
            Log.fail("Not able to verify text present in the screen --> " + locatorName + e.getMessage());
        }
        return actText;
    }*/

    public static void navigateBack() throws IOException {
        try {
            PageDriver.getDriver().navigate().back();
            //Log.info("Navigated back to screen", true);
        } catch (Exception e) {
            //Log.fail("Not able to navigate back to the screen " + e.getMessage());
        }
    }

    public PageEl get(int index) {
        this.index = index;
        return this;
    }

    public void jsClick(String locatorName) throws Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) PageDriver.getDriver();
            executor.executeScript("arguments[0].click();", Element());
            System.out.println("Clicked on " + locatorName);
        } catch (Exception e) {
            throw new Exception("Not able to click on " + Element());
        }
    }

    /*public void verifyElementNotPresent(String locatorName) throws IOException {
        try {
            if (Elements().size() == 0) {
                Log.pass("Verified " + locatorName + " is not displaying");
            } else {
                Log.failAndContinue("Verification failed " + locatorName + " is displaying");
            }
        } catch (Exception e) {
            Log.fail("Element not found --> " + locatorName + e.getMessage());
        }
    }*/



}
