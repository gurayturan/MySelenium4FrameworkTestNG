package annotation.test;

public class MyKeywords {


    @Keyword(keywordName = "write my name",keywordDesc = "gönderilen ismi yazar")
    public void writeMyName(String name,String surname){
        System.out.println("name:"+name +"-"+surname);
    }

//    @Keyword(keywordName = "write my age",keywordDesc = "gönderilen yaşı yazar")
//    public void writeMyAge(int age)
//    {
//        System.out.println("age:"+age);
//    }
}
