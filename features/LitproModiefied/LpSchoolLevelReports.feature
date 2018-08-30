@functional @reports @regressionlpset1 @testreports 
Feature: LitPro Reports UI validation at School level 
	As a LitPro User
  I should be able to view school level reports
  So that I can ....
  
  
  
	
	
Scenario: Testing Awards are based on: points earned Setting 
	Given I browse to Settings Page as "admin" 
	Then I should see class name 
	And I should set the following settings for awards 
		| Award Name | Value |
		| Gold       | 4   |
		| Silver     | 3   |
		| Bronze     | 2   |
		| Red        | 1   |
		| Blue       | 0   |
	And I click Save 
	Then 'Settings Saved' Message should be displayed 
	Then I logout 
	
	
Scenario: Collecting test data of all the students 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	Then I should collect the data of all students 
		|Student Name|
		|JoeMartina|
		|EdMcCreery|
		|JonSnow|
		|AryaStark|
		
		
		
Scenario: Vaildating the data of Lexile Compared to Norm Report at class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Lexile Compared to Norm Report" 
	Then I should see then report header as "Lexile Compared to Norm Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Lexile Compared to Norm Report for "Lui Class" class level for Student 
	
	
Scenario: Vaildating the data of Lexile Compared to Norm Report at Grade level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I select grade from the grade dropdown
	When I Click on View Reprot button of "Lexile Compared to Norm Report" 
	Then I should see then report header as "Lexile Compared to Norm Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Lexile Compared to Norm Report at Grade level for Student 
	
Scenario: Vaildating the data of Lexile Compared to Norm Report at school level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I go to "breaking bad 6" for school level reprot validation. 
	When I Click on View Reprot button of "Lexile Compared to Norm Report" 
	Then I should see then report header as "Lexile Compared to Norm Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Lexile Compared to Norm Report at school level for Student 
	
	
Scenario:
Vaildating the data of Reading Proficiency Report Report at class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Reading Proficiency Report" 
	Then I should see then report header as "Reading Proficiency Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Reading Proficiency Report for "Lui Class" class level for Student 

	
Scenario: Vaildating the data of Reading Proficiency Report at Grade level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I select grade from the grade dropdown
	When I Click on View Reprot button of "Reading Proficiency Report" 
	Then I should see then report header as "Reading Proficiency Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Reading Proficiency Report at Grade "5" level for Student 
	
Scenario: Vaildating the data of Reading Proficiency Report at school level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I go to "breaking bad 6" for school level reprot validation. 
	When I Click on View Reprot button of "Reading Proficiency Report" 
	Then I should see then report header as "Reading Proficiency Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Reading Proficiency Report at school level for Student 
	
Scenario: Vaildating the data of Lexile Growth Report at Class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Lexile Growth Report" 
	Then I should see then report header as "Lexile Growth Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Lexile Growth Report for "Lui Class" class level for Student 


Scenario: Vaildating the data of Lexile Growth Report at Grade level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	Then I should collect the data of all students 
		|Student Name|
		|JoeMartina|
		|EdMcCreery|
		|JonSnow|
		|AryaStark|
	When I select grade from the grade dropdown
	When I Click on View Reprot button of "Lexile Growth Report" 
	Then I should see then report header as "Lexile Growth Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Lexile Growth Report at Grade "5" level for Student 
	
	
Scenario: Vaildating the data of Lexile Growth Report at school level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I go to "breaking bad 6" for school level reprot validation. 
	When I Click on View Reprot button of "Lexile Growth Report" 
	Then I should see then report header as "Lexile Growth Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Lexile Growth Report at School level for Student 
	
	#LAP-570
Scenario: Vaildating the data of Expected Lexile Growth Report at Class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Expected Lexile Growth Report" 
	Then I should see then report header as "Expected Lexile Growth Report" 
	And I should see an asterisk with message "** Expected growth data is only available for students in year/grade 3-10." 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Expected Lexile Growth Report for "Lui Class" class level for Student 
	
	#LAP-570
