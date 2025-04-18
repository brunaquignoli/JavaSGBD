/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasgbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruna
 */
public class Produto {

    private int id;
    private String descricao;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void cadastrar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("insert into produto(descricao, preco) values(?,?)");
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.execute();
        con.close();
    }

    public void deletar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("Delete from produto where id = ?");
        comando.setInt(1, id);
        comando.execute();
        con.close();
    }

    public void atualizar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("update produto set descricao = ?, preco = ? where id = ?");
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.setInt(3, id);
        comando.execute();
        con.close();
    }

    public ArrayList<Produto> listar() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("Select * from produto");
        ResultSet resultado = comando.executeQuery();

        ArrayList<Produto> lista = new ArrayList<>();
        while (resultado.next()) {
            Produto p = new Produto();
            p.setId(resultado.getInt("id"));
            p.setDescricao(resultado.getString("descricao"));
            p.setPreco(resultado.getDouble("preco"));
            lista.add(p);
        }

        resultado.close();
        comando.close();
        con.close();
        return lista;
    }

    public Connection getConexao() throws ClassNotFoundException, SQLException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/aula_ioo";
        String USER = "root";
        String PASSWORD = "";
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
