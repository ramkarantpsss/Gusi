package com.Gusi;

import io.appium.java_client.android.AndroidDriver;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class ReportProvider {

    static final String mHostAddress="http://localhost:4723";
    static final String mGetReportAddress=mHostAddress+"/getReport";
    static final String mSetReportAddress=mHostAddress+"/setTestInfo";
    static final String mDeleteReportAddress=mHostAddress+"/deleteReportData";
    static final String HTML_REPORT_DIR = System.getProperty("user.dir");

    public static void setTestInfo(String sessionId, String testName, String testStatus, String error) {
        try {

            String body = "{" +
                    "\"sessionId\":\""+sessionId+"\"," +
                    "\"testName\":\""+testName+"\"," +
                    "\"testStatus\":\""+testStatus+"\"," +
                    "\"error\":\""+error+"\"" +
                    "}";
            System.out.println("url = " + mSetReportAddress);
            System.out.println("Body of setTestInfo = " + body);
            HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.post(mSetReportAddress)
                    .header("Content-Type", "application/json")
                    .body(body).asJson();
        } catch (Exception e){
            System.out.println("Failed to set Test info"+e.toString());
        }

    }

    public String getSessionId(AndroidDriver driver){

        String sessionId;
        try {
            sessionId = driver.getSessionId().toString();
        } catch (Exception e){
            sessionId = UUID.randomUUID().toString();
        }
        return sessionId;
    }

    public void quitDriver(AndroidDriver driver){
        if(driver != null && driver.getSessionId() != null)
            driver.quit();
        driver = null;
    }

    public String getReport() throws IOException, InterruptedException {
        System.out.println(mGetReportAddress);
        return Unirest.get(mGetReportAddress).asString().getBody();
    }

    public void deleteReportData() throws IOException, InterruptedException {
        System.out.println(mDeleteReportAddress);
        Unirest.delete(mDeleteReportAddress).asEmpty();
    }

    public void createReportFile(String data, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(HTML_REPORT_DIR + "/" + fileName + ".html");
        fileWriter.write(data);
        fileWriter.close();
    }

}
