package kr.ac.kopo.etc_layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Grid05_5Activity extends AppCompatActivity {
    EditText edit1, edit2;
    Button[] btnNums = new Button[10];
    Button btnPlus, btnMinus, btnMulti, btnDiv;
    TextView result;

    String num1,num2 = "";

    int[] btnNumids = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.grid05_5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        for (int i = 0; i < btnNumids.length; i++) {
            btnNums[i] = findViewById(btnNumids[i]);
        }
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        result = findViewById(R.id.result);

        for (int i = 0; i < btnNums.length; i++) {
            final int index;
            index = i;

            btnNums[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused()) {
                       num1 = edit1.getText().toString() +btnNums[index].getText().toString();
                       edit1.setText(num1);
                    } else if (edit2.isFocused()) {
                        num2 = edit2.getText().toString() +btnNums[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "에딧 텍스트를 먼저 선택해주세요",Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = 0;
                Button btnE = (Button) v;
                if (btnE == btnPlus) {
                    res = Integer.parseInt(num1) + Integer.parseInt(num2);
                } else if (btnE == btnMinus) {
                    res = Integer.parseInt(num1) - Integer.parseInt(num2);
                } else if (btnE == btnMulti) {
                    res = Integer.parseInt(num1) * Integer.parseInt(num2);
                } else if (btnE == btnDiv) {
                    res = Integer.parseInt(num1) / Integer.parseInt(num2);
                }
                result.setText("계산 결과: "+ res);
            }
        };

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMulti.setOnClickListener(btnListener);
        btnDiv.setOnClickListener(btnListener);
    }
}