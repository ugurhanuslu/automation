package com.ugurhan.beymen.manager;
import java.io.*;

public class TextFileManager {
        public static void WriteLine(String productName, String price) {
            String fileName = "productDetails.txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write("Product Name: " +productName+ ", Product Price: " +price );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


