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
public class DieuChinhGia {
    private Integer ProductId,CategoryId;
    private String ProductName;
    private BigDecimal CurrenPrice;

    public DieuChinhGia() {
    }

    public DieuChinhGia(Integer ProductId, Integer CategoryId, String ProductName, BigDecimal CurrenPrice) {
        this.ProductId = ProductId;
        this.CategoryId = CategoryId;
        this.ProductName = ProductName;
        this.CurrenPrice = CurrenPrice;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public BigDecimal getCurrenPrice() {
        return CurrenPrice;
    }

    public void setCurrenPrice(BigDecimal CurrenPrice) {
        this.CurrenPrice = CurrenPrice;
    }

    @Override
    public String toString() {
        return "DieuChinhGia{" + "ProductId=" + ProductId + ", ProductName=" + ProductName + ", CurrenPrice=" + CurrenPrice + '}';
    }
    
}
