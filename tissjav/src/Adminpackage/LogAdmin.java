/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adminpackage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author valer
 */
public class LogAdmin {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //parametros
            String email = request.getParameter("email");
            String pass = request.getParameter("upass");
            //sesion
            HttpSession hs = request.getSession();
            //method
            Connection con = DatabaseConnection.getConnection();
            //Statement
            Statement st = con.createStatement();
            //database
            ResultSet resultset = st.executeQuery("select * from tbla_dmin where email='" + email + "' AND password='" + pass + "'");
            //if correcto
            if (resultset.next()) {
                hs.setAttribute("uname", resultset.getString("name"));
                //Redirect admin
                response.sendRedirect("dashboard.jsp");
            } else {
                //If incorrecto
                String message = "You have enter wrong credentials";
                hs.setAttribute("credential", message);
                //Redirect admin
                response.sendRedirect("admin-login.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
    
