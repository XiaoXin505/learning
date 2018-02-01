package com.javen.activemq;

import com.javen.model.TbUser;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;
import java.util.Enumeration;

/**
 * @author created by xujn14
 * @date 2017-11-10 10:32
 **/
public class QueueMessageListener implements MessageListener {
    //当收到消息后，自动调用该方法
    @Override
    public void onMessage(Message message) {
    //  ActiveMQObjectMessage tm = (ActiveMQObjectMessage) message;
        ActiveMQMapMessage mm=(ActiveMQMapMessage) message;
        System.out.println("QueueMessageListener监听到了文本消息：\t"
                +  mm);
        //do something ...
        try {
           //TbUser user=(TbUser) tm.getObject();
            String name =  mm.getString("user");
            String pass=mm.getString("pass");
            Enumeration<String> mapNames = mm.getMapNames();
            String key=null;
            Object value = null;
            while(mapNames.hasMoreElements()){
                key=mapNames.nextElement();
                value=mm.getObject(key);
            }
            //  System.out.println("监听的对象："+user.getUsername()+","+user.getPassword());
            System.out.println("监听的map："+name+","+pass);
            System.out.println("遍历的map:"+key+","+ value);
        } catch ( JMSException e ) {
            e.printStackTrace();
        }
    }

}
