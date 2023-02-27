package com.application.practices.sha_256;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.practice.databinding.Sha256LayoutBinding;

import java.security.MessageDigest;

/**
 * Created by Charles Raj I on 25/06/22.
 *
 * @author Charles Raj I
 */
public class Sha_256 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Sha256LayoutBinding sha256LayoutBinding = Sha256LayoutBinding.inflate(getLayoutInflater());
        setContentView(sha256LayoutBinding.getRoot());

        sha256LayoutBinding.convert.setOnClickListener(view -> {
            String value = generateHashString(sha256LayoutBinding.shaDate.getText().toString(), sha256LayoutBinding.shaSalt.getText().toString());

            sha256LayoutBinding.shaOutput.setText(value);
        });

        


    }

    public String generateHashString(String data, String salt){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            byte[] shaData;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            /*Adding salt to the encoding process...*/
            messageDigest.update(salt.getBytes());
            shaData = messageDigest.digest(data.getBytes());
            Log.d("TAG", "generateHashString: --- " + shaData);

            StringBuilder hexString = new StringBuilder(2 * shaData.length);
            for (byte shaDatum : shaData){
//                stringBuilder.append(Integer.toString((shaDatum & 0xff) + 0x100, 16 ));
                String hex = Integer.toHexString(0xff & shaDatum);
                if (hex.length() == 1){
                    hexString.append("0");
                }
                hexString.append(hex);
                stringBuilder = hexString;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
