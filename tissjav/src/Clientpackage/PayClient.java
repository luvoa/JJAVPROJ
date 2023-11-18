/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientpackage;
import java.net.MalformedURLException; 
import java.net.URL; 
 
import com.mypos.myposcheckout.ipc.Config; 
import com.mypos.myposcheckout.ipc.IPCException;
/**
 *
 * @author valer
 */
public class PayClient {

onfig cnf = new Config(); 
 
 
try { 
    ipcApiUrl = new URL("https://mypos.com/vmp/checkout-test/"); 
} catch (MalformedURLException ex) { 
    // Handle the malformed URL exception 
} 
 
cnf.setIpcUrl(ipcApiUrl); 
cnf.setLang("en"); 
cnf.loadPrivateKeyFromFile("path_to_directory/storePrivateKey.pem"); // Replace `path_to_directory` with the actual file path 
cnf.loadPublicKeyFromFile("path_to_directory/apiPublicKey.pem"); // Replace `path_to_directory` with the actual file path 
cnf.setKeyIndex(1); 
cnf.setSid(""); 
cnf.setVersion(""); 
cnf.setWalletNumber("");

try { 
    ipcApiUrl = new URL("https://mypos.com/vmp/checkout-test/"); 
} catch (MalformedURLException ex) { 
    // Handle the malformed URL exception 
} 
 
cnf.setIpcUrl(ipcApiUrl); 
cnf.setLang("en"); 
cnf.loadPrivateKeyFromFile("path_to_directory/storePrivateKey.pem"); // Replace `path_to_directory` with the actual file path 
cnf.loadPublicKeyFromFile("path_to_directory/apiPublicKey.pem"); // Replace `path_to_directory` with the actual file path 
cnf.setKeyIndex(1); 
cnf.setSid(""); 
cnf.setVersion(""); 
cnf.setWalletNumber("");

}
    


