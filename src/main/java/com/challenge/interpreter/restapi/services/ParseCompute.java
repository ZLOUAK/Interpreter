package com.challenge.interpreter.restapi.services;


import com.challenge.interpreter.restapi.model.CODE;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;


@Service
public class ParseCompute {

    public String parssing(CODE code) {
        return code.getCode().substring(8);
    }

    public String parssingS(String code) {
        return code.substring(8);
    }
    public boolean Postparssing(String code) {
        return code.substring(1,7).toUpperCase().equals("PYTHON");

    }
    public Boolean var(String code) {
        if (code.indexOf("a")!=-1) {
            return true;
        }
        return false;
    }
    public Boolean coding(String code) {
        if (code.indexOf("=")!=-1) {
            return true;
        }
        return false;
    }

    public String compute() {

        String Path="/home/Devloper/Public/Interpreter/python.py";
        String var=null;
        String err=null;
        try {
            Process PI = Runtime.getRuntime().exec("python "+ Path);
            BufferedReader inp = new BufferedReader(new InputStreamReader(PI.getInputStream()));
            BufferedReader oup = new BufferedReader(new InputStreamReader(PI.getErrorStream()));
            var = inp.readLine();
            inp.close();
            if(var==null){
                err= oup.readLine();
                var=err;
                oup.close();
            }
        }//Read any errors from the attempted command exit
        catch (Exception e) { e.printStackTrace(); }
        return var;
    }
    public String computevar() {

        String Path="/home/Devloper/Public/Interpreter/pythontem.py";
        String var=null;
        String err=null;
        try {
            Process PI = Runtime.getRuntime().exec("python "+ Path);
            BufferedReader inp = new BufferedReader(new InputStreamReader(PI.getInputStream()));
            BufferedReader oup = new BufferedReader(new InputStreamReader(PI.getErrorStream()));
            var = inp.readLine();
            inp.close();
            if(var==null){
                err= oup.readLine();
                var=err;
                oup.close();
            }
        }//Read any errors from the attempted command exit
        catch (Exception e) { e.printStackTrace(); }
        return var;
    }
}