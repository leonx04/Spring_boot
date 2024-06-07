package com.example.buoi_1.repository.asm1;

import com.example.LoginAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MultipleLoginTest {
    private List<WebDriver> drivers;
    private ExecutorService executorService;

    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
        drivers = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(100); // Số luồng tối đa chạy đồng thời
    }

    @Test
    public void multipleLoginTest() {
        List<LoginAccount> accounts = new ArrayList<>();
        accounts.add(new LoginAccount("DungNA31@fpt.edu.vn", "123456"));
        accounts.add(new LoginAccount("qanqi@gmail.com", "123456"));
        accounts.add(new LoginAccount("wmyuen6@gmail.com", "123456"));
        accounts.add(new LoginAccount("kaows@outlook.com", "123456"));
        accounts.add(new LoginAccount("hendersonch@hotmail.com", "123456"));
        accounts.add(new LoginAccount("caozitao@gmail.com", "123456"));
        accounts.add(new LoginAccount("siuwm16@outlook.com", "123456"));
        accounts.add(new LoginAccount("barrywest@gmail.com", "123456"));
        accounts.add(new LoginAccount("sychan@icloud.com", "123456"));
        accounts.add(new LoginAccount("jesoto@outlook.com", "123456"));

        for (LoginAccount account : accounts) {
            executorService.execute(() -> {
                WebDriver driver = new EdgeDriver();
                drivers.add(driver);
                driver.get("http://localhost:8080/login");
                WebElement usernameInput = driver.findElement(By.name("tenDN"));
                WebElement passwordInput = driver.findElement(By.name("matKhau"));
                WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

                usernameInput.sendKeys(account.getUsername());
                passwordInput.sendKeys(account.getPassword());
                loginButton.click();

                // Kiểm tra đăng nhập thành công
                WebElement successMessage = driver.findElement(By.cssSelector(".text-success"));
                if (successMessage.isDisplayed()) {
                    System.out.println("Đăng nhập thành công với tài khoản: " + account.getUsername());
                } else {
                    System.out.println("Đăng nhập thất bại với tài khoản: " + account.getUsername());
                }
            });
        }
    }

    @After
    public void tearDown() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebDriver driver : drivers) {
            driver.quit();
        }
    }
}