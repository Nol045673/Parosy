package komer.nol.parosy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    MediaPlayer player;

    // музыка
    public void Music(){
        player = MediaPlayer.create(this, R.raw.main_backgraund_music);
        player.setLooping(true);
        player.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    player.stop();
                    Intent intant = new Intent(MainActivity.this, Levels.class);
                    startActivity(intant);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        Music();

// на весь экнран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Dialog welc = new Dialog(MainActivity.this);
        welc.requestWindowFeature(Window.FEATURE_NO_TITLE);
        welc.setContentView(R.layout.welcome_window);
        welc.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        final Button btn_con = (Button)welc.findViewById(R.id.cont_main);
        welc.setCancelable(false);
        welc.show();
        btn_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    welc.dismiss();
                } catch (Exception e){}
            }
        });

    }

    // настройка системной кнопки назад
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            player.stop();
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}