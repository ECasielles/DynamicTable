package com.mercacortex.dynamictable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * @author ECasielles
 * @version 1.0
 * Shows how to create components at runtime
 * Resources used:
 *  -LayoutParams
 *  -Shape
 *  -Color
 *  -String-array
 */
public class DynamicTable_Activity extends AppCompatActivity {

    private TableLayout mTblHead, mTblBody;
    private TableRow.LayoutParams mTbrLayoutId, mTbrLayoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table_);
        mTblHead = (TableLayout) findViewById(R.id.tblHead);
        mTblBody = (TableLayout) findViewById(R.id.tblBody);

        // 100 es el ancho por defecto en dp que le damos al id
        // Queremos que el nombre se expanda y no el id
        // Márgenes mínimos para casi cualquier dispositivo
        mTbrLayoutId = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT);
        mTbrLayoutId.setMargins(0,10,0,10);
        mTbrLayoutName = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        mTbrLayoutName.setMargins(0,10,0,10);

        createHeader();
        createBody();
    }

    private void createHeader() {
        TableRow mTbrHead = new TableRow(this);

        // Ponemos el texto
        TextView mTxvId = new TextView(this);
        mTxvId.setText(R.string.txvId);
        mTxvId.setLayoutParams(mTbrLayoutId);
        mTxvId.setBackgroundResource(R.drawable.shapehead);
        mTbrHead.addView(mTxvId);

        TextView mTxvName = new TextView(this);
        mTxvName.setText(R.string.txvName);
        mTxvName.setLayoutParams(mTbrLayoutName);
        mTxvName.setBackgroundResource(R.drawable.shapehead);
        mTbrHead.addView(mTxvName);

        // Metemos la fila de la tabla en la plantilla
        mTblHead.addView(mTbrHead);
    }

    private void createBody() {
        TableRow mTbrBody;

        // Ponemos el texto
        TextView mTxvId, mTxvName;

        String[] mNameList = getResources().getStringArray(R.array.nameList);

        for (int i = 0; i < mNameList.length; i++){

            // Lleno el texto ID
            mTxvId = new TextView(this);
            mTxvId.setText(" " + String.valueOf(i + 1) + " ");
            mTxvId.setLayoutParams(mTbrLayoutId);

            // Lleno el texto NAME
            mTxvName = new TextView(this);
            mTxvName.setText(mNameList[i]);
            mTxvName.setLayoutParams(mTbrLayoutName);

            // Le damos shape
            mTxvId.setBackgroundResource(R.drawable.shapebody);
            mTxvName.setBackgroundResource(R.drawable.shapebody);

            // Creo la fila
            mTbrBody = new TableRow(this);

            mTbrBody.addView(mTxvId);
            mTbrBody.addView(mTxvName);

            // Añado la fila a la tabla
            mTblBody.addView(mTbrBody);
        }
    }
}
