package komer.nol.parosy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinichGameInfity extends AppCompatActivity {
    MediaPlayer player;
    private SharedPreferences sharedPreferences;
    private final String Settings = "settings";
    public static int[] records = {0, 0, 0, 0, 0};
    public void addRec(int chet_int){
        for (int i = 0; i < 5; i++){
            if (records[i] < chet_int){
                records[i] = chet_int;
                break;
            }
        }
    }

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

//кнопка назад
        Button back = (Button)findViewById(R.id.vihod);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(FinichGameInfity.this, Levels.class);
                    startActivity(intent); finish();
                }catch (Exception e){}
            }
        });

// пренос данных
        TextView time = (TextView)findViewById(R.id.time_life);
        TextView chetf = (TextView)findViewById(R.id.ochki);
        Intent intent = getIntent();
        String chet_string = intent.getStringExtra("OchkiInfi");
        String sec_map = intent.getStringExtra("Vrem1");
        String min_map = intent.getStringExtra("Vrem2");
        chetf.setText("Счёт: " + chet_string);
        if (sec_map != "1" && sec_map != "2" && sec_map != "3" && sec_map != "4" && sec_map != "5" && sec_map != "6" && sec_map != "7" && sec_map != "8" && sec_map != "9"){
            time.setText("Время: " + sec_map + ":" + min_map);
        }
        else {time.setText("Время: " + sec_map + ":0" + min_map);}

        sharedPreferences = getSharedPreferences(Settings, MODE_PRIVATE);
        int chet_int = Integer.parseInt(chet_string);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        addRec(chet_int);
        for (int i = 0; i < 5; i++){
            edit.putInt(Settings + 1 ,records[i]);
        }
        edit.apply();




        Intent intent1 = getIntent();
        intent1.putExtra("ArrRec", records);

// на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    // системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            player.stop();
            Intent intant = new Intent(FinichGameInfity.this, MainActivity.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}