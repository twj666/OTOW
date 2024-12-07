package io.github.geniusay.template.java.meta;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class MetaMethod extends ImportChecker{

    private String returnRes;

    private String methodName;

    private List<MetaMethodParam> methodParams = new ArrayList<>();

    private String methodBody;

    private List<MetaAnnotation> annotations = new ArrayList<>();

    public MetaMethod(String methodName, Class<?> returnRes, List<MetaMethodParam> params, String methodBody, List<MetaAnnotation> annotations) {
        this.methodName = methodName;
        this.returnRes = returnRes.getSimpleName();
        this.methodBody = methodBody;
        addAnnotations(annotations);
        addParams(params);
    }

    public MetaMethod(String methodName, Class<?> returnRes,List<MetaMethodParam> params, String methodBody) {
        this.methodName = methodName;
        this.returnRes = returnRes.getSimpleName();
        this.methodBody = methodBody;
        addParams(params);
    }

    public MetaMethod(String methodName, List<MetaMethodParam> params, String methodBody) {
        this.methodName = methodName;
        this.returnRes = "void";
        this.methodBody = methodBody;
        addParams(params);
    }

    public void addAnnotations(List<MetaAnnotation> annotations){
        addImportCheckers(annotations);
        this.annotations.addAll(annotations);
    }

    protected void addParams(List<MetaMethodParam> params){
        addImportCheckers(params);
        this.methodParams.addAll(params);
    }
}
