package panzer.vor.mic.stream.provider.service;

import panzer.vor.mic.entity.Product;
import panzer.vor.mic.entity.User;

public interface IMessageProvider {
     void send(Product product);
     void sendUser(User user);
}