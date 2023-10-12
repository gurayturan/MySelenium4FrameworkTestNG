package annotation.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Keyword {

    String keywordName();
    String keywordDesc();
}
