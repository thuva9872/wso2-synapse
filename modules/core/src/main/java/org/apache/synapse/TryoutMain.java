package org.apache.synapse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.util.UIDGenerator;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.engine.AxisConfiguration;
import org.apache.axis2.transport.RequestResponseTransport;
import org.apache.axis2.transport.base.BaseConstants;
import org.apache.synapse.commons.builders.SynapseMessageConverter;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.config.xml.endpoints.HTTPEndpointFactory;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.apache.synapse.core.axis2.Axis2SynapseEnvironment;
import org.apache.synapse.core.axis2.MessageContextCreatorForAxis2;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.HTTPEndpoint;
import org.apache.synapse.mediators.builtin.CallMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.apache.synapse.transport.netty.BridgeConstants;
import org.apache.synapse.transport.netty.config.SourceConfiguration;
import org.apache.synapse.transport.netty.util.RequestResponseUtils;
import org.apache.synapse.transport.nhttp.HttpCoreRequestResponseTransport;
import org.apache.synapse.transport.util.HttpMessageHandler;
import org.wso2.transport.http.netty.message.HttpCarbonMessage;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.stream.XMLStreamException;

import static org.apache.axiom.om.util.AXIOMUtil.stringToOM;

public class TryoutMain {

    private static Axis2SynapseEnvironment synEnv;

    public static void main(String[] args) throws AxisFault, XMLStreamException {

        org.apache.synapse.MessageContext axis2MessageContext = TryoutMain.createMessageContext();

        PropertyMediator propertyMediator = new PropertyMediator();
        propertyMediator.setScope("default");
        propertyMediator.setName("testProperty");
        propertyMediator.setValue("testValue");
        propertyMediator.mediate(axis2MessageContext);

//        String httpXml = "<endpoint name=\"http\" xmlns=\"http://ws.apache.org/ns/synapse\">\n" +
//                "\t<http method=\"get\" uri-template=\"https://www.google.com\">\n" +
//                "\t\t<suspendOnFailure>\n" +
//                "\t\t\t<initialDuration>-1</initialDuration>\n" +
//                "\t\t\t<progressionFactor>1</progressionFactor>\n" +
//                "\t\t</suspendOnFailure>\n" +
//                "\t\t<markForSuspension>\n" +
//                "\t\t\t<retriesBeforeSuspension>0</retriesBeforeSuspension>\n" +
//                "\t\t</markForSuspension>\n" +
//                "\t</http>\n" +
//                "</endpoint>";
//        OMElement httpElement  = stringToOM(httpXml);
//        Endpoint http = HTTPEndpointFactory.getEndpointFromElement(httpElement, true, new Properties());
//        CallMediator callMediator = new CallMediator();
//        callMediator.setEndpoint(http);
//        callMediator.setBlocking(true);
//        callMediator.init(synEnv);
//        callMediator.mediate(axis2MessageContext);



        System.out.println("Property set: " + axis2MessageContext.getProperty("testProperty"));


    }

    private static org.apache.synapse.MessageContext createMessageContext() throws AxisFault {
        SynapseConfiguration synConfig = new SynapseConfiguration();
        AxisConfiguration axisConfig = new AxisConfiguration();
        synConfig.setAxisConfiguration(axisConfig);

        org.apache.axis2.context.MessageContext axis2Ctx = new org.apache.axis2.context.MessageContext();
        ConfigurationContext cfgCtx = new ConfigurationContext(axisConfig);
        axis2Ctx.setConfigurationContext(cfgCtx);

        MessageContextCreatorForAxis2.setSynConfig(synConfig);
        synEnv = new Axis2SynapseEnvironment(cfgCtx,synConfig);
        MessageContextCreatorForAxis2.setSynEnv(synEnv);
        return MessageContextCreatorForAxis2.getSynapseMessageContext(axis2Ctx);
    }

}
