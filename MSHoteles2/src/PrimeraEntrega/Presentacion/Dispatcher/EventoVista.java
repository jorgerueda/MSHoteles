package PrimeraEntrega.Presentacion.Dispatcher;

public class EventoVista {
	
	//PRIMERA ENTREGA
	
		//EVENTOS DE EXITO
		
		public final static int ALTA_HABITACION_EXITO = 1010;
		public final static int BAJA_HABITACION_EXITO = 1020;
		public final static int MODIFICAR_HABITACION_EXITO = 1030;
		public final static int MOSTRAR_HABITACION_EXITO = 1040;
		public final static int MOSTRAR_HABITACIONES_EXITO = 1050;
		public final static int MOSTRAR_HABITACION_N_RESERVAS_EXITO = 1060;

		
		public final static int ALTA_CLIENTE_EXITO = 2010;
		public final static int BAJA_CLIENTE_EXITO = 2020;
		public final static int MODIFICAR_CLIENTE_EXITO = 2030;
		public final static int MOSTRAR_CLIENTE_EXITO = 2040;
		public final static int MOSTRAR_CLIENTES_EXITO = 2050;
		public final static int MOSTRAR_CLIENTE_N_RESERVAS_EXITO = 2060;

		
		public final static int ALTA_RESERVA_EXITO = 3010;
		public final static int BAJA_RESERVA_EXITO = 3020;
		public final static int MODIFICAR_RESERVA_EXITO = 3030;
		public final static int MOSTRAR_RESERVA_EXITO = 3040;
		public final static int MOSTRAR_RESERVAS_EXITO = 3050;
		public final static int ADD_HABITACION_EXITO = 3060;
		public final static int QUITAR_HABITACION_EXITO = 3070;

		
		//EVENTOS DE FALLO
		
		public final static int ALTA_HABITACION_FALLO = 1011;
		public final static int BAJA_HABITACION_FALLO = 1021;
		public final static int MODIFICAR_HABITACION_FALLO = 1031;
		public final static int MOSTRAR_HABITACION_FALLO = 1041;
		public final static int MOSTRAR_HABITACIONES_FALLO = 1051;
		public final static int MOSTRAR_HABITACION_N_RESERVAS_FALLO = 1061;

		
		public final static int ALTA_CLIENTE_FALLO = 2011;
		public final static int BAJA_CLIENTE_FALLO = 2021;
		public final static int MODIFICAR_CLIENTE_FALLO = 2031;
		public final static int MOSTRAR_CLIENTE_FALLO = 2041;
		public final static int MOSTRAR_CLIENTES_FALLO= 2051;
		public final static int MOSTRAR_CLIENTE_N_RESERVAS_FALLO = 2061;

		
		public final static int ALTA_RESERVA_FALLO = 3011;
		public final static int BAJA_RESERVA_FALLO = 3021;
		public final static int MODIFICAR_RESERVA_FALLO = 3031;
		public final static int MOSTRAR_RESERVA_FALLO = 3041;
		public final static int MOSTRAR_RESERVAS_FALLO = 3051;
		public final static int ADD_HABITACION_FALLO = 3061;
		public final static int QUITAR_HABITACION_FALLO = 3071;
		
		//EVENTOS DE FLUJO ALTERNATIVO
		public final static int ALTA_HABITACION_CAPACIDAD_NO_VALIDA = 1012;
		public final static int ALTA_HABITACION_NUMERO_YA_EXISTE = 1013;
		
		public final static int BAJA_HABITACION_NO_EXISTE = 1022;
		public final static int BAJA_HABITACION_CLIENTES_ASOCIADOS = 1023;
		public final static int BAJA_HABITACION_RESERVAS_ASOCIADOS = 1024;
		
		public final static int MODIFICAR_HABITACION_NO_EXISTE = 1032;
		public final static int MODIFICAR_HABITACION_CAPACIDAD_MENOR_OCUPANTES = 1033;
		
		public final static int ALTA_CLIENTE_DNI_YA_EXISTE = 2012;
		public final static int ALTA_CLIENTE_HABITACION_NO_EXISTE = 2013;
		public final static int ALTA_CLIENTE_HABITACION_LLENA = 2014;
		
		public final static int BAJA_CLIENTE_NO_EXISTE = 2022;
		public final static int BAJA_CLIENTES_RESERVAS_ASOCIADAS = 2023;
		
		public final static int MODIFICAR_CLIENTE_NO_EXISTE = 2032;
		
		public final static int ALTA_RESERVA_CLIENTE_NO_EXISTE = 3012;
		
		public final static int BAJA_RESERVA_NO_EXISTE = 3022;
		
		public final static int MODIFICAR_RESERVA_NO_EXISTE = 3032;
		
		public final static int ASGNAR_RESERVA_NO_EXISTE = 3062;
		public final static int ASGNAR_HABITACION_NO_EXISTE = 3063;

}
