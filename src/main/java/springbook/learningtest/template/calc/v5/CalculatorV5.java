package springbook.learningtest.template.calc.v5;

import springbook.learningtest.template.calc.v3.BufferedReaderCallback;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorV5 {

    public Integer lineReadTemplate(String filepath, LineCallBack callBack, int initVal) throws IOException {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filepath));
            Integer res = initVal;
            String line = null;
            while((line = br.readLine())!=null){
                    res = callBack.doSomethingWithLine(line,res);
            }

            return res;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        }finally {
            if(br!=null){
                try{br.close();}
                catch (IOException e){System.out.println(e);}
            }
        }
    }

    public Integer calcSum(String filepath) throws IOException {
        LineCallBack sumCallback = new LineCallBack() {

            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value + Integer.valueOf(line);
            }
        };

        return lineReadTemplate(filepath,sumCallback,0);
    }

    public Integer calcMul(String filepath) throws IOException {
        LineCallBack mulCallback = new LineCallBack() {

            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value * Integer.valueOf(line);
            }
        };

        return lineReadTemplate(filepath,mulCallback,1);
    }
}
