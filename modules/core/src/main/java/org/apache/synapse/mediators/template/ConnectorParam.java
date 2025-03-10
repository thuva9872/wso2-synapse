package org.apache.synapse.mediators.template;

import org.apache.synapse.mediators.Value;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class represents the parameter of the connector operation
 * {@code <connector.operation>
 *     <parameter1 name="p1" value="{expr}">
 *         <childParam name="p2" value="{expr}"/>
 *     </parameter1>
 *     <parameter2>value</parameter2>
 * </connector.operation>}
 */
public class ConnectorParam {

    private String paramName;

    /**
     * stores the expression for {@code <parameter2>value</parameter2>}
     */
    private Value inlineValue;

    /**
     * stores the attribute name expression map. {@code <parameter1 name="p1" value="{expr}">}
     */
    private Map<String, Value> attributeName2ExpressionMap;

    /**
     * stores the nested parameters. {@code <childParam name="p2" value="{expr}"/>}
     */
    private List<ConnectorParam> childParams;

    public ConnectorParam() {

        attributeName2ExpressionMap = new LinkedHashMap<>();
        childParams = new LinkedList<>();
    }

    public String getParamName() {

        return paramName;
    }

    public void setParamName(String paramName) {

        this.paramName = paramName;
    }

    public Value getInlineValue() {

        return inlineValue;
    }

    public void setInlineValue(Value inlineValue) {

        this.inlineValue = inlineValue;
    }

    public Map<String, Value> getAttributeName2ExpressionMap() {

        return attributeName2ExpressionMap;
    }

    public void setAttributeName2ExpressionMap(Map<String, Value> attributeName2ExpressionMap) {

        this.attributeName2ExpressionMap = attributeName2ExpressionMap;
    }

    public List<ConnectorParam> getChildParams() {

        return childParams;
    }

    public void setChildParams(List<ConnectorParam> childParams) {

        this.childParams = childParams;
    }

    public void addChildParam(ConnectorParam childParam) {

        childParams.add(childParam);
    }

    public void addAttribute2Expression(String attributeName, Value expression) {

        attributeName2ExpressionMap.put(attributeName, expression);
    }
}
