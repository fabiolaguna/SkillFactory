package net.skillfactory;

import net.skillfactory.connection.ConnectionClass;
import net.skillfactory.exceptions.ProductNotFoundException;
import net.skillfactory.model.Product;
import net.skillfactory.repository.ProductRepository;

import java.util.Optional;

public class App {

    public static void main( String[] args ) {

        // Creacion de productos con el patron builder
        Product p1 = new Product.Builder().name("Desodorante").price(150.50).brand("Axe").unit(2).quantity(5).discount(12.5).build();
        Product p2 = new Product.Builder().name("Camiseta de boca").brand("Adidas").build();

        ProductRepository repo = new ProductRepository();

        // Insertar productos a la base de datos
        /*repo.addProduct(p1);
        repo.addProduct(p2);*/

        // Eliminar un producto especificado por su id
        Integer rowsAffected = repo.delete(3);
        if (rowsAffected == 0){
            System.out.println("No se ha podido eliminar el producto");
        } else {
            System.out.println("Producto eliminado");
        }

        // Modificar un producto mediante id
        Integer rowsUpdatedAffected = repo.update(new Product.Builder().name("Camiseta del Barsa").brand("Nike").quantity(33).build(), 4);
        if (rowsUpdatedAffected == 0){
            System.out.println("No se ha podido modificar el producto");
        } else {
            System.out.println("Producto modificado");
        }

        // Devolver un producto en especifico de la base de datos
        Product productFound = repo.findById(1);
        System.out.println(Optional.ofNullable(productFound).orElseThrow(ProductNotFoundException::new));

        // Listar todos los productos de la base de datos
        repo.findAll().stream().forEach(product -> System.out.println(product.toString()));

        ConnectionClass.closeConnection();
    }
}