Scenario: Vaildating the data of Expected Lexile Growth Report at grade level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I select grade from the grade dropdown
	When I Click on View Reprot button of "Expected Lexile Growth Report" 
	Then I should see then report header as "Expected Lexile Growth Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Expected Lexile Growth Report at Grade level for Student 
	
	#LAP-570
	
Scenario: Vaildating the data of Expected Lexile Growth Report at school level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I go to "breaking bad 6" for school level reprot validation. 
	When I Click on View Reprot button of "Expected Lexile Growth Report" 
	Then I should see then report header as "Expected Lexile Growth Report" 
	And I should see an asterisk with message "** Expected growth data is only available for students in year/grade 3-10." 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Expected Lexile Growth Report at School level for Student 
	
@LPI-5269defectopen 
Scenario: Vaildating the data of Class Reading Report Card at Class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Reading Report Card" 
	Then I should see then report header as "Class Reading Report Card" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Class Reading Report Card for "Lui Class" class level for Student 
	
	
Scenario: Vaildating the data of Class Lexile History Report at Class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Lexile History Report" 
	Then I should see then report header as "Class Lexile History Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Class Lexile History Report Card for "Lui Class" class level for Student 
	
@admin @regression 
Scenario: Reading Proficiency Report UI verification 
	Given I browse to 'Reports' page as an "Admin" 
	Then I should see Reports page header with text "Reports for" 
	And I should see report card name "Reading Proficiency Report" 
	When I click on View Report button 
	Then I see the report card on a modal with header "Reading Proficiency Report" 
	And the report modal description should read 'This report shows the percentage or number of students in each proficiency band.' 
	And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.' 
	And "Reading Proficiency Report" modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| pie   |
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on bar 'graph' button 
	And I click on 'table' button 
	When I click on 'close' button 
	Then I should see Reports page header with text "Reports for" 
	
@admin @regression 
Scenario: Book Comprehension Report UI verification 
	Given I browse to 'Reports' page as an "Admin" 
	Then I should see Reports page header with text "Reports for" 
	And I should see report card name "Book Comprehension Report" 
	When I click on View Report button 
	Then I see the report card on a modal with header "Book Comprehension Report" 
	And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.' 
	And Book Comprehension Report modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Book Comprehension Report modal should display following reports 
		| graph       |
		| table       |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	When I click on 'close' button 
	Then I should see Reports page header with text "Reports for" 
	
@admin @regression 
Scenario: Quiz Pass Rate Report UI verification 
	Given I browse to 'Reports' page as an "Admin" 
	Then I should see Reports page header with text "Reports for" 
	And I should see report card name "Quiz Pass Rate Report" 
	When I click on View Report button 
	Then I see the report card on a modal with header "Quiz Pass Rate Report" 
	And the report modal footer should read '*Imported data may affect averages across reports. For more information, click here.' 
	And Quiz Pass Rate Report modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Quiz Pass Rate Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	When I click on 'close' button 
	Then I should see Reports page header with text "Reports for" 
	
	#LAP-570
@admin @regression 
Scenario: Vaildating the data of Admin Dashboard 
	Given I browse to Report Page as "admin" 
	When I click on home page 
	Then I should see following reports in dashboard 
		|Dashboard Report|
		|Average Lexile|
		|Average Lexile Growth This Year|
		|Average Quiz Score|
		|Number of Quizzes Taken|
		|Quiz Pass Rate|
		|Words Read|
	And I should see an asterisk with message "** Expected growth data is only available for students in year/grade 3-10." 
	Then I should validate the Admin dashboard reports 
	
@teacher @regression 
Scenario: Vaildating the data of Teacher Dashboard 
	Given I browse to Report Page as "Teacher"
	When I click on home page 
	Then I should see following reports in dashboard 
		|Dashboard Report|
		|Average Lexile|
		|Average Lexile Growth This Year|
		|Average Quiz Score|
		|Number of Quizzes Taken|
		|Quiz Pass Rate|
		|Words Read|
	Then I should validate the Teacher dashboard reports 
	
	#LAP-589
