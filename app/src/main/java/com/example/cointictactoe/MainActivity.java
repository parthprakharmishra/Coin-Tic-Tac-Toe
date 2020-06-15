package com.example.cointictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int player=0;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    int winPos[][]={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    boolean b=true;
    public void dropin(View v)
    {
        ImageView iv =(ImageView) v;
        iv.setTranslationY(-1500);

        int cnt=Integer.parseInt(iv.getTag().toString());
        if(gameState[cnt-1]==2 && b==true) {
            gameState[cnt - 1] = player;
        }

        if(player==0) {
            iv.setImageResource(R.drawable.yellow);
            iv.animate().translationYBy(1500).rotation(2700).setDuration(400);
            player=1;
        }
        else
        {
            iv.setImageResource(R.drawable.red);
            iv.animate().translationYBy(1500).rotation(2700).setDuration(400);
            player=0;
        }

        String msg="";


        for(int win[]: winPos)
        {
            if(gameState[win[0]-1]==gameState[win[1]-1] && gameState[win[1]-1]==gameState[win[2]-1] && gameState[win[0]-1]!=2)
            {
                if(player==0)msg="Red";
                else msg="Yellow";
                b=false;


                Button btn = (Button) findViewById(R.id.playAgainBut);
                TextView tv = (TextView) findViewById(R.id.Winner);
                tv.setText(msg+" has won!!");
                btn.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);

            }
        }
    }
public void playAgn(View v) {
    Button btn = (Button) findViewById(R.id.playAgainBut);
    TextView tv = (TextView) findViewById(R.id.Winner);
    btn.setVisibility(View.INVISIBLE);
    tv.setVisibility(View.INVISIBLE);

    GridLayout gl = (GridLayout) findViewById(R.id.gridLayout);

    for (int i = 0; i < gl.getChildCount(); i++) {
        ImageView iv3 = (ImageView) gl.getChildAt(i);
        iv3.setImageDrawable(null);
    }
        for (int j = 0; j < gameState.length; ++j) {
            gameState[j] = 2;
        }
        player = 0;
        b = true;

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
