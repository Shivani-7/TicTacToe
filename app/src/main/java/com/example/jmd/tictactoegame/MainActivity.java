package com.example.jmd.tictactoegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int active=1;
    int[][] winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
int[] gameState={2,2,2,2,2,2,2,2,2};
public void dropImage(View view)
{
    ImageView counter=(ImageView)view;
    Log.i( "Info","tapped on screen");
    int tappedImage=Integer.parseInt(counter.getTag().toString());
    if (gameState[tappedImage]==2) {
        gameState[tappedImage] = active;
        if (active == 1) {
            counter.setImageResource(R.drawable.cross);
            active = 0;
        } else {
            counter.setImageResource(R.drawable.zero);
            active = 1;
        }
    }
for(int[] game:winning)
{ String msg;
  if(gameState[game[0]]==gameState[game[1]] && gameState[game[1]]==gameState[game[2]] && gameState[game[0]]!=2)
    {
        if(active==0)
        {msg ="Congratulation! Cross player wins";}
        else
        {msg="Congratulation! Zero player wins";}
        TextView nameTextView=(TextView)findViewById(R.id.nameTextView);
        Button playButton=(Button)findViewById(R.id.playButton);
        nameTextView.setText(msg);
        nameTextView.setVisibility(view.VISIBLE);
        playButton.setVisibility(view.VISIBLE);
    }
  else
  {int flag=1;
      for(int i=0;i<gameState.length;i++) {
          if(gameState[i]== 2)
          {flag=1;
              break;
          }
          else

          {
              flag=0;
          }
      }
      if(flag==0)
      {
          String   msg1="This game is a draw";
          TextView nameTextView=(TextView)findViewById(R.id.nameTextView);
          Button playButton=(Button)findViewById(R.id.playButton);
          nameTextView.setText(msg1);
          nameTextView.setVisibility(view.VISIBLE);
          playButton.setVisibility(view.VISIBLE);
      }
  }
}
}
public void playAgain(View view)
{
    TextView nameTextView=(TextView)findViewById(R.id.nameTextView);
    Button playButton=(Button)findViewById(R.id.playButton);
    nameTextView.setVisibility(view.INVISIBLE);
    playButton.setVisibility(view.INVISIBLE);
    GridLayout gridLayout2=(GridLayout)findViewById(R.id.gridLayout2);
    for(int i=0; i<gridLayout2.getChildCount(); i++) {
        ImageView counter = (ImageView)gridLayout2.getChildAt(i);
        counter.setImageDrawable(null);}
        for(int i=0;i<gameState.length;i++) {
             gameState[i] = 2;
        }
         active=1;
        // do stuff with child view
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
