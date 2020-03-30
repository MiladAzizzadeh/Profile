package ir.maziz.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        String userName = getIntent().getStringExtra(MainActivity.EXTRA_KEY_FULLNAME);
        final EditText editTextFullName = findViewById(R.id.et_editProfile_fullName);
        editTextFullName.setText(userName);
        Button buttonDone = findViewById(R.id.btn_editProfile_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = editTextFullName.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_KEY_FULLNAME, fullName);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
