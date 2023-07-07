/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.DieuChinhGia;
import Repository.DieuChinhGiaRepository;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ttuan
 */
public class DieuChinhGiaService {
    DieuChinhGiaRepository dieuChinhGiaRepository= new DieuChinhGiaRepository();
    public List<DieuChinhGia> findByDanhMuc( Integer Id) throws Exception{
        return dieuChinhGiaRepository.findByDanhMuc(Id);
    }
    public Integer DieuChinhGia(BigDecimal gia,Integer Id){
        try {
            return dieuChinhGiaRepository.DieuChinhGia(gia, Id);
        } catch (Exception e) {
            return -1;
        }
    }
    public boolean check(String a){
        return dieuChinhGiaRepository.check(a);
    }
}
