package jishuneimu.basis.xmlparse;

import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/26
 */
public class GenericTokenParserTest {


    public static void main(String[] args) {

        GenericTokenParser genericTokenParser = new GenericTokenParser("${", "}", new TokenHandler() {
            @Override
            public String handleToken(String content) {
                System.out.println(content);
                return null;
            }
        });

        genericTokenParser.parse("${item.length}");

    }

}
