/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.carrerarelevos;

import java.util.logging.Level;
import java.util.logging.Logger;
import static udec.carrerarelevos.Logica.pasosRojo;

/**
 *clase que controla al corredor 7
 * @author Jonathan
 */
public class PersonaHilo7 extends Thread{
    /**
     * atributo que contiene el nombre del equipo al que pertenece
     */
    private String equipo;
    /**
     * atributo que recibe el vector del equipo para calcular el avance del corredor
     */
    char [] vector;
    /**
     * atributo que recibe la variable sincrinizada para control de hilos
     */
    Integer pasos1;
    /**
     * constructor de la clase que incializa las variables
     * @param equipo nombre del equipo al que pertenece
     * @param vector variable que recibe el vector especifico del equipo para generar el avance
     */
    public PersonaHilo7(String equipo, char [] vector, Integer pasos) {
        this.equipo = equipo;
        this.vector = vector;
        this.pasos1 = pasos;
       // this.pasos = pasos;
    }//consructor
    /**
     * metodo que inciializa el hilo
     */
    @Override
    public void run(){
        while(pasosRojo <= 14){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PersonaHilo4.class.getName()).log(Level.SEVERE, null, ex);
            }//catch
            int numero = generarNumero();
            
            avance(numero);
        } //while
        
    }//run
    /**
     * numero que genera un numero randonomico entre 3 y 1
     * @return numero retorna el numero randonomico
     */
    public int generarNumero(){
        int numero = (int) (Math.random() * 3)+1;
        return numero;
    }//generarRandonomico
    /**
     * metodo que se encarga de generar el avance de el corredor 1
     * @param avance numero de pasos que avanzara el corredor 1
     */
    public void avance(int avance){
        for(int i = 0; i<50; i++){
            if(vector[i]=='Ø'){
                if(i+avance >=15){
                    vector[i]='_';
                    vector[14]='Ø';
                    pasosRojo =14;
                    synchronized (pasos1){
                        pasos1.notify();
                    }
                    break;
                }else{
                    pasosRojo += avance;
                    vector[i] = '_';
                    vector[i+avance] = 'Ø';
                    break;
                }//else
            }//if
        }//for
        Logica principal = new Logica(vector, 3);
    }//avance
    /**
     * retorna el nombre del equipo al que pertenece
     * @return equipo
     */
    public String getEquipo() {
        return equipo;
    }//getEquipo
    /**
     * modifica el nombre dle equipo al que pertenece
     * @param equipo 
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }//setEquipo
    
}//PersonaHilo7
