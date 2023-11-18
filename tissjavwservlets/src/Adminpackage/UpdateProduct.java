/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adminpackage;
import com.connection.DatabaseConnection;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse
        @WebServlet("/UpdateProduct")
/**
 *
 * @author valer
 */
 public class UpdateProduct extends HttpServlet{
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //datos
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        String discount_price = null;
        Double productPrice = 0.0;
        try {
            //database
            ResultSet rs = DatabaseConnection.getResultFromSqlQuery("select discount_price from tbl_cart where customer_id='" + session.getAttribute("id") + "' and product_id='" + productId + "'");
            while (rs.next()) {
                //obtenerdata
                discount_price = rs.getString("discount_price");
                //
                productPrice = Double.parseDouble(discount_price);
            }
            productPrice = productPrice * quantity;
            //Update
            int updateQuantity = DatabaseConnection.insertUpdateFromSqlQuery("update tblcart set quantity='" + quantity + "',total_price='" + productPrice + "' where customer_id='" + session.getAttribute("id") + "' and product_id='" + productId + "' ");
            //
            if (updateQuantity > 0) {
                //
                response.sendRedirect("checkout.jsp");
                //
            } else {
                 //
                response.sendRedirect("checkout.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   
}
