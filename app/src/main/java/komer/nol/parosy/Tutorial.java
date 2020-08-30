package komer.nol.parosy;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Tutorial extends AppCompatActivity {

    MediaPlayer player;
    int clats = 0;
    int max_combo = 0;
    int proc = 0;
    int gone = 0;
    int luck = 0;
    int unluck = 0;
    private int i = 160;
    String vrem = "";
    private int min_map = 0;
    private int sec_map = 28;
    private int ochki = 0;
    int k_o = 0;
    int sleep = 0;

    public void Music(){
        player = MediaPlayer.create(this, R.raw.main_backgraund_music);
        player.setLooping(true);
        player.start();
    }


    //массивы
    int[] array_knopki = {};

    // кол-во элементов ЭТО ВАЖНО
    float kol_vo = 6;
    // все о точности на мапе
    float one_procent = 100 / kol_vo;
    float accecery = 0;

    // счетчек очков - начало
    public void Chetchik_ochkov(){
        TextView chet = (TextView)findViewById(R.id.chet);
        chet.setGravity(Gravity.CENTER);
        try {
            if (ochki < 10) {
                try {
                    String hh = String.valueOf("00000" + ochki);
                    chet.setText(hh);
                } catch (Exception e) {
                }
            }
            if ((ochki >= 10) && (ochki < 100)) {
                try {
                    String hh = String.valueOf("0000" + ochki);
                    chet.setText(hh);
                } catch (Exception e) {
                }
            }
            if ((ochki >= 100) && (ochki < 1000)) {
                try {
                    String hh = String.valueOf("000" + ochki);
                    chet.setText(hh);
                } catch (Exception e) {
                }
            }
            if ((ochki >= 1000) && (ochki < 10000)) {
                try {
                    String hh = String.valueOf("00" + ochki);
                    chet.setText(hh);
                } catch (Exception e) {
                }
            }
            if ((ochki >= 10000) && (ochki < 100000)) {
                try {
                    String hh = String.valueOf("0" + ochki);
                    chet.setText(hh);
                } catch (Exception e) {
                }
            }
            if (ochki >= 100000) {
                try {
                    String hh = String.valueOf(ochki);
                    chet.setText(hh);
                } catch (Exception e) {
                }
            }
        }catch (Exception e){}
    }
// счетчик очков - конец

    // здесь счетчик комбо - начало
    public void Chetchik_combo(){
        TextView combo = (TextView)findViewById(R.id.combo);
        try {
            if (clats == 1){
                if (max_combo <= proc){
                    max_combo = proc;
                }
            }
            if (k_o >= 0) {
                String gr = String.valueOf(k_o);
                combo.setText(gr);
            }
        }catch (Exception e){}
    }
// счетчик комбо - конец

    //характеристика для битов - начало
    public void Harak_biti(final View v){
        try {
            if (luck == 0 && unluck == 0) {
                i -= 5;
                k_o = 0;
                clats = 1;
                proc = 0;
                v.setVisibility(View.GONE);
            }
            if (luck == 1 && unluck == 0) {
                i -= 5;
                k_o = 0;
                clats = 1;
                proc = 0;
                v.setVisibility(View.GONE);
            }
            if (luck == 1 && unluck == 1) {
                i += 10;
                k_o += 1;
                proc += 1;
                ochki += k_o * 300;
                clats = 1;
                accecery += one_procent;
                v.setVisibility(View.GONE);
            }
        }catch (Exception e){}
    }
    public void fail(){
        TextView combo = (TextView)findViewById(R.id.combo);
        proc = 0;
        i -= 5;
        k_o = 0;
        String gr = String.valueOf(k_o);
        combo.setText(gr);
    }
//характеристика для битов - конец

    //характеристика для слайдеров - начало
    public void Harak_slaider(final View v){
        try {
            clats = 1;
            if (luck == 0 && unluck == 0) {
                i -= 5;
                k_o = 0;
                proc = 0;
                v.setVisibility(View.GONE);
            }
            if (luck == 1 && unluck == 0) {
                i -= 5;
                k_o = 0;
                proc = 0;
                v.setVisibility(View.GONE);
            }
            if (luck == 1 && unluck == 1) {
                i += 10;
                k_o += 1;
                proc += 1;
                ochki += k_o * 300;
                accecery += one_procent;
                v.setVisibility(View.GONE);
            }
        }catch (Exception e){}
    }
//характеристика для слайдеров - конец

    //конец всем потокам
    public void Time_p() {
        while (sleep == 1) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
    // чтоб остановить поток после конца игры
    public void end_game(){
        if (gone == 1){
            try {
                Thread.sleep(1000000000);
            }catch (Exception e){}
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor);

        Music();
        final Dialog pause = new Dialog(Tutorial.this);
        Button btn_pause = (Button)findViewById(R.id.btn_pause);
        final ImageButton bit1 = (ImageButton)findViewById(R.id.bit);
        final ImageButton bit2 = (ImageButton)findViewById(R.id.bit2);
        final ImageButton bit3 = (ImageButton)findViewById(R.id.bit3);
        final ImageButton slaider1 = (ImageButton)findViewById(R.id.slaider);
        final ImageButton slaider2 = (ImageButton)findViewById(R.id.slaider2);
        final ImageButton slaider3 = (ImageButton)findViewById(R.id.slaider3);
        final ProgressBar progress_hp = (ProgressBar)findViewById(R.id.hp);
        final TextView tochnost = (TextView)findViewById(R.id.tochnost);
        progress_hp.setMax(160);
        progress_hp.setProgress(i);



// пауза начало
// окно паузы - начало
        pause.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pause.setContentView(R.layout.pause_game);
        pause.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pause.setCancelable(false);
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    player.pause();
                    sleep = 1;
                    pause.show();
                }catch (Exception e){}
            }
        });
        final Button conti = (Button)pause.findViewById(R.id.conti);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    player.start();
                    sleep = 0;
                    pause.dismiss();
                }catch (Exception e){}
            }
        });
        Button resum = (Button)pause.findViewById(R.id.resum);
        resum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                Intent intant = new Intent(Tutorial.this, Tutorial.class);
                startActivity(intant); finish();
            }
        });
        final Button esc = (Button)pause.findViewById(R.id.esc);
        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                Intent intant = new Intent(Tutorial.this, Levels.class);
                startActivity(intant); finish();
            }
        });
