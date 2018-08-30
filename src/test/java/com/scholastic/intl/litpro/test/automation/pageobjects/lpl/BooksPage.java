package com.scholastic.intl.litpro.test.automation.pageobjects.lpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.regexp.REProgram;
import org.junit.Assert;
import org.omg.stub.java.rmi._Remote_Stub;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg.LitProUserType;

/* @ Author: Rajesh R
 * @ Created Date:04/01/2016
 * @ Functionality: Books Page Page objects 
 * @ Type: Smoke, regression
 * 
 * 
 * @ Updated Date
 * @ Updated By Rajesh R
 * 
 */

public class BooksPage extends ParentPage {
	WebDriver driver;
	final String PAGE_TITLE = "Literacy Pro Library";
	final String PAGE_HEADER = "Students";
	String fileName;
	@FindBy(css = ".lpl-page-title1")
	private WebElement pgHeader;
	@FindBy(css = ".lpl-page-title2")
	private WebElement pgHeader1;
	@FindBy(css = "#searchBooks")
	private WebElement searchBooks;
	@FindBy(css = ".lpl-filter-title")
	private WebElement filter;
	@FindBy(css = ".lpl-span-text2")
	private WebElement filtersText;
	@FindBy(xpath = ".//*[@class='lpl-filter-item-title']/span[contains(text(),'My books')]")
	private WebElement myBooks;
	@FindBy(xpath = ".//*[@class='lpl-filter-item-title']/span[contains(text(),'Reading Level')]")
	private WebElement readingLevel;
	@FindBy(css = ".selected.ng-binding")
	private WebElement dropdownBooks;
	@FindBy(xpath = ".//*[@class='lpl-assignedto-student-popover-subheader-container']/div")
	private WebElement className;
	@FindBy(xpath = ".//*[@class='lpl-btn-choose-multi-books']")
	private WebElement chooseMultipleBooks;
	@FindBy(xpath = ".//*[@class='lpl-btn-choose-multi-books']/button[contains(text(),'Assign Books')]")
	private WebElement assignBooks;
	@FindBy(xpath = ".//*[@class='lpl-btn-choose-multi-books']/button[contains(text(),'Hide Books')]")
	private WebElement hideBooks;
	@FindBy(xpath = ".//*[@class='lpl-btn-choose-multi-books']/button[contains(text(),'Cancel')]")
	private WebElement cancel;
	@FindBy(xpath = ".//*[@class='lpl-book-list-grid container']/div/div/div/div")
	private WebElement assign;
	
	@FindBy(how = How.XPATH, using = "(. //div[@class='lpl-book-assign-quiz']//div[@class='lpl-book-assign']/div[@class='lpl-book-list-book-assign assigned ng-binding ng-scope'])[1]")
	WebElement clickOnAssign_book;
	@FindBy(how = How.XPATH, using = "//button[text()='Read']")
	WebElement Read_InPopup;
	@FindBy(how = How.XPATH, using = "//button[text()='Assign']")
	WebElement Assign_InPopup;
	@FindBy(how = How.XPATH, using = "//button[text()='Assigned']")
	WebElement Assigned_InPopup;
	@FindBy(how = How.XPATH, using = "//span[text()='Assign to']")
	WebElement Assign_to_InPopup;
	@FindBy(how = How.XPATH, using = "//span[text()='Assigned to']")
	WebElement Assigned_to_InPopup;
	@FindBy(how = How.XPATH, using = "//span[text()='Entire Class']")
	//@FindBy(how = How.XPATH, using = "//*[@ng-click='entireSelect();']")
	
	
	WebElement Entire_class;
	@FindBy(how = How.XPATH, using = "//button[text()='Assign to Students']")
	WebElement Assign_to_Students;
	@FindBy(how = How.XPATH, using = "//span[text()='This assignment has been sent to your students']")
	WebElement Assigned_text;
	@FindBy(how = How.XPATH, using = "//button[@id='assignedConfimed']")
	WebElement done_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Hide/Unhide this book']")
	WebElement Hide_Unhide_button;
	@FindBy(how = How.XPATH, using = "//span[@class='lpl-modal-title lpl-modal-title-text ng-scope']")
	WebElement Hide_Unhide_text;
	@FindBy(how = How.XPATH, using = "//button[text()='Save Changes']")
	WebElement save_changes_button;
	@FindBy(how = How.XPATH, using = "(//div[@ng-repeat='book in bookLists']//img)[2]")
	WebElement first_book;
	@FindBy(how = How.XPATH, using = "//img[@class='lpl-margin-top-15px lpl-icon-message-small1']")
	WebElement VIEW_MESSAGES;
	@FindBy(how = How.XPATH, using = "//span[@class='lpl-icon lpl-icon-close lpl-cursor-pointer']")
	WebElement close_button_for_OpenBook;
	@FindBy(how = How.XPATH, using = "//div[@class='lpl-assigned-student-name ng-binding']")
	WebElement entireClass_students;
	@FindBy(how = How.XPATH, using = "//span[text()='Books']")
	WebElement Books_Page;
	@FindBy(how = How.XPATH, using = "(//div[text()='ASSIGNED'])[1]")
	WebElement ASSIGNED;
	@FindBy(how = How.XPATH, using = "//button[text()='Choose Multiple Books']")
	WebElement Choose_Multiple_Books;
	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-lg lpl-btn lpl-multiple-assign-grey'])[1]")
	WebElement Assign_books_disabled;
	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-lg lpl-btn lpl-multiple-assign-grey'])[2]")
	WebElement Hide_books_disabled;
	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-lg lpl-btn btn-primary lpl-btn-blue'])[1]")
	WebElement Assign_books_enabled;
	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-lg lpl-btn btn-primary lpl-btn-blue'])[2]")
	WebElement Hide_books_enabled;
	@FindBy(how = How.XPATH, using = "(//img[@class='lpl-icon-assign'])[1]")
	WebElement ClickOnFirstBook;
	@FindBy(how = How.XPATH, using = "(//img[@class='lpl-icon-assign'])[2]")
	WebElement ClickOnSecondBook;
	@FindBy(how = How.XPATH, using = "(//img[@class='lpl-icon-assign'])[3]")
	WebElement ClickOnThirdBook;
	@FindBy(xpath = "//div[@class='wrap-dd-select ng-isolate-scope']")
	private WebElement ClickOndropDown_Selection_To_Show_Books;
	@FindBy(xpath = "//a[text()='80']")
	private WebElement Select_80;
	@FindBy(xpath = "//a[text()='All']")
	private WebElement Select_All;
	@FindBy(xpath = "//a[text()='40']")
	private WebElement Select_40;
	@FindBy(xpath = "//span[text()='40']")
	private WebElement verify_40;
	@FindBy(xpath = "//span[text()='80']")
	private WebElement verify_80;
	@FindBy(xpath = "//span[text()='All']")
	private WebElement verify_All;
	@FindBy(xpath = "//*[@class='lpl-filter-option ng-binding ng-scope'][text()='Assigned']")
	private WebElement Assigned_Selection_FILTER;
	@FindBy(xpath = "//span[text()='Assigned']")
	private WebElement Verify_Assigned_tag;
	@FindBy(xpath = "//div[text()='ASSIGNED']")
	private WebElement Verify_ASSINGNED_Books_Display;

	// 05/02/2016
	@FindBy(xpath = ".//*[@class='modal-content']//show-quiz-button//span")
	private WebElement QuizButton;
	@FindBy(xpath = "//div[contains(text(),'HOME')]")
	private WebElement homeTab;
	private LitProUserType lpUserType;

	@FindBy(xpath = "(//img[@class='lpl-book-style lpl-avatar-relative lpl-avatar-maxheight'])[2]")
	private WebElement click_on_the_book;
	@FindBy(xpath = "//img[@class='lpl-icon-pencil1']")
	private WebElement SEND_A_MESSAGE_in_open_book;
	@FindBy(xpath = "//div[@ng-if='rightArrow == true']")
	private WebElement next_button_open_book;
	@FindBy(xpath = "//img[@src='app/themes/images/next-grey.png']")
	private WebElement next_button_disable_open_book;
	@FindBy(xpath = "//img[@src='app/themes/images/icon-left-arrow.png']")
	private WebElement previous_button_open_book;
	@FindBy(xpath = "//img[@src='app/themes/images/prev-grey.png']")
	private WebElement previous_button_disable_open_book;
	////////////// 10-02-2016 //////////////////
	@FindBy(xpath = "(//img[@src='app/themes/images/icon-percent-old-notstarted.png'])[1]")
	private WebElement reading_book_status;
	@FindBy(xpath = "//div[div[span[text()='Reading Level']]]/div[1]/span[2]")
	private WebElement reading_level;
	@FindBy(xpath = "//div[text()='Lexile Level']")
	private WebElement Lexile_Level;
	@FindBy(xpath = "//div[span[text()='From']]/input[1]")
	private WebElement Lexile_Level_From;
	@FindBy(xpath = "//div[span[text()='From']]/input[2]")
	private WebElement Lexile_Level_to;
	@FindBy(xpath = "//div[@class='lpl-book-list-grid-item col-md-3 ng-scope'][1]/div[3]/div[2]/div")
	private WebElement filtered_selection_book;
	@FindBy(xpath = "//span[@class='lpl-icon lpl-icon-close']")
	private WebElement close_button_in_popup;
	@FindBy(xpath = "//span[contains(text(),'Lexile:')]/parent::div/span[2]")
	private WebElement Lexile_value;
	//////////////// 15-02-2016 ///////////////////////
	@FindBy(xpath = "//div[text()='Colour Wheel']")
	private WebElement Colour_wheel_header;
	@FindBy(xpath = "//div[text()='Magenta']")
	private WebElement Colour_Magenta;
	@FindBy(xpath = "//div[text()='Red']")
	private WebElement Colour_Red;
	@FindBy(xpath = "//div[text()='Yellow']")
	private WebElement Colour_Yellow;
	@FindBy(xpath = "//div[text()='Blue']")
	private WebElement Colour_Blue;
	@FindBy(xpath = "//div[text()='Green']")
	private WebElement Colour_Green;
	@FindBy(xpath = "//div[text()='Orange']")
	private WebElement Colour_Orange;
	@FindBy(xpath = "//div[text()='Turquoise']")
	private WebElement Colour_Turquoise;
	@FindBy(xpath = "//div[text()='Purple']")
	private WebElement Colour_Purple;
	@FindBy(xpath = "//div[text()='Gold']")
	private WebElement Colour_Gold;
	@FindBy(xpath = "//div[text()='Silver']")
	private WebElement Colour_Silver;
	@FindBy(xpath = "//div[text()='Emerald']")
	private WebElement Colour_Emerald;
	@FindBy(xpath = "//div[text()='Ruby']")
	private WebElement Colour_Ruby;
	@FindBy(xpath = "//div[text()='Sapphire']")
	private WebElement Colour_Sapphire;
	@FindBy(xpath = "//div[span[text()='Colour Wheel:']]/span[2]")
	private WebElement Colour_wheel_name;
	@FindBy(xpath = "//span[text()='Magenta']")
	private WebElement Magenta_tag;
	@FindBy(xpath = "//span[text()='Red']")
	private WebElement Red_tag;
	@FindBy(xpath = "//span[text()='Yellow']")
	private WebElement Yellow_tag;
	@FindBy(xpath = "//span[text()='Blue']")
	private WebElement Blue_tag;
	@FindBy(xpath = "//span[text()='Green']")
	private WebElement Green_tag;
	@FindBy(xpath = "//span[text()='Orange']")
	private WebElement Orange_tag;
	@FindBy(xpath = "//span[text()='Turquoise']")
	private WebElement Turquoise_tag;
	@FindBy(xpath = "//span[text()='Purple']")
	private WebElement Purple_tag;
	@FindBy(xpath = "//span[text()='Gold']")
	private WebElement Gold_tag;
	@FindBy(xpath = "//span[text()='Silver']")
	private WebElement Silver_tag;
	@FindBy(xpath = "//span[text()='Emerald']")
	private WebElement Emerald_tag;
	@FindBy(xpath = "//span[text()='Ruby']")
	private WebElement Ruby_tag;
	@FindBy(xpath = "//span[text()='Sapphire']")
	private WebElement Sapphire_tag;
	@FindBy(xpath = "//div[text()='Reading Level']")
	private WebElement Reading_Level_header;
	@FindBy(xpath = "//div[text()='1-8']")
	private WebElement One_to_8_selection_in_Reading_Level;
	@FindBy(xpath = "//div[text()='9-14']")
	private WebElement Nine_to_14_selection_in_Reading_Level;
	@FindBy(xpath = "//div[text()='15-20']")
	private WebElement Fifteen_to_20_selection_in_Reading_Level;
	@FindBy(xpath = "//div[text()='21-25']")
	private WebElement TwentyOne_to_25_selection_in_Reading_Level;
	@FindBy(xpath = "//div[text()='26-30']")
	private WebElement TwentySix_to_30_selection_in_Reading_Level;
	@FindBy(xpath = "//span[text()='1-8']")
	private WebElement One_to_8_tag;
	@FindBy(xpath = "//span[text()='9-14']")
	private WebElement Nine_to_14_tag;
	@FindBy(xpath = "//span[text()='15-20']")
	private WebElement Fifteen_to_20_tag;
	@FindBy(xpath = "//span[text()='21-25']")
	private WebElement TwentyOne_to_25_tag;
	@FindBy(xpath = "//span[text()='26-30']")
	private WebElement TwentySix_to_30_tag;
	@FindBy(xpath = "//div[span[text()='Reading Level:']]/span[2]")
	private WebElement Reading_Level_Value;
	@FindBy(xpath = "//div[div[div[text()='Colour Wheel']]]/div[2]")
	private WebElement Colour_Values;
	@FindBy(xpath = "//div[div[div[text()='Reading Level']]]/div[2]")
	private WebElement Reading_Values;
	/////////// 16-02-2016 //////////////////////
	@FindBy(xpath = "//span[text()='Genre']")
	private WebElement Genre_header;
	@FindBy(xpath = "//div[span[text()='Genre']]/span[2]")
	private WebElement Genre_button;
	@FindBy(xpath = "//label[div[text()='Fiction']]/span")
	private WebElement Fiction_in_Genre;
	@FindBy(xpath = "//label[div[text()='Non-Fiction']]/span")
	private WebElement NonFiction_in_Genre;
	@FindBy(xpath = "//span[contains(text(),'Genre:')]/parent::div/span[2]")
	private WebElement Genre_type;
	@FindBy(xpath = "//span[text()='Fiction']")
	private WebElement Fiction_tag;
	@FindBy(xpath = "//span[text()='Non-Fiction']")
	private WebElement NonFiction_tag;
	@FindBy(xpath = "//span[text()='Interest category']")
	private WebElement Interest_category_header;
	@FindBy(xpath = "//div[span[text()='Interest category']]/span[2]")
	private WebElement Interest_category_button;
	@FindBy(xpath = "//div[span[text()='Series']]/span[2]")
	private WebElement Series_button;
	@FindBy(xpath = "//div[div[span[text()='Interest category']]]/div[2]")
	private WebElement Interest_category_values;

