package com.introduction.project;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class SelfIntroduction {

	public static void main(String[] args) {
			
		 System.setProperty("webdriver.chrome.driver", "/Introduction/chromedriver-win64/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com");
	}

}
