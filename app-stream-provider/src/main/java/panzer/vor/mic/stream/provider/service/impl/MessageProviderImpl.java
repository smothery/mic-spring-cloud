package panzer.vor.mic.stream.provider.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import panzer.vor.mic.constanst.ChannelConstanst;
import panzer.vor.mic.entity.Product;
import panzer.vor.mic.entity.User;
import panzer.vor.mic.stream.provider.channel.DefaultChannel;
import panzer.vor.mic.stream.provider.service.IMessageProvider;

@EnableBinding(DefaultChannel.class)
public class MessageProviderImpl implements IMessageProvider {
    @Autowired
    @Qualifier(ChannelConstanst.PRODUCT_OUTPUT)
    private MessageChannel output;  // 消息的发送管道
    @Autowired
    @Qualifier(ChannelConstanst.USER_OUTPUT)
    private MessageChannel userOutput;  // 消息的发送管道

    @Override
    public void send(Product product) {
        output.send(MessageBuilder.withPayload(product).build());
    }

    @Override
    public void sendUser(User user) {
        userOutput.send(MessageBuilder.withPayload(user).build());
    }
}