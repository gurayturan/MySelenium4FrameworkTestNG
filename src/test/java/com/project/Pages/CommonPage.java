package com.project.Pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class CommonPage extends Page{

   public By searchBar= By.xpath("//*[@id='searchBar']");
   public By okButton= By.xpath("//*[@id='ok']");
   public Map<String, By> commonElements = new HashMap<String, By>();

   public CommonPage(Map<String, By> elems){
      super();
      commonElements.put("searchBar",searchBar);
      commonElements.put("okButton",okButton);
      elements=elems;
   }
}
