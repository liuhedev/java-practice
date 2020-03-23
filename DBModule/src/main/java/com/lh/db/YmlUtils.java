package com.lh.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuhe
 * @date 2020/03/23
 */
public class YmlUtils {

    public static void main(String[] args) {

        Properties prop = new Properties();
        try {
            //读取属性文件a.properties
            String resPath = YmlUtils.class.getResource("/").getPath();
            InputStream in = new BufferedInputStream(new FileInputStream(resPath + "application.properties"));
            prop.load(in);     ///加载属性列表
            Iterator<String> it = prop.stringPropertyNames().iterator();
            while (it.hasNext()) {
                String key = it.next();
                System.out.println(key + ":" + prop.getProperty(key));
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
