import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTransformerTest {

    @Test
    public void testTransform() {
        StringTransformer transformer = new StringTransformer();

        assertEquals("AbCdEf", transformer.transform("AbCdEf"));
        assertEquals("EvEn", transformer.transform("EvEn"));
        assertEquals("OdD", transformer.transform("OdD"));

    }
}

