/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Top10Product;
import Repository.Top10ProductRepository;
import java.util.List;

/**
 *
 * @author ttuan
 */
public class Top10ProductService {
    Top10ProductRepository top10ProductRepository=new Top10ProductRepository();
    public List<Top10Product> findAll() throws Exception{
        return top10ProductRepository.findAll();
    }
}
