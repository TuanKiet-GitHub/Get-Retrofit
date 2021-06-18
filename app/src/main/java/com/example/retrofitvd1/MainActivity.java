package com.example.retrofitvd1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofitvd1.AIP.ApiService;
import com.example.retrofitvd1.Model.Currency;
import com.example.retrofitvd1.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   private  ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallApi();
            }
        });
        binding.btnGet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallApi2();
            }
        });
        binding.btnGet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallApi3();
            }
        });

    }
    // Link API :http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    private void clickCallApi3() {
            Map<String,String> options = new HashMap<>();
            options.put("access_key","843d4d34ae72b3882e3db642c51e28e6");
            options.put("currencies","VND");
            options.put("source","USD");
            options.put("format","1");
        ApiService.apiService.convertVersion4(options).enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Toast.makeText(MainActivity.this , "Success" , Toast.LENGTH_LONG).show();
                Currency currency = response.body();
                binding.tvSucces.setText(currency.isSuccess() + "");
                binding.tvCode.setText(currency.getError().getCode() + "1");
                binding.tvInfo.setText(currency.getError().getInfo() + "2");
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Error" , Toast.LENGTH_LONG).show();
                Log.e("Log" ,   "Fail");
            }
        });
    }

    private void clickCallApi2() {
        ApiService.apiService.convertVersion1().enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Toast.makeText(MainActivity.this , "Success" , Toast.LENGTH_LONG).show();
                Currency currency = response.body();
                binding.tvSucces.setText(currency.isSuccess() + "");
                binding.tvCode.setText(currency.getError().getCode() + "1");
                binding.tvInfo.setText(currency.getError().getInfo() + "2");
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Error" , Toast.LENGTH_LONG).show();
                Log.e("Log" ,   "Fail");
            }
        });
    }

    // Link API :http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    private void clickCallApi() {
        ApiService.apiService.convertAIP("843d4d34ae72b3882e3db642c51e28e6", "VND","USD",1)
        .enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Toast.makeText(MainActivity.this , "Success" , Toast.LENGTH_LONG).show();
                 Currency currency = response.body();
                binding.tvSucces.setText(currency.isSuccess() + "");
                binding.tvCode.setText(currency.getError().getCode() + "1");
                binding.tvInfo.setText(currency.getError().getInfo() + "2");
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(MainActivity.this , "Error" , Toast.LENGTH_LONG).show();
                Log.e("Log" ,   "Fail");
            }
        });


    }
}