package test.java.Homework;

import main.Parser.AutomatSpaceNormalizer;
import main.Parser.ISpaceNormolizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AutomatSpaceNormalizerTest {

    @Test
    void firstTest()
    {
        ISpaceNormolizer parser = new AutomatSpaceNormalizer();
        {
            String result = parser.normalize("   asdasas   safdasf a ");
            Assertions.assertEquals("asdasas safdasf a",result);
        }
        {
            String result = parser.normalize("   asdasas,  safdasf a ");
            Assertions.assertEquals("asdasas, safdasf a",result);
        }
        {
            String result = parser.normalize("  Text   . ettetetetetet   ");
            Assertions.assertEquals("Text. Ettetetetetet",result);
        }
        {
            String result = parser.normalize("asdasas ,    aqqqqqqa.");
            Assertions.assertEquals("asdasas, aqqqqqqa.",result);
        }
        {
            String res = parser.normalize("    abc        abc errrr    ");
            Assertions.assertEquals("abc abc errrr",res);
        }
        {
            String res = parser.normalize("  qqq  qqs   ");
            Assertions.assertEquals("qqq qqs",res);
        }
        {
            String res = parser.normalize("   asdasas   ,safdasf ,     aqqqqqqa ");
            Assertions.assertEquals("asdasas, safdasf, aqqqqqqa",res);
        }
    }

}