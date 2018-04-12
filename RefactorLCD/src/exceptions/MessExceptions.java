package exceptions;

/**
 * Esta clase nos permite gestionar nuestras propias excepciones en este proyecto
 * 
 */

public class MessExceptions extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public static String ILEGAL_ARGUMENT_SPACE = "El espacio entre digitos debe estar entre 0 y 5";
	public static String ILEGAL_ARGUMENT_NUMEBR = "Debes ingresar un número";
	public static String ILEGAL_ARGUMENT_EMPTY = "El campo no puede ser vacio";	

	public MessExceptions() {
	}

	public MessExceptions(String exception) {
		super(exception);
	}

	public class NotValidFieldException extends MessExceptions {
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String info) {
			super("Error, campo invalido:" + info );
		}
	}
	
	public class NullEntityExcepcion extends MessExceptions {
		private static final long serialVersionUID = 1L;

		public NullEntityExcepcion(String info) {
			super("Error, entidad null"+ info);
		}
	}

	public class EmptyFieldException extends MessExceptions {
		private static final long serialVersionUID = 1L;

		public EmptyFieldException(String info) {
			super("Error campo vacio:" + info);
		}
	}

	
}
