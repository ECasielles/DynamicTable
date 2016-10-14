package com.mercacortex.dynamictable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DynamicTable_Activity extends AppCompatActivity {

    private TableLayout mTblHead, mTblBody;
    private TableRow.LayoutParams mTbrLayoutId, mTbrLayoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_table_);
        mTblBody = (TableLayout) findViewById(R.id.tblBody);
        mTblHead = (TableLayout) findViewById(R.id.tblHead);

        // 100 es el tamaño por defecto en dp que le damos
        // Queremos que el nombre se expanda y no el id
        mTbrLayoutId = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT);
        // Márgenes mínimos para casi cualquier dispositivo
        mTbrLayoutId.setMargins(0,10,0,10);
        mTbrLayoutName = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);

        createHeader();
        createBody();
    }

    private void createHeader() {
        TableRow mTbrHead = new TableRow(this);

        // Ponemos el texto
        TextView mTxvId = new TextView(this);
        mTxvId.setText(R.string.txvId);
        mTxvId.setLayoutParams(mTbrLayoutId);
        mTbrHead.addView(mTxvId);

        TextView mTxvName = new TextView(this);
        mTxvName.setText(R.string.txvName);
        mTxvName.setLayoutParams(mTbrLayoutName);
        mTbrHead.addView(mTxvName);

        // Metemos la fila de la tabla en la plantilla
        mTblHead.addView(mTbrHead);
    }

    private void createBody() {
        TableRow mTbrBody;

        // Ponemos el texto
        TextView mTxvId = new TextView(this);
        TextView mTxvName = new TextView(this);

        String[] mNameList = getResources().getStringArray(R.array.nameList);

        for (int i = 0; i < mNameList.length; i++){
            mTbrBody = new TableRow(this);
        }
        // Terminar
    }


}
