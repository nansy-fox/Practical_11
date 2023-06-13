package com.example.practical_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public boolean Started=false;
    public boolean Finished=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void Start(View view){
        Button button=(Button)findViewById(R.id.btnStart);
        if(!Finished){
            if(!Started){
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started=true;
            }
            else if(Started){
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started=false;
            }
        }
        else{
            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
    public void Drive1(View view){
        Button button=(Button)findViewById(R.id.btnStart);
        View Car=(View)findViewById(R.id.Car1);
        TextView result=(TextView)findViewById(R.id.tvResult);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin=(ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin+=40;
            margin.rightMargin-=40;
            Car.requestLayout();
            if(margin.rightMargin<=-1500){
                result.setText("Победа 1 игрока");
                button.setText("Заново");
                button.setTextColor(0xffe91E63);
                Finished=true;
            }
        }
    } public void Drive2(View view){
        Button button=(Button)findViewById(R.id.btnStart);
        View Car=(View)findViewById(R.id.Car2);
        TextView result=(TextView)findViewById(R.id.tvResult);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin=(ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin+=40;
            margin.rightMargin-=40;
            Car.requestLayout();
            if(margin.rightMargin<=-1500){
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                button.setTextColor(0xfff00000);
                Finished=true;
            }
        }
    }
}