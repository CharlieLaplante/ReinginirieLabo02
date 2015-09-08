package cl_mb_201356187.reinginirielabo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MagibButton extends AppCompatActivity {

    Random rand = new Random();
    LinearLayout PrincLL;
    int Level1Button = 10;
    TextView NbButRestant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magib_button);

        PrincLL = (LinearLayout)findViewById(R.id.PrincipalLayyout);
        NbButRestant = (TextView)findViewById(R.id.NbBouttonRestant);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_magib_button, menu);


        return true;
    }

    public void Jeux()
    {
        LinearLayout SecondLL = (LinearLayout)PrincLL.getChildAt(rand.nextInt(1 - 4 + 1) + 1);
        Button Button = (Button)SecondLL.getChildAt(rand.nextInt(3));
        Button.setVisibility(View.VISIBLE);
        Button.setBackgroundColor(16711680);
        Level1Button--;
        NbButRestant.setText(Level1Button + "");
    }
    public void Start()
    {
        NbButRestant.setText(Level1Button + "");
        Jeux();
    }
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
