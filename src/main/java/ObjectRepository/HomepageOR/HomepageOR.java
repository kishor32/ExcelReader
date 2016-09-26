package main.java.ObjectRepository.HomepageOR;

import org.openqa.selenium.By;

public final class HomepageOR {

   private HomepageOR(){}



    public static final By SEARCH_BY_NAME=By.xpath(".//*[@id='id_search_container']/label");

    public static final By SEARCH_TEXTBOX=By.id("search1");

    public static final By CLICK_ON_MERCENT=By.xpath(".//*[@id='table2']/tbody/tr/td[1]/div[2]/span/i");

    public static final String DYNAMIC_MERCHANT_LINK1= ".//*[@id='table2']/tbody/tr[";

    public static final String DYNAMIC_MERCHANT_LINK2="]/td[1]/div[2]/span/i";




}
