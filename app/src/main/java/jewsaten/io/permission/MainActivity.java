package jewsaten.io.permission;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission(this, 0, "test", new String[]{Manifest.permission.CAMERA}, new PermissionsCallback() {
            @Override
            public void onSuccess(Context context) {
                
            }
        });
    }

}
