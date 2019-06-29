package com.zy.snippets.http;

import lombok.extern.java.Log;
import org.junit.Test;

/**
 * @Author: zy
 * @Date: 2018/11/18 15:37
 */
@Log
public class RestTemplateDemoTest {

    @Test
    public void get() {
        try {
            String urlFormat = "http://www.qq.com/{0}.ts";
            int lastIndex = 257;
            String flieFormat = "H:\\test\\" + System.currentTimeMillis() + "\\{0}.ts";
            RestTemplateDemo demo = new RestTemplateDemo();
            demo.get(urlFormat, lastIndex, flieFormat);
        } catch (Exception e) {
            log.info(e.getMessage());

            StringBuilder sb = new StringBuilder();
            for (StackTraceElement se : e.getStackTrace()) {
                sb.append(se.toString()).append("\r\n");
            }
            log.info(sb.toString());
        }
    }

}
