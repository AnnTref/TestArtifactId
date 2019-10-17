
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ozon {
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ozon.ru/");
        Thread.sleep(3000);

        driver.manage().window().maximize();

        WebElement buttonKatalog = driver.findElement(By.xpath("//button[@value = 'Каталог']"));
        Thread.sleep(3000);
        buttonKatalog.click();

        WebElement book = driver.findElement(By.xpath("//span[@class='_389557']/ancestor::a[@href='/category/knigi-16500/']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(book).build().perform();

        Thread.sleep(3000);
        WebElement kompTech = driver.findElement(By.xpath("//span[contains(text(), 'Компьютерные')]"));
        kompTech.click();
        Thread.sleep(3000);

        WebElement checkBestsellers = driver.findElement(By.xpath("//span[text()='Бестселлеры']"));
        if(checkBestsellers.isSelected()){
            checkBestsellers.click();
        }
        checkBestsellers.click();
        Thread.sleep(3000);

        WebElement checkProgr = driver.findElement(By.xpath("//span[contains(text(),'Языки')]"));

        if(checkProgr.isSelected()){
            checkProgr.click();
        }
        checkProgr.click();
        Thread.sleep(3000);

        WebElement checkBook = driver.findElement(By.xpath("//a[@href='/context/detail/id/7821666/']"));
        checkBook.click();
        Thread.sleep(3000);

        WebElement buttonBox = driver.findElement(By.xpath("//button[contains(text(), 'Добавить в корзину')]"));
        buttonBox.click();
        Thread.sleep(3000);

        boolean buttonPresent = driver.findElements(By.xpath("//a[@class='_652bc6 ab8d80']")).size() > 0;
        if (buttonPresent==true)
        { System.out.println("Книга в козине, кнопка не отображается");}
        else
        { System.out.println("Книга НЕ козине, кнопка не отображается");}

        WebElement Box = driver.findElement(By.xpath("//span[contains(text(),'Корзина')]"));
        Box.click();
        Thread.sleep(1000);

        WebElement Picture = driver.findElement(By.xpath("//div[@class='img item-image _96fa6d']"));
        Picture.click();
        Thread.sleep(1000);

        boolean autorPresent = driver.findElements(By.xpath("//div[contains(text(),'Изучаем Java')]")).size() > 0;
        if (autorPresent==true)
            { System.out.println("Ваша книга в корзине"); }
        else
            { System.out.println("Это не ваша книга в корзине"); }
            }
    }