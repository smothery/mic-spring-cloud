package panzer.vor.mic.stream.provider.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import panzer.vor.mic.constanst.ChannelConstanst;

/**
 * Created by luozc on 2019-10-11
 */
public interface DefaultChannel {

    @Output(ChannelConstanst.PRODUCT_OUTPUT)
    MessageChannel output();

    @Output(ChannelConstanst.USER_OUTPUT)
    MessageChannel outputUser();
}
