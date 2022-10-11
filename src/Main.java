import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanInput;
        try {
            FileReader input = new FileReader("input.txt");
            scanInput = new Scanner(input);
        } catch (FileNotFoundException e){
            System.out.println(Errors.ERR_NO_SUCH_FILE.getText());
            return;
        }

        //read banner and table size
        int n,m;
        try {
            String firstLine = scanInput.nextLine();
            String[] size = firstLine.split(" ");
            n = Integer.parseInt(size[0]);
            m = Integer.parseInt(size[1]);
        } catch (Exception e) {
            System.out.println(Errors.ERR_INCORRECT_FORMAT.getText());
            return;
        }

        //read banner data
        char[][] banner = new char[n][m];
        try {
            for (int i = 0; i < n; i++) {
                String inputLine = scanInput.nextLine();
                for (int j = 0; j < m; j++) {
                    banner[i][j] = inputLine.charAt(j);
                    System.out.print(banner[i][j]);
                }
                System.out.println();
            }
        }catch (Exception e) {
            System.out.println(Errors.ERR_INCORRECT_FORMAT.getText());
            return;
        }

        //read table data
        byte[][] table = new byte[n][m];
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    table[i][j] = scanInput.nextByte();
                    System.out.print(table[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e){
            System.out.println(Errors.ERR_INCORRECT_FORMAT.getText());
            return;
        }

        //check possibility
        String result = "YES";
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                PixelType pxl;
                try {
                    pxl = PixelType.valueOf("N" + table[i][j]);
                } catch (Exception e){
                    System.out.println(Errors.ERR_INCORRECT_FORMAT.getText());
                    return;
                }
                if (!pxl.checkColour(banner[i][j])) {
                    result="NO";
                    break;
                }
            }
            if (result.equals("NO")) break;
        }

        //write result
        try {
            FileWriter output = new FileWriter("output.txt");
            output.write(result);
            output.close();
        } catch (Exception e) {
            System.out.println(Errors.ERR_CAN_NOT_WRITE.getText());
            return;
        }
        System.out.println(result);

        scanInput.close();
    }
}