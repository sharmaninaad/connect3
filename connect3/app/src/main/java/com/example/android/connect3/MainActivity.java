package com.example.android.connect3;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    LinearLayout layout=(LinearLayout)findViewById(R.id.baap);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout.setVisibility(View.INVISIBLE);



    }
    public int gamedata[]= new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
    int winning[][]=new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int active=0;

    public void box_click(View view) {
        ImageView img = (ImageView) view;


        int tapped=Integer.parseInt(img.getTag().toString());
        if(gamedata[tapped]==2) {
            gamedata[tapped] = active;
            if (active == 0) {

                img.setImageResource(R.drawable.red);
                img.setTranslationY(-1000f);
                img.animate().translationYBy(1000f).setDuration(500).rotation(90);
                active = 1;

            }
            else {

                img.setImageResource(R.drawable.yellow);
                img.setTranslationY(-1000f);
                img.animate().translationYBy(1000f).setDuration(500).rotation(90);
                active = 0;
            }

            for (int i = 0; i < 8; i++) {
                if (gamedata[winning[i][0]] == gamedata[winning[i][1]] && gamedata[winning[i][1]] == gamedata[winning[i][2]] && gamedata[winning[i][0]] != 2) {
                    layout.setVisibility(View.VISIBLE);
                    layout.animate().translationYBy(1000f).setDuration(500);
                    TextView res=(TextView)findViewById(R.id.result);
                    if (gamedata[winning[i][0]] == 0) {

                        Toast.makeText(MainActivity.this, "player red won", Toast.LENGTH_LONG).show();
                        res.setText("Player Red Won");
                        for(i=0;i<9;i++){
                            gamedata[i]=3;
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "player yellow won", Toast.LENGTH_LONG).show();
                        res.setText("Player Yellow Won");
                        for (i = 0; i < 9; i++) {
                            gamedata[i] = 3;
                        }
                    }
                    break;
                }
                else
                    continue;

            }
        }
    }
    public void reset()
    {

        GridView grid=(GridView)findViewById(R.id.grids);
        int num=grid.getChildCount();
        active=0;
        for (int i = 0; i < 9; i++) {
            gamedata[i] = 2;
        }
        for(int i=0;i<num;i++)
        {
            ImageView pic=(ImageView)grid.getChildAt(i);
            pic.setImageResource(0);

        }

    }


}
