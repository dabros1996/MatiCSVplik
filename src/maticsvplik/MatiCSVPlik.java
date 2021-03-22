/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maticsvplik;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author dabro
 */
public class MatiCSVPlik {

        public static boolean isNumeric(String string) {
    int intValue;
		
   // System.out.println(String.format("Parsing string: \"%s\"", string));
		
    if(string == null || string.equals("")) {
       System.out.println("String cannot be parsed, it is null or empty.");
        return false;
    }
    
    try {
        intValue = Integer.parseInt(string);
        return true;
    } catch (NumberFormatException e) {
        System.out.println("Input String cannot be parsed to Integer.");
    }
    return false;
    }

    public static void main(String[] args) {
        ArrayList<String> Datalist=new ArrayList<String>();
        ArrayList<String> Datarow=new ArrayList<String>();
        int suma1=0,suma2=0;
        try
        {
        File csvFile =new File("plik.csv");
        
        Scanner scan=new Scanner(csvFile);        
        
        while(scan.hasNextLine())
        {                        
            String data=scan.nextLine();
            //System.out.print(data);
            String[] datarow=data.split(";");
            Datalist.add(data);
            for(int s=0;s<datarow.length;s++){
            Datarow.add(datarow[s]);
            }
                   
        }
        scan.close();
        }
        catch(FileNotFoundException e)
        {
             System.out.println("Blad");
             e.printStackTrace();
        }
         
        
        
        
        
        for(int l=0;l<Datarow.size();l++)
         {
            String[] row=Datarow.get(l).split(",");
              
            for(int q=0;q<row.length;q++)
            {           
              if(isNumeric(row[q]))
              {               
               int a=Integer.parseInt(row[q]);
               suma1+=a;               
              }
            }
        
         System.out.println("Suma lini "+l+" to "+suma1+" ");
         suma2+=suma1;
         suma1=0;
         if(l==Datarow.size()-1)
         {System.out.println("Całkowita suma to "+suma2+" ");}
         }
         
         // datarow to arraylist poszczególnych lini
         //datalist to arraylist całości pliku 
        
    }
}
        
    
    
    

        
        
    
    