	@FindBy(xpath = "//div[text()='Action & Adventure']")
	private WebElement Category_Action_Adventure;
	@FindBy(xpath = "//div[text()='Animals & Pets']")
	private WebElement Category_Animals_Pets;
	@FindBy(xpath = "//div[text()='Biographies']")
	private WebElement Category_Biographies;
	@FindBy(xpath = "//div[text()='Caring & Sharing']")
	private WebElement Caring_Sharing;
	@FindBy(xpath = "//div[text()='Celebrations']")
	private WebElement Category_Celebrations;
	@FindBy(xpath = "//div[text()='Friends, Family & Growing Up']")
	private WebElement Category_Friends_Family_GrowingUp;
	@FindBy(xpath = "//div[text()='Food & Drink']")
	private WebElement Category_Food_Drink;
	@FindBy(xpath = "//div[text()='Around the World")
	private WebElement Category_World_Cultures_Geography;
	@FindBy(xpath = "//div[text()='All Time Favourite Stories']")
	private WebElement Category_History;
	@FindBy(xpath = "//div[text()='Fun & Games']")
	private WebElement Category_Humour;
	@FindBy(xpath = "//div[text()='Funny Stories']")
	private WebElement Category_Romance_Relationships;
	@FindBy(xpath = "//div[text()='In the Past']")
	private WebElement Category_Miscellaneous;
	@FindBy(xpath = "//div[text()='Music & Art']")
	private WebElement Category_Music_Art;
	@FindBy(xpath = "//div[text()='Mystery']")
	private WebElement Category_Mystery;
	@FindBy(xpath = "//div[text()='Folktales & Legends']")
	private WebElement Category_Folktales_Legends;
	@FindBy(xpath = "//div[text()='Nature & the Environment']")
	private WebElement Category_Nature_theEnvironment;
	@FindBy(xpath = "//div[text()='Science & Technology']")
	private WebElement Category_Science_Technology;
	@FindBy(xpath = "//div[text()='Science Fiction & Fantasy']")
	private WebElement Category_Science_Fiction_Fantasy;
	@FindBy(xpath = "//div[text()='Space']")
	private WebElement Category_Space;
	/*@FindBy(xpath = "//div[text()='Sports & Hobbies']")
	private WebElement Category_Sports_Hobbies;*/

	@FindBy(xpath = "//span[text()='Action & Adventure']")
	private WebElement tag_Action_Adventure;
	@FindBy(xpath = "//span[text()='Animals & Pets']")
	private WebElement tag_Animals_Pets;
	@FindBy(xpath = "//span[text()='Biographies']")
	private WebElement tag_Biographies;
	@FindBy(xpath = "//span[text()='Caring & Sharing']")
	private WebElement tag_Classics;
	@FindBy(xpath = "//span[text()='Celebrations']")
	private WebElement tag_Celebrations;
	@FindBy(xpath = "//span[text()='Friends, Family & Growing Up']")
	private WebElement tag_Friends_Family_GrowingUp;
	@FindBy(xpath = "//span[text()='Food & Drink']")
	private WebElement tag_Food_Drink;
	@FindBy(xpath = "//span[text()='Around the World']")
	private WebElement tag_World_Cultures_Geography;
	@FindBy(xpath = "//span[text()='All Time Favourite Stories']")
	private WebElement tag_History;
	@FindBy(xpath = "//span[text()='Fun & Games']")
	private WebElement tag_Humour;
	@FindBy(xpath = "//span[text()='Funny Stories']")
	private WebElement tag_Romance_Relationships;
	@FindBy(xpath = "//span[text()='In the Past']")
	private WebElement tag_Miscellaneous;
	@FindBy(xpath = "//span[text()='Music & Art']")
	private WebElement tag_Music_Art;
	@FindBy(xpath = "//span[text()='Mystery']")
	private WebElement tag_Mystery;
	@FindBy(xpath = "//span[text()='Folktales & Legends']")
	private WebElement tag_Folktales_Legends;
	@FindBy(xpath = "//span[text()='Nature & the Environment']")
	private WebElement tag_Nature_theEnvironment;
	@FindBy(xpath = "//span[text()='Science & Technology']")
	private WebElement tag_Science_Technology;
	@FindBy(xpath = "//span[text()='Science Fiction & Fantasy']")
	private WebElement tag_Science_Fiction_Fantasy;
	@FindBy(xpath = "//span[text()='Space']")
	private WebElement tag_Space;
	/*@FindBy(xpath = "//span[text()='Sports & Hobbies']")
	private WebElement tag_Sports_Hobbies;*/

	@FindBy(xpath = "//img[@src='./images/category_icons/action.png']")
	private WebElement icon_Action_Adventure;
	@FindBy(xpath = "//img[@src='./images/category_icons/animals_pets.png']")
	private WebElement icon_Animals_Pets;
	@FindBy(xpath = "//img[@src='./images/category_icons/famous_people.png']")
	private WebElement icon_Biographies;
	@FindBy(xpath = "//img[@src='./images/category_icons/alltime_favorite_stories.png']")
	private WebElement icon_Classics;
	@FindBy(xpath = "//img[@src='./images/category_icons/celebrations.png']")
	private WebElement icon_Celebrations;
	@FindBy(xpath = "//img[@src='./images/category_icons/friends_family_growingup.png']")
	private WebElement icon_Friends_Family_GrowingUp;
	@FindBy(xpath = "//img[@src='./images/category_icons/food_drink.png']")
	private WebElement icon_Food_Drink;
	@FindBy(xpath = "//img[@src='./images/category_icons/around_the_world.png']")
	private WebElement icon_World_Cultures_Geography;
	@FindBy(xpath = "//img[@src='./images/category_icons/in_the_past.png']")
	private WebElement icon_History;
	@FindBy(xpath = "//img[@src='./images/category_icons/funny_stories.png']")
	private WebElement icon_Humour;
	@FindBy(xpath = "//img[@src='./images/category_icons/caring_sharing.png']")
	private WebElement icon_Romance_Relationships;
	@FindBy(xpath = "//img[@src='./images/category_icons/everything_else.png']")
	private WebElement icon_Miscellaneous;
	@FindBy(xpath = "//img[@src='./images/category_icons/music_art.png']")
	private WebElement icon_Music_Art;
	@FindBy(xpath = "//img[@src='./images/category_icons/mystery.png']")
	private WebElement icon_Mystery;
	@FindBy(xpath = "//img[@src='./images/category_icons/folktales_legends.png']")
	private WebElement icon_Folktales_Legends;
	@FindBy(xpath = "//img[@src='./images/category_icons/nature_the_earth.png']")
	private WebElement icon_Nature_theEnvironment;
	@FindBy(xpath = "//img[@src='./images/category_icons/how_things_work.png']")
	private WebElement icon_Science_Technology;
	@FindBy(xpath = "//img[@src='./images/category_icons/science_fiction_fantasy.png']")
	private WebElement icon_Science_Fiction_Fantasy;
	@FindBy(xpath = "//img[@src='./images/category_icons/space.png']")
	private WebElement icon_Space;
	@FindBy(xpath = "//img[@src='./images/category_icons/fun_games.png']")
	private WebElement icon_Sports_Hobbies;
	////////////////// 17-02-2016 ///////////////////////
	@FindBy(xpath = "(//img[@src='app/themes/images/icon-info2.png'])[1]")
	private WebElement filtered_selection_book_student;
	///////////////// 18-02-2016////////////////////
	@FindBy(xpath = "//div[@class='lpl-message-container']")
	private WebElement message_container_header;
	@FindBy(xpath = "//span[@class='lpl-select-dropdown ng-scope']")
	private WebElement dropDown_to_select_students_for_sending_message;
	@FindBy(xpath = "//span[@class='lpl-modal-title lpl-modal-title-text lpl-margin-15px-20px pull-left']")
	private WebElement Students_class_header;
	@FindBy(xpath = "html/body/div[5]/div/div/div[3]/label/span")
	private WebElement entire_class_selection_for_sending_message;
	@FindBy(xpath = ".//*[@id='assign-main-container']/div[1]/div/label/span")
	private WebElement student1_for_sending_message;
	@FindBy(xpath = ".//*[@id='assign-main-container']/div[2]/div/label/span")
	private WebElement student2_for_sending_message;
	@FindBy(xpath = ".//*[@id='assign-main-container']/div[3]/div/label/span")
	private WebElement student3_for_sending_message;
	@FindBy(xpath = ".//*[@id='assign-main-container']/div[4]/div/label/span")
	private WebElement student4_for_sending_message;
	@FindBy(xpath = "//button[@class='btn lpl-message-button-send lpl-btn-blue ']")
	private WebElement select_message_recipients;
	@FindBy(xpath = ".//*[@id='book-reader-page']/div[5]/div/div[2]/textarea")
	private WebElement Text_area_for_sending_message;
	@FindBy(xpath = "//button[text()='Send']")
	private WebElement Send_button_for_sending_message;
	@FindBy(xpath = "//div[@class='confirm-text']")
	private WebElement confirmation_message_after_sent_message;
	@FindBy(xpath = "//button[@id='pop-up-button-yes']")
	private WebElement Okay_button_in_confirmation_message;
	///////////////// 22-02-2016 //////////////////////////
	@FindBy(xpath = "//input[@id='searchBooks']")
	private WebElement Search_field;
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-search lpl-icon-search lpl-color-grey5 lpl-cursor-pointer']")
	private WebElement Search_button;
	@FindBy(xpath = "//span[@class='lpl-modal-title ng-binding']")
	private WebElement Header_of_OpenBook;
	@FindBy(how = How.XPATH, using = "//span[text()='This assignment has been sent to your student']")
	WebElement Assigned_text_single;
	@FindBy(xpath = ".//button[text()='Clear all assignments']")
	private WebElement clearAllAssignments;
    @FindBy(xpath=".//div[text()='Hidden']")
    WebElement hiddenFilter;
	
