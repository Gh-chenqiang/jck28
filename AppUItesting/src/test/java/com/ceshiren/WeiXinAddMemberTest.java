package com.ceshiren;

import com.ceshiren.utils.TestDataFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.ceshiren.utils.CapsUtil;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author chenqiang
 * @create 2023/12/21 16:32
 */
@DisplayName("添加成员")
public class WeiXinAddMemberTest {
    private static AndroidDriver driver;
    private static final String URL = "http://127.0.0.1:4723/wd/hub";

    @BeforeAll
    static void setUp() {
        // 设置Capability
        DesiredCapabilities caps = new DesiredCapabilities();
        CapsUtil capsUtil = new CapsUtil();
        try {
            capsUtil.setCaps(caps, TestDataFactory.getCapsData().get(0));
            // 启动 app 建立 session
            driver = new AndroidDriver(new URL(URL), caps);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 添加全局隐式等待时间5秒
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("手动输入添加")
    @Order(1)
    void addMemberTest() {
        //定位通讯录并进入页面
        WebElement contactEle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"通讯录\"]"));
        if (!contactEle.isEnabled()) {
            System.out.println("元素不可用: " + contactEle.getText());
            return;
        }
        contactEle.click();
        //定位添加成员按钮并进入添加页面
        WebElement addEle = driver.findElement(AppiumBy.xpath("//*[@text=\"添加成员\"]"));
        if (addEle.isEnabled()) {
            System.out.println("元素不可用: " + addEle.getText());
            return;
        }
        addEle.click();
        // 定位手动添加输入成员按钮并进入添加详情页
        WebElement manualAddEle = driver.findElement(AppiumBy.id("com.tencent.wework:id/e5q"));
        if (manualAddEle.isEnabled()) {
            System.out.println("元素不可用: " + manualAddEle.getText());
            return;
        }
        manualAddEle.click();
        // 定位姓名输入框并输入姓名
        WebElement fullNameEle = driver.findElement(AppiumBy.id("com.tencent.wework:id/c68"));
        if (fullNameEle.isEnabled()) {
            System.out.println("元素不可用: " + fullNameEle.getText());
            return;
        }
        String name = System.currentTimeMillis() + "张三";
        fullNameEle.sendKeys(name);
        //定位手机号输入框并输入手机号
        WebElement telephoneEle = driver.findElement(AppiumBy.id("com.tencent.wework:id/inm"));
        if (telephoneEle.isEnabled()) {
            System.out.println("元素不可用: " + telephoneEle.getText());
            return;
        }
        String telephoneNumber = "183" + System.currentTimeMillis() / 100000;
        telephoneEle.sendKeys(telephoneNumber);
        //定位保存按钮
        WebElement preserveEle = driver.findElement(AppiumBy.id("com.tencent.wework:id/b45"));
        if (preserveEle.isEnabled()) {
            System.out.println("元素不可用: " + preserveEle.getText());
            return;
        }
        preserveEle.click();
        // 返回成员列表
        driver.navigate().back();
        //获取列表成员名字
        List<WebElement> nameEles = driver.findElements(AppiumBy.id("com.tencent.wework:id/g9r"));

        assertAll("添加结果断言",
                () -> {
                    // 添加Allure 报告步骤信息
                    Allure.step("添加结果断言");
                    // 断言所有的成员姓名是否包含添加时输入的姓名
                    assertTrue(nameEles.stream().anyMatch(webElement -> webElement.getText().contains(name)));
                }
        );

    }

    @AfterAll
    static void tearDown() {
        // 退出 app session
        driver.quit();
    }
}
