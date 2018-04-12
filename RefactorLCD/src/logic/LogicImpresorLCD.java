/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.MessExceptions;

/**
 * @author Look
 *
 */
public class LogicImpresorLCD implements ILogicImpresorLCD {


	public static final int NUM_CERO=0;
	public static final int NUM_ONE=1;
	public static final int NUM_TWO=2;
	public static final int NUM_THREE=3;
	public static final int NUM_FOUR=4;
	public static final int NUM_FIVE=5;
	public static final int NUM_SIX=6;
	public static final int NUM_SEVEN=7;
	public static final int NUM_EIGHT=8;
	public static final int NUM_NINE=9;



	@Override
	public void adicionarDigito(int digito,String[][] matriz, List<int[]> puntos,
    		String posX,String posY,int tamanno, String caracV, String caracH){
		// Establece los segmentos de cada numero
        List<Integer> segList = new ArrayList<>();

        switch (digito) {
            case 1:
                segList.add(NUM_THREE);
                segList.add(NUM_FOUR);
                break;
            case 2:
                segList.add(NUM_FIVE);
                segList.add(NUM_THREE);
                segList.add(NUM_SIX);
                segList.add(NUM_TWO);
                segList.add(NUM_SEVEN);
                break;
            case 3:
                segList.add(NUM_FIVE);
                segList.add(NUM_THREE);
                segList.add(NUM_SIX);
                segList.add(NUM_FOUR);
                segList.add(NUM_SEVEN);
                break;
            case 4:
                segList.add(NUM_ONE);
                segList.add(NUM_SIX);
                segList.add(NUM_THREE);
                segList.add(NUM_FOUR);
                break;
            case 5:
                segList.add(NUM_FIVE);
                segList.add(NUM_ONE);
                segList.add(NUM_SIX);
                segList.add(NUM_FOUR);
                segList.add(NUM_SEVEN);
                break;
            case 6:
                segList.add(NUM_FIVE);
                segList.add(NUM_ONE);
                segList.add(NUM_SIX);
                segList.add(NUM_TWO);
                segList.add(NUM_SEVEN);
                segList.add(NUM_FOUR);
                break;
            case 7:
                segList.add(NUM_FIVE);
                segList.add(NUM_THREE);
                segList.add(NUM_FOUR);
                break;
            case 8:
                segList.add(NUM_ONE);
                segList.add(NUM_TWO);
                segList.add(NUM_THREE);
                segList.add(NUM_FOUR);
                segList.add(NUM_FIVE);
                segList.add(NUM_SIX);
                segList.add(NUM_SEVEN);
                break;
            case 9:
                segList.add(NUM_ONE);
                segList.add(NUM_THREE);
                segList.add(NUM_FOUR);
                segList.add(NUM_FIVE);
                segList.add(NUM_SIX);
                segList.add(NUM_SEVEN);
                break;
            case 0:
                segList.add(NUM_ONE);
                segList.add(NUM_TWO);
                segList.add(NUM_THREE);
                segList.add(NUM_FOUR);
                segList.add(NUM_FIVE);
                segList.add(NUM_SEVEN);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = segList.iterator();

        while (iterator.hasNext()) {
        	adicionarSegmento(iterator.next(),matriz,puntos,posX,posY,tamanno,caracV,caracH);
        }
  
	}
	
	/**
	 * Este método permite agregar una linea a la al número que se desea construir
	 * @param matriz, la matriz sobre la cual se esta contruyendo el número a imprimir
	 * @param punto, el pivote sobre el cual se esta trabajando en la matriz.
	 * @param posFija
	 * @param size
	 * @param caracter, dependiendo de si es POSICION_X un "-" o en caso contrario una linea "|"
	 * @param posX, indica la posición horizontalmente
	 * @return la matriz actualizada
	 * @throws Exception
	 */
	private String[][] adicionarLinea(String[][] matriz, int[] punto, String posFija, 
			int size, String caracter,String posX) {
		if (posFija.equalsIgnoreCase(posX)) 
        {
            for (int y = 1; y <= size; y++) 
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } 
        else 
        {
            for (int i = 1; i <= size; i++) 
            {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
        return matriz;

	}


	@Override
	public  String[][] adicionarSegmento(int segmento,String[][] matriz, List<int[]> puntos,
    		String posX,String posY,int tamanno, String caracV, String caracH ){
				
		String[][] mat= null;
    	
    	int[] p1 = puntos.get(0);
    	int[] p2 = puntos.get(1);
    	int[] p3 = puntos.get(2);
    	int[] p4 = puntos.get(3);
    	int[] p5 = puntos.get(4);

        switch (segmento) {
            case 1:
            	mat = adicionarLinea(matriz, p1, posY, tamanno, caracV,posX);
                break;
            case 2:
            	mat = adicionarLinea(matriz, p2, posY, tamanno, caracV, posX);
                break;
            case 3:
            	mat = adicionarLinea(matriz, p5, posY, tamanno, caracV,posX);
                break;
            case 4:
            	mat = adicionarLinea(matriz, p4, posY, tamanno, caracV,posX);
                break;
            case 5:
            	mat = adicionarLinea(matriz, p1, posX, tamanno, caracH,posX);
                break;
            case 6:
            	mat = adicionarLinea(matriz, p2, posX, tamanno, caracH,posX);
                break;
            case 7:
            	mat = adicionarLinea(matriz, p3, posX, tamanno, caracH,posX);
                break;
            default:
                break;
        }
        return mat;
		

	}
	
	public void verificarDIgito(char[] digitos)throws Exception{
		 for (char digito : digitos) {
	        //Valida que el caracter sea un digito
            if(! Character.isDigit(digito)){
                throw new MessExceptions().new NotValidFieldException("contiene caracteres invalidos");
            }
		 }
	}
	
	public void imprimirMatriz(String matriz[][], int fila, int columna) {
        // Imprime matriz
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
	}
	
	/**
    *
    * Metodo encargado de validar si una cadena es numerica
    *
    * @param cadena Cadena
    */  
   public boolean isNumeric(String cadena)throws Exception {
	   boolean si = false;
       try {
           Integer.parseInt(cadena);
           si= true;
       } catch (NumberFormatException ex) {
    	   throw new MessExceptions().new NotValidFieldException("No es valido");
           
       }
       
       return si;
   }



	@Override
	public void validar(String comando, int espacioDig) throws Exception {
		String[] parametros;        
        int tam;

        if (!comando.contains(",")) {
        	throw new MessExceptions().new NotValidFieldException("Cadena " + comando
                    + " no contiene caracter ,");
        }
        
        parametros = comando.split(",");
        
        //Valida la cantidad de parametros
        if(parametros.length>2)
        {
        	throw new MessExceptions().new NotValidFieldException("Cadena " + comando
                    + " contiene mas caracter ,"); 
        }
        
        //Valida la cantidad de parametros
        if(parametros.length<2)
        {
        	throw new MessExceptions().new NotValidFieldException("Cadena " + comando
                    + " no contiene los parametros requeridos"); 
        }
        
        //Valida que el parametro size sea un numerico
        if(isNumeric(parametros[0])){
        	
            tam = Integer.parseInt(parametros[0]);
            
            // se valida que el size este entre 1 y 10
            if(tam <1 || tam >10)
            {
            	throw new MessExceptions().new NotValidFieldException("El parametro size ["+tam
                        + "] debe estar entre 1 y 10");
            }
        }
        else
        {
        	throw new MessExceptions().new NotValidFieldException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
        
	}
	@Override
	public void isNumber(String cadena) throws Exception {
		
	}

}
