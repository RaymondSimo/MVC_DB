
package main;
import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author Raymond SIMOLY
 */
public class Main {
    public static void main(String[]ray){  
ViewClientes viewClientes = new ViewClientes();
        ModelClientes modelClientes = new ModelClientes();
        ControllerClientes controllerClientes = new ControllerClientes(viewClientes, modelClientes);
        
        View_provedores view_provedores=new View_provedores();
        ModelProvedores modelProvedores = new ModelProvedores();
        ControllerProvedores controllerProvedores= new ControllerProvedores(view_provedores, modelProvedores);
        
        View_productos view_productos=new View_productos();
        ModelProductos modelProductos = new ModelProductos();
        ControllerProductos controllerProductos= new ControllerProductos(view_productos, modelProductos);
        
       ViewUsuarios viewUsuarios = new ViewUsuarios();
       Model_users model_users= new Model_users();
       Controller_users controller_users= new Controller_users(viewUsuarios,model_users);
       
       ViewRegist_users viewRegist_users=new ViewRegist_users();
       ModelRegist_users modelRegist_users=new  ModelRegist_users();
       ControllerRegist_users controllerRegist_users= new ControllerRegist_users(viewRegist_users, modelRegist_users);
        
        ViewMain viewMain = new ViewMain();
        ModelMain modelMain = new ModelMain();
        ControllerMain controllerMain = new ControllerMain(viewMain, viewClientes, view_provedores, view_productos, viewUsuarios, viewRegist_users, modelMain);
     }
}
    

