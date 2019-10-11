package panzer.vor.mic.stream.consumer.listener;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import panzer.vor.mic.constanst.ChannelConstanst;
import panzer.vor.mic.entity.Product;
import panzer.vor.mic.entity.User;
import panzer.vor.mic.stream.consumer.channel.DefaultChannel;

/**
 * Created by luozc on 2019-10-11
 */
@EnableBinding(DefaultChannel.class)
public class MessageListener {

    @StreamListener(ChannelConstanst.PRODUCT_INPUT)
    public void input(Message<Product> message) {
        System.err.println("【*** 消息接收 ***】" + message.getPayload());
    }

    @StreamListener(ChannelConstanst.USER_INPUT)
    public void inputUser(Message<User> message) {
        System.err.println("【*** 消息接收 ***】" + message.getPayload());
    }

}
