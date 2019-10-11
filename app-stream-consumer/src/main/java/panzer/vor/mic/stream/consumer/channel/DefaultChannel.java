package panzer.vor.mic.stream.consumer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import panzer.vor.mic.constanst.ChannelConstanst;

/**
 * Created by luozc on 2019-10-11
 */

public interface DefaultChannel {
    @Input(ChannelConstanst.USER_INPUT)
    SubscribableChannel inputUser();

    @Input(ChannelConstanst.PRODUCT_INPUT)
    SubscribableChannel input();
}
