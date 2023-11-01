package tdc.edu.player2023.player;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import tdc.edu.player2023.R;

//cac imgv bao = view = linear => extend linear
public class Player extends LinearLayout {
    //array ImageView.
    private ViewGroup group;
    //Uy quyen B2:Listener variable Definitions.
    private OnPlayerListener playerListener;
    //Properties.
    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
//            change state of btn.
            if (view.isSelected()) {
                view.setSelected(false);
            } else {
                view.setSelected(true);
                for (int i = 0; i < group.getChildCount(); i++) {
                    if (view.getId() != group.getChildAt(i).getId()) {
                        group.getChildAt(i).setSelected(false);
                    }
                }
            }

            //B3:Event processing.
            if (playerListener != null) {
                //Event processing.
                int id = view.getId();
                if (id == R.id.img_ic_next) {
                    playerListener.next(view.isSelected());
                } else if (id == R.id.img_ic_pause) {
                    playerListener.pause(view.isSelected());
                } else if (id == R.id.img_ic_play) {
                    playerListener.play(view.isSelected());
                } else if (id == R.id.img_ic_stop) {
                    playerListener.stop(view.isSelected());
                } else if (id == R.id.img_ic_prev) {
                    playerListener.prev(view.isSelected());
                }
            } else {
                //Notification to User.
                alert();
            }
        }
    };


    public void alert() {
        AlertDialog.Builder a = new AlertDialog.Builder(getContext());
        a.setTitle("WE DONT NO ANYMORE");
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


    //    Constructors
    public Player(Context context) {
        super(context);
        Init(context);
    }

    public Player(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public Player(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }

    public Player(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Init(context);
    }

    //Initializaion => day la 1 ham rieng phai de ham nay de trong cac contructer de khoi tao
    private void Init(Context context) {
        inflate(context, R.layout.player_layout, this);
        //lay tat ca cac con trong view
        group = (ViewGroup) getChildAt(0);
        //Anh xa
        ImageView prev = findViewById(R.id.img_ic_prev);
        ImageView next = findViewById(R.id.img_ic_next);
        ImageView pause = findViewById(R.id.img_ic_pause);
        ImageView stop = findViewById(R.id.img_ic_stop);
        ImageView play = findViewById(R.id.img_ic_play);
        //Them vao ham onClick
        prev.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);
        pause.setOnClickListener(onClickListener);
        stop.setOnClickListener(onClickListener);
        play.setOnClickListener(onClickListener);
    }

    //Uy quyen
    //B1: Interface Definition
    public interface OnPlayerListener {
        public void prev(boolean active);

        public void next(boolean active);

        public void play(boolean active);

        public void stop(boolean active);

        public void pause(boolean active);
    }

    //B4: Setter definitions
    public void setPlayerListener(OnPlayerListener playerListener) {
        this.playerListener = playerListener;
    }

}
