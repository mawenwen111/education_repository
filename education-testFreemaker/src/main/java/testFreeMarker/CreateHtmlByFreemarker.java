package testFreeMarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CreateHtmlByFreemarker {
    private static final String TEMPLATE_PATH = "D:\\test";
    private static final String CLASS_PATH = "D:\\test";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("username", "zhangsan");
            dataMap.put("password", "123456");
            dataMap.put("age", "18");
            dataMap.put("address", "test");
            // step4 加载模版文件
            Template template = configuration.getTemplate("user.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH + "\\" + "user.html");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^user.ftl 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}