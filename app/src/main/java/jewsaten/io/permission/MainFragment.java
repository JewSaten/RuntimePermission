package jewsaten.io.permission;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/8.
 */

public class MainFragment extends AbsFragment implements View.OnClickListener {
    private static final String[] SMS = {Manifest.permission.READ_SMS};
    private static final int RC_SMS_PERM = 122;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container);
        root.findViewById(R.id.button_sms).setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        checkPermission(RC_SMS_PERM, getString(R.string.rationale_sms), SMS, new PermissionsCallback() {
            @Override
            public void onSuccess(Context context) {
                Toast.makeText(context, "TODO: SMS things", Toast.LENGTH_LONG).show();
            }
        });
    }
}
