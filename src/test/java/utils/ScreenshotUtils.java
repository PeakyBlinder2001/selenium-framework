package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            String screenshotDir = "target/screenshots";
            Files.createDirectories(Paths.get(screenshotDir));

            String filePath = screenshotDir + "/" + testName + ".png";

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get(filePath));

            return filePath;

        } catch (Exception e) {
            return null;
        }
    }
}
