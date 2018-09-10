package io.github.openunirest.mappers;

import io.github.openunirest.request.GenericType;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.List;

import static org.junit.Assert.*;

public class GsonObjectMapperTest {
    private GsonObjectMapper om = new GsonObjectMapper();

    @Test
    public void canWrite() {
        TestMe test = new TestMe("foo", 42, new TestMe("bar", 666, null));

        String json = om.writeValue(test);

        JSONAssert.assertEquals(
                "{\"text\":\"foo\",\"nmbr\":42,\"another\":{\"text\":\"bar\",\"nmbr\":666}}"
                , json
                , true
        );
    }

    @Test
    public void canRead(){
        TestMe test = om.readValue("{\"text\":\"foo\",\"nmbr\":42,\"another\":{\"text\":\"bar\",\"nmbr\":666}}",
                TestMe.class);

        assertEquals("foo", test.text);
        assertEquals(42, test.nmbr);
        assertEquals("bar", test.another.text);
        assertEquals(666, test.another.nmbr);
        assertEquals(null, test.another.another);
    }

    @Test
    public void canReadGenerics(){
        List<TestMe> testList = om.readValue("[{\"text\":\"foo\",\"nmbr\":42,\"another\":{\"text\":\"bar\",\"nmbr\":666,\"another\":null}}]",
                new GenericType<List<TestMe>>(){});

        TestMe test = testList.get(0);

        assertEquals("foo", test.text);
        assertEquals(42, test.nmbr);
        assertEquals("bar", test.another.text);
        assertEquals(666, test.another.nmbr);
        assertEquals(null, test.another.another);
    }


    public static class TestMe {
        public String text;
        public int nmbr;
        public TestMe another;

        public TestMe(){}

        public TestMe(String text, Integer nmbr, TestMe another) {
            this.text = text;
            this.nmbr = nmbr;
            this.another = another;
        }
    }
}