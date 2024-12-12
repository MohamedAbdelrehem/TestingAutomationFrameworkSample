package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Reusable class for taking screenshots
public class ScreenshotHeadway {
    private static WebDriver driver;
    private static String sessionFolderPath;

    // Constructor to initialize WebDriver and set session folder path
    public ScreenshotHeadway(WebDriver driver) {
        this.driver = driver;

        // Create a session folder based on the current date and time (once per session)
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDate = dateTimeNow.format(myFormatObj);

        // Set the session folder path
        this.sessionFolderPath = "./ScreenShot_Folder/" + formattedDate;

        // Create the folder if it doesn't exist
        File sessionFolder = new File(sessionFolderPath);
        if (!sessionFolder.exists()) {
            if (sessionFolder.mkdirs()) {
                System.out.println("Session folder created at: " + sessionFolderPath);
            } else {
                System.err.println("Failed to create session folder at: " + sessionFolderPath);
                throw new RuntimeException("Could not create session folder");
            }
        }
    }

    // Method to capture and save a screenshot within the session folder
    public static void captureScreenshot(String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Ensure the filename ends with .png
        if (!fileName.endsWith(".png")) {
            fileName = fileName + ".png";
        }

        // Full path for the screenshot
        String filePathWithTimestamp = sessionFolderPath + "/" + fileName;

        try {
            FileUtils.copyFile(screenshot, new File(filePathWithTimestamp));
            System.out.println("Screenshot saved at: " + filePathWithTimestamp);
        } catch (IOException e) {
            System.err.println("Error while saving screenshot: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
