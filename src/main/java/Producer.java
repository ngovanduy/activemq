import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Producer {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String nameQueue = "my_queue";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(nameQueue);

        MessageProducer messageProducer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("duynv");

        messageProducer.send(message);
        connection.close();
    }
}
