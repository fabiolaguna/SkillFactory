package net.skillfactory.model;

import java.util.Optional;

public class Product {

    private Integer id;
    private String name;
    private Double price;
    private String brand;
    private Integer unit;
    private Integer quantity;
    private Double discount;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public Integer getUnit() {
        return unit;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Double getDiscount() {
        return discount;
    }

    public static class Builder {

        private Integer id;
        private String name;
        private Double price;
        private String brand;
        private Integer unit;
        private Integer quantity;
        private Double discount;

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder price(Double price){
            this.price = price;
            return this;
        }
        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }
        public Builder unit(Integer unit){
            this.unit = unit;
            return this;
        }
        public Builder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        public Builder discount(Double discount){
            this.discount = discount;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

    private Product(Builder b){
        this.id = b.id;
        this.name = Optional.ofNullable(b.name).orElseGet(() -> b.name == null ? "" : b.name);
        this.price = Optional.ofNullable(b.price).orElseGet(() -> b.price == null ? 0 : b.price);
        this.brand = Optional.ofNullable(b.brand).orElseGet(() -> b.brand == null ? "" : b.brand);
        this.unit = Optional.ofNullable(b.unit).orElseGet(() -> b.unit == null ? 0 : b.unit);
        this.quantity = Optional.ofNullable(b.quantity).orElseGet(() -> b.quantity == null ? 0 : b.quantity);
        this.discount = Optional.ofNullable(b.discount).orElseGet(() -> b.discount == null ? 0 : b.discount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
