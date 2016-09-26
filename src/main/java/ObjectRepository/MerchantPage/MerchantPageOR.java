package main.java.ObjectRepository.MerchantPage;

import org.openqa.selenium.By;

public final class MerchantPageOR {

    private MerchantPageOR(){

    }


    private static final class Settings{

        public static final By MERCHANT_NAME_LABLEL=By.id(".//*[@id='id_merchant_name_container']/label");

        public static final By MERCHANT_NAME=By.id("id_merchant_name");

        public static final By ADDRESS_LABEL=By.xpath(".//*[@id='id_address_container']/label");

        public static final By ADDRESS_BOX=By.id("id_address");

        public static final By CITY_LABEL=By.xpath(".//*[@id='id_city_container']/label");

        public static final By CITY_BOX=By.id("id_city");

        public static final By TIMEZONE_LABEL=By.xpath(".//*[@id='id_timezone_container']/label");

        public static final By TIMEZONE_BOX=By.xpath(".//*[@id='id_timezone_container']/div[1]/div/custom-drop-down/div/div/input");

        public static final By USERID_LABEL=By.xpath(".//*[@id='id_user_id_']/label");

        public static final By USERID_BOX=By.id("id_user_id");

    }

    private static final class PaymentHistory{

    }


    private static final class CreatePayment{


    }

}
