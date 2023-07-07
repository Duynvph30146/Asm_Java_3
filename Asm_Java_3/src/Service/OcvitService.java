/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.OcVit;
import Model.OcvitTable;
import Repository.OcvitRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ttuan
 */
public class OcvitService {

    OcvitRepository ocvitRepository = new OcvitRepository();

    public List<OcVit> layDanhSach() throws Exception {
        return ocvitRepository.getAll();
    }

    public Integer ThemOcVit(OcVit ocVit) {
        try {
            return ocvitRepository.Them(ocVit);

        } catch (Exception e) {
            return -1;
        }
    }

    public boolean checkNull(JTextField a) {
        return ocvitRepository.checkNull(a);
    }

    public boolean checkMaDM(JTextField a) {
        return ocvitRepository.checkMaDM(a);

    }
    public boolean checkGia(JTextField a){
        return ocvitRepository.checkGia(a);
    }
    public boolean checkSL(JTextField a){
        return ocvitRepository.checkSL(a);
    }

    public Integer XoaOc(Integer id) {
        try {
            return ocvitRepository.Xoa(id);
            
        } catch (Exception ex) {
            return -1;
        }

    }



    public List<OcVit> TimKiemOcVit(String a) throws Exception{
        return ocvitRepository.TimKiem(a);
    }
    
    public Integer CapNhatOc(OcVit ocVit){
        try {
            return ocvitRepository.CapNhat(ocVit);
        } catch (Exception e) {
            return -1;
        }
    }
    public boolean checkIdCapNhat(JTextField a,Integer b){
        return ocvitRepository.checkIdCapNhat(a,b);
    }
    
    public boolean checkGiaCapNhat(JTextField a,Integer b){
        return ocvitRepository.checkGiaCapNhat(a, b);
    }
    public boolean checkSLCapNhat(JTextField a, Integer b){
        return ocvitRepository.checkSLCapNhap(a, b);
    }
    
}
