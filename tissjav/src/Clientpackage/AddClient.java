/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientpackage;
import java.io.IOException;
/**
 *
 * @author valer
 */
public class AddClient {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String pincode = request.getParameter("pincode");
        
        //sesion
        HttpSession hs = request.getSession();
        
        //database
        try {
            //database
            int addCustomer = DatabaseConnection.insertUpdateFromSqlQuery("insert into tbl_client(address,email,gender,name,password,phone,pin_code)values('" + address + "','" + email + "','" + gender + "','" + name + "','" + password + "','"
                    + mobile + "','" + pincode + "')");
            
            //registro exitoso
            if (addCustomer > 0) {
                String message = "Customer register successfully.";
                //mensaje
                hs.setAttribute("success-message", message);
                //respuesta
                response.sendRedirect("customer-register.jsp");
            } else {
                 //falla
                String message = "Customer registration fail";
                //mensaje
                hs.setAttribute("fail-message", message);
                //respuesta user/client
                response.sendRedirect("customer-register.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
    
