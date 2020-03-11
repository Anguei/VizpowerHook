package me.lyc8503.vizpowerhook.hook;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

public class ClassListActivityHook extends XC_MethodHook {

    public static final String TAG = "ClassListHook";

    @Override
    protected void beforeHookedMethod(MethodHookParam param) {
        XposedBridge.log(TAG + " 成功 HookVizpower 目标方法: " + param);
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) {
        Context vizContext = ((Activity) param.thisObject).getApplicationContext();
        Toast.makeText(vizContext, "VizpowerHook: 已经 Hook 到无限宝! 模块启动成功.", Toast.LENGTH_LONG).show();
        XposedBridge.log(TAG + " Hook Test 已经完成!");
    }
}
