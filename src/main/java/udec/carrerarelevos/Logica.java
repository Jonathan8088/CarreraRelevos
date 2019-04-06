/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.carrerarelevos;

/**
 *clase que contiene los metodos propios del proyecto
 * @author Jonathan
 */
public class Logica {
    /**
     * vector que maneja las posiciones del equipo amarillo
     */
    char[] equipoAmarillo = new char [50];
    /**
     * vector que maneja las posiciones del equipo rojo
     */
    char[] equipoRojo = new char [50];
    /**
     * vector que maneja las posiciones del equipo azul
     */
    char[] equipoAzul = new char [50];
    /**
     * atributo que controla los pasos que va dando cada equipo
     */
    static Integer pasosAmarillo = 0;
    /**
     * atributo que controla los pasos que va dando cada equipo
     */
    static Integer pasosAzul = 0;
    /**
     * atributo que controla los pasos que va dando cada equipo
     */
    static Integer pasosRojo = 0;
    /**
     * variable que lleva un control acerca de si ya existe un ganador o no
     */
    static boolean control = true;
    /**
     * constructor de la clase
     */
    public Logica(int prueba) {
        llenar(equipoRojo);
        llenar(equipoAzul);
        llenar(equipoAmarillo);
        ubicacion();
        PersonaHilo1 corredor1 = new PersonaHilo1("amarillo", equipoAmarillo,pasosAmarillo);
        PersonaHilo2 corredor2 = new PersonaHilo2("amarillo", equipoAmarillo,pasosAmarillo);
        PersonaHilo3 corredor3 = new PersonaHilo3("amarillo", equipoAmarillo,pasosAmarillo);
        PersonaHilo4 corredor4 = new PersonaHilo4("rojo", equipoAzul,pasosAzul);
        PersonaHilo5 corredor5 = new PersonaHilo5("rojo", equipoAzul,pasosAzul);
        PersonaHilo6 corredor6 = new PersonaHilo6("rojo", equipoAzul,pasosAzul);
        PersonaHilo7 corredor7 = new PersonaHilo7("azul",equipoRojo,pasosRojo);
        PersonaHilo8 corredor8 = new PersonaHilo8("azul",equipoRojo,pasosRojo);
        PersonaHilo9 corredor9 = new PersonaHilo9("azul",equipoRojo,pasosRojo);
        corredor1.start();
        corredor4.start();
        corredor7.start();
        corredor2.start();
        corredor3.start();
        corredor5.start();
        corredor6.start();
        corredor8.start();
        corredor9.start();
    }//constructor
    /**
     * constructor de la clase diseñado para pruebas
     */
    public Logica(){
        
    }//costructor
    /**
     * constructor que toma el vector enviado en el vector correspondiente de cada equipo
     * @param vector vector que envia cada hilo con los datos correspondientes de sus metodos
     * @param equipo variable que controla que equipo envio el vector
     */
    public Logica(char [] vector, int equipo){
        if(control){
            if(equipo == 1){
                equipoAmarillo = vector;
                imprimir(equipoAmarillo,1);
                if(equipoAmarillo[49]=='3'){
                    ganador("Amarillo");
                }//if
            }else if (equipo == 2){
                equipoAzul = vector;
                imprimir(equipoAzul,2);
                if(equipoAzul[49]=='C'){
                    ganador("Azul");
                }//if
            }else if(equipo == 3){
                equipoRojo = vector;
                imprimir(equipoRojo,3);
                if(equipoRojo[49]=='§'){
                    ganador("Rojo");
                }//if
            }//if    
        }//if
    }//constructor
    /**
     * metodo que se encarga de ubicar los corredores en cada vector
     */
    private void ubicacion(){
        equipoAmarillo[0] = '1';
        equipoAmarillo[15] = '2';
        equipoAmarillo[30] = '3';
        equipoAzul[0] = 'A';
        equipoAzul[15] = 'B';
        equipoAzul[30] = 'C';
        equipoRojo[0] = 'Ø';
        equipoRojo[15] = '¶';
        equipoRojo[30] = '§';
    }//ubicacion
    /**
     * metodo que realiza llenado de las matrices con caracteres
     */
     private void llenar(char [] vector){
        for (int i = 0; i < 50; i++) {
            equipoAmarillo[i] = '_';
        }//for
        for (int i = 0; i < 50; i++) {
            equipoAzul[i] = '_';
        }//for
        for (int i = 0; i < 50; i++) {
            equipoRojo[i] = '_';
        }//for
    }//llenar
    /**
     * metodo que se encarga de imprimir los vectores deacuerdo al avance de cada uno
     * @param vector 
     */
    public static synchronized void imprimir(char [] vector, int equipo){
        if(control){
            System.out.print("\n");
            for (int i = 0; i < 50; i++) {
                if(equipo == 1){
                    System.out.print("\033[33m"+vector[i]);
                }else if(equipo == 2){
                    System.out.print("\033[34m"+vector[i]);
                }else{
                    System.out.print("\033[31m"+vector[i]);
                }//if
            }//for
            System.out.print("\n");   
        }//if
    }//imprimir
    /**
     * metodo que imprime la medalla e indica cual equipo fue el ganador
     * @param equipo variable que contiene el color del equipo ganador
     */
    public static synchronized boolean ganador(String equipo){
        if(control){
            System.out.println("          ||");
            System.out.println("       ||      ||");
            System.out.println("     ||          ||");
            System.out.println("   ||              ||");
            System.out.println(" ||                  ||");
            System.out.println("|| GANADOR: "+equipo+"||");
            System.out.println(" ||                   ||");
            System.out.println("  ||                 ||");
            System.out.println("   ||              ||");
            System.out.println("     ||          ||");
            System.out.println("        ||    ||");
            System.out.println("          ||");   
            control = false;
            return false;
        }else{
            return true;
        }//else
    }//ganador

}//Principal
