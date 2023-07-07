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
public class XuatNhap {
    private Integer CategoryId;
    private Integer ProductId;
    private String ProductName;
    private Integer Quantity;
    private BigDecimal CurrenPrice;

    public XuatNhap() {
    }

    public XuatNhap(Integer CategoryId, Integer ProductId, String ProductName, Integer Quantity, BigDecimal CurrenPrice) {
        this.CategoryId = CategoryId;
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.CurrenPrice = CurrenPrice;
    }

   

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer CategoryId) {
        this.CategoryId = CategoryId;
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

    public BigDecimal getCurrenPrice() {
        return CurrenPrice;
    }

    public void setCurrenPrice(BigDecimal CurrenPrice) {
        this.CurrenPrice = CurrenPrice;
    }

    @Override
    public String toString() {
        return "XuatNhap{" + "ProductId=" + ProductId + ", ProductName=" + ProductName + ", Quantity=" + Quantity + ", CurrenPrice=" + CurrenPrice + '}';
    }
    

    

    
    
    
}
