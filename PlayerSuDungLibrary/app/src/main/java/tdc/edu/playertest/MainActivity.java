package tdc.edu.playertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import tdc.edu.player2023.player.Player;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player player = findViewById(R.id.player_id_test);
        player.setPlayerListener(new Player.OnPlayerListener() {
            @Override
            public void prev(boolean b) {
                Toast.makeText(MainActivity.this, ""+b, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void next(boolean b) {
            if(b){
                Toast.makeText(MainActivity.this, ""+b, Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void play(boolean b) {
                Toast.makeText(MainActivity.this, ""+b, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void stop(boolean b) {
                Toast.makeText(MainActivity.this, ""+b, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void pause(boolean b) {
                Toast.makeText(MainActivity.this, ""+b, Toast.LENGTH_SHORT).show();

            }
        });
    }
}