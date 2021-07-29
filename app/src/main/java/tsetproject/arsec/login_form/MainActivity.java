package tsetproject.arsec.login_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    EditText name, lastname, email, password, phoneNumber;
    RadioGroup gender;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        submit.setOnClickListener(this);

    }

    private void init() {
        name = findViewById(R.id.input_name);
        lastname = findViewById(R.id.input_lastname);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        phoneNumber = findViewById(R.id.input_number);
        gender = findViewById(R.id.gender);
        submit = findViewById(R.id.submit_btn);


    }

    @Override
    public void onClick(View view) {

        if (check()) {
            Toast.makeText(this, "ثبت نام با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean check() {
        boolean isOK = true;
        if (name.getText().toString().trim().isEmpty() || lastname.getText().toString().trim().isEmpty() ||
                email.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty()
                || phoneNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "لطفا فیلد های خالی را پر کنید", Toast.LENGTH_SHORT).show();
            isOK = false;
        } else {
            if (name.getText().toString().trim().length() < 2) {
                isOK = false;
                Toast.makeText(this, "نام وارد شده کوچک تر از حد مجاز است", Toast.LENGTH_SHORT).show();
            }
            if (lastname.getText().toString().trim().length() < 2) {
                isOK = false;
                Toast.makeText(this, "نام خانوادگی وارد شده کوچک تر از حد مجاز است", Toast.LENGTH_SHORT).show();
            }
            if (email.getText().toString().trim().length() < 12) {
                isOK = false;
                Toast.makeText(this, "ایمیل وارد شده کوچک تر از حد مجاز است", Toast.LENGTH_SHORT).show();
            } else {
                if (!email.getText().toString().trim().contains("@")) {
                    isOK = false;
                    Toast.makeText(this, "ایمیل وارد شده نامعبر است", Toast.LENGTH_SHORT).show();
                }
            }
            if (password.getText().toString().trim().length() < 8) {
                isOK = false;
                Toast.makeText(this, "رمز وارد شده کوچک تر از حد مجاز است", Toast.LENGTH_SHORT).show();
            }
            if (phoneNumber.getText().toString().trim().length() < 11) {
                isOK = false;
                Toast.makeText(this, "شمار وارد شده کوچک تر از حد مجاز است", Toast.LENGTH_SHORT).show();
            } else if (phoneNumber.getText().toString().trim().length() > 11) {
                isOK = false;
                Toast.makeText(this, "شماره وارد شده صحیح نسیت", Toast.LENGTH_SHORT).show();
            }


        }

        return isOK;
    }
}