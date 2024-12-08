package io.github.geniusay.template.meta;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MetaMethod extends ImportChecker{

    private String returnRes;

    private String methodName;

    private List<MetaMethodParam> methodParams = new ArrayList<>();

    private String methodBody;

    private List<MetaAnnotation> annotations = new ArrayList<>();

    private boolean staticFlag = false;

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

    public void setIsStatic(boolean isStatic){
        this.staticFlag = isStatic;
    }
}