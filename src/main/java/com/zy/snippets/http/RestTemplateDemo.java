package com.zy.snippets.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * @Author: zy
 * @Date: 2018/11/18 14:26
 */
@Slf4j
public class RestTemplateDemo extends RestTemplateBase {

    public void get(String urlFormat, int lastIndex, String storeFileFormat) throws IOException {
        for (int i = 0; i <= lastIndex; i++) {
            String index = getIndex(4, i);
            String url = MessageFormat.format(urlFormat, index);
            byte[] res = (byte[]) httpInvoke(url);

            if (res == null || res.length == 0) {
                log.info("null result! index: {}", i);
                continue;
            }

            String fileName = MessageFormat.format(storeFileFormat, i);
            File file = new File(fileName);
            createFlie(file);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(res);
            }

            log.info("completed download, index: {}", i);
        }
    }

    private void createFlie(File file) throws IOException {
        if (!file.exists()) {
            File pfile = file.getParentFile();
            if (!pfile.exists()) {
                pfile.mkdirs();
            }
            file.createNewFile();
        }
    }

    private String getIndex(int fullNum, int index) {
        String indexStr = String.valueOf(index);
        int diff = fullNum - indexStr.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            sb.append(0);
        }
        sb.append(indexStr);
        return sb.toString();
    }

    public Object httpInvoke(String url) {
        RestTemplate restTemplate = getRestTemplate();
        try {
            ResponseEntity<byte[]> resp = restTemplate.exchange(url, HttpMethod.GET, null, byte[].class);
            if (HttpStatus.OK.equals(resp.getStatusCode())) {
                return resp.getBody();
            }
            log.info("http request fail, {}" + resp.getStatusCode().getReasonPhrase());
        } catch (Exception e) {
            log.info("http request fail!!");
        }
        return null;
    }

}
