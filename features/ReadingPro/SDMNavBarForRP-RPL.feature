@SDMNavBarRP-RPL

Feature: As a Teacher, Admin or Student who is logged onto RP/RPL I want the ability to return to SDM or SLZ to edit my account,
or jump to any other application i am entitiled to or logout from the application via navigation bar


@RPL
Scenario Outline: As a teacher/admin/student I launch RPL from SDM and verify all the headers
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
Then the SDM-specific headers elements will be present in the RP header like sdm nav bar,apps drop down,log out link
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher	|
|TonyS2					|fan17zoo	|	Student |
 |teacher@ps21.org					|password1	|	Admin 	|

@RPL  
Scenario Outline: As a teacher/student/admin when I logout from the application RPL , I should see the SDM signin page
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
When the user clicks on their name in the top right of header
And clicks on logout
Then the user will experience the SDM-defined logout behavior 
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher|
|TonyS2					|fan17zoo	|	Student|
|teacher@ps21.org					|password1	|	Admin 	|


@RPL 
Scenario Outline: RPL- As a teacher when I select SDM from the nav bar dropdown then I should return to SDM Home Page
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header and clicks on the Scholastic Digital Manager in the dropdown
Then the user will experience the SDM-defined SDM navigation behavior
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher|

@RPL 
Scenario Outline: RPL - As a student when I select SDM from the nav bar dropdown then I should return to SDM Home Page
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header and clicks on the Scholastic Digital Manager in the dropdown
Then the user will experience the SDM-defined SDM navigation behavior for student 
Examples:
|username				|password	|	usertype|
|TonyS2					|fan17zoo	|	Student|

@RPL 
Scenario Outline: RPL- As an admin when I select SDM from the nav bar dropdown then I should return to SDM Home Page
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header and clicks on the Scholastic Digital Manager in the dropdown
Then the user will experience the SDM-defined SDM navigation behavior for admin
Examples:
|username									|password		|	usertype |
|teacher@ps21.org					|password1	|	Admin 	 |

@RPL 
Scenario Outline: RPL- As a teacher/student/admin when i select another app from the SDM app matrix then I go to another application i am subscribed to 
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header,another app name is present in the dropdown and clicks on the other app name
Then the user will experience the SDM-defined other app navigation behavior by navigating to another app.
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher|
|TonyS2					|fan17zoo	|	Student|
|teacher@ps21.org					|password1	|	Admin		|

@RPL
Scenario Outline: As a teacher/admin New Reading pro library logo on all the pages.
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
Then the user should see the new reading pro library logo on all the screens.
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher|
|teacher@ps21.org|password1|Admin|


@RPL  @RPL-1
Scenario Outline: As a student New Reading pro library logo on all the pages.
Given I launch RPL using "<username>" and "<password>" with "<usertype>"
Then the user should see the new reading pro library logo on all the four screens
Examples:
|username				|password	|	usertype|
|TonyS2					|fan17zoo	|	Student|

@RP
Scenario Outline: As a teacher/student/admin I launch RP from SDM and verify all the headers
Given I launch RP using "<username>" and "<password>" with "<usertype>"
Then the SDM-specific headers elements will be present in the RP header like sdm nav bar,apps drop down,log out link
Examples:
|username				 |password	|	usertype|
|teacher@sdm.org |password1	|	Teacher	|
|TonyS2					 |fan17zoo	|	Student |
|teacher@ps21.org|password1	|	Admin		|

@RP
Scenario Outline:As a teacher/student/admin when I logout from the application , I should see the SDM signin page
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When the user clicks on their name in the top right of header
And clicks on logout
Then the user will experience the SDM-defined logout behavior 
Examples:
|username				|password		|	usertype|
|teacher@sdm.org|password1	|	Teacher	|
|TonyS2					|fan17zoo		|	Student	|
|teacher@ps21.org|password1	|	Admin		|

@RP
Scenario Outline: As a teacher when I select SDM from the nav bar dropdown then I should return to SDM Home Page
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header and clicks on the Scholastic Digital Manager in the dropdown
Then the user will experience the SDM-defined SDM navigation behavior
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher|

@RP
Scenario Outline: As a student when I select SDM from the nav bar dropdown then I should return to SDM Home Page
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header and clicks on the Scholastic Digital Manager in the dropdown
Then the user will experience the SDM-defined SDM navigation behavior for student 
Examples:
|username				|password	|	usertype|
|TonyS2					|fan17zoo	|	Student|
@RP
Scenario Outline: As an admin when I select SDM from the nav bar dropdown then I should return to SDM Home Page
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header and clicks on the Scholastic Digital Manager in the dropdown
Then the user will experience the SDM-defined SDM navigation behavior for admin
Examples:
|username									|password		|	usertype |
|teacher@ps21.org					|password1	|	Admin 	 |

@RP
Scenario Outline: As a teacher/student/admin when i select another app from the SDM app matrix then I go to another application i am subscribed to 
Given I launch RP using "<username>" and "<password>" with "<usertype>"
When the user clicks on the app matrix icon in the top right of header,another app name is present in the dropdown and clicks on the other app name
Then the user will experience the SDM-defined other app navigation behavior
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher	|
|TonyS2					|fan17zoo	|	Student	|
|teacher@ps21.org					|password1|	Admin		|
@RP
Scenario Outline: As a student I should see the New Reading pro logo on all the pages.
Given I launch RP using "<username>" and "<password>" with "<usertype>"
Then the user should see the new reading pro logo on all the  four screens
Examples:
|username				|password	|	usertype|
|TonyS2					|fan17zoo	|	Student|

@RP
Scenario Outline: As a teacher/admin I should see the New Reading pro logo on all the pages.
Given I launch RP using "<username>" and "<password>" with "<usertype>"
Then the user should see the new reading pro logo on all the screens
Examples:
|username				|password	|	usertype|
|teacher@sdm.org|password1|	Teacher|
|teacher@ps21.org					|password1|	Admin		|
