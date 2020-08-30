package komer.nol.parosy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class One_tut extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_tur_text);

        final ProgressBar progress_hp = (ProgressBar)findViewById(R.id.hp);
        progress_hp.setMax(160);
        progress_hp.setProgress(160);
        Button bt = (Button)findViewById(R.id.one_t);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intant = new Intent(One_tut.this, Two_tut.class);
                    startActivity(intant);
                    finish();
                } catch (Exception e) {
                }
            }
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    // системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            Intent intant = new Intent(One_tut.this, Levels.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}

