package com.example.converter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheet extends BottomSheetDialogFragment {
    public static final String TAG="ActionBottonDialog";
    private EditText editText;
    int  realdata;
    private Button button;
    RecyclerView recyclerView;
    public static BottomSheet newInstance(){
        return new BottomSheet();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL,R.style.DialogStyle);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.bottomsheet,container,false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        Bundle bundle=getArguments();
        recyclerView=getView().findViewById(R.id.recycleView);
        button=getView().findViewById(R.id.button);
        String[] data= (String[]) bundle.get("meter");
        recycle adapter = new recycle(getContext(),data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
               button.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       realdata=adapter.getData();
                       dismiss();
                   }
               });
            }

    @Override
    public void onDismiss(DialogInterface dialogInterface){
        Activity activity=getActivity();
        if(activity instanceof DialogCloseListner){
            ((DialogCloseListner)activity).handleDialogClose(dialogInterface,realdata);
        }
    }
}

