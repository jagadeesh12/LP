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
  "duration": 2515931416,
  "error_message": "org.openqa.selenium.WebDriverException: disconnected: unable to connect to renderer\n  (Session info: chrome\u003d65.0.3325.146)\n  (Driver info: chromedriver\u003d2.30.477691 (6ee44a7247c639c0703f291d320bdf05c1531b57),platform\u003dLinux 3.19.0-65-generic x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 7 milliseconds\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027jagadeesh-ThinkPad-L450\u0027, ip: \u0027127.0.1.1\u0027, os.name: \u0027Linux\u0027, os.arch: \u0027amd64\u0027, os.version: \u00273.19.0-65-generic\u0027, java.version: \u00271.8.0_161\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.30.477691 (6ee44a7247c639c0703f291d320bdf05c1531b57), userDataDir\u003d/tmp/.org.chromium.Chromium.x136tX}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d65.0.3325.146, platform\u003dLINUX, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 56a88c002e61679ecc69392552f11ada\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteWebDriverOptions$RemoteWindow.maximize(RemoteWebDriver.java:945)\n\tat com.scholastic.intl.litpro.test.automation.stepdefs.Hooks.beforeHook(Hooks.java:35)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat com.scholastic.torque.cucumber.testng.CucumberTestNGRunner.runCucumber(CucumberTestNGRunner.java:108)\n\tat com.scholastic.torque.cucumber.testng.CukesByFeatureAndCompositionTest.feature(CukesByFeatureAndCompositionTest.java:22)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:86)\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:643)\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:820)\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1128)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:782)\n\tat org.testng.TestRunner.run(TestRunner.java:632)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:366)\n\tat org.testng.SuiteRunner.access$000(SuiteRunner.java:39)\n\tat org.testng.SuiteRunner$SuiteWorker.run(SuiteRunner.java:400)\n\tat org.testng.internal.thread.ThreadUtil$2.call(ThreadUtil.java:64)\n\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n\tat java.lang.Thread.run(Thread.java:748)\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.match({
  "location": "LplCommonFlow.i_should_collect_the_usage_detail_info()"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
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
formatter.write("Current Page URL is data:,");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 182796919,
  "status": "passed"
});
});