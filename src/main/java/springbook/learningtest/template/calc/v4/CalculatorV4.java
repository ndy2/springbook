package springbook.learningtest.template.calc.v4;

import springbook.learningtest.template.calc.v3.BufferedReaderCallback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorV4 {

    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br =null;
        try{
            br = new BufferedReader(new FileReader(filepath));
            int ret = callback.doSomethingWithReader(br);
            return ret;
        }catch(IOException e){
            System.out.println(e.getMessage());
            throw e;
        }finally{
            if(br!=null){
                try{br.close();}
                catch (IOException e){System.out.println(e);}
            }
        }
    }

    public Integer calcSum(String filepath) throws IOException {
        BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                Integer sum = 0;
                String line = null;
                while((line=br.readLine())!=null){
                    sum+=Integer.valueOf(line);
                }
                return sum;
            }
        };

        return fileReadTemplate(filepath,sumCallback);
    }

    public Integer calcMul(String filepath) throws IOException {
        BufferedReaderCallback mulCallback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
                Integer mul = 1;
                String line = null;
                while((line=br.readLine())!=null){
                    mul*=Integer.valueOf(line);
                }
                return mul;
            }
        };

        return fileReadTemplate(filepath, mulCallback);
    }
}
