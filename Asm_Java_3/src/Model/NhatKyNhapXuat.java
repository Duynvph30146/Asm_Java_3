/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author ttuan
 */
public class NhatKyNhapXuat {
    private Integer ProductId;
    private LocalDateTime IEDate;
    private Integer IoE;
    private double Quantity;
    private BigDecimal Price;

    public NhatKyNhapXuat() {
    }

    public NhatKyNhapXuat(Integer ProductId, LocalDateTime IEDate, Integer IoE, double Quantity, BigDecimal Price) {
        this.ProductId = ProductId;
        this.IEDate = IEDate;
        this.IoE = IoE;
        this.Quantity = Quantity;
        this.Price = Price;
    }
    
    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }

    public LocalDateTime getIEDate() {
        return IEDate;
    }

    public void setIEDate(LocalDateTime IEDate) {
        this.IEDate = IEDate;
    }

    public Integer getIoE() {
        return IoE;
    }

    public void setIoE(Integer IoE) {
        this.IoE = IoE;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    
    
}
