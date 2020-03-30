package ir.maziz.profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_KEY_FULLNAME = "fullName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable drawable = getResources().getDrawable(R.drawable.profile_image);
        String text = "Hello World!";
        Button saveInformationButton = findViewById(R.id.btn_main_save_information);
        saveInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "User Clicked on Save Information Button", Toast.LENGTH_LONG).show();
            }
        });
        CheckBox checkBoxAndroidDevelopment = findViewById(R.id.chb_android_development);
        checkBoxAndroidDevelopment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Android Development Skill is Checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Android Development Skill is not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox checkBoxUiDesign = findViewById(R.id.chb_ui_design);
        checkBoxUiDesign.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Ui Design Skill is Checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Ui Design Skill is not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox checkBoxDeepLearning = findViewById(R.id.chb_deep_learning);
        checkBoxDeepLearning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Deep Learning Skill is Checkd", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Deep Learning Skill is not Checkd", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        RadioButton radioButtonGilanRasht = findViewById(R.id.rbtn_gilan_rasht);
/*        radioButtonGilanRasht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "RadioButton GilanRasht is Checked", Toast.LENGTH_SHORT).show();
            }
        });*/
/*        radioButtonGilanRasht.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Radio GilanRahst is Cheched", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Radio GilanRahst is not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        RadioGroup radioGroupMain = findViewById(R.id.rg_main);
        radioGroupMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtn_gilan_rasht:
                        Toast toast = Toast.makeText(MainActivity.this, "RadioButton GilanRasht is Checked", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        break;
                    case R.id.rbtn_tehran_tehran:
                        Toast.makeText(MainActivity.this, "RadioButton TehranTehran is Checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtn_alborz_karaj:
                        Toast.makeText(MainActivity.this, "RadioButton AlborzKaraj is Checked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        Button editProfile = findViewById(R.id.btn_edit_profile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
                TextView textViewUserName = findViewById(R.id.txt_user_name);
                intent.putExtra(EXTRA_KEY_FULLNAME, textViewUserName.getText());
                startActivityForResult(intent, 1001);
            }
        });
        Button buttonViewWebsite = findViewById(R.id.btn_view_website);
        buttonViewWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://7learn.ac"));
                startActivity(intent);
            }
        });
/*        Log.v("myTag", "this is verbose log", new NullPointerException());
        Log.d("myTag", "this is debug log");
        Log.i("myTag", "this is information log");
        Log.w("myTag", "this is warning log");
        Log.e("myTag", "this is error log");
        Log.wtf("myTag", "this is assert log");
        Log.println(Log.ASSERT, "myTag", "this is assert log");*/
//        Log.println(Log.VERBOSE, "myTag", "this is verbose log");
/*        Log.d(TAG, "onCreate: this is test");
        Log.i(TAG, "onCreate: this is test");
        Log.w(TAG, "onCreate: this is test", );
        Log.e(TAG, "onCreate: this is test", );
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]"); // logm
        Log.d(TAG, "onCreate() returned: " + test); // logr*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        Log.i(TAG, "onActivityResult: this is test");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK && data != null) {
            String fullName = data.getStringExtra(EXTRA_KEY_FULLNAME);
            TextView textView = findViewById(R.id.txt_user_name);
            textView.setText(fullName);
        }
    }
}