Scenario: Vaildating the data of Quiz Pass Rate Report at class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Quiz Pass Rate Report" 
	Then I should see then report header as "Quiz Pass Rate Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Quiz Pass Rate Report for "Lui Class" class level for Student 
	
	
	#LAP-589 
Scenario: Vaildating the data of Quiz Pass Rate Report at Grade level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	Then I should collect the data of all students 
		|Student Name|
		|JoeMartina|
		|EdMcCreery|
		|JonSnow|
		|AryaStark|
	When I select grade from the grade dropdown 
	When I Click on View Reprot button of "Quiz Pass Rate Report" 
	Then I should see then report header as "Quiz Pass Rate Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Quiz Pass Rate Report at Grade level for Student 
	
	
	#LAP-589 
Scenario: Vaildating the data of Quiz Pass Rate Report at School level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I go to "breaking bad 6" for school level reprot validation. 
	When I Click on View Reprot button of "Quiz Pass Rate Report" 
	Then I should see then report header as "Quiz Pass Rate Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Quiz Pass Rate Report at school level for Student 
	
	#LAP-589
Scenario: Vaildating the data of Class Quiz Activity Report at class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Quiz Activity Report" 
	Then I should see then report header as "Class Quiz Activity Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the reports data of Class Quiz Activity Report for "Lui Class" class level for Student 
	
	
	
	#LAP-589
	@settingstest1
Scenario:
Vaildating the Historical SRI data of Lexile Growth Report Report at School level 
	Given I browse to Report Page for historical data as "admin" 
	Then I should see header text for Reports page 
	When I Click on View Reprot button of "Lexile Growth Report" 
	Then I should see then report header as "Lexile Growth Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	Then I should validated and select the school year for which the data was uplaoded 
	And I click on 'table' button 
	Then I should validate the reports data of historical Lexile Growth Report at school level 
	
	
	#LAP-589 
Scenario:
Vaildating the Historical SRI data of Class Quiz Activity Report at School level 
	Given I browse to Report Page for historical data as "admin" 
	Then I should see header text for Reports page 
	When I Click on View Reprot button of "Lexile Compared to Norm Report" 
	Then I should see then report header as "Lexile Compared to Norm Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	Then I should validated and select the school year for which the data was uplaoded 
	And I click on 'table' button 
	Then I should validate the reports data of historical Lexile Compared to Norm Report at school level 
	
	#LAP-589
Scenario: Vaildating the Historical SRI data of Expected Lexile Growth Report at School level 
	Given I browse to Report Page for historical data as "admin" 
	Then I should see header text for Reports page 
	When I Click on View Reprot button of "Expected Lexile Growth Report" 
	Then I should see then report header as "Expected Lexile Growth Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	Then I should validated and select the school year for which the data was uplaoded 
	And I click on 'table' button 
	Then I should validate the reports data of historical Expected Lexile Growth Report at school level 
	
	#LAP-589 
Scenario: Vaildating the Historical SRI data of Reading Proficiency Report at School level 
	Given I browse to Report Page for historical data as "admin" 
	Then I should see header text for Reports page 
	When I Click on View Reprot button of "Reading Proficiency Report" 
	Then I should see then report header as "Reading Proficiency Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	Then I should validated and select the school year for which the data was uplaoded 
	And I click on 'table' button 
	Then I should validate the reports data of historical Reading Proficiency Report at school level 
	
	
	#LAP-575
	
