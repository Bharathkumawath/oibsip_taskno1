package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogCloseListner{
     private Button button,from,to;
     private TextView textview,t1,t2,t3;
     private EditText editText;
     int f=0,t=0;
     int a,b;
     String[] arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.check);
        t1=findViewById(R.id.fromtext);
        t2=findViewById(R.id.totext);
        t3=findViewById(R.id.output);
        from=findViewById(R.id.right);
        to=findViewById(R.id.left);
        textview=findViewById(R.id.tounit);
        editText=findViewById(R.id.input);
//        arrayList= new String[]{"mm","cm", "m", "km"};
//        arrayList2= new String[]{"pound","kg","g","millig","microg"};
        Intent intent=getIntent();
        arrayList=intent.getStringArrayExtra("bharath");

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//
               String s=editText.getText().toString();
               if(s.equals("")){
                   Toast.makeText(MainActivity.this, "enter the value", Toast.LENGTH_SHORT).show();
               }else {
                   int kg = Integer.parseInt(s);

                   if (a != b) {
                       if (arrayList[0].equals("kilometer")) {
                           float pound = distance(a, b) * kg;
                           t3.setText("" + pound);
                       } else if (arrayList[0].equals("pound")) {
                           float pound = weight(a, b) * kg;
                           t3.setText("" + pound);
                       }
                       else if (arrayList[0].equals("celsius")) {
                           float pound = Temp(a, b) * kg;
                           t3.setText("" + pound);
                       }
                       else if (arrayList[0].equals("square mile")) {
                           float pound = Area(a, b) * kg;
                           t3.setText("" + pound);
                       }
                       else if (arrayList[0].equals("millilitre")) {
                           float pound = Volume(a, b) * kg;
                           t3.setText("" + pound);
                       }
                       else if (arrayList[0].equals("millsecond")) {
                           float pound = Timing(a, b) * kg;
                           t3.setText("" + pound);
                       }
                       else if (arrayList[0].equals("meter/second")) {
                           float pound = speed(a, b) * kg;
                           t3.setText("" + pound);
                       }
                       else if (arrayList[0].equals("pascal")) {
                           float pound = pressure(a, b) * kg;
                           t3.setText("" + pound);
                       }
                       textview.setText(t2.getText());
                   } else {
                       Toast.makeText(MainActivity.this, "select different unit", Toast.LENGTH_SHORT).show();
                   }
               }

            }
        });
        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f=1;
                t=0;
                editItem();

            }
        });
        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f=0;
                t=1;
                editItem();
            }
        });
    }
    public float distance(int a,int b){
        int kilometer=6,meter=5,centimeter=4,millimeter=3,Inch=2,Foot=1,Yard=0;
        int[] A= new int[]{kilometer, meter, centimeter, millimeter,Inch,Foot,Yard};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
       // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){
            if(A[Big]==6){
                factor=factor*1000;
            }
            else if(A[Big]==5){
                factor=factor*100;
            }
            else if(A[Big]==4){
                factor=factor*10;
            }
            else if(A[Big]==3){
                factor=factor*0.039F;
            }
            else if(A[Big]==2){
                factor=factor*0.083F;
            }
            else if(A[Big]==1){
                factor=factor*0.33F;
            }
            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    public float weight(int a,int b){
        int pound=5,kg=4,g=3,millig=2,microg=1,Grain=0;
        int i=0,j=0,k=1;
        int[] A= new int[]{pound,kg,g,millig,microg,Grain};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean Big_ok=false,small_ok=false,reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
        // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){
            if(A[Big]==5){
                factor=factor*0.454F;
            }
            else if(A[Big]==4){
                factor=factor*1000;
            }
            else if(A[Big]==3){
                factor=factor*1000;
            }
            else if(A[Big]==2){
                factor=factor*1000;
            }
            else if(A[Big]==1){
                factor=factor*0.00002F;
            }

            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    public float Temp(int a,int b){
        int celsius=2,Fehrenheit=1,kelvin=0;
        int[] A= new int[]{celsius,Fehrenheit,kelvin};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
        // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){
             if(A[Big]==2){
                factor=factor*33.8F;
            }
            else if(A[Big]==1){
                factor=factor*255.928F;
            }

            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    public float Area(int a,int b){
        int squaremile=4,squareinch=3,squarefoot=2,squareyard=1,Acre=0;
        int[] A= new int[]{squaremile,squareinch,squarefoot,squareyard,Acre};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
        // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){
            if(A[Big]==4){
                factor=factor*4014489599F;
            }
            else if(A[Big]==3){
                factor=factor*0.007F;
            }
            if(A[Big]==2){
                factor=factor*0.111F;
            }
            else if(A[Big]==1){
                factor=factor*0.01F;
            }

            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    public float Volume(int a,int b){
       // int squaremile=4,squareinch=3,squarefoot=2,squareyard=1,Acre=0;
        int[] A= new int[]{4,3,2,1,0};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
        // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){
            if(A[Big]==4){
                factor=factor*0.001F;
            }
            else if(A[Big]==3){
                factor=factor*0.008F;
            }
            else if(A[Big]==2){
                factor=factor*0.01F;
            }
            else if(A[Big]==1){
                factor=factor*61023.744F;
            }

            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    public float Timing(int a,int b){
        // int squaremile=4,squareinch=3,squarefoot=2,squareyard=1,Acre=0;
        int[] A= new int[]{7,6,5,4,3,2,1,0};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
        // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){
            if(A[Big]==7){
                factor=factor*0.001F;
            }
            else if(A[Big]==6){
                factor=factor*0.017F;
            }
            else if(A[Big]==5){
                factor=factor*0.017F;
            }
            else if(A[Big]==4){
                factor=factor*0.042F;
            }
            else if(A[Big]==3){
                factor=factor*0.143F;
            }
            else if(A[Big]==2){
                factor=factor*0.23F;
            }
            else if(A[Big]==1){
                factor=factor*0.083F;
            }

            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    public float speed(int a,int b){
        // int squaremile=4,squareinch=3,squarefoot=2,squareyard=1,Acre=0;
        int[] A= new int[]{4,3,2,1,0};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
        // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){

             if(A[Big]==4){
                factor=factor*3.281F;
            }
            else if(A[Big]==3){
                factor=factor*1.097F;
            }
            else if(A[Big]==2){
                factor=factor*0.631F;
            }
            else if(A[Big]==1){
                factor=factor*0.01F;
            }

            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    public float pressure(int a,int b){
        // int squaremile=4,squareinch=3,squarefoot=2,squareyard=1,Acre=0;
       // {"pascal","bar","kg-force/sq.cm","psi","ksi","millimeter water" }
        int[] A= new int[]{5,4,3,2,1,0};
        int Big = 0,small=0;
        float factor= 1.0F;
        boolean reverse=false;;
        if(a<b){
            Big=a;
            small=b;
        }
        else{
            Big=b;
            small=a;
            reverse=true;
        }
        // Toast.makeText(MainActivity.this, ""+j+k, Toast.LENGTH_SHORT).show();
        while (Big<small){
            if(A[Big]==5){
                factor=factor*0.00001F;
            }
            else if(A[Big]==4){
                factor=factor*1.02F;
            }
            else if(A[Big]==3){
                factor=factor*14.223F;
            }
            else if(A[Big]==2){
                factor=factor*0.001F;
            }
            else if(A[Big]==1){
                factor=factor*703088.937F;
            }

            Big++;
        }
        if(reverse){
            factor=(1/factor);
        }
        return factor;
    }
    @Override
    public void handleDialogClose(DialogInterface dialogInterface,int realdata) {
        if(f==1){
            a=realdata;
            t1.setText(arrayList[realdata]);
        }
        else {
           b=realdata;
            t2.setText(arrayList[realdata]);
        }
    }
    public void editItem(){
        Bundle bundle=new Bundle();
        bundle.putStringArray("meter",arrayList);
        BottomSheet fragment=new BottomSheet();
        fragment.setArguments(bundle);
        fragment.show(getSupportFragmentManager(),BottomSheet.TAG);
    }
}