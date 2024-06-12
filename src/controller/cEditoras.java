/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mEditoras;

/**
 *
 * @author rafael.tolomeotti
 */
public class cEditoras {

    public void cadastrar(mEditoras modelE) {
        Connection conn = mysql.conexão();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO editoras (nome) VALUES (?)");
            stmt.setString(1, modelE.getNome());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editora Cadastrada");

        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<mEditoras> listar() {

        Connection conn = mysql.conexão();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mEditoras> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM editoras");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mEditoras modelE = new mEditoras();
                modelE.setId_editora(rs.getInt("id_editora"));
                modelE.setNome(rs.getString("nome"));

                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public List<mEditoras> pesquisar(String texto, int filtro) {

        Connection conn = mysql.conexão();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mEditoras> lista = new ArrayList<>();

        try {
            if (filtro == 0) {
                stmt = conn.prepareStatement("SELECT * FROM editoras WHERE id_editora = ?");
                stmt.setString(1, texto);
                rs = stmt.executeQuery();
            } else {
                stmt = conn.prepareStatement("SELECT * FROM editoras WHERE nome LIKE ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            while (rs.next()) {
                mEditoras modelE = new mEditoras();
                modelE.setId_editora(rs.getInt("id_editora"));
                modelE.setNome(rs.getString("nome"));

                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public void alterar(mEditoras modelE) {
        Connection conn = mysql.conexão();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE  editoras SET nome = ? WHERE id_editora = ? ");
            stmt.setString(1, modelE.getNome());
            stmt.setInt(2, modelE.getId_editora());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editora Alterada");

        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(mEditoras modelE) {
        Connection conn = mysql.conexão();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM editoras WHERE id_editora = ?");
            stmt.setInt(1, modelE.getId_editora());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editora Deletada");

        } catch (SQLException ex) {
            Logger.getLogger(cEditoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
