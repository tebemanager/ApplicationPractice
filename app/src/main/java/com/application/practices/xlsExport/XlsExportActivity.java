package com.application.practices.xlsExport;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.application.practices.databinding.XlsExportActivityBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Charles Raj I on 26/02/23.
 *
 * @author Charles Raj I
 */
public class XlsExportActivity extends AppCompatActivity implements ExportInterface {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        var xlsExportActivityBinding = XlsExportActivityBinding.inflate(getLayoutInflater());
        setContentView(xlsExportActivityBinding.getRoot());


        xlsExportActivityBinding.saveExcel.setOnClickListener(view -> {

            List<XlsMode> xlsModeList = new ArrayList<>();

            xlsModeList.add(new XlsMode("1","James", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("2","Kindlsy", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("3","Wesley", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("4","Aberaham", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("5","Mari", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("6","Durai", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("7","Livingstron", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("8","Bravo", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("9","Wex", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("10","Cloe", "X","2","12","Male","a"));
            xlsModeList.add(new XlsMode("11","Vertex", "X","2","12","Male","a"));

            Gson gson = new Gson();
            var jsonArray = gson.toJsonTree(xlsModeList).getAsJsonArray();

            String[] titles = new String[]{"ID", "Name", "Class", "Bench", "Age", "Gender","Grade"};
            String[] indexName = new String[]{"studentId", "studentName", "studentClass", "studentBench", "studentAge", "studentGender","studentGrade"};

            HashMap<String, String> otherValue  = new HashMap<>();
            otherValue.put("Record", "Student Record");
            otherValue.put("Place", "Campus City");
            otherValue.put("City", "Toranto");


            var file = generateXlsFile(this, titles,indexName,jsonArray,otherValue,"Student Record","students",1);


        });

    }
}
