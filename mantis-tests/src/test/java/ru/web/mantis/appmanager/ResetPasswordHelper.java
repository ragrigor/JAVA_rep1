package ru.web.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Радочка on 06.11.2016.
 */
public class ResetPasswordHelper extends HelperBase{

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }


    public void start() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        wd.findElements(By.xpath("//tr[position()>1]/td[1]/a")).iterator().next().click();
        //if (next != wd.findElement(By.xpath("//tr[1]/td[1]/a"))){
       //     next.click();
            click(By.cssSelector("input[value='Сбросить пароль']"));
        }


        // public void viewProfileDetails(int id) {
        //     WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        //     WebElement row = checkbox.findElement(By.xpath("./../.."));
        //     row.findElement(By.xpath("./td[7]/a")).click();

      //  wd.findElements(By.xpath("./td[1]/a")).iterator().next().click();
       // wd.findElements(By.xpath("//td[1]/a")).iterator().next().click();



    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[type='submit']"));
    }
}
