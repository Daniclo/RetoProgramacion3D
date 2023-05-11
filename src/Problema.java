import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Problema {
    static HashMap<String, Integer> letras = new HashMap<>();

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;

            /* Lectura y validación  de clave */
            Scanner sc = new Scanner(System.in);
            boolean flag = false;
            String claveValida = null;
            int errores = 0;
            while (!flag){
                errores = 0;
                System.out.println("Introduce la clave de cifrado:");
                String regex = "[A-z]";
                String claveSinValidar = sc.nextLine();
                for (int i=0;i<claveSinValidar.length();i++){
                    String c = String.valueOf(claveSinValidar.charAt(i));
                    if (!c.matches(regex)){
                        errores++;
                    }
                }
                if (errores==0){
                    flag=true;
                    claveValida = claveSinValidar;
                }else {
                    System.out.println("Error, introduce una clave válida, solo caracteres alfabéticos");
                }
            }

            //Asignar las letras a cada valor para el cifrado:
            letras.put("a",0);
            letras.put("b",1);
            letras.put("c",2);
            letras.put("d",3);
            letras.put("e",4);
            letras.put("f",5);
            letras.put("g",6);
            letras.put("h",7);
            letras.put("i",8);
            letras.put("j",9);
            letras.put("k",10);
            letras.put("l",11);
            letras.put("m",12);
            letras.put("n",13);
            letras.put("ñ",14);
            letras.put("o",15);
            letras.put("p",16);
            letras.put("q",17);
            letras.put("r",18);
            letras.put("s",19);
            letras.put("t",20);
            letras.put("u",21);
            letras.put("v",22);
            letras.put("w",23);
            letras.put("x",24);
            letras.put("y",25);
            letras.put("z",26);
            letras.put("A",0);
            letras.put("B",1);
            letras.put("C",2);
            letras.put("D",3);
            letras.put("E",4);
            letras.put("F",5);
            letras.put("G",6);
            letras.put("H",7);
            letras.put("I",8);
            letras.put("J",9);
            letras.put("K",10);
            letras.put("L",11);
            letras.put("M",12);
            letras.put("N",13);
            letras.put("Ñ",14);
            letras.put("O",15);
            letras.put("P",16);
            letras.put("Q",17);
            letras.put("R",18);
            letras.put("S",19);
            letras.put("T",20);
            letras.put("U",21);
            letras.put("V",22);
            letras.put("W",23);
            letras.put("X",24);
            letras.put("Y",25);
            letras.put("Z",26);
            int contadorCifrado=0;
            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());

                /* Aquí vendría la lógica del programa */
                for (int i=0;i<linea.length();i++){
                    String caracterMensaje = String.valueOf(linea.charAt(i));
                    if (contadorCifrado>=claveValida.length()){
                        contadorCifrado=0;
                    }
                    String caracterClave = String.valueOf(claveValida.charAt(contadorCifrado));
                    for (int c=0;c<letras.size();c++){
                        if (letras.containsKey(caracterClave)){
                            int ascii = (caracterMensaje.charAt(0) + letras.get(caracterClave));
                            //System.out.println(caracterMensaje.charAt(0) + " " + letras.get(caracterClave));
                            char caracter = (char) ascii;
                            sb.append(caracter);
                            break;
                        }
                    }
                    contadorCifrado++;
                }




                bw.write(sb.toString()); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */

            }
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}


