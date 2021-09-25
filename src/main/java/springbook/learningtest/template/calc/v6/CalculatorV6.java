package springbook.learningtest.template.calc.v6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorV6 {

    public <T> T lineReadTemplate(String filepath, LineCallBack<T> callBack, T initVal) throws IOException {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(filepath));
            T res = initVal;
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

    public String concat(String filepath) throws IOException {
        LineCallBack<String> concatCallback =
                new LineCallBack<String>() {
                    @Override
                    public String doSomethingWithLine(String line, String value) {
                        return value+line;
                    }
                };

        return lineReadTemplate(filepath,concatCallback,"");
    }
}
