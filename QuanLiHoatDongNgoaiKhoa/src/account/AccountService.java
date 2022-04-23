/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AD
 */
public class AccountService {
    private ManagerAccount managerAccount;
    public AccountService(){
        managerAccount = new ManagerAccount();
    }
    public Account checkAccount(String userName) throws SQLException{
        return managerAccount.checkAccount(userName);
    }
    public void addAccount(Account account) throws SQLException{
        managerAccount.addAccount(account);
    }
    public Account getAccount(String userName, String passWord) throws SQLException{
        return managerAccount.getAccount(userName, passWord);
    }
    
}
