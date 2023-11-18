/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientpackage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import com.connection.DatabaseConnection;
@WebServlet("/AddProductCartClient")
/**
 *
 * @author valer
 */
public class AddProductCartClient extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 0;
        //parametros
        int productId = Integer.parseInt(request.getParameter("productId"));
        String price = request.getParameter("price");
        String mrp_price = request.getParameter("mrp_price");
        HttpSession hs = request.getSession();
        try {
            //log
            if ((String) hs.getAttribute("name") == null) {
                response.sendRedirect("customer-login.jsp");
                //database
            } else {
                int customerId = (int) hs.getAttribute("id");
                //
                int addToCart = DatabaseConnection.insertUpdateFromSqlQuery("insert into tblcart values('" + id + "','" + price + "',1,'" + price + "','" + customerId + "','" + productId + "','" + mrp_price + "')");
                if (addToCart > 0) {
                    response.sendRedirect("index.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
   
