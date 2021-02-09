package Service;

import javax.jms.JMSException;
import javax.jms.Message;

public interface ListernerInterface {
     String getMessage(Message message) throws JMSException;
}
