package org.zgc.aac.bean.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

/**
 * Author: ZGC
 * Time: 2019/10/20 23:05
 * Description:
 */
//public class User extends BaseObservable {
//    private String name;//名字
//    private String intro;//简介
//
//    @Bindable
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//        notifyPropertyChanged(org.zgc.aac.BR.name);
//    }
//
//    @Bindable
//    public String getIntro() {
//        return intro;
//    }
//
//    public void setIntro(String intro) {
//        this.intro = intro;
//        notifyPropertyChanged(org.zgc.aac.BR.intro);
//    }
//}
public class User {
    private ObservableField<String> name;//名字
    private ObservableField<String> intro;//简介

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<String> getIntro() {
        return intro;
    }

    public void setIntro(ObservableField<String> intro) {
        this.intro = intro;
    }
}
