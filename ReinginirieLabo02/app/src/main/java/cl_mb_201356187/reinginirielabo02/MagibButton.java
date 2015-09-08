package cl_mb_201356187.reinginirielabo02;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;
import android.os.Handler;
import android.widget.Toast;


public class MagibButton extends AppCompatActivity {

    private Random rand = new Random();
    private LinearLayout PrincLL;
    private int LevelButton = 10;
    private TextView NbButRestant;
    private Button ButtonDeJeux;
    private Handler TimerHandler = new Handler();
    private int second = 10;
    private boolean FlagTimer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magib_button);

        PrincLL = (LinearLayout)findViewById(R.id.PrincipalLayyout);
        NbButRestant = (TextView)findViewById(R.id.NbBouttonRestant);
        NbButRestant.setText(LevelButton + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_magib_button, menu);

        return true;
    }

    public void Jeux(View V)
    {
        if(ButtonDeJeux!=null)
        ButtonDeJeux.setVisibility(View.INVISIBLE);

        LinearLayout SecondLL = (LinearLayout)PrincLL.getChildAt(rand.nextInt(4)+1);
        ButtonDeJeux = (Button)SecondLL.getChildAt(rand.nextInt(3));
        ButtonDeJeux.setVisibility(View.VISIBLE);
        ButtonDeJeux.setBackgroundColor(Color.RED);
        LevelButton--;
        NbButRestant.setText(LevelButton + "");

        if(LevelButton==0)
        {
            FlagTimer= false;
            LevelButton = 10;
            PrincLL.setBackgroundColor(Color.GREEN);
            ButtonDeJeux.setVisibility(View.INVISIBLE);
        }
    }
    public void Start(View V)
    {
        FlagTimer = true;
        second = 10;
        LevelButton =  10;
        Jeux(V);
        TimerRun.run();

    }
    Runnable TimerRun = new Runnable() {
        @Override
        public void run() {
            if (second != 0 && FlagTimer) {
                second--;
                TimerHandler.postDelayed(TimerRun, 1000);
            } else {
                Toast.makeText(getBaseContext(),
                        "GAME OVER",
                        Toast.LENGTH_SHORT).show();
                PrincLL.setBackgroundColor(Color.GRAY);
                LevelButton = 10;
                ButtonDeJeux.setVisibility(View.INVISIBLE);
                NbButRestant.setText(LevelButton + "");

            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
