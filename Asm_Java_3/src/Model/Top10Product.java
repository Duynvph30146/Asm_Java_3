/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author ttuan
 */
public class Top10Product {
    private Integer ProductId;
    private String ProductName;
    private Integer Quantity;
    private BigDecimal Price;

    public Top10Product() {
    }

    public Top10Product(Integer ProductId, String ProductName, Integer Quantity, BigDecimal Price) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }
    
}
