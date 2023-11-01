package tdc.edu.player2023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import tdc.edu.player2023.player.Player;

public class manhinhchinh_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhchinh_layout);
        //Test the player.
        Player player_id = findViewById(R.id.player_id);
        //Tao cac hang dong cua interface
        player_id.setPlayerListener(new Player.OnPlayerListener() {
            @Override
            public void prev(boolean active) {
                if (active) {
                    alert();
                }
            }

            @Override
            public void next(boolean active) {
                Toast.makeText(manhinhchinh_activity.this, "next" + active, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void play(boolean active) {
                Toast.makeText(manhinhchinh_activity.this, "play" + active, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void stop(boolean active) {
                Toast.makeText(manhinhchinh_activity.this, "stop" + active, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void pause(boolean active) {

            }
        });

    }

    public void alert() {
        AlertDialog.Builder a = new AlertDialog.Builder(manhinhchinh_activity.this);
        a.setTitle("THUC HIEN");
        a.setIcon(R.drawable.ic_launcher_foreground);
        a.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        a.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        a.show();
    }

}