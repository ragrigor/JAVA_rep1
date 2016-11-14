package ru.web.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.web.mantis.model.Users;

/**
 * Created by Радочка on 06.11.2016.
 */
public class ResetPasswordHelper extends HelperBase{

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }


    public void start(Users user) {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        click(By.linkText(user.getUsername()));
        click(By.cssSelector("input[value='Сбросить пароль']"));
    }
        //if (user.getUsername() != "administrator") {
           // wd.findElement(By.xpath(".//*[text()='" + user.getUsername() + "']/..")).click();
            //wd.findElements(By.xpath("//tr[position()>1]/td[1]/a")).iterator().next().click();
            //if (next != wd.findElement(By.xpath("//tr[1]/td[1]/a"))){
            //     next.click();


        // public void viewProfileDetails(int id) {
         //    WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        //     WebElement row = checkbox.findElement(By.xpath("./../.."));
        //     row.findElement(By.xpath("./td[7]/a")).click();

      //  wd.findElements(By.xpath("./td[1]/a")).iterator().next().click();
    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[type='submit']"));
    }
}
