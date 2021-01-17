//package lib;
//
//import account.Account;
//import account.StudentAccount;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import lib.model.LibraryDao;
//
//public class StudentDaoImp implements LibraryDao<StudentAccount> {
//
//    @Override
//    public void insert(StudentAccount obj) {
//        String acc = "INSERT INTO studentaccount VALUES(?,?,?)";
//        try (Connection conn = ConnectDB.getConnection();
//                PreparedStatement pstm = conn.prepareStatement(acc)) {
//            pstm.setInt(1, obj.getId());
//            pstm.setString(2, obj.getRegisterCourses());
//            pstm.setString(3, obj.);
//            pstm.execute();
//        } catch (SQLException sqlex) {
//            java.util.logging.Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
//        }
//    }
//
//    @Override
//    public void delete(StudentAccount obj) {
//        String acc = "DELETE from studentaccount ";
//        try (Connection conn = ConnectDB.getConnection();
//                PreparedStatement pstm = conn.prepareStatement(acc)) {
//            pstm.setLong(2, obj.getId());
//            pstm.execute();
//        } catch (SQLException sqlex) {
//            java.util.logging.Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
//        }
//    }
//
//    @Override
//    public void update(StudentAccount obj) {
//        String acc = "UPDATE studentaccount ";
//        try (Connection conn = ConnectDB.getConnection();
//                PreparedStatement pstm = conn.prepareStatement(acc)) {
//            pstm.setLong(2, obj.getId());
//            pstm.execute();
//        } catch (SQLException sqlex) {
//            java.util.logging.Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
//        }
//    }
//
//    @Override
//    public StudentAccount findById(String id) {
//        StudentAccount stuacc = null;
//        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
//            ResultSet rs = stm.executeQuery("SELECT * FROM studentaccounts ");
//            if (rs.next()) {
//                stuacc = new StudentAccount();
//            }
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return stuacc;
//    }
//
//    @Override
//    public ArrayList<StudentAccount> getAll() {
//        ArrayList<StudentAccount> stuacc = new ArrayList<StudentAccount>();
//        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement()) {
//            ResultSet rs = stm.executeQuery("SELECT * FROM studentaccounts ");
//            while (rs.next()) {
//                stuacc.add(new StudentAccount();
//            }
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return stuacc;
//    }
//
//}
