package main.java.com.angular.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Set;

/**
 * ���ﶨ���˴�������ķ���
 */
public class PageUtils {


    /**
     * ��������¼��ʱ�����û����֤�������£����ǲ��Ǻ�����������Զ�������Ϣ�����½�أ�
     * ����������԰������������顣
     *
     * ������µ�ʵ�������������ִ��js����
     * @param driver����������������
     */
    public static  void inputStrByJS(WebDriver driver, String id, String value){
        //1��js���룬��id���õ� input ��ǩ�����ҶԸñ�ǩ��ֵ
        String setValueJS = "document.getElementById('"+id+"').value='" + value + "';";

        //2��ʹ��driverִ�и�js����
        ((JavascriptExecutor) driver).executeScript(setValueJS);

    }

    /**
     * �����ڿ����������ʱ�������кܶ�ı�ǩҳ������һ��driverֻ�ܶ�Ӧһ����ǩҳ��
     * ��ÿһ��driver��handleҲ�Ƕ�Ӧһ����ǩҳ�������������ת����ı�ǩҳ����Ҫ
     * ���ȵõ���һ����ǩҳ��handle��Ȼ�����driver.switchTo().window(handle);
     * ������
     *
     * ���磬���Ƿ����Ա���ʱ����һ����Ʒ�б�ҳ�棬Ȼ����������һ����Ʒ�������¿�
     * һ����ǩҳ�����ʱ����������Ǹ��µı�ǩҳ����ô����Ҫ���ȵõ��Ǹ��µı�ǩҳ��
     * handle����Ϊÿһ��handle��Ӧһ��������ı�ǩҳ��Ȼ�����
     * driver.switchTo().window(handle);
     *
     *
     * ��������ǵ���������ǩҳʱ�л�����һ����ǩҳ�ķ���
     * @param driver
     */
    public static void getAnotherPage(WebDriver driver){
        //1�����Ȼ�õ�ǰ��ǩҳ�� handle
        String currentPageHandle = driver.getWindowHandle();

        //2��������б�ǩҳ�� handle
        Set<String> totalPageHandle = driver.getWindowHandles();

        //3������handle��������ǵ�ǰ�� handle ��ô�л�����һ��handle�ı�ǩҳ
        for (String handleStr : totalPageHandle){
            if (!handleStr.equals(currentPageHandle)){
                //��ת����һ����ǩҳ�����ʱ����Ϳ�����driver���Ƶ�ǰҳ����
                driver.switchTo().window(handleStr);
            }
        }

    }


    /**
     * ���ݴ����Ԫ�ػ�������Ӧ��Ԫ�أ�Ȼ�������Ԫ�أ����Է�ֹ������������
     *
     * @param element : �����Ԫ�أ�ע�������Ԫ�ر����ǿ��Ե����
     *                ����a��ǩ����href������ĳ��Ԫ�����и�onclick�¼�
     * @param driver  : �����driver�����Ե�������������������Ϊ��������� ��������Ҫ���������˱��봫����
     */
    public static void scrollToElementAndClick(WebElement element, WebDriver driver) {
        //�õ�����Ԫ�ص�y������
        int yScrollPosition = element.getLocation().getY() - 100;
        //�õ�����Ԫ�ص�x������
        int xScrollPosition = element.getLocation().getX();
        //�����������ǿ��תΪ����ִ��js�Ķ���
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        //ҳ����ִ��js���룬�����ٿ�ҳ�棬��js����Ϊ��window.scroll(xScrollPosition ,  yScrollPosition );  ��˼�Ǵ�����ת��x��y��λ�ã����Է�ֹ����û�����������������
        executor.executeScript("window.scroll(" + xScrollPosition + ", " + yScrollPosition + ");");
        element.click();
    }


    /**
     * ��ȡPhantomJsDriver����Ҫ����PhantomJsDriver�����ﲻ����ʾ
     *
     * @param url
     * @return
     */
    public static WebDriver getPhantomJSDriver(String url) {

        DesiredCapabilities dcaps = new DesiredCapabilities();
        //������ͼƬ
        dcaps.setCapability("phantomjs.page.settings.loadImages", false);
        //����������ķ�����ʽ
        //dcaps.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        //dcaps.setCapability("phantomjs.page.settings.XSSAuditingEnabled", true);
        //dcaps.setCapability("phantomjs.page.settings.localToRemoteUrlAccessEnabled", true);
        //dcaps.setCapability();
        System.setProperty("phantomjs.binary.path", "E:/phantomjs-2.1.1-windows/bin/phantomjs.exe");


        WebDriver driver = new PhantomJSDriver(dcaps);

        //System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //WebDriver driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","C:/Users/HP/AppData/Local/Google/Chrome/Application/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);

        return driver;
    }


    /**
     * �򿪹ȸ������������һ��WebDriver����������Ĳ���ͨ��webDriver��ִ��
     *
     * @param url
     * @return
     */
    public static WebDriver getChromeDriver(String url) {

        //���ùȸ�������������ҷ�����Ŀ��·���£�����������԰���򿪱��صĹȸ������
        System.setProperty("webdriver.chrome.driver", "E:/Downloads/chromedriver.exe");


        // ���öԹȸ�������ĳ�ʼ����           ��ʼ
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        //���ý�ֹͼƬ
        //prefs.put("profile.managed_default_content_settings.images", 2);
        //���ý�ֹcookies
        //prefs.put("profile.default_content_settings.cookies", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();
        chromeCaps.setCapability(ChromeOptions.CAPABILITY, options);
        // ���öԹȸ�������ĳ�ʼ����           ����

        //�½�һ���ȸ����������driver��
        WebDriver driver = new ChromeDriver(chromeCaps);

        //ͨ��driver��������������ӣ�url��
        driver.get(url);
        return driver;
    }


}

