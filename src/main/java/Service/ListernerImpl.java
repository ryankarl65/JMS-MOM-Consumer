package Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ListernerImpl implements MessageListener, ListernerInterface {
    @Override
    public void onMessage(Message message) {
        TextMessage sms = (TextMessage) message;
        try {
            System.out.println("J'ai reccupere " + sms.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMessage(Message message) throws JMSException {
        TextMessage sms = (TextMessage) message;
        return sms.getText();
    }
}
