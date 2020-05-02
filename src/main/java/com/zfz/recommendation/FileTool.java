package com.zfz.recommendation;

import org.springframework.data.relational.core.sql.In;

import java.io.*;

public class FileTool {
    private static String fileName = "D:\\web\\user.csv";
    private static String tmpFileName = "D:\\web\\tmp.csv";
    public boolean append(Integer userId, Integer book_id, Double rate) {
        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            fileWriter.write("\n");
            String tmp = userId.toString() + "," + book_id.toString() + "," + rate.toString();
            fileWriter.write(tmp);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean updateRate(Integer userId, Integer bookId, Double newRate) throws IOException {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFileName));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String item[] = line.split(",");
                if(Integer.getInteger(item[0]) == userId && Integer.getInteger(item[1]) == bookId){
                    String tmp = item[0] + "," + item[1] + "," + newRate.toString() + "\n";
                    bufferedWriter.write(tmp);
                }else
                    bufferedWriter.write(line+"\n");
            }
            bufferedWriter.close();
            bufferedReader.close();
            return true;

    }
}
