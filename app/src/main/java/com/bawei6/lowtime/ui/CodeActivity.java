package com.bawei6.lowtime.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei6.lowtime.R;
import com.bawei6.lowtime.ui.weight.LockView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李荘
 */
public class CodeActivity extends AppCompatActivity {

    private LockView lock_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        initView();

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        lock_view.setStandard(intList);
        lock_view.setOnDrawCompleteListener(new LockView.OnDrawCompleteListener() {
            @Override
            public void onComplete(boolean isSuccess) {
                Toast.makeText(CodeActivity.this, isSuccess ? "success" : "fail", Toast.LENGTH_SHORT).show();
                if (isSuccess){
                    startActivity(new Intent(CodeActivity.this,Welcome_Select_Activity.class));
                }
            }
        });
    }

    private void initView() {
        lock_view = (LockView) findViewById(R.id.lock_view);
    }
}
