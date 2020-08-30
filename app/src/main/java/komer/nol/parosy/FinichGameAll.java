package komer.nol.parosy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class FinichGameAll extends AppCompatActivity {
    MediaPlayer player;

    // музыка
    public void Music(){
        player = MediaPlayer.create(this, R.raw.itog_music);
        player.start();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finich_game);

        Music();
        float toch = 0;

//кнопка назад
        Button back = (Button)findViewById(R.id.vihod);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(FinichGameAll.this, Levels.class);
                    startActivity(intent); finish();
                }catch (Exception e){}
            }
        });

// пренос данных
        TextView combof = (TextView)findViewById(R.id.time_life);
        TextView chetf = (TextView)findViewById(R.id.ochki);
        TextView accecer = (TextView)findViewById(R.id.accecer);
        Intent intent = getIntent();
        String accer = intent.getStringExtra("Accer");
        String chet = intent.getStringExtra("Ochki");
        String k_o = intent.getStringExtra("Combo");
        accecer.setText("Точность: " + accer + "%");
        chetf.setText("Счёт: " + chet);
        combof.setText("Комбо: " + k_o);

//Гифка
        GifImageView rang = (GifImageView)findViewById(R.id.rang);
        float accet = intent.getFloatExtra("intAccent", toch);

        if(accet >= 90 && accet < 100){
            rang.setImageResource(R.drawable.cow_s_rang);
        }
        else if(accet >= 75 && accet < 90){
            rang.setImageResource(R.drawable.cow_a_rang);
        }
        else if(accet >= 50 && accet < 75){
            rang.setImageResource(R.drawable.cow_c_rang);
        }
        else{
            rang.setImageResource(R.drawable.cow_d_rang);
        }

// на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    // системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            player.stop();
            Intent intant = new Intent(FinichGameAll.this, MainActivity.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}
