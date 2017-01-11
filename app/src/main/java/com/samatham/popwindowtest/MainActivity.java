package com.samatham.popwindowtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    TooltipWindow tipWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipWindow = new TooltipWindow(MainActivity.this);
    }

    @Override
    public void onClick(View anchor) {
        if (!tipWindow.isTooltipShown())
            tipWindow.showToolTip(anchor);
    }

    @Override
    protected void onDestroy() {
        if (tipWindow != null && tipWindow.isTooltipShown())
            tipWindow.dismissTooltip();
        super.onDestroy();
    }

    public void dispPopupStack(View view) {
        CharSequence colors[] = new CharSequence[] {"Measure", "Rename", "Compare", "Delete", "Mole was removed", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modify Mole");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on colors[which]
                if (which == 3){
                    Toast.makeText(MainActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.show();
    }
}