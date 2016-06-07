package com.vims.hello;

import com.vims.hello.ExcelReader.ExcelReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vnatarajan on 05/06/2016.
 */
@RestController
public class Hellocontroller {

    @Autowired
    ExcelReader excelReader;

    @RequestMapping(value="/hello", method = RequestMethod.GET, produces = "text/plain")
    public String downloadExcel() {
        return "Greetings from Spring Boot! from hello ";
    }


    @RequestMapping(value="/", method = RequestMethod.GET, produces = "text/plain")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/sendEmail", method = RequestMethod.GET, produces = "text/plain")
    public String sendEmail(@RequestParam(required = false) String fileName ) {
        excelReader.setFileName(fileName);
        String outputString = excelReader.SendEmails();
        return outputString;
    }



}
