package com.scholastic.intl.litpro.test.automation.base;

import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.intl.litpro.test.automation.pageobjects.AssessmentPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.BenchmarkPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.InLibraryPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.LitProHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.MyResultsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.ParentPage;
import com.scholastic.intl.litpro.test.automation.pageobjects.QuizModal;
import com.scholastic.intl.litpro.test.automation.pageobjects.ReportsPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SearchPg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzHomePg;
import com.scholastic.intl.litpro.test.automation.pageobjects.SlzLoginPg;

public abstract class PageFactory {
	static TestBase testBase = TestBaseProvider.getTestBase();

	public static PageFactory getFactory() {
		String platform = testBase.getContext().getString("platform", "");
		if (platform.equalsIgnoreCase("desktop")) {
			return new BrowserPageFactory();
		}
		return null;
	}

	public abstract AssessmentPg getAssessmentPg();

	public abstract BenchmarkPg getBenchmarkPage();

	public abstract LitProHomePg getLitProHomePage();

	public abstract InLibraryPg getInLibraryPg();

	public abstract LitProHomePg getLitProHomePg();

	public abstract MyResultsPg getMyResultsPg();

	public abstract ParentPage getParentPG();

	public abstract QuizModal getQuizPg();

	public abstract ReportsPg getReportsPg();

	public abstract SearchPg getSearchPg();

	public abstract SlzHomePg getSlzHomePg();

	public abstract SlzLoginPg getSlzLoginPg();

	public static class BrowserPageFactory extends PageFactory {

		@Override
		public AssessmentPg getAssessmentPg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BenchmarkPg getBenchmarkPage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LitProHomePg getLitProHomePage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public InLibraryPg getInLibraryPg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LitProHomePg getLitProHomePg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MyResultsPg getMyResultsPg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ParentPage getParentPG() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public QuizModal getQuizPg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ReportsPg getReportsPg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SearchPg getSearchPg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SlzHomePg getSlzHomePg() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SlzLoginPg getSlzLoginPg() {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
