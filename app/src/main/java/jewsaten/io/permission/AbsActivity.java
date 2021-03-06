package jewsaten.io.permission;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import jewsaten.io.library.RuntimePermission;


/**
 * Created by Administrator on 2018/3/7.
 */

public class AbsActivity extends AppCompatActivity implements RuntimePermission.PermissionsResultCallback {

    private PermissionsCallback mCallback;

    public void checkPermission(int requestCode, String rationale, String[] perms, PermissionsCallback callback) {
        mCallback = callback;
        if (RuntimePermission.hasPermissions(this, perms)) {
            if (mCallback != null) mCallback.onSuccess(this);
        } else {
            RuntimePermission.requestPermissions(this, rationale,
                    requestCode, perms);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        RuntimePermission.somePermissionPermanentlyDenied(this, getString(R.string.rationale_ask_again),
                R.string.setting, R.string.cancel, perms);
    }

    @Override
    public void onPermissionsPossessed() {
        if (mCallback != null) mCallback.onSuccess(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        RuntimePermission.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public interface PermissionsCallback {
        void onSuccess(Context context);
    }
}
