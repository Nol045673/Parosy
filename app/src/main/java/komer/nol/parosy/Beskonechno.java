package komer.nol.parosy;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Beskonechno extends AppCompatActivity {

    MediaPlayer player;
    Random random = new Random();
    int clats = 0;
    int max_combo = 0;
    int proc = 0;
    int luck = 0;
    int unluck = 0;
    int k_o = 0;
    int gone = 0;
    int sleep = 0;
    private int i = 160;
    private int ochki = 0;
    private int min_map = 0;
    private int sec_map = 0;
    String vrem = "";
    int speed = 900;
    int time_sleep_bit = 1000;
    int speed_hp = 350;
    int pred_k_o = 0;
    int poosk = 0;

    public void Music(){
        int[] tabl = {0, 1};
        int choose = random.nextInt(tabl.length);
        if (choose == 0){
            player = MediaPlayer.create(this, R.raw.music1);
            player.start();
        }
        if (choose == 1){
            player = MediaPlayer.create(this, R.raw.music2);
            player.start();
        }
    }

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
                if(k_o >= 10){
                    i += 20;
                }
                else {
                    i += 9;
                }
                k_o += 1;
                proc += 1;
                ochki += k_o * 300;
                clats = 1;
                v.setVisibility(View.GONE);
            }
        }catch (Exception e){}
    }
    public void fail(){
        TextView combo = (TextView)findViewById(R.id.combo);
        proc = 0;
        i -= 5;
        k_o = 0;
        pred_k_o = 0;
        String gr = String.valueOf(k_o);
        combo.setText(gr);
    }
//характеристика для битов - конец

    //характеристика для слайдеров - начало
    public void Harak_slaider(final View v){
        try {
            if (luck == 0 && unluck == 0) {
                i -= 5;
                k_o = 0;
                proc = 0;
                clats = 1;
                v.setVisibility(View.GONE);
            }
            if (luck == 1 && unluck == 0) {
                i -= 5;
                k_o = 0;
                proc = 0;
                clats = 1;
                v.setVisibility(View.GONE);
            }
            if (luck == 1 && unluck == 1) {
                if(k_o >= 10){
                    i += 20;
                }
                else {
                    i += 9;
                }
                k_o += 1;
                proc += 1;
                ochki += k_o * 300;
                clats = 1;
                v.setVisibility(View.GONE);
            }
        }catch (Exception e){}
    }
//характеристика для слайдеров - конец

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


    // жизнь бита
    public void life_btn(final ImageButton bit1, int speed, int time_sleep_bit) {
// первый бит
        try {
            Time_p();
            Thread.sleep(speed);
            Time_p();
            bit1.setImageResource(R.drawable.bit1_game_small);
            luck = 0;
            unluck = 0;
        } catch (Exception e) {
        }
        try {
            Time_p();
            Thread.sleep(speed);
            Time_p();
            luck = 1;
            unluck = 0;
            bit1.setImageResource(R.drawable.bit2_game_small);

        } catch (Exception e) {
        }
        try {
            Time_p();
            Thread.sleep(speed);
            Time_p();
            bit1.setImageResource(R.drawable.bit3_game_small);
            luck = 1;
            unluck = 1;
            pred_k_o += 1;
            try {
                Time_p();
                Thread.sleep(speed);
                Time_p();
                if(clats == 0){
                    fail();
                }
                bit1.setImageResource(R.drawable.empty);
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
// сон
        try {
            Thread.sleep(time_sleep_bit);
            clats = 0;

        } catch (Exception e) {
        }
    }


    public void crtbit(final ProgressBar progress_hp, final LinearLayout[] pStoroni, final LinearLayout[] vStoroni, final ImageButton bit, final int[] yui, final int[] iuy, final ViewGroup.LayoutParams param){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bit.setVisibility(View.VISIBLE);
                    LinearLayout lul = vStoroni[0];
                    int lor = random.nextInt(yui.length);
                    int lcr = random.nextInt(iuy.length); // lcr - left, center, right
                    if (lor == 0){
                        lul = pStoroni[lcr];
                    }
                    if(lor == 1){
                        lul = vStoroni[lcr];
                    }
                    bit.setMinimumWidth(600);
                    bit.setMinimumHeight(300);
                    bit.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    lul.addView(bit, param);
                    life_btn(bit, speed, time_sleep_bit);
                    lul.removeAllViews();
                    poosk = 0;
                }catch (Exception e){}
            }
        }).start();
    }


    // жизнь бита окончена

    //жизнь слайдера
    public void life_slaider(final ImageButton slaider1, int speed, int time_sleep_bit) {
        try {
            Time_p();
            Thread.sleep(speed);
            Time_p();
            slaider1.setImageResource(R.drawable.slayder1_game_small);
            luck = 0;
            unluck = 0;
        }catch (Exception e){}
        try {Time_p();
            Thread.sleep(speed);
            Time_p();
            slaider1.setImageResource(R.drawable.slayder2_game_small);
            luck = 1;
            unluck = 0;
        }catch (Exception e){}
        try{Time_p();
            Thread.sleep(speed);
            Time_p();
            slaider1.setImageResource(R.drawable.slayder3_game_small);
            luck = 1;
            unluck = 1;
            Time_p();
            Thread.sleep(speed);
            slaider1.setImageResource(R.drawable.empty);
            pred_k_o += 1;
            Time_p();
            if (pred_k_o != k_o) {
                fail();
            }
        }catch (Exception e){}
        // сон
        try {
            Thread.sleep(time_sleep_bit);
            clats = 0;

        } catch (Exception e) {
        }
    }

    public void crtslaider(final ProgressBar progress_hp, final LinearLayout[] pStoroni, final LinearLayout[] vStoroni, final ImageButton slaider, final int[] yui, final int[] iuy, final ViewGroup.LayoutParams param){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    slaider.setVisibility(View.VISIBLE);
                    LinearLayout lul = vStoroni[0];
                    int lor = random.nextInt(yui.length);
                    int lcr = random.nextInt(iuy.length); // lcr - left, center, right
                    if (lor == 0){
                        lul = pStoroni[lcr];
                    }
                    if(lor == 1){
                        lul = vStoroni[lcr];
                    }
                    slaider.setMinimumWidth(600);
                    slaider.setMinimumHeight(300);
                    slaider.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    lul.addView(slaider, param);
                    life_slaider(slaider, speed, time_sleep_bit);
                    lul.removeAllViews();
                    poosk = 0;
                }catch (Exception e){}
            }
        }).start();
    }
    //жизнь слайдера окончена

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infinti_lvl);

        final LinearLayout pLeft = (LinearLayout)findViewById(R.id.pLeft);
        final LinearLayout pCenter = (LinearLayout)findViewById(R.id.pCenter);
        final LinearLayout pRight = (LinearLayout)findViewById(R.id.pRight);
        final LinearLayout vLeft = (LinearLayout)findViewById(R.id.vLeft);
        final LinearLayout vCenter = (LinearLayout)findViewById(R.id.vCenter);
        final LinearLayout vRight = (LinearLayout)findViewById(R.id.vRight);
        final Dialog pause = new Dialog(Beskonechno.this);
        Button btn_pause = (Button)findViewById(R.id.btn_pause);
        final ProgressBar progress_hp = (ProgressBar)findViewById(R.id.hp);
        progress_hp.setMax(160);
        progress_hp.setProgress(i);
        Music();

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
        final Button resum = (Button)pause.findViewById(R.id.resum);
        resum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                Intent intant = new Intent(Beskonechno.this, Beskonechno.class);
                startActivity(intant); finish();
            }
        });
        final Button esc = (Button)pause.findViewById(R.id.esc);
        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                Intent intant = new Intent(Beskonechno.this, Levels.class);
                startActivity(intant); finish();
            }
        });
