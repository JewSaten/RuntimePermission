package jewsaten.io.permission;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AbsActivity {
    private static final String[] CAMERA = {Manifest.permission.CAMERA};

    private static final String[] LOCATION_AND_CONTACTS =
            {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS};

    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_LOCATION_CONTACTS_PERM = 124;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.button_camera).setOnClickListener(createOnClickListener());
        findViewById(R.id.button_location_and_contacts).setOnClickListener(createOnClickListener());
    }

    private void checkPermission(int targetId) {
        final boolean camera = R.id.button_camera == targetId;
        checkPermission(camera ? RC_CAMERA_PERM : RC_LOCATION_CONTACTS_PERM, getString(camera ? R.string.rationale_camera : R.string.rationale_location_contacts), camera ? CAMERA : LOCATION_AND_CONTACTS, new PermissionsCallback() {
            @Override
            public void onSuccess(Context context) {
                Toast.makeText(context, camera ? "TODO: Camera things" : "TODO: Location and Contacts things", Toast.LENGTH_LONG).show();
            }
        });
    }

    private View.OnClickListener createOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(view.getId());
            }
        };
    }

}
