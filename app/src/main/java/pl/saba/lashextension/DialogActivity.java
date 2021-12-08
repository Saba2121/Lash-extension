package pl.saba.lashextension;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogActivity extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Information")
                .setMessage("Current day - green                                                                         Holidays - red                 " +
                        "                                                                                Unavailable - grey")
                .setPositiveButton("ok", (dialog, which) -> {
                });

        return builder.create();

    }
}
