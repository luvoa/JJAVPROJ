/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientpackage;
import java.io.IOException;
import java.sql.ResultSet;
/**
 *
 * @author valer
 */
public class LogClient {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //datos user/client
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //sesion
        HttpSession hs = request.getSession();
        try {
            //Resultset
            ResultSet resultset = null;
            //log detalles
            resultset = DatabaseConnection.getResultFromSqlQuery("select * from tbl_client where email='" + email + "' and password='" + password + "'");
            //Check if user vacio o no
            if (email != null && password != null) {
                if (resultset.next()) {
                    //consulta user
                    hs.setAttribute("id", resultset.getInt("id"));
                    hs.setAttribute("name", resultset.getString("name"));
                    //respuesta
                    response.sendRedirect("index.jsp");
                } else {
                    //consulta datos erroneos
                    String message = "You have enter wrong credentials";
                    hs.setAttribute("credential", message);
                    //Redirect respuesta
                    response.sendRedirect("customer-login.jsp");
                }
            } else {
                //If username or password is vacia
                String message = "User name or Password is null";
                hs.setAttribute("credential", message);
                //Redirect respuesta
                response.sendRedirect("customer-login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
            
