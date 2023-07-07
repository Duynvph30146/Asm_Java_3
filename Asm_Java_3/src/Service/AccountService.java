/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Account;
import Repository.AccountRepository;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ttuan
 */
public class AccountService {
    AccountRepository accountRepository= new AccountRepository();
    
    
    public Account findAccount(String username,String password) throws Exception{
        return accountRepository.findAccount(username, password);
    }
    public boolean CheckName(JTextField a){
        return accountRepository.checkNullName(a);
    }
    public boolean CheckPass(JPasswordField a){
        return accountRepository.checkNullMK(a);
    }
}
