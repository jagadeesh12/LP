@functional @homepage @regressionlp @wip1 @LpHomePage.feature
Feature: LitPro users home page
  As a LitPro user 
  I should be able to view the following on my home page..

  @student @readinginterests @regressionlp123 
  Scenario Outline: Create / Edit Reading Interests
    Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    Then I should see user greeting text 'Welcome, '
    And I should see the header - "What do you like to read? Choose up to three kinds of books."
    And I should see the following reading interest categories:
      | Reading Interest Categories  |
      | Action & Adventure           |
      | Animals & Pets               |
      | Biographies                  |
      | Celebrations                 |
      | Classics                     |
      | Folktales & Legends          |
      | Food & Drink                 |
      | Friends, Family & Growing Up |
      | History                      |
      | Humor                        |
      | Miscellaneous                |
      | Music & Art                  |
      | Mystery                      |
      | Nature & the Environment     |
      | Romance & Relationships      |
      | Science & Technology         |
      | Science Fiction & Fantasy    |
      | Space                        |
      | Sports & Hobbies             |
      | World Cultures & Geography   |
    When I select 3 random categories
    And I click 'Create my reading list' button on my homepage
    Then I should see My reading interests list
    And I click on Edit Reading Interests
    Then I should see the modal popup header - "Choose up to three reading interests"
    And I should see the following reading interest categories in modal popup:
      | Reading Interest Categories  |
      | Action & Adventure           |
      | Animals & Pets               |
      | Biographies                  |
      | Celebrations                 |
      | Classics                     |
      | Folktales & Legends          |
      | Food & Drink                 |
      | Friends, Family & Growing Up |
      | History                      |
      | Humor                        |
      | Miscellaneous                |
      | Music & Art                  |
      | Mystery                      |
      | Nature & the Environment     |
      | Romance & Relationships      |
      | Science & Technology         |
      | Science Fiction & Fantasy    |
      | Space                        |
      | Sports & Hobbies             |
      | World Cultures & Geography   |
    And I will deselect the selected reading interest categories
    Then I select different reading interest categories
    And I click on update reading list button
    Then I should be able to view my updated reading interest categories
    Examples: 
     | username       | password | usertype | 
     | ReadingList    | welcome1 | Student  | 
 
     
    @student @readinginterests @july27 
    Scenario Outline: Verify the created reading interests
    Given I launch LitPro using "<username>" and "<password>" with "<usertype>"
    Then I should see user greeting text 'Welcome, '
    When I have selected my reading interest categories
    Then I should see the header 'Here are some great books to read!'
    And Book title or author name should not be empty
    And all the books should have atleast one of the reading interest categories
	When I click on 'Fast find' button
	Then Book title or author name should not be empty
	And all the books should have atleast one of the reading interest categories
	When I click on Whats New button
	Then Book title or author name should not be empty
	#And all the books should have atleast one of the reading interest categories
    Examples: 
     | username       | password | usertype | 
     | ReadingList    | welcome1 | Student  | 