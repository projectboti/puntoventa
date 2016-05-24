/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sase.Control;

import java.sql.*;
import sase.Connection.Connection;

/**
 *
 * @author VAIO
 */
public class methods {
    private Connection con = new Connection();
    private java.sql.Connection cn = con.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

   public int Login(String contraseña){
       int ret = 0;
       try{
        this.ps = cn.prepareStatement("exec sp_login ?");
        this.ps.setString(1, contraseña);
        rs = ps.executeQuery();
        if(rs.next()){
            ret = Integer.parseInt(rs.getString(1));
        }
       }catch(Exception e){
           ret = 0;
           System.out.println(e.getMessage());
       }
     return ret;
    }     
}
