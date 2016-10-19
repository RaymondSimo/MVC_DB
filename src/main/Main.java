
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
        
        ViewMain viewMain = new ViewMain();
        ModelMain modelMain = new ModelMain();
        ControllerMain controllerMain = new ControllerMain(viewMain, viewClientes, modelMain);
     }
}
    

