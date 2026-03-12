import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Clase2 {

/*
Datos primitivos: int, byte, long, float, double, char
Objetos: String

Clases: Archivo mínimo necesario para albergar código, todo el código esta dentro de clases. Representan parte del problema que queremos solucionar con un software.
Lo que hay en la BBDD tiene que verse representado en el código mediante clases. En cada clase creas objetos, la clase es el "molde"
a través del cuál creas distintos objetos.
    - Principales -> Vive y ejecuta código directamente
    -
En este caso el objetivo no es crear objetos, sino crear un código y ejecutarlo. Es una clase principal.

[] Atributos de una clase: Variables para guardar datos y memoria, nos permiten realizar las funciones que queremos que realice la clase.
[] Constante: variables que no pueden ser modificadas una vez que han sido asignadas. SIEMPRE EN MAYÚSCULA
    - final -> Le damos un valor y lo que declaramos a continuación es una constante, no pueden cambiar en ejecución y hay que inicializaralas obligatoriamente.
    Para poder hacer referencia por ejemplo a NOTA_APROBADO, tendría que crear un objeto de la clase: "Clase2.NOTA_APROBADO"
    - static -> Me permite utilizar variables, constantes y funciones sin necesidad de crear objetos, pertenecen a la clase, no hace falta crear un objeto.
    Es superior a cualquier objeto creado. Imagina que tenemos.
    1 Clase Coche
    1.1 String marca        Para poder definir estos strings tengo que crear una objeto pero con static, la variable creada es superior
    1.2 String modelo       a estos objetos. Por ejemplo -> static int num_coches es superior a los objetos, no depende de ellos, depende de la clase "coches".
                            Esta superioridad se la da la palabra static, hace que sea independiente de creación de objetos, pertenece a la clase.
                            Para poner un ejemplo, sería como la propiedad "nº alumno" que es genérica, y el propio número de cada alumno.


----------
(double) siempre para décimales para no forzar la f de float
Compiladores lineales/secuenciales: leen el código de arriba a abajo, si la función no la declaras encima de donde la utilizas no funcionaría, como en C, C++, Javascript.
Babeling? -> La función sube de abajo a arriba. En Java no, hace una lectura global y reconoce todas las funciones.
Sobrecarga de funciones -> Permite definir múltiples funciones con el mismo nombre dentro de una clase siempre que tengan distintos parámetros
Las funciones nos permiten que si cambia el nombre/lógica de este código sólo la cambiamos una vez y no en cada una de las veces que se utiliza. Por ej: el sout en sí es una función.
Las variables y parámetros de entrada solo existen dentro de la función, no se pueden referenciar fuera.
clic derecho -> Go To -> Implementations [Para ver de donde viene o donde está referenciada la función]
Debug -> Ir paso a paso en el código viendo lo que pasa.
 */

    static final double NOTA_APROBADO = 5.0; // double por que puede ser decimal, siempre se pone en decimal. Static por que sino no se podría hacer referencia a esta variable en "Clase2" sin previamente crear un objeto dentro de "Clase2".
    static final double IVA = 0.10;
    static final double PRECIO_BASE = 500.0;
    static final double DESC_FAM_NUM = 0.10;

    // Esto en el futuro se realizará con SQL y vendrá de una BBDD, ahora mismo lo estamos haciendo "a machete" todo.
    static final int MAYORIA_EDAD = 18;

    static String nombre;                     // String -> Vector de caracteres, sirve para meter texto (letras y números) pero no opera matemáticamente con los números, es un identificador. Al no ser constante, puedo pedirlo después al usuario.
    static int edad;                          // int -> Números enteros
    static String apellido;
    static double nota1;                      // Double -> Decimales
    static double nota2;
    static double nota_media;

    static boolean familiaNumerosa;           // Boolean -> True (1) or False(0). Se utilizan para hacer evaluaciones.

    /* ====================================================================
       Scanner -> clase que sirve para leer datos que introduce el usuario
       --------------------------------------------------------------------
       new -> Crear nuevo objeto
       System.in -> Entra información
       Lo declaro para poder meter contenido a través del teclado.
       ==================================================================== */

    /**
     * Objeto -> Parte generada por una clase nativa de Java. Scanner = clase nativa/función de Java.
     */
    static Scanner sc = new Scanner(System.in);

    static void main() {                      // Abreviatura "psvm"
        saludar();                            // Llama a la función "saludar".
        saludar("Pepe");              // Sabe que se refiere a la segunda función de saludar ya que tiene el parámetro de entrada con String. Tiene que coincidir en tipo y número que haya definido.
        System.out.println(saludar("Pepe", "Rodríguez"));   // Método saludar(string, string). Devuelve solo string, por eso lo imprimimos con println. Sino se queda en memoria y no pasa nada.
        leerDatos();
        System.out.println(nombre);           // Ponemos la variable nombre que es la que hemos declarado en leerDatos, la que detecta lo que se ha introducido por teclado.
        saludar(nombre);                      // Se utiliza el primer saludar ya que no tiene parámetros de entrada que coincidan con los otros.
        saludar(nombre, "Korner");
        System.out.println(saludar(nombre, "Korner"));  // La función sin el sout no devuelve el apellido ya que dentro de la función "saludar(string, string)" no pone sout, sino return.
    }


    /**
     * Función -> Acción ya definida, Código que se va a repetir FUERA del main, ya que main es otra función.
     * Con void = La función no devuelve nada, sólo va a ejecutar el código, le ofrece sólo lo que hay dentro.
     */
    static void saludar() {
        System.out.println("Hola");
    }


    static void saludar(String nombre) {             // Función con parámetros de entrada -> Ponemos tipo de dato "String", y la variable "nombre" sólo se mantiene dentro de esta función, es un parámetro de esta función y es totalmente independiente de todo lo que hay en el exterior.
        System.out.println("Hola " + nombre);        // Operación de concatenación de Strings
    }

    static String saludar(String nombre, String apellido) {            // Cambio "void" -> "String": Nos devuelve un String. No es suficiente para que lo distinga del "saludar" anterior. La sobrecarga sólo afecta en los parámetros de entrada, no de salida. Añadimos un segundo parámetro para que puedan convivir las 3.
        String mensaje = "Hola " + nombre + " " + apellido + "!";      // Me debe devolver un String, por lo que le quito el sout, y declaramos String mensaje.
        return mensaje;                                                // return -> Como nos tiene que devolver un string, nos lo manda. Lo que pongo en el return tiene que coincidir con el tipo de dato que le digo que me tiene que devolver.
    }


    /* =====================================================
       Sesión 3 - 03/03/2026
       -----------------------------------------------------
       if -> sentencias de control, evalúan si algo es verdadero o falso
       if verdadero = 1 camino
       if falso = otro camino
       ===================================================== */


    /**
     * Lo que declare en una función solo vive en la función, pero dentro de esta función puedo hacer referencia a variables que están declaradas fuera.
     */

    /* =====================================================
       Función/Método leerDatos
       -----------------------------------------------------
       Lee información del usuario
       Objeto = sc
       Clase = scanner y system
       Variables = nombre y edad
       ===================================================== */
    static void leerDatos() {

        //Mostramos mensaje solicitando nombre

        System.out.println("Nombre: ");

        // nextLine() lee una línea completa de texto, límite 255 caracteres.
        // Guardamos valor en la variable "nombre"
        nombre = sc.nextLine().trim();

    /*  -----------------------------------------------------
        Obligar a que introduzca nombre
        -----------------------------------------------------
        while -> Programa no avanza hasta que introduzca un nombre
        .isBlank -> Detecta si hay espacios en blanco
        .trim -> Limpia espacios de las esquinas antes de validar
        -----------------------------------------------------   */
        while(nombre.isBlank()){
            System.out.println("Introduce el nombre.");
            nombre = sc.nextLine().trim();
        }

    /*  -----------------------------------------------------
        Comparar información
        -----------------------------------------------------
        .equals -> compara contenido, para objetos
        == -> compara dirección de memoria, para valores primitivos
        Primitivos guardan el valor real -> int X = 5; en la RAM, la variable X es igual a 5. Pero (continua abajo)
        Objetos guarda la dirección donde se encuentra el contenido -> String X = Enrique; en la RAM, X = (dirección de memoria donde se encuentra "Enrique")
        -----------------------------------------------------   */

        if (nombre.equals("pepe)")){
            System.out.println("es pepe");
        }

        System.out.println("Apellido: ");
        apellido = sc.nextLine().trim();
        //Leemos la edad
        System.out.println("Edad: ");

        // nextInt sólo admite enteros
        edad = sc.nextInt();

    /*  =====================================================
        if
        -----------------------------------------------------
        Con 2 bifurcaciones
        if (edad < 18) {
            System.out.println("Es menor de edad");
        } else {
            System.out.println("Es mayor de edad");
        }

        Con más de 2 -> else if
        Cuando hay demasiadas opciones y el código se acompleja demasiado, se sustituye if por un switch -> case
        =====================================================
        */

        // si quiero 3 opciones
        if (edad < MAYORIA_EDAD) {
            System.out.println("Es menor de edad");
        } else if (edad < 55) {
            System.out.println("Es de mediana edad");
        } else {
            System.out.println("Es de edad avanzada");
        }

    /*  =====================================================
        Calcular media
        -----------------------------------------------------
        Al no ser enteros sino decimales, se pone nextDouble.
        =====================================================
        */
        System.out.println("Introduce nota 1: ");
        nota1 = sc.nextDouble();
        System.out.println("Introduce nota 2: ");
        nota2 = sc.nextDouble();

    /*  =====================================================
        printf
        -----------------------------------------------------
        Permite imprimir el texto + variables y controlar el formato de salida
        %f -> Indica el tipo (double o float)
        .2 -> Indica número de decimales
        %n -> Salta de línea al terminar
        %s -> String (si quiero que los imprima en mayúscula pongo la S en mayúscula sin modificar variable original)
        =====================================================
        */
        nota_media = (nota1 + nota2) /2;
        System.out.printf("La nota media del alumno %S %S es de: %.2f%nEnr", nombre, apellido, nota_media);



    }

}





