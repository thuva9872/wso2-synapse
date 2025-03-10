package org.apache.synapse.mediators.template;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class represents the resolved parameter of the template.
 */
public class ResolvedConnectorParam {

    private String paramName;
    private ValueHolder inlineValue;
    private Map<String, ValueHolder> attributeMappings;
    List<ResolvedConnectorParam> childParams;

    public ResolvedConnectorParam() {

        attributeMappings = new LinkedHashMap<>();
        childParams = new LinkedList<>();
    }

    public String getParamName() {

        return paramName;
    }

    public void setParamName(String paramName) {

        this.paramName = paramName;
    }

    public Object getInlineValue() {

        return inlineValue;
    }

    public void setInlineValue(ValueHolder inlineValueHolder) {

        this.inlineValue = inlineValue;
    }

    public Map<String, ValueHolder> getAttributeMappings() {

        return attributeMappings;
    }

    public void setAttributeMappings(Map<String, ValueHolder> attributeMappings) {

        this.attributeMappings = attributeMappings;
    }

    public void addAttributeMapping(String name, ValueHolder value) {

        attributeMappings.put(name, value);
    }

    public List<ResolvedConnectorParam> getChildParams() {

        return childParams;
    }

    public void setChildParams(List<ResolvedConnectorParam> childParams) {

        this.childParams = childParams;
    }

    public void addChildParam(ResolvedConnectorParam childParam) {

        childParams.add(childParam);
    }
}
