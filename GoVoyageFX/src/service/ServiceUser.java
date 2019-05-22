/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Agence;
import entite.Hotel;
import entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DataSource;

/**
 *
 * @author Lenovo
 */
public class ServiceUser {

    Connection con = DataSource.getInstance().getConnection();

    Statement ste;

    public int ajouterUser(User r) {
        int test = -1;
        try {
            ste = con.createStatement();
            String query = "INSERT INTO user ("
                    + " login_user, "
                    + " nom_user, "
                    + "prenom_user,"
                    + " date_naissance_user,"
                    + " password_user,"
                    + "tel_user,"
                    + "longitude_user,"
                    + "lattitude_user,"
                    + "is_active_user,"
                    + "is_hotel,"
                    + "is_agency,"
                    + "is_client)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, r.getLogin_user());
            preparedStatement.setString(2, r.getNom_user());
            preparedStatement.setString(3, r.getPrenom_user());
            preparedStatement.setString(4, r.getDate_naissance_user());
            preparedStatement.setString(5, r.getPassword_user());
            preparedStatement.setInt(6, r.getTel_user());
            preparedStatement.setString(7, r.getLongitude_user());
            preparedStatement.setString(8, r.getLattitude_user());
            preparedStatement.setInt(9, r.getIs_active_user());
            preparedStatement.setInt(10, r.getIs_hotel());
            preparedStatement.setInt(11, r.getIs_agency());
            preparedStatement.setInt(12, r.getIs_client());
            int va = preparedStatement.executeUpdate();

            if (va > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    test = generatedKeys.getInt(1);
                    System.out.println(test);
                } else {
                    throw new SQLException("Creating failed, no ID obtained.");
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return test;
    }

    public void modifierUser(User u) {

        try {
            PreparedStatement update = con.prepareStatement("UPDATE user SET nom_user = ?, prenom_user = ?, date_naissance_user = ?, tel_user = ? WHERE id = ?");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public User loginUser(String login, String pass) {
        boolean test = false;
        User resultUser = null;
        try {
            String query = "SELECT  * From user where login_user = ? and password_user = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int numberOfRows = rs.getInt(1);
                System.out.println("numberOfRows= " + numberOfRows);
                if (numberOfRows > 0) {
                    resultUser = new User(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getInt(11),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            rs.getInt(15));

                    return resultUser;

                }
            } else {
                System.out.println("error: could not get the record counts");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultUser;
    }

    public Hotel getHotelData(int userId) {

        Hotel resultUser = null;
        try {
            String query = "SELECT  * From hotel where id_user = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int numberOfRows = rs.getInt(1);
                System.out.println("numberOfRows= " + numberOfRows);
                if (numberOfRows > 0) {
                    resultUser = new Hotel(rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getString(9),
                            rs.getString(10)
                    );

                    return resultUser;

                }
            } else {
                System.out.println("error: could not get the record counts");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultUser;
    }

    public Agence getAgenceData(int userId) {

        Agence resultUser = null;
        try {
            String query = "SELECT  * From agence where id_user = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int numberOfRows = rs.getInt(1);
                System.out.println("numberOfRows= " + numberOfRows);
                if (numberOfRows > 0) {
                    resultUser = new Agence(rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4));

                    return resultUser;

                }
            } else {
                System.out.println("error: could not get the record counts");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultUser;
    }

    public User get(int id) {
        User resultUser = null;
        try {
            String query = "SELECT  * From user where id_user = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int numberOfRows = rs.getInt(1);
                System.out.println("numberOfRows= " + numberOfRows);
                if (numberOfRows > 0) {
                    resultUser = new User(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getInt(11),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            rs.getInt(15));

                    return resultUser;

                }
            } else {
                System.out.println("error: could not get the record counts");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultUser;
    }

}
