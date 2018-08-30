@regressionlp   @Benchmark
Feature: LitPro Benchmark
  As a LitPro User
  I should be able to changes Benchmarks
  So that I can ....

  @admin @benchmark123 @regressionlp123 @test1
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

  @admin @wipfix @regressionlp123 
  Scenario: Benchmark UI Changes
    Given I browse to Benchmark Page as "Admin"
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Year 1  | BR-BR       | BR-99    | 100-400    | 401+     |
      | Year 2  | BR-99       | 100-299  | 300-600    | 601+     |
      | Year 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Year 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Year 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Year 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Year 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Year 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Year 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Year 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Year 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Year 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Grade 1  | BR-BR       | BR-BR    | 100-400    | 401+     |
      | Grade 2  | BR-BR       | 100-299  | 300-600    | 601+     |
      | Grade 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Grade 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Grade 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Grade 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Grade 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Grade 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Grade 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Grade 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Grade 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Grade 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    When I click on Save "Global English Language Learners"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Level 1 | Level 2 | Level 3 | Level 4 |
    And I should see the values for grades
      |         | Level 1 | Level 2 | Level 3  | Level 4 |
      | Year 2  | BR-124  | 125-224 | 225-419  | 420+    |
      | Year 3  | BR-234  | 235-324 | 325-519  | 520+    |
      | Year 4  | BR-354  | 355-424 | 425-739  | 740+    |
      | Year 5  | BR-494  | 495-574 | 575-829  | 830+    |
      | Year 6  | BR-539  | 540-649 | 650-924  | 925+    |
      | Year 7  | BR-644  | 645-714 | 715-969  | 970+    |
      | Year 8  | BR-679  | 680-769 | 770-1009 | 1010+   |
      | Year 9  | BR-734  | 735-799 | 800-1049 | 1050+   |
      | Year 10 | BR-779  | 780-829 | 830-1079 | 1080+   |
      | Year 11 | BR-824  | 825-869 | 870-1184 | 1185+   |
      | Year 12 | BR-834  | 835-899 | 900-1184 | 1185+   |
    And I should see the values for grades in Canada
      |          | Level 1 | Level 2 | Level 3  | Level 4 |
      | Grade 2  | BR-124  | 125-224 | 225-419  | 420+    |
      | Grade 3  | BR-234  | 235-324 | 325-519  | 520+    |
      | Grade 4  | BR-354  | 355-424 | 425-739  | 740+    |
      | Grade 5  | BR-494  | 495-574 | 575-829  | 830+    |
      | Grade 6  | BR-539  | 540-649 | 650-924  | 925+    |
      | Grade 7  | BR-644  | 645-714 | 715-969  | 970+    |
      | Grade 8  | BR-679  | 680-769 | 770-1009 | 1010+   |
      | Grade 9  | BR-734  | 735-799 | 800-1049 | 1050+   |
      | Grade 10 | BR-779  | 780-829 | 830-1079 | 1080+   |
      | Grade 11 | BR-824  | 825-869 | 870-1184 | 1185+   |
      | Grade 12 | BR-834  | 835-899 | 900-1184 | 1185+   |
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Year 1  | BR-BR       | BR-99    | 100-400    | 401+     |
      | Year 2  | BR-99       | 100-299  | 300-600    | 601+     |
      | Year 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Year 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Year 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Year 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Year 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Year 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Year 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Year 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Year 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Year 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Grade 1  | BR-BR       | BR-BR    | 100-400    | 401+     |
      | Grade 2  | BR-BR       | 100-299  | 300-600    | 601+     |
      | Grade 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Grade 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Grade 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Grade 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Grade 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Grade 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Grade 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Grade 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Grade 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Grade 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    When I enter search string "Lui"
    Then I should see Benchmark Page Page Header starting with "Benchmark Proficiency Bands for Lui Class"
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Year 1  | BR-BR       | BR-99    | 100-400    | 401+     |
      | Year 2  | BR-99       | 100-299  | 300-600    | 601+     |
      | Year 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Year 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Year 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Year 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Year 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Year 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Year 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Year 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Year 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Year 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Grade 1  | BR-BR       | BR-BR    | 100-400    | 401+     |
      | Grade 2  | BR-BR       | 100-299  | 300-600    | 601+     |
      | Grade 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Grade 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Grade 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Grade 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Grade 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Grade 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Grade 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Grade 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Grade 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Grade 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    When I click on Save "Global English Language Learners"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Level 1 | Level 2 | Level 3 | Level 4 |
    And I should see the values for grades
      |         | Level 1 | Level 2 | Level 3  | Level 4 |
      | Year 2  | BR-124  | 125-224 | 225-419  | 420+    |
      | Year 3  | BR-234  | 235-324 | 325-519  | 520+    |
      | Year 4  | BR-354  | 355-424 | 425-739  | 740+    |
      | Year 5  | BR-494  | 495-574 | 575-829  | 830+    |
      | Year 6  | BR-539  | 540-649 | 650-924  | 925+    |
      | Year 7  | BR-644  | 645-714 | 715-969  | 970+    |
      | Year 8  | BR-679  | 680-769 | 770-1009 | 1010+   |
      | Year 9  | BR-734  | 735-799 | 800-1049 | 1050+   |
      | Year 10 | BR-779  | 780-829 | 830-1079 | 1080+   |
      | Year 11 | BR-824  | 825-869 | 870-1184 | 1185+   |
      | Year 12 | BR-834  | 835-899 | 900-1184 | 1185+   |
    And I should see the values for grades in Canada
      |          | Level 1 | Level 2 | Level 3  | Level 4 |
      | Grade 2  | BR-124  | 125-224 | 225-419  | 420+    |
      | Grade 3  | BR-234  | 235-324 | 325-519  | 520+    |
      | Grade 4  | BR-354  | 355-424 | 425-739  | 740+    |
      | Grade 5  | BR-494  | 495-574 | 575-829  | 830+    |
      | Grade 6  | BR-539  | 540-649 | 650-924  | 925+    |
      | Grade 7  | BR-644  | 645-714 | 715-969  | 970+    |
      | Grade 8  | BR-679  | 680-769 | 770-1009 | 1010+   |
      | Grade 9  | BR-734  | 735-799 | 800-1049 | 1050+   |
      | Grade 10 | BR-779  | 780-829 | 830-1079 | 1080+   |
      | Grade 11 | BR-824  | 825-869 | 870-1184 | 1185+   |
      | Grade 12 | BR-834  | 835-899 | 900-1184 | 1185+   |
    When I click on Save "LitPro Standard"
    Then 'Benchmark Saved' Message should display
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Year 1  | BR-BR       | BR-99    | 100-400    | 401+     |
      | Year 2  | BR-99       | 100-299  | 300-600    | 601+     |
      | Year 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Year 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Year 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Year 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Year 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Year 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Year 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Year 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Year 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Year 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Grade 1  | BR-BR       | BR-BR    | 100-400    | 401+     |
      | Grade 2  | BR-BR       | 100-299  | 300-600    | 601+     |
      | Grade 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Grade 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Grade 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Grade 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Grade 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Grade 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Grade 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Grade 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Grade 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Grade 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |

  @teacher @wipfix 
  Scenario: Teacher LitPro Benchmark Page LitPro Standard
    Given I browse to Benchmark Page as "Teacher"
    Then I should see Benchmark Page Page Header starting with "Benchmark Proficiency Bands for"
    And I should see benchmark table with following category
      | Below Basic | Basic | Proficient | Advanced |
    And I should see the values for grades
      |         | Below Basic | Basic    | Proficient | Advanced |
      | Year 1  | BR-BR       | BR-99    | 100-400    | 401+     |
      | Year 2  | BR-99       | 100-299  | 300-600    | 601+     |
      | Year 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Year 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Year 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Year 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Year 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Year 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Year 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Year 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Year 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Year 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
    And I should see the values for grades in Canada
      |          | Below Basic | Basic    | Proficient | Advanced |
      | Grade 1  | BR-BR       | BR-BR    | 100-400    | 401+     |
      | Grade 2  | BR-BR       | 100-299  | 300-600    | 601+     |
      | Grade 3  | BR-249      | 250-499  | 500-800    | 801+     |
      | Grade 4  | BR-349      | 350-599  | 600-900    | 901+     |
      | Grade 5  | BR-449      | 450-699  | 700-1000   | 1001+    |
      | Grade 6  | BR-499      | 500-799  | 800-1050   | 1051+    |
      | Grade 7  | BR-549      | 550-849  | 850-1100   | 1101+    |
      | Grade 8  | BR-599      | 600-899  | 900-1150   | 1151+    |
      | Grade 9  | BR-649      | 650-999  | 1000-1200  | 1201+    |
      | Grade 10 | BR-699      | 700-1024 | 1025-1250  | 1251+    |
      | Grade 11 | BR-799      | 800-1049 | 1050-1300  | 1301+    |
      | Grade 12 | BR-799      | 800-1049 | 1050-1300  | 1301+    |

  @admin @regressionlp123 
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
      | Year 2  | BR-124  | 125-224 | 225-419  | 420+    |
      | Year 3  | BR-234  | 235-324 | 325-519  | 520+    |
      | Year 4  | BR-354  | 355-424 | 425-739  | 740+    |
      | Year 5  | BR-494  | 495-574 | 575-829  | 830+    |
      | Year 6  | BR-539  | 540-649 | 650-924  | 925+    |
      | Year 7  | BR-644  | 645-714 | 715-969  | 970+    |
      | Year 8  | BR-679  | 680-769 | 770-1009 | 1010+   |
      | Year 9  | BR-734  | 735-799 | 800-1049 | 1050+   |
      | Year 10 | BR-779  | 780-829 | 830-1079 | 1080+   |
      | Year 11 | BR-824  | 825-869 | 870-1184 | 1185+   |
      | Year 12 | BR-834  | 835-899 | 900-1184 | 1185+   |
    And I should see the values for grades in Canada
      |          | Level 1 | Level 2 | Level 3  | Level 4 |
      | Grade 2  | BR-124  | 125-224 | 225-419  | 420+    |
      | Grade 3  | BR-234  | 235-324 | 325-519  | 520+    |
      | Grade 4  | BR-354  | 355-424 | 425-739  | 740+    |
      | Grade 5  | BR-494  | 495-574 | 575-829  | 830+    |
      | Grade 6  | BR-539  | 540-649 | 650-924  | 925+    |
      | Grade 7  | BR-644  | 645-714 | 715-969  | 970+    |
      | Grade 8  | BR-679  | 680-769 | 770-1009 | 1010+   |
      | Grade 9  | BR-734  | 735-799 | 800-1049 | 1050+   |
      | Grade 10 | BR-779  | 780-829 | 830-1079 | 1080+   |
      | Grade 11 | BR-824  | 825-869 | 870-1184 | 1185+   |
      | Grade 12 | BR-834  | 835-899 | 900-1184 | 1185+   |

  @admin 
  Scenario: Verifying dublicate benchmark
    Given I browse to Benchmark Page as "Admin"
    Then I should click on benckmark dropdown
    Then I should verify the dublicate benchmark