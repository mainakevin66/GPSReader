/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gpsreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class GpsReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        String filepath = "C:\\GPS\\input.txt";
        
        separateString(FileReader(filepath));
        
        long endTime = System.nanoTime();
        
        System.out.println();
        System.out.println("The program took: " +(startTime - startTime) + " ns");
    }

    public static String FileReader(String filepath) throws IOException, ArrayIndexOutOfBoundsException {
        try {
            BufferedReader read = new BufferedReader(new FileReader(new File(filepath)));
            String line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
                System.out.println();
                return line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;


    }

    public static void separateString(String coord) throws IOException, ArrayIndexOutOfBoundsException {
        
        String[] str1;
        String delimeter = ",";
        int i;
        str1 = coord.split(delimeter);
        
        String[] constants = 
        {
            " = Global Positioning System Fix Data",
            " = UTC of position ",
            " = latitude of position",
            " = N or S",
            " = Longitude of position",
            " = E or W",
            " = GPS Quality indicator (0=no fix, 1=GPS fix, 2=Dif. GPS fix) ",
            " = number of satellites in use ",
            " = horizontal dilution of precision",
            " = Antenna altitude above mean-sea-level",
            " = units of antenna altitude, meters ",
            " = Geoidal separation",
            " = units of geoidal separation, meters",
            " = Age of Differential GPS data (seconds)",
            "= Checksum"
        };
        
        for (i = 0; i < str1.length ; i++)
        {
            System.out.print( i +" :");
            System.out.print(str1[i]);
            System.out.println(constants[i]);
        }

    }
}
