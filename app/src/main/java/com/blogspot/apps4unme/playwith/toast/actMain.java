package com.blogspot.apps4unme.playwith.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class actMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Show Toast on Different Positions.
        final int TOAST_NUM= 8;
        String [] msg = {"BottomCenter", "BottomLeft",
                            "CenterLeft", "TopLeft",
                            "TopCenter", "TopRight",
                            "CenterRight", "BottomRight"};
        int [] pos = { Gravity.BOTTOM|Gravity.CENTER, Gravity.BOTTOM|Gravity.LEFT,
                Gravity.CENTER_VERTICAL|Gravity.LEFT, Gravity.TOP|Gravity.LEFT,
                Gravity.CENTER|Gravity.TOP, Gravity.TOP|Gravity.RIGHT,
                Gravity.CENTER_VERTICAL|Gravity.RIGHT, Gravity.BOTTOM|Gravity.RIGHT};
        Toast[] toasts = new Toast[TOAST_NUM];

        for (int i = 0; i < TOAST_NUM; i++) {
            toasts[i] = Toast.makeText(this, msg[i], Toast.LENGTH_SHORT);
            toasts[i].setGravity(pos[i], 0, 0);
            toasts[i].show();
        }

        // Default location
        Toast.makeText(this, "Toast Default", Toast.LENGTH_SHORT).show();

        // Customize Toast View.
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        ((TextView) layout.findViewById(R.id.text)).setText("This is a custom toast");
        ((ImageView) layout.findViewById(R.id.img)).setImageResource(android.R.drawable.btn_star_big_on);
        Toast toast4 = new Toast(getApplicationContext());
        toast4.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast4.setDuration(Toast.LENGTH_SHORT);
        toast4.setView(layout);
        toast4.show();

        Toast.makeText(this, "The End", Toast.LENGTH_LONG).show();
    }
}
