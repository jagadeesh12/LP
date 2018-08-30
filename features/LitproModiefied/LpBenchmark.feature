@regressionlp @benchmark @regressionlpset1
Feature: LitPro Benchmark
  As a LitPro User
  I should be able to changes Benchmarks
  So that I can ....

  @admin  @SmokeLP   
  Scenario: Revert to LitPro Standard for School and class
    Given I browse to Benchmark Page as "Admin"
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    When I enter search string "Lui"
    Then I should see Benchmark Page Page Header starting with "Benchmark Proficiency Bands for Lui Class"
    When I click on Save "Global English Language Learners"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Level 1 | Level 2 | Level 3 | Level 4 |
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |

  @admin @wipfix
  Scenario: Benchmark UI Changes
    Given I browse to Benchmark Page as "Admin"
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades 
		|         | Below Basic 	 | Basic    | Proficient | Advanced |
		| Class 1 | BR2000L-BR2000L	 |BR1999L-99L|100L-400L|401L+| 
		| Class 2  | BR2000L-99L       | 100L-299L  | 300L-600L    | 601L+     |
		| Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
		| Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
		| Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
		| Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
		| Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
		| Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
		| Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
		| Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
		| Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
		| Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-BR2000    | 100-400    | 401+     |
      | Class 2  | BR2000-BR2000       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    When I click on Save "Global English Language Learners"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Level 1 | Level 2 | Level 3 | Level 4 |
    And I should see the values for grades
      |         | Level 1 | Level 2 | Level 3  | Level 4 |
      | Class 2  | BR2000-124  | 125-224 | 225-419  | 420+    |
      | Class 3  | BR2000-234  | 235-324 | 325-519  | 520+    |
      | Class 4  | BR2000-354  | 355-424 | 425-739  | 740+    |
      | Class 5  | BR2000-494  | 495-574 | 575-829  | 830+    |
      | Class 6  | BR2000-539  | 540-649 | 650-924  | 925+    |
      | Class 7  | BR2000-644  | 645-714 | 715-969  | 970+    |
      | Class 8  | BR2000-679  | 680-769 | 770-1009 | 1010+   |
      | Class 9  | BR2000-734  | 735-799 | 800-1049 | 1050+   |
      | Class 10 | BR2000-779  | 780-829 | 830-1079 | 1080+   |
      | Class 11 | BR2000-824  | 825-869 | 870-1184 | 1185+   |
      | Class 12 | BR2000-834  | 835-899 | 900-1184 | 1185+   |
    And I should see the values for grades in Canada
      |          | Level 1 | Level 2 | Level 3  | Level 4 |
      | Class 2  | BR2000-124  | 125-224 | 225-419  | 420+    |
      | Class 3  | BR2000-234  | 235-324 | 325-519  | 520+    |
      | Class 4  | BR2000-354  | 355-424 | 425-739  | 740+    |
      | Class 5  | BR2000-494  | 495-574 | 575-829  | 830+    |
      | Class 6  | BR2000-539  | 540-649 | 650-924  | 925+    |
      | Class 7  | BR2000-644  | 645-714 | 715-969  | 970+    |
      | Class 8  | BR2000-679  | 680-769 | 770-1009 | 1010+   |
      | Class 9  | BR2000-734  | 735-799 | 800-1049 | 1050+   |
      | Class 10 | BR2000-779  | 780-829 | 830-1079 | 1080+   |
      | Class 11 | BR2000-824  | 825-869 | 870-1184 | 1185+   |
      | Class 12 | BR2000-834  | 835-899 | 900-1184 | 1185+   |
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-99    | 100-400    | 401+     |
      | Class 2  | BR2000-99       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-BR2000    | 100-400    | 401+     |
      | Class 2  | BR2000-BR2000       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    When I enter search string "Lui"
    Then I should see Benchmark Page Page Header starting with "Benchmark Proficiency Bands for Lui Class"
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-99    | 100-400    | 401+     |
      | Class 2  | BR2000-99       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-BR2000    | 100-400    | 401+     |
      | Class 2  | BR2000-BR2000       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    When I click on Save "Global English Language Learners"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Level 1 | Level 2 | Level 3 | Level 4 |
    And I should see the values for grades
      |         | Level 1 | Level 2 | Level 3  | Level 4 |
      | Class 2  | BR2000-124  | 125-224 | 225-419  | 420+    |
      | Class 3  | BR2000-234  | 235-324 | 325-519  | 520+    |
      | Class 4  | BR2000-354  | 355-424 | 425-739  | 740+    |
      | Class 5  | BR2000-494  | 495-574 | 575-829  | 830+    |
      | Class 6  | BR2000-539  | 540-649 | 650-924  | 925+    |
      | Class 7  | BR2000-644  | 645-714 | 715-969  | 970+    |
      | Class 8  | BR2000-679  | 680-769 | 770-1009 | 1010+   |
      | Class 9  | BR2000-734  | 735-799 | 800-1049 | 1050+   |
      | Class 10 | BR2000-779  | 780-829 | 830-1079 | 1080+   |
      | Class 11 | BR2000-824  | 825-869 | 870-1184 | 1185+   |
      | Class 12 | BR2000-834  | 835-899 | 900-1184 | 1185+   |
    And I should see the values for grades in Canada
      |          | Level 1 | Level 2 | Level 3  | Level 4 |
      | Class 2  | BR2000-124  | 125-224 | 225-419  | 420+    |
      | Class 3  | BR2000-234  | 235-324 | 325-519  | 520+    |
      | Class 4  | BR2000-354  | 355-424 | 425-739  | 740+    |
      | Class 5  | BR2000-494  | 495-574 | 575-829  | 830+    |
      | Class 6  | BR2000-539  | 540-649 | 650-924  | 925+    |
      | Class 7  | BR2000-644  | 645-714 | 715-969  | 970+    |
      | Class 8  | BR2000-679  | 680-769 | 770-1009 | 1010+   |
      | Class 9  | BR2000-734  | 735-799 | 800-1049 | 1050+   |
      | Class 10 | BR2000-779  | 780-829 | 830-1079 | 1080+   |
      | Class 11 | BR2000-824  | 825-869 | 870-1184 | 1185+   |
      | Class 12 | BR2000-834  | 835-899 | 900-1184 | 1185+   |
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-99    | 100-400    | 401+     |
      | Class 2  | BR2000-99       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-BR2000    | 100-400    | 401+     |
      | Class 2  | BR2000-BR2000       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |

  @teacher @wipfix
  Scenario: Teacher LitPro Benchmark Page LitPro Standard
    Given I browse to Benchmark Page as "Teacher"
    Then I should see Benchmark Page Page Header starting with "Benchmark Proficiency Bands for"
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-99    | 100-400    | 401+     |
      | Class 2  | BR2000-99       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Class 1  | BR2000-BR2000       | BR2000-BR2000    | 100-400    | 401+     |
      | Class 2  | BR2000-BR2000       | 100-299  | 300-600    | 601+     |
      | Class 3  | BR2000-249      | 250-499  | 500-800    | 801+     |
      | Class 4  | BR2000-349      | 350-599  | 600-900    | 901+     |
      | Class 5  | BR2000-449      | 450-699  | 700-1000   | 1001+    |
      | Class 6  | BR2000-499      | 500-799  | 800-1050   | 1051+    |
      | Class 7  | BR2000-549      | 550-849  | 850-1100   | 1101+    |
      | Class 8  | BR2000-599      | 600-899  | 900-1150   | 1151+    |
      | Class 9  | BR2000-649      | 650-999  | 1000-1200  | 1201+    |
      | Class 10 | BR2000-699      | 700-1024 | 1025-1250  | 1251+    |
      | Class 11 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |
      | Class 12 | BR2000-799      | 800-1049 | 1050-1300  | 1301+    |

  @admin
  Scenario: Benchmark UI Changes to GELL for Class
    Given I browse to Benchmark Page as "Admin"
    When I enter search string "Lui"
    Then I should see Benchmark Page Page Header starting with "Benchmark Proficiency Bands for Lui Class"
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    When I click on Save "Global English Language Learners"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Level 1 | Level 2 | Level 3 | Level 4 |

  @teacher @wipfix
  Scenario: Teacher LitPro Benchmark Page GELL
    Given I browse to Benchmark Page as "Teacher"
    And I should see benchmark table with following category
      | Level 1 | Level 2 | Level 3 | Level 4 |
    And I should see the values for grades
      |         | Level 1 | Level 2 | Level 3  | Level 4 |
      | Class 2  | BR2000-124  | 125-224 | 225-419  | 420+    |
      | Class 3  | BR2000-234  | 235-324 | 325-519  | 520+    |
      | Class 4  | BR2000-354  | 355-424 | 425-739  | 740+    |
      | Class 5  | BR2000-494  | 495-574 | 575-829  | 830+    |
      | Class 6  | BR2000-539  | 540-649 | 650-924  | 925+    |
      | Class 7  | BR2000-644  | 645-714 | 715-969  | 970+    |
      | Class 8  | BR2000-679  | 680-769 | 770-1009 | 1010+   |
      | Class 9  | BR2000-734  | 735-799 | 800-1049 | 1050+   |
      | Class 10 | BR2000-779  | 780-829 | 830-1079 | 1080+   |
      | Class 11 | BR2000-824  | 825-869 | 870-1184 | 1185+   |
      | Class 12 | BR2000-834  | 835-899 | 900-1184 | 1185+   |
    And I should see the values for grades in Canada
      |          | Level 1 | Level 2 | Level 3  | Level 4 |
      | Class 2  | BR2000-124  | 125-224 | 225-419  | 420+    |
      | Class 3  | BR2000-234  | 235-324 | 325-519  | 520+    |
      | Class 4  | BR2000-354  | 355-424 | 425-739  | 740+    |
      | Class 5  | BR2000-494  | 495-574 | 575-829  | 830+    |
      | Class 6  | BR2000-539  | 540-649 | 650-924  | 925+    |
      | Class 7  | BR2000-644  | 645-714 | 715-969  | 970+    |
      | Class 8  | BR2000-679  | 680-769 | 770-1009 | 1010+   |
      | Class 9  | BR2000-734  | 735-799 | 800-1049 | 1050+   |
      | Class 10 | BR2000-779  | 780-829 | 830-1079 | 1080+   |
      | Class 11 | BR2000-824  | 825-869 | 870-1184 | 1185+   |
      | Class 12 | BR2000-834  | 835-899 | 900-1184 | 1185+   |

  @admin 
  Scenario: Verifying dublicate benchmark
    Given I browse to Benchmark Page as "Admin"
    Then I should click on benckmark dropdown
    Then I should verify the dublicate benchmark
    
   @admin  
  Scenario: Benchmark Report Display settings
    Given I browse to Benchmark Page as "Admin"
    When I click on Save "Global English Language Learners"
    Then 'Benchmark Saved' Message should display
    When I click on home page 
    Then I Should see "Lexile Growth" in the Dash board
    When I navigate to reports page
    Then I must not see below reports
    | Expected Lexile Growth Report   | Lexile Compared to Norm Report    |
    
    @admin     
  Scenario: Benchmark Report Display settings 
    Given I browse to Benchmark Page as "Admin"
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    When I click on home page 
    Then I Should see "Expected Growth" in the Dash board
    When I navigate to reports page
    Then I must see below reports
    | Expected Lexile Growth Report   |  Lexile Compared to Norm Report    |
    
    
  