
package pe.egcc.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class CalculadoraController {
 
    private String pantalla="";
    private String memoria1="";
    private String signo="";
    private String memoria2="";

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getMemoria1() {
        return memoria1;
    }

    public void setMemoria1(String memoria1) {
        this.memoria1 = memoria1;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getMemoria2() {
        return memoria2;
    }

    public void setMemoria2(String memoria2) {
        this.memoria2 = memoria2;
    }
    
    
    
    public void doResetear(){
        pantalla="";
    }
    
    public void doResetearUno(){
        String cadena;
        cadena=pantalla;
        
        if (cadena.length()>0) {
            cadena=cadena.substring(0, cadena.length()-1);
            pantalla=cadena;
        }
    }
    
    public void doInvertirNumero(){
        String cadena;
        Double num;
        cadena=pantalla;
        if (cadena.length()>0) {
            num=1/Double.parseDouble(cadena);
            pantalla=num.toString();
        }
    }
    
    public void doInvertirSigno(){
        String cadena;
        Double num;
        cadena=pantalla;
        if (cadena.length()>0) {
            num=(-1)*(Double.parseDouble(cadena));
            pantalla=num.toString();
        } 
    }
    
    public void doPunto(){
        String cadena;
        cadena=pantalla;
        
        if (cadena.length()<=0) {
            pantalla="0.";
            
        }else{
            if (!existepunto(pantalla)) {
                pantalla=pantalla+".";
                
            }
        }
    }
    
    public void doUno(){
        pantalla = pantalla + "1";
    }
    
    public void doDos(){
        pantalla = pantalla + "2";
    }
    
    public void doTres(){
        pantalla = pantalla + "3";
    }
    
    public void doCuatro(){
        pantalla = pantalla + "4";
    }
    
    public void doCinco(){
        pantalla = pantalla + "5";
    }
    
    public void doSeis(){
        pantalla = pantalla + "6";
    }
    
    public void doSiete(){
        pantalla = pantalla + "7";
    }
    
    public void doOcho(){
        pantalla = pantalla + "8";
    }
    
    public void doNueve(){
        pantalla = pantalla + "9";
    }
    
    public void doCero(){
        pantalla = pantalla + "0";
    }
    
    public void doSumar(){
        if (!pantalla.equals("")) {
             memoria1=pantalla;
             signo="+";
             pantalla="";
        }
    }
    
    public void doRestar(){
        if (!pantalla.equals("")) {
             memoria1=pantalla;
             signo="-";
             pantalla="";
        }
    }
    
    public void doMultiplicar(){
        if (!pantalla.equals("")) {
             memoria1=pantalla;
             signo="*";
             pantalla="";
        }
    }
    
    public void doDividir(){
        if (!pantalla.equals("")) {
             memoria1=pantalla;
             signo="/";
             pantalla="";
        }
    }
    
    public void doIgual(){
        String resultado;
        memoria2=pantalla;
         
        if (!memoria2.equals("")) {
            resultado=calculadora(memoria1,memoria2,signo);
            pantalla=resultado;
        }
    }
    
    public static String calculadora(String memoria1, String memoria2, String signo){
        Double resultado=0.0;
        String respuesta;
        
        if (signo.equals("-")) {
            resultado=Double.parseDouble(memoria1)-Double.parseDouble(memoria2);
            
        }
        if (signo.equals("+")) {
            resultado=Double.parseDouble(memoria1)+Double.parseDouble(memoria2);
            
        }
        if (signo.equals("*")) {
            resultado=Double.parseDouble(memoria1)*Double.parseDouble(memoria2);
            
        }
        if (signo.equals("/")) {
            resultado=Double.parseDouble(memoria1)/Double.parseDouble(memoria2);
            
        }
        
        respuesta=resultado.toString();
        return respuesta;
    }
    
    public static boolean existepunto(String cadena){
        boolean resultado;
        resultado=false;
        
        for(int i = 0; i < cadena.length(); i++){
            if (cadena.substring(i, i+1).equals(".")) {
                resultado=true;
                break;
                
            }
        }
        return resultado;
    }
}
