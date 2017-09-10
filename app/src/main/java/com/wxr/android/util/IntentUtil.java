package com.wxr.android.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.util.Log;
import com.wxr.android.BuildConfig;
import java.io.File;

/**
 * Intent工具类
 *
 * @author ran
 */
public class IntentUtil {

    private static final String TAG = IntentUtil.class.getSimpleName();

    /**
     * 跳转界面
     *
     * @param packageContext
     * @param intent
     */
    public static void startActivity(Context packageContext, Intent intent) {
        packageContext.startActivity(intent);
    }

    /**
     * 跳转界面
     *
     * @param packageContext
     * @param cls
     */
    public static void startActivity(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        packageContext.startActivity(intent);
    }

    /**
     * 跳转界面
     *
     * @param packageContext
     * @param cls
     * @param bundle         跳转参数
     */
    public static void startActivity(Context packageContext, Class<?> cls,
                                     Bundle bundle) {
        Intent intent = new Intent(packageContext, cls);
        intent.putExtras(bundle);
        packageContext.startActivity(intent);
    }

    /**
     * 通过Action跳转界面
     *
     * @param packageContext
     * @param action
     */
    public static void startActivity(Context packageContext, String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        if (intent.resolveActivity(packageContext.getPackageManager()) != null) {
            packageContext.startActivity(intent);
        } else {
            Log.e(TAG, "there is no activity can handle this intent: "
                    + intent.getAction().toString());
        }
    }

