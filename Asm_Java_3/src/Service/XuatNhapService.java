/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhatKyNhapXuat;
import Model.XuatNhap;
import Repository.XuatNhapRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ttuan
 */
public class XuatNhapService {

    XuatNhapRepository xuatNhapRepository = new XuatNhapRepository();

    public List<XuatNhap> findByDanhMuc(Integer id) throws Exception {
        return xuatNhapRepository.findByDanhMuc(id);
    }

    public Integer Nhap(double Sluong, Integer id) {
        try {
            return xuatNhapRepository.Nhap(Sluong, id);
        } catch (Exception ex) {
            return -1;
        }
    }

    public Integer Xuat(double Sluong, Integer id) {
        try {
            return xuatNhapRepository.Xuat(Sluong, id);
        } catch (Exception e) {
            return -1;
        }
    }

    public Integer NhatkyNhap(NhatKyNhapXuat nk) {
        try {
            return xuatNhapRepository.NhatKyNhap(nk);
        } catch (Exception ex) {
            return -1;
        }
    }

    public Integer NhatkyXuat(NhatKyNhapXuat nk) {
        try {
            return xuatNhapRepository.NhatKyXuat(nk);
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean CheckNull(String a) {
        return xuatNhapRepository.checkNullName(a);
    }

    public boolean checkSo(String a) {
        return xuatNhapRepository.checkSo(a);
    }

    public boolean checkSoTN(String a) {
        return xuatNhapRepository.checkSoTN(a);
    }

    public boolean checkSL(String a) {
        return xuatNhapRepository.checkSL(a);
    }

    public boolean checkQuaSL(String a, Integer SL) {
        return xuatNhapRepository.checkQuaSL(a, SL);
    }

}