    @FindBy(xpath = ".//*[@id='epub-reader-container']")
	private WebElement ReadContainer;
	
	@FindBy(xpath = "//button/span[contains(text(),'View Quiz')]")
	private WebElement ViewQuizBtn;
	
	@FindBy(xpath = "//button/span[contains(text(),'Take Quiz')]")
	private WebElement TakeQuizBtn;
	
	@FindBy(xpath = ".//*[@id='navSearch']/a/span")
	private WebElement LPSearchTab;
	
	@FindBy(xpath = ".//*[@id='mainSearch']/div[1]/div[3]/div[1]/input")
	private WebElement LPSearchBox;
	
	@FindBy(xpath = ".//*[@id='mainSearch']/div[1]/div[3]/div[1]/button")
	private WebElement LPSearchbtn;
  
    @FindBy(xpath="//span[contains(text(),'Recent Assignments')]")
    WebElement RecentAssignments;
    
    @FindBy(xpath = "//div[@class='lpl-booklist-right-container ng-scope']//img")
	private WebElement nextbuttonReadingPOPUp;

	@FindBy(xpath = "(//button[contains(text(),'Read')])[1]")
	private WebElement ReadBtns;
			
	@FindBy(xpath = "//span[@ng-bind='bookDetails.name']")
	private WebElement HidebookTitle;
	
	@FindBy(xpath="(//div[@class='lpl-youngerstudent-booklist-container lpl-height-230px lpl-margin-bottom-40px']//img[@src='app/themes/images/icon-info.png'])[3]")
    WebElement NotStartedHomeSelfAssigned;
		    		
    @FindBy(xpath="(//img[@src='app/themes/images/icon-percent-old-notstarted.png'])[1]/parent::div/img[1]")
    WebElement NotStartedHome;

	@FindBy(xpath = "//span[@ng-click='closeAssignToPopup()']")
	private WebElement ClosePopup;
	
	@FindBy(xpath = "//button/i[@class='img-btn-close']")
	private WebElement CloseBtn;
	
	@FindBy(xpath = "//input[@value='Done']")
	private WebElement DoneBtn;

	@FindBy(xpath = "//button[contains(text(),'Yes, quit')]")
	private WebElement YesQuit;
	
	@FindBy(xpath = ".//*[@id='takeQuiz']/a")
	private WebElement SearcbtnTab;

	@FindBy(xpath = ".//*[@id='student-search-form']/div[1]/div[1]/input")
	private WebElement SearcTxtBox;
	
	@FindBy(xpath = ".//*[@id='student-search-form']/div[1]/div[1]/button")
	private WebElement SearcbtnStu;
	
	@FindBy(xpath = "//input[@analytics-category='Quiz-Exit']")
	private WebElement ExitQuiz;
	
	@FindBy(xpath = "//div[contains(text(),'ASSIGN')]")
	private WebElement AssignBtn;
	
	@FindBy(xpath = "(//button[contains(text(),'Assign')])[2]")
	private WebElement AssignPOPupBtn;

	@FindBy(xpath = ".//*[@id='book-reader-page']//input[@class='lpl-modal-pagination-textbox ng-pristine ng-untouched ng-valid']")
	private WebElement PageNumInput;
	
	@FindBy(xpath = "//span[contains(text(),'Reading Level')]/parent::div/span[2]")
	private WebElement ReadingLevelAdd;
	
	@FindBy(xpath = "//span[contains(text(),'Reading Level')]/parent::div/span[@class='glyphicon lpl-float-right lpl-fontsize-12px lpl-color-blue1 glyphicon-minus']")
	private WebElement ReadingLevelMinus;

	@FindBy(xpath = "//span[@ng-if='bookDetails.lexileLevel && !bookDetails.lexileCode']")
	private WebElement Lexile;
	
	@FindBy(xpath = "(//img[@src='app/themes/images/icon-right-arrow.png'])[3]")
	private WebElement nextbuttonReadingPOPUpHome;
	
	@FindBy(xpath = "//span[@class='lpl-icon lpl-icon-close']")
	private WebElement Close;

	@FindBy(xpath = "(//img[@src='app/themes/images/icon-info2.png'])[1]")
	private WebElement IconBtn;

	@FindBy(xpath = "//div[@class='lpl-book-list-search lpl-margin-top-12px']/span")
	private WebElement SrchBtn;
	
	@FindBy(xpath = ".//*[@id='searchBooks']")
	private WebElement SrchTxtBx;
	
	@FindBy(xpath = "//div[contains(@class,'lpl-book-list-search')]/span")
	private WebElement SrchBtnTch;

	@FindBy(xpath = "//input[@ng-model='lexile.lexileFrom']")
	private WebElement StartLexileTxt;
	
	@FindBy(xpath = "//input[@ng-model='lexile.lexileTo']")
	private WebElement EndLexileTxt;

	@FindBy(xpath = "//img[@src='app/themes/images/next-grey.png']")
	private WebElement nextbuttonGrey;

    @FindBy(xpath = "(//div[@class='owl-next']//a/img)[2]")
	private WebElement nextbuttonBookSeleted;

	@FindBy(xpath = ".//*[@id='pop-up-button-yes']")
	private WebElement OkeyMessage;
	
	@FindBy(xpath = "//img[@src='app/themes/images/icon-email.png']")
	private WebElement SendMessage;

	@FindBy(xpath = "//img[@alt='send audio recording']")
	private WebElement Audio;
	
	@FindBy(xpath = "//img[@src='app/themes/images/icon-record.png']")
	private WebElement Record;
	
	@FindBy(xpath = "(//img[@src='app/themes/images/icon-pause.png'])[2]")
	private WebElement Pause;
	
	@FindBy(xpath="(//div[@class='modal-body']//label[@class='gray-out'])[1]")
    WebElement StudentDisable;
	
	private WebElement NotStarted;
	public static String bookstitle;
	public static String img;	

	//

	//
	//
	//

	@FindBy(xpath = "//div[@class='lpl-book-assign-quiz']//div[text()='ASSIGN']")
	private WebElement AssingBtn;
	
	String books;
	public void clickOnAssign() throws InterruptedException {
		try{
			books = driver.findElement(By.xpath("(. //div[@class='lpl-book-assign-quiz']//div[@class='lpl-book-assign']/div[@class='lpl-book-list-book-assign assigned ng-binding ng-scope'])[1]/parent::div/parent::div/parent::div/div[2]/img")).getAttribute("src");
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        executor.executeScript("arguments[0].click();", AssingBtn);
		}
		catch (Exception e){
			
			/*clickOnASSIGNED();
			clickOn_Assigned_InPopup();
			clickOnEntire_class();
			clickOn_save_changes_button();*/
			//driver.findElement(By.xpath("(.//paging/ul/li[3]/span)[1])")).click();
			Thread.sleep(5000);
			books = driver.findElement(By.xpath("(. //div[@class='lpl-book-assign-quiz']//div[@class='lpl-book-assign']/div[@class='lpl-book-list-book-assign assigned ng-binding ng-scope'])[1]/parent::div/parent::div/parent::div/div[2]/img")).getAttribute("src");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", clickOnAssign_book);
		}
	}

	public void clickOnASSIGNED() {
		lazyWait(4);
		this.sync(ASSIGNED);
       JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        executor.executeScript("arguments[0].click();", ASSIGNED);
	}

	public void clickOnAssign_books_enabled() {
		
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-lg lpl-btn btn-primary lpl-btn-blue'])[1]")));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", element);
		//Assign_books_enabled.click();
	}

	public void clickOnHide_books_enabled() {
		Hide_books_enabled.click();
	}

	public void ClickOnFirstBook() {
		this.sync(ClickOnFirstBook).click();
	}

	public void ClickOnSecondBook() {
		this.sync(ClickOnSecondBook).click();
	}

