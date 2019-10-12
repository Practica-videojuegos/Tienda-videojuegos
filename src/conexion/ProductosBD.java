/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import formularios.Productos;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS ROG
 */
public class ProductosBD {
    public ArrayList<Productos> ListaProductos () {
        
            ArrayList <Productos> Productos = new ArrayList();
            try{
            // Connection cnx = (Connection) ConexionBD.getConection();
            // TODO add your handling code here:
            String url = "jdbc:mysql://geoconstructor.com:3306/geoconst_Practica5";
            String usuario = "geoconst";
            String passw= "##Geo##2018";
            String sql = "SELECT id,Nombre,Precio,Cantidad,id_Categoria FROM Producto ";
            Connection cn= (Connection) DriverManager.getConnection(url, usuario, passw);
            
            Statement ps = (Statement) cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            
                while (rs.next()){
            
            Productos prod= new Productos ();
            prod.setId(rs.getString("id"));    
            prod.setNombre(rs.getString("Nombre"));
            prod.setPrecio(rs.getString("Precio"));
            prod.setCantidad(rs.getString("Cantidad"));
            prod.setId_Categoria(rs.getString("id_Categoria"));
            
            Productos.add(prod);
                }

            
        
        } catch (SQLException ex) {
            Logger.getLogger(ProductosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Productos;
            
        
        }
    
}
