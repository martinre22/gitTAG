package com.example.apploginmvp.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apploginmvp.Presenter.IMainActivityPresenter;
import com.example.apploginmvp.Presenter.MainActivityPresenter;
import com.example.apploginmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainActivityView {

    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_signup)
    Button btnLogin;

    IMainActivityPresenter iMainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        iMainActivityPresenter = new MainActivityPresenter(getApplicationContext(), this);
    }



    @Override
    public void clearFields() {
        etUser.setText("");
        etPassword.setText("");

    }

    @Override
    public void validityFields() {
        if(etUser.getText().equals(""))
        {
            Toast.makeText(this, "debe ingresar un usuario", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this, "debe ingresar un password", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_signup)
    public void onViewClicked() {
        validityFields();
        String user_name = etUser.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        iMainActivityPresenter.registrationUserBD(iMainActivityPresenter.return_user(user_name, password));
        clearFields();
    }


}