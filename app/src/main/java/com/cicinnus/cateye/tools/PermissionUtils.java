package com.cicinnus.cateye.tools;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.cicinnus.cateye.R;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus on 2017/6/9.
 */

public abstract class PermissionUtils {

    private final RxPermissions rxPermissions;
    private final Activity activity;
    private int permissionNum;
    private boolean firstPermission;


    public PermissionUtils(Activity context, String... permissions) {
        activity = context;
        rxPermissions = new RxPermissions(context);
        getPermission(permissions);
    }

    private void getPermission(final String... permissions) {
        rxPermissions.requestEach(permissions)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(@NonNull Permission permission) throws Exception {
                        if (permission.granted) {
                            permissionNum++;
                            if (permissionNum == permissions.length) {
                                //全部权限通过
                                allGranted();
                            }
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            if (firstPermission) {
                                showRequestPermission(activity, permission.name);
                                firstPermission = false;
                            }
                        } else {
                            // Denied permission with ask never again
                            // Need to go to the settings
                            showSettingDialog(activity, permission.name);
                        }
                    }
                });
    }

    private void showSettingDialog(final Activity activity, String name) {

        String title = "";
        String message = "";
        switch (name) {
            case Manifest.permission.CAMERA:
                title = "请允许拍照权限";
                message = "由于无法获取拍照权限,不能正常运行,请开启权限后再使用activity.getResources().getString(R.string.app_name)\n设置路径:系统设置->"+activity.getResources().getString(R.string.app_name)+"->权限";
                break;
            case Manifest.permission.RECORD_AUDIO:
                title = "请允许录音权限";
                message = "由于无法获取录音权限,不能正常运行,请开启权限后再使用activity.getResources().getString(R.string.app_name)\n设置路径:系统设置->"+activity.getResources().getString(R.string.app_name)+"->权限";
                break;
            case Manifest.permission.ACCESS_COARSE_LOCATION:
                title = "请允许获取位置信息";
                message = "由于无法获取定位权限,不能正常运行,请开启权限后再使用activity.getResources().getString(R.string.app_name)\n设置路径:系统设置->"+activity.getResources().getString(R.string.app_name)+"->权限";
                break;
            case Manifest.permission.ACCESS_FINE_LOCATION:
                title = "请允许获取位置信息";
                message = "由于无法获取定位权限,不能正常运行,请开启权限后再使用activity.getResources().getString(R.string.app_name)\n设置路径:系统设置->"+activity.getResources().getString(R.string.app_name)+"->权限";
                break;
        }

        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        permissionRefused();
                    }
                })
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        JumpPermissionManagement.ApplicationInfo(activity);
                    }
                })
                .setCancelable(true)
                .create();
        dialog.setCanceledOnTouchOutside(false);
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }


    private void showRequestPermission(final Activity activity, final String PermissionName) {
        String title = "";
        String message = "";
        switch (PermissionName) {
            case Manifest.permission.CAMERA:
                title = "请允许拍照权限";
                message = "需要拍摄权限,为您拍摄照片;\n否则您将无法正常使用"+ activity.getResources().getString(R.string.app_name);
                break;
            case Manifest.permission.RECORD_AUDIO:
                title = "请允许录音权限";
                message = "需要录音权限,为您记录会议录音;\n否则您将无法正常使用"+ activity.getResources().getString(R.string.app_name);
                break;
            case Manifest.permission_group.STORAGE:
                title = "请允许获取存储空间";
                message = "我们需要获取存储空间,为您存储个人信息;\n否则您将无法正常使用"+ activity.getResources().getString(R.string.app_name);
                break;
            case Manifest.permission.ACCESS_COARSE_LOCATION:
                title = "请允许获取位置信息";
                message = "需要获取位置信息,为您提供更好的服务;\n否则您将无法正常使用"+ activity.getResources().getString(R.string.app_name);
                break;
            case Manifest.permission.ACCESS_FINE_LOCATION:
                title = "请允许获取位置信息";
                message = "需要获取位置信息,为您提供更好的服务;\n否则您将无法正常使用"+ activity.getResources().getString(R.string.app_name);
                break;
        }
        AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        permissionRefused();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        getPermission();
                    }
                })
                .setCancelable(false)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        if (!alertDialog.isShowing()) {
            alertDialog.show();
        }

    }

    protected abstract void permissionRefused();

    /**
     * 所有权限通过
     */
    protected abstract void allGranted();

}
