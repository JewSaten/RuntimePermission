# RuntimePermission
简化版的 [easypermissions](https://github.com/googlesamples/easypermissions)

![截图](/img/image.gif "截图")

## 使用方法

```
 checkPermission(RC_SMS_PERM, getString(R.string.rationale_sms), SMS, new PermissionsCallback() {
            @Override
            public void onSuccess(Context context) { // 6.0以下默认回调此方法，否则只有当全部权限都允许之后才会回调
                Toast.makeText(context, "TODO: SMS things", Toast.LENGTH_LONG).show();
            }
        });
 ```

## 联系

- **Gmail：** satenjew@gmail.com
- **个人博客：** [https://jewsaten.github.io/](https://jewsaten.github.io/)
