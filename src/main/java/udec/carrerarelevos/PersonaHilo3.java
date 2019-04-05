/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udec.carrerarelevos;

import java.util.logging.Level;
import java.util.logging.Logger;
import static udec.carrerarelevos.Logica.pasosAmarillo;
/**
 *clase que controla al corredor 3
 * @author Jonathan
 */
public class PersonaHilo3 extends Thread{
    /**
     * atributo que contiene el nombre del equipo al que pertenece
     */
    private String equipo;
    /**
     * atributo que recibe el vector del equipo para calcular el avance del corredor 3
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
    public PersonaHilo3(String equipo, char [] vector, Integer pasos) {
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
        while(pasosAmarillo<30){
            synchronized (pasos1){
            try {
                pasos1.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PersonaHilo1.class.getName()).log(Level.SEVERE, null, ex);
                    }//catch
                }//pasos
        }//if
        while(pasosAmarillo<50){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PersonaHilo2.class.getName()).log(Level.SEVERE, null, ex);
            }//catch
            int numero = generarNumero();
            pasosAmarillo += numero;
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
        for(int i = 30; i<50; i++){
            if(vector[i]=='3'){
                if(i+avance >=50){
                    vector[i]='_';
                    vector[49]='3';
                    pasosAmarillo = 50;
                    break;
                }else{
                   // pasos += avance;
                    vector[i] = '_';
                    vector[i+avance] = '3';
                    break;
                }//else
            }//if
        }//for
        Logica principal = new Logica(vector, 1);
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
    
}//PersonaHilo3
