package com.example.converter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycle2 extends RecyclerView.Adapter<recycle2.ViewHolder> {
    Context context;
    int realData;
    String[] data=new String[]{"Distance","Weight","Temperature","Area","Volume","Time","Speed","Pressure"};
    String[] arrayList= new String[]{"kilometer", "meter", "centimeter", "millimeter","Inch","Foot","Yard"};
    String[] arrayList2= new String[]{"pound","kilogram","gram","milligram","microgram","Grain"};
    String[] arrayList3= new String[]{"celsius","Fehrenheit","kelvin"};
    String[] arrayList4= new String[]{"square mile","square inch","square foot","square yard","Acre"};
    String[] arrayList5= new String[]{"millilitre","litre","cubic cm","cubic m","cubic inch"};

    String[] arrayList6= new String[]{"millsecond","second","minute","Hour","day","week","month","year"};
    String[] arrayList7= new String[]{"meter/second","foot/second","kilometer/hour","mile/hour","light speed"};
    String[] arrayList8= new String[]{"pascal","bar","kg-force/sq.cm","psi","ksi","millimeter water" };
    int[] images=new int[]{R.drawable.distance,R.drawable.weight,R.drawable.temperature,R.drawable.area,R.drawable.flask,
            R.drawable.clock,R.drawable.speedometer,R.drawable.pressure};
    ArrayList<String[]> array=new ArrayList<>();
    public recycle2(Context context) {
        this.context=context;
//        this.data=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_bottom,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos=position;
            holder.textView.setText(data[pos*2]);
            holder.textView2.setText(data[pos*2+1]);
           holder.imageView.setImageResource(images[pos*2]);
        holder.imageView2.setImageResource(images[pos*2+1]);

    }

    @Override
    public int getItemCount() {
        return data.length/2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView2;
        ImageView imageView,imageView2;
        CardView first,second;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            imageView2=itemView.findViewById(R.id.image2);
            first=itemView.findViewById(R.id.first);
            second=itemView.findViewById(R.id.second);
            array.add(arrayList);
            array.add(arrayList2);
            array.add(arrayList3);
            array.add(arrayList4);
            array.add(arrayList5);
            array.add(arrayList6);
            array.add(arrayList7);
            array.add(arrayList8);
            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,MainActivity.class);
                    intent.putExtra("bharath",array.get(getAdapterPosition()*2));
                    context.startActivity(intent);
                }
            });
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,MainActivity.class);
                    intent.putExtra("bharath",array.get(getAdapterPosition()*2+1));
                    context.startActivity(intent);
                }
            });
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
        }
    }
    public int getData(){
        return realData;
    }
}
