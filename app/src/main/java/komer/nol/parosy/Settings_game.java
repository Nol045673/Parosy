package komer.nol.parosy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings_game extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private final String Settings = "settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records_ochki);


        Button back = (Button)findViewById(R.id.vihod2);
        TextView one = (TextView)findViewById(R.id.one_p);
        TextView two = (TextView)findViewById(R.id.two_p);
        TextView three = (TextView)findViewById(R.id.tree_p);
        TextView four = (TextView)findViewById(R.id.four_p);
        TextView five = (TextView)findViewById(R.id.five_p);

        Intent intent = getIntent();
        int[] records = intent.getIntArrayExtra("ArrRec");

        for (int i = 0; i < 5; i++) {
            assert records != null;
            records[i] = sharedPreferences.getInt(Settings + i, records[i]);
        }

        one.setText(String.valueOf(records[0]));
        two.setText(String.valueOf(records[1]));
        three.setText(String.valueOf(records[2]));
        four.setText(String.valueOf(records[3]));
        five.setText(String.valueOf(records[4]));


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intant = new Intent(Settings_game.this, Levels.class);
                startActivity(intant); finish();
            }
        });
    }
    // системная кнопка назад
    @Override
    public void onBackPressed(){
        try{
            Intent intant = new Intent(Settings_game.this, Levels.class);
            startActivity(intant); finish();
        }catch (Exception e){}
    }
}
