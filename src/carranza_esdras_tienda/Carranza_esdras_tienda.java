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
        Scanner info = new Scanner(System.in);

        info.useDelimiter("\n");

        System.out.println("Sea bienvenido, al cajero virtual de tienda Esdras Store");
        System.out.println("A continuacion se le mostraran las secciones con las cuales usted puede interactuar" + "\n" + "En cada una se le dara una intrucciones para utlizarlas");

        int opcion = 0, producto = 0, tipo_clien = 0, opcion_produc = 0, cont_compra = 0, comprar_igual = 0;
        double cant_efectivo = 0, kilos_pro = 0, total_com = 0, cant_azucar = 0, cant_avena = 0, cant_trigo = 0, cant_maiz = 0, kilos_ven = 0, total_venta = 0;
        int opcion_pro = 0;

        while (opcion != 6) {
            System.out.println("1.Abrir Caja" + "\n" + "2.Ventas" + "\n" + "3.Compras" + "\n" + "4.Reportes" + "\n" + "5.Cierre de caja" + "\n" + "6.Salir del sistema");
            opcion = info.nextInt();

            if (opcion > 6 || opcion < 1) {
                System.out.println("Error. Opcion no existente");
            } else if (opcion == 1) {
                System.out.println("En este seccion, ingrese la cantidad de efectivo que usted dispone, esta misma cambiara cuando se realizen compras o ventas.");
                System.out.println("ingrese la cantidad de efectivo con la que dispone ");
                cant_efectivo = info.nextDouble();

            } else if (opcion == 3) {
                System.out.println("Bienvenido a la seccion de compras, en este seccion se provee una cantidad de productos, para suplir la seccion de ventas.");
                System.out.println("Las siguientes son opciones de productos  a nuestro proveedores, dependiendo  del tipo de proveedor, usted podra comprar los siguientes productos");
                System.out.println("      Codigo      " + "        Producto        " + "        Precio Compra        "
                        + "\n" + "        1        " + "          Azucar        " + "            Lps.25        "
                        + "\n" + "        2        " + "          Avena         " + "        Lps.B(20) C(22)   "
                        + "\n" + "        3        " + "          Trigo         " + "            Lps.30        "
                        + "\n" + "        4        " + "          Maiz          " + "            Lps.20        ");
                System.out.println("Si selecciona el proveedor A solo podra proveer el producto con codigo 1 y 4" + "\n" + "Si selecciona el proveedor B solo podra proveer el producto con codigo 2 y 3"
                        + "\n" + "Si selecciona el  proveedor C solo podra proveer el producto con codigo 2");

                System.out.println("seleccione el tipo de proveedor que desea");
                System.out.println("1. Tipo A" + "\n" + "2.Tipo B" + "\n" + "3.Tipo C");
                opcion_pro = info.nextInt();
                if (opcion_pro > 3 || opcion_pro < 1) {
                    System.out.println("Error. Proveedor no existente");
                } else if (opcion_pro == 1) {
                    System.out.println("El  proveedor que usted a seleccionado es el A");
                    System.out.println("Ingrese el codigo del producto requerido ");
                    producto = info.nextInt();

                    if (producto == 1) {
                        System.out.println("El producto que usted selecciono es Azucar");
                        System.out.println("Ingrese los kilos que necesite");
                        kilos_pro = info.nextDouble();

                        total_com = kilos_pro * 25;

                        if (total_com > cant_efectivo) {
                            System.out.println("No Se Puede Pagar Compra");
                        } else if (total_com < cant_efectivo) {
                            cant_efectivo = cant_efectivo - total_com;
                            System.out.println("El total de su compra es " + total_com);

                            cant_azucar = cant_azucar + kilos_pro;
                        }

                    } else if (producto == 4) {
                        System.out.println("El producto que usted selecciono es Maiz");
                        System.out.println("Ingrese los kilos que necesite");
                        kilos_pro = info.nextDouble();

                        total_com = kilos_pro * 20;

                        if (total_com > cant_efectivo) {
                            System.out.println("No Se Puede Pagar Compra");
                        } else if (total_com < cant_efectivo) {
                            cant_efectivo = cant_efectivo - total_com;
                            System.out.println("El total de su compra es " + total_com);
                            cant_maiz = cant_maiz + kilos_pro;
                        }

                    } else {
                        System.out.println("Error.Proveedor no vende dicho Producto");
                    }

                } else if (opcion_pro == 2) {
                    System.out.println("El  proveedor que usted a seleccionado es el B");
                    System.out.println("Ingrese el codigo del producto requerido ");
                    producto = info.nextInt();

                    if (producto == 2) {
                        System.out.println("El producto que usted selecciono es Avena");
                        System.out.println("Ingrese los kilos que necesite");
                        kilos_pro = info.nextDouble();

                        total_com = kilos_pro * 20;

                        if (total_com > cant_efectivo) {
                            System.out.println("No Se Puede Pagar Compra");
                        } else if (total_com < cant_efectivo) {
                            cant_efectivo = cant_efectivo - total_com;
                            System.out.println("El total de su compra es " + total_com);
                            cant_avena = cant_avena + kilos_pro;
                        }

                    } else if (producto == 3) {
                        System.out.println("El producto que usted selecciono es Trigo");
                        System.out.println("Ingrese los kilos que necesite");
                        kilos_pro = info.nextDouble();

                        total_com = kilos_pro * 30;

                        if (total_com > cant_efectivo) {
                            System.out.println("No Se Puede Pagar Compra");
                        } else if (total_com < cant_efectivo) {
                            cant_efectivo = cant_efectivo - total_com;
                            System.out.println("El total de su compra es " + total_com);
                            cant_trigo = cant_trigo + kilos_pro;
                        }

                    } else {
                        System.out.println("Error.Proveedor no vende dicho Producto");
                    }

                } else if (opcion_pro == 3) {
                    System.out.println("El  proveedor que usted a seleccionado es el B");
                    System.out.println("Ingrese el codigo del producto requerido ");
                    producto = info.nextInt();

                    if (producto == 2) {
                        System.out.println("El producto que usted selecciono es Avena");
                        System.out.println("Ingrese los kilos que necesite");
                        kilos_pro = info.nextDouble();

                        total_com = kilos_pro * 22;

                        if (total_com > cant_efectivo) {
                            System.out.println("No Se Puede Pagar Compra");
                        } else if (total_com < cant_efectivo) {
                            cant_efectivo = cant_efectivo - total_com;
                            System.out.println("El total de su compra es " + total_com);
                            cant_avena = cant_avena + kilos_pro;
                        } else {
                            System.out.println("Error.Proveedor no vende dicho Producto");
                        }

                    }

                }

            } else if (opcion == 2) {
                System.out.println("Bienvenido a la seccion de ventas");
                System.out.println("En este seccion se vende una cantidad de productos, para suplir las  necesidades del cliente.");
                System.out.println("Las siguientes son opciones de nuestro tipo de clientes, dependiendo  del tipo de cliente, usted podra comprar los siguientes productos");
                System.out.println("      Codigo      " + "        Producto        " + "        Precio Compra        "
                        + "\n" + "        1        " + "          Azucar        " + "            Lps.30        "
                        + "\n" + "        2        " + "          Avena         " + "            Lps.25          "
                        + "\n" + "        3        " + "          Trigo         " + "            Lps.32        "
                        + "\n" + "        4        " + "          Maiz          " + "            Lps.20        ");
                System.out.println("Si selecciona el cliente A podra comprar todo tipo de productos" + "\n" + "Si selecciona el Cliente B solo podra comprar productos con el codigo 1,2 y 3"
                        + "\n" + "Si selecciona el  proveedor C solo podra comprar el producto con codigo 8");

                System.out.println("seleccione el tipo de cliente que es ");
                System.out.println("1. Tipo A" + "\n" + "2.Tipo B" + "\n" + "3.Tipo C ");
                System.out.println("(use los numero especificos de cada tipo)");
                tipo_clien = info.nextInt();
                while (tipo_clien != 1 && tipo_clien != 2 && tipo_clien != 3) {
                    System.out.println("Error. TIPO DE CLIENTE NO EXISTE");
                    tipo_clien = info.nextInt();
                }

                if (tipo_clien == 1) {
                    System.out.println("Usted a seleccionado el tipo A de clientes");

                    while (cont_compra != 2) {
                        System.out.println("Ingrese el codigo del producto que necesite");
                        opcion_produc = info.nextInt();
                        if (opcion_produc == 1) {
                            System.out.println("El producto que selecciono es Azucar, el costo de estes de 30 lps");
                            if (cant_azucar < 1) {
                                System.out.println("No tenemos el producto solicitado");
                            }

                            System.out.println("ingrese los kilos que requiere ");
                            kilos_ven = info.nextDouble();
                            if (kilos_ven > cant_azucar) {
                                System.out.println("Unicamente contamos con " + cant_azucar + " kilos de azucar");
                                System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                comprar_igual = info.nextInt();

                                if (comprar_igual == 1) {
                                    total_venta = kilos_ven * 30;
                                    cant_azucar = cant_azucar - kilos_ven;
                                    cant_efectivo = cant_efectivo + total_venta;
                                    System.out.println("Compra realizada");
                                    System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                    cont_compra = info.nextInt();

                                } else if (comprar_igual == 2) {
                                    System.out.println("compra no realizada");
                                } else {
                                    System.out.println("Error.Respuesta no existente");
                                }

                            } else {
                                total_venta = kilos_ven * 30;
                                System.out.println("Compra realizada");
                                cant_azucar = cant_azucar - kilos_ven;
                                cant_efectivo = cant_efectivo + total_venta;
                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                cont_compra = info.nextInt();

                            }

                        }
                    }
                    
                    if(cont_compra == 2){
                        System.out.println("xd");
                    }

                }
            }

        }

    }

}
