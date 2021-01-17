package lib;

import account.Account;
import person.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import lib.model.LibraryDao;
import account.Position;

public class AccountDaoImp implements LibraryDao<Account> {

    @Override
    public void insert(Account obj) {
        String acc = "INSERT INTO account VALUES(?,?,?,?,?)";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setInt(1, obj.getId());
            pstm.setString(2, obj.getPassword());
            if (obj.getPosition().equals(Position.DEPARTMENT)) {
                pstm.setString(3, "DEPARTMENT");
            } else {
                pstm.setString(3, "STUDENT");
            }
            pstm.setString(4, obj.getPerson().getFirstName());
            pstm.setString(5, obj.getPerson().getLastName());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void delete(Account obj) {
         String act = "DELETE FROM account WHERE id = '" + obj.getId() + "'";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(act)) {
        //    pstm.setString(1, obj.getCodeAct());
            pstm.execute();
            System.out.println("Excecute success");
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }
    
    
    public void delete2(int id) {
         String act = "DELETE FROM account WHERE id = '" + id + "'";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(act)) {
        //    pstm.setString(1, obj.getCodeAct());
            pstm.execute();
            System.out.println("Excecute success");
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void update(Account obj) {
        String acc = "UPDATE account SET Id = ?, Password = ?, State = ?, FName = ? , Lname = ? ";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setInt(1, obj.getId());
            pstm.setString(2, obj.getPassword());
            if (obj.getPosition().equals(Position.DEPARTMENT)) {
                pstm.setString(3, "DEPARTMENT");
            } else {
                pstm.setString(3, "STUDENT");
            }
            pstm.setString(4, obj.getPerson().getFirstName());
            pstm.setString(5, obj.getPerson().getLastName());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public Account findById(String id) {
        Account acc = null;
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM account");
            Position position = Position.valueOf(rs.getString("State"));
            if (rs.next()) {
                acc = new Account(rs.getInt(1), rs.getString(2), new Person(rs.getInt(1), rs.getString(4), rs.getString(5)), position);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }

    @Override
    public ArrayList<Account> getAll() {
        ArrayList<Account> acc = new ArrayList<Account>();
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM account where state = 'STUDENT'"  );
           // Position position = Position.valueOf(rs.getString("State"));
           
            while (rs.next()) {
                acc.add(new Account(rs.getInt(1), rs.getString(2), new Person(rs.getInt(1), rs.getString(4), rs.getString(5)), Position.STUDENT));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return acc;
    }

}
