package Festivos;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Festivo {
    protected LocalDate fechaFestivo;
    protected String descripcion;

    public Festivo(int dia,int mes,String descripcion) throws DateTimeException{
        this.fechaFestivo=LocalDate.of(2026,mes,dia);
        this.descripcion=descripcion;
    }

    public static boolean validarFecha(int dia,int mes,ArrayList<Festivo> listaFestivos){
        for (int i=0;i<listaFestivos.size();i++){
            Festivo f=listaFestivos.get(i);
            if (f.fechaFestivo.getDayOfMonth()==dia && f.fechaFestivo.getMonthValue()==mes){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaFestivo.format(patron)+" "+descripcion;-
    }

}
