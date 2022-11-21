package bussinesLayer;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private int idClient;
    private int idOrder;
    private Date orderData;
    private int totalPrice;

    public Order(int idClient, int idOrder, Date orderData, int totalPrice) {
        this.idClient = idClient;
        this.idOrder = idOrder;
        this.orderData = orderData;
        this.totalPrice = totalPrice;
    }

    public int getIdClient() { return idClient; }

    public int getIdOrder() { return idOrder; }

    public void setIdOrder(int idOrder) { this.idOrder = idOrder; }

    public Date getOrderData() { return orderData; }

    public void setOrderData(Date orderData) { this.orderData = orderData; }

    public int getTotalPrice() { return totalPrice; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return (idOrder == order.idOrder && idClient == order.idClient && orderData.equals(order.orderData));
    }

    @Override
    public int hashCode() { return Objects.hash(idOrder, idClient, orderData); }

    @Override
    public String toString() {
        return "Order: " + "idClient = " + idClient + " idOrder=" + idOrder +
                " orderData = " + orderData + " totalPrice=" + totalPrice + "\n";
    }
}
