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
public class OcVit {
    private Integer Id,CategoryId;
    private String ProductName;
    private BigDecimal CurrenPrice;
    private double Quantity;
    private String Origin,Uses;

    public OcVit() {
    }

    public OcVit(Integer Id, Integer CategoryId, String ProductName, BigDecimal CurrenPrice, double Quantity, String Origin, String Uses) {
        this.Id = Id;
        this.CategoryId = CategoryId;
        this.ProductName = ProductName;
        this.CurrenPrice = CurrenPrice;
        this.Quantity = Quantity;
        this.Origin = Origin;
        this.Uses = Uses;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getUses() {
        return Uses;
    }

    public void setUses(String Uses) {
        this.Uses = Uses;
    }

    

    
    
    
    
            
}
