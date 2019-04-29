package com.example.question04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] words = new String[6];
    private TextView mShowList;
    private EditText edit;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public MainActivity () {
        this.words[0] = "you";
        this.words[1] = "probably";
        this.words[2] = "despite";
        this.words[3] = "moon";
        this.words[4] = "misspellings";
        this.words[5] = "pale";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowList = (TextView) findViewById(R.id.showList);
        edit = (EditText)findViewById(R.id.wordIn);
    }

    public void searchWord(View view) {
        String word = edit.getText().toString();
        String result = null;
        for (int i = 0; i < this.words.length; i++) {
            if (word.equals(this.words[i])) {
                Log.d("Main Activity", "entrou no if equals");
                    result = this.words[i];
            }
            if (this.isPartiallyPermuted(word, this.words[i])) {
                Log.d("Main Activity", "entrou no if partially permuted");

                result = this.words[i];
            }
            if (this.isTypo(word, this.words[i])) {
                Log.d("Main Activity", "entrou no if typo");

                result = this.words[i];
            }
            if ((this.isPartiallyPermuted(word, this.words[i])) && (this.isTypo(word, this.words[i]))) {
                Log.d("Main Activity", "entrou no if duplo");

                result = null;
            }
        }
        if (result == null) {
            result = "Not found";
        }
        if(mShowList != null) {
            mShowList.setText(result);
        }


    }

    private boolean isPartiallyPermuted(String astr, String bstr) {
        char[] astrArray = astr.toCharArray();
        char[] bstrArray = bstr.toCharArray();
        boolean typo = false;
        boolean partialPermutation = false;
        if(astrArray[0] == bstrArray[0] && astrArray.length == bstrArray.length) {
            if (astrArray.length > 3) {
                int count = 0;
                int eq = 0;
                char[] auxl = bstrArray.clone();
                for (int x = 0; x < astrArray.length; x++) {
                    for (int y = 0; y < auxl.length; y++) {
                        if (astrArray[x] == auxl[y] && x != y) {
                            char aux = auxl[x];
                            auxl[x] = auxl[y];
                            auxl[y] = aux;
                        }
                    }
                }
                for (int z = 0; z < astrArray.length; z++) {
                    if (astrArray[z] != auxl[z]) {
                        typo = true;
                    }
                }
                if (typo != true) {
                    for (int a = 0; a < astrArray.length; a++) {
                        for (int b = a; b < bstrArray.length; b++) {
                            if ((astrArray[a] == astrArray[b]) && (a != b)) {
                                eq += 1;
                            }
                        }
                    }
                    for (int i = 0; i < astrArray.length; i++) {
                        for (int j = 0; j < bstrArray.length; j++) {
                            if ((astrArray[i] == bstrArray[j]) && (i != j)) {
                                count += 1;
                            }
                        }
                    }
                    count = count - (eq * 2);
                    if ((count > 0) && (count < ((astrArray.length * 2) / 3))) {
                        partialPermutation = true;
                    }
                }
            } else {
                if (astrArray[1] == bstrArray[2]) {
                    partialPermutation = true;
                }
            }
        }
            return partialPermutation;
    }

    private boolean isTypo(String astr, String bstr) {
        char[] astrArray = astr.toCharArray();
        char[] bstrArray = bstr.toCharArray();
        int lenDiff = astr.length() - bstr.length();
        boolean typo = false;
        if((lenDiff == 0) || (lenDiff == 1) || (lenDiff == -1)) {
            int c = 0;
            if (lenDiff == 0) {
                for (int i = 0; i < astrArray.length; i++) {
                    if (astrArray[i] != bstrArray[i]) {
                        c += 1;
                    }
                }
                if (c == 1) {
                    typo = true;
                }
            }
            if (lenDiff == 1) {
                for (int i = 0; i < bstrArray.length; i++) {
                    if (bstrArray[i] != astrArray[i]) {
                        if (bstrArray[i] != astrArray[i + 1]) {
                            c += 1;
                        }
                    }
                }
                if (c > 0) {
                    typo = false;
                } else {
                    typo = true;
                }
            }
            if (lenDiff == -1) {
                for (int i = 0; i < astrArray.length; i++) {
                    if (astrArray[i] != bstrArray[i]) {
                        if (astrArray[i] != bstrArray[i + 1]) {
                            c += 1;
                        }
                    }
                }
                if (c > 0) {
                    typo = false;
                } else {
                    typo = true;
                }
            }
        }
        return typo;
    }
}
