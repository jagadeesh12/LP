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
  "duration": 6993291525,
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
  "duration": 2386180337,
  "status": "passed"
});
formatter.match({
  "location": "LplCommonFlow.i_should_collect_the_usage_detail_info()"
});
formatter.result({
  "duration": 7302480627,
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
  "duration": 361499380214,
  "error_message": "java.lang.NullPointerException\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:302)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$100(ExpectedConditions.java:41)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:288)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:285)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage.sync(ParentPage.java:100)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage.type(ParentPage.java:134)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg.login(SlzLoginPg.java:239)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg.loginAs(SlzLoginPg.java:248)\n\tat com.scholastic.intl.litpro.test.automation.pageobjects.BasePage.launchPortal(BasePage.java:54)\n\tat com.scholastic.intl.litpro.test.automation.stepdefs.lpl.LplCommonFlow.i_login_into_SLZ_as_a(LplCommonFlow.java:83)\n\tat ✽.When I login into SLZ as a \"Teacher\"(LPLCommonUI.feature:402)\n",
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
formatter.write("Current Page URL is https://qa-slz2.scholasticlearningzone.com/slz-portal/#/");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 251799372,
  "status": "passed"
});
});