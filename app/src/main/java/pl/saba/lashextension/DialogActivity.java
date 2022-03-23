package pl.saba.lashextension;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class DialogActivity extends DialogFragment {

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Information")
                .setMessage("Current day - green\nHolidays - red\nUnavailable - grey")
                .setPositiveButton("ok", (dialog, which) -> {
                });

        return builder.create();

    }
}
