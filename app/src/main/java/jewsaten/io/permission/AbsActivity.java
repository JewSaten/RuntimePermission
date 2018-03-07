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

    public void checkPermission(Context context, int requestCode, String rationale, String[] perms, PermissionsCallback callback) {
        mCallback = callback;
        if (RuntimePermission.hasPermissions(context, perms)) {
            if (mCallback != null) mCallback.onSuccess(context);
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
        RuntimePermission.somePermissionPermanentlyDenied(this, "提示", 0, 0, perms);
    }

    @Override
    public void onPermissionsPossessed(Context context) {
        if (mCallback != null) mCallback.onSuccess(context);
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
