package com.ceshiren.utils;

import com.ceshiren.DataEntity.CapsEntity;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * @Author chenqiang
 * @create 2023/12/21 16:32
 */
public class CapsUtil {

    // 设置 Capability
    public <T> void setCaps(DesiredCapabilities caps, CapsEntity capsEntity) {
        // 设置 Android 专属caps配置
        if (capsEntity.getPlatformName().equals("Android")) {
            caps.setCapability(AUTOMATION_NAME, "Uiautomator2");
            caps.setCapability(APP_PACKAGE, capsEntity.getAppPackage());
            caps.setCapability(APP_ACTIVITY, capsEntity.getAppActivity());
            caps.setCapability(AUTO_GRANT_PERMISSIONS,true);

            // 首次启动的时候，不停止app
            caps.setCapability(DONT_STOP_APP_ON_RESET,true);
            // 跳过安装，权限设置等操作
            caps.setCapability(SKIP_DEVICE_INITIALIZATION,true);
            //输入中文，UiAutomator1 需要配置才能输入中文，UiAutomator2不再需要配置
            caps.setCapability(UNICODE_KEYBOARD,true);

            // WebView 配置ensureWebviewsHavePages
            //是否跳过在 getContexts 输出中显示没有页面的 Web 视图。
            // 驱动程序使用 devtools 连接来检索有关现有页面的信息。
            // 自 Appium 1.19.0 起默认为 true，如果低于 1.19.0，则为 false。
            caps.setCapability(ENSURE_WEBVIEWS_HAVE_PAGES, true);
            //nativeWebScreenshot: 是否使用UiAutomator框架提供的截图端点（true）
            //而不是chromedriver提供的端点（false，默认值）。当您遇到后者问题时使用它。
            caps.setCapability(NATIVE_WEB_SCREENSHOT, true);
        }
        if (capsEntity.getPlatformName().equals("iOS")){
            caps.setCapability(AUTOMATION_NAME, "XCUItest");
            caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, capsEntity.getBundleId());
        }
        caps.setCapability(PLATFORM_NAME, capsEntity.getPlatformName());
        caps.setCapability(PLATFORM_VERSION, capsEntity.getPlatformVersion());
        caps.setCapability(UDID, capsEntity.getUdid());
        caps.setCapability(DEVICE_NAME, capsEntity.getUdid());
        //在假设客户端退出并结束会话之前，Appium 将等待来自客户端的新命令多长时间（以秒为单位）
        caps.setCapability(NEW_COMMAND_TIMEOUT, 60);
        // 添加参数 noReset =true 保存历史状态数据
        caps.setCapability(NO_RESET, capsEntity.getNoReset());
    }

}
