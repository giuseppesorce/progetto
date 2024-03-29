package com.giuseppesorce.progetto.android.debug;


/**
 * @author Giuseppe Sorce copyright Giuseppe Sorce
 */

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Dbg {
    public static String TAG = "progetto";


    public static void p(Object m) {
        try {
           Log.i(Dbg.TAG, m.toString());
        } catch (Exception e) {

        }

    }

    public static void p(String m, Boolean grave) {
        try {
            Log.i(Dbg.TAG, m);
            if (grave) {
               // appendLog(DateApp.getStamp() + ": " + m);
            }
        } catch (Exception e) {

        }

    }


    public static void p(String m, String tag) {

        try {
           Log.i(tag, m);

        } catch (Exception e) {

        }

    }

    public static void p(String m) {

        try {
           Log.i(Dbg.TAG, m);

        } catch (Exception e) {

        }
    }

    public static void p(List m) {
       Log.i(Dbg.TAG, m.toString());

    }

    public static void e(String m, boolean grave) {

        try {
          Log.e(Dbg.TAG, m);
            if (grave) {
                appendLog(DateApp.getStamp() + ": " + m);
            }
        } catch (Exception e) {

        }

    }
    public static void e(String m) {
     Log.e(Dbg.TAG, m);



    }

    public static void appendLog(String text) {

        File folder = new File(Environment.getExternalStorageDirectory() + "/", "camazing/");
          try{
            if(!folder.exists()) {
                folder.mkdir();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        File logFile = new File(folder, "log.txt");


        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Dbg.p("Errore: " + e.getLocalizedMessage());
            }
        } else {
            long kb = logFile.length() / 2024;
             if (kb > 1000) {
                File logFiletorename = new File(folder, "log_old_" + DateApp.getStampFile() + "_.txt");
                logFile.renameTo(logFiletorename);
                try {
                    logFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
