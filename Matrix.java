import java.io.*;
import java.util.PriorityQueue;

import static java.lang.System.exit;

/**
 * Created by ashleyjain on 22/08/16.
 */
public class Matrix {

    static BufferedWriter bw;

    public static void main(String args[]) throws IOException {

        //read from input file
        BufferedReader br = null;

        File file = new File("output.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        //writer of output file
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        bw = new BufferedWriter(fw);

        String actionString;
        br = new BufferedReader(new FileReader("input.txt"));
        actionString = br.readLine();
        int num = Integer.parseInt(actionString);
        int row[] = new int[num];
        int col[] = new int[num];

        //for checking
        int row2[] = new int[num];
        int col2[] = new int[num];

        int rsum,csum;
        rsum=csum=0;

        actionString = br.readLine();
        String[] rowSt = actionString.split(",");
        actionString = br.readLine();
        String[] colSt = actionString.split(",");

        PriorityQueue<Entry> colum = new PriorityQueue<>();
        PriorityQueue<Entry> colum2 = new PriorityQueue<>();
        PriorityQueue<Entry> tmp = new PriorityQueue<>();



        for(int i=0;i<num;i++){
            row[i] = Integer.parseInt(rowSt[i]);
            rsum+=row[i];
            col[i] = Integer.parseInt(colSt[i]);
            csum+=col[i];
            colum.add(new Entry(col[i],i));

            if(row[i]>num||col[i]>num){
                bw.write("0",0,1);
                bw.close();
                //System.out.println("0");
                exit(0);
            }
        }

        //for checking
        for(int i=0;i<num;i++){
            row2[i]=row[i];
            col2[i]=col[i];
        }

        if(rsum!=csum){
            bw.write("0",0,1);
            //System.out.println("0");
            bw.close();
            exit(0);
        }

//        System.out.println(colum.remove().getValue());
        int A[][] = new int[num][num];


        for(int i=0;i<num;i++){
            colum.addAll(colum2);
            colum2 = new PriorityQueue<>();
                while(row[i]!=0){
                    Entry max = colum.remove();
                    //System.out.println("Entry: "+max.getKey()+","+max.getValue());
                    A[i][max.getValue()]++;
                    int maxkey = max.getKey();
                    colum2.add(new Entry(--maxkey,max.getValue()));
                    row[i]--;
                }
        }

        //for checking
        int srow,scol;
        srow=scol=0;
        for(int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                srow+=A[i][j];
            }
            if(srow!=row2[i]) {
                bw.write("0",0,1);
                bw.close();
                //System.out.println("0");
                exit(0);
            }
//            else{
//                System.out.println(srow);
//            }
            srow = 0;
        }
        for(int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                scol+=A[j][i];
            }
            if(scol!=col2[i]) {
                bw.write("0",0,1);
                bw.close();
                //System.out.println("0");
                exit(0);
            }
//            else{
//                System.out.println(scol);
//            }
            scol=0;
        }

        //output whole matrix
        bw.write("1\n",0,2);
        //System.out.println("1");

        String matrixToString = "";
        for(int i=0;i<num;i++) {
            for (int j = 0; j < num; j++) {
                matrixToString+=A[i][j];
                //System.out.print(A[i][j]);
                if(j!=num-1)
                    matrixToString+=",";
                    //System.out.print(",");
            }
            matrixToString+="\n";
            //System.out.print("\n");
        }
        bw.write(matrixToString,0,matrixToString.length());
        bw.close();

    }

}