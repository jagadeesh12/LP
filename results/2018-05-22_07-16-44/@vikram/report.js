$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LPLCommonUI.feature");
formatter.feature({
  "line": 2,
  "name": "LitPro library",
  "description": "",
  "id": "litpro-library",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@f1"
    },
    {
      "line": 1,
      "name": "@regressionlpl"
    },
    {
      "line": 1,
      "name": "@smokelpl"
    }
  ]
});
formatter.before({
  "duration": 6211408565,
  "status": "passed"
});
formatter.scenario({
  "line": 399,
  "name": "LitProLibrary - Validating the Usage Details of the student - Teacher",
  "description": "",
  "id": "litpro-library;litprolibrary---validating-the-usage-details-of-the-student---teacher",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 398,
      "name": "@regression"
    },
    {
      "line": 398,
      "name": "@EBB-3765"
    },
    {
      "line": 398,
      "name": "@vikram"
    }
  ]
});
formatter.step({
  "line": 400,
  "name": "I login into SLZ as a \"Student\"",
  "keyword": "When "
});
formatter.step({
  "line": 401,
  "name": "I should collect the usage detail info",
  "keyword": "Then "
});
formatter.step({
  "line": 402,
  "name": "I login into SLZ as a \"Teacher\"",
  "keyword": "When "
});
formatter.step({
  "line": 403,
  "name": "I should click on \"breaking bad 6\" in roster tree",
  "keyword": "Then "
});
formatter.step({
  "line": 404,
  "name": "I should click on \"Lui Class\" in roster tree",
  "keyword": "Then "
});
formatter.step({
  "line": 405,
  "name": "I should click on student \"Snow Jon\" in roster tree",
  "keyword": "Then "
});
formatter.step({
  "line": 406,
  "name": "I should compare usage detail info of student with teacher",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Student",
      "offset": 23
    }
  ],
  "location": "LplCommonFlow.i_login_into_SLZ_as_a(String)"
});
formatter.result({
  "duration": 3311736311,
  "status": "passed"
});
formatter.match({
  "location": "LplCommonFlow.i_should_collect_the_usage_detail_info()"
});
formatter.result({
  "duration": 7327704317,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Teacher",
      "offset": 23
    }
  ],
  "location": "LplCommonFlow.i_login_into_SLZ_as_a(String)"
});
formatter.result({
  "duration": 9296099895,
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d65.0.3325.146)\n  (Driver info: chromedriver\u003d2.38.552522 (437e6fbedfa8762dec75e2c5b3ddb86763dc9dcb),platform\u003dLinux 3.19.0-65-generic x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 4 milliseconds\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027jagadeesh-ThinkPad-L450\u0027, ip: \u0027127.0.1.1\u0027, os.name: \u0027Linux\u0027, os.arch: \u0027amd64\u0027, os.version: \u00273.19.0-65-generic\u0027, java.version: \u00271.8.0_161\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.38.552522 (437e6fbedfa8762dec75e2c5b3ddb86763dc9dcb), userDataDir\u003d/tmp/.org.chromium.Chromium.mmeNyk}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d65.0.3325.146, platform\u003dLINUX, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dfalse, acceptInsecureCerts\u003dfalse, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 0b0258c019d9033c323ba249d6d5ac64\n*** Element info: {Using\u003dname, value\u003dUserName}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByName(RemoteWebDriver.java:461)\n\tat org.openqa.selenium.By$ByName.findElement(By.java:303)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage$1.apply(ParentPage.java:146)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage$1.apply(ParentPage.java:1)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage.getElement(ParentPage.java:152)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg.login(SlzLoginPg.java:235)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg.loginAs(SlzLoginPg.java:248)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.BasePage.launchPortal(BasePage.java:54)\n\tat com.scholastic.intl.litpro.test.automation.stepdefs.lpl.LplCommonFlow.i_login_into_SLZ_as_a(LplCommonFlow.java:83)\n\tat ✽.When I login into SLZ as a \"Teacher\"(LPLCommonUI.feature:402)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "breaking bad 6",
      "offset": 19
    }
  ],
  "location": "LplCommonFlow.i_should_click_on_something_in_roster_tree(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Lui Class",
      "offset": 19
    }
  ],
  "location": "LplCommonFlow.i_should_click_on_something_in_roster_tree(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Snow Jon",
      "offset": 27
    }
  ],
  "location": "LplCommonFlow.i_should_click_on_student_something_in_roster_tree(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LplCommonFlow.i_should_compare_usage_detail_info_of_student_with_teacher()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 77852471,
  "status": "passed"
});
});