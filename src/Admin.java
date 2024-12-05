

import java.io.*;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Admin implements Serializable{
  protected static String setedUsername = "John";
  protected static String setedPassword = "456456";
  public String getPassword(){
    return setedPassword;
  }
  public void setPass(String newPass){
    setedPassword = newPass;
    System.out.println("pass changed");
  }
}
class Acount implements Serializable{
  Admin admin = new Admin();
  public void changePassword(String newPass){
    //Admin admin = new Admin();
    admin.setPass(newPass);
    System.out.println( admin.getPassword());
    saveAcountInfo();
    loadSavedAcountInfo();
  }
  public void saveAcountInfo(){
    try{
      FileOutputStream fileout = new FileOutputStream("D:\\NetBeansProjects\\Jtable\\adminAcountInfo.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileout);
      out.writeObject(admin);
      out.close();
      fileout.close();
      System.out.println("Acount info saved");
    }catch(IOException e){
      System.out.println("something went wrong...");
      System.out.println(e);
    }
  }
  public void loadSavedAcountInfo(){
    //Admin admin = null;
    try{
      FileInputStream filein = new FileInputStream("D:\\NetBeansProjects\\Jtable\\adminAcountInfo.ser");
      ObjectInputStream in = new ObjectInputStream(filein);
      admin = (Admin) in.readObject();
      in.close();
      filein.close();
      System.out.println( admin.getPassword());
      System.out.println("Acount info loaded");
    }catch(IOException e){
      System.out.println("something went wrong... loading data");
      System.out.println(e);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Acount.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
