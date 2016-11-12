
package main;
import models.*;
import views.*;
import controllers.*;
import javax.swing.JPanel;

/**
 *
 * @author Raymond SIMOLY
 */
public class Main {
    private static ViewMain viewMain;
    private static ModelMain modelMain;
    private static ControllerMain controllerMain;
    
    private static ViewClientes viewClientes;
    private static ModelClientes modelClientes;
    private static ControllerClientes controllerClientes;
    
    private static ViewRegist_users viewRegist_users;
    private static ModelRegist_users modelRegist_users;
    private static ControllerRegist_users controllerRegist_users;
    
    private static ViewUsuarios viewUsuarios;
    private static Model_users model_users;
    private static Controller_users controller_users;
    
    private static View_productos view_productos;
    private static ModelProductos modelProductos;
    private static ControllerProductos controllerProductos;
    
    private static View_provedores view_provedores;
    private static ModelProvedores modelProvedores;
    private static ControllerProvedores controllerProvedores;
    
    private static ViewCompras viewCompras;
    private static ModelCompras modelCompras;
    private static ControllerCompras controllerCompras;
    
    public static void main(String[]ray){  
        
        viewClientes = new ViewClientes();
        modelClientes = new ModelClientes();
        controllerClientes = new ControllerClientes(viewClientes, modelClientes);
        
         view_provedores=new View_provedores();
         modelProvedores = new ModelProvedores();
         controllerProvedores= new ControllerProvedores(view_provedores, modelProvedores);
        
         view_productos=new View_productos();
         modelProductos = new ModelProductos();
         controllerProductos= new ControllerProductos(view_productos, modelProductos);
        
         viewMain = new ViewMain();
       viewUsuarios = new ViewUsuarios();
       model_users= new Model_users();
       controller_users= new Controller_users(viewUsuarios,model_users,viewMain);
       
        viewRegist_users=new ViewRegist_users();
       modelRegist_users=new  ModelRegist_users();
       controllerRegist_users= new ControllerRegist_users(viewRegist_users, modelRegist_users);
       
        viewCompras = new ViewCompras();
        modelCompras=new ModelCompras();
        controllerCompras= new ControllerCompras(viewCompras, modelCompras);
        
         JPanel views[]=new JPanel[6];
         views[0]=viewUsuarios;
         views[1]=viewRegist_users;
         views[2]=viewClientes;
         views[3]=view_productos;
         views[4]=view_provedores;
         views[5]=viewCompras;
         
         
      //viewMain = new ViewMain();
       modelMain = new ModelMain();
       controllerMain = new ControllerMain(viewMain,modelMain,views);
     }
}
    