//окно паузы - конец

        //кодим впемя - начало
        new Thread(new Runnable() {
            public void run() {
                TextView tame = (TextView)findViewById(R.id.tame);
                while (i > 0){
                    try {Time_p();
                        end_game();
                        Thread.sleep(1000);
                        Time_p();
                        sec_map += 1;
                        if (sec_map % 10 == 0){
                            speed -= 35;
                            if (speed <= 100){
                                speed = 100;
                            }
                            time_sleep_bit -= 30;
                            if (time_sleep_bit <= 100){
                                time_sleep_bit = 100;
                            }
                        }
                        if (sec_map == 59) {
                            sec_map = 0;
                            min_map += 1;
                            speed_hp -= 25;
                            if (speed_hp <= 40){
                                speed_hp = 40;
                            }
                        }
                        if (sec_map < 10){
                            vrem = (min_map + ":0" + sec_map);
                        }
                        else {
                            vrem = (min_map + ":" + sec_map);
                        }

                        tame.setText(vrem);
                    } catch (Exception e) {}
                }


            }
        }).start();

        // типо тут кнопка - хп
        i = progress_hp.getProgress();
        new Thread(new Runnable() {
            public void run() {
                while (i > 0){
                    if (i + 20 >= 159) {
                        try {
                            i -= 15;
                        } catch (Exception e) {}
                    }
                    Time_p();
                    i -= 1;
                    progress_hp.setProgress(i);
                    try {Thread.sleep(speed_hp);
                    } catch (Exception e) {}
                }
                try {
                    player.stop();
                    end_game();
                    gone = 1;
                    Intent intant = new Intent(Beskonechno.this, FinichGameInfity.class);
                    int hh2 = ochki;
                    String hh = String.valueOf(ochki);
                    String gr = String.valueOf(min_map);
                    String gr1 = String.valueOf(sec_map);
                    intant.putExtra("OchkiInfi1", hh2);
                    intant.putExtra("OchkiInfi", hh);
                    intant.putExtra("Vrem1", gr);
                    intant.putExtra("Vrem2", gr1);

                    startActivity(intant);
                    finish();
                }catch (Exception e){}
            }
        }).start();
        // конец кнопка - хп


        final LinearLayout[] pStoroni = {pLeft, pCenter, pRight};
        final LinearLayout[] vStoroni = {vLeft, vCenter, vRight};
        final LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        param.gravity = Gravity.CENTER_HORIZONTAL;
        final LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        param.gravity = Gravity.CENTER_HORIZONTAL;
        final int[] bit_or_slaider = {0, 1};
        final int[] yui = {0, 1};
        final int[] iuy = {0, 1, 2};
        final ImageButton slaider = new ImageButton(Beskonechno.this);
        slaider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_slaider(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });
        final ImageButton bit = new ImageButton(Beskonechno.this);
        bit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chetchik_combo();
                Harak_biti(v);
                progress_hp.setProgress(i);
                Chetchik_ochkov();
                Chetchik_combo();
            }
        });
        final int[] what_ellement = {0};
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i > 0) {
                    int sett = random.nextInt(bit_or_slaider.length);
                    what_ellement[0] = bit_or_slaider[sett];
                    if (what_ellement[0] == 0) {
                        poosk = 1;
                        crtslaider(progress_hp, pStoroni, vStoroni, slaider, yui, iuy, param);
                    }
                    if (what_ellement[0] == 1) {
                        poosk = 1;
                        crtbit(progress_hp, pStoroni, vStoroni, slaider, yui, iuy, param1);
                    }
                    while (poosk == 1){
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){}
                    }
                }
            }
        }).start();

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
            Intent intant = new Intent(Beskonechno.this, Levels.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}
