package jewsaten.io.permission;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.List;

import jewsaten.io.library.RuntimePermission;

/**
 * Created by Administrator on 2018/3/7.
 */

public class AbsFragment extends Fragment implements RuntimePermission.PermissionsResultCallback {

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsPossessed(Context context) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
