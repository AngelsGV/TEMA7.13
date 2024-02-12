
 //       En el momento de decorar una casa, una habitación o cualquier objeto, se plantea el problema de
 //       elegir la paleta de colores que vamos a utilizar en nuestra decoración. Existe una solución,
 //       algo atrevida, que consiste en utilizar colores al azar. Diseña la clase Colores, que alberga
 //       por defecto una serie de colores (mediante una cadena), aunque es posible añadir tantos como
 //       necesitemos. La clase tendrá un método que devuelve una tabla con los n colores que necesitemos
 //       elegidos al azar sin repeticiones.
 //       Ademas de diseñar la clase tendrás que hacer el programa en java que la utilice para crearla,
 //       añadir colores y mostrar los n colores solicitados por el decorador
                package ;

import java.util.Arrays;
import java.util.Random;

public class Colores {

    // Array para almacenar la paleta de colores.
    private String[] colorsPalette;
    // Contador para llevar la cuenta de cuántos colores hay actualmente en la paleta.
    private int contColors;

    // Constructor de la clase. Se invoca al crear una instancia de Colors.
    public Colores() {
        // Inicializa el array con un conjunto predeterminado de colores.
        this.colorsPalette = new String[]{"Granate", "Verde", "Azul", "Amarillo", "Blanco", "Beige", "Gris", "Negro"};
        // Inicializa el contador con el número de colores predeterminados.
        contColors = colorsPalette.length;
    }

    // Método para añadir un nuevo color a la paleta.
    public void addColor(String newColor){
        // Verifica si es necesario expandir el array (esto siempre será cierto como está escrito).
        if (contColors == colorsPalette.length){
            // Crea un nuevo array más grande y copia los colores existentes.
            colorsPalette = Arrays.copyOf(colorsPalette, contColors + 1);
            // Añade el nuevo color en la siguiente posición disponible.
            colorsPalette[contColors] = newColor;
            // Incrementa el contador para reflejar el nuevo total de colores.
            contColors++;
        }
    }

    // Método que comprueba si un elemento está en el array
    public boolean checkIfSelected(String[] arrayElements, String element) {
        for (int i = 0; i < arrayElements.length; i++) {
            if (arrayElements[i] != null && arrayElements[i].equals(element)) {
                // Si encuentra el elemento, retorna true inmediatamente.
                return true;
            }
        }
        // Retorna false si el bucle termina sin encontrar el elemento.
        return false;
    }

    public String[] getRandomColors(int nColors){
        // Inciar una instancia de la clase random de Java
        Random random = new Random();
        // Inciar un array que se rellenará de colores selecionados al azar
        String[] selectedRandomColors = new String [nColors];
        // Iniciar un contador para los colores seleccionados
        int contRandomColors = 0;

        // Bucle while que se ejecuta mientras el numColors es menor que el total de libros del array randomizado
        while ( contRandomColors < nColors ){
            // Generar un inidce random dentro del array total de colores
            int randomIndexColor = random.nextInt(contColors);

            // Almacenar en un String el color que está en la posicion seleceionada por el randomIndex
            String newColor = colorsPalette[randomIndexColor];

            //Comprobar en el array selectedRandomColors si el color generado existe
            if(!checkIfSelected(selectedRandomColors, newColor)){
                // si no existe se añade al arra de colores al azar
                selectedRandomColors[contRandomColors] =  newColor;
                // aumentar en 1 el contador del array de colores al azar
                contRandomColors++;
            }
        }
        // Devolver el array de colores selecionados al azar
        return selectedRandomColors;
    }
}