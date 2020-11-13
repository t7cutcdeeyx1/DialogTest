package com.example.dialogtest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tipDialogBtn = (Button) findViewById(R.id.tipDialogBtn);
        tipDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 构建对话框组件
                builder.setMessage("提示对话框").setTitle("对话框");
                // 设定确定按钮
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "用户按下了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                // 设定取消按钮
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                // 设定忽略按钮
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                // 显示构建好的对话框组件
                builder.show();
            }
        });

        final Button LoginDialogBtn = (Button) findViewById(R.id.customDialogBtn);
        LoginDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("登录")
                        .setIcon(R.drawable.ic_launcher_background);
                // 获取弹出框的view
                LayoutInflater inflater = getLayoutInflater();
                final View customDialogView = (View) inflater.inflate(R.layout.login_dialog, null);
                builder.setView(customDialogView);
                builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText userName = customDialogView.findViewById(R.id.userName);
                        EditText password = customDialogView.findViewById(R.id.password);
                        if ("abc".equals(userName.getText().toString()) && "123".equals(password.getText().toString())) {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "取消登录", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}
