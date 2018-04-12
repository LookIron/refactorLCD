package logic;

import java.util.List;

public interface ILogicImpresorLCD {
	
	/**
	 * Verifica si una cadena es un numero
	 * @param cadena
	 * @throws Exception
	 */
	public void isNumber(String cadena) throws Exception;
	
	/**
	 * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
	 * @param digito, el num�ro el cual se desea armar
	 * @return una lista con todas las partes de n�mero
	 * @throws Exception
	 */
	public void adicionarDigito(int digito,String[][] matriz, List<int[]> puntos,
    		String posX,String posY,int tamanno, String caracV, String caracH);
	
	/**
	 * Metodo encargado de un segmento a la matriz de Impresion	
	 * @param segmento,Parte del n�mero que se desea realizar.
	 * @param matriz, la matriz sobre la cual se estan dibujando los n�meros
	 * @param puntos, los puntos fijos de un n�mero
	 * @param posX, marca de la posici�n horizontal
	 * @param posY, marca de la posici�n vertical
	 * @param tamanno, el tama�o
	 * @param caracV, el caracter de la posici�n Vertical
	 * @param caracH, el caracter de la posici�n horizontal
	 * @return, la matriz actualizada
	 */
	public  String[][] adicionarSegmento(int segmento,String[][] matriz, List<int[]> puntos,
    		String posX,String posY,int tamanno, String caracV, String caracH );
	

	/**
	 * Valida que la informaci�n ingresada sea correcta
	 * @param comando, la entrada que el usuario desea visualizar, elemplo 2,34
	 * @param espacioDig, el espacio entre los digitos
	 * @throws Exception, en caso de que alguno de los parametros sea incorrecto
	 */
	public void validar(String comando, int espacioDig)throws Exception;
	/**
	 * Permite virificar que una cadena contenga solo digitos
	 * @param digitos, un arreglo de digitos
	 * @throws Exception, si uno de los caracteres no es un digito
	 */
	public void verificarDIgito(char[] digitos)throws Exception;
	
	/**
	 * Permite imprimir la matriz en la consola
	 * @param matriz, la matriz a imprimir
	 * @param fila, el tama�o de la fila
	 * @param columna, el tama�o de la columna
	 */
	public void imprimirMatriz(String matriz[][], int fila, int columna);
	
	/**
	 * Permite convertir una cadena a un n�mero
	 * @param cadena, la cadena que se desea convertir
	 * @return, true si se convirtio y false en caso contrario
	 * @throws Exception en caso de que la cadena contenga caracteres invalidos
	 */
	public boolean isNumeric(String cadena)throws Exception;

}
