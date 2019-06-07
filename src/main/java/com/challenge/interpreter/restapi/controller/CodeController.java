package com.challenge.interpreter.restapi.controller;


import com.challenge.interpreter.restapi.model.CODE;
import com.challenge.interpreter.restapi.model.CODEReplay;
import com.challenge.interpreter.restapi.services.CreateWritefile;
import com.challenge.interpreter.restapi.services.ParseCompute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CodeController {
    public static String tem;
    @Autowired
    public ParseCompute pc;

    @Autowired
    public CreateWritefile WF;

    @RequestMapping(value = "/Execute", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> getlinecode(@RequestBody CODE code) {

        CODEReplay CR = new CODEReplay();
        //Postparssing
        if (code.getCode().substring(0, 1).equals("%")) {
            if (pc.Postparssing(code.getCode())) {
                if (code.getCode().substring(7, 8).equals(" ")) {

                   if(pc.coding(code.getCode())==true)
                   {
                       tem =  pc.parssingS(code.getCode());
                       System.out.println("AB"+tem);
                       CR.setResult("");
                   }
                   else{
                       if(pc.var(code.getCode())==true){
                           try {
                               System.out.println("ABC");
                               code.setCode(pc.parssing(code));
                               //Write into Variable File
                               WF.Createtemfile(code.getCode(),tem);
                               //Runtime exec of Variable File.
                               CR.setResult(pc.computevar());
                           }
                           catch (Exception e){
                               e.printStackTrace();
                           }
                        }
                       else{
                           try {
                               System.out.println("ABCD");
                               code.setCode(pc.parssing(code));
                               //Write into Variable File
                               WF.Createfile(code.getCode());
                               //Runtime exec of Variable File.
                               CR.setResult(pc.compute());
                           }
                           catch (Exception e){
                               e.printStackTrace();
                           }
                       }
                   }
                }
                else {
                    CR.setResult("WhiteSpace Required Before Code");
                }
            } else {
                CR.setResult("Interpreter Type Is Wrong");
            }
        } else {
            CR.setResult("% Required Before Interpreter Type");
        }

        HttpHeaders header = new HttpHeaders();
            return new ResponseEntity<>(CR,header,HttpStatus.OK);
    }
}