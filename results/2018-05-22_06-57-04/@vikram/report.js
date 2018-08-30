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
  "duration": 397652135,
  "error_message": "java.lang.NoClassDefFoundError: org/apache/http/auth/Credentials\n\tat org.openqa.selenium.remote.HttpCommandExecutor.getDefaultClientFactory(HttpCommandExecutor.java:96)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.\u003cinit\u003e(HttpCommandExecutor.java:70)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.\u003cinit\u003e(HttpCommandExecutor.java:58)\n\tat org.openqa.selenium.firefox.internal.NewProfileExtensionConnection.start(NewProfileExtensionConnection.java:87)\n\tat org.openqa.selenium.firefox.FirefoxDriver.startClient(FirefoxDriver.java:271)\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:119)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:216)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:211)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:207)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:120)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat java.lang.Class.newInstance(Class.java:442)\n\tat com.scholastic.torque.common.TestBase$WEBDRIVER.getDriver(TestBase.java:479)\n\tat com.scholastic.torque.common.TestBase.initDriver(TestBase.java:158)\n\tat com.scholastic.torque.common.TestBase.getDriver(TestBase.java:83)\n\tat com.scholastic.torque.common.TestBase.getSessionID(TestBase.java:528)\n\tat com.scholastic.intl.litpro.test.automation.stepdefs.Hooks.beforeHook(Hooks.java:26)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat com.scholastic.torque.cucumber.testng.CucumberTestNGRunner.runCucumber(CucumberTestNGRunner.java:108)\n\tat com.scholastic.torque.cucumber.testng.CukesByFeatureAndCompositionTest.feature(CukesByFeatureAndCompositionTest.java:22)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:86)\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:643)\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:820)\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1128)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:782)\n\tat org.testng.TestRunner.run(TestRunner.java:632)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:366)\n\tat org.testng.SuiteRunner.access$000(SuiteRunner.java:39)\n\tat org.testng.SuiteRunner$SuiteWorker.run(SuiteRunner.java:400)\n\tat org.testng.internal.thread.ThreadUtil$2.call(ThreadUtil.java:64)\n\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n\tat java.lang.Thread.run(Thread.java:748)\nCaused by: java.lang.ClassNotFoundException: org.apache.http.auth.Credentials\n\tat java.net.URLClassLoader.findClass(URLClassLoader.java:381)\n\tat java.lang.ClassLoader.loadClass(ClassLoader.java:424)\n\tat sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:338)\n\tat java.lang.ClassLoader.loadClass(ClassLoader.java:357)\n\t... 55 more\n",
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
formatter.after({
  "duration": 105885234,
  "error_message": "java.lang.NoClassDefFoundError: org/apache/http/auth/Credentials\n\tat org.openqa.selenium.remote.HttpCommandExecutor.getDefaultClientFactory(HttpCommandExecutor.java:96)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.\u003cinit\u003e(HttpCommandExecutor.java:70)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.\u003cinit\u003e(HttpCommandExecutor.java:58)\n\tat org.openqa.selenium.firefox.internal.NewProfileExtensionConnection.start(NewProfileExtensionConnection.java:87)\n\tat org.openqa.selenium.firefox.FirefoxDriver.startClient(FirefoxDriver.java:271)\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:119)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:216)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:211)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:207)\n\tat org.openqa.selenium.firefox.FirefoxDriver.\u003cinit\u003e(FirefoxDriver.java:120)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat java.lang.Class.newInstance(Class.java:442)\n\tat com.scholastic.torque.common.TestBase$WEBDRIVER.getDriver(TestBase.java:479)\n\tat com.scholastic.torque.common.TestBase.initDriver(TestBase.java:158)\n\tat com.scholastic.torque.common.TestBase.getDriver(TestBase.java:83)\n\tat com.scholastic.intl.litpro.test.automation.stepdefs.Hooks.afterHook(Hooks.java:43)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat com.scholastic.torque.cucumber.testng.CucumberTestNGRunner.runCucumber(CucumberTestNGRunner.java:108)\n\tat com.scholastic.torque.cucumber.testng.CukesByFeatureAndCompositionTest.feature(CukesByFeatureAndCompositionTest.java:22)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:86)\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:643)\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:820)\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1128)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:782)\n\tat org.testng.TestRunner.run(TestRunner.java:632)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:366)\n\tat org.testng.SuiteRunner.access$000(SuiteRunner.java:39)\n\tat org.testng.SuiteRunner$SuiteWorker.run(SuiteRunner.java:400)\n\tat org.testng.internal.thread.ThreadUtil$2.call(ThreadUtil.java:64)\n\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\n\tat java.lang.Thread.run(Thread.java:748)\nCaused by: java.lang.ClassNotFoundException: org.apache.http.auth.Credentials\n\tat java.net.URLClassLoader.findClass(URLClassLoader.java:381)\n\tat java.lang.ClassLoader.loadClass(ClassLoader.java:424)\n\tat sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:338)\n\tat java.lang.ClassLoader.loadClass(ClassLoader.java:357)\n\t... 54 more\n",
  "status": "failed"
});
});