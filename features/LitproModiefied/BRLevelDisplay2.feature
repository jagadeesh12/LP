@BRDisplayChange
Feature: As a product owner, I would like to modify the display of BR Lexile values for books in RP so they reflect changes to the measurement scale.

  
  @LPBRDisplayChange1
  Scenario Outline: Negative Lexile is displayed with a BR prefix on the myresults page for a student set to Lexile class and has negative lexile.
 
    Given I launch RP using "<username>" and "<password>" with "<usertype>"
    #RP-810 RP-542 Then the negative lexile on Home page with "My Lexile" header is displayed with "BR" prefix
    When I click on My Results tab
    Then the negative lexile is displayed with "BR" prefix

    Examples: 
      | username  | password  | usertype | 
      | JonSnow1 | welcome1 | Student  |

  Scenario Outline: Negative lexile is displayed with a BR prefix for a student set to Lexile class
    Given I launch RP using "<username>" and "<password>" with "<usertype>"
    When they navigate to the Reports tab
    When I view a reading report card for a student with negative lexile "<studentname>" "<classname>"
    Then the lexile should be displayed with "BR" prefix on the reading report card
    When I select the class name "<classname>"
    And I should see report card name "Class Reading Report Card"
    When I click on View Report button
    Then the lexile should be displayed with "BR" prefix for the student with negative lexile "<studentname>" "<classname>" on the class reading report card
    When I view the parent letter for a student with negative lexile "<studentname2>"
    Then the lexile should be displayed with "BR" prefix

    Examples: 
      | username              | password  | usertype | studentname       | classname  | studentname2      |
      | TonyStark             | password1 | Teacher  | JonSnow1          | LuiClass  | TestStudent Three |

  Scenario Outline: As a student Negative Lexile is displayed with "BR" prefix for book meta data
    Given I launch RP using "<username>" and "<password>" with "<usertype>"
    And I navigate to browse page as a student in RP
    When I search for a book with negative lexile "<bookname>""<usertype>"
    Then I should see the book with negative lexile with "BR" prefix on the search page "<bookname>"
    When I click on My Results tab
    Then I should see book with a negative lexile with "BR" prefix "<bookname2>" on myresults page

    Examples: 
      | username  | password  | usertype | bookname            | bookname2 | classname  | username1             | password1 | usertype1 |
      | TeststT17 | password1 | Student  | Midnight Horse, The | Horse     | TestClass1 | testteacher2@dev2.com | password1 | Teacher   |

  Scenario Outline: As a teacher I want to verify negative lexile is displayed with "BR" for book meta data
    Given I launch RP using "<username>" and "<password>" with "<usertype>"
    And I navigate to search page
    When I search for a book with negative lexile "<bookname>""<usertype>"
    Then I should see the book with negative lexile with "BR" prefix on the search page "<bookname>"

    Examples: 
      | username              | password  | usertype | bookname            | usertype |
      | testteacher2@dev2.com | password1 | Teacher  | Midnight Horse, The | Teacher  |
