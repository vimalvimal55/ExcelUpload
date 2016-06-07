package com.vims.hello.ExcelReader;

import com.vims.hello.model.StudentDTO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnatarajan on 06/06/2016.
 */
@Component
public class ExcelReader {

    String fileName;

    List<StudentDTO> studentList;

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    FileInputStream fIP;

    public String SendEmails() {
        StringBuilder strbuil= new StringBuilder();
        try {

            strbuil.append("this is file name "+getFileName()+".xls"+"\n\n");

            File file = new File(getFileName()+".xls");
            String absolutePath = file.getAbsolutePath();
            strbuil.append("\n"+"absolute path is "+absolutePath);

            String filepath = getFileName()+".xls";
            String createdPath =absolutePath.replace(filepath,"/src/main/resources/"+filepath);
            strbuil.append("\n"+"createdPath path is "+createdPath);


            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(createdPath),true);
            HSSFSheet sheetOne = workbook.getSheetAt(0);
            int lastrownNum = sheetOne.getLastRowNum();
            strbuil.append("\n");
            strbuil.append("The rows in the file is "+lastrownNum+"\n");

            List<StudentDTO> studentList=new ArrayList<>();
            strbuil.append("\n The students added below \n");
            for(int i=1;i<=lastrownNum;i++){
                HSSFRow row = sheetOne.getRow(i);
                int cellnum = 0;
                int lastCell=row.getLastCellNum();

                StudentDTO studentDTO=new StudentDTO();
                studentDTO.setId(row.getCell(cellnum++).toString());
                studentDTO.setName(row.getCell(cellnum++).toString());
                studentDTO.setEmailid(row.getCell(cellnum).toString());
                studentList.add(studentDTO);
                strbuil.append("\n"+studentDTO.toString()+"\n");
            }
            this.setStudentList(studentList);
            return strbuil.toString();
        } catch (FileNotFoundException e) {
            strbuil.append(e.toString());
            strbuil.append("\n");
            e.printStackTrace();
        } catch (IOException e) {
            strbuil.append(e.toString());
            strbuil.append("\n");
            e.printStackTrace();
        }
        return strbuil.toString();
    }
}
