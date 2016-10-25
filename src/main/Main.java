
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
        
        view_provedores view_provedores=new view_provedores();
        ModelProvedores modelProvedores = new ModelProvedores();
        //ControllerProvedores controllerProvedores= new ControllerProvedores(view_provedores, modelProvedores);
        
        View_productos view_productos=new View_productos();
        ModelProductos modelProductos = new ModelProductos();
        ControllerProductos controllerProductos= new ControllerProductos(view_productos, modelProductos);
        
        ViewMain viewMain = new ViewMain();
        ModelMain modelMain = new ModelMain();
        ControllerMain controllerMain = new ControllerMain(viewMain, viewClientes, view_provedores, view_productos, modelMain);
     }
}
    

