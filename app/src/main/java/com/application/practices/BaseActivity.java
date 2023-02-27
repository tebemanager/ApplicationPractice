package com.application.practices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.practices.bottomNavigationOne.BottomNavOne;
import com.application.practices.coinToss.PractiseActivity;
import com.application.practices.databinding.BaseActivityBinding;
import com.application.practices.databinding_Sqlite.addUser.AddUserDetailsActivity;
import com.application.practices.mvvmDemo.view.MainActivity;
import com.application.practices.sha_256.Sha_256;
import com.application.practices.xlsExport.XlsExportActivity;
import com.application.practices.xml_pdf.XmlToPdf;

/**
 * Created by Charles Raj I on 07/05/22.
 *
 * @author Charles Raj I
 */
public class BaseActivity extends AppCompatActivity {

    Activity activity;
    BaseActivityBinding baseActivityBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = BaseActivity.this;
        baseActivityBinding = BaseActivityBinding.inflate(getLayoutInflater());
        setContentView(baseActivityBinding.getRoot());


        baseActivityBinding.mvvmDemo.setOnClickListener(view -> {
            Intent tossIntent = new Intent(activity, MainActivity.class);
            startActivity(tossIntent);
        });

        baseActivityBinding.coinToss.setOnClickListener(view -> {
            Intent tossIntent = new Intent(activity, PractiseActivity.class);
            startActivity(tossIntent);
        });

        baseActivityBinding.bottomNavOne.setOnClickListener(view -> {
            Intent bottomOne = new Intent(activity, BottomNavOne.class);
            startActivity(bottomOne);
        });

        baseActivityBinding.sha256.setOnClickListener(view -> {
            Intent bottomOne = new Intent(activity, Sha_256.class);
            startActivity(bottomOne);
        });
        baseActivityBinding.xmlPdf.setOnClickListener(view -> {
            Intent xmlPdfIntent = new Intent(activity, XmlToPdf.class);
            startActivity(xmlPdfIntent);
        });
        baseActivityBinding.sqlDatabindingRxjava.setOnClickListener(view -> {
            Intent sqliteDataBinding = new Intent(activity, AddUserDetailsActivity.class);
            startActivity(sqliteDataBinding);
        });

        baseActivityBinding.xlsExport.setOnClickListener(view -> {
            Intent xlsIntent = new Intent(activity, XlsExportActivity.class);
            startActivity(xlsIntent);
        });

    }
}
