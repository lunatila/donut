import java.io.IOException;
import java.util.HashMap;
import java.lang.Math;

import static java.util.Arrays.fill;

public class donut {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Speed of rotation
        float A=0; //y-axis
        float B=0; //x-axis

        float i, j;
        float[] z = new float[7040];
        //MINHA TELA É 120X30
        char[] b = new char[1760];
        HashMap<Integer, Character> mapa = new HashMap<Integer, Character>();
        mapa.put(0, '.');
        mapa.put(1, ',');
        mapa.put(2, '-');
        mapa.put(3, '~');
        mapa.put(4, ':');
        mapa.put(5, ';');
        mapa.put(6, '=');
        mapa.put(7, '!');
        mapa.put(8, '*');
        mapa.put(9, '#');
        mapa.put(10, '$');
        mapa.put(11, '@');

        //Clear the console
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        while(true){
            fill(b, (char) 32);
            fill(z, (char) 0);

            for(j = 0f; j < 6.28f; j += 0.1f){
                for(i = 0f; 6.28 > i; i += 0.1f){
                    double sini=Math.sin(i),
                           cosj=Math.cos(j),
                           sinA=Math.sin(A),
                           sinj=Math.sin(j),
                           cosA=Math.cos(A),
                           cosj2=cosj+2,
                           mess=1/(sini*cosj2*sinA+sinj*cosA+5),
                           cosi=Math.cos(i),
                           cosB=Math.cos(B),
                           sinB=Math.sin(B),
                           t=sini*cosj2*cosA-sinj* sinA;
                    int x = (int)(40+30*mess*(cosi*cosj2*cosB-t*sinB)),
                            y = (int) (12+15*mess*(cosi*cosj2*sinB +t*cosB)),
                            o = x+80*y,
                            N = (int) (8*((sinj*sinA-sini*cosj*cosA)*cosB-sini*cosj*sinA-sinj*cosA-cosi *cosj*sinB));
                    if( 22>y && y>0 && x>0 && 80>x && mess>z[o] ){
                        z[o] = (float) mess;
                        b[o] = mapa.get(Math.abs(N));
                    }
                }
            }
            System.out.print("\033[d");
            System.out.flush();
            for(int k = 0; 1760 > k; k++)
                System.out.print(b[k]);
            A+=0.2;
            B+= 0.1;
        }
    }
}
