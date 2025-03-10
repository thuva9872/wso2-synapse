package org.apache.synapse.mediators.template;

import org.apache.synapse.mediators.Value;

/**
 * This class represents the expression and the resolved value of the expression. The expression is stored as we may
 * need that in other places.
 */
public class ValueHolder {

    private Value expression;
    private Object resolvedValue;

    public ValueHolder(Value expression, Object resolvedValue) {

        this.expression = expression;
        this.resolvedValue = resolvedValue;
    }

    public Value getExpression() {

        return expression;
    }

    public void setExpression(Value expression) {

        this.expression = expression;
    }

    public Object getResolvedValue() {

        return resolvedValue;
    }

    public void setResolvedValue(Object resolvedValue) {

        this.resolvedValue = resolvedValue;
    }
}
