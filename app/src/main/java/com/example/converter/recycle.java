package com.example.converter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class recycle extends RecyclerView.Adapter<recycle.ViewHolder> {
    Context context;
    int realData;
    String[] data;
    int checked=-1;
    public recycle(Context context,String[] data) {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_bottom2,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.textView.setText(data[position]);

         if(checked==position){
             holder.checkBox.setChecked(true);

         }
         else {
             holder.checkBox.setChecked(false);
         }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardView;
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checkbox);
            textView=itemView.findViewById(R.id.textView2);
            cardView=itemView.findViewById(R.id.card);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(checkBox.isChecked()){
                                realData=getAdapterPosition();
                    }
                }
            });
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    realData=getAdapterPosition();

                        checked=getAdapterPosition();
                        notifyDataSetChanged();
                   // Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();;
                }
            });
        }
    }
    public int getData(){

        return realData;
    }
}
