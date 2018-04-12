package logic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import exceptions.MessExceptions;
import exceptions.MessExceptions.NotValidFieldException;

public class RunLCD {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        ILogicImpresorLCD logic = new LogicImpresorLCD();
        ImpresorLCD impresor = new ImpresorLCD();
        String comando;
        int espacioDig;
        
        try {

            try (Scanner lector = new Scanner(System.in)) {
                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un numero
                if (logic.isNumeric(comando)) 
                {
                    espacioDig = Integer.parseInt(comando);
                    
                    // se valida que el espaciado este entre 0 y 5
                    if(espacioDig <0 || espacioDig >5)
                    {
                    	 throw new MessExceptions().new NotValidFieldException("El espacio entre "
                                + "digitos debe estar entre 0 y 5");
                    }
                    
                } 
                else 
                {
                	 throw new MessExceptions().new NotValidFieldException("Cadena " + comando
                            + " no es un entero");
                }
                
                do
                {
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    if(!comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                        listaComando.add(comando);
                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
            }
       

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                	impresor.procesar(iterator.next(), espacioDig);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        } catch (Exception ex) 
        {
        	
            System.out.println("Error: "+ex.getMessage());
        }

    }

}
