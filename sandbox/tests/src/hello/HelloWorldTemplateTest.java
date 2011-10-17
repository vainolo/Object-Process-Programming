package hello;

import org.junit.Test;

public class HelloWorldTemplateTest {

    @Test
    public void test() {
        System.out.println(HelloWorldTemplate.create(null).generate("Hello World"));
    }

}
