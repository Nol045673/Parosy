package komer.nol.parosy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class One_infi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infity_lvl_welc);

        Button bt = (Button)findViewById(R.id.cont_main);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intant = new Intent(One_infi.this, Beskonechno.class);
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
            Intent intant = new Intent(One_infi.this, Levels.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}
