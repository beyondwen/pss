package com.wenhao.pss.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

import java.io.StringWriter;

/**
 * Created by lenovo on 2016/10/17.
 */
public class HelloWorld {
    @Test
    public void helloWord() throws Exception {
        VelocityContext context = new VelocityContext();
        context.put("text", "hello velocity");
        //Velocity velocity = new Velocity();
        Template template = Velocity.getTemplate("velocity.jsp", "UTF-8");
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        System.out.println(writer.toString());
    }
}
