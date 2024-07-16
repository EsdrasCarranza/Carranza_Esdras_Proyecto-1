/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carranza_esdras_tienda;
import java.util.Scanner;

/**
 *
 * @author 50488
 */
public class Carranza_esdras_tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner info = new Scanner (System.in);
        
        info.useDelimiter("\n");
        
        System.out.println("Sea bienvenido, al cajero virtual de tienda Esdras Store");
        System.out.println("A continuacion se le mostraran las secciones con las cuales usted puede interactuar" + "\n" + "En cada una se le dara una intrucciones para utlizarlas");
        
        int opcion = 0;
        double cant_efectivo = 0;
        while (opcion != 6){
            System.out.println("1.Abrir Caja" + "\n" + "2.Compras" + "\n" + "3.Ventas" + "\n" + "4.Reportes" + "\n" + "5.Cierre de caja" + "\n" + "6.Salir del sistema");
            opcion = info.nextInt();
            
            if(opcion > 6 || opcion < 1){
                System.out.println("Error. Opcion no existente");
            }else if(opcion == 1){
                System.out.println("En este seccion, ingrese la cantidad de efectivo que usted dispone, esta misma cambiara cuando se realizen compras o ventas.");
                System.out.println("ingrese la cantidad de efectivo con la que dispone ");
                cant_efectivo = info.nextDouble();
                
            }else if (opcion == 2){
                System.out.println("Bienvenido a la seccion de compras, en este seccion se compra una cantidad de productos, para suplir la seccion de ventas.");
                System.out.println("Primero seleccione el tipo de proveedor que desea");
                System.out.println("los productos disponibles para la compra son los siguientes");
                System.out.println("      Codigo      " + "        Producto        " + "        Precio Compra        " +
                        "\n" + "        1        " + "        Azucar        " + "       Lps.25        ");
                
            }
                
        }
        
    }
    
}

