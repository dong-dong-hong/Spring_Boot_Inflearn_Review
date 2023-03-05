package hello.core.order_1;

public interface OrderService {
    Order createOrder(Long userId, String productName, int productPrice);
}