//окно паузы - конец


// таймкод всех элементов
        new Thread(new Runnable() {
            public void run() {
// первый бит
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit1.setImageResource(R.drawable.bit1_game_small);
                    luck = 0;
                    unluck = 0;
                }catch (Exception e){}
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit1.setImageResource(R.drawable.bit2_game_small);
                    luck = 1;
                    unluck = 0;
                }catch (Exception e){}
                try{Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit1.setImageResource(R.drawable.bit3_game_small);
                    luck = 1;
                    unluck = 1;
                    try{Time_p();
                        Thread.sleep(1000);
                        Time_p();
                        if (clats == 0){fail();}
                        bit1.setImageResource(R.drawable.empty);
                        bit1.setEnabled(false);
                    }catch (Exception e){}
                }catch (Exception e){}
// сон
                try {Thread.sleep(1000); clats = 0;}catch (Exception e){}
// второй бит
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit2.setImageResource(R.drawable.bit1_game_small);
                    luck = 0;
                    unluck = 0;
                }catch (Exception e){}
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit2.setImageResource(R.drawable.bit2_game_small);
                    luck = 1;
                    unluck = 0;
                }catch (Exception e){}
                try{Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit2.setImageResource(R.drawable.bit3_game_small);
                    luck = 1;
                    unluck = 1;
                    try{Time_p();
                        Thread.sleep(1000);
                        Time_p();
                        if (clats == 0){fail();}
                        bit2.setImageResource(R.drawable.empty);
                        bit2.setEnabled(false);
                    }catch (Exception e){}
                }catch (Exception e){}
