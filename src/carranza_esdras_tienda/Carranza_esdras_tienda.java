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
        System.out.println("A continuacion se le mostraran las secciones con las cuales usted puede interactuar" + "\n" + "En cada una se le dara intrucciones para utilizarlas");

        //Aqui estan todas las variables que se utilizan a lo largo del codigo.
        double primero = 0, segundo = 0, tercero = 0, cuarto = 0;
        String prod_primero = "", prod_segundo = "", prod_tercero = "", prod_cuarto = "";
        int opcion = 0, producto = 0, tipo_clien = 0, opcion_produc = 0, cont_compra = 0, comprar_igual = 0, cant_ventas = 0, cant_compras = 0;
        String nom_producto = "", nombre_mayorcom = "",
                nombre_mayorventa = "", producto_estrella = " ", factura = " ";
        double cant_efectivo = 0, kilos_pro = 0, total_com = 0, cant_azucar = 0, cant_avena = 0, cant_trigo = 0, cant_maiz = 0, kilos_ven = 0, subtotal_venta = 0, descuento = 0,
                impuesto = 0, total_venta = 0, ganacias = 0, total_compras = 0, total_ventas = 0, mayor_compra = 0, kilos_mayorcompra = 0, mayor_venta = 0, kilos_mayorventa = 0,
                kilos_maiz = 0, kilos_trigo = 0, kilos_azucar = 0, kilos_avena = 0, kilos_mayor = 0, subtotal_total = 0, descuento_visual = 0,
                promedio_ventas = 0, promedio_compras = 0, volumen_compras = 0, volumen_ventas = 0;
        int opcion_pro = 0, caja_abierta = 0;
        //inicio del bucle del menu principal
        while (opcion != 6) {
            // validamos una variabe en 0 para el funcionamiento de otra opcion.
            cont_compra = 0;
            // se muestra las opciones disponibles
            System.out.println("1.Abrir Caja" + "\n" + "2.Ventas" + "\n" + "3.Compras" + "\n" + "4.Reportes" + "\n" + "5.Cierre de caja" + "\n" + "6.Salir del sistema");
            opcion = info.nextInt();
            //posibles errores al usar el menu
            if (opcion > 6 || opcion < 1) {
                System.out.println("Error. Opcion no existente");
                //apertura de la primera opcion abrir caja 
            } else if (opcion == 1) {
                if (caja_abierta == 0) {
                    //intrucciones
                    System.out.println("En este seccion, ingrese la cantidad de efectivo que usted dispone, esta misma cambiara cuando se realizen compras o ventas.");
                    System.out.println("ingrese la cantidad de efectivo con la que dispone: ");
                    cant_efectivo = info.nextDouble();
                    //error por si el usuario ingresa dinero negativo 
                    if (cant_efectivo <= 0) {
                        System.out.println(" ");
                        System.out.println("ERROR. su cantidad de efectivo no puede ser 0 o ser negativa");
                        System.out.println(" ");

                    } else {
                        //se muestra el saldo que hay en la caja 
                        System.out.println(" ");
                        System.out.println("El saldo ingresado es de: " + cant_efectivo);
                        System.out.println(" ");
                        caja_abierta = 1;
                    }

                } else if (caja_abierta > 0) {
                    // por si se desea ingresar mas efectivo una vez la caja este abierta
                    System.out.println("Su saldo actual es de : " + cant_efectivo);
                    System.out.println("desea ingresar mas dinero a la cuenta, ingrese cuanto dinero va  adicionar: ");
                    int extra_dinero = info.nextInt();
                    // otro error por si al caso ingresa otro valor en 0 
                    if (extra_dinero < 0) {

                        System.out.println("ERROR. no se puede ingresar una cantidad menor a 0");
                    } else {
                        //caja actualizada con dinero 
                        cant_efectivo += extra_dinero;
                        System.out.println(" ");
                        System.out.println("Cantidad de caja actualizada");
                        System.out.println("Su nuevo capital es de: " + cant_efectivo);
                        System.out.println(" ");
                    }

                }

            } else if (opcion == 3) {
                //mensaje por si se desea abrir compras antes de abrir caja 
                if (caja_abierta == 0) {
                    System.out.println("Abrir caja antes de ingresar a compras");
                } else {
                    //menu principal y solicitud de producto 
                    System.out.println(" ");
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
                    System.out.println("1.Tipo A" + "\n" + "2.Tipo B" + "\n" + "3.Tipo C");
                    System.out.println(" ");
                    opcion_pro = info.nextInt();
                    // error por si se ingresa un tipo de proveedor incorrecto
                    if (opcion_pro > 3 || opcion_pro < 1) {
                        System.out.println("Error. Proveedor no existente");
                    } else if (opcion_pro == 1) {
                        System.out.println(" ");

                        System.out.println("El  proveedor que usted a seleccionado es el A");
                        System.out.println("Ingrese el codigo del producto requerido (en todo caso de no querer realizar la compra presionar 0)");
                        producto = info.nextInt();
                        // validacion por si se quiere cancelar la compra
                        if (producto == 0) {
                            System.out.println("----COMPRA CANCELADA----");
                        } else if (producto == 1) {

                            nom_producto = "Azucar";
                            System.out.println(" ");

                            System.out.println("El producto que usted selecciono es Azucar");
                            System.out.println("Ingrese los kilos que necesite(en todo caso de no querer realizar la compra presionar 0).");
                            kilos_pro = info.nextDouble();
                            //error por si los kilos de producto es 0 o menor a 0 
                            if (kilos_pro < 0) {
                                System.out.println("Error. NO SE PUEDE COMPRAR PRODUCTOS NEGATIVOS");
                                //otro por si al caso 
                            } else if (kilos_pro == 0) {
                                System.out.println("----COMPRA CANCELADA----");

                            } else {
                                total_com = kilos_pro * 25;
                                // validacion por si al caso no se puede pagar 
                                if (total_com > cant_efectivo) {

                                    System.out.println(" ");
                                    System.out.println("No Se Puede Pagar Compra");
                                    System.out.println("el total de su compra es: " + total_com);
                                    System.out.println("Unicamente cuenta con : " + cant_efectivo);
                                    double cant_efectivo_calculo = cant_efectivo;
                                    double posible_compra = total_com - cant_efectivo_calculo;
                                    System.out.println("Para completar esa compra le hacen falta : " + posible_compra + " Lempiras.");
                                    System.out.println(" ");
                                    // validacion por si si se puede pagar 
                                } else if (total_com < cant_efectivo) {
                                    cant_efectivo = cant_efectivo - total_com;
                                    System.out.println(" ");
                                    System.out.println("Compra efectuada");
                                    System.out.println("se han comprado " + kilos_pro + " kilogramos de " + nom_producto);
                                    System.out.println("El total de su compra es de " + total_com);
                                    System.out.println("Cantidad de capital actual: " + cant_efectivo);
                                    System.out.println(" ");
                                    // se le suma las cantidad de compras y se va sumando al almacen
                                    cant_compras++;

                                    cant_azucar = cant_azucar + kilos_pro;
                                }
                            }

                        } else if (producto == 4) {
                            // lo mismo en todos los productos
                            nom_producto = "Maiz";
                            System.out.println(" ");
                            System.out.println("El producto que usted selecciono es Maiz ");
                            System.out.println("Ingrese los kilos que necesite(en todo caso de no querer realizar la compra presionar 0)");
                            kilos_pro = info.nextDouble();
                            if (kilos_pro < 0) {
                                System.out.println("Error. NO SE PUEDE COMPRAR PRODUCTOS NEGATIVOS");
                            } else if (kilos_pro == 0) {
                                System.out.println("----COMPRA CANCELADA----");
                            } else {
                                total_com = kilos_pro * 20;

                                if (total_com > cant_efectivo) {
                                    System.out.println(" ");
                                    System.out.println("No Se Puede Pagar Compra");
                                    System.out.println("el total de su compra es: " + total_com);
                                    System.out.println("Unicamente cuenta con : " + cant_efectivo);
                                    double cant_efectivo_calculo = cant_efectivo;
                                    double posible_compra = total_com - cant_efectivo_calculo;
                                    System.out.println("Para completar esa compra le hacen falta: " + posible_compra + " Lempiras.");
                                    System.out.println(" ");
                                } else if (total_com < cant_efectivo) {
                                    cant_efectivo = cant_efectivo - total_com;
                                    System.out.println(" ");
                                    System.out.println("Compra efectuada");
                                    System.out.println("se han comprado " + kilos_pro + " kilogramos de " + nom_producto);
                                    System.out.println("El total de su compra es de " + total_com);
                                    System.out.println("Cantidad de capital actual: " + cant_efectivo);
                                    System.out.println(" ");
                                    cant_maiz = cant_maiz + kilos_pro;
                                    cant_compras++;

                                }
                            }
                            //error por si el proveedor esta mal 
                        } else {
                            System.out.println("Error.Proveedor no vende dicho Producto");
                        }

                    } else if (opcion_pro == 2) {
                        System.out.println("El  proveedor que usted a seleccionado es el B");
                        System.out.println("Ingrese el codigo del producto requerido (en todo caso de no querer realizar la compra presionar 0) ");
                        producto = info.nextInt();

                        if (producto == 0) {
                            System.out.println("----COMPRA CANCELADA----");
                        } else if (producto == 2) {

                            nom_producto = "Avena";
                            System.out.println("El producto que usted selecciono es Avena");
                            System.out.println("Ingrese los kilos que necesite (en todo caso de no querer realizar la compra presionar 0)");
                            kilos_pro = info.nextDouble();
                            if (kilos_pro < 0) {
                                System.out.println("Error. NO SE PUEDE COMPRAR PRODUCTOS NEGATIVOS");
                            } else if (kilos_pro == 0) {
                                System.out.println("----COMPRA CANCELADA----");
                            } else {
                                total_com = kilos_pro * 20;

                                if (total_com > cant_efectivo) {
                                    System.out.println(" ");
                                    System.out.println("No Se Puede Pagar Compra");
                                    System.out.println("el total de su compra es: " + total_com);
                                    System.out.println("Unicamente cuenta con : " + cant_efectivo);
                                    double cant_efectivo_calculo = cant_efectivo;
                                    double posible_compra = total_com - cant_efectivo_calculo;
                                    System.out.println("Para completar esa compra le hacen falta : " + posible_compra + " Lempiras.");
                                    System.out.println(" ");

                                } else if (total_com < cant_efectivo) {
                                    cant_efectivo = cant_efectivo - total_com;
                                    System.out.println(" ");
                                    System.out.println("Compra efectuada");
                                    System.out.println("se han comprado " + kilos_pro + " kilogramos de " + nom_producto);
                                    System.out.println("El total de su compra es de " + total_com);
                                    System.out.println("Cantidad de capital actual: " + cant_efectivo);
                                    System.out.println(" ");
                                    cant_avena = cant_avena + kilos_pro;
                                    cant_compras++;

                                }
                            }

                        } else if (producto == 3) {

                            nom_producto = "Trigo";
                            System.out.println("El producto que usted selecciono es Trigo");
                            System.out.println("Ingrese los kilos que necesite (en todo caso de no querer realizar la compra presionar 0)");
                            kilos_pro = info.nextDouble();
                            if (kilos_pro < 0) {
                                System.out.println("Error. NO SE PUEDE COMPRAR PRODUCTOS NEGATIVOS");
                            } else if (kilos_pro == 0) {
                                System.out.println("----COMPRA CANCELADA----");
                            } else {
                                total_com = kilos_pro * 30;

                                if (total_com > cant_efectivo) {
                                    System.out.println(" ");
                                    System.out.println("No Se Puede Pagar Compra");
                                    System.out.println("el total de su compra es: " + total_com);
                                    System.out.println("Unicamente cuenta con : " + cant_efectivo);
                                    double cant_efectivo_calculo = cant_efectivo;
                                    double posible_compra = total_com - cant_efectivo_calculo;
                                    System.out.println("Para completar esa compra le hacen falta : " + posible_compra + " Lempiras.");
                                    System.out.println(" ");
                                } else if (total_com < cant_efectivo) {
                                    cant_efectivo = cant_efectivo - total_com;
                                    System.out.println(" ");
                                    System.out.println("Compra efectuada");
                                    System.out.println("se han comprado " + kilos_pro + " kilogramos de " + nom_producto);
                                    System.out.println("El total de su compra es de " + total_com);
                                    System.out.println("Cantidad de capital actual: " + cant_efectivo);
                                    System.out.println(" ");
                                    cant_trigo = cant_trigo + kilos_pro;
                                    cant_compras++;

                                }
                            }

                        } else {
                            System.out.println("Error.Proveedor no vende dicho Producto");
                        }

                    } else if (opcion_pro == 3) {
                        System.out.println("El  proveedor que usted a seleccionado es el B");
                        System.out.println("Ingrese el codigo del producto requerido(en todo caso de no querer realizar la compra presionar 0) ");
                        producto = info.nextInt();
                        if (producto == 0) {
                            System.out.println("----COMPRA CANCELADA----");
                        } else if (producto == 2) {

                            nom_producto = "Avena";
                            System.out.println("El producto que usted selecciono es Avena");
                            System.out.println("Ingrese los kilos que necesite (en todo caso de no querer realizar la compra presionar 0)");
                            kilos_pro = info.nextDouble();
                            if (kilos_pro < 0) {
                                System.out.println("Error. NO SE PUEDE COMPRAR PRODUCTOS NEGATIVOS");
                            } else if (kilos_pro == 0) {
                                System.out.println("----COMPRA CANCELADA----");
                            } else {
                                total_com = kilos_pro * 22;

                                if (total_com > cant_efectivo) {
                                    System.out.println(" ");
                                    System.out.println("No Se Puede Pagar Compra");
                                    System.out.println("el total de su compra es: " + total_com);
                                    System.out.println("Unicamente cuenta con : " + cant_efectivo);
                                    double cant_efectivo_calculo = cant_efectivo;
                                    double posible_compra = total_com - cant_efectivo_calculo;
                                    System.out.println("Para completar esa compra le hacen falta : " + posible_compra + " Lempiras.");
                                    System.out.println(" ");
                                } else if (total_com < cant_efectivo) {
                                    cant_efectivo = cant_efectivo - total_com;
                                    System.out.println(" ");
                                    System.out.println("Compra efectuada");
                                    System.out.println("se han comprado " + kilos_pro + " kilogramos de " + nom_producto);
                                    System.out.println("El total de su compra es de " + total_com);
                                    System.out.println("Cantidad de capital actual: " + cant_efectivo);
                                    System.out.println(" ");
                                    cant_avena = cant_avena + kilos_pro;
                                    cant_compras++;

                                }
                            }

                        } else {
                            System.out.println("Error. PRODUCTO NO EXISTENTE ");
                        }

                    }
                    // aqui se busca cual fue la mayor venta para los reportes 
                    total_compras += total_com;

                    if (total_com > mayor_compra) {
                        mayor_compra = total_com;
                        kilos_mayorcompra = kilos_pro;
                        nombre_mayorcom = nom_producto;
                    }

                }

            } else if (opcion == 2) {
                // se valida si esta abierta la caja 
                if (caja_abierta == 0) {
                    System.out.println("Abrir caja antes de ingresar ventas");
                } else {
                    // se valida si no hay ninguna compra antes de entrar 
                    if (cant_compras == 0) {
                        System.out.println("No poseemos ningun producto.");
                    } else {
                        //menu de ventas.
                        System.out.println("Bienvenido a la seccion de ventas");
                        System.out.println("En este seccion se vende una cantidad de productos, para suplir las  necesidades del cliente.");
                        System.out.println("Las siguientes son opciones de nuestro tipo de clientes, dependiendo  del tipo de cliente, usted podra comprar los siguientes productos");
                        System.out.println("      Codigo      " + "        Producto        " + "        Precio Compra        "
                                + "\n" + "        1        " + "          Azucar        " + "            Lps.30        "
                                + "\n" + "        2        " + "          Avena         " + "            Lps.25          "
                                + "\n" + "        3        " + "          Trigo         " + "            Lps.32        "
                                + "\n" + "        4        " + "          Maiz          " + "            Lps.20        ");
                        System.out.println("Si selecciona el cliente A podra comprar todo tipo de productos" + "\n" + "Si selecciona el Cliente B solo podra comprar productos con el codigo 1,2 y 3"
                                + "\n" + "Si selecciona el  proveedor C solo podra comprar el producto con codigo 4");

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
                                System.out.println("Ingrese el codigo del producto que necesite(en todo caso de no querer realizar la venta presionar 0)");
                                opcion_produc = info.nextInt();
                                if (opcion_produc == 0) {
                                    System.out.println("----VENTA CANCELADA----");
                                    cont_compra = 2;
                                }
                                if (opcion_produc == 1) {
                                    nom_producto = "Azucar";
                                    System.out.println("El producto que selecciono es Azucar, el costo de estes de 30 lps,contamos con " + cant_azucar + " kilos");
                                    if (cant_azucar < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();

                                    } else if (cant_azucar > 1) {
                                        System.out.println("ingrese los kilos que requiere(en todo caso de no querer realizar la venta presionar 0): ");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven <= -1) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        } else if (kilos_ven > cant_azucar) {
                                            System.out.println("Unicamente contamos con " + cant_azucar + " kilos de azucar");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 30;
                                                cant_azucar = cant_azucar - cant_azucar;
                                                subtotal_total += subtotal_venta;

                                                System.out.println("venta realizada");
                                                kilos_azucar += kilos_ven;
                                                cant_ventas++;

                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  30 lps. " + "\n";
                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 30;
                                            cant_azucar = cant_azucar - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("venta realizada");
                                            kilos_azucar += kilos_ven;
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  30 lps. " + "\n";
                                            cant_ventas++;

                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else if (opcion_produc == 2) {
                                    nom_producto = "Avena";
                                    System.out.println("El producto que selecciono es Avena, el costo de estes de 25 lps,contamos con " + cant_avena + " kilos");
                                    if (cant_avena < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();
                                    } else if (cant_avena > 1) {
                                        System.out.println("ingrese los kilos que requiere(en todo caso de no querer realizar la venta presionar 0): ");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven <= -1) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        } else if (kilos_ven > cant_avena) {
                                            System.out.println("Unicamente contamos con " + cant_avena + " kilos de avena");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 25;
                                                cant_avena = cant_avena - cant_avena;
                                                subtotal_total += subtotal_venta;
                                                System.out.println("venta realizada");
                                                kilos_avena += kilos_ven;
                                                total_ventas += total_venta;
                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  25 lps. " + "\n";
                                                cant_ventas++;

                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 25;
                                            cant_avena = cant_avena - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("Venta realizada");
                                            kilos_avena += kilos_ven;
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  25 lps. " + "\n";
                                            cant_ventas++;

                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else if (opcion_produc == 3) {
                                    nom_producto = "trigo";
                                    System.out.println("El producto que selecciono es Trigo, el costo de estes de 32 lps,,contamos con " + cant_trigo + " kilos");
                                    if (cant_trigo < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();
                                    } else if (cant_trigo > 1) {

                                        System.out.println("ingrese los kilos que requiere (en todo caso de no querer realizar la venta presionar 0):");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven <= -1) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        } else if (kilos_ven > cant_trigo) {
                                            System.out.println("Unicamente contamos con " + cant_trigo + " kilos de trigo");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 32;
                                                cant_trigo = cant_trigo - cant_trigo;
                                                subtotal_total += subtotal_venta;

                                                System.out.println("Venta realizada");
                                                kilos_trigo += kilos_ven;
                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  32 lps. " + "\n";
                                                cant_ventas++;

                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 32;
                                            cant_trigo = cant_trigo - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("Venta realizada");
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  32 lps. " + "\n";
                                            kilos_trigo += kilos_ven;
                                            cant_ventas++;

                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else if (opcion_produc == 4) {
                                    nom_producto = "Maiz";
                                    System.out.println("El producto que selecciono es Maiz, el costo de estes de 20 lps,contamos con " + cant_maiz + " kilos");
                                    if (cant_maiz < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();
                                    } else if (cant_maiz > 1) {

                                        System.out.println("ingrese los kilos que requiere(en todo caso de no querer realizar la venta presionar 0):");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven <= -1) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        } else if (kilos_ven > cant_maiz) {
                                            System.out.println("Unicamente contamos con " + cant_maiz + " kilos de maiz");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 20;
                                                cant_maiz = cant_maiz - cant_maiz;
                                                subtotal_total += subtotal_venta;
                                                System.out.println("Venta realizada");
                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  20 lps. " + "\n";
                                                kilos_maiz += kilos_ven;
                                                cant_ventas++;

                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 20;
                                            cant_maiz = cant_maiz - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("Venta realizada");
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  20 lps. " + "\n";
                                            kilos_maiz += kilos_ven;
                                            cant_ventas++;

                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else {
                                    System.out.println("Error. opcion no disponible");
                                }
                            }

                        } else if (tipo_clien == 2) {

                            System.out.println("Usted a seleccionado el tipo B de clientes");

                            while (cont_compra != 2) {
                                System.out.println("Ingrese el codigo del producto que necesite(en todo caso de no querer realizar la venta presionar 0):");
                                opcion_produc = info.nextInt();
                                if (opcion_produc == 0) {
                                    System.out.println("----VENTA CANCELADA----");
                                    cont_compra = 2;
                                } else if (opcion_produc == 1) {
                                    nom_producto = "Azucar";
                                    System.out.println("El producto que selecciono es Azucar, el costo de este es de 30 lps,contamos con " + cant_azucar + " kilos");
                                    if (cant_azucar < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();
                                    } else if (cant_azucar > 1) {
                                        System.out.println("ingrese los kilos que requiere(en todo caso de no querer realizar la venta presionar 0): ");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven <= -1) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        } else if (kilos_ven > cant_azucar) {
                                            System.out.println("Unicamente contamos con " + cant_azucar + " kilos de azucar");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 30;
                                                cant_azucar = cant_azucar - cant_azucar;
                                                subtotal_total += subtotal_venta;
                                                System.out.println("Venta realizada");
                                                kilos_azucar += kilos_ven;
                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  30 lps. " + "\n";
                                                cant_ventas++;

                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 30;
                                            cant_azucar = cant_azucar - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("VENTA realizada");
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  30 lps. " + "\n";
                                            kilos_azucar += kilos_ven;
                                            cant_ventas++;

                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else if (opcion_produc == 2) {
                                    nom_producto = "Avena";
                                    System.out.println("El producto que selecciono es Avena, el costo de este es de 25 lps,contamos con " + cant_avena + " kilos");
                                    if (cant_avena < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();

                                    } else if (cant_avena > 1) {
                                        System.out.println("ingrese los kilos que requiere(en todo caso de no querer realizar la venta presionar 0):");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven <= -1) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        } else if (kilos_ven > cant_avena) {
                                            System.out.println("Unicamente contamos con " + cant_avena + " kilos de avena");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 25;
                                                cant_avena = cant_avena - cant_avena;
                                                subtotal_total += subtotal_venta;
                                                System.out.println("Venta realizada");
                                                kilos_avena += kilos_ven;
                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  25 lps. " + "\n";
                                                cant_ventas++;

                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 25;
                                            cant_avena = cant_avena - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("Venta realizada");
                                            kilos_avena += kilos_ven;
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  25 lps. " + "\n";
                                            cant_ventas++;

                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else if (opcion_produc == 3) {
                                    nom_producto = "trigo";
                                    System.out.println("El producto que selecciono es Trigo, el costo de este es de 32 lps,contamos con " + cant_trigo + " kilos");
                                    if (cant_trigo < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();
                                    } else if (cant_trigo > 1) {

                                        System.out.println("ingrese los kilos que requiere(en todo caso de no querer realizar la venta presionar 0): ");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven <= -1) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        } else if (kilos_ven > cant_trigo) {
                                            System.out.println("Unicamente contamos con " + cant_trigo + " kilos de trigo");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 32;
                                                cant_trigo = cant_trigo - cant_trigo;
                                                subtotal_total += subtotal_venta;
                                                System.out.println("Venta realizada");
                                                kilos_trigo += kilos_ven;
                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  32 lps. " + "\n";
                                                cant_ventas++;

                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 32;
                                            cant_trigo = cant_trigo - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("Venta realizada");
                                            kilos_trigo += kilos_ven;
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  32 lps. " + "\n";
                                            cant_ventas++;

                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else {
                                    System.out.println("Error. opcion no disponible");
                                }
                            }

                        } else if (tipo_clien == 3) {
                            System.out.println("Usted a seleccionado el tipo C de clientes");

                            while (cont_compra != 2) {
                                System.out.println("Ingrese el codigo del producto que necesite(en todo caso de no querer realizar la venta presionar 0):");
                                opcion_produc = info.nextInt();

                                if (opcion_produc == 0) {
                                    System.out.println("----VENTA CANCEADA----");
                                    cont_compra = 2;
                                } else if (opcion_produc == 4) {
                                    nom_producto = "Maiz";
                                    System.out.println("El producto que selecciono es Maiz, el costo de este es de 20 lps,contamos con " + cant_maiz + " kilos");
                                    if (cant_maiz < 1) {
                                        System.out.println("No tenemos el producto solicitado");
                                        System.out.println("desea buscar otro producto? " + "\n" + "si(1)" + "\n" + "no(2)");
                                        cont_compra = info.nextInt();
                                    } else if (cant_maiz > 1) {
                                        System.out.println("ingrese los kilos que requiere(en todo caso de no querer realizar la venta presionar 0): ");
                                        kilos_ven = info.nextDouble();
                                        if (kilos_ven < 0) {
                                            System.out.println("ERROR. NO INGRESAR NEGATIVOS");
                                        } else if (kilos_ven == 0) {
                                            System.out.println("----VENTA CANCELADA----");
                                            cont_compra = 2;
                                        }
                                        if (kilos_ven > cant_maiz) {
                                            System.out.println("Unicamente contamos con " + cant_maiz + " kilos de maiz");
                                            System.out.println("desea comprar esos kilos ?" + "\n" + "si(1)" + "\n" + "no(2)");
                                            comprar_igual = info.nextInt();

                                            if (comprar_igual == 1) {
                                                subtotal_venta = kilos_ven * 20;
                                                cant_maiz = cant_maiz - cant_maiz;
                                                subtotal_total += subtotal_venta;
                                                System.out.println("Venta realizada");
                                                factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  20 lps. " + "\n";
                                                kilos_maiz += kilos_ven;
                                                cant_ventas++;
                                                System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                                cont_compra = info.nextInt();

                                            } else if (comprar_igual == 2) {
                                                System.out.println("compra no realizada");
                                            } else {
                                                System.out.println("Error.Respuesta no existente");
                                            }

                                        } else {
                                            subtotal_venta = kilos_ven * 20;
                                            cant_maiz = cant_maiz - kilos_ven;
                                            subtotal_total += subtotal_venta;
                                            System.out.println("Venta realizada");
                                            factura += "Nombre del producto: " + nom_producto + ". Cantidad en kilogramos : " + kilos_ven + ". Precio unitario:  20 lps. " + "\n";
                                            cant_ventas++;
                                            kilos_maiz += kilos_ven;
                                            System.out.println("desea realizar otra compra? " + "\n" + "si(1)" + "\n" + "no(2)");
                                            cont_compra = info.nextInt();

                                        }
                                    }

                                } else {
                                    System.out.println("ERROR. OPCION NO EXISTE");
                                }

                            }

                        }
                        //mayor venta 
                        if (subtotal_venta > mayor_venta) {
                            mayor_venta = subtotal_venta;
                            kilos_mayorventa = kilos_ven;
                            nombre_mayorventa = nom_producto;
                        }
                        //calculo de los descuentos 
                        if (subtotal_total > 1000 && subtotal_total < 5000) {
                            descuento = subtotal_total * 0.05;
                            descuento_visual = 5;
                        } else if (subtotal_total > 5000) {
                            descuento = subtotal_total * 0.1;
                            descuento_visual = 10;
                        } else if (subtotal_total < 1000) {
                            descuento = 0;
                            descuento_visual = 0;
                        }
                        impuesto = subtotal_total * 0.07;

                        total_venta = subtotal_total - descuento + impuesto;
                        total_ventas += total_venta;
                        // proceso de facturacion 
                        System.out.println("----------FACTURA----------");
                        System.out.println(factura);
                        System.out.println("Subtotal de las ventas: " + String.format("%.2f", subtotal_total));
                        System.out.println("Descuento que se va a aplicar: " + String.format("%.2f", descuento_visual));
                        System.out.println("Descuento ya aplicado en el subtotal: " + String.format("%.2f", descuento));
                        System.out.println("El impuesto sobre venta es del 7%");
                        System.out.println("Total: " + String.format("%.2f", total_venta));
                        factura = " ";
                        subtotal_total = 0;
                        descuento = 0;
                        descuento_visual = 0;

                    }

                }
                //inicio de busqueda de producto estrella
                for (int i = 0; i < 4; i++) {
                    double kilos_actual = 0;
                    String nombre_producto = "";

                    // Determinamos el producto actual y su cantidad de ventas
                    if (i == 0) {
                        kilos_actual = kilos_azucar;
                        nombre_producto = "azucar";
                    } else if (i == 1) {
                        kilos_actual = kilos_avena;
                        nombre_producto = "avena";
                    } else if (i == 2) {
                        kilos_actual = kilos_trigo;
                        nombre_producto = "trigo";
                    } else if (i == 3) {
                        kilos_actual = kilos_maiz;
                        nombre_producto = "maiz";
                    }
                    /*
                    Este código compara las ventas de un producto actual con las ventas más altas registradas hasta el momento. 
                    Si el producto actual tiene más ventas, se convierte en el más vendido. Si hay un empate en ventas, 
                    el código agrega el nombre del producto a una lista de productos más vendidos. 
                    Si hay varios productos empatados, los nombres se separan con "y".
                     */
                    if (kilos_actual > kilos_mayor) {
                        kilos_mayor = kilos_actual;
                        producto_estrella = nombre_producto;
                    } else if (kilos_actual == kilos_mayor) {
                        if (!producto_estrella.contains(nombre_producto)) {
                            if (!producto_estrella.isEmpty()) {
                                producto_estrella += " y ";
                            }
                            producto_estrella += nombre_producto;
                        }
                    }
                }
                //Apartir de aqui empezamos la validaciones del ranking 
                /*
                
                Este bloque de código determina cuál producto tiene la mayor cantidad de ventas y maneja los empates. 
                Primero, compara las ventas de cada producto con la cantidad más alta registrada (primero). 
                Si un producto tiene más ventas que primero, se actualiza primero y se guarda el nombre del producto en prod_primero. 
                Si el producto tiene la misma cantidad de ventas que primero, se agrega su nombre a prod_primero para registrar el empate, 
                separando los nombres con comas. 
                Esto permite identificar todos los productos empatados en el primer lugar de ventas.
                 */
                if (kilos_azucar > primero) {
                    primero = kilos_azucar;
                    prod_primero = "Azucar";
                } else if (kilos_azucar == primero) {
                    prod_primero += ", Azucar";
                }
                if (kilos_avena > primero) {
                    primero = kilos_avena;
                    prod_primero = "Avena";
                } else if (kilos_avena == primero) {
                    prod_primero += ", Avena";
                }
                if (kilos_trigo > primero) {
                    primero = kilos_trigo;
                    prod_primero = "Trigo";
                } else if (kilos_trigo == primero) {
                    prod_primero += ", Trigo";
                }
                if (kilos_maiz > primero) {
                    primero = kilos_maiz;
                    prod_primero = "Maiz";
                } else if (kilos_maiz == primero) {
                    prod_primero += ", Maiz";
                }

                // Determinar el segundo lugar
                if (kilos_azucar > segundo && kilos_azucar < primero) {
                    segundo = kilos_azucar;
                    prod_segundo = "Azucar";
                } else if (kilos_azucar == segundo) {
                    prod_segundo += ", Azucar";
                }
                if (kilos_avena > segundo && kilos_avena < primero) {
                    segundo = kilos_avena;
                    prod_segundo = "Avena";
                } else if (kilos_avena == segundo) {
                    prod_segundo += ", Avena";
                }
                if (kilos_trigo > segundo && kilos_trigo < primero) {
                    segundo = kilos_trigo;
                    prod_segundo = "Trigo";
                } else if (kilos_trigo == segundo) {
                    prod_segundo += ", Trigo";
                }
                if (kilos_maiz > segundo && kilos_maiz < primero) {
                    segundo = kilos_maiz;
                    prod_segundo = "Maiz";
                } else if (kilos_maiz == segundo) {
                    prod_segundo += ", Maiz";
                }

                // Determinar el tercer lugar
                if (kilos_azucar > tercero && kilos_azucar < segundo) {
                    tercero = kilos_azucar;
                    prod_tercero = "Azucar";
                } else if (kilos_azucar == tercero) {
                    prod_tercero += ", Azucar";
                }
                if (kilos_avena > tercero && kilos_avena < segundo) {
                    tercero = kilos_avena;
                    prod_tercero = "Avena";
                } else if (kilos_avena == tercero) {
                    prod_tercero += ", Avena";
                }
                if (kilos_trigo > tercero && kilos_trigo < segundo) {
                    tercero = kilos_trigo;
                    prod_tercero = "Trigo";
                } else if (kilos_trigo == tercero) {
                    prod_tercero += ", Trigo";
                }
                if (kilos_maiz > tercero && kilos_maiz < segundo) {
                    tercero = kilos_maiz;
                    prod_tercero = "Maiz";
                } else if (kilos_maiz == tercero) {
                    prod_tercero += ", Maiz";
                }

                // Determinar el cuarto lugar
                if (kilos_azucar > cuarto && kilos_azucar < tercero) {
                    cuarto = kilos_azucar;
                    prod_cuarto = "Azucar";
                } else if (kilos_azucar == cuarto) {
                    prod_cuarto += ", Azucar";
                }
                if (kilos_avena > cuarto && kilos_avena < tercero) {
                    cuarto = kilos_avena;
                    prod_cuarto = "Avena";
                } else if (kilos_avena == cuarto) {
                    prod_cuarto += ", Avena";
                }
                if (kilos_trigo > cuarto && kilos_trigo < tercero) {
                    cuarto = kilos_trigo;
                    prod_cuarto = "Trigo";
                } else if (kilos_trigo == cuarto) {
                    prod_cuarto += ", Trigo";
                }
                if (kilos_maiz > cuarto && kilos_maiz < tercero) {
                    cuarto = kilos_maiz;
                    prod_cuarto = "Maiz";
                } else if (kilos_maiz == cuarto) {
                    prod_cuarto += ", Maiz";
                }

            } else if (opcion == 5) {

                if (caja_abierta == 0) {
                    System.out.println("Abrir caja antes de cierre de caja ");
                } else {
                    System.out.println("Bienvenido a la seccion de cierre de caja");
                    ganacias = total_ventas - total_compras;
                    System.out.println("Ganancias = " + ganacias);
                    System.out.println(" ");
                    System.out.println("Dinero que hay en caja al momento de cierre: " + cant_efectivo);
                    System.out.println(" ");
                    int deposito_invalido = 0;
                    while (deposito_invalido == 0) {
                        System.out.println("Ingrese la cantidad de ese dinero que quiere ingresar al banco(Unicamente el 60% de ese dinero): ");
                        int deposito_banco = info.nextInt();

                        double deposito_valido = cant_efectivo * 0.6;

                        if (deposito_banco > deposito_valido) {
                            System.out.println("ERROR. recuerde que unicamente puede ingresar el 60%");

                        } else {
                            System.out.println("Cantidad valida ingresada al banco ");
                            deposito_invalido = 1;
                            cant_efectivo = cant_efectivo - deposito_banco;

                            System.out.println("la cuanta actual de su caja tiene = " + cant_efectivo);

                            caja_abierta = 0;

                        }

                    }
                    kilos_pro = 0;
                    total_com = 0;
                    cant_azucar = 0;
                    cant_avena = 0;
                    cant_trigo = 0;
                    cant_maiz = 0;
                    kilos_ven = 0;
                    subtotal_venta = 0;
                    descuento = 0;
                    impuesto = 0;
                    total_venta = 0;
                    ganacias = 0;
                    total_compras = 0;
                    total_ventas = 0;
                    mayor_compra = 0;
                    kilos_mayorcompra = 0;
                    mayor_venta = 0;
                    kilos_mayorventa = 0;
                    kilos_maiz = 0;
                    kilos_trigo = 0;
                    kilos_azucar = 0;
                    kilos_avena = 0;
                    kilos_mayor = 0;
                    subtotal_total = 0;
                    descuento_visual = 0;
                    promedio_ventas = 0;
                    promedio_compras = 0;
                    nom_producto = "";
                    nombre_mayorcom = " ";
                    nombre_mayorventa = "";
                    producto_estrella = " ";
                    factura = " ";
                    cant_ventas = 0;
                    cant_compras = 0;
                    nombre_mayorcom = "";
                }

            } else if (opcion == 4) {
                if (caja_abierta == 0) {
                    System.out.println("Abrir caja antes de ingresar reportes");
                } else {
                    promedio_ventas = total_ventas / cant_ventas;
                    promedio_compras = total_compras / cant_compras;
                    ganacias = total_ventas - total_compras;
                    System.out.println(" ");
                    System.out.println("Cantidad de efectivo al momento del cierre: " + cant_efectivo);
                    System.out.println("Volumen de ventas del dia: " + total_ventas
                            + "\n" + "Volumen de compras del dia: " + total_compras
                            + "\n" + "Margen de ganancias: " + String.format("%.2f", ganacias)
                            + "\n" + "Promedio de dinero obtenido de ventas: " + String.format("%.2f", promedio_ventas)
                            + "\n" + "Promedio de dinero obtenido de compras: " + String.format("%.2f", promedio_compras)
                            + "\n" + "Venta de mayor ganancia : " + nombre_mayorventa + " se gano: " + mayor_venta + "$. Kilos que se vendieron: " + kilos_mayorventa + "kg"
                            + "\n" + "Compra de mayor gasto: " + nombre_mayorcom + " se gasto: " + mayor_compra + "$. kilos que se compraron: " + kilos_mayorcompra + "kg"
                            + "\n" + "El producto estrella es: " + producto_estrella + " con " + kilos_mayor + " kilogramos vendidos."
                            + "\n" + "Ranking:   ");
                    if (primero > 0) {
                        System.out.println("1 lugar: " + prod_primero + " (" + primero + " kilos)");
                    }
                    if (segundo > 0 && !prod_segundo.equals(prod_primero)) {
                        System.out.println("2 lugar: " + prod_segundo + " (" + segundo + " kilos)");
                    }
                    if (tercero > 0 && !prod_tercero.equals(prod_primero) && !prod_tercero.equals(prod_segundo)) {
                        System.out.println("3 lugar: " + prod_tercero + " (" + tercero + " kilos)");
                    }
                    if (cuarto > 0 && !prod_cuarto.equals(prod_primero) && !prod_cuarto.equals(prod_segundo) && !prod_cuarto.equals(prod_tercero)) {
                        System.out.println("4 lugar: " + prod_cuarto + " (" + cuarto + " kilos)");
                    }

                }

            }

        }

    }

}
