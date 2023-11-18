/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adminpackage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author valer
 */
public class AddProduct {
 
private final String UPLOAD_DIRECTORY = "ENTER_YOUR_DIRECTORY_PATH";

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //sesion
        HttpSession session = request.getSession();
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                //Añadir producto
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                String imageName = null;
                String productName = null;
                String productQuantity = null;
                String productPrice = null;
                String descrip = null;
                String mrpPrice = null;
                String status = null;
                String category = null;
                //Codigo unico producto
                String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                StringBuilder salt = new StringBuilder();
                Random rnd = new Random();
                while (salt.length() < 3) { // 
                    int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                    salt.append(SALTCHARS.charAt(index));
                }
                String code = salt.toString();
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        //imagen
                        imageName = new File(item.getName()).getName();
                        //directorio
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + imageName));
                        
                        FileItem pName = (FileItem) multiparts.get(0);
                        productName = pName.getString();
                        FileItem price = (FileItem) multiparts.get(1);
                        productPrice = price.getString();
                        FileItem description = (FileItem) multiparts.get(2);
                        descrip = description.getString();
                        FileItem mprice = (FileItem) multiparts.get(3);
                        mrpPrice = mprice.getString();
                        FileItem fstatus = (FileItem) multiparts.get(4);
                        status = fstatus.getString();
                        FileItem pcategory = (FileItem) multiparts.get(5);
                        category = pcategory.getString();
                    }
                }
                try {
                    int id = 0;
                    String imagePath = UPLOAD_DIRECTORY + imageName;
                    //Querying to insert product in the table
                    int i = DatabaseConnection.insertUpdateFromSqlQuery("insert into tbl_product(id,active,code,description,image,image_name,name,price,mrp_price,product_category) values('" + id + "','" + status + "','" + code + "','" + descrip + "','" + imagePath + "','" + imageName + "','" + productName + "','" + productPrice + "','" + mrpPrice + "','" + category + "')");
                    //If product inserted successfully in the database
                    if (i > 0) {
                        String success = "Product added successfully.";
                        //method
                        session.setAttribute("message", success);
                        //respuesta
                        response.sendRedirect("admin-add-product.jsp");
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception ex) {
                //If error
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
        try {
                    int id = 0;
                    String imagePath = UPLOAD_DIRECTORY + imageName;
                    //Querying to delete product in the table
                    int i = DatabaseConnection.deleteUpdateFromSqlQuery("delete from tbl_product(id,active,code,description,image,image_name,name,price,mrp_price,product_category) values('" + id + "','" + status + "','" + code + "','" + descrip + "','" + imagePath + "','" + imageName + "','" + productName + "','" + productPrice + "','" + mrpPrice + "','" + category + "')");
                    //If product deleted successfully in the database
                    if (i > 0) {
                        String success = "Product deleted successfully.";
                        //method
                        session.setAttribute("message", success);
                        //respuesta
                        response.sendRedirect("admin-delete-product.jsp");
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception ex) {
                //If error
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
        }
    }
}
    