//сон
                try {Thread.sleep(1000); clats = 0;}catch (Exception e){}
                // первый слайдер
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider1.setImageResource(R.drawable.slayder1_game_small);
                    luck = 0;
                    unluck = 0;
                }catch (Exception e){}
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider1.setImageResource(R.drawable.slayder2_game_small);
                    luck = 1;
                    unluck = 0;
                }catch (Exception e){}
                try{Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider1.setImageResource(R.drawable.slayder3_game_small);
                    luck = 1;
                    unluck = 1;
                    try{Time_p();
                        Thread.sleep(500);
                        Time_p();
                        if (clats == 0){fail();}
                        slaider1.setImageResource(R.drawable.empty);
                        slaider1.setEnabled(false);
                    }catch (Exception e){}
                }catch (Exception e){}
                //сон
                try {Thread.sleep(1000); clats = 0;}catch (Exception e){}
                // третий бит
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit3.setImageResource(R.drawable.bit1_game_small);
                    luck = 0;
                    unluck = 0;
                }catch (Exception e){}
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit3.setImageResource(R.drawable.bit2_game_small);
                    luck = 1;
                    unluck = 0;
                }catch (Exception e){}
                try{Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    bit3.setImageResource(R.drawable.bit3_game_small);
                    luck = 1;
                    unluck = 1;
                    try{Time_p();
                        Thread.sleep(1000);
                        Time_p();
                        if (clats == 0){fail();}
                        bit3.setImageResource(R.drawable.empty);
                        bit3.setEnabled(false);
                    }catch (Exception e){}
                }catch (Exception e){}
                //сон
                try {Thread.sleep(1000); clats = 0;}catch (Exception e){}
                // второй слайдер
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider2.setImageResource(R.drawable.slayder1_game_small);
                    luck = 0;
                    unluck = 0;
                }catch (Exception e){}
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider2.setImageResource(R.drawable.slayder2_game_small);
                    luck = 1;
                    unluck = 0;
                }catch (Exception e){}
                try{Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider2.setImageResource(R.drawable.slayder3_game_small);
                    luck = 1;
                    unluck = 1;
                    try{Time_p();
                        Thread.sleep(500);
                        Time_p();
                        if (clats == 0){fail();}
                        slaider2.setImageResource(R.drawable.empty);
                        slaider2.setEnabled(false);
                    }catch (Exception e){}
                }catch (Exception e){}
                // сон
                try {Thread.sleep(1000); clats = 0;}catch (Exception e){}
                // третий слайдер
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider3.setImageResource(R.drawable.slayder1_game_small);
                    luck = 0;
                    unluck = 0;
                }catch (Exception e){}
                try {Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider3.setImageResource(R.drawable.slayder2_game_small);
                    luck = 1;
                    unluck = 0;
                }catch (Exception e){}
                try{Time_p();
                    Thread.sleep(1000);
                    Time_p();
                    slaider3.setImageResource(R.drawable.slayder3_game_small);
                    luck = 1;
                    unluck = 1;
                    try{Time_p();
                        Thread.sleep(500);
                        Time_p();
                        if (clats == 0){fail();}
                        slaider3.setImageResource(R.drawable.empty);
                        slaider3.setEnabled(false);
                    }catch (Exception e){}
                }catch (Exception e){}
            }
        }).start();


// НЕ таймкод битов

// Статичные действия - начало
// типо тут кнопка - хп
        i = progress_hp.getProgress();
        if (i + 10 >= 159) {
            try {
                i -= 15;
            } catch (Exception e) {}
        }
        new Thread(new Runnable() {
            public void run() {
                while (i <= 160){
                    Time_p();
                    if (i == 0) {
                        end_game();
                        try {
                            player.stop();
                            gone = 1;
                            Intent intant = new Intent(Tutorial.this, Fail_lvl_okno.class);
                            startActivity(intant);
                            finish();
                        } catch (Exception e) {}
                    }
                    i -= 1;
                    progress_hp.setProgress(i);
                    try {Thread.sleep(250);
                    } catch (Exception e) {}
                }

            }
        }).start();
// конец кнопка - хп
//кодим впемя - начало
        new Thread(new Runnable() {
            public void run() {
                TextView tame = (TextView)findViewById(R.id.tame);
                int h = min_map * 60 + sec_map;
                for (int i = 0; i < h; i++) {

                    try {Time_p();
                        end_game();
                        Thread.sleep(1000);
                        Time_p();
                        sec_map -= 1;
                        if (sec_map == 0) {
                            sec_map = 59;
                            min_map -= 1;
                        }
                        vrem = (min_map + ":" + sec_map);
                        tame.setText(vrem);
                        if (accecery > 100){accecery = 100;}
                        if (accecery < 0){accecery = 0;}
                        String accec = String.format("%.2f", accecery);
                        tochnost.setText(accec);
                    } catch (Exception e) {}
                }
// по завершению игры переносим данные и делаем остановку потоков
                try {
                    end_game();
                    gone = 1;
                    player.stop();
                    Intent intant = new Intent(Tutorial.this, FinichGameAll.class);
                    String hh = String.valueOf(ochki);
                    String gr = String.valueOf(max_combo);
                    String accec = String.format("%.2f", accecery);
                    intant.putExtra("intAccent", accecery);
                    intant.putExtra("Accer", accec);
                    intant.putExtra("Ochki", hh);
                    intant.putExtra("Combo", gr);
                    startActivity(intant);
                    finish();
                } catch (Exception e) {}
            }
        }).start();
//кодим время - конец
// Статичные действия - конец

// Элементы игры
        bit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_biti(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });

        bit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_biti(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });
        bit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_biti(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });

        slaider1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_slaider(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });
        slaider2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_slaider(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });
        slaider3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_slaider(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });


// на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }
    // системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            end_game();
            gone = 1;
            player.stop();
            Intent intant = new Intent(Tutorial.this, Levels.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }

}