	public void ClickOnThirdBook() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", ClickOnThirdBook);
		//this.click(this.takeQuizBtn);
		 executor.executeScript("arguments[0].click();", ClickOnThirdBook);
		//this.sync(ClickOnThirdBook).click();
	}

	public void clickOn_Read_InPopup() {
		Read_InPopup.click();
	}

	public void clickOn_Choose_Multiple_Books() {
		this.sync(Choose_Multiple_Books).click();
	}

	public void clickOn_save_changes_button() {
		this.sync(save_changes_button);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", save_changes_button);
		lazyWait(4);
	}

	public void clickOn_first_book_BooksTab() {
		first_book.click();
	}

	public void clickOn_close_button_for_OpenBook() {
		this.sync(close_button_for_OpenBook).click();
	}

	public void clickOn_Assign_InPopup() {
		img = driver.findElement(By.xpath("//div[@class='lpl-bookdetails-left']/img")).getAttribute("src");
		Assign_InPopup.click();
	}

	public void clickOn_Assigned_InPopup() {
		this.sync(Assigned_InPopup).click();
	}

	public void clickOnEntire_class() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
      boolean entireSelected =  (Boolean) executor.executeScript("return $('#entire-select').is(':checked')");
		
      try{
    	  if(!entireSelected){
      System.out.println(entireSelected);
          Entire_class.click();
    	  }
		else{
			System.out.println("sdasdsad" +entireSelected);
			/*Entire_class.click();
			Thread.sleep(3000);
			Entire_class.click();*/
			Thread.sleep(3000);
		}
      }
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickOnAssign_to_Students() {
		lazyWait(3);
		this.sync(Assign_to_Students);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", Assign_to_Students);
        executor.executeScript("arguments[0].click();", Assign_to_Students);
	}

	public String Assigned_text() {
		String value = this.sync(Assigned_text).getText();
		return value;
	}

	public void clickOndone_button() {
		this.sync(done_button).click();
	}

	public void clickOn_hide_unhide_Button() {
		lazyWait(4);
		this.sync(Hide_Unhide_button);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Hide_Unhide_button);
		lazyWait(4);
		//Hide_Unhide_button.click();
	}

	public boolean isReadbuttondislayed() {
		if (this.sync(Read_InPopup).isDisplayed())
			return true;
		else
			return false;
	}

	public boolean isEntireClass_students_dislayed() {
		if (entireClass_students.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isAssign_books_hidden_button_displayed() {
		if (Assign_books_disabled.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isHide_books_hidden_button_displayed() {
		if (Hide_books_disabled.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isAssign_books_enabled_button_displayed() {
		if (Assign_books_enabled.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isHide_books_enabled_button_displayed() {
		if (Hide_books_enabled.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isBooks_Page_dislayed() throws InterruptedException {
		this.sync(Books_Page);
		/*Thread.sleep(5000);
		clickClearButton();*/
		if (Books_Page.isDisplayed())
			return true;
		else
			return false;

	}
	
	public boolean isBooks_HideBook_Grey(){
		boolean result =false;
		String xpaths = "//div[@class='lpl-book-list-book-img']/img[@class='lpl-book-style gray-out' and @src='"+books+"']";
		System.out.println("------------------------------------"+xpaths);
		try{
			if(driver.findElement(By.xpath(xpaths)).isDisplayed()){
				result = true;
			}
		} catch(Exception e){
			reportLog("Hidden book is not displayed");
		}		
		return result;
	}
	
	public void AssignHiddenBook(){
		String xpaths = "//div[@class='lpl-book-list-book-img']/img[@class='lpl-book-style gray-out' and @src='"+books+"']/parent::div/parent::div//div[@class='lpl-book-list-book-assign assigned ng-binding ng-scope']";
		System.out.println("------------------------------------"+xpaths);
		//driver.findElement(By.xpath(xpaths)).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpaths)));
		
		
		click(driver.findElement(By.xpath("(//button[3])[2]")));
	}
	
	public boolean HiddenBookStudentDisable(){
		boolean result =false;
		try{
			if(StudentDisable.isDisplayed()){
				result=true;
				reportLog("Students are disabled for hidden books");
				
			}
		} catch(Exception e){
			reportLog("Hidden book is not displayed");
		}
		return result;		
	}
	

	public boolean isAssignbuttondislayed() {
		if (this.sync(Assign_InPopup).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isAssignedbuttondislayed() {
		if (Assigned_InPopup.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isViewMessagesDisplayed() {
		if (this.sync(VIEW_MESSAGES).isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isAssign_to_text_displayed() {
		this.sync(Assign_to_InPopup);
		if (Assign_to_InPopup.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isAssigned_to_text_displayed() {
		this.sync(Assigned_to_InPopup);
		if (Assigned_to_InPopup.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean is_hide_Unhide_text_displayed() throws InterruptedException {
		Thread.sleep(3000);
		this.sync(driver.findElement(By.xpath("//span[@class='lpl-modal-title lpl-modal-title-text ng-binding ng-scope']")));
		if ((driver.findElement(By.xpath("//span[@class='lpl-modal-title lpl-modal-title-text ng-binding ng-scope']")).getText().contains("Hide/Unhide From:")))
			return true;
		else
			return false;

	}
	
	public boolean isHide_Unhide_button_displyed() {
		this.sync(Hide_Unhide_button);
		bookstitle = getText(HidebookTitle);
		img = driver.findElement(By.xpath("//div[@class='lpl-bookdetails-left']/img")).getAttribute("src");
		if (Hide_Unhide_button.isDisplayed())
			return true;
		else
			return false;

	}
	
	public boolean ValidateBookVisiblity(){
		boolean result = false;
		String Xpath = "//img[@src=\""+img+"\"]";
		System.out.println("------------------------"+Xpath);
		int num = driver.findElements(By.xpath(Xpath)).size();
		System.out.println(num);
		if(num>0){
			result=true;
		}
		return result;
	}
	
	public boolean VerifyBooksInRecentAssignments(){
		boolean result = false;
		isVisible(previous_button_disable_open_book);
		String Xpath = "(//div[@class='owl-wrapper'])[1]//img[@src=\""+img+"\"]";
		System.out.println("------------------------"+Xpath);
		int num = driver.findElements(By.xpath(Xpath)).size();
		System.out.println(num);
		if(num>0){
			reportLog("Found the book assingned to student in Recent Assignment section");
			result=true;
		}
		return result;
	}
	
	
	
	public void Hometab(){
		 click(homeTab);
	}
	
	public void Searchhiddenbook(){
		System.out.println("------------------------------------"+bookstitle);
		SrchTxtBx.sendKeys(bookstitle);
	}
	
	public void LexileRangeStudent(String StrtLexile, String EndLexile) throws InterruptedException {
		reportLog("Searching for the books in the lexile range of "+StrtLexile+" and "+EndLexile);
		lazyWait(2);
		type(StartLexileTxt, StrtLexile);
		type(EndLexileTxt, EndLexile);
	}

	public BooksPage(WebDriver driver) {

		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(this.DRIVER_WAIT);

	}

	public String getHeaderText() {
		return this.getText(pgHeader);
	}

	public boolean isFilterDisplayed() {
		if (filter.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isMybooksDisplayed() {
		if (myBooks.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean readingLevelDisplayed() {
		if (readingLevel.isDisplayed())
			return true;
		else
			return false;

	}

	public void selectNoOfBooks(String number) {
		reportLog("Select dropdown");
		Select dropdown = new Select(driver.findElement(By.className(".//*[@class='dropdown-item ng-isolate-scope']")));
		dropdown.selectByVisibleText(number);

	}

	public boolean selectBook() {
		reportLog("Select book");
		this.sync(driver.findElement(By.xpath(".//*[@class='lpl-book-list-grid-row row']/div[1]"))).click();
		return true;

	}

	public boolean closeBook() {
		reportLog("close book");
		this.sync(driver.findElement(By.xpath(".//*[@id='book-reader-page']/div[2]/span[2]"))).click();
		return true;

	}

	public boolean assignDisplayed() {
		return false;

	}

	public boolean isClassDisplayed() {
		reportLog("Class displayed");
		this.sync(className).isDisplayed();
		return true;
	}

	public boolean verifyBookPage() {
		if (pgHeader.getText().contains("Books"))
			return true;
		else
			return false;
	}

	public boolean verifyBookHeader() {
		reportLog("verifyBookHeader");
		if (pgHeader1.getText().contains("Assign"))
			return true;
		else
			return false;
	}

	public void assignBookToStudent() {
		reportLog("Assign Book to Student");
		List<WebElement> books = assign.findElements(By.xpath("div"));
		for (WebElement ele : books) {
			if (ele.getText().equals("assign")) {
				ele.click();
				break;
			} else {
				this.reportLog("Assign book is  NOT present/enabl");
			}
		}
	}

	public boolean isSendAMessageIconEnabled() {
		boolean flag = false;
		reportLog("Message Icon enabled Status ");
		String messageicon = this.getAttribute(driver.findElement(By.xpath(".//*[@class='lpl-icon-pencil1']")), "src");

		if (messageicon.contains("disabled")) {
			flag = true;

		} else {
			if (messageicon.contains("enabled"))

				flag = false;
		}
		return flag;

	}

	public String getbooktitleLPL() {
		reportLog("get book title");
		String bookTitle = null;

		bookTitle = this.sync(driver.findElement(By.cssSelector(".lpl-modal-title.ng-binding"))).getText();

		return bookTitle;

	}

	public boolean writeAMessageHeaderIsDisplayed() {
		if (this.sync(driver.findElement(By.cssSelector(".lpl-reader-message-title.ng-scope"))).getText()
				.contains("Write a message about this "))
			return true;
		else
			return false;
	}

	public void writeAMessageToStudents(String Message) {
		this.sync(driver.findElement(By.cssSelector(".lpl-reader-message-comment.ng-pristine.ng-untouched.ng-valid")))
				.sendKeys(Message);
	}

	public void sendMessageToStudentsButton() {
		this.sync(driver
				.findElement(By.xpath(".//*[@class='lpl-message-button-container']/button[contains(text(),'Send')]")))
				.click();
	}

	public void cancelMessageToStudentsButton() {
		this.sync(driver
				.findElement(By.xpath(".//*[@class='lpl-message-button-container']/button[contains(text(),'Cancel')]")))
				.click();
	}

	public void selectStudents() {
		this.sync(driver.findElement(By.cssSelector(".lpl-select-dropdown.ng-scope"))).click();
	}

	public String assignBooksToStudent(String Students) {
		assignBookToStudent();

		driver.switchTo().activeElement();
		String booktitle = this.sync(driver.findElement(By.cssSelector(".btn.lpl-btn-blue.btn-primary.ng-scope ")))
				.getText();
		this.sync(driver.findElement(By.cssSelector(".btn.lpl-btn-blue.btn-primary.ng-scope "))).click();
		this.lazyWait(2);
		driver.switchTo().activeElement();
		if (Students.equals("All")) {
			this.sync(driver.findElement(By.xpath(".//*[@id='entire-select'][@type='checkbox'] "))).click();
		}
		this.sync(driver.findElement(By.xpath(".//*[@id='mCSB_3_container']//div[3]/label/input[@type='checkbox']")))
				.click();
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Assign to Students')]"))).click();
		this.lazyWait(2);
		driver.switchTo().activeElement();
		this.sync(driver.findElement(By.xpath(".//*[@id='assignedConfimed']]"))).click();

		return booktitle;
	}

	public String unassignBooksToStudent(String Students) {
		assignBookToStudent();

		driver.switchTo().activeElement();
		String booktitle = this.sync(driver.findElement(By.cssSelector(".btn.lpl-btn-blue.btn-primary.ng-scope ")))
				.getText();
		this.sync(driver.findElement(By.cssSelector(".btn.lpl-btn-blue.btn-primary.ng-scope "))).click();
		this.lazyWait(2);
		driver.switchTo().activeElement();
		if (Students.equals("All")) {
			this.sync(driver.findElement(By.xpath(".//*[@id='entire-select'][@type='checkbox'] "))).click();
		}
		this.sync(driver.findElement(By.xpath(".//*[@id='mCSB_3_container']//div[3]/label/input[@type='checkbox']")))
				.click();
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Assign to Students')]"))).click();
		this.lazyWait(2);
		driver.switchTo().activeElement();
		this.sync(driver.findElement(By.xpath(".//*[@id='assignedConfimed']]"))).click();

		return booktitle;
	}

	public boolean chooseMultipleBooksIsDisplayed() {
		reportLog("Choose Multiple Books is Displayed ");
		this.sync(chooseMultipleBooks).isDisplayed();
		return true;
	}

	public boolean openAssignedBookFromTeacher() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("''''''''''''''''''''''''''"+getbooktitlesb());
		String xpath = "(//img[@src='"+getbooktitlesb()+"'])[2]";
		/*this.sync(driver.findElement(By.xpath(xpath)))
				.click();*/	
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
		return true;

	}

	public boolean selectStudentsToSendMessage() throws InterruptedException {
		//this.sync(driver.findElement(By.xpath("//img[@class='lpl-icon-pencil1']"))).click();
		this.sync(driver.findElement(By.xpath(".//*[@class='lpl-message-to-container']/span[1]"))).click();
		Thread.sleep(3000);
		this.sync(driver.findElement(By.xpath("//span[text()='Entire Class']"))).click();
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Select Message Recipients ')]"))).click();
		return true;

	}

	public void writeAMessageToStudentsFromAssignedBook(String Message) {
		this.sync(driver.findElement(By.xpath(".//textarea"))).sendKeys(Message);
		sendMessageToStudentsButton();
	}

	public boolean isSucessMessageDisplayed() {

		if (this.sync(driver.findElement(By.cssSelector(".confirm-text"))).getText()
				.contains("Your message has been sent"))
			return true;
		else
			return false;

	}

	public void clickOnMessageIcon() throws InterruptedException {
		Thread.sleep(20000);

		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		this.sync(
				driver.findElement(By.xpath("//img[@class='lpl-icon-pencil1']")));
		
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@alt='send a message']")));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", element);
	}

	public void ClickOndropDown_Selection_To_Show_Books() {
		this.sync(ClickOndropDown_Selection_To_Show_Books).click();
	}

	public void ClickOn_Select_40() {
		this.sync(Select_40).click();
	}

	public void ClickOn_Select_80() {
		this.sync(Select_80).click();
	}

	public void ClickOn_Select_All() {
		this.sync(Select_All).click();
		lazyWait(5);
	}

	public void ClickOn_Assigned_Selection_FILTER() {
		this.sync(Assigned_Selection_FILTER);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Assigned_Selection_FILTER);
		
	}

	public boolean is_Show_40_displayed() {
		if (verify_40.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean is_Assigned_tag_displayed() {
		if (Verify_Assigned_tag.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean is_ASSINGNED_Books_displayed() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (Verify_ASSINGNED_Books_Display.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean is_Show_80_displayed() {
		if (verify_80.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean is_Show_All_displayed() {
		if (verify_All.isDisplayed())
			return true;
		else
			return false;

	}

	public boolean isQuizButtondisplayed() { 
		lazyWait(5);
		bookload();
		wait.until(ExpectedConditions.visibilityOf((QuizButton)));
		if (this.sync(QuizButton).isDisplayed())
			return true;
		else
			return false;

	}

	public LitProLibraryHomePg goToHomePage() throws InterruptedException {
		Thread.sleep(5000);
		this.click(this.homeTab);
		return new LitProLibraryHomePg(driver, lpUserType);
	}
	/////////// 01-02-2016 ///////////////////////

	public void ClickOn_the_book() {
		this.sync(click_on_the_book).click();
	}

	public boolean is_SEND_A_MESSAGE_in_open_book_displayed() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (SEND_A_MESSAGE_in_open_book.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOn_next_button_open_book() {
		while (next_button_open_book.isDisplayed()) {
			// this.sync(next_button_Recent_Assignments).click();
			try {
				this.sync(next_button_open_book).click();
			} catch (Exception e) {
				//System.out.println("Next Button is not displayed");
			}
		}
	}

	public void clickOn_previous_button_open_book() {

		while (previous_button_open_book.isDisplayed()) {
			// this.sync(next_button_Recent_Assignments).click();
			try {
				this.sync(previous_button_open_book).click();

			} catch (Exception e) {
				//System.out.println("Previous Button is not displayed");
			}

		}
	}

	public boolean is_next_button_disable_in_open_book_displayed() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (next_button_disable_open_book.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean is_previous_button_disable_in_open_book_displayed() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (previous_button_disable_open_book.isDisplayed())
			return true;
		else
			return false;
	}

	public String Assigned_text_single() {
		String value = Assigned_text_single.getText();
		return value;
	}

	//////////////////// 10-02-2016 ///////////////////
	public String reading_book_status() {
		lazyWait(5);
		this.sync(reading_book_status);
		String value = reading_book_status.getAttribute("ng-if");
		return value;
	}

	public void clickOn_reading_level() {
		lazyWait(5);
		if(!(driver.findElement(By.xpath("//div[div[span[text()='Reading Level']]]/div/div[@ng-repeat='subfilter in filter.subFilterList']")).isDisplayed()))
				{
				this.sync(reading_level).click();
				}
	}

	public boolean is_Lexile_Level_Displayed() {
		if (this.sync(Lexile_Level).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void Lexile_Level_From(String value) throws InterruptedException {
		this.sync(Lexile_Level_From).clear();
		this.sync(Lexile_Level_From).sendKeys(value);
		Thread.sleep(1000);
	}

	public void Lexile_Level_to(String value) throws InterruptedException {
		this.sync(Lexile_Level_to).clear();
		this.sync(Lexile_Level_to).sendKeys(value);
		Thread.sleep(3000);
	}

	public void clickOn_filtered_selection_book() throws InterruptedException {
		Thread.sleep(2000);
		this.sync(filtered_selection_book).click();
	}

	public void clickOn_close_button_in_popup() {
		this.sync(close_button_in_popup).click();
	}

	public void Lexile_value_validation() {
		String actual = Lexile_value.getText();

		actual = actual.replaceAll("[^\\d.]", "");
		for (int expected1 = 10; expected1 <= 1000; expected1++) {
			String tes = expected1 + "";
			if (tes.equalsIgnoreCase(actual)) {
				break;
			} else {
			}
		}
	}
	/////////////// 15-02-2016 /////////////////////

	public boolean is_Colour_wheel_header_Displayed() {
		if (this.sync(Colour_wheel_header).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickOn_Colour_Magenta() {
		this.sync(Colour_Magenta).click();
	}

	public void validation_of_colour_wheel_name() {
		String actual = this.sync(Colour_wheel_name).getText();
		//System.out.println("ACTUAL IS: " + actual);
		String expected = "Magenta";
		Assert.assertEquals("Values are not same", actual, expected);
	}

	public boolean is_Magenta_tag_Displayed() {
		if (this.sync(Magenta_tag).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean is_Reading_Level_header_Displayed() {
		if (this.sync(Reading_Level_header).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void clickOn_One_to_8_selection_in_Reading_Level() {
		this.sync(One_to_8_selection_in_Reading_Level).click();
	}

	public boolean is_One_to_8_tag_Displayed() {
		if (this.sync(One_to_8_tag).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void validation_of_Reading_Level_Value_1_8() {
		String actual = Reading_Level_Value.getText();
		//System.out.println("*************ACTUAL IS: " + actual);
		for (int expected1 = 1; expected1 <= 8; expected1++) {
			String tes = expected1 + "";
			//System.out.println("$$$$$$$$$$$$" + tes);
			if (tes.equalsIgnoreCase(actual)) {
				//System.out.println(actual + "------EQ--------" + tes);
				break;

			} else {
				//System.out.println(actual + "-------NOT EQ-------" + tes);

			}
		}
	}

	public void selection_of_colour_and_validation() throws InterruptedException {
		String actual = Colour_Values.getText();
		//System.out.println("**********VALUES ARE " + actual);
		String[] words = actual.split("\\s+");
		int i = words.length;
		//System.out.println("@@@@@@@@@@@ Length is: " + i);
		String actual2 = null;
		int x = (int) (Math.random() * i) + 1;
		//System.out.println("########### Generated Value " + x);
		if (x == 1) {
			this.sync(Colour_Magenta).click();
			// this.sync(Magenta_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Magenta";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 2) {
			this.sync(Colour_Red).click();
			// this.sync(Red_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Red";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 3) {
			this.sync(Colour_Yellow).click();
			// this.sync(Yellow_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Yellow";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 4) {
			this.sync(Colour_Blue).click();
			// this.sync(Blue_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Blue";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 5) {
			this.sync(Colour_Green).click();
			// this.sync(Green_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Green";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 6) {
			this.sync(Colour_Orange).click();
			// this.sync(Orange_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Orange";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 7) {
			this.sync(Colour_Turquoise).click();
			// this.sync(Turquoise_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Turquoise";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 8) {
			this.sync(Colour_Purple).click();
			// this.sync(Purple_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Purple";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 9) {
			this.sync(Colour_Gold).click();
			// this.sync(Gold_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Gold";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 10) {
			this.sync(Colour_Silver).click();
			// this.sync(Silver_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Silver";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 11) {
			this.sync(Colour_Emerald).click();
			// this.sync(Emerald_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Emerald";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 12) {
			this.sync(Colour_Ruby).click();
			// this.sync(Ruby_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Ruby";
			Assert.assertEquals("Values are not same", actual2, expected);
		} else if (x == 13) {
			this.sync(Colour_Sapphire).click();
			// this.sync(Sapphire_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Colour_wheel_name).getText();
			//System.out.println("ACTUAL IS: " + actual2);
			String expected = "Sapphire";
			Assert.assertEquals("Values are not same", actual2, expected);
		}
	}

	public void selection_of_Reading_level_and_validation() throws InterruptedException {
		String actual = Reading_Values.getText();
		//System.out.println("**********VALUES ARE " + actual);
		String[] words = actual.split("\\s+");
		int i = words.length;
		//System.out.println("@@@@@@@@@@@ Length is: " + i);
		String actual2 = null;
		int x = (int) (Math.random() * i) + 1;
		//System.out.println("########### Generated Value " + x);

		if (x == 1) {
			this.sync(One_to_8_selection_in_Reading_Level).click();
			// this.sync(One_to_8_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Reading_Level_Value).getText();
			for (int expected1 = 1; expected1 <= 8; expected1++) {
				String tes = expected1 + "";
				//System.out.println("$$$$$$$$$$$$" + tes);
				if (tes.equalsIgnoreCase(actual2)) {
					//System.out.println(actual2 + "------EQ--------" + tes);
					break;
				} else {
					//System.out.println(actual2 + "-------NOT EQ-------" + tes);
				}
			}
		} else if (x == 2) {
			this.sync(Nine_to_14_selection_in_Reading_Level).click();
			// this.sync(Nine_to_14_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Reading_Level_Value).getText();
			for (int expected1 = 9; expected1 <= 14; expected1++) {
				String tes = expected1 + "";
				//System.out.println("$$$$$$$$$$$$" + tes);
				if (tes.equalsIgnoreCase(actual2)) {
					//System.out.println(actual2 + "------EQ--------" + tes);
					break;
				} else {
					//System.out.println(actual2 + "-------NOT EQ-------" + tes);
				}
			}
		} else if (x == 3) {
			this.sync(Fifteen_to_20_selection_in_Reading_Level).click();
			// this.sync(Fifteen_to_20_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Reading_Level_Value).getText();
			for (int expected1 = 15; expected1 <= 20; expected1++) {
				String tes = expected1 + "";
				//System.out.println("$$$$$$$$$$$$" + tes);
				if (tes.equalsIgnoreCase(actual2)) {
					//System.out.println(actual2 + "------EQ--------" + tes);
					break;
				} else {
					//System.out.println(actual2 + "-------NOT EQ-------" + tes);
				}
			}
		} else if (x == 4) {
			this.sync(TwentyOne_to_25_selection_in_Reading_Level).click();
			// this.sync(TwentyOne_to_25_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Reading_Level_Value).getText();
			for (int expected1 = 21; expected1 <= 25; expected1++) {
				String tes = expected1 + "";
				//System.out.println("$$$$$$$$$$$$" + tes);
				if (tes.equalsIgnoreCase(actual2)) {
					//System.out.println(actual2 + "------EQ--------" + tes);
					break;
				} else {
					//System.out.println(actual2 + "-------NOT EQ-------" + tes);
				}
			}
		} else if (x == 5) {
			this.sync(TwentySix_to_30_selection_in_Reading_Level).click();
			// this.sync(TwentySix_to_30_tag).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			actual2 = this.sync(Reading_Level_Value).getText();
			for (int expected1 = 26; expected1 <= 30; expected1++) {
				String tes = expected1 + "";
				//System.out.println("$$$$$$$$$$$$" + tes);
				if (tes.equalsIgnoreCase(actual2)) {
					//System.out.println(actual2 + "------EQ--------" + tes);
					break;
				} else {
					//System.out.println(actual2 + "-------NOT EQ-------" + tes);
				}
			}
		}
	}

	//////////////// 16-02-2016 ////////////////
	public boolean is_Genre_header_displayed() {
		if (Genre_header.isDisplayed())
			return true;
		else
			return false;
	}

	public void ClickOn_Genre_button() {
JavascriptExecutor executor = (JavascriptExecutor)driver;		
        executor.executeScript("arguments[0].click();", Genre_button);
	}

	public void ClickOn_Fiction_in_Genre() throws InterruptedException {
		this.sync(Fiction_in_Genre).click();
		Thread.sleep(2000);
	}

	public void ClickOn_NonFiction_in_Genre() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", NonFiction_in_Genre);
		Thread.sleep(2000);
	}

	public boolean is_Fiction_tag_displayed() {
		if (Fiction_tag.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean is_NonFiction_tag_displayed() {
		if (NonFiction_tag.isDisplayed())
			return true;
		else
			return false;
	}

	public void validation_of_Genre_type_Fiction() {
		String actual = Genre_type.getText();
		//System.out.println("ACTUAL TYPE IS: " + actual);
		String expected = "Fiction";
		Assert.assertEquals("Genre type is different:::", actual, expected);
	}

	public void validation_of_Genre_type_NonFiction() {
		String actual = Genre_type.getText();
		//System.out.println("ACTUAL TYPE IS: " + actual);
		String expected = "Non Fiction";
		Assert.assertEquals("Genre type is different:::", actual, expected);
	}
	
	public void MinReadingLevel(){
		try{
			ReadinglistDropdown.isDisplayed();
			ReadinglistDropdown.click();
		} catch (Exception e){
			reportLog("Already clicked reading List");
		}
	}
	
	public void InterestcategoryPlus(){
		click(InterestcategoryPlus);
	}
	
	public boolean CollectInterestcategory(){
		boolean result=false;
		reportLog("Collecting the Interest category");
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<String> b= new ArrayList<String>();
		int i = driver.findElements(By.xpath("//span[contains(text(),'Interest category')]/parent::div/parent::div//div[@class='lpl-filter-option ng-binding']")).size();
		for(int j=1; j<=i; j++){
			String xpaths="(//span[contains(text(),'Interest category')]/parent::div/parent::div//div[@class='lpl-filter-option ng-binding'])["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		System.out.println(a);
		b.addAll(a);
		Collections.sort(a);
		reportLog("Verifying if the Interest category are in Alphabetical order");
		System.out.println(a);
		System.out.println(b);
		if(b.equals(a)){
			reportLog("The Interest category are arranged in Alphabetical order");
			result=true;
		}
		lazyWait(3);
		return result;
	}
	
	@FindBy(xpath="//span[contains(text(),'Interest category')]/parent::div/span[contains(@class,'glyphicon-plus')]")
    WebElement InterestcategoryPlus;
	
	@FindBy(xpath="//span[contains(text(),'Reading Level')]/parent::div/span[contains(@class,'glyphicon-minus')]")
    WebElement ReadinglistDropdown;
	
	public void ClickOn_Interest_category_button() throws InterruptedException {
		this.sync(Interest_category_button).click();
		lazyWait(2);
	}
	
	public void ClickOn_EducationLevel() throws InterruptedException{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", EducationLevelPlus);
        System.out.println("it done");
		
	}
	
	public boolean EducationlevelVerify(String EducationLevel){
		boolean result = false;
		ArrayList<String> a= new ArrayList<String>();
		int i = driver.findElements(By.xpath(".//*[@id='teacher-book']/div[9]//div[2]/div//label/div")).size();
		for(int j=1; j<=i; j++){
			String xpaths="(.//*[@id='teacher-book']/div[9]//div[2]/div//label/div)["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		if(a.contains(EducationLevel)){
			result=true;
		}
		return result;
	}
	
	public boolean SearchFilter(String EducationLevel){
		boolean result = false;
		ArrayList<String> a= new ArrayList<String>();
		int i = driver.findElements(By.xpath(".//*[@id='teacher-book']/div/div/div[1]/span[1]")).size();
		for(int j=1; j<=i; j++){
			String xpaths="(.//*[@id='teacher-book']/div/div/div[1]/span[1])["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		
		System.out.println(a+"'''''''''''''''''''''''''''''''''''''"+(EducationLevel));
		
		if(a.contains(EducationLevel)){
			result=true;
		}
		
		System.out.println("_________________________________________"+result);
		return result;
	}
	
	public boolean ExtraSearchFilter(String EducationLevel){
		boolean result = false;
		ArrayList<String> a= new ArrayList<String>();
		int i = driver.findElements(By.xpath(".//*[@id='teacher-book']/div/div/div/div/label/div")).size();
		for(int j=1; j<=i; j++){
			String xpaths="(.//*[@id='teacher-book']/div/div/div/div/label/div)["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		
		System.out.println(a+"'''''''''''''''''''''''''''''''''''''"+(EducationLevel));
		
		if(a.contains(EducationLevel)){
			result=true;
		}
		
		System.out.println("_________________________________________"+result);
		return result;
	}
	
	public boolean SearchFilterStudent(String EducationLevel){
		boolean result = false;
		ArrayList<String> a= new ArrayList<String>();
		int i = driver.findElements(By.xpath(".//*[@id='old-student-book']/div/div/div[1]/span[1]")).size();
		System.out.println(i+"'''''''''''''''''''''''''''''''");
		for(int j=1; j<=i; j++){
			String xpaths="(.//*[@id='old-student-book']/div/div/div[1]/span[1])["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		
		System.out.println(a+"'''''''''''''''''''''''''''''''''''''"+(EducationLevel));
		
		if(a.contains(EducationLevel)){
			result=true;
		}
		
		System.out.println("_________________________________________"+result);
		return result;
	}
	
	public boolean ExtraSearchFilterStudent(String EducationLevel){
		boolean result = false;
		ArrayList<String> a= new ArrayList<String>();
		int i = driver.findElements(By.xpath(".//*[@id='old-student-book']/div/div/div/div/label/div")).size();
		for(int j=7; j<=(6+(i-1)); j++){
			String xpaths="(.//*[@id='old-student-book']/div["+j+"]/div/div/div/label/div)";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		
		System.out.println(a+"'''''''''''''''''''''''''''''''''''''"+(EducationLevel));
		
		if(a.contains(EducationLevel)){
			result=true;
		}
		
		System.out.println("_________________________________________"+result);
		return result;
	}
	
	public void EducationlevelSelection(String EducationLevel){
			String xpaths="//span[contains(text(),'Education Level')]/parent::div/parent::div//div[contains(text(),'"+EducationLevel+"')]";
			JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpaths)));
			lazyWait(4);
	}
	
	public boolean VerifyEducationlevelBook(String EduLevel) throws InterruptedException{
		boolean result = false;
		//driver.findElement(By.xpath(xpaths)).click();
		int y=0;
		int i = driver.findElements(By.xpath("//div[@class='lpl-book-list-grid-item col-md-3 ng-scope']//div[@ng-click='onClickBook(book);']")).size();
		for(int j=1; j<=i; j++){
			System.out.println("```````````````````"+j);
			String xpaths="(//div[@class='lpl-book-list-grid-item col-md-3 ng-scope']//div[@ng-click='onClickBook(book);'])["+j+"]";
			//scrolldowntoElement(driver.findElement(By.xpath(xpaths)));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpaths)));
			//click(driver.findElement(By.xpath(xpaths)));
			lazyWait(2);
			String Edu = getText(driver.findElement(By.xpath("//span[contains(text(),'Education Level:')]/parent::div/span[2]")));
			if(Edu.equalsIgnoreCase(EduLevel)){
				y=y+1;
			}
			click(close_button_in_popup);
			lazyWait(2);
		}
		System.out.println(i+"===================================="+y);
		if(i==y){
			result=true;
		}
		return result;
	}
	
	@FindBy(xpath="//span[contains(text(),'Education Level')]/parent::div/span[contains(@class,'glyphicon-plus')]")
    WebElement EducationLevelPlus;
	
	@FindBy(xpath=".//*[@id='teacher-book']/div[9]//div[2]/div//label/div")
    WebElement EducationLevel;
	
	public void ClickOn_Series_button(){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String t = "arguments[0].click();";
		
		jse.executeScript(t, Series_button);
		//click(Series_button);
		lazyWait(2);
	}

	public boolean is_Interest_category_header_displayed() {
		if (Interest_category_header.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean is_Not_Series_displayed(String Series){
		boolean result = false;
		String xpath = "(//div[@class='lpl-filter-item-options-container ng-scope'])[4]//label/div";
		
		int i=driver.findElements(By.xpath(xpath)).size();
		ArrayList<String> a=new ArrayList<String>();
		
		for(int j=1; j<=i; j++){
			String xpaths = "((//div[@class='lpl-filter-item-options-container ng-scope'])[4]//label/div)["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		
		System.out.println("---"+a.toString());
		
		result=!a.toString().contains(Series);
		System.out.println("===="+result);

		return result;
	}
	

	@FindBy(xpath = ".//*[@id='old-student-book']/div[1]/div/span[1]")
	private WebElement Filter;
	
	public boolean is_Not_filter_displayed(String user, String Series){
		
		boolean result = false;
		String xpath; 
		String id;
		
		if(user.equalsIgnoreCase("Student")){
			id= ".//*[@id='old-student-book']";
			click(Filter);
		}else{
			id=".//*[@id='teacher-book']";
		}
		
		xpath= id+"/div/div/div[1]/span[1]";			
		System.out.println("Vikram ===========================================");
		int i=driver.findElements(By.xpath(xpath)).size();
		ArrayList<String> a=new ArrayList<String>();
		System.out.println("'''''''''''''''''''"+i);
		for(int j=2; j <=i+1; j++){
			String xpaths = id+"/div["+j+"]/div/div[1]/span[1]";
			System.out.println(xpaths+"----------------------");
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		
		System.out.println("---"+a.toString());
		
		result=!a.toString().contains(Series);
		System.out.println("===="+result);

		return result;
	}

	/*public void selection_of_category_and_validation() throws InterruptedException {
		String actual = Interest_category_values.getText();
		//System.out.println("**********VALUES ARE::: " + actual);
		String[] lines = actual.split("\r\n|\r|\n");
		int i = lines.length-1;
		//System.out.println("@@@@@@@@@@@ Length is: " + i);
		int x = (int) (Math.random() * i) + 1;
		//System.out.println("########### Generated Value " + x);
		if (x == 1) {
			this.sync(Category_Action_Adventure).click();
			// this.sync(tag_Action_Adventure).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Action_Adventure).isDisplayed();
		} else if (x == 2) {
			this.sync(Category_Animals_Pets).click();
			// this.sync(tag_Animals_Pets).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Animals_Pets).isDisplayed();
		} else if (x == 3) {
			this.sync(Category_Biographies).click();
			// this.sync(tag_Biographies).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Biographies).isDisplayed();
		} else if (x == 4) {
			this.sync(Caring_Sharing).click();
			// this.sync(tag_Classics).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Classics).isDisplayed();
		} else if (x == 5) {
			this.sync(Category_Celebrations).click();
			// this.sync(tag_Celebrations).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Celebrations).isDisplayed();
		} else if (x == 6) {
			this.sync(Category_Friends_Family_GrowingUp).click();
			// this.sync(tag_Friends_Family_GrowingUp).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Friends_Family_GrowingUp).isDisplayed();
		} else if (x == 7) {
			this.sync(Category_Food_Drink).click();
			// this.sync(tag_Food_Drink).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Food_Drink).isDisplayed();
		} else if (x == 8) {
			this.sync(Category_World_Cultures_Geography).click();
			// this.sync(tag_World_Cultures_Geography).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_World_Cultures_Geography).isDisplayed();
		} else if (x == 9) {
			this.sync(Category_History).click();
			// this.sync(tag_History).isDisplayed();
			Thread.sleep(2000);
			this.sync(filtered_selection_book).click();
			this.sync(icon_History).isDisplayed();
		} else if (x == 10) {
			this.sync(Category_Humour).click();
			// this.sync(tag_Humour).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Humour).isDisplayed();
		} else if (x == 11) {
			this.sync(Category_Romance_Relationships).click();
			// this.sync(tag_Romance_Relationships).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Romance_Relationships).isDisplayed();
		} else if (x == 12) {
			this.sync(Category_Miscellaneous).click();
			// this.sync(tag_Miscellaneous).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Miscellaneous).isDisplayed();
		} else if (x == 13) {
			this.sync(Category_Music_Art).click();
			// this.sync(tag_Music_Art).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Music_Art).isDisplayed();
		} else if (x == 14) {
			this.sync(Category_Mystery).click();
			// this.sync(tag_Mystery).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Mystery).isDisplayed();
		} else if (x == 15) {
			this.sync(Category_Folktales_Legends).click();
			// this.sync(tag_Folktales_Legends).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Folktales_Legends).isDisplayed();
		} else if (x == 16) {
			this.sync(Category_Nature_theEnvironment).click();
			// this.sync(tag_Nature_theEnvironment).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Nature_theEnvironment).isDisplayed();
		} else if (x == 17) {
			this.sync(Category_Science_Technology).click();
			// this.sync(tag_Science_Technology).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Science_Technology).isDisplayed();
		} else if (x == 18) {
			this.sync(Category_Science_Fiction_Fantasy).click();
			// this.sync(tag_Science_Fiction_Fantasy).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Science_Fiction_Fantasy).isDisplayed();
		} else if (x == 19) {
			this.sync(Category_Space).click();
			// this.sync(tag_Space).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Space).isDisplayed();
		} else if (x == 20) {
			this.sync(Category_Sports_Hobbies).click();
			// this.sync(tag_Sports_Hobbies).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Sports_Hobbies).isDisplayed();
		}

	}*/
	
	
	public void selection_of_category_and_validation() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		String actual = Interest_category_values.getText();
		//System.out.println("**********VALUES ARE::: " + actual);
		String[] lines = actual.split("\r\n|\r|\n");
		int i = lines.length-1;
		//System.out.println("@@@@@@@@@@@ Length is: " + i);
		int x = (int) (Math.random() * i) + 1;
		//System.out.println("########### Generated Value " + x);
		if (x == 1) {			
	        executor.executeScript("arguments[0].click();", Category_Action_Adventure);
			// this.sync(tag_Action_Adventure).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Action_Adventure).isDisplayed();
		} else if (x == 2) {
			executor.executeScript("arguments[0].click();", Category_Animals_Pets);
			
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Animals_Pets).isDisplayed();
		} else if (x == 3) {
			executor.executeScript("arguments[0].click();", Category_Biographies);

			// this.sync(tag_Biographies).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Biographies).isDisplayed();
		} else if (x == 4) {
			executor.executeScript("arguments[0].click();", Caring_Sharing);

			// this.sync(tag_Classics).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Classics).isDisplayed();
		} else if (x == 5) {
			executor.executeScript("arguments[0].click();", Category_Celebrations);

			// this.sync(tag_Celebrations).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Celebrations).isDisplayed();
		} else if (x == 6) {
			executor.executeScript("arguments[0].click();", Category_Friends_Family_GrowingUp);
	
			// this.sync(tag_Friends_Family_GrowingUp).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Friends_Family_GrowingUp).isDisplayed();
		} else if (x == 7) {
			executor.executeScript("arguments[0].click();", Category_Food_Drink);

			// this.sync(tag_Food_Drink).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Food_Drink).isDisplayed();
		} else if (x == 8) {
			executor.executeScript("arguments[0].click();", Category_World_Cultures_Geography);

			// this.sync(tag_World_Cultures_Geography).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_World_Cultures_Geography).isDisplayed();
		} else if (x == 9) {
			executor.executeScript("arguments[0].click();", Category_History);
			// this.sync(tag_History).isDisplayed();
			Thread.sleep(2000);
			this.sync(filtered_selection_book).click();
			this.sync(icon_History).isDisplayed();
		} else if (x == 10) {
			executor.executeScript("arguments[0].click();", Category_Humour);

			// this.sync(tag_Humour).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Humour).isDisplayed();
		} else if (x == 11) {
			executor.executeScript("arguments[0].click();", Category_Romance_Relationships);
			// this.sync(tag_Romance_Relationships).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Romance_Relationships).isDisplayed();
		} else if (x == 12) {
			executor.executeScript("arguments[0].click();", Category_Miscellaneous);

			// this.sync(tag_Miscellaneous).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Miscellaneous).isDisplayed();
		} else if (x == 13) {
			executor.executeScript("arguments[0].click();", Category_Music_Art);

			// this.sync(tag_Music_Art).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Music_Art).isDisplayed();
		} else if (x == 14) {
			executor.executeScript("arguments[0].click();", Category_Mystery);

			// this.sync(tag_Mystery).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Mystery).isDisplayed();
		} else if (x == 15) {
			executor.executeScript("arguments[0].click();", Category_Folktales_Legends);
			// this.sync(tag_Folktales_Legends).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Folktales_Legends).isDisplayed();
		} else if (x == 16) {
			executor.executeScript("arguments[0].click();", Category_Nature_theEnvironment);
			// this.sync(tag_Nature_theEnvironment).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Nature_theEnvironment).isDisplayed();
		} else if (x == 17) {
			executor.executeScript("arguments[0].click();", Category_Science_Technology);

			// this.sync(tag_Science_Technology).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Science_Technology).isDisplayed();
		} else if (x == 18) {
			executor.executeScript("arguments[0].click();", Category_Science_Fiction_Fantasy);
			// this.sync(tag_Science_Fiction_Fantasy).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Science_Fiction_Fantasy).isDisplayed();
		} else if (x == 19) {
			executor.executeScript("arguments[0].click();", Category_Space);
			// this.sync(tag_Space).isDisplayed();
			Thread.sleep(2000);
			try {
				filtered_selection_book.click();
			} catch (Exception e) {
				filtered_selection_book_student.click();
			}
			this.sync(icon_Space).isDisplayed();
		}
	} 

	/////////////// 17-02-2016 ////////////////////////////
	public void clickOn_filtered_selection_book_student() throws InterruptedException {
		Thread.sleep(2000);
		this.sync(filtered_selection_book_student).click();
	}

	public boolean is_message_container_header_displayed() {
		if (message_container_header.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOn_dropDown_to_select_students_for_sending_message() {
		this.sync(dropDown_to_select_students_for_sending_message).click();
	}

	public boolean is_Students_class_header_displayed() {
		if (Students_class_header.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOn_entire_class_selection_for_sending_message() {
		this.sync(entire_class_selection_for_sending_message).click();
	}

	public void clickOn_student3_for_sending_message() {
		this.sync(student3_for_sending_message).click();
	}

	public void clickOn_select_message_recipients() {
		this.sync(select_message_recipients).click();
	}

	public void clickOn_Text_area_for_sending_message() throws InterruptedException {
		Thread.sleep(2000);
		this.sync(Text_area_for_sending_message).click();
	}

	public void message_to_send(String message) {
		this.sync(Text_area_for_sending_message).sendKeys(message);
	}

	public void clickOn_Send_button_for_sending_message() {
		this.sync(Send_button_for_sending_message).click();
	}

	public boolean is_confirmation_message_after_sent_message_displayed() {
		if (confirmation_message_after_sent_message.isDisplayed())
			return true;
		else
			return false;
	}

	public void clickOn_Okay_button_in_confirmation_message() {
		this.sync(Okay_button_in_confirmation_message).click();
	}

	///////////// 22-02-2016 ////////////////////////
	public void enter_the_text_in_Search_field() {
		this.sync(Search_field).sendKeys("Wrinkles");
	}

	public void clickOn_Search_button() throws InterruptedException {
		this.sync(Search_button);
		Thread.sleep(5000);
         JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", Search_button);
         //executor.executeScript("$('#searchBooks').next('span').trigger('click')");
        // executor.executeScript("$('#searchBooks').next('span').trigger('click')");
		Thread.sleep(5000);
	}

	public void bookload(){
		WebDriverWait wait = new WebDriverWait(driver, 360);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='popup-inner']/div/div[4]/a/img")));
		lazyWait(2);
	}
	
	public void verify_header_of_the_book() throws InterruptedException {
		bookload();
		String value = getText(Header_of_OpenBook);
		String expected = "Wrinkles";
		Assert.assertEquals("Header is not same", value, expected);
	}

	public void UnassignBooks() throws InterruptedException {
		this.sync(driver.findElement(By.xpath(".//*[@class='lpl-book-assign']")));
		//List<WebElement> ele = driver.findElements(By.xpath(".//*[@class='lpl-book-assign']"));
		for(int i=1; i<=3; i++){
			if( driver.findElement(By.xpath("(.//*[@class='lpl-book-assign'])["+ i +"]")).getText().contains("ASSIGNED"))
			{
				driver.findElement(By.xpath("(.//*[@class='lpl-book-assign'])["+ i +"]")).click();
				clickOn_Assigned_InPopup();
				clickOnEntire_class();
				clickOn_save_changes_button();
				Thread.sleep(5000);
			}
		}
	}

	public boolean isAudiRecordingDisplayed() {
		if (this.sync(driver.findElement(By.xpath(".//*[@id='microphoneImg']"))).isDisplayed())
			return true;
		else
			return false;
		
	}

	public boolean isSendMessageDipslayed() {
		if (is_SEND_A_MESSAGE_in_open_book_displayed())
			return true;
		else
			return false;
	}

	public boolean isViewMessageDisplayed() {
		if (this.sync(driver.findElement(By.xpath(".//*[contains(text(),'VIEW MESSAGES')]"))).isDisplayed())
			return true;
		else
			return false;
	}
	
	public void clickViewQuiz() {
		this.sync(driver.findElement(By.xpath(".//show-quiz-button/a/span"))).click();
		
	}

	public boolean isAssignedbookDisplayed() {
		if(this.sync(ASSIGNED).isDisplayed())
			return true;
		return false;
	}
	public void clickOn_clearAllAssignments() {
		lazyWait(4);
		this.sync(clearAllAssignments);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clearAllAssignments);
	}

	public void clickClearButton() {
		this.sync(driver.findElement(By.xpath("(.//*[@ng-click='clearFilters();'])[1]"))).click();
		
	}
	public void clickHiddenFilter() throws InterruptedException{
		Thread.sleep(5000);
		this.sync(hiddenFilter).click();
	}

	public boolean isHiddenBookDispplayed() throws InterruptedException {
		Thread.sleep(20000);
		if(this.sync(driver.findElement(By.cssSelector(".lpl-book-style.gray-out"))).isDisplayed())
		return true;
		else 
		return false;
	}

	public void UncheckEntire_class() {
		lazyWait(10);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	      boolean entireSelected =  (Boolean) executor.executeScript("return $('#entire-select').is(':checked')");
			System.out.println(entireSelected);
	    	  
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	        executor1.executeScript("arguments[0].click();", Entire_class);
	       
	    	  
	}
	public boolean isAssignbookDisplayed() throws InterruptedException {
		Thread.sleep(10000);
		if(this.sync(assign).isDisplayed()){
			return true;
		}
		return false;
	}
	public void clickOnAssignhidden() throws InterruptedException {
		lazyWait(5);
		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
		
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(.//*[@ng-show='hideAssignBooks'][@class='lpl-book-assign'])[1]/div")));
		}
		catch (Exception e){
			
			/*clickOnASSIGNED();
			clickOn_Assigned_InPopup();
			clickOnEntire_class();
			clickOn_save_changes_button();*/
			driver.findElement(By.xpath("(.//paging/ul/li[3]/span)[1])")).click();
			Thread.sleep(5000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(.//*[@ng-show='hideAssignBooks'][@class='lpl-book-assign'])[1]")));
		}
	}
	
	public void LexileRange(String StrtLexile, String EndLexile) throws InterruptedException {
		reportLog("Searching for the books in the lexile range of "+StrtLexile+" and "+EndLexile);
		type(StartLexileTxt, StrtLexile);
		type(EndLexileTxt, EndLexile);
	}
	
	public boolean BookLexileRange(String StrtLexile, String EndLexile) throws InterruptedException {
		boolean result=false;
		lazyWait(4);
		reportLog("Verifying the Lexile range "+StrtLexile+" and "+EndLexile);
		/*String SLex=getText(StartLexileTxt);
		String ELex= getText(EndLexileTxt);*/
		String SLex=StartLexileTxt.getText();
		String ELex= EndLexileTxt.getText();
		System.out.println(SLex+"====="+ELex);
		System.out.println(StrtLexile+"====="+EndLexile);
		if(SLex.equalsIgnoreCase(StrtLexile) && ELex.equalsIgnoreCase(EndLexile)){
			result = true;
		}
		return result;
	}
	
	public void LexileRangeTeacher(String StrtLexile, String EndLexile) throws InterruptedException {
		reportLog("Searching for the books in the lexile range of "+StrtLexile+" and "+EndLexile);
		try{
			ReadingLevelAdd.click();
		}catch (Exception e) {
			reportLog("Reading level dropdown is already open");
		}
		lazyWait(4);
		type(StartLexileTxt, StrtLexile);
		type(EndLexileTxt, EndLexile);
	}
	
	public void SrchBttn(){
		click(SrchBtn);
		reportLog("Clicked on the search button");
		lazyWait(4);
	}
	
	public void SrchBttnTch(){
		click(SrchBtnTch);
		reportLog("Clicked on the search button");
		lazyWait(4);
	}
	
	public boolean AssignPopup() throws InterruptedException{
		boolean result = false;
		int j;
		int count=0;
		int i = driver.findElements(By.xpath("//div[contains(text(),'ASSIGN')]")).size();
		for( j=1; j<=i; j++){
			String xpath="(//div[contains(text(),'ASSIGN')])["+j+"]";
			System.out.println("''''''''''''"+xpath);
			lazyWait(2);			
			click(driver.findElement(By.xpath(xpath)));
			reportLog("Clicked on the info button");
			reportLog("Validating the BR Lexile");
			String LexileBR = getText(Lexile);
			if(LexileBR.contains("BR")){
				count++;
				reportLog("Books falls bellow the Zero Lexile");
			}
			click(Close);
			if((j % 4) == 0){
				scrolldownTillEnd(210);
			}
		}
		System.out.println(j+"=="+count+"==="+i);
		if((j-1)==count){
			result = true;
		}
		return result;
	}
	
	public void QuizPopup(){
		click(driver.findElement(By.xpath("(//div[contains(text(),'ASSIGN')])[1]")));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a/span[contains(text(),'Quiz')])[2]")));
		click(driver.findElement(By.xpath("(//a/span[contains(text(),'Quiz')])[2]")));
	}
	
	public void Quizinfo(){
		click(filtered_selection_book_student);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div/div/div[3]/show-quiz-button/a/span")));
		click(driver.findElement(By.xpath("html/body/div[4]/div/div/div[3]/show-quiz-button/a/span")));
	}
	
	public void QuizBookCover(){
		click(BookCoverQuiz);
	}
	
	@FindBy(xpath = "(//show-quiz-button/a/span)[1]")
	private WebElement BookCoverQuiz;
  
	public boolean VerifyLP_LPL_integration(String bookTitle){
		boolean result=false;
		String PopTitle = "//h3[contains(text(),'Quizzes for "+bookTitle+"')]";
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PopTitle)));
		try{
			if(driver.findElement(By.xpath(PopTitle)).isDisplayed() && ViewQuizBtn.isDisplayed()){
				result=true;
				reportLog("LP-LPL integration is working as expected");
			}
		} catch (Exception e){
			reportLog("LP-LPL integration is not working as expected");
		}
		return result;
	}
	
	public boolean VerifyLP_LPL_integrationStudent(String bookTitle){
		boolean result=false;
		String PopTitle = "//h3[contains(text(),'Quizzes for "+bookTitle+"')]";
		System.out.println("--------------------------------------------------------------------------------------"+PopTitle);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PopTitle)));
		try{
			if(driver.findElement(By.xpath(PopTitle)).isDisplayed() && TakeQuizBtn.isDisplayed()){
				result=true;
				reportLog("LP-LPL integration is working as expected");
			}
		} catch (Exception e){
			reportLog("LP-LPL integration is not working as expected");
		}
		return result;
	}
	
	public boolean ViewQuizAndVerify(){
		click(ViewQuizBtn);
		reportLog("Clicked on View quiz button");
		switchToNewWindow();
		boolean result = isVisible(driver.findElement(By.xpath("//*[@id='quizView']/div/div[4]/ol/li[1]")));
		if (result = true){
			reportLog("LP-LPL integration is wroking as expected");
		}
		driver.close();
		switchToNewWindow();
		return result;
	}
	
	public void ClosePopUp(){
		click(CloseBtn);
	}
	
	
	
	public void SearchBookLP(String BookTitle){		
		click(LPSearchTab);
		type(LPSearchBox, BookTitle);
		click(LPSearchbtn);
	}	
	
	public void SearchBookLPStn(String BookTitle){		
		click(SearcbtnTab);
		type(SearcTxtBox, BookTitle);
		click(SearcbtnStu);
	}
	
	public void ReadBookBtnStn(String Book){
		String Xpaths="(//p[contains(text(),'"+Book+"')]/parent::div/parent::div//a/span[contains(text(),'Read Book')])[1]";
		lazyWait(5);
		System.out.println("________________"+Xpaths);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(Xpaths)));
	}
	
	public void ReadBookBtn(String Book){
		String Xpaths="//span[contains(text(),'"+Book+"')]/parent::div/parent::td/parent::tr//span[contains(text(),'Read Book')]";
		lazyWait(5);
		System.out.println("________________"+Xpaths);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(Xpaths)));
	}
	
	public boolean VerifyBookLPL(String Book){
		boolean result=false;
		String PopTitle = "//span[contains(text(),'"+Book+"')]";
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PopTitle)));
		try{
			if(driver.findElement(By.xpath(PopTitle)).isDisplayed() && ReadContainer.isDisplayed()){
				result=true;
				reportLog("LP-LPL integration is working as expected");
			}
		} catch (Exception e){
			reportLog("LP-LPL integration is not working as expected");
		}
		
		return result;
	}
		
	public boolean AssignPopupZeroVerify() throws InterruptedException{
		boolean result = false;
		int j;
		int count=0;
		int i = driver.findElements(By.xpath("//div[contains(text(),'ASSIGN')]")).size();
		for( j=1; j<=i; j++){
			String xpath="(//div[contains(text(),'ASSIGN')])["+j+"]";
			System.out.println("''''''''''''"+xpath);
			lazyWait(2);			
			click(driver.findElement(By.xpath(xpath)));
			reportLog("Clicked on the info button");
			reportLog("Validating the BR Lexile");
			String LexileBR = getText(Lexile);
			if(LexileBR.contains("0")){
				count++;
				reportLog("Books has Zero Lexile score");
			}
			click(Close);
			if((j % 4) == 0){
				scrolldownTillEnd(210);
			}
		}
		System.out.println(j+"=="+count+"==="+i);
		if((j-1)==count){
			result = true;
		}
		return result;
	}
	
	public void InformationPopup(){
		click(IconBtn);
		reportLog("Clicked on the info button");
	}
	
	public boolean AssignPopupLexile(String MinLex, String MaxLex) throws InterruptedException{
		boolean result = false;
		int j;
		int count=0;
		int i = driver.findElements(By.xpath("//div[contains(text(),'ASSIGN')]")).size();
		for( j=1; j<=i; j++){
			String xpath="(//div[contains(text(),'ASSIGN')])["+j+"]";
			System.out.println("''''''''''''"+xpath);
			lazyWait(2);			
			JavascriptExecutor executor = (JavascriptExecutor)driver;			
	        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
			reportLog("Clicked on the info button");
			reportLog("Validating the BR Lexile");
			String LexileBR = getText(BRLexile).replaceAll("[^\\d.]", "");
	        System.out.println(LexileBR);
			if(Integer.parseInt(MinLex)<=Integer.parseInt(LexileBR) && Integer.parseInt(LexileBR)<=Integer.parseInt(MaxLex)){
				count = count+1;
				reportLog("book has lexile value containing Zero");
			}
			click(Close);
		}
		System.out.println(j+"=="+count+"==="+i);
		if((j-1)==count){
			result = true;
		}
		return result;
	}
	
	public boolean InformationPopupValidation(){
		boolean result=false;
		int count = 0;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		int size = driver.findElements(By.xpath("//img[@src='app/themes/images/icon-info2.png']")).size();
		for(int i=1; i<=size; i++){
			String xpathS="(//img[@src='app/themes/images/icon-info2.png'])["+i+"]";	
	        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathS)));
	        
	        String LexileBR = getText(BRLexile);
			if(LexileBR.contains("BR")){
				count = count+1;
				reportLog("book has lexile value containing Zero");
			}
		}
		reportLog(count+"============================================================================"+size);
		if(count==size){
			result =  true;
		}
		return result;
	}
	@FindBy(xpath = "//span[contains(text(),'Lexile: ')]/parent::div/span[2]")
	private WebElement BRLexile;
	
	public boolean ValidateBookLexile(){
		boolean result = false;
		reportLog("Validating the BR Lexile");
		String LexileBR = getText(BRLexile);
		if(LexileBR.contains("BR")){
			result =  true;
			reportLog("Books falls bellow the Zero Lexile");
		}
		return result;
	}
	
	
	public void AssignBok(){
		AssignBtn.click();
		reportLog("Clicked on the Assign button");
		click(AssignPOPupBtn);
		reportLog("Clicked in the Assign pop up button");
	}
	
	public boolean CollectClassdata(){
		boolean result=false;
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<String> b= new ArrayList<String>();
		int i = driver.findElements(By.xpath("//div[@dropdown-item-label='className' and @dropdown-model='classSelection']//a")).size();
		for(int j=1; j<=i; j++){
			System.out.println(j);
			String xpaths="(//div[@dropdown-item-label='className' and @dropdown-model='classSelection']//a)["+j+"]";
			a.add(driver.findElement(By.xpath(xpaths)).getText());
		}
		System.out.println(a);
		b.addAll(a);
		Collections.sort(a);
		System.out.println(a);
		System.out.println(b);
		if(b.equals(a)){
			reportLog("The classes are arranged in Alphabetical order");
			result=true;
		}
		click(ClosePopup);
		lazyWait(3);
		return result;
	}
	
	public void AssignedInfo() throws InterruptedException{
		lazyWait(3);
		click(NotStartedHome);
	}
	
	public void SelfAssignedInfo(){
		lazyWait(3);
		click(NotStartedHomeSelfAssigned);
		System.out.println("-------------------------------------------------------------------------------------");		
	}
    
	public void ReadBtn(){
		lazyWait(5);
		img = driver.findElement(By.xpath("//div[@class='lpl-bookdetails-left']/img")).getAttribute("src");
		System.out.println("======================================================="+img);
		String title = getText(driver.findElement(By.xpath("//span[@ng-bind='bookDetails.name']")));
		reportLog("Title of the book is : "+title);
		click(ReadBtns);
		setbooktitle(img);
	}
	
	public void Readbook(){
		lazyWait(5);
		bookload();
		for(int i=0; i<=5; i++){
			lazyWait(4);
			click(nextbuttonReadingPOPUp);
		}
	}
	
	public void ReadbookCompletely(){
		lazyWait(5);
		bookload();
		PageNumInput.clear();
		PageNumInput.sendKeys("1");
		lazyWait(4);
		driver.findElement(By.xpath("//div[@class='lpl-reader-top-controls']//span[@class='lpl-span-title ng-binding'][3]")).click();
		int pageNu=Integer.parseInt(driver.findElement(By.xpath("//div[@class='lpl-reader-top-controls']//span[@class='lpl-span-title ng-binding'][3]")).getText());
		System.out.println("*********************************"+pageNu);
		for(int i=1; i<=pageNu; i++){
			lazyWait(4);
			click(nextbuttonReadingPOPUp);
		}
		click(driver.findElement(By.xpath("//div[@class='modal-header']/span[@ng-click='closeEbookReader()']")));
		lazyWait(3);
	}
	
	public boolean bookcompletedVerifyHome(){
		boolean result = false;
		for(int i=0; i<30; i++){
			click(nextbuttonBookSeleted);
			System.out.println("----------"+i);
			Boolean isPresent = driver.findElements(By.xpath("//img[@src='app/themes/images/next-grey.png']")).size() > 0;		
			if(isPresent){
				break;
			}
		}
		lazyWait(7);
		String title =img;
		System.out.println("_________"+title);
		String xpaths = "//img[contains(@src, '"+title+"')]/parent::div/parent::div/parent::div//img[@src='app/themes/images/icon-percent-completed.png']";
		
		try{
			driver.findElement(By.xpath(xpaths)).isDisplayed();
			result = true;
		}
		catch(Exception e) {
			result = false;
			reportLog("Not able to see the completed book in the last block");
		}
		lazyWait(5);
		return result;
	}	
	
	public void ReadandRecord() throws IOException, FindFailed{
		lazyWait(5);
		bookload();
		int pageNu=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='lpl-reader-top-controls']//span[@class='lpl-span-title ng-binding'])[3]")).getText());
		System.out.println("*********************************"+pageNu);
			
		for(int i=1; i<=1000; i++){
			if(i==1){
				lazyWait(4);
				click(nextbuttonReadingPOPUpHome);
				lazyWait(4);
			}
			int ActualPageNu=Integer.parseInt(driver.findElement(By.xpath("//div[@class='lpl-reader-top-controls']//input")).getAttribute("value"));
			if(ActualPageNu<pageNu){
				lazyWait(4);
				click(nextbuttonReadingPOPUpHome);
				System.out.println(ActualPageNu+"------------------------------------------------------3333----------------------"+pageNu);
			}
		}
		click(Audio);
		lazyWait(10);
		
		Screen s=new Screen();
		String uploadFilePath = new File(".").getCanonicalPath() + "\\src\\test\\resources\\image\\";
		String fullPath = uploadFilePath + "Allow.jpg";
		s.click(fullPath);
		lazyWait(5);
		click(Record);
		lazyWait(11);
		click(Pause);
		click(SendMessage);
		click(OkeyMessage);
		lazyWait(3);
		click(driver.findElement(By.xpath("//div[@class='modal-header']/span[@ng-click='closeEbookReader()']")));
		lazyWait(3);
	}
	

	public void MyBook(String Status){
		String Xpath ="//div[@class='checkbox ng-scope' ]//div[contains(text(),'"+Status+"')]";
		System.out.println("============="+Xpath);
		click(driver.findElement(By.xpath(Xpath)));
	}
	
	public boolean AudioMessageNoRecording(){
		//AudioRecording
		boolean result= false;
		String message;
		bookload();
		lazyWait(8);
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("(//img[@alt='send audio recording'])[2]")))
				.build().perform();
		lazyWait(2);
		message = AudioDisableMessage.getText();
		if(message.contains("Audio recording is only available on teacher-assigned books.")){
			result = true;
		}
		System.out.println("____________________________________________"+AudioDisableMessage.getText());
		return result;
	}
	
	@FindBy(xpath = ".//*[@id='recorderSegment']/ul/li[7]/div/div[2]")
	private WebElement AudioDisableMessage;
}