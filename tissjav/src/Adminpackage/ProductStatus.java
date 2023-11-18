/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adminpackage;

import java.io.IOException;
import java.sql.ResultSet;
/**
 *
 * @author valer
 */
public class ProductStatus {
 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int statusMode = 0;
            //
            ResultSet rs = DatabaseConnection.getResultFromSqlQuery("select order_status from tbl_orders where order_no='" + request.getParameter("orderId") + "'");
            while (rs.next()) {
                if (rs.getString(1).equals("Deliver")) {
                    statusMode = DatabaseConnection.insertUpdateFromSqlQuery("update tbl_orders set order_status='Pending' where order_no='" + request.getParameter("orderId") + "'");
                } else {
                    statusMode = DatabaseConnection.insertUpdateFromSqlQuery("update tbl_orders set order_status='Deliver' where order_no='" + request.getParameter("orderId") + "'");
                }
            }
            if (statusMode > 0) {
                //
                response.sendRedirect("admin-all-orders.jsp");
            } else {
                //
                response.sendRedirect("admin-all-orders.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}    
    