Scenario: Vaildating the data of Student Lexile History Report at grade level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "JonSnow" 
	When I Click on View Reprot button of "Student Lexile History Report" 
	Then I should see then report header as "Student Lexile History Report" 
	And modal should display following buttons on the header 
		| Report modal Elements |
		| export                |
		| print                 |
		| close                 |
	And Reading Proficiency Report modal should display following reports 
		| graph |
		| table |
	When I click on 'School Calendar' dropdown 
	Then I should see list of school year options 
	And I click on 'table' button 
	Then I should validate the student lexile history report should show reports for current year 
	When I select "View all years" option from dropdown 
	Then I should Verify that all the lexile scores should be shown 
	
@Remaining1 
Scenario: Parent Letter for class 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	Then I should collect the data of all students 
		|Student Name|
		|JonSnow|
		|AryaStark|
	When I search for the class "Lui Class" 
	And I print Parent Letter for multiple students 
	Then Students Report card data should match in the Parent Letter 
		|Student Name|
		|Jon Snow|
		|Arya Stark|
		
		
		
@Remaining2 
Scenario: Print Multiple Reading report Card 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	Then I should collect the data of all students 
		|Student Name|
		|JonSnow|
		|AryaStark|
	When I search for the class "Lui Class" 
	And I print Reading Report Card for multiple students 
	Then Students Report card data should match in the Reading Report card Letter 
		|Student Name|
		|Jon Snow|
		|Arya Stark|
		
		#LAP-578	
@Admin 
Scenario: LitPro Student Print Student certificate At class level 
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I click on print certificates options at class level 
	Then I should validate the certificate of all the students in the class "Lui Class" 
	
	#LAP-578	
@Admin 
Scenario: LitPro Student Print Student certificate At class level 
	Given I browse to Report Page as "Teacher" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I click on print certificates options at class level 
	Then I should validate the certificate of all the students in the class "Lui Class"	
	
	
	################################################################################
#LAP-634
Scenario: Custom date range:- Should verify left calender is of previous month and right calender of current month(Class Quiz Activity Report)
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Quiz Activity Report" 
	Then I should see then report header as "Class Quiz Activity Report" 
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	Then I should verify that left calender is of previous month and right calender of current month

#LAP-634
Scenario: Custom date range:- Should verify left calender is of previous month and right calender of current month(Certificates Report)
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Certificates Report" 
	Then I should see then report header as "Certificates Report" 
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	Then I should verify that left calender is of previous month and right calender of current month

#LAP-634
Scenario: Custom date range:- Should verify left calender is of previous month and right calender of current month(Class Reading Report Card)
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Reading Report Card" 
	Then I should see then report header as "Class Reading Report Card" 
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	Then I should verify that left calender is of previous month and right calender of current month

#LAP-634
Scenario: Custom date range:- Should verify movement of months according to arrows
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Quiz Activity Report" 
	Then I should see then report header as "Class Quiz Activity Report" 
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	When I click on left icon I should see previous month in calender
	Then I should click on Cancel button
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	When I click on right icon I should see furture month in calender


#LAP-634
Scenario: Custom date range:- Apply and X button clicking verification
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Quiz Activity Report" 
	Then I should see then report header as "Class Quiz Activity Report" 
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	Then I should Click on Apply button and year dropdown button should change to according selected date
	When I click on the X button next to date range
	Then The date range will be cleared and default school year "School Calendar" will be shown
	
#LAP-634
Scenario: Custom date range:- Should verify movement of months according to arrows
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Quiz Activity Report" 
	Then I should see then report header as "Class Quiz Activity Report" 
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	Then I should click on Cancel button
	Then I should see calendar tray collapse and same year "School Calendar" dropdown button name
	
#LAP-634
Scenario: Custom date range:- Should verify difference between FROM and TO date less then 365 days
	Given I browse to Report Page as "admin" 
	Then I should see header text for Reports page 
	When I search for the class "Lui Class" 
	When I Click on View Reprot button of "Class Quiz Activity Report" 
	Then I should see then report header as "Class Quiz Activity Report" 
	When I click on 'School Calendar' dropdown 
	Then I should click on "Set Custom Range" option.
	When I select TO date
	Then I should not be able to select more then 365 days from TO date
	
	
	
	