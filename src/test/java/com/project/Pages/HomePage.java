package com.project.Pages;

import org.openqa.selenium.By;

public class HomePage extends Page{

   public By googleSearchbar= By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");

   public HomePage(){
      super();
      elements.put("googleSearchbar",googleSearchbar);
   }
}
