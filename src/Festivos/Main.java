package Festivos;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Festivo> listaFestivos=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        int num;
        do {
            System.out.println("1.Añadir festivo"+
                    "\n2.Quitar festivo"+
                    "\n3.Buscar festivo"+
                    "\n4.Listar todos los festivos"+
                    "\n5.Salir");
            num= in.nextInt();
            in.nextLine();

            switch (num){
                case 1:
                    try {
                        System.out.println("Dime el dia: ");
                        int dia=in.nextInt();
                        in.nextLine();

                        System.out.println("Dime el mes: ");
                        int mes=in.nextInt();
                        in.nextLine();

                        System.out.println("Dime la descripcion de ese festivo: ");
                        String descripcion=in.nextLine();

                        Festivo diasfestivo=new Festivo(dia,mes,descripcion);

                        if (Festivo.validarFecha(dia,mes,listaFestivos)){
                            listaFestivos.add(diasfestivo);
                            System.out.println("Festivo agregado correctamente");
                        }
                        else {
                            System.out.println("Ese festivo ya esta añadido");
                        }

                    }
                    catch (DateTimeException dte){
                        System.out.println("La fecha introducida no es valida");
                    }
                    break;
                case 2:
                    System.out.println("Dime el dia: ");
                    int dia=in.nextInt();
                    in.nextLine();

                    System.out.println("Dime el mes: ");
                    int mes=in.nextInt();
                    in.nextLine();
                    boolean encontrado=false;

                    for (int i=0;i<listaFestivos.size();i++){
                        Festivo eliminar=listaFestivos.get(i);
                        if (eliminar.fechaFestivo.getDayOfMonth()==dia && eliminar.fechaFestivo.getMonthValue()==mes){
                            listaFestivos.remove(i);
                            System.out.println("Dia eliminado");
                            encontrado=true;
                            break;
                        }
                    }
                    if (!encontrado){
                        System.out.println("El dia que intentas buscar no esta registrado");
                    }
                    break;

                case 3:
                    System.out.println("Dime el dia: ");
                    dia=in.nextInt();
                    in.nextLine();

                    System.out.println("Dime el mes: ");
                    mes=in.nextInt();
                    in.nextLine();

                    encontrado=false;
                    for (int i=0;i<listaFestivos.size();i++){
                        Festivo buscar=listaFestivos.get(i);
                        if (buscar.fechaFestivo.getDayOfMonth()==dia && buscar.fechaFestivo.getMonthValue()==mes){
                            System.out.println(buscar);
                            encontrado=true;
                            break;
                        }
                    }
                    if (!encontrado){
                        System.out.println("El dia que intentas buscar no esta registrado");
                    }
                    break;

                case 4:
                    System.out.println("Lista de los festivos: ");
                    for (Festivo diasfestivo : listaFestivos){
                        System.out.println(diasfestivo);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo....");
                    break;
            }

        }while (num!=5);
    }
}

