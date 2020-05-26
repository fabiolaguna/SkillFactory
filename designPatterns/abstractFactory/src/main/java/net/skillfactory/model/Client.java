package net.skillfactory.model;

public class Client {

    private String name;
    private Product product;

    public Client(Product product, String name){
        this.product = product;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CLIENT : " + name + "\n" + product.toString();
    }
}
