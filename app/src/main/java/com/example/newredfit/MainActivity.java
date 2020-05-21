package com.example.newredfit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.converter.gson.GsonConverterFactory;
import org.apache.wink.spring.internal.SpringObjectFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Button button;
Parsic bars;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bars=new Parsic(5, "Parsic", null, null);
                savedInstanceState.putParcelable("barsic",bars);
            }
        });
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("http://yandex.ru")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit r=builder.build();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(bars!=null){
            outState.putParcelable("barsic",bars);
        }
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.getParcelable("barsik")!=null){
             bars=savedInstanceState.getParcelable("barsic");
        }
    }

}
