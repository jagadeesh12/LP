package com.scholastic.intl.litpro.test.automation.pageobjects.slz;
import java.util.Random;
import java.util.UUID;

public class Slzobj {
	 private static final String CHAR_LIST =
		        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		    private static final int RANDOM_STRING_LENGTH = 10;
	
	private String orgname;
	

	public String getOrgname() {
		 
		String rand = generateRandomString();
		setOrgname("Auto"+rand);
		return orgname;
	}

	public void setOrgname(String orgname) {
		
		this.orgname = orgname;
	}
	
	public String getOrgaizationName(){
		return orgname;
	}
	
	 public String generateRandomString(){
         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
	 private int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
	
}