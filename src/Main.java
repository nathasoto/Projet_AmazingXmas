import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class Main {
    public static void main(String[] args) {

        double[][] coordinates = {
                {45.171112, 5.695952},
                {45.183152, 5.699386},
                {45.174115, 5.711106},
                {45.176123, 5.722083},
                {45.184301, 5.719791},
//                {45.184252,5.730698},
//                {45.170588,5.716664},
//                {45.193702,5.691028},
//                {45.165641,5.739938},
//                {45.178718,5.744940},
//                {45.176857,5.762518},
//                {45.188512,5.767172},
//                {45.174017,5.706729},
//                {45.174458,5.687902},
//                {45.185110,5.733667},
//                {45.185702,5.734507},
//                {45.184726,5.734666},
//                {45.184438,5.733735},
//                {45.184902,5.735256},
//                {45.174812,5.698095},
//                {45.169851,5.695723},
//                {45.180943,5.698965},
//                {45.176205,5.692165},
//                {45.171244,5.689872}
        };

        boolean[] visited = {
                false,
                false,
                false,
                false,
                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
//                false,
        };

        double[][] matrizGPS = creater_matriz(coordinates);
        showMatriz(matrizGPS);


        int ville2=0;
        int ville = matrizGPS.length-1;

        while(ville > 0){

            ville2 = pluCourtNomVisited(ville2, visited, matrizGPS);

           ville--;
        }



    }

    public static double haversine(double lat1, double lon1,
                                   double lat2, double lon2) {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

    public static double[][] creater_matriz(double coordinates[][]) {

        double[][] matrizGPS = new double[5][5];
        for (int i = 0; i < coordinates.length; i++) {

            for (int j = 0; j < coordinates.length; j++) {

                double lat1 = coordinates[i][0];
                double lon1 = coordinates[i][1];

                double lat2 = coordinates[j][0];
                double lon2 = coordinates[j][1];

                matrizGPS[i][j] = haversine(lat1, lon1, lat2, lon2);
            }

        }

        return matrizGPS;

    }

    public static void showMatriz(double matrizGPS[][]) {

        for (int x = 0; x < matrizGPS.length; x++) {
            for (int y = 0; y < matrizGPS[x].length; y++)
                System.out.print(" | " + matrizGPS[x][y] + " | ");
            System.out.println("\n----------------------------------------------------------------");

        }

    }

    public static int pluCourtNomVisited(int villeActuel, boolean[] visited, double matrizGPS[][]) {


        visited[villeActuel] = true;
        double pp = 1000000;
        int ipp = 0;

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i] && (matrizGPS[villeActuel][i] < pp)) {
                pp = matrizGPS[villeActuel][i];
                ipp = i;

            }

        }
        System.out.println(ipp);
        return ipp;

    }


}