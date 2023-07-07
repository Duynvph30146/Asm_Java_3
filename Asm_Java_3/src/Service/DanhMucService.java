package Service;


import Model.DanhMuc;
import Repository.DanhMucRepository;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ttuan
 */
public class DanhMucService {
    DanhMucRepository danhMucRepository= new DanhMucRepository();
    public List<DanhMuc> findAll() throws Exception{
        return danhMucRepository.findAll();
    }
}
