package com.wenhao.pss.CreatCode;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by lenovo on 2016/10/17.
 */
public class CreateCode {
    //12.开关：默认情况下已经存在的文件不需要生成代码 true:覆盖所有代码
    private boolean createCode = false;

    //1.那些domain需要生成代码
    private String[] domains = {"Dept"};
    private String[] domainName = {"部门"};
    //2.定义固定的目录路径:都是使用相对路径,规范：路径前面都不加/,路径的后面都加/
    private static final String SRC = "src/main/java/";
    private static final String PACKAGE = "com/wenhao/pss/";
    private static final String RESOURCES = "src/main/resources/";
    private static final String WEBAPP = "src/main/webapp/";
    //3.有那些模板需要生成
    private String[] templates = { "Service.java", "ServiceImpl.java", "Action.java", "Query.java", "Context.xml", "hbm.xml", "input.jsp", "list.jsp", "domain.js"};
    //4.模板文件对应的生成文件路径
    private String[] filePath = {SRC + PACKAGE + "service/", SRC + PACKAGE + "service/impl/", SRC + PACKAGE + "web/", SRC + PACKAGE + "page/",
            RESOURCES + "manger/",
            RESOURCES + PACKAGE + "domain/",
            WEBAPP + "WEB-INF/view/",
            WEBAPP + "WEB-INF/view/",
            WEBAPP + "js/model/"
    };

    @Test
    public void create() throws Exception {
        VelocityContext context = new VelocityContext();
        //5.外循环：domains
        for (int i = 0; i < domains.length; i++) {
            context.put("domain", domains[i]);
            context.put("domainName", domainName[i]);
            //6.处理domain首字母小写
            String lowerDomain = StringUtils.uncapitalize(domains[i]);
            context.put("lowerDomain", lowerDomain);
            //7.内循环：templates和files
            for (int j = 0; j < templates.length; j++) {
                //8.实例化文件存放的路径
                File file = new File(filePath[j] + domains[i] + templates[j]);
                //9.处理特殊的文件名称
                if ("Service.java".equals(templates[j])) {
                    file = new File(filePath[j] + "I" + domains[i] + templates[j]);
                } else if ("hbm.xml".equals(templates[j])) {
                    file = new File(filePath[j] + domains[i] + "." + templates[j]);
                } else if ("input.jsp".equals(templates[j])) {
                    file = new File(filePath[j] + lowerDomain + "/" + lowerDomain + "_" + templates[j]);
                } else if ("list.jsp".equals(templates[j])) {
                    file = new File(filePath[j] + lowerDomain + "/" + lowerDomain + "_" + templates[j]);
                } else if ("domain.js".equals(templates[j])) {
                    file = new File(filePath[j] + lowerDomain + "/" + lowerDomain + ".js");
                }

                if (file.exists() && !createCode) {
                    continue;
                }
                System.out.println(file.getAbsolutePath());
                Template template = Velocity.getTemplate("temp/" + templates[j], "UTF-8");
                //10.判断父目录是否存在
                File paretnFile = file.getParentFile();
                if (!paretnFile.exists()) {
                    paretnFile.mkdirs();
                }
                //11.必须关闭流，写入内容
                FileWriter fileWriter = new FileWriter(file);
                template.merge(context, fileWriter);
                fileWriter.close();
                //System.out.println(template.getName());
                //template.merge(context,);

            }
        }
    }
}
