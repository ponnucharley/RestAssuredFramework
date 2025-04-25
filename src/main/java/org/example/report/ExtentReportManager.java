package org.example.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.util.List;

public class ExtentReportManager {
public static ExtentReports extentReports;
    public static ExtentReports createInstance()
    {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Report.html");
        extentSparkReporter.config().setReportName("API Test Report");//report name
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;
    }

    public static void logPass(String log)
    {
        Setup.extentTest.pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));//display pass msg in green
    }
    public static void logFail(String log)
    {
        Setup.extentTest.fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logInfo(String log)
    {
        Setup.extentTest.info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logJson(String json)
    {
        Setup.extentTest.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }
    public static void logHeaders(List<Header> headerList)
    {
        String[][]headers= headerList.stream().map(header -> new String[]{header.getName(), header.getValue()})
                .toArray(String[][]::new );
        Setup.extentTest.info(MarkupHelper.createTable(headers));
    }
}
