package com.javen.activemq;

import javax.annotation.Resource;
import javax.jms.*;

import com.javen.model.TbUser;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author created by xujn14
 * @date 2017-11-10 10:32
 **/
@Service
public class ProducerService {
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 向指定队列发送消息
     */
    public void sendMessage(Destination destination, final String msg) {
        System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
        final TbUser tbUser = new TbUser();
        tbUser.setUsername("xiaoxin");
        tbUser.setUserId(1);
        tbUser.setPassword("admin");
        tbUser.setSalt("gfdsgk");
       /* jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });*/
       /*  jmsTemplate.send(destination,new MessageCreator() {
             @Override
             public Message createMessage(Session session) throws JMSException {
                 ActiveMQObjectMessage msg = (ActiveMQObjectMessage)session.createObjectMessage();
                 msg.setObject((Serializable) tbUser);
                 return msg;
             }
         });*/
        jmsTemplate.send(destination,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ActiveMQMapMessage mapMsg = (ActiveMQMapMessage) session.createMapMessage();
                mapMsg.setString("user",tbUser.getUsername());
                mapMsg.setString("pass",tbUser.getPassword());
                return mapMsg;
            }
        });
    }

    /**
     * 向默认队列发送消息
     */
    public void sendMessage(final String msg) {
        String destination =  jmsTemplate.getDefaultDestination().toString();
        System.out.println("向队列" +destination+ "发送了消息------------" + msg);
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });

    }
}
