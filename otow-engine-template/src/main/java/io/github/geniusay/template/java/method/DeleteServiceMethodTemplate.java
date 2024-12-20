package io.github.geniusay.template.java.method;

import io.github.geniusay.template.java.MethodTemplate;
import io.github.geniusay.template.meta.MetaMethod;
import org.apache.velocity.VelocityContext;

//TODO serviceImpl删除实体方法模板完善
public class DeleteServiceMethodTemplate extends MethodTemplate {
    private String entityClassName;

    protected DeleteServiceMethodTemplate(String templateFilePath) {
        super(templateFilePath);
    }

    public DeleteServiceMethodTemplate(String templateFilePath, String entityClassName) {
        super(templateFilePath);
        this.entityClassName = entityClassName;
    }

    @Override
    public MetaMethod generateMethod() {
        MetaMethod metaMethod = MetaMethod.justStringReinder(generateMethodBody());
        return metaMethod;
    }

    @Override
    public VelocityContext getContext() {
        VelocityContext context = new VelocityContext();
        context.put("entityClassName",entityClassName.toLowerCase());
        return context;
    }
}