    /**
     * 含有Data通过Action跳转界面
     *
     * @param packageContext
     * @param action
     * @param data
     */
    public static void startActivity(Context packageContext, String action,
                                     Uri data) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setData(data);
        if (intent.resolveActivity(packageContext.getPackageManager()) != null) {
            packageContext.startActivity(intent);
        } else {
            Log.e(TAG, "there is no activity can handle this intent: "
                    + intent.getAction().toString());
        }
    }

    /**
     * 含有Data和Type通过Action跳转界面
     *
     * @param packageContext
     * @param action
     * @param data
     * @param type
     */
    public static void startActivity(Context packageContext, String action,
                                     Uri data, String type) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setDataAndType(data, type);
        if (intent.resolveActivity(packageContext.getPackageManager()) != null) {
            packageContext.startActivity(intent);
        } else {
            Log.e(TAG, "there is no activity can handle this intent: "
                    + intent.getAction().toString());
        }
    }

    /**
     * 跳转界面(回调)
     * @param activity
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public static void startActivityForResult(Activity activity, Class<?> cls,
                                              Bundle bundle, int requestCode) {
        Intent intent = new Intent(activity, cls);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent,requestCode);
    }

    /**
     * 回调结果到界面
     * @param activity
     * @param cls
     * @param bundle
     * @param resultCode
     */
    public static void setResult(Activity activity, Class<?> cls,
                                 Bundle bundle, int resultCode) {
        Intent intent = new Intent(activity, cls);
        if(bundle != null)
            intent.putExtras(bundle);
        activity.setResult(resultCode,intent);
    }

    /**
     * 直接拨号
     *
     * @param context
     * @param phoneNumber 电话号码
     */
    public static void intentActionCall(Context context, String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                + phoneNumber));
        context.startActivity(callIntent);
    }

    /**
     * 将电话号码传入拨号程序
     *
     * @param context
     * @param phoneNumber 电话号码
     */
    public static void intentActionDial(Context context, String phoneNumber) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
                + phoneNumber));
        context.startActivity(dialIntent);
    }

    /**
     * 调用拨号程序
     *
     * @param context
     */
    public static void intentTouchDialer(Context context) {
        Intent touchDialerIntent = new Intent(
                "com.android.phone.action.TOUCH_DIALER");
        context.startActivity(touchDialerIntent);
    }

    /**
     * 浏览网页
     *
     * @param context
     * @param url     网址
     */
    public static void intentWeb(Context context, String url) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(webIntent);
    }

    /**
     * 查看联系人
     *
     * @param context
     */
    public static void intentListContacts(Context context) {
        Intent contactListIntent = new Intent(
                "com.android.contacts.action.LIST_CONTACTS");
        context.startActivity(contactListIntent);
    }

    /**
     * 发送短信
     *
     * @param context
     * @param phoneNumber 电话号码
     * @param text        短信内容
     */
    public static void intentSendTo(Context context, String phoneNumber,
                                    String text) {
        Uri smsToUri = Uri.parse("smsto:" + phoneNumber);
        Intent mIntent = new Intent(Intent.ACTION_SENDTO,
                smsToUri);
        mIntent.putExtra("sms_body", text);
        context.startActivity(mIntent);
    }

    /**
     * 调用系统的邮件系统
     *
     * @param context
     * @param emailReciver 接收方邮箱
     */
    public static void intentSendEmail(Context context, String[] emailReciver) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("text/plain");
        // 设置邮件默认地址
        email.putExtra(Intent.EXTRA_EMAIL, emailReciver);
        // 调用系统的邮件系统
        context.startActivity(Intent.createChooser(email, "请选择邮件发送软件"));
    }

    /**
     * 显示系统设置主界面
     *
     * @param context
     */
    public static void intentSetting(Context context) {
        String pkg = "com.android.settings";
        String cls = "com.android.settings.Settings";

        ComponentName component = new ComponentName(pkg, cls);
        Intent intent = new Intent();
        intent.setComponent(component);
        context.startActivity(intent);
    }

    /**
     * 显示Wi-Fi设置界面
     *
     * @param context
     */
    public static void intentWifiSetting(Context context) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        context.startActivity(intent);
    }

    /**
     * 显示蓝牙设置界面
     *
     * @param context
     */
    public static void intentBluetooth(Context context) {
        Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        context.startActivity(intent);
    }

    /**
     * 获取文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getViewFileIntent(String filePath) {
        String extraName = null;
        int index = filePath.lastIndexOf('.');
        if (index >= 0)
            extraName = filePath.substring(index);

        if (extraName == null)
            return getUnknowIntent(filePath);
        else if (extraName.equals(".pdf"))
            return getPdfFileViewIntent(filePath);
        else if (extraName.equals(".doc") || extraName.equals(".docx"))
            return getWordFileViewIntent(filePath);
        else if (extraName.equals(".xls"))
            return getExcelFileViewIntent(filePath);
        else if (extraName.equals(".ppt"))
            return getPptFileViewIntent(filePath);
        else if (extraName.equals(".txt"))
            return getTextFileViewIntent(filePath);
        else if (extraName.equals(".jpg") || extraName.equals(".png")
                || extraName.equals(".gif") || extraName.equals(".tif"))
            return getImageFileViewIntent(filePath);
        else if (extraName.equals(".mp3"))
            return getAudioFileViewIntent(filePath);
        else if (extraName.equals(".mp4"))
            return getVideoFileViewIntent(filePath);
        return getUnknowIntent(filePath);
    }

    /**
     * 获取未知文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getUnknowIntent(String filePath) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        File file = new File(filePath);
        intent.setDataAndType(Uri.fromFile(file), "*/*");
        return intent;
    }

    /**
     * 获取html文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getViewHtmlFileIntent(String filePath) {
        Uri uri = Uri.parse(filePath).buildUpon()
                .encodedAuthority("com.android.htmlfileprovider")
                .scheme("content").encodedPath(filePath).build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "text/html");
        return intent;
    }

    /**
     * 获取图片文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getImageFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "image/*");
        return intent;
    }

    /**
     * 获取pdf文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getPdfFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/pdf");
        return intent;
    }

    /**
     * 获取word文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getWordFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/msword");
        return intent;
    }

    /**
     * 获取excel文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getExcelFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/vnd.ms-excel");
        return intent;
    }

    /**
     * 获取ppt文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getPptFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        return intent;
    }

    /**
     * 获取文本文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getTextFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "text/plain");
        return intent;
    }

    /**
     * 获取音频文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getAudioFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }

    /**
     * 获取视频文件intent
     *
     * @param filePath 文件路径
     * @return
     */
    public static Intent getVideoFileViewIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "video/*");
        return intent;
    }

    /**
     * 跳转到应用详细界面
     *
     * @param context
     */
    public static void intentAppDetailSetting(Context context) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        context.startActivity(localIntent);
    }

    /**
     * 打开系统照相机拍照
     *
     * @param requestCode 返回值
     * @param activity    上下文
     * @param fileName    生成的图片文件的路径
     */
    public static void intentTakePhoto(int requestCode, Activity activity, String fileName) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri uri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID +".fileProvider", new File(fileName));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        } else {
            intent.addCategory("android.intent.category.DEFAULT");
            Uri uri = Uri.fromFile(new File(fileName));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 打开系统照相机拍照(可携带数据)
     *
     * @param requestCode 返回值
     * @param activity    上下文
     * @param fileName    生成的图片文件的路径
     * @param bundle    可携带的数据
     */
    public static void intentTakePhoto(int requestCode, Activity activity, String fileName , Bundle bundle) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri uri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID +".fileProvider", new File(fileName));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            intent.putExtras(bundle);
        } else {
            intent.addCategory("android.intent.category.DEFAULT");
            Uri uri = Uri.fromFile(new File(fileName));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 打开系统照相机录像
     *
     * @param requestCode 返回值
     * @param activity    上下文
     * @param fileName    生成的视频文件的路径
     */
    public static void intentTakeVideo(int requestCode, Activity activity, String fileName) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.addCategory("android.intent.category.DEFAULT");
        try {
            Uri uri = Uri.fromFile(new File(fileName));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            activity.startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 安装apk
     *
     * @param context 上下文
     * @param file    APK文件
     */
    public static void intentInstallApk(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID +".fileProvider", file);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    /**
     * 卸载apk
     *
     * @param context     上下文
     * @param packageName 包名
     */
    public static void intentUninstallApk(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        Uri packageURI = Uri.parse("package:" + packageName);
        intent.setData(packageURI);
        context.startActivity(intent);
    }

    /**
     * 获取指定包名的intent
     *
     * @param context     上下文
     * @param packageName 包名
     * @return
     */
    public static Intent getLaunchIntentForPackage(Context context, String packageName) {
        return context.getPackageManager().getLaunchIntentForPackage(packageName);
    }


}
