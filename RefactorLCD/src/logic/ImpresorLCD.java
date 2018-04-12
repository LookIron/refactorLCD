package logic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpresorLCD {

	public static final String CARACTER_VERTICAL = "|";
	public static final String CARACTER_HORIZONTAL = "-";
	public static final String POSICION_X = "X";
	public static final String POSICION_Y = "Y";
	public static final int NUM_PUNTUS = 5;
	
	private ILogicImpresorLCD logica;
    
    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    
    private String[][] matrizImpr;

    private int size;

    // Calcula el numero de filasDig
    private int filasDig;
    private int columDig;
    private int totalFilas;
    private int totalColum;

    public ImpresorLCD() {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
        logica = new LogicImpresorLCD();
    }
    
     /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size el tamaño Segmento Digitos
     * @param numeroImp Numero a Imprimir
     * @param espacio Espacio Entre digitos
     * @throws Exception 
     */    
    private void imprimirNumero(int size, String numeroImp, int espacio) throws Exception 
    {
        int pivotX = 0;
        char[] digitos;

        this.size = size;      
        
        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = getFila();

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (getColumna() * numeroImp.length())
                + (espacio * numeroImp.length());

        // crea matriz para almacenar los numero a imprimir
        this.matrizImpr = new String[this.totalFilas][this.totalColum];

        // crea el arreglo de digitos
        digitos = numeroImp.toCharArray();

        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }

       logica.verificarDIgito(digitos);
       
       for (char digito : digitos) {

            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (this.filasDig / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (this.filasDig - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (this.columDig - 1);
            this.pf4[1] = (this.filasDig / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (this.columDig - 1) + pivotX;

            pivotX = pivotX + this.columDig + espacio;
            
            List<int[]> puntos = new ArrayList<>();
            puntos.add(pf1);
            puntos.add(pf2);
            puntos.add(pf3);
            puntos.add(pf4);
            puntos.add(pf5);
           
            logica.adicionarDigito(numero,this.matrizImpr,puntos, POSICION_X,POSICION_Y,this.size,CARACTER_VERTICAL,CARACTER_HORIZONTAL);
        }
       
       logica.imprimirMatriz(this.matrizImpr, this.totalFilas, this.totalColum);

    }

     /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito
     * y el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     * @throws Exception 
     */  
    public void procesar(String comando, int espacioDig) throws Exception {
        
        String[] parametros;
        
        int tam;
        
        logica.validar(comando, espacioDig);
        
        
        parametros = comando.split(",");
        tam = Integer.parseInt(parametros[0]);
        
        // Realiza la impresion del numero
        imprimirNumero(tam, parametros[1],espacioDig);

    }
    
    private int getFila() {
    	return  this.filasDig = (2 * this.size) + 3;
    }
    
    private int getColumna(){
    	return this.columDig = this.size + 2;
    }

    

}
