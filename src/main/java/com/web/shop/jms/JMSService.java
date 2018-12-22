package com.web.shop.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import javax.jms.*;

public class JMSService {

    private static ActiveMQConnectionFactory connectionFactory=null; //управляемый объект от ApacheMQ
//служащий для создания объекта Connection.

    private static Connection connection=null; //сам Connection.

    private static Session session; //контекст для посылки и приема сообщений.

    private static Destination destination; //буфер отправки и получения сообщений.

    private static String queue=null; //имя очереди или топика.

    public static Boolean Connected(){
        try {
            if (connection==null){
                connectionFactory=getConnectionFactory();
                connection=connectionFactory.createConnection();
                //получаем экзмпляр класса подключения
                connection.start(); //стартуем
                session =connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                //создаем объект сессию без транзакций
                //параметром AUTO_ACKNOWLEDGE мы указали что отчет о доставке будет
                //отправляться автоматически при получении сообщения.
            }else{
                connection.start();
            }
            return true;
        } catch (JMSException ex) {
            return false;
        }
    }

    private static ActiveMQConnectionFactory getConnectionFactory(){
        return new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "failover://tcp://localhost:61616");
    }

    private static Destination getDestinationQueue(){
        try {
            return session.createQueue(queue);
        } catch (JMSException ex) {
            return null;
        }
    }

    public static void sendQueue(){
        //получаем имя очереди к которой необходимо подключитсья
        queue="productQueue";
        if (Connected()){
//            if (windowjms.isPtP()){
                destination=getDestinationQueue();
//            }else{
//                destination=getDestinationTopic();
//            }
            if (destination!=null){
                try {
                    MessageProducer producer = session.createProducer(destination);
                    producer.setDeliveryMode(DeliveryMode.PERSISTENT);//парметром PERSISTENT указываем что сообщение
                    //будет хранится до тех пор пока не будет доставлено адресату.
                    //Создаем текстовое сообщение.
                    TextMessage message =session.createTextMessage("updated");
                    producer.send(message);
                } catch (JMSException ex) {
                }
            }
        }
    }
}
