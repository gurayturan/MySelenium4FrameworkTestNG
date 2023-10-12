package annotation.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test
{
    public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        MyKeywords mk=new MyKeywords();
        for(Method method:mk.getClass().getDeclaredMethods())
        {
         if(method.isAnnotationPresent(Keyword.class)&method.getAnnotation(Keyword.class).keywordName().toString().equalsIgnoreCase("write my name")){
             method.invoke(mk,  "guray","turan"); // pass arg
         }
        }
    }
}
