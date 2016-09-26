package main.java.Browser;

public class Browser {


    private Browser (){

    }

    private static Browser b=new Browser();

    public static Browser getBrowser(){

        return b;
    }

    private String browserName;


    public String getBrowserName() {

        System.out.println(browserName);

        return browserName;
    }

    public void setBrowserName(String browserName) {

        System.out.println( browserName);
        this.browserName = browserName;
    }
}
