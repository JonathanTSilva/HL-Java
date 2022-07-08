package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

		Date x1 = new Date(); // Cria uma data com o horário atual
		Date x2 = new Date(System.currentTimeMillis()); // Outra forma de obter data atual
		Date x3 = new Date(0L); // Da mesma forma que foi passado os millis de agora, é possível passar qualquer
		// Em 0 millisegundos, significa o primeiro horário de armazenamento do Date (01/01/1970 GMT), mas como estamos
		// três horas atrasados, esse horário será diferente.
		// O sufixo L indica que é Long
		Date x4 = new Date(1000L * 60L * 60L * 5); // 5 horas da manhã do primeiro dia
		
		Date y1 = sdf1.parse("10/04/2050"); // Faz um parse da data passada para o tipo Date
		Date y2 = sdf2.parse("10/04/2050 04:55:07");
		Date y3 = Date.from(Instant.parse("2034-07-23T10:34:03Z")); // Data no formato ISO 8601. O Z diz que o time zone é o padrão
		// Para converter problema, criar um novo formato setando o TimeZone - sdf3
		
		System.out.println(x1); // Imprime a data no padrão local
		System.out.println(y1);
		System.out.println("----------------------");
		System.out.println("x1: " + sdf2.format(x1)); // Para imprimir no padrão sdf2, utilizar o parametro format
		System.out.println("x2: " + sdf2.format(x2));
		System.out.println("x3: " + sdf2.format(x3));
		System.out.println("x4: " + sdf2.format(x4));
		System.out.println("y1: " + sdf2.format(y1));
		System.out.println("y2: " + sdf2.format(y2));
		System.out.println("y2: " + sdf2.format(y3)); // Note que será impresso com diferença de -3 GTM
		System.out.println("----------------------");
		System.out.println("x1: " + sdf3.format(x1)); // Todos agora no formato UTC
		System.out.println("x2: " + sdf3.format(x2));
		System.out.println("x3: " + sdf3.format(x3));
		System.out.println("x4: " + sdf3.format(x4));
		System.out.println("y1: " + sdf3.format(y1));
		System.out.println("y2: " + sdf3.format(y2));
		System.out.println("y2: " + sdf3.format(y3));
	}

}
