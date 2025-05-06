package org.example.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {//ITestListener is an interface
    public static ExtentReports extentReports;
    //public static ExtentTest extentTest;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public void onStart(ITestContext context) {

        extentReports= ExtentReportManager.createInstance();
    }

    public void onFinish(ITestContext context) {

        extentReports.flush();
    }

    public  void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);


    }
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFail(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());//code to get complete error if test gets failed
        stackTrace=stackTrace.replaceAll(",","<br>");
        ExtentReportManager.logFail(stackTrace);
    }

}




//In ItestListener all methods are written as default from Java8.Previously ,it was mandatory to
//implement all the methods in ItestListener but from java8 , we need to implement only required ones.
