package testing.util;

import java.util.*;

public class StringUtil {
    private static final Integer FIRST_SYMBOL_CODE = 97;
    private static final Integer LAST_SYMBOL_CODE = 122;
    private static final Integer COUNT_SYMBOLS = 10;

    public static String getGeneratorText() {
        Random random = new Random();

        String generatedString = random.ints(FIRST_SYMBOL_CODE, LAST_SYMBOL_CODE + 1)
                .limit(COUNT_SYMBOLS)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
