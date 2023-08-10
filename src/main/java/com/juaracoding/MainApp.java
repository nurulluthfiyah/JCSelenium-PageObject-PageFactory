package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductToCart;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class MainApp {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        LoginPage loginPage = new LoginPage();
        System.out.println("Login Success");
        loginPage.login("Admin","admin123");

        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        AddProductToCart addProductToCart = new AddProductToCart();
        System.out.println("Add Product to Cart Success");
        addProductToCart.addToCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverSingleton.closeObjectInstance();
    }
}