package example.com.dery.storage.proyek2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class SplashScreen extends AppCompatActivity {

    public static final String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //pastikan pastikan parent pada style bernilai "Theme.AppCompat.Light.NoActionBar"
        //pada styles.xml di folder res/values

        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            if (isLogin()) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }

            finish();
        }, 3000);
    }

    boolean isLogin() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);
        return file.exists();
    }

}
