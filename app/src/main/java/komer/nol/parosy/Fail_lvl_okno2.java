package komer.nol.parosy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Fail_lvl_okno2 extends AppCompatActivity {
    MediaPlayer player;

    // музыка
    public void Music(){
        player = MediaPlayer.create(this, R.raw.fail_music);
        player.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fail_lvl_game);
        Music();

// кнопки меню паузы
        Button resum = (Button)findViewById(R.id.resum);
        resum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intant = new Intent(Fail_lvl_okno2.this, Beskonechno.class);
                startActivity(intant); finish();
            }
        });
        Button esc = (Button)findViewById(R.id.esc);
        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intant = new Intent(Fail_lvl_okno2.this, Levels.class);
                startActivity(intant); finish();
            }
        });

// опять же на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    // системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            player.stop();
            Intent intant = new Intent(Fail_lvl_okno2.this, MainActivity.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}

