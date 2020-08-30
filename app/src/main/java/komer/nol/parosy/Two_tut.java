package komer.nol.parosy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Two_tut extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_tur_text);
        Button bt = (Button)findViewById(R.id.two_t);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intant = new Intent(Two_tut.this, Tutorial.class);
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
            Intent intant = new Intent(Two_tut.this, Levels.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}
