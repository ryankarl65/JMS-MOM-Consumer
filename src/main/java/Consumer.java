import Service.ListernerImpl;
import org.apache.qpid.jms.JmsConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) throws JMSException {


        JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
        Connection con = factory.createConnection("admin", "admin");
        con.start();

        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //Destination dest = session.createQueue("PARIS");
        Destination dest = session.createTopic("DAKAR");
        MessageConsumer consumer = session.createConsumer(dest);

        Message msg = consumer.receive();

        ListernerImpl lst = new ListernerImpl();
        String sms = lst.getMessage(msg);

        System.out.println("J'ai recu un sms, bah le voici \n " + sms);


    }
}
