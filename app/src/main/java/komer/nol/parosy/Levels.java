package komer.nol.parosy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Levels extends AppCompatActivity {
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
        setContentView(R.layout.levels);
        Button back = (Button)findViewById(R.id.button_back);
        Button lvl1 = (Button)findViewById(R.id.level1);
        Button infi = (Button)findViewById(R.id.level2);

// кнопки выбора уровней
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    player.stop();
                    Intent intant = new Intent(Levels.this, One_tut.class);
                    startActivity(intant); finish();
                }catch (Exception e){

                }
            }
        });

        infi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    player.stop();
                    Intent intant = new Intent(Levels.this, One_infi.class);
                    startActivity(intant); finish();
                }catch (Exception e){

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    player.stop();
                    Intent intant = new Intent(Levels.this, MainActivity.class);
                    startActivity(intant); finish();
                }catch (Exception e){

                }
            }
        });


        Music();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    // системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            player.stop();
            Intent intant = new Intent(Levels.this, MainActivity.class);
            startActivity(intant); finish();
        }catch (Exception e){

        }
    }
}
